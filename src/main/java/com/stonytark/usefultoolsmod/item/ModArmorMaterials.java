package com.stonytark.usefultoolsmod.item;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import com.stonytark.usefultoolsmod.block.ModBlocks;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final Holder<ArmorMaterial> RGOLD_ARMOR_MATERIAL = register("rgold", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 5);
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.BODY, 9);
            }), 25, 2f, 0.1f, () -> ModItems.RGOLD.get());

    public static final Holder<ArmorMaterial> OBSIDIAN_ARMOR_MATERIAL = register("obsidian", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 6);
                attribute.put(ArmorItem.Type.LEGGINGS, 7);
                attribute.put(ArmorItem.Type.CHESTPLATE, 9);
                attribute.put(ArmorItem.Type.HELMET, 6);
                attribute.put(ArmorItem.Type.BODY, 10);
            }), 10, 4f, 0.4f, () -> ModItems.OBINGOT.get());

    public static final Holder<ArmorMaterial> EMERALD_ARMOR_MATERIAL = register("emerald", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 4);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 4);
                attribute.put(ArmorItem.Type.BODY, 9);
            }), 30, 2f, 0.15f, () -> ModItems.SEM.get());

    public static final Holder<ArmorMaterial> OVERPOWER_ARMOR_MATERIAL = register("overpower", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 15);
                attribute.put(ArmorItem.Type.LEGGINGS, 15);
                attribute.put(ArmorItem.Type.CHESTPLATE, 15);
                attribute.put(ArmorItem.Type.HELMET, 15);
                attribute.put(ArmorItem.Type.BODY, 15);
            }), 50, 8f, 1f, () -> ModItems.OBINGOT.get());

    public static final Holder<ArmorMaterial> HRED_ARMOR_MATERIAL = register("hred", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.LEGGINGS, 4);
                attribute.put(ArmorItem.Type.CHESTPLATE, 4);
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.BODY, 6);
            }), 23, 1.1f, 0.08f, () -> ModItems.HRED.get());

    /**
     * Hardened Glowstone — lighter protection than HRED but more enchantable.
     * Toughness and knockback resistance sacrificed for magical affinity.
     * Complement to HRED: HRED for power, HGLOW for utility/enchanting.
     */
    public static final Holder<ArmorMaterial> HGLOW_ARMOR_MATERIAL = register("hglow", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 4);
                attribute.put(ArmorItem.Type.CHESTPLATE, 5);
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.BODY, 6);
            }), 25, 0.0f, 0.0f, () -> ModItems.HGLOW.get());

    public static final Holder<ArmorMaterial> RLAPIS_ARMOR_MATERIAL = register("rlapis", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 4);
                attribute.put(ArmorItem.Type.HELMET, 4);
                attribute.put(ArmorItem.Type.BODY, 8);
            }), 32, 1.6f, 0.15f, () -> ModItems.RLAPIS.get());

    /**
     * Coal armor material — sits between leather and chainmail.
     * Low protection, low durability multiplier.
     */
    public static final Holder<ArmorMaterial> COAL_ARMOR_MATERIAL = register("coal", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 3);
                attribute.put(ArmorItem.Type.HELMET, 1);
                attribute.put(ArmorItem.Type.BODY, 4);
            }), 8, 0f, 0f, () -> ModItems.HARDENED_COAL.get());

    /**
     * Flint-Iron (FNI) armor — slightly less protective than vanilla iron.
     * Iron: boots 2, legs 5, chest 6, helm 2 (total 15). FNI: 1/4/5/2 (total 12).
     * Flint shards are sharp but the assembly is imperfect; enchantability matches iron.
     */
    public static final Holder<ArmorMaterial> FNI_ARMOR_MATERIAL = register("fni", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 4);
                attribute.put(ArmorItem.Type.CHESTPLATE, 5);
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.BODY, 6);
            }), 9, 0.0f, 0.0f, () -> Items.FLINT);

    // ── Crystal / element smooth armor materials (iron-level) ─────────────────
    // Vanilla iron: boots 2, legs 5, chest 6, helm 2 = 15 pts, ×15 multiplier
    // These sit at or just around vanilla iron, below any mod-custom material.

    /** Calcified Amethyst — iron-equivalent protection, higher enchantability. */
    public static final Holder<ArmorMaterial> CAMETHYST_ARMOR_MATERIAL = register("camethyst", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 6);
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.BODY, 7);
            }), 14, 0.5f, 0.0f, () -> ModItems.CALCIFIED_AMETHYST.get());

    /** Glacial (Ice) — below chainmail protection; brittle and temporary. */
    public static final Holder<ArmorMaterial> ICE_ARMOR_MATERIAL = register("ice", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 3);
                attribute.put(ArmorItem.Type.CHESTPLATE, 4);
                attribute.put(ArmorItem.Type.HELMET, 1);
                attribute.put(ArmorItem.Type.BODY, 5);
            }), 8, 0.0f, 0.0f, () -> ModItems.GLACIAL_SHARD.get());

    /** Smooth Quartz — iron-equivalent protection, hardest of the smooth set. */
    public static final Holder<ArmorMaterial> SQUARTZ_ARMOR_MATERIAL = register("squartz", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 6);
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.BODY, 7);
            }), 10, 0.5f, 0.05f, () -> ModItems.POLISHED_QUARTZ.get());

    /** Smooth Prismarine — iron-equivalent protection, ocean-enchanted. */
    public static final Holder<ArmorMaterial> SPRISM_ARMOR_MATERIAL = register("sprism", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 6);
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.BODY, 7);
            }), 12, 0.0f, 0.0f, () -> ModItems.POLISHED_PRISMARINE.get());

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(UsefultoolsMod.MOD_ID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_GENERIC;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}