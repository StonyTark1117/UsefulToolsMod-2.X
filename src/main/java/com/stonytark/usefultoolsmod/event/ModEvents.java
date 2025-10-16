package com.stonytark.usefultoolsmod.event;

import com.stonytark.usefultoolsmod.item.ModArmorMaterials;
import com.stonytark.usefultoolsmod.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        if (player == null || player.isSpectator()) return;

        // Handle tools in both hands
        ItemStack main = player.getMainHandItem();
        ItemStack off = player.getOffhandItem();
        handleToolEffects(player, main);
        handleToolEffects(player, off);

// Handle armor glow
        for (ItemStack armorStack : player.getArmorSlots()) {
            if (armorStack.getItem() instanceof ArmorItem armor) {
                if (ModArmorMaterials.OVERPOWER_ARMOR_MATERIAL.is(armor.getMaterial()) && player.level().isClientSide) {
                    spawnAuraParticles(player.level(), player);
                }
            }
        }


    }

    // --- Tool Effects ---
    private static void handleToolEffects(Player player, ItemStack held) {
        if (held.isEmpty()) return;

        boolean hasEffect = false;

        // Sword
        if (held.is(ModItems.OVERPOWER_SWORD.get())) {
            hasEffect = true;
            applyEffects(player,
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.JUMP, 10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 3, false, false, false));
        }
        // Pickaxe
        else if (held.is(ModItems.OVERPOWER_PICKAXE.get())) {
            hasEffect = true;
            applyEffects(player,
                    new MobEffectInstance(MobEffects.DIG_SPEED, 10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.JUMP, 10, 10, false, false, false));
        }
        // Shovel
        else if (held.is(ModItems.OVERPOWER_SHOVEL.get())) {
            hasEffect = true;
            applyEffects(player,
                    new MobEffectInstance(MobEffects.DIG_SPEED, 10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 1, false, false, false),
                    new MobEffectInstance(MobEffects.JUMP, 10, 5, false, false, false));
        }
        // Axe
        else if (held.is(ModItems.OVERPOWER_AXE.get())) {
            hasEffect = true;
            applyEffects(player,
                    new MobEffectInstance(MobEffects.REGENERATION, 10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 3, false, false, false),
                    new MobEffectInstance(MobEffects.JUMP, 10, 10, false, false, false));
        }

        // Glow for tools
        if (hasEffect && player.level().isClientSide) {
            spawnAuraParticles(player.level(), player);
        }
    }

    // --- Apply hidden potion effects ---
    private static void applyEffects(Player player, MobEffectInstance... effects) {
        for (MobEffectInstance effect : effects) {
            player.addEffect(effect);
        }
    }

    // --- Particle glow aura ---
    private static void spawnAuraParticles(net.minecraft.world.level.Level level, Player player) {
        double radius = 0.5 + level.random.nextDouble() * 0.5;
        double angle = level.random.nextDouble() * Math.PI * 2;
        double x = player.getX() + Math.cos(angle) * radius;
        double y = player.getY() + 1.0 + (level.random.nextDouble() - 0.5) * 0.3;
        double z = player.getZ() + Math.sin(angle) * radius;

        if (level.random.nextBoolean()) {
            level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 0, 0.02, 0);
        } else {
            level.addParticle(ParticleTypes.ENCHANT, x, y, z, 0, 0.01, 0);
        }
    }
}
