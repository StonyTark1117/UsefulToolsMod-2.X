package com.stonytark.usefultoolsmod.event;

import com.stonytark.usefultoolsmod.Config;
import com.stonytark.usefultoolsmod.entity.custom.GhostEntity;
import com.stonytark.usefultoolsmod.item.ModArmorMaterials;
import com.stonytark.usefultoolsmod.item.ModItems;
import com.stonytark.usefultoolsmod.item.custom.CoalArmorItem;
import com.stonytark.usefultoolsmod.item.custom.CoalBurningHelper;
import com.stonytark.usefultoolsmod.item.custom.EctoplasmArmorHelper;
import com.stonytark.usefultoolsmod.item.custom.EctoplasmInfusionHelper;
import com.stonytark.usefultoolsmod.trigger.ModTriggers;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
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

        if (Config.overpowerEnabled && Config.opToolEffectsEnabled) {
            handleOpToolEffects(player, player.getMainHandItem());
            handleOpToolEffects(player, player.getOffhandItem());
        }
        if (Config.overpowerEnabled && Config.opArmorEffectsEnabled) {
            spawnArmorAuraIfOp(player);
        }

        if (!player.level().isClientSide) {
            if (Config.coalEnabled && Config.coalFireEffects) {
                handleCoalToolBurning(player);
                handleCoalArmorBurning(player);
            }
            if (Config.snowEnabled && Config.snowMeltEffects) {
                handleSnowMelt(player);
                handleSnowFireProtection(player);
            }
            if (Config.iceEnabled && Config.iceEffects) {
                handleIceMelt(player);
                handleIceFireProtection(player);
            }
            if (Config.pprismEnabled && Config.pprismWaterEffects) {
                handlePprismWaterEffects(player);
            }
            if (Config.fniEnabled && Config.fniFireEffects) {
                handleFniBootsFire(player);
                handleFniArmorBonus(player);
            }
            if (Config.ectoplasmSetEnabled && Config.ectoplasmWallPhasing) {
                handleEctoWallPhasing(player);
            }
            if (Config.spectralInfuserEnabled && Config.infusedToolEffects) {
                handleInfusedToolEffects(player);
            }
            if (Config.foodHungerDrain) {
                handleFoodHungerDrain(player);
            }
            if (Config.cakeEnabled && Config.cakeArmorEffects) {
                handleCakeArmorEffects(player);
            }
            // Food set armor effects
            if (Config.breadEnabled && Config.breadArmorEffects) handleBreadArmorEffects(player);
            if (Config.driedKelpEnabled && Config.driedKelpArmorEffects) handleDriedKelpArmorEffects(player);
            if (Config.rottenFleshEnabled && Config.rottenFleshArmorEffects) handleRottenFleshArmorEffects(player);
            if (Config.melonEnabled && Config.melonArmorEffects) handleMelonArmorEffects(player);
            if (Config.sweetBerryEnabled && Config.sweetBerryArmorEffects) handleSweetBerryArmorEffects(player);
            if (Config.pumpkinPieEnabled && Config.pumpkinPieArmorEffects) handlePumpkinPieArmorEffects(player);
            if (Config.mushroomEnabled && Config.mushroomArmorEffects) handleMushroomArmorEffects(player);
            if (Config.pufferfishEnabled && Config.pufferfishArmorEffects) handlePufferfishArmorEffects(player);
            if (Config.honeyEnabled && Config.honeyArmorEffects) handleHoneyArmorEffects(player);
            if (Config.chorusFruitEnabled && Config.chorusFruitArmorEffects) handleChorusFruitArmorEffects(player);
            if (Config.goldenAppleEnabled && Config.goldenAppleArmorEffects) handleGoldenAppleArmorEffects(player);
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

        // Damage player and drain durability once per second
        if (player.tickCount % 20 == 0) {
            player.hurt(player.damageSources().inFire(), 0.5f);
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
    // Snow melt mechanics
    // -----------------------------------------------------------------------

    private static void handleSnowMelt(Player player) {
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
    }

    // -----------------------------------------------------------------------
    // Snow fire protection — absorbs fire at heavy durability cost
    // -----------------------------------------------------------------------

    private static void handleSnowFireProtection(Player player) {
        if (!(player.level() instanceof ServerLevel serverLevel)) return;
        if (!player.isOnFire()) return;

        ItemStack main = player.getMainHandItem();
        ItemStack off  = player.getOffhandItem();

        boolean hasProtector = isSnowTool(main) || isSnowTool(off);
        if (!hasProtector) return;

        player.clearFire();

        if (player.tickCount % 20 == 0) {
            if (isSnowTool(main)) main.hurtAndBreak(5, player, EquipmentSlot.MAINHAND);
            if (isSnowTool(off))  off.hurtAndBreak(5,  player, EquipmentSlot.OFFHAND);
        }

        if (player.tickCount % 8 == 0) {
            serverLevel.sendParticles(ParticleTypes.FALLING_WATER,
                    player.getX(), player.getY() + 1.0, player.getZ(),
                    6, 0.4, 0.4, 0.4, 0.05);
        }
    }

    // -----------------------------------------------------------------------
    // Ice melt mechanics
    // -----------------------------------------------------------------------

    private static void handleIceMelt(Player player) {
        if (!(player.level() instanceof ServerLevel serverLevel)) return;

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
    // Ice fire protection — absorbs fire at heavy durability cost
    // -----------------------------------------------------------------------

    private static void handleIceFireProtection(Player player) {
        if (!(player.level() instanceof ServerLevel serverLevel)) return;
        if (!player.isOnFire()) return;

        ItemStack main = player.getMainHandItem();
        ItemStack off  = player.getOffhandItem();

        boolean hasProtector = isIceTool(main) || isIceTool(off);
        if (!hasProtector) {
            for (EquipmentSlot slot : ARMOR_SLOTS) {
                if (isIceArmor(player.getItemBySlot(slot))) { hasProtector = true; break; }
            }
        }
        if (!hasProtector) return;

        player.clearFire();

        if (player.tickCount % 20 == 0) {
            if (isIceTool(main)) main.hurtAndBreak(5, player, EquipmentSlot.MAINHAND);
            if (isIceTool(off))  off.hurtAndBreak(5,  player, EquipmentSlot.OFFHAND);
            for (EquipmentSlot slot : ARMOR_SLOTS) {
                ItemStack piece = player.getItemBySlot(slot);
                if (isIceArmor(piece)) piece.hurtAndBreak(5, player, slot);
            }
        }

        if (player.tickCount % 8 == 0) {
            serverLevel.sendParticles(ParticleTypes.FALLING_WATER,
                    player.getX(), player.getY() + 1.0, player.getZ(),
                    6, 0.4, 0.4, 0.4, 0.05);
        }
    }

    // -----------------------------------------------------------------------
    // Polished Prismarine water benefits
    // -----------------------------------------------------------------------

    private static void handlePprismWaterEffects(Player player) {
        if (!player.isInWater()) return;

        // Pprism tool in hand → Haste I (cancels underwater mining penalty)
        if (isPprismTool(player.getMainHandItem()) || isPprismTool(player.getOffhandItem())) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 0, false, false, false));
        }

        // Per-slot armor benefits while in water
        // Helmet → Water Breathing
        if (isPprismArmor(player.getItemBySlot(EquipmentSlot.HEAD))) {
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60, 0, false, false, false));
        }
        // Chestplate → Resistance I (ocean's protective pressure)
        if (isPprismArmor(player.getItemBySlot(EquipmentSlot.CHEST))) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false, false));
        }
        // Leggings → Haste I (removes underwater mining penalty)
        if (isPprismArmor(player.getItemBySlot(EquipmentSlot.LEGS))) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 0, false, false, false));
        }
        // Boots → Slow Falling (buoyancy — rise through water effortlessly)
        if (isPprismArmor(player.getItemBySlot(EquipmentSlot.FEET))) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, false, false));
        }

        // Full 4-piece → Dolphins Grace
        boolean fullSet = isPprismArmor(player.getItemBySlot(EquipmentSlot.HEAD))
                && isPprismArmor(player.getItemBySlot(EquipmentSlot.CHEST))
                && isPprismArmor(player.getItemBySlot(EquipmentSlot.LEGS))
                && isPprismArmor(player.getItemBySlot(EquipmentSlot.FEET));
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

    private static boolean isPprismTool(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(ModItems.PPRISM_SWORD.get())
            || stack.is(ModItems.PPRISM_PICKAXE.get())
            || stack.is(ModItems.PPRISM_SHOVEL.get())
            || stack.is(ModItems.PPRISM_AXE.get())
            || stack.is(ModItems.PPRISM_HOE.get());
    }

    private static boolean isPprismArmor(ItemStack stack) {
        if (stack.isEmpty() || !(stack.getItem() instanceof ArmorItem armor)) return false;
        return ModArmorMaterials.PPRISM_ARMOR_MATERIAL.is(armor.getMaterial());
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
        if (!Config.fniEnabled || !Config.fniFireEffects) return;
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
    // Item tooltips
    // -----------------------------------------------------------------------

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();

        if (EctoplasmInfusionHelper.isInfused(stack)) {
            event.getToolTip().add(Component.translatable("tooltip.usefultoolsmod.ectoplasm_infused")
                    .withStyle(ChatFormatting.DARK_AQUA));
            if (stack.getItem() instanceof PickaxeItem) {
                event.getToolTip().add(Component.translatable("tooltip.usefultoolsmod.spectral_sight")
                        .withStyle(ChatFormatting.GRAY));
            } else if (stack.getItem() instanceof ShovelItem) {
                event.getToolTip().add(Component.translatable("tooltip.usefultoolsmod.spectral_efficiency")
                        .withStyle(ChatFormatting.GRAY));
            } else if (stack.getItem() instanceof HoeItem) {
                event.getToolTip().add(Component.translatable("tooltip.usefultoolsmod.spectral_fortune")
                        .withStyle(ChatFormatting.GRAY));
            }
        }

        // Coal tools / armor
        if (isCoalTool(stack) || isCoalArmor(stack)) {
            if (CoalBurningHelper.isBurning(stack)) {
                event.getToolTip().add(Component.translatable("tooltip.usefultoolsmod.burning")
                        .withStyle(ChatFormatting.RED));
                // Coal tools: -2 dur/s, coal armor: -1 dur/s
                double drainPerSecond = isCoalTool(stack) ? 2.0 : 1.0;
                addTimeRemaining(event, stack, drainPerSecond);
            } else {
                event.getToolTip().add(Component.translatable("tooltip.usefultoolsmod.flammable")
                        .withStyle(ChatFormatting.GOLD));
            }
        }

        // Snow tools
        if (isSnowTool(stack)) {
            event.getToolTip().add(Component.translatable("tooltip.usefultoolsmod.melts_when_held")
                    .withStyle(ChatFormatting.AQUA));
            // -1 dur / 40 ticks = 0.5 dur/s
            addTimeRemaining(event, stack, 0.5);
        }

        // Ice tools
        if (isIceTool(stack)) {
            event.getToolTip().add(Component.translatable("tooltip.usefultoolsmod.melts_when_held")
                    .withStyle(ChatFormatting.AQUA));
            // -1 dur / 60 ticks = 1/3 dur/s
            addTimeRemaining(event, stack, 1.0 / 3.0);
        }

        // Ice armor
        if (isIceArmor(stack)) {
            event.getToolTip().add(Component.translatable("tooltip.usefultoolsmod.melts_when_worn")
                    .withStyle(ChatFormatting.AQUA));
            // -1 dur / 60 ticks = 1/3 dur/s
            addTimeRemaining(event, stack, 1.0 / 3.0);
        }
    }

    private static void addTimeRemaining(ItemTooltipEvent event, ItemStack stack, double drainPerSecond) {
        if (!stack.isDamageableItem()) return;
        int remaining = stack.getMaxDamage() - stack.getDamageValue();
        int totalSeconds = (int) Math.ceil(remaining / drainPerSecond);
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        String time;
        if (minutes > 0) {
            time = minutes + "m " + seconds + "s";
        } else {
            time = seconds + "s";
        }

        event.getToolTip().add(Component.translatable("tooltip.usefultoolsmod.time_remaining", time)
                .withStyle(ChatFormatting.GRAY));
    }

    // -----------------------------------------------------------------------
    // Ectoplasm wall phasing
    // -----------------------------------------------------------------------

    /** Tracks which players are currently phasing through walls. */
    private static final Set<UUID> PHASING_PLAYERS = new HashSet<>();

    /**
     * Full ecto armor set allows the player to phase through walls ≤ 3 blocks thick.
     * When inside a solid block: noPhysics=true, Slowness I, SOUL_FIRE_FLAME particles.
     * If the player loses armor while inside a wall, they are teleported to safety.
     */
    private static void handleEctoWallPhasing(Player player) {
        boolean hasFullSet = EctoplasmArmorHelper.hasFullEctoArmorSet(player);
        boolean isPhasing = PHASING_PLAYERS.contains(player.getUUID());
        Level level = player.level();
        BlockPos feetPos = player.blockPosition();
        BlockPos headPos = feetPos.above();

        boolean inSolid = !level.getBlockState(feetPos).getCollisionShape(level, feetPos).isEmpty()
                       || !level.getBlockState(headPos).getCollisionShape(level, headPos).isEmpty();

        if (hasFullSet && inSolid && (isPhasing || player.isShiftKeyDown())) {
            // Must sneak to initiate phasing; once inside, continue until exit
            if (!isPhasing) {
                // Entering wall — check thickness
                int thickness = measureWallThickness(player, level);
                if (thickness > 3 || thickness == 0) {
                    // Wall too thick or couldn't find exit; deny entry
                    player.noPhysics = false;
                    return;
                }
            }

            // Allow phasing
            player.noPhysics = true;
            PHASING_PLAYERS.add(player.getUUID());

            // Apply Slowness I while phasing
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 0, false, false, true));

            // Spawn particles
            if (level instanceof ServerLevel serverLevel && player.tickCount % 4 == 0) {
                serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME,
                        player.getX(), player.getY() + 1.0, player.getZ(),
                        3, 0.3, 0.5, 0.3, 0.01);
            }
        } else if (isPhasing) {
            // Player left the wall or lost armor
            player.noPhysics = false;
            PHASING_PLAYERS.remove(player.getUUID());

            if (!hasFullSet && inSolid) {
                // Lost armor while inside wall — teleport to safety
                teleportToSafety(player, level);
            }
        } else {
            // Not phasing, not in solid — ensure noPhysics is off
            player.noPhysics = false;
        }
    }

    /**
     * Measures how many consecutive solid blocks exist from the player's position
     * outward in their horizontal look direction. Returns 0 if no exit found within 4 blocks.
     */
    private static int measureWallThickness(Player player, Level level) {
        // Get horizontal look direction as a unit vector
        float yaw = player.getYRot();
        double dx = -Math.sin(Math.toRadians(yaw));
        double dz = Math.cos(Math.toRadians(yaw));

        // Normalize to dominant axis for block scanning
        Direction dir;
        if (Math.abs(dx) > Math.abs(dz)) {
            dir = dx > 0 ? Direction.EAST : Direction.WEST;
        } else {
            dir = dz > 0 ? Direction.SOUTH : Direction.NORTH;
        }

        BlockPos checkPos = player.blockPosition();
        int solidCount = 0;

        for (int i = 0; i < 4; i++) {
            checkPos = checkPos.relative(dir);
            BlockPos checkHead = checkPos.above();

            boolean feetSolid = !level.getBlockState(checkPos).getCollisionShape(level, checkPos).isEmpty();
            boolean headSolid = !level.getBlockState(checkHead).getCollisionShape(level, checkHead).isEmpty();

            if (feetSolid || headSolid) {
                solidCount++;
            } else {
                // Found exit
                return solidCount;
            }
        }

        // No exit within 4 blocks
        return 0;
    }

    // -----------------------------------------------------------------------
    // Generalized food hunger drain (all food sets including cake)
    // -----------------------------------------------------------------------

    /** All food armor materials for hunger drain scanning (lazy to avoid premature registry access). */
    private static List<Holder<ArmorMaterial>> FOOD_ARMOR_MATERIALS;
    private static List<Holder<ArmorMaterial>> getFoodArmorMaterials() {
        if (FOOD_ARMOR_MATERIALS == null) {
            FOOD_ARMOR_MATERIALS = List.of(
                    ModArmorMaterials.CAKE_ARMOR_MATERIAL,
                    ModArmorMaterials.BREAD_ARMOR_MATERIAL,
                    ModArmorMaterials.DRIED_KELP_ARMOR_MATERIAL,
                    ModArmorMaterials.ROTTEN_FLESH_ARMOR_MATERIAL,
                    ModArmorMaterials.MELON_ARMOR_MATERIAL,
                    ModArmorMaterials.SWEET_BERRY_ARMOR_MATERIAL,
                    ModArmorMaterials.PUMPKIN_PIE_ARMOR_MATERIAL,
                    ModArmorMaterials.MUSHROOM_ARMOR_MATERIAL,
                    ModArmorMaterials.PUFFERFISH_ARMOR_MATERIAL,
                    ModArmorMaterials.HONEY_ARMOR_MATERIAL,
                    ModArmorMaterials.CHORUS_FRUIT_ARMOR_MATERIAL,
                    ModArmorMaterials.GOLDEN_APPLE_ARMOR_MATERIAL
            );
        }
        return FOOD_ARMOR_MATERIALS;
    }

    private static boolean isFoodTool(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return isCakeTool(stack) || isBreadTool(stack) || isDriedKelpTool(stack)
            || isRottenFleshTool(stack) || isMelonTool(stack) || isSweetBerryTool(stack)
            || isPumpkinPieTool(stack) || isMushroomTool(stack) || isPufferfishTool(stack)
            || isHoneyTool(stack) || isChorusFruitTool(stack) || isGoldenAppleTool(stack);
    }

    private static boolean isFoodArmor(ItemStack stack) {
        if (stack.isEmpty() || !(stack.getItem() instanceof ArmorItem armor)) return false;
        for (Holder<ArmorMaterial> mat : getFoodArmorMaterials()) {
            if (mat.is(armor.getMaterial())) return true;
        }
        return false;
    }

    private static boolean isFoodSetEnabled(ItemStack stack) {
        if (isCakeTool(stack) || isCakeArmor(stack)) return Config.cakeEnabled;
        if (isBreadTool(stack) || isBreadArmor(stack)) return Config.breadEnabled;
        if (isDriedKelpTool(stack) || isDriedKelpArmor(stack)) return Config.driedKelpEnabled;
        if (isRottenFleshTool(stack) || isRottenFleshArmor(stack)) return Config.rottenFleshEnabled;
        if (isMelonTool(stack) || isMelonArmor(stack)) return Config.melonEnabled;
        if (isSweetBerryTool(stack) || isSweetBerryArmor(stack)) return Config.sweetBerryEnabled;
        if (isPumpkinPieTool(stack) || isPumpkinPieArmor(stack)) return Config.pumpkinPieEnabled;
        if (isMushroomTool(stack) || isMushroomArmor(stack)) return Config.mushroomEnabled;
        if (isPufferfishTool(stack) || isPufferfishArmor(stack)) return Config.pufferfishEnabled;
        if (isHoneyTool(stack) || isHoneyArmor(stack)) return Config.honeyEnabled;
        if (isChorusFruitTool(stack) || isChorusFruitArmor(stack)) return Config.chorusFruitEnabled;
        if (isGoldenAppleTool(stack) || isGoldenAppleArmor(stack)) return Config.goldenAppleEnabled;
        return false;
    }

    private static void handleFoodHungerDrain(Player player) {
        if (!(player.level() instanceof ServerLevel serverLevel)) return;
        if (player.getFoodData().getFoodLevel() > 6) return;
        if (player.tickCount % 40 != 0) return;

        ItemStack main = player.getMainHandItem();
        ItemStack off  = player.getOffhandItem();
        if (isFoodTool(main) && main.isDamageableItem() && isFoodSetEnabled(main)) {
            main.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
            player.getFoodData().eat(1, 0.1f);
            spawnFoodParticles(player, serverLevel);
        }
        if (isFoodTool(off) && off.isDamageableItem() && isFoodSetEnabled(off)) {
            off.hurtAndBreak(1, player, EquipmentSlot.OFFHAND);
            player.getFoodData().eat(1, 0.1f);
            spawnFoodParticles(player, serverLevel);
        }

        for (EquipmentSlot slot : ARMOR_SLOTS) {
            ItemStack piece = player.getItemBySlot(slot);
            if (isFoodArmor(piece) && piece.isDamageableItem() && isFoodSetEnabled(piece)) {
                piece.hurtAndBreak(1, player, slot);
                player.getFoodData().eat(1, 0.1f);
                spawnFoodParticles(player, serverLevel);
            }
        }
    }

    private static void spawnFoodParticles(Player player, ServerLevel level) {
        level.sendParticles(ParticleTypes.HAPPY_VILLAGER,
                player.getX(), player.getY() + 1.0, player.getZ(),
                5, 0.3, 0.3, 0.3, 0.01);
    }

    private static void handleCakeArmorEffects(Player player) {
        // Boots → Speed I (sugar rush)
        if (isCakeArmor(player.getItemBySlot(EquipmentSlot.FEET))) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false, true));
        }
        // Leggings → Jump Boost I (light and fluffy)
        if (isCakeArmor(player.getItemBySlot(EquipmentSlot.LEGS))) {
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 0, false, false, true));
        }
        // Chestplate → Regeneration I (comfort food healing)
        if (isCakeArmor(player.getItemBySlot(EquipmentSlot.CHEST))) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false, true));
        }
        // Helmet → Saturation (keeps hunger satisfied)
        if (isCakeArmor(player.getItemBySlot(EquipmentSlot.HEAD))) {
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 60, 0, false, false, true));
        }

        // Full set → Absorption I (frosting shield — 2 extra hearts)
        boolean fullSet = isCakeArmor(player.getItemBySlot(EquipmentSlot.HEAD))
                && isCakeArmor(player.getItemBySlot(EquipmentSlot.CHEST))
                && isCakeArmor(player.getItemBySlot(EquipmentSlot.LEGS))
                && isCakeArmor(player.getItemBySlot(EquipmentSlot.FEET));
        if (fullSet) {
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 60, 0, false, false, true));
        }
    }

    private static boolean isCakeTool(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(ModItems.CAKE_SWORD.get())
            || stack.is(ModItems.CAKE_PICKAXE.get())
            || stack.is(ModItems.CAKE_SHOVEL.get())
            || stack.is(ModItems.CAKE_AXE.get())
            || stack.is(ModItems.CAKE_HOE.get());
    }

    private static boolean isCakeArmor(ItemStack stack) {
        if (stack.isEmpty() || !(stack.getItem() instanceof ArmorItem armor)) return false;
        return ModArmorMaterials.CAKE_ARMOR_MATERIAL.is(armor.getMaterial());
    }

    // -----------------------------------------------------------------------
    // Ectoplasm-infused non-weapon tool effects
    // -----------------------------------------------------------------------

    private static void handleInfusedToolEffects(Player player) {
        ItemStack main = player.getMainHandItem();
        ItemStack off  = player.getOffhandItem();

        applyInfusedEffect(player, main);
        applyInfusedEffect(player, off);
    }

    private static void applyInfusedEffect(Player player, ItemStack stack) {
        if (stack.isEmpty() || !EctoplasmInfusionHelper.isInfused(stack)) return;

        // Pickaxe → Night Vision (spectral sight)
        if (stack.getItem() instanceof PickaxeItem) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 260, 0, false, false, true));
        }
        // Shovel → Haste I (spectral efficiency)
        else if (stack.getItem() instanceof ShovelItem) {
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 0, false, false, true));
        }
        // Hoe → Luck I (spectral fortune)
        else if (stack.getItem() instanceof HoeItem) {
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 60, 0, false, false, true));
        }
    }

    /**
     * Teleports the player to the nearest safe (non-solid) position above them.
     */
    private static void teleportToSafety(Player player, Level level) {
        BlockPos pos = player.blockPosition();

        // Try going up
        for (int y = 0; y < 256; y++) {
            BlockPos check = pos.above(y);
            BlockPos checkHead = check.above();

            boolean feetClear = level.getBlockState(check).getCollisionShape(level, check).isEmpty();
            boolean headClear = level.getBlockState(checkHead).getCollisionShape(level, checkHead).isEmpty();

            if (feetClear && headClear) {
                player.teleportTo(check.getX() + 0.5, check.getY(), check.getZ() + 0.5);
                return;
            }
        }
    }

    // =======================================================================
    // Food set helpers
    // =======================================================================

    private static boolean isBreadTool(ItemStack s) {
        return !s.isEmpty() && (s.is(ModItems.BREAD_SWORD.get()) || s.is(ModItems.BREAD_PICKAXE.get())
            || s.is(ModItems.BREAD_SHOVEL.get()) || s.is(ModItems.BREAD_AXE.get()) || s.is(ModItems.BREAD_HOE.get()));
    }
    private static boolean isBreadArmor(ItemStack s) {
        return !s.isEmpty() && s.getItem() instanceof ArmorItem a && ModArmorMaterials.BREAD_ARMOR_MATERIAL.is(a.getMaterial());
    }
    private static boolean isDriedKelpTool(ItemStack s) {
        return !s.isEmpty() && (s.is(ModItems.DRIED_KELP_SWORD.get()) || s.is(ModItems.DRIED_KELP_PICKAXE.get())
            || s.is(ModItems.DRIED_KELP_SHOVEL.get()) || s.is(ModItems.DRIED_KELP_AXE.get()) || s.is(ModItems.DRIED_KELP_HOE.get()));
    }
    private static boolean isDriedKelpArmor(ItemStack s) {
        return !s.isEmpty() && s.getItem() instanceof ArmorItem a && ModArmorMaterials.DRIED_KELP_ARMOR_MATERIAL.is(a.getMaterial());
    }
    private static boolean isRottenFleshTool(ItemStack s) {
        return !s.isEmpty() && (s.is(ModItems.ROTTEN_FLESH_SWORD.get()) || s.is(ModItems.ROTTEN_FLESH_PICKAXE.get())
            || s.is(ModItems.ROTTEN_FLESH_SHOVEL.get()) || s.is(ModItems.ROTTEN_FLESH_AXE.get()) || s.is(ModItems.ROTTEN_FLESH_HOE.get()));
    }
    private static boolean isRottenFleshArmor(ItemStack s) {
        return !s.isEmpty() && s.getItem() instanceof ArmorItem a && ModArmorMaterials.ROTTEN_FLESH_ARMOR_MATERIAL.is(a.getMaterial());
    }
    private static boolean isMelonTool(ItemStack s) {
        return !s.isEmpty() && (s.is(ModItems.MELON_SWORD.get()) || s.is(ModItems.MELON_PICKAXE.get())
            || s.is(ModItems.MELON_SHOVEL.get()) || s.is(ModItems.MELON_AXE.get()) || s.is(ModItems.MELON_HOE.get()));
    }
    private static boolean isMelonArmor(ItemStack s) {
        return !s.isEmpty() && s.getItem() instanceof ArmorItem a && ModArmorMaterials.MELON_ARMOR_MATERIAL.is(a.getMaterial());
    }
    private static boolean isSweetBerryTool(ItemStack s) {
        return !s.isEmpty() && (s.is(ModItems.SWEET_BERRY_SWORD.get()) || s.is(ModItems.SWEET_BERRY_PICKAXE.get())
            || s.is(ModItems.SWEET_BERRY_SHOVEL.get()) || s.is(ModItems.SWEET_BERRY_AXE.get()) || s.is(ModItems.SWEET_BERRY_HOE.get()));
    }
    private static boolean isSweetBerryArmor(ItemStack s) {
        return !s.isEmpty() && s.getItem() instanceof ArmorItem a && ModArmorMaterials.SWEET_BERRY_ARMOR_MATERIAL.is(a.getMaterial());
    }
    private static boolean isPumpkinPieTool(ItemStack s) {
        return !s.isEmpty() && (s.is(ModItems.PUMPKIN_PIE_SWORD.get()) || s.is(ModItems.PUMPKIN_PIE_PICKAXE.get())
            || s.is(ModItems.PUMPKIN_PIE_SHOVEL.get()) || s.is(ModItems.PUMPKIN_PIE_AXE.get()) || s.is(ModItems.PUMPKIN_PIE_HOE.get()));
    }
    private static boolean isPumpkinPieArmor(ItemStack s) {
        return !s.isEmpty() && s.getItem() instanceof ArmorItem a && ModArmorMaterials.PUMPKIN_PIE_ARMOR_MATERIAL.is(a.getMaterial());
    }
    private static boolean isMushroomTool(ItemStack s) {
        return !s.isEmpty() && (s.is(ModItems.MUSHROOM_SWORD.get()) || s.is(ModItems.MUSHROOM_PICKAXE.get())
            || s.is(ModItems.MUSHROOM_SHOVEL.get()) || s.is(ModItems.MUSHROOM_AXE.get()) || s.is(ModItems.MUSHROOM_HOE.get()));
    }
    private static boolean isMushroomArmor(ItemStack s) {
        return !s.isEmpty() && s.getItem() instanceof ArmorItem a && ModArmorMaterials.MUSHROOM_ARMOR_MATERIAL.is(a.getMaterial());
    }
    private static boolean isPufferfishTool(ItemStack s) {
        return !s.isEmpty() && (s.is(ModItems.PUFFERFISH_SWORD.get()) || s.is(ModItems.PUFFERFISH_PICKAXE.get())
            || s.is(ModItems.PUFFERFISH_SHOVEL.get()) || s.is(ModItems.PUFFERFISH_AXE.get()) || s.is(ModItems.PUFFERFISH_HOE.get()));
    }
    private static boolean isPufferfishArmor(ItemStack s) {
        return !s.isEmpty() && s.getItem() instanceof ArmorItem a && ModArmorMaterials.PUFFERFISH_ARMOR_MATERIAL.is(a.getMaterial());
    }
    private static boolean isHoneyTool(ItemStack s) {
        return !s.isEmpty() && (s.is(ModItems.HONEY_SWORD.get()) || s.is(ModItems.HONEY_PICKAXE.get())
            || s.is(ModItems.HONEY_SHOVEL.get()) || s.is(ModItems.HONEY_AXE.get()) || s.is(ModItems.HONEY_HOE.get()));
    }
    private static boolean isHoneyArmor(ItemStack s) {
        return !s.isEmpty() && s.getItem() instanceof ArmorItem a && ModArmorMaterials.HONEY_ARMOR_MATERIAL.is(a.getMaterial());
    }
    private static boolean isChorusFruitTool(ItemStack s) {
        return !s.isEmpty() && (s.is(ModItems.CHORUS_FRUIT_SWORD.get()) || s.is(ModItems.CHORUS_FRUIT_PICKAXE.get())
            || s.is(ModItems.CHORUS_FRUIT_SHOVEL.get()) || s.is(ModItems.CHORUS_FRUIT_AXE.get()) || s.is(ModItems.CHORUS_FRUIT_HOE.get()));
    }
    private static boolean isChorusFruitArmor(ItemStack s) {
        return !s.isEmpty() && s.getItem() instanceof ArmorItem a && ModArmorMaterials.CHORUS_FRUIT_ARMOR_MATERIAL.is(a.getMaterial());
    }
    private static boolean isGoldenAppleTool(ItemStack s) {
        return !s.isEmpty() && (s.is(ModItems.GOLDEN_APPLE_SWORD.get()) || s.is(ModItems.GOLDEN_APPLE_PICKAXE.get())
            || s.is(ModItems.GOLDEN_APPLE_SHOVEL.get()) || s.is(ModItems.GOLDEN_APPLE_AXE.get()) || s.is(ModItems.GOLDEN_APPLE_HOE.get()));
    }
    private static boolean isGoldenAppleArmor(ItemStack s) {
        return !s.isEmpty() && s.getItem() instanceof ArmorItem a && ModArmorMaterials.GOLDEN_APPLE_ARMOR_MATERIAL.is(a.getMaterial());
    }

    private static boolean isWearingFullSet(Player player, java.util.function.Predicate<ItemStack> check) {
        return check.test(player.getItemBySlot(EquipmentSlot.HEAD))
            && check.test(player.getItemBySlot(EquipmentSlot.CHEST))
            && check.test(player.getItemBySlot(EquipmentSlot.LEGS))
            && check.test(player.getItemBySlot(EquipmentSlot.FEET));
    }

    // =======================================================================
    // Food set armor effects
    // =======================================================================

    // --- Bread: Boots=Speed, Legs=Jump, Chest=Saturation, Helm=Luck, Full=Hunger immunity ---
    private static void handleBreadArmorEffects(Player player) {
        if (isBreadArmor(player.getItemBySlot(EquipmentSlot.FEET)))
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false, true));
        if (isBreadArmor(player.getItemBySlot(EquipmentSlot.LEGS)))
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 0, false, false, true));
        if (isBreadArmor(player.getItemBySlot(EquipmentSlot.CHEST)))
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 60, 0, false, false, true));
        if (isBreadArmor(player.getItemBySlot(EquipmentSlot.HEAD)))
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 60, 0, false, false, true));
        if (isWearingFullSet(player, ModEvents::isBreadArmor)) {
            player.removeEffect(MobEffects.HUNGER);
        }
    }

    // --- Dried Kelp: Boots=Dolphins Grace, Legs=Haste, Chest=Water Breathing, Helm=Night Vision, Full=Conduit Power ---
    private static void handleDriedKelpArmorEffects(Player player) {
        if (isDriedKelpArmor(player.getItemBySlot(EquipmentSlot.FEET)))
            player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 0, false, false, true));
        if (isDriedKelpArmor(player.getItemBySlot(EquipmentSlot.LEGS)))
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 0, false, false, true));
        if (isDriedKelpArmor(player.getItemBySlot(EquipmentSlot.CHEST)))
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60, 0, false, false, true));
        if (isDriedKelpArmor(player.getItemBySlot(EquipmentSlot.HEAD)))
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 260, 0, false, false, true));
        if (isWearingFullSet(player, ModEvents::isDriedKelpArmor))
            player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 60, 0, false, false, true));
    }

    // --- Rotten Flesh: Boots=Slow Falling, Legs=Fire Resist, Chest=Resistance, Helm=Hunger, Full=Undead neutral (event) ---
    private static void handleRottenFleshArmorEffects(Player player) {
        if (isRottenFleshArmor(player.getItemBySlot(EquipmentSlot.FEET)))
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, false, true));
        if (isRottenFleshArmor(player.getItemBySlot(EquipmentSlot.LEGS)))
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 0, false, false, true));
        if (isRottenFleshArmor(player.getItemBySlot(EquipmentSlot.CHEST)))
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false, true));
        if (isRottenFleshArmor(player.getItemBySlot(EquipmentSlot.HEAD)))
            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 60, 0, false, false, true));
    }

    // --- Melon: Boots=Speed, Legs=Jump, Chest=Regen, Helm=Water Breathing, Full=Passive hunger restore ---
    private static void handleMelonArmorEffects(Player player) {
        if (isMelonArmor(player.getItemBySlot(EquipmentSlot.FEET)))
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false, true));
        if (isMelonArmor(player.getItemBySlot(EquipmentSlot.LEGS)))
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 0, false, false, true));
        if (isMelonArmor(player.getItemBySlot(EquipmentSlot.CHEST)))
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false, true));
        if (isMelonArmor(player.getItemBySlot(EquipmentSlot.HEAD)))
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60, 0, false, false, true));
        if (isWearingFullSet(player, ModEvents::isMelonArmor) && player.tickCount % 60 == 0) {
            player.getFoodData().eat(1, 0.1f);
        }
    }

    // --- Sweet Berries: Boots=Speed, Legs=Jump Boost, Chest=Regen, Helm=Saturation, Full=Thorns (event) ---
    private static void handleSweetBerryArmorEffects(Player player) {
        if (isSweetBerryArmor(player.getItemBySlot(EquipmentSlot.FEET)))
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false, true));
        if (isSweetBerryArmor(player.getItemBySlot(EquipmentSlot.LEGS)))
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 0, false, false, true));
        if (isSweetBerryArmor(player.getItemBySlot(EquipmentSlot.CHEST)))
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false, true));
        if (isSweetBerryArmor(player.getItemBySlot(EquipmentSlot.HEAD)))
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 60, 0, false, false, true));
    }

    // --- Pumpkin Pie: Boots=Speed, Legs=Jump, Chest=Absorption, Helm=Enderman avoid (event), Full=Luck ---
    private static void handlePumpkinPieArmorEffects(Player player) {
        if (isPumpkinPieArmor(player.getItemBySlot(EquipmentSlot.FEET)))
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false, true));
        if (isPumpkinPieArmor(player.getItemBySlot(EquipmentSlot.LEGS)))
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 0, false, false, true));
        if (isPumpkinPieArmor(player.getItemBySlot(EquipmentSlot.CHEST)))
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 60, 0, false, false, true));
        if (isWearingFullSet(player, ModEvents::isPumpkinPieArmor))
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 60, 0, false, false, true));
    }

    // --- Mushroom: Boots=Haste, Legs=Jump, Chest=Resistance, Helm=Night Vision, Full=Nausea aura ---
    private static void handleMushroomArmorEffects(Player player) {
        if (isMushroomArmor(player.getItemBySlot(EquipmentSlot.FEET)))
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 0, false, false, true));
        if (isMushroomArmor(player.getItemBySlot(EquipmentSlot.LEGS)))
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 0, false, false, true));
        if (isMushroomArmor(player.getItemBySlot(EquipmentSlot.CHEST)))
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false, true));
        if (isMushroomArmor(player.getItemBySlot(EquipmentSlot.HEAD)))
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 260, 0, false, false, true));
        if (Config.mushroomSporeCloud && isWearingFullSet(player, ModEvents::isMushroomArmor)
                && player.tickCount % 40 == 0 && player.level() instanceof ServerLevel serverLevel) {
            AABB area = player.getBoundingBox().inflate(4.0);
            for (Mob mob : serverLevel.getEntitiesOfClass(Mob.class, area, m -> m.getTarget() != null)) {
                mob.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0, false, false, false));
            }
        }
    }

    // --- Pufferfish: Boots=Water Breathing, Legs=Resistance, Chest=Poison immunity, Helm=Conduit Power, Full=Poison aura ---
    private static void handlePufferfishArmorEffects(Player player) {
        if (isPufferfishArmor(player.getItemBySlot(EquipmentSlot.FEET)))
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60, 0, false, false, true));
        if (isPufferfishArmor(player.getItemBySlot(EquipmentSlot.LEGS)))
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false, true));
        if (isPufferfishArmor(player.getItemBySlot(EquipmentSlot.CHEST)))
            player.removeEffect(MobEffects.POISON);
        if (isPufferfishArmor(player.getItemBySlot(EquipmentSlot.HEAD)))
            player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 60, 0, false, false, true));
        if (Config.pufferfishPoisonAura && isWearingFullSet(player, ModEvents::isPufferfishArmor)
                && player.tickCount % 40 == 0 && player.level() instanceof ServerLevel serverLevel) {
            AABB area = player.getBoundingBox().inflate(3.0);
            for (Mob mob : serverLevel.getEntitiesOfClass(Mob.class, area, m -> m.getTarget() != null)) {
                mob.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0, false, false, false));
            }
        }
    }

    // --- Honey: Boots=Slow Falling, Legs=Resistance, Chest=Fire Resist, Helm=Poison immunity, Full=Sticky (event) ---
    private static void handleHoneyArmorEffects(Player player) {
        if (isHoneyArmor(player.getItemBySlot(EquipmentSlot.FEET)))
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, false, true));
        if (isHoneyArmor(player.getItemBySlot(EquipmentSlot.LEGS)))
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false, true));
        if (isHoneyArmor(player.getItemBySlot(EquipmentSlot.CHEST)))
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 0, false, false, true));
        if (isHoneyArmor(player.getItemBySlot(EquipmentSlot.HEAD))) {
            player.removeEffect(MobEffects.POISON);
        }
    }

    // --- Chorus Fruit: Boots=Slow Falling, Legs=Speed, Chest=Resistance, Helm=Night Vision, Full=Teleport dodge (event) ---
    private static void handleChorusFruitArmorEffects(Player player) {
        if (isChorusFruitArmor(player.getItemBySlot(EquipmentSlot.FEET)))
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, false, true));
        if (isChorusFruitArmor(player.getItemBySlot(EquipmentSlot.LEGS)))
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false, true));
        if (isChorusFruitArmor(player.getItemBySlot(EquipmentSlot.CHEST)))
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false, true));
        if (isChorusFruitArmor(player.getItemBySlot(EquipmentSlot.HEAD)))
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 260, 0, false, false, true));
    }

    // --- Golden Apple: Boots=Speed, Legs=Resistance, Chest=Regen, Helm=Fire Resist, Full=Absorption II ---
    private static void handleGoldenAppleArmorEffects(Player player) {
        if (isGoldenAppleArmor(player.getItemBySlot(EquipmentSlot.FEET)))
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false, true));
        if (isGoldenAppleArmor(player.getItemBySlot(EquipmentSlot.LEGS)))
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false, true));
        if (isGoldenAppleArmor(player.getItemBySlot(EquipmentSlot.CHEST)))
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, false, true));
        if (isGoldenAppleArmor(player.getItemBySlot(EquipmentSlot.HEAD)))
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 0, false, false, true));
        if (isWearingFullSet(player, ModEvents::isGoldenAppleArmor))
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 60, 1, false, false, true));
    }

    // =======================================================================
    // Food tool-hit effects + armor reactive events (LivingHurtEvent)
    // =======================================================================

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();

        // --- Tool-hit effects (attacker holding food tool) ---
        if (source.getEntity() instanceof Player attacker) {
            ItemStack held = attacker.getMainHandItem();
            if (Config.honeyEnabled && isHoneyTool(held)) {
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0));
            }
            if (Config.pufferfishEnabled && isPufferfishTool(held)) {
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
            }
            if (Config.sweetBerryEnabled && isSweetBerryTool(held)) {
                event.setAmount(event.getAmount() + 1.0f);
            }
            if (Config.rottenFleshEnabled && isRottenFleshTool(held)) {
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 0));
            }
            if (Config.mushroomEnabled && isMushroomTool(held)) {
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 0));
            }
            if (Config.chorusFruitEnabled && Config.chorusFruitTeleport && isChorusFruitTool(held)) {
                if (attacker.level().random.nextFloat() < 0.1f) {
                    teleportRandomly(event.getEntity(), 3, 8);
                }
            }
        }

        // --- Armor reactive effects (player is the target) ---
        if (event.getEntity() instanceof Player victim && source.getEntity() instanceof LivingEntity attacker) {
            // Sweet Berry thorns
            if (Config.sweetBerryEnabled && Config.sweetBerryThorns
                    && isWearingFullSet(victim, ModEvents::isSweetBerryArmor)) {
                attacker.hurt(victim.damageSources().thorns(victim), 1.0f);
            }
            // Honey sticky — attacker gets Slowness II
            if (Config.honeyEnabled && Config.honeySticky
                    && isWearingFullSet(victim, ModEvents::isHoneyArmor)) {
                attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
            }
            // Chorus Fruit teleport dodge — 15% chance
            if (Config.chorusFruitEnabled && Config.chorusFruitTeleport
                    && isWearingFullSet(victim, ModEvents::isChorusFruitArmor)) {
                if (victim.level().random.nextFloat() < 0.15f) {
                    teleportRandomly(victim, 3, 8);
                    event.setCanceled(true);
                }
            }
        }
    }

    // =======================================================================
    // Targeting events (LivingChangeTargetEvent)
    // =======================================================================

    @SubscribeEvent
    public static void onLivingChangeTarget(LivingChangeTargetEvent event) {
        if (!(event.getNewTarget() instanceof Player player)) return;

        // Rotten Flesh full set — undead mobs ignore player
        if (Config.rottenFleshEnabled && Config.rottenFleshUndeadNeutral
                && isWearingFullSet(player, ModEvents::isRottenFleshArmor)) {
            if (event.getEntity() instanceof Zombie || event.getEntity() instanceof AbstractSkeleton
                    || event.getEntity() instanceof Phantom) {
                event.setCanceled(true);
                return;
            }
        }

        // Pumpkin Pie helmet — endermen ignore player
        if (Config.pumpkinPieEnabled && Config.pumpkinPieEndermanAvoidance
                && isPumpkinPieArmor(player.getItemBySlot(EquipmentSlot.HEAD))) {
            if (event.getEntity() instanceof EnderMan) {
                event.setCanceled(true);
            }
        }
    }

    // =======================================================================
    // Utility — random teleport
    // =======================================================================

    private static void teleportRandomly(LivingEntity entity, int minDist, int maxDist) {
        Level level = entity.level();
        if (level.isClientSide()) return;

        for (int attempt = 0; attempt < 16; attempt++) {
            double angle = level.random.nextDouble() * Math.PI * 2;
            double dist = minDist + level.random.nextDouble() * (maxDist - minDist);
            double tx = entity.getX() + Math.cos(angle) * dist;
            double tz = entity.getZ() + Math.sin(angle) * dist;
            double ty = entity.getY();

            BlockPos target = BlockPos.containing(tx, ty, tz);
            // Try to find a safe y
            for (int dy = -2; dy <= 2; dy++) {
                BlockPos check = target.above(dy);
                BlockPos checkHead = check.above();
                if (level.getBlockState(check).getCollisionShape(level, check).isEmpty()
                        && level.getBlockState(checkHead).getCollisionShape(level, checkHead).isEmpty()
                        && !level.getBlockState(check.below()).getCollisionShape(level, check.below()).isEmpty()) {
                    entity.teleportTo(check.getX() + 0.5, check.getY(), check.getZ() + 0.5);
                    if (level instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.PORTAL,
                                entity.getX(), entity.getY() + 1.0, entity.getZ(),
                                32, 0.5, 0.5, 0.5, 0.5);
                    }
                    return;
                }
            }
        }
    }
}
