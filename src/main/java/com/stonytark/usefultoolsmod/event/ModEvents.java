package com.stonytark.usefultoolsmod.event;

import com.stonytark.usefultoolsmod.Config;
import com.stonytark.usefultoolsmod.entity.custom.GhostEntity;
import com.stonytark.usefultoolsmod.item.ModArmorMaterials;
import com.stonytark.usefultoolsmod.item.ModItems;
import com.stonytark.usefultoolsmod.item.custom.CoalArmorItem;
import com.stonytark.usefultoolsmod.item.custom.CoalBurningHelper;
import com.stonytark.usefultoolsmod.item.custom.EctoplasmInfusionHelper;
import com.stonytark.usefultoolsmod.trigger.ModTriggers;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber
public class ModEvents {

    // -----------------------------------------------------------------------
    // Coal burning state
    // -----------------------------------------------------------------------

    /** Players currently holding at least one burning coal item (tool or armor in hand). */
    private static final Set<UUID> COAL_TOOL_BURNING  = new HashSet<>();
    /** Players whose worn coal armor is burning. */
    private static final Set<UUID> COAL_ARMOR_BURNING = new HashSet<>();

    /**
     * Burning coal items (tools OR armor) that are lying on the ground as item entities.
     * Key = entity UUID (globally unique per session), Value = dimension they are in.
     * Using UUIDs + dimension avoids integer-ID collisions when the same int ID is
     * re-used across dimensions within a server session.
     */
    private static final Map<UUID, ResourceKey<Level>> BURNING_DROPPED_ITEMS = new HashMap<>();

    // -----------------------------------------------------------------------
    // Per-player tick
    // -----------------------------------------------------------------------

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        if (player == null || player.isSpectator()) return;

        if (Config.opToolEffectsEnabled) {
            handleOpToolEffects(player, player.getMainHandItem());
            handleOpToolEffects(player, player.getOffhandItem());
        }
        if (Config.opArmorEffectsEnabled && !player.level().isClientSide) {
            spawnArmorAuraIfOp(player);
        }

        if (!player.level().isClientSide) {
            handleCoalToolBurning(player);
            handleCoalArmorBurning(player);
            handleSnowIceMelt(player);
            handleIceFireProtection(player);
            handleSprismWaterEffects(player);
            handleFniBootsFire(player);
            handleFniArmorBonus(player);
        }
    }

    // -----------------------------------------------------------------------
    // Level tick — processes burning coal items lying on the ground
    // -----------------------------------------------------------------------

    @SubscribeEvent
    public static void onLevelTick(TickEvent.LevelTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (!(event.level instanceof ServerLevel serverLevel)) return;
        if (BURNING_DROPPED_ITEMS.isEmpty()) return;

        ResourceKey<Level> thisDim = serverLevel.dimension();

        BURNING_DROPPED_ITEMS.entrySet().removeIf(entry -> {
            // Only process entries that belong to this dimension this tick
            if (!entry.getValue().equals(thisDim)) return false;

            var entity = serverLevel.getEntity(entry.getKey());
            if (entity == null) return false;          // chunk unloaded — keep tracking
            if (!(entity instanceof ItemEntity itemEntity) || !itemEntity.isAlive()) return true;

            ItemStack item = itemEntity.getItem();
            if (!(isCoalTool(item) || isCoalArmor(item)) || !CoalBurningHelper.isBurning(item)) return true;

            // Water extinguishes the item
            if (itemEntity.isInWater()) {
                CoalBurningHelper.setBurning(item, false);
                return true;
            }

            // Durability drain once per second
            if (serverLevel.getGameTime() % 20 == 0) {
                int newDmg = item.getDamageValue() + 2;
                if (newDmg >= item.getMaxDamage()) {
                    itemEntity.discard();
                    return true;
                }
                item.setDamageValue(newDmg);
            }

            // Smoke particles from the burning item on the ground
            if (serverLevel.getGameTime() % 5 == 0) {
                serverLevel.sendParticles(ParticleTypes.SMOKE,
                        itemEntity.getX(), itemEntity.getY() + 0.3, itemEntity.getZ(),
                        1, 0.1, 0.1, 0.1, 0.01);
            }

            return false;
        });
    }

    // -----------------------------------------------------------------------
    // Detect burning coal items entering the world (drops, throws, chunk loads)
    // -----------------------------------------------------------------------

    @SubscribeEvent
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
        if (event.getLevel().isClientSide()) return;
        if (!(event.getEntity() instanceof ItemEntity itemEntity)) return;
        if (!(event.getLevel() instanceof Level level)) return;

        ItemStack item = itemEntity.getItem();
        if ((isCoalTool(item) || isCoalArmor(item)) && CoalBurningHelper.isBurning(item)) {
            BURNING_DROPPED_ITEMS.put(itemEntity.getUUID(), level.dimension());
        }
    }

    // -----------------------------------------------------------------------
    // Player death — handle burning coal armor/tool on death
    // -----------------------------------------------------------------------

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (player.level().isClientSide()) return;

        UUID uuid = player.getUUID();
        boolean keepInventory = player.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY);

        // --- Burning armor ---
        if (COAL_ARMOR_BURNING.contains(uuid)) {
            COAL_ARMOR_BURNING.remove(uuid);
            if (keepInventory) {
                // Items stay in inventory — clear burning so they don't auto-hurt on respawn
                clearArmorBurning(player);
            }
            // If !keepInventory: items drop as ItemEntities with coal_burning=true intact.
            // onEntityJoinLevel will pick them up and add them to BURNING_DROPPED_ITEMS.
        }

        // --- Burning tool ---
        if (COAL_TOOL_BURNING.contains(uuid)) {
            COAL_TOOL_BURNING.remove(uuid);
            if (keepInventory) {
                // Clear burning so re-held tool doesn't auto-hurt on respawn
                clearBurningIfCoalTool(player.getMainHandItem());
                clearBurningIfCoalTool(player.getOffhandItem());
            }
            // If !keepInventory: tool drops as entity with coal_burning=true, tracked below
        }
    }

    // -----------------------------------------------------------------------
    // OP Tool effects
    // -----------------------------------------------------------------------

    private static void handleOpToolEffects(Player player, ItemStack held) {
        if (held.isEmpty()) return;
        boolean hasEffect = false;

        if (held.is(ModItems.OVERPOWER_SWORD.get())) {
            hasEffect = true;
            applyEffects(player,
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST,      10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED,    10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.JUMP,              10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 3, false, false, false));
        } else if (held.is(ModItems.OVERPOWER_PICKAXE.get())) {
            hasEffect = true;
            applyEffects(player,
                    new MobEffectInstance(MobEffects.DIG_SPEED,    10, 3,  false, false, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 3,  false, false, false),
                    new MobEffectInstance(MobEffects.JUMP,         10, 10, false, false, false));
        } else if (held.is(ModItems.OVERPOWER_SHOVEL.get())) {
            hasEffect = true;
            applyEffects(player,
                    new MobEffectInstance(MobEffects.DIG_SPEED,    10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 1, false, false, false),
                    new MobEffectInstance(MobEffects.JUMP,         10, 5, false, false, false));
        } else if (held.is(ModItems.OVERPOWER_AXE.get())) {
            hasEffect = true;
            applyEffects(player,
                    new MobEffectInstance(MobEffects.REGENERATION, 10, 3,  false, false, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 3,  false, false, false),
                    new MobEffectInstance(MobEffects.JUMP,         10, 10, false, false, false));
        }

        if (hasEffect && player.level().isClientSide) {
            spawnAuraParticles(player.level(), player);
        }
    }

    private static void spawnArmorAuraIfOp(Player player) {
        for (ItemStack armorStack : player.getArmorSlots()) {
            if (armorStack.getItem() instanceof ArmorItem armor) {
                if (ModArmorMaterials.OVERPOWER_ARMOR_MATERIAL.is(armor.getMaterial())
                        && player.level().isClientSide) {
                    spawnAuraParticles(player.level(), player);
                }
            }
        }
    }

    // -----------------------------------------------------------------------
    // Coal tool burning (held by a player)
    // -----------------------------------------------------------------------

    private static void handleCoalToolBurning(Player player) {
        if (!Config.coalFireEffectsEnabled) return;

        UUID uuid      = player.getUUID();
        ItemStack main = player.getMainHandItem();
        ItemStack off  = player.getOffhandItem();

        // Coal armor held in hand behaves identically to a burning coal tool
        boolean mainIsCoal = isCoalTool(main) || isCoalArmor(main);
        boolean offIsCoal  = isCoalTool(off)  || isCoalArmor(off);
        boolean mainBurning = mainIsCoal && CoalBurningHelper.isBurning(main);
        boolean offBurning  = offIsCoal  && CoalBurningHelper.isBurning(off);

        // Water extinguishes any burning coal item in hand
        if (player.isInWater()) {
            if (mainIsCoal) CoalBurningHelper.setBurning(main, false);
            if (offIsCoal)  CoalBurningHelper.setBurning(off,  false);
            COAL_TOOL_BURNING.remove(uuid);
            return;
        }

        // Ignite: player catches fire while holding an unlit coal item
        if (player.isOnFire()) {
            boolean justIgnitedTool = false;
            if (mainIsCoal && !CoalBurningHelper.isBurning(main)) {
                CoalBurningHelper.setBurning(main, true);
                mainBurning = true;
                if (isCoalTool(main)) justIgnitedTool = true;
            }
            if (offIsCoal && !CoalBurningHelper.isBurning(off)) {
                CoalBurningHelper.setBurning(off, true);
                offBurning = true;
                if (isCoalTool(off)) justIgnitedTool = true;
            }
            if (mainIsCoal || offIsCoal) COAL_TOOL_BURNING.add(uuid);
            // Advancement trigger fires only when a coal tool (not armor) first ignites
            if (justIgnitedTool && player instanceof ServerPlayer sp) {
                ModTriggers.COAL_TOOL_IGNITED.get().trigger(sp);
            }
        }

        // Re-register if player picked up an already-burning coal item
        if ((mainBurning || offBurning) && !COAL_TOOL_BURNING.contains(uuid)) {
            COAL_TOOL_BURNING.add(uuid);
        }

        // No burning coal item in hand — clear held effects
        if (!mainBurning && !offBurning) {
            COAL_TOOL_BURNING.remove(uuid);
            return;
        }

        if (!COAL_TOOL_BURNING.contains(uuid)) return;

        // Once per second: damage player and drain item durability
        if (player.tickCount % 20 == 0) {
            player.hurt(player.damageSources().inFire(), 0.5f);

            if (mainBurning) {
                main.hurtAndBreak(2, player, EquipmentSlot.MAINHAND);
                if (main.isEmpty() && !offBurning) {
                    COAL_TOOL_BURNING.remove(uuid);
                    return;
                }
            }
            if (offBurning) {
                off.hurtAndBreak(2, player, EquipmentSlot.OFFHAND);
                if (off.isEmpty() && !mainBurning) {
                    COAL_TOOL_BURNING.remove(uuid);
                    return;
                }
            }
        }

        // Smoke particles from the held burning item
        if (player.tickCount % 4 == 0 && player.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.SMOKE,
                    player.getX(), player.getY() + 1.2, player.getZ(),
                    1, 0.15, 0.1, 0.15, 0.01);
        }
    }

    // -----------------------------------------------------------------------
    // Coal armor burning (worn by a player)
    // -----------------------------------------------------------------------

    private static final EquipmentSlot[] ARMOR_SLOTS = {
            EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET
    };

    private static void handleCoalArmorBurning(Player player) {
        if (!Config.coalFireEffectsEnabled) return;

        UUID uuid = player.getUUID();

        // Water extinguishes worn armor burning
        if (player.isInWater()) {
            if (COAL_ARMOR_BURNING.contains(uuid)) {
                COAL_ARMOR_BURNING.remove(uuid);
                clearArmorBurning(player);
            }
            return;
        }

        // Ignite: player catches fire while wearing coal armor
        if (player.isOnFire() && isWearingAnyCoalArmor(player) && !COAL_ARMOR_BURNING.contains(uuid)) {
            COAL_ARMOR_BURNING.add(uuid);
            for (EquipmentSlot slot : ARMOR_SLOTS) {
                ItemStack piece = player.getItemBySlot(slot);
                if (isCoalArmor(piece)) CoalBurningHelper.setBurning(piece, true);
            }
        }

        if (!COAL_ARMOR_BURNING.contains(uuid)) return;

        // Stop if no burning coal armor is worn anymore
        if (!isWearingAnyBurningCoalArmor(player)) {
            COAL_ARMOR_BURNING.remove(uuid);
            return;
        }

        // Keep player on fire while wearing burning coal armor
        if (player.getRemainingFireTicks() < 40) {
            player.setRemainingFireTicks(100);
        }

        // Durability drain once per second
        if (player.tickCount % 20 == 0) {
            for (EquipmentSlot slot : ARMOR_SLOTS) {
                ItemStack piece = player.getItemBySlot(slot);
                if (isCoalArmor(piece) && CoalBurningHelper.isBurning(piece)) {
                    piece.hurtAndBreak(1, player, slot);
                }
            }
        }

        // Smoke particles
        if (player.tickCount % 3 == 0 && player.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.SMOKE,
                    player.getX(), player.getY() + 1.5, player.getZ(),
                    3, 0.3, 0.3, 0.3, 0.01);
        }
    }

    // -----------------------------------------------------------------------
    // Ghost spawn gating
    // -----------------------------------------------------------------------

    @SubscribeEvent
    public static void onFinalizeSpawn(MobSpawnEvent.FinalizeSpawn event) {
        if (!(event.getEntity() instanceof GhostEntity)) return;
        if (!Config.ghostEnabled
                || event.getLevel().getRandom().nextDouble() > Config.ghostSpawnChance) {
            event.setResult(Event.Result.DENY);
        }
    }

    // -----------------------------------------------------------------------
    // Furnace fuel values for coal items
    // -----------------------------------------------------------------------

    @SubscribeEvent
    public static void onFurnaceFuel(FurnaceFuelBurnTimeEvent event) {
        var item = event.getItemStack().getItem();

        if (item == ModItems.COAL_DUST.get())       { event.setBurnTime(200);  return; }
        if (item == ModItems.HARDENED_COAL.get())   { event.setBurnTime(400);  return; }
        if (item == ModItems.COAL_SWORD.get())      { event.setBurnTime(800);  return; }
        if (item == ModItems.COAL_PICKAXE.get())    { event.setBurnTime(1200); return; }
        if (item == ModItems.COAL_SHOVEL.get())     { event.setBurnTime(400);  return; }
        if (item == ModItems.COAL_AXE.get())        { event.setBurnTime(1200); return; }
        if (item == ModItems.COAL_HOE.get())        { event.setBurnTime(800);  return; }
        if (item == ModItems.COAL_HELMET.get())     { event.setBurnTime(2000); return; }
        if (item == ModItems.COAL_CHESTPLATE.get()) { event.setBurnTime(3200); return; }
        if (item == ModItems.COAL_LEGGINGS.get())   { event.setBurnTime(2800); return; }
        if (item == ModItems.COAL_BOOTS.get())      { event.setBurnTime(1600); }
    }

    // -----------------------------------------------------------------------
    // Snow / Ice melt mechanics
    // -----------------------------------------------------------------------

    private static void handleSnowIceMelt(Player player) {
        if (!(player.level() instanceof ServerLevel serverLevel)) return;

        // Snow tools melt every 40 ticks when held
        if (player.tickCount % 40 == 0) {
            ItemStack main = player.getMainHandItem();
            ItemStack off  = player.getOffhandItem();
            boolean melted = false;
            if (isSnowTool(main)) { main.hurtAndBreak(1, player, EquipmentSlot.MAINHAND); melted = true; }
            if (isSnowTool(off))  { off.hurtAndBreak(1, player, EquipmentSlot.OFFHAND);   melted = true; }
            if (melted) spawnMeltParticles(player, serverLevel);
        }

        // Ice tools + armor melt every 60 ticks
        if (player.tickCount % 60 == 0) {
            ItemStack main = player.getMainHandItem();
            ItemStack off  = player.getOffhandItem();
            boolean melted = false;
            if (isIceTool(main)) { main.hurtAndBreak(1, player, EquipmentSlot.MAINHAND); melted = true; }
            if (isIceTool(off))  { off.hurtAndBreak(1, player, EquipmentSlot.OFFHAND);   melted = true; }

            for (EquipmentSlot slot : ARMOR_SLOTS) {
                ItemStack piece = player.getItemBySlot(slot);
                if (isIceArmor(piece)) {
                    piece.hurtAndBreak(1, player, slot);
                    melted = true;
                    // On break: 10% chance to place a water source at the player's feet
                    if (piece.isEmpty() && serverLevel.random.nextFloat() < 0.1f) {
                        var feet = player.blockPosition();
                        if (serverLevel.getBlockState(feet).isAir()) {
                            serverLevel.setBlock(feet, Blocks.WATER.defaultBlockState(), 3);
                        }
                    }
                }
            }
            if (melted) spawnMeltParticles(player, serverLevel);
        }
    }

    private static void spawnMeltParticles(Player player, ServerLevel level) {
        level.sendParticles(ParticleTypes.FALLING_WATER,
                player.getX(), player.getY() + 1.2, player.getZ(),
                4, 0.3, 0.3, 0.3, 0.02);
    }

    // -----------------------------------------------------------------------
    // Ice / Snow fire protection — absorbs fire at heavy durability cost
    // -----------------------------------------------------------------------

    private static void handleIceFireProtection(Player player) {
        if (!(player.level() instanceof ServerLevel serverLevel)) return;
        if (!player.isOnFire()) return;

        ItemStack main = player.getMainHandItem();
        ItemStack off  = player.getOffhandItem();

        // Check if any ice or snow item is present
        boolean hasProtector = isSnowTool(main) || isIceTool(main)
                            || isSnowTool(off)   || isIceTool(off);
        if (!hasProtector) {
            for (EquipmentSlot slot : ARMOR_SLOTS) {
                if (isIceArmor(player.getItemBySlot(slot))) { hasProtector = true; break; }
            }
        }
        if (!hasProtector) return;

        // Suppress fire every tick while a protector exists
        player.clearFire();

        // Heavy durability drain once per second (5 per relevant item)
        if (player.tickCount % 20 == 0) {
            if (isSnowTool(main) || isIceTool(main)) main.hurtAndBreak(5, player, EquipmentSlot.MAINHAND);
            if (isSnowTool(off)  || isIceTool(off))  off.hurtAndBreak(5,  player, EquipmentSlot.OFFHAND);
            for (EquipmentSlot slot : ARMOR_SLOTS) {
                ItemStack piece = player.getItemBySlot(slot);
                if (isIceArmor(piece)) piece.hurtAndBreak(5, player, slot);
            }
        }

        // Steam/sizzle particles while absorbing fire
        if (player.tickCount % 8 == 0) {
            serverLevel.sendParticles(ParticleTypes.FALLING_WATER,
                    player.getX(), player.getY() + 1.0, player.getZ(),
                    6, 0.4, 0.4, 0.4, 0.05);
        }
    }

    // -----------------------------------------------------------------------
    // Smooth Prismarine water benefits
    // -----------------------------------------------------------------------

    private static void handleSprismWaterEffects(Player player) {
        if (!player.isInWater()) return;

        // Sprism tool in hand → Haste I (cancels underwater mining penalty)
        if (isSprismTool(player.getMainHandItem()) || isSprismTool(player.getOffhandItem())) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 0, false, false, false));
        }

        // Per-slot armor benefits while in water
        // Helmet → Water Breathing
        if (isSprismArmor(player.getItemBySlot(EquipmentSlot.HEAD))) {
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60, 0, false, false, false));
        }
        // Chestplate → Resistance I (ocean's protective pressure)
        if (isSprismArmor(player.getItemBySlot(EquipmentSlot.CHEST))) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false, false));
        }
        // Leggings → Haste I (removes underwater mining penalty)
        if (isSprismArmor(player.getItemBySlot(EquipmentSlot.LEGS))) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 0, false, false, false));
        }
        // Boots → Slow Falling (buoyancy — rise through water effortlessly)
        if (isSprismArmor(player.getItemBySlot(EquipmentSlot.FEET))) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, false, false));
        }

        // Full 4-piece → Dolphins Grace
        boolean fullSet = isSprismArmor(player.getItemBySlot(EquipmentSlot.HEAD))
                && isSprismArmor(player.getItemBySlot(EquipmentSlot.CHEST))
                && isSprismArmor(player.getItemBySlot(EquipmentSlot.LEGS))
                && isSprismArmor(player.getItemBySlot(EquipmentSlot.FEET));
        if (fullSet) {
            player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 0, false, false, false));
        }
    }

    // -----------------------------------------------------------------------
    // Helpers
    // -----------------------------------------------------------------------

    private static boolean isSnowTool(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(ModItems.SNOW_SWORD.get())
            || stack.is(ModItems.SNOW_PICKAXE.get())
            || stack.is(ModItems.SNOW_SHOVEL.get())
            || stack.is(ModItems.SNOW_AXE.get())
            || stack.is(ModItems.SNOW_HOE.get());
    }

    private static boolean isIceTool(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(ModItems.ICE_SWORD.get())
            || stack.is(ModItems.ICE_PICKAXE.get())
            || stack.is(ModItems.ICE_SHOVEL.get())
            || stack.is(ModItems.ICE_AXE.get())
            || stack.is(ModItems.ICE_HOE.get());
    }

    private static boolean isIceArmor(ItemStack stack) {
        if (stack.isEmpty() || !(stack.getItem() instanceof ArmorItem armor)) return false;
        return ModArmorMaterials.ICE_ARMOR_MATERIAL.is(armor.getMaterial());
    }

    private static boolean isSprismTool(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(ModItems.SPRISM_SWORD.get())
            || stack.is(ModItems.SPRISM_PICKAXE.get())
            || stack.is(ModItems.SPRISM_SHOVEL.get())
            || stack.is(ModItems.SPRISM_AXE.get())
            || stack.is(ModItems.SPRISM_HOE.get());
    }

    private static boolean isSprismArmor(ItemStack stack) {
        if (stack.isEmpty() || !(stack.getItem() instanceof ArmorItem armor)) return false;
        return ModArmorMaterials.SPRISM_ARMOR_MATERIAL.is(armor.getMaterial());
    }

    private static boolean isCoalTool(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(ModItems.COAL_SWORD.get())
            || stack.is(ModItems.COAL_PICKAXE.get())
            || stack.is(ModItems.COAL_SHOVEL.get())
            || stack.is(ModItems.COAL_AXE.get())
            || stack.is(ModItems.COAL_HOE.get());
    }

    private static boolean isCoalArmor(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() instanceof CoalArmorItem;
    }

    private static boolean isWearingAnyCoalArmor(Player player) {
        for (EquipmentSlot slot : ARMOR_SLOTS) {
            if (isCoalArmor(player.getItemBySlot(slot))) return true;
        }
        return false;
    }

    private static boolean isWearingAnyBurningCoalArmor(Player player) {
        for (EquipmentSlot slot : ARMOR_SLOTS) {
            ItemStack piece = player.getItemBySlot(slot);
            if (isCoalArmor(piece) && CoalBurningHelper.isBurning(piece)) return true;
        }
        return false;
    }

    private static void clearArmorBurning(Player player) {
        for (EquipmentSlot slot : ARMOR_SLOTS) {
            ItemStack piece = player.getItemBySlot(slot);
            if (isCoalArmor(piece)) CoalBurningHelper.setBurning(piece, false);
        }
    }

    private static void clearBurningIfCoalTool(ItemStack stack) {
        if (isCoalTool(stack)) CoalBurningHelper.setBurning(stack, false);
    }

    private static void applyEffects(Player player, MobEffectInstance... effects) {
        for (MobEffectInstance effect : effects) {
            player.addEffect(effect);
        }
    }

    // -----------------------------------------------------------------------
    // FNI fire mechanics
    // -----------------------------------------------------------------------

    /**
     * Sneak + right-click a block while holding any Flint-Iron tool in the main hand
     * to start a fire on the clicked face (identical behaviour to vanilla Flint and Steel).
     * Consumes 1 durability per use.
     */
    @SubscribeEvent
    public static void onFniRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        if (!player.isShiftKeyDown()) return;
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        ItemStack held = player.getMainHandItem();
        if (!isFniTool(held)) return;

        Level level = event.getLevel();
        if (level.isClientSide()) return;

        BlockPos clickedPos = event.getPos();
        Direction face = event.getFace();
        if (face == null) return;

        BlockPos firePos = clickedPos.relative(face);
        BlockState target = level.getBlockState(firePos);
        if (target.isAir() || target.canBeReplaced()) {
            level.setBlock(firePos, BaseFireBlock.getState(level, firePos), 11);
            level.playSound(null, firePos, SoundEvents.FLINTANDSTEEL_USE,
                    SoundSource.BLOCKS, 1.0f, level.random.nextFloat() * 0.4f + 0.8f);
            held.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
            event.setCanceled(true);
            event.setResult(net.minecraftforge.eventbus.api.Event.Result.ALLOW);
        }
    }

    /**
     * FNI boots: small chance (4% per 10 ticks) to ignite flammable blocks underfoot.
     * Fire appears beside the player to avoid immediately burning them.
     */
    private static void handleFniBootsFire(Player player) {
        if (!player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.FNI_BOOTS.get())) return;
        if (player.tickCount % 10 != 0) return;
        if (!player.onGround()) return;

        Level level = player.level();
        BlockPos feetPos = player.blockPosition();
        BlockState floorState = level.getBlockState(feetPos.below());

        if (((FireBlock) Blocks.FIRE).getBurnOdds(floorState) > 0
                && level.random.nextFloat() < 0.04f) {
            Direction[] dirs = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
            Direction randDir = dirs[level.random.nextInt(4)];
            BlockPos firePos = feetPos.relative(randDir);
            if (level.getBlockState(firePos).isAir()) {
                level.setBlock(firePos, BaseFireBlock.getState(level, firePos), 11);
            }
        }
    }

    /**
     * Full FNI set bonus: drains fire ticks one extra per tick on top of vanilla's own
     * decrement, cutting effective burn duration roughly in half.  Not full immunity —
     * the player still takes fire damage — but the flames die out noticeably faster.
     */
    private static void handleFniArmorBonus(Player player) {
        if (!isWearingFullFniArmor(player)) return;
        int fireTicks = player.getRemainingFireTicks();
        if (fireTicks > 0) {
            player.setRemainingFireTicks(fireTicks - 1);
        }
    }

    private static boolean isWearingFullFniArmor(Player player) {
        return player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.FNI_HELMET.get())
            && player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.FNI_CHESTPLATE.get())
            && player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.FNI_LEGGINGS.get())
            && player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.FNI_BOOTS.get());
    }

    private static boolean isFniTool(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(ModItems.FNI_SWORD.get())
            || stack.is(ModItems.FNI_PICKAXE.get())
            || stack.is(ModItems.FNI_SHOVEL.get())
            || stack.is(ModItems.FNI_AXE.get())
            || stack.is(ModItems.FNI_HOE.get());
    }

    private static void spawnAuraParticles(net.minecraft.world.level.Level level, Player player) {
        double radius = 0.5 + level.random.nextDouble() * 0.5;
        double angle  = level.random.nextDouble() * Math.PI * 2;
        double x = player.getX() + Math.cos(angle) * radius;
        double y = player.getY() + 1.0 + (level.random.nextDouble() - 0.5) * 0.3;
        double z = player.getZ() + Math.sin(angle) * radius;

        if (level.random.nextBoolean()) {
            level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 0, 0.02, 0);
        } else {
            level.addParticle(ParticleTypes.ENCHANT, x, y, z, 0, 0.01, 0);
        }
    }

    // -----------------------------------------------------------------------
    // Ectoplasm infusion tooltip
    // -----------------------------------------------------------------------

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (EctoplasmInfusionHelper.isInfused(stack)) {
            event.getToolTip().add(Component.translatable("tooltip.usefultoolsmod.ectoplasm_infused")
                    .withStyle(ChatFormatting.DARK_AQUA));
        }
    }
}
