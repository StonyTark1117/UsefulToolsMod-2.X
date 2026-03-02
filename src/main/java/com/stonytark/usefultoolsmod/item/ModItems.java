package com.stonytark.usefultoolsmod.item;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import com.stonytark.usefultoolsmod.entity.ModEntities;
import com.stonytark.usefultoolsmod.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UsefultoolsMod.MOD_ID);

    public static final RegistryObject<Item> RGOLD = ITEMS.register("rgold",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> RAW_RGOLD = ITEMS.register("raw_rgold",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> OBSHARD = ITEMS.register("obshard",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> SEM = ITEMS.register("sem",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> OBINGOT = ITEMS.register("obingot",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> GRENADE = ITEMS.register("grenade",
            () -> new Grenade(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> HRED = ITEMS.register("hred",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> HGLOW = ITEMS.register("hglow",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> RLAPIS = ITEMS.register("rlapis",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> DYNAMITE = ITEMS.register("dynamite",
                    () -> new Dynamite(new Item.Properties()
                            .stacksTo(16)
                            .fireResistant()  // optional
                    )
            );

    public static final RegistryObject<Item> JEMERALD_SWORD = ITEMS.register("jemerald_sword",
            () -> new SwordItem(ModToolTiers.JEMERALD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.JEMERALD, 3, -2.4f))));
    public static final RegistryObject<Item> JEMERALD_PICKAXE = ITEMS.register("jemerald_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JEMERALD, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.JEMERALD, 1, -2.8f))));
    public static final RegistryObject<Item> JEMERALD_SHOVEL = ITEMS.register("jemerald_shovel",
            () -> new ShovelItem(ModToolTiers.JEMERALD, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.JEMERALD, 1.5f, -3f))));
    public static final RegistryObject<Item> JEMERALD_AXE = ITEMS.register("jemerald_axe",
            () -> new AxeItem(ModToolTiers.JEMERALD, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.JEMERALD, 6, -3.2f))));
    public static final RegistryObject<Item> JEMERALD_HOE = ITEMS.register("jemerald_hoe",
            () -> new HoeItem(ModToolTiers.JEMERALD, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.JEMERALD, 0, -3f))));

    public static final RegistryObject<Item> SEMERALD_SWORD = ITEMS.register("semerald_sword",
            () -> new SwordItem(ModToolTiers.SEMERALD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.SEMERALD, 3, -2.4f))));
    public static final RegistryObject<Item> SEMERALD_PICKAXE = ITEMS.register("semerald_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SEMERALD, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SEMERALD, 1, -2.8f))));
    public static final RegistryObject<Item> SEMERALD_SHOVEL = ITEMS.register("semerald_shovel",
            () -> new ShovelItem(ModToolTiers.SEMERALD, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.SEMERALD, 1.5f, -3f))));
    public static final RegistryObject<Item> SEMERALD_AXE = ITEMS.register("semerald_axe",
            () -> new AxeItem(ModToolTiers.SEMERALD, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.SEMERALD, 6, -3.2f))));
    public static final RegistryObject<Item> SEMERALD_HOE = ITEMS.register("semerald_hoe",
            () -> new HoeItem(ModToolTiers.SEMERALD, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.SEMERALD, 0, -3f))));

    public static final RegistryObject<Item> JOBSIDIAN_SWORD = ITEMS.register("jobsidian_sword",
            () -> new SwordItem(ModToolTiers.JOBSIDIAN, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.JOBSIDIAN, 3, -2.4f))));
    public static final RegistryObject<Item> JOBSIDIAN_PICKAXE = ITEMS.register("jobsidian_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JOBSIDIAN, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.JOBSIDIAN, 1, -2.8f))));
    public static final RegistryObject<Item> JOBSIDIAN_SHOVEL = ITEMS.register("jobsidian_shovel",
            () -> new ShovelItem(ModToolTiers.JOBSIDIAN, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.JOBSIDIAN, 1.5f, -3f))));
    public static final RegistryObject<Item> JOBSIDIAN_AXE = ITEMS.register("jobsidian_axe",
            () -> new AxeItem(ModToolTiers.JOBSIDIAN, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.JOBSIDIAN, 6, -3.2f))));
    public static final RegistryObject<Item> JOBSIDIAN_HOE = ITEMS.register("jobsidian_hoe",
            () -> new HoeItem(ModToolTiers.JOBSIDIAN, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.JOBSIDIAN, 0, -3f))));

    public static final RegistryObject<Item> SOBSIDIAN_SWORD = ITEMS.register("sobsidian_sword",
            () -> new SwordItem(ModToolTiers.SOBSIDIAN, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.SOBSIDIAN, 3, -2.4f))));
    public static final RegistryObject<Item> SOBSIDIAN_PICKAXE = ITEMS.register("sobsidian_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SOBSIDIAN, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SOBSIDIAN, 1, -2.8f))));
    public static final RegistryObject<Item> SOBSIDIAN_SHOVEL = ITEMS.register("sobsidian_shovel",
            () -> new ShovelItem(ModToolTiers.SOBSIDIAN, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.SOBSIDIAN, 1.5f, -3f))));
    public static final RegistryObject<Item> SOBSIDIAN_AXE = ITEMS.register("sobsidian_axe",
            () -> new AxeItem(ModToolTiers.SOBSIDIAN, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.SOBSIDIAN, 6, -3.2f))));
    public static final RegistryObject<Item> SOBSIDIAN_HOE = ITEMS.register("sobsidian_hoe",
            () -> new HoeItem(ModToolTiers.SOBSIDIAN, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.SOBSIDIAN, 0, -3f))));

    public static final RegistryObject<Item> OVERPOWER_SWORD = ITEMS.register("overpower_sword",
            () -> new SwordItem(ModToolTiers.OVERPOWER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.OVERPOWER, 3, -2.4f))));
    public static final RegistryObject<Item> OVERPOWER_PICKAXE = ITEMS.register("overpower_pickaxe",
            () -> new PickaxeItem(ModToolTiers.OVERPOWER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.OVERPOWER, 1, -2.8f))));
    public static final RegistryObject<Item> OVERPOWER_SHOVEL = ITEMS.register("overpower_shovel",
            () -> new ShovelItem(ModToolTiers.OVERPOWER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.OVERPOWER, 1.5f, -3f))));
    public static final RegistryObject<Item> OVERPOWER_AXE = ITEMS.register("overpower_axe",
            () -> new AxeItem(ModToolTiers.OVERPOWER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.OVERPOWER, 6, -3.2f))));


    public static final RegistryObject<Item> HREDSTONE_SWORD = ITEMS.register("hredstone_sword",
            () -> new SwordItem(ModToolTiers.HREDSTONE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.HREDSTONE, 3, -2.4f))));
    public static final RegistryObject<Item> HREDSTONE_PICKAXE = ITEMS.register("hredstone_pickaxe",
            () -> new PickaxeItem(ModToolTiers.HREDSTONE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.HREDSTONE, 1, -2.8f))));
    public static final RegistryObject<Item> HREDSTONE_SHOVEL = ITEMS.register("hredstone_shovel",
            () -> new ShovelItem(ModToolTiers.HREDSTONE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.HREDSTONE, 1.5f, -3f))));
    public static final RegistryObject<Item> HREDSTONE_AXE = ITEMS.register("hredstone_axe",
            () -> new AxeItem(ModToolTiers.HREDSTONE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.HREDSTONE, 6, -3.2f))));
    public static final RegistryObject<Item> HREDSTONE_HOE = ITEMS.register("hredstone_hoe",
            () -> new HoeItem(ModToolTiers.HREDSTONE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.HREDSTONE, 0, -3f))));

    public static final RegistryObject<Item> HGLOWSTONE_SWORD = ITEMS.register("hglowstone_sword",
            () -> new SwordItem(ModToolTiers.HGLOWSTONE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.HGLOWSTONE, 3, -2.4f))));
    public static final RegistryObject<Item> HGLOWSTONE_PICKAXE = ITEMS.register("hglowstone_pickaxe",
            () -> new PickaxeItem(ModToolTiers.HGLOWSTONE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.HGLOWSTONE, 1, -2.8f))));
    public static final RegistryObject<Item> HGLOWSTONE_SHOVEL = ITEMS.register("hglowstone_shovel",
            () -> new ShovelItem(ModToolTiers.HGLOWSTONE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.HGLOWSTONE, 1.5f, -3f))));
    public static final RegistryObject<Item> HGLOWSTONE_AXE = ITEMS.register("hglowstone_axe",
            () -> new AxeItem(ModToolTiers.HGLOWSTONE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.HGLOWSTONE, 6, -3.2f))));
    public static final RegistryObject<Item> HGLOWSTONE_HOE = ITEMS.register("hglowstone_hoe",
            () -> new HoeItem(ModToolTiers.HGLOWSTONE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.HGLOWSTONE, 0, -3f))));

    public static final RegistryObject<Item> RGOLD_SWORD = ITEMS.register("rgold_sword",
            () -> new SwordItem(ModToolTiers.RGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RGOLD, 3, -2.4f))));
    public static final RegistryObject<Item> RGOLD_PICKAXE = ITEMS.register("rgold_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RGOLD, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.RGOLD, 1, -2.8f))));
    public static final RegistryObject<Item> RGOLD_SHOVEL = ITEMS.register("rgold_shovel",
            () -> new ShovelItem(ModToolTiers.RGOLD, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.RGOLD, 1.5f, -3f))));
    public static final RegistryObject<Item> RGOLD_AXE = ITEMS.register("rgold_axe",
            () -> new AxeItem(ModToolTiers.RGOLD, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.RGOLD, 6, -3.2f))));
    public static final RegistryObject<Item> RGOLD_HOE = ITEMS.register("rgold_hoe",
            () -> new HoeItem(ModToolTiers.RGOLD, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.RGOLD, 0, -3f))));

    public static final RegistryObject<Item> RLAPIS_SWORD = ITEMS.register("rlapis_sword",
            () -> new SwordItem(ModToolTiers.RLAPIS, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RLAPIS, 3, -2.4f))));
    public static final RegistryObject<Item> RLAPIS_PICKAXE = ITEMS.register("rlapis_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RLAPIS, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.RLAPIS, 1, -2.8f))));
    public static final RegistryObject<Item> RLAPIS_SHOVEL = ITEMS.register("rlapis_shovel",
            () -> new ShovelItem(ModToolTiers.RLAPIS, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.RLAPIS, 1.5f, -3f))));
    public static final RegistryObject<Item> RLAPIS_AXE = ITEMS.register("rlapis_axe",
            () -> new AxeItem(ModToolTiers.RLAPIS, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.RLAPIS, 6, -3.2f))));
    public static final RegistryObject<Item> RLAPIS_HOE = ITEMS.register("rlapis_hoe",
            () -> new HoeItem(ModToolTiers.RLAPIS, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.RLAPIS, 0, -3f))));

    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet",
            () -> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(33))));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",
            () -> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(33))));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings",
            () -> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(33))));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots",
            () -> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(33))));

    public static final RegistryObject<Item> HRED_HELMET = ITEMS.register("hred_helmet",
            () -> new ArmorItem(ModArmorMaterials.HRED_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(20))));
    public static final RegistryObject<Item> HRED_CHESTPLATE = ITEMS.register("hred_chestplate",
            () -> new ArmorItem(ModArmorMaterials.HRED_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(20))));
    public static final RegistryObject<Item> HRED_LEGGINGS = ITEMS.register("hred_leggings",
            () -> new ArmorItem(ModArmorMaterials.HRED_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(20))));
    public static final RegistryObject<Item> HRED_BOOTS = ITEMS.register("hred_boots",
            () -> new ArmorItem(ModArmorMaterials.HRED_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(20))));

    public static final RegistryObject<Item> HGLOW_HELMET = ITEMS.register("hglow_helmet",
            () -> new ArmorItem(ModArmorMaterials.HGLOW_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));
    public static final RegistryObject<Item> HGLOW_CHESTPLATE = ITEMS.register("hglow_chestplate",
            () -> new ArmorItem(ModArmorMaterials.HGLOW_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> HGLOW_LEGGINGS = ITEMS.register("hglow_leggings",
            () -> new ArmorItem(ModArmorMaterials.HGLOW_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(18))));
    public static final RegistryObject<Item> HGLOW_BOOTS = ITEMS.register("hglow_boots",
            () -> new ArmorItem(ModArmorMaterials.HGLOW_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(18))));

    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(45))));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(45))));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(45))));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(45))));

    public static final RegistryObject<Item> RGOLD_HELMET = ITEMS.register("rgold_helmet",
            () -> new ArmorItem(ModArmorMaterials.RGOLD_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));
    public static final RegistryObject<Item> RGOLD_CHESTPLATE = ITEMS.register("rgold_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RGOLD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> RGOLD_LEGGINGS = ITEMS.register("rgold_leggings",
            () -> new ArmorItem(ModArmorMaterials.RGOLD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(18))));
    public static final RegistryObject<Item> RGOLD_BOOTS = ITEMS.register("rgold_boots",
            () -> new ArmorItem(ModArmorMaterials.RGOLD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(18))));

    public static final RegistryObject<Item> RLAPIS_HELMET = ITEMS.register("rlapis_helmet",
            () -> new ArmorItem(ModArmorMaterials.RLAPIS_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(17))));
    public static final RegistryObject<Item> RLAPIS_CHESTPLATE = ITEMS.register("rlapis_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RLAPIS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(17))));
    public static final RegistryObject<Item> RLAPIS_LEGGINGS = ITEMS.register("rlapis_leggings",
            () -> new ArmorItem(ModArmorMaterials.RLAPIS_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(17))));
    public static final RegistryObject<Item> RLAPIS_BOOTS = ITEMS.register("rlapis_boots",
            () -> new ArmorItem(ModArmorMaterials.RLAPIS_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(17))));

    public static final RegistryObject<Item> OVERPOWER_HELMET = ITEMS.register("overpower_helmet",
            () -> new ModArmorItem(ModArmorMaterials.OVERPOWER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(100))));
    public static final RegistryObject<Item> OVERPOWER_CHESTPLATE = ITEMS.register("overpower_chestplate",
            () -> new ArmorItem(ModArmorMaterials.OVERPOWER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(100))));
    public static final RegistryObject<Item> OVERPOWER_LEGGINGS = ITEMS.register("overpower_leggings",
            () -> new ArmorItem(ModArmorMaterials.OVERPOWER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(100))));
    public static final RegistryObject<Item> OVERPOWER_BOOTS = ITEMS.register("overpower_boots",
            () -> new ArmorItem(ModArmorMaterials.OVERPOWER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(100))));

    public static final RegistryObject<Item> GHOST_SPAWN_EGG = ITEMS.register("ghost_spawn_egg",
            () -> new ForgeSpawnEggItem(() -> ModEntities.GHOST.get(), 0xFFFFFF, 0x999999, new Item.Properties()));

    public static final RegistryObject<Item> ECTOPLASM = ITEMS.register("ectoplasm",
            () -> new Item(new Item.Properties().stacksTo(64)));

    // -------------------------------------------------------------------------
    // Coal material items
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> COAL_DUST = ITEMS.register("coal_dust",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> HARDENED_COAL = ITEMS.register("hardened_coal",
            () -> new Item(new Item.Properties().stacksTo(64)));

    // -------------------------------------------------------------------------
    // Coal tools  (wood mining level, durability ~120, flammable)
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> COAL_SWORD = ITEMS.register("coal_sword",
            () -> new CoalSwordItem(ModToolTiers.COAL_TOOL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.COAL_TOOL, 2, -2.4f))));

    public static final RegistryObject<Item> COAL_PICKAXE = ITEMS.register("coal_pickaxe",
            () -> new CoalPickaxeItem(ModToolTiers.COAL_TOOL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.COAL_TOOL, 1, -2.8f))));

    public static final RegistryObject<Item> COAL_SHOVEL = ITEMS.register("coal_shovel",
            () -> new CoalShovelItem(ModToolTiers.COAL_TOOL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.COAL_TOOL, 1.5f, -3f))));

    public static final RegistryObject<Item> COAL_AXE = ITEMS.register("coal_axe",
            () -> new CoalAxeItem(ModToolTiers.COAL_TOOL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.COAL_TOOL, 5, -3.2f))));

    public static final RegistryObject<Item> COAL_HOE = ITEMS.register("coal_hoe",
            () -> new CoalHoeItem(ModToolTiers.COAL_TOOL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.COAL_TOOL, 0, -3f))));

    // -------------------------------------------------------------------------
    // Coal armor  (between leather and chainmail, flammable)
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> COAL_HELMET = ITEMS.register("coal_helmet",
            () -> new CoalArmorItem(ModArmorMaterials.COAL_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(8))));

    public static final RegistryObject<Item> COAL_CHESTPLATE = ITEMS.register("coal_chestplate",
            () -> new CoalArmorItem(ModArmorMaterials.COAL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(8))));

    public static final RegistryObject<Item> COAL_LEGGINGS = ITEMS.register("coal_leggings",
            () -> new CoalArmorItem(ModArmorMaterials.COAL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(8))));

    public static final RegistryObject<Item> COAL_BOOTS = ITEMS.register("coal_boots",
            () -> new CoalArmorItem(ModArmorMaterials.COAL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(8))));



    // -------------------------------------------------------------------------
    // Raw metal jagged tool sets
    // -------------------------------------------------------------------------

    // Jagged Raw Gold (wood mining level — fast, fragile)
    public static final RegistryObject<Item> JRAW_GOLD_SWORD = ITEMS.register("jraw_gold_sword",
            () -> new SwordItem(ModToolTiers.JRAW_GOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.JRAW_GOLD, 3, -2.4f))));
    public static final RegistryObject<Item> JRAW_GOLD_PICKAXE = ITEMS.register("jraw_gold_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JRAW_GOLD, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.JRAW_GOLD, 1, -2.8f))));
    public static final RegistryObject<Item> JRAW_GOLD_SHOVEL = ITEMS.register("jraw_gold_shovel",
            () -> new ShovelItem(ModToolTiers.JRAW_GOLD, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.JRAW_GOLD, 1.5f, -3f))));
    public static final RegistryObject<Item> JRAW_GOLD_AXE = ITEMS.register("jraw_gold_axe",
            () -> new AxeItem(ModToolTiers.JRAW_GOLD, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.JRAW_GOLD, 6, -3.2f))));
    public static final RegistryObject<Item> JRAW_GOLD_HOE = ITEMS.register("jraw_gold_hoe",
            () -> new HoeItem(ModToolTiers.JRAW_GOLD, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.JRAW_GOLD, 0, -3f))));

    // Jagged Raw Copper (stone mining level)
    public static final RegistryObject<Item> JRAW_COPPER_SWORD = ITEMS.register("jraw_copper_sword",
            () -> new SwordItem(ModToolTiers.JRAW_COPPER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.JRAW_COPPER, 3, -2.4f))));
    public static final RegistryObject<Item> JRAW_COPPER_PICKAXE = ITEMS.register("jraw_copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JRAW_COPPER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.JRAW_COPPER, 1, -2.8f))));
    public static final RegistryObject<Item> JRAW_COPPER_SHOVEL = ITEMS.register("jraw_copper_shovel",
            () -> new ShovelItem(ModToolTiers.JRAW_COPPER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.JRAW_COPPER, 1.5f, -3f))));
    public static final RegistryObject<Item> JRAW_COPPER_AXE = ITEMS.register("jraw_copper_axe",
            () -> new AxeItem(ModToolTiers.JRAW_COPPER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.JRAW_COPPER, 6, -3.2f))));
    public static final RegistryObject<Item> JRAW_COPPER_HOE = ITEMS.register("jraw_copper_hoe",
            () -> new HoeItem(ModToolTiers.JRAW_COPPER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.JRAW_COPPER, 0, -3f))));

    // Jagged Raw Iron (iron mining level)
    public static final RegistryObject<Item> JRAW_IRON_SWORD = ITEMS.register("jraw_iron_sword",
            () -> new SwordItem(ModToolTiers.JRAW_IRON, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.JRAW_IRON, 3, -2.4f))));
    public static final RegistryObject<Item> JRAW_IRON_PICKAXE = ITEMS.register("jraw_iron_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JRAW_IRON, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.JRAW_IRON, 1, -2.8f))));
    public static final RegistryObject<Item> JRAW_IRON_SHOVEL = ITEMS.register("jraw_iron_shovel",
            () -> new ShovelItem(ModToolTiers.JRAW_IRON, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.JRAW_IRON, 1.5f, -3f))));
    public static final RegistryObject<Item> JRAW_IRON_AXE = ITEMS.register("jraw_iron_axe",
            () -> new AxeItem(ModToolTiers.JRAW_IRON, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.JRAW_IRON, 6, -3.2f))));
    public static final RegistryObject<Item> JRAW_IRON_HOE = ITEMS.register("jraw_iron_hoe",
            () -> new HoeItem(ModToolTiers.JRAW_IRON, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.JRAW_IRON, 0, -3f))));

    // Jagged Raw Ferrous Gold (iron mining level)
    public static final RegistryObject<Item> JRAW_RGOLD_SWORD = ITEMS.register("jraw_rgold_sword",
            () -> new SwordItem(ModToolTiers.JRAW_RGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.JRAW_RGOLD, 3, -2.4f))));
    public static final RegistryObject<Item> JRAW_RGOLD_PICKAXE = ITEMS.register("jraw_rgold_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JRAW_RGOLD, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.JRAW_RGOLD, 1, -2.8f))));
    public static final RegistryObject<Item> JRAW_RGOLD_SHOVEL = ITEMS.register("jraw_rgold_shovel",
            () -> new ShovelItem(ModToolTiers.JRAW_RGOLD, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.JRAW_RGOLD, 1.5f, -3f))));
    public static final RegistryObject<Item> JRAW_RGOLD_AXE = ITEMS.register("jraw_rgold_axe",
            () -> new AxeItem(ModToolTiers.JRAW_RGOLD, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.JRAW_RGOLD, 6, -3.2f))));
    public static final RegistryObject<Item> JRAW_RGOLD_HOE = ITEMS.register("jraw_rgold_hoe",
            () -> new HoeItem(ModToolTiers.JRAW_RGOLD, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.JRAW_RGOLD, 0, -3f))));

    // Jagged Netherite Scrap (diamond mining level)
    public static final RegistryObject<Item> JSCRAP_SWORD = ITEMS.register("jscrap_sword",
            () -> new SwordItem(ModToolTiers.JSCRAP, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.JSCRAP, 3, -2.4f))));
    public static final RegistryObject<Item> JSCRAP_PICKAXE = ITEMS.register("jscrap_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JSCRAP, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.JSCRAP, 1, -2.8f))));
    public static final RegistryObject<Item> JSCRAP_SHOVEL = ITEMS.register("jscrap_shovel",
            () -> new ShovelItem(ModToolTiers.JSCRAP, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.JSCRAP, 1.5f, -3f))));
    public static final RegistryObject<Item> JSCRAP_AXE = ITEMS.register("jscrap_axe",
            () -> new AxeItem(ModToolTiers.JSCRAP, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.JSCRAP, 6, -3.2f))));
    public static final RegistryObject<Item> JSCRAP_HOE = ITEMS.register("jscrap_hoe",
            () -> new HoeItem(ModToolTiers.JSCRAP, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.JSCRAP, 0, -3f))));

    // -------------------------------------------------------------------------
    // Crystal / element material items
    // -------------------------------------------------------------------------

    public static final RegistryObject<Item> CALCIFIED_AMETHYST = ITEMS.register("calcified_amethyst",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> GLACIAL_SHARD = ITEMS.register("glacial_shard",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> POLISHED_QUARTZ = ITEMS.register("polished_quartz",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> POLISHED_PRISMARINE = ITEMS.register("polished_prismarine",
            () -> new Item(new Item.Properties().stacksTo(64)));

    // -------------------------------------------------------------------------
    // Jagged Amethyst tools (iron mining level)
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> JAMETHYST_SWORD = ITEMS.register("jamethyst_sword",
            () -> new SwordItem(ModToolTiers.JAMETHYST, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.JAMETHYST, 3, -2.4f))));
    public static final RegistryObject<Item> JAMETHYST_PICKAXE = ITEMS.register("jamethyst_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JAMETHYST, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.JAMETHYST, 1, -2.8f))));
    public static final RegistryObject<Item> JAMETHYST_SHOVEL = ITEMS.register("jamethyst_shovel",
            () -> new ShovelItem(ModToolTiers.JAMETHYST, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.JAMETHYST, 1.5f, -3f))));
    public static final RegistryObject<Item> JAMETHYST_AXE = ITEMS.register("jamethyst_axe",
            () -> new AxeItem(ModToolTiers.JAMETHYST, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.JAMETHYST, 6, -3.2f))));
    public static final RegistryObject<Item> JAMETHYST_HOE = ITEMS.register("jamethyst_hoe",
            () -> new HoeItem(ModToolTiers.JAMETHYST, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.JAMETHYST, 0, -3f))));

    // -------------------------------------------------------------------------
    // Snow tools (stone mining level)
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> SNOW_SWORD = ITEMS.register("snow_sword",
            () -> new SwordItem(ModToolTiers.SNOW_TOOL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.SNOW_TOOL, 3, -2.4f))));
    public static final RegistryObject<Item> SNOW_PICKAXE = ITEMS.register("snow_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SNOW_TOOL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SNOW_TOOL, 1, -2.8f))));
    public static final RegistryObject<Item> SNOW_SHOVEL = ITEMS.register("snow_shovel",
            () -> new ShovelItem(ModToolTiers.SNOW_TOOL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.SNOW_TOOL, 1.5f, -3f))));
    public static final RegistryObject<Item> SNOW_AXE = ITEMS.register("snow_axe",
            () -> new AxeItem(ModToolTiers.SNOW_TOOL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.SNOW_TOOL, 6, -3.2f))));
    public static final RegistryObject<Item> SNOW_HOE = ITEMS.register("snow_hoe",
            () -> new HoeItem(ModToolTiers.SNOW_TOOL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.SNOW_TOOL, 0, -3f))));

    // -------------------------------------------------------------------------
    // Jagged Quartz tools (iron mining level)
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> JQUARTZ_SWORD = ITEMS.register("jquartz_sword",
            () -> new SwordItem(ModToolTiers.JQUARTZ, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.JQUARTZ, 3, -2.4f))));
    public static final RegistryObject<Item> JQUARTZ_PICKAXE = ITEMS.register("jquartz_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JQUARTZ, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.JQUARTZ, 1, -2.8f))));
    public static final RegistryObject<Item> JQUARTZ_SHOVEL = ITEMS.register("jquartz_shovel",
            () -> new ShovelItem(ModToolTiers.JQUARTZ, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.JQUARTZ, 1.5f, -3f))));
    public static final RegistryObject<Item> JQUARTZ_AXE = ITEMS.register("jquartz_axe",
            () -> new AxeItem(ModToolTiers.JQUARTZ, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.JQUARTZ, 6, -3.2f))));
    public static final RegistryObject<Item> JQUARTZ_HOE = ITEMS.register("jquartz_hoe",
            () -> new HoeItem(ModToolTiers.JQUARTZ, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.JQUARTZ, 0, -3f))));

    // -------------------------------------------------------------------------
    // Jagged Prismarine tools (iron mining level)
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> JPRISM_SWORD = ITEMS.register("jprism_sword",
            () -> new SwordItem(ModToolTiers.JPRISM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.JPRISM, 3, -2.4f))));
    public static final RegistryObject<Item> JPRISM_PICKAXE = ITEMS.register("jprism_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JPRISM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.JPRISM, 1, -2.8f))));
    public static final RegistryObject<Item> JPRISM_SHOVEL = ITEMS.register("jprism_shovel",
            () -> new ShovelItem(ModToolTiers.JPRISM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.JPRISM, 1.5f, -3f))));
    public static final RegistryObject<Item> JPRISM_AXE = ITEMS.register("jprism_axe",
            () -> new AxeItem(ModToolTiers.JPRISM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.JPRISM, 6, -3.2f))));
    public static final RegistryObject<Item> JPRISM_HOE = ITEMS.register("jprism_hoe",
            () -> new HoeItem(ModToolTiers.JPRISM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.JPRISM, 0, -3f))));

    // -------------------------------------------------------------------------
    // Calcified Amethyst tools (iron mining level)
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> CAMETHYST_SWORD = ITEMS.register("camethyst_sword",
            () -> new SwordItem(ModToolTiers.CAMETHYST, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.CAMETHYST, 3, -2.4f))));
    public static final RegistryObject<Item> CAMETHYST_PICKAXE = ITEMS.register("camethyst_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CAMETHYST, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CAMETHYST, 1, -2.8f))));
    public static final RegistryObject<Item> CAMETHYST_SHOVEL = ITEMS.register("camethyst_shovel",
            () -> new ShovelItem(ModToolTiers.CAMETHYST, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CAMETHYST, 1.5f, -3f))));
    public static final RegistryObject<Item> CAMETHYST_AXE = ITEMS.register("camethyst_axe",
            () -> new AxeItem(ModToolTiers.CAMETHYST, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CAMETHYST, 6, -3.2f))));
    public static final RegistryObject<Item> CAMETHYST_HOE = ITEMS.register("camethyst_hoe",
            () -> new HoeItem(ModToolTiers.CAMETHYST, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CAMETHYST, 0, -3f))));
    public static final RegistryObject<Item> CAMETHYST_HELMET = ITEMS.register("camethyst_helmet",
            () -> new ArmorItem(ModArmorMaterials.CAMETHYST_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))));
    public static final RegistryObject<Item> CAMETHYST_CHESTPLATE = ITEMS.register("camethyst_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CAMETHYST_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))));
    public static final RegistryObject<Item> CAMETHYST_LEGGINGS = ITEMS.register("camethyst_leggings",
            () -> new ArmorItem(ModArmorMaterials.CAMETHYST_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final RegistryObject<Item> CAMETHYST_BOOTS = ITEMS.register("camethyst_boots",
            () -> new ArmorItem(ModArmorMaterials.CAMETHYST_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15))));

    // -------------------------------------------------------------------------
    // Ice (Glacial) tools (diamond mining level)
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> ICE_SWORD = ITEMS.register("ice_sword",
            () -> new SwordItem(ModToolTiers.ICE_TOOL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ICE_TOOL, 3, -2.4f))));
    public static final RegistryObject<Item> ICE_PICKAXE = ITEMS.register("ice_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ICE_TOOL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ICE_TOOL, 1, -2.8f))));
    public static final RegistryObject<Item> ICE_SHOVEL = ITEMS.register("ice_shovel",
            () -> new ShovelItem(ModToolTiers.ICE_TOOL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ICE_TOOL, 1.5f, -3f))));
    public static final RegistryObject<Item> ICE_AXE = ITEMS.register("ice_axe",
            () -> new AxeItem(ModToolTiers.ICE_TOOL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ICE_TOOL, 6, -3.2f))));
    public static final RegistryObject<Item> ICE_HOE = ITEMS.register("ice_hoe",
            () -> new HoeItem(ModToolTiers.ICE_TOOL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ICE_TOOL, 0, -3f))));
    public static final RegistryObject<Item> ICE_HELMET = ITEMS.register("ice_helmet",
            () -> new ArmorItem(ModArmorMaterials.ICE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(10))));
    public static final RegistryObject<Item> ICE_CHESTPLATE = ITEMS.register("ice_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ICE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(10))));
    public static final RegistryObject<Item> ICE_LEGGINGS = ITEMS.register("ice_leggings",
            () -> new ArmorItem(ModArmorMaterials.ICE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(10))));
    public static final RegistryObject<Item> ICE_BOOTS = ITEMS.register("ice_boots",
            () -> new ArmorItem(ModArmorMaterials.ICE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(10))));

    // -------------------------------------------------------------------------
    // Smooth Quartz tools (diamond mining level)
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> SQUARTZ_SWORD = ITEMS.register("squartz_sword",
            () -> new SwordItem(ModToolTiers.SQUARTZ, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.SQUARTZ, 3, -2.4f))));
    public static final RegistryObject<Item> SQUARTZ_PICKAXE = ITEMS.register("squartz_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SQUARTZ, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SQUARTZ, 1, -2.8f))));
    public static final RegistryObject<Item> SQUARTZ_SHOVEL = ITEMS.register("squartz_shovel",
            () -> new ShovelItem(ModToolTiers.SQUARTZ, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.SQUARTZ, 1.5f, -3f))));
    public static final RegistryObject<Item> SQUARTZ_AXE = ITEMS.register("squartz_axe",
            () -> new AxeItem(ModToolTiers.SQUARTZ, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.SQUARTZ, 6, -3.2f))));
    public static final RegistryObject<Item> SQUARTZ_HOE = ITEMS.register("squartz_hoe",
            () -> new HoeItem(ModToolTiers.SQUARTZ, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.SQUARTZ, 0, -3f))));
    public static final RegistryObject<Item> SQUARTZ_HELMET = ITEMS.register("squartz_helmet",
            () -> new ArmorItem(ModArmorMaterials.SQUARTZ_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(16))));
    public static final RegistryObject<Item> SQUARTZ_CHESTPLATE = ITEMS.register("squartz_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SQUARTZ_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(16))));
    public static final RegistryObject<Item> SQUARTZ_LEGGINGS = ITEMS.register("squartz_leggings",
            () -> new ArmorItem(ModArmorMaterials.SQUARTZ_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(16))));
    public static final RegistryObject<Item> SQUARTZ_BOOTS = ITEMS.register("squartz_boots",
            () -> new ArmorItem(ModArmorMaterials.SQUARTZ_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(16))));

    // -------------------------------------------------------------------------
    // Smooth Prismarine tools (diamond mining level)
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> SPRISM_SWORD = ITEMS.register("sprism_sword",
            () -> new SwordItem(ModToolTiers.SPRISM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.SPRISM, 3, -2.4f))));
    public static final RegistryObject<Item> SPRISM_PICKAXE = ITEMS.register("sprism_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SPRISM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SPRISM, 1, -2.8f))));
    public static final RegistryObject<Item> SPRISM_SHOVEL = ITEMS.register("sprism_shovel",
            () -> new ShovelItem(ModToolTiers.SPRISM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.SPRISM, 1.5f, -3f))));
    public static final RegistryObject<Item> SPRISM_AXE = ITEMS.register("sprism_axe",
            () -> new AxeItem(ModToolTiers.SPRISM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.SPRISM, 6, -3.2f))));
    public static final RegistryObject<Item> SPRISM_HOE = ITEMS.register("sprism_hoe",
            () -> new HoeItem(ModToolTiers.SPRISM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.SPRISM, 0, -3f))));
    public static final RegistryObject<Item> SPRISM_HELMET = ITEMS.register("sprism_helmet",
            () -> new ArmorItem(ModArmorMaterials.SPRISM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(14))));
    public static final RegistryObject<Item> SPRISM_CHESTPLATE = ITEMS.register("sprism_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SPRISM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(14))));
    public static final RegistryObject<Item> SPRISM_LEGGINGS = ITEMS.register("sprism_leggings",
            () -> new ArmorItem(ModArmorMaterials.SPRISM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(14))));
    public static final RegistryObject<Item> SPRISM_BOOTS = ITEMS.register("sprism_boots",
            () -> new ArmorItem(ModArmorMaterials.SPRISM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(14))));

    // -------------------------------------------------------------------------
    // Flint Tools (jagged, stone level)
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> JFLINT_SWORD = ITEMS.register("jflint_sword",
            () -> new SwordItem(ModToolTiers.JFLINT, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.JFLINT, 3, -2.4f))));
    public static final RegistryObject<Item> JFLINT_PICKAXE = ITEMS.register("jflint_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JFLINT, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.JFLINT, 1, -2.8f))));
    public static final RegistryObject<Item> JFLINT_SHOVEL = ITEMS.register("jflint_shovel",
            () -> new ShovelItem(ModToolTiers.JFLINT, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.JFLINT, 1.5f, -3f))));
    public static final RegistryObject<Item> JFLINT_AXE = ITEMS.register("jflint_axe",
            () -> new AxeItem(ModToolTiers.JFLINT, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.JFLINT, 6, -3.2f))));
    public static final RegistryObject<Item> JFLINT_HOE = ITEMS.register("jflint_hoe",
            () -> new HoeItem(ModToolTiers.JFLINT, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.JFLINT, 0, -3f))));

    // -------------------------------------------------------------------------
    // Flint-Iron (FNI) Tools + Armor
    // -------------------------------------------------------------------------
    public static final RegistryObject<Item> FNI_SWORD = ITEMS.register("fni_sword",
            () -> new SwordItem(ModToolTiers.FNI_TOOLS, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.FNI_TOOLS, 3, -2.4f))));
    public static final RegistryObject<Item> FNI_PICKAXE = ITEMS.register("fni_pickaxe",
            () -> new PickaxeItem(ModToolTiers.FNI_TOOLS, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.FNI_TOOLS, 1, -2.8f))));
    public static final RegistryObject<Item> FNI_SHOVEL = ITEMS.register("fni_shovel",
            () -> new ShovelItem(ModToolTiers.FNI_TOOLS, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.FNI_TOOLS, 1.5f, -3f))));
    public static final RegistryObject<Item> FNI_AXE = ITEMS.register("fni_axe",
            () -> new AxeItem(ModToolTiers.FNI_TOOLS, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.FNI_TOOLS, 6, -3.2f))));
    public static final RegistryObject<Item> FNI_HOE = ITEMS.register("fni_hoe",
            () -> new HoeItem(ModToolTiers.FNI_TOOLS, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.FNI_TOOLS, 0, -3f))));

    public static final RegistryObject<Item> FNI_HELMET = ITEMS.register("fni_helmet",
            () -> new ArmorItem(ModArmorMaterials.FNI_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(13))));
    public static final RegistryObject<Item> FNI_CHESTPLATE = ITEMS.register("fni_chestplate",
            () -> new ArmorItem(ModArmorMaterials.FNI_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(13))));
    public static final RegistryObject<Item> FNI_LEGGINGS = ITEMS.register("fni_leggings",
            () -> new ArmorItem(ModArmorMaterials.FNI_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(13))));
    public static final RegistryObject<Item> FNI_BOOTS = ITEMS.register("fni_boots",
            () -> new ArmorItem(ModArmorMaterials.FNI_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(13))));

    // -------------------------------------------------------------------------
    // Stone Rock Variant Tools (13 types × 5 tools, each with its own tier)
    // -------------------------------------------------------------------------

    // Andesite — vanilla stone baseline
    public static final RegistryObject<Item> ANDESITE_SWORD = ITEMS.register("andesite_sword",
            () -> new SwordItem(ModToolTiers.STONE_ANDESITE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_ANDESITE, 3, -2.4f))));
    public static final RegistryObject<Item> ANDESITE_PICKAXE = ITEMS.register("andesite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_ANDESITE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_ANDESITE, 1, -2.8f))));
    public static final RegistryObject<Item> ANDESITE_SHOVEL = ITEMS.register("andesite_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_ANDESITE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_ANDESITE, 1.5f, -3f))));
    public static final RegistryObject<Item> ANDESITE_AXE = ITEMS.register("andesite_axe",
            () -> new AxeItem(ModToolTiers.STONE_ANDESITE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_ANDESITE, 6, -3.2f))));
    public static final RegistryObject<Item> ANDESITE_HOE = ITEMS.register("andesite_hoe",
            () -> new HoeItem(ModToolTiers.STONE_ANDESITE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_ANDESITE, 0, -3f))));

    // Basalt — dense, durable, slow: heavy swing, harder axe/shovel
    public static final RegistryObject<Item> BASALT_SWORD = ITEMS.register("basalt_sword",
            () -> new SwordItem(ModToolTiers.STONE_BASALT, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_BASALT, 3, -2.5f))));
    public static final RegistryObject<Item> BASALT_PICKAXE = ITEMS.register("basalt_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_BASALT, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_BASALT, 1, -2.9f))));
    public static final RegistryObject<Item> BASALT_SHOVEL = ITEMS.register("basalt_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_BASALT, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_BASALT, 2.0f, -3.1f))));
    public static final RegistryObject<Item> BASALT_AXE = ITEMS.register("basalt_axe",
            () -> new AxeItem(ModToolTiers.STONE_BASALT, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_BASALT, 7, -3.3f))));
    public static final RegistryObject<Item> BASALT_HOE = ITEMS.register("basalt_hoe",
            () -> new HoeItem(ModToolTiers.STONE_BASALT, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_BASALT, 0, -3.1f))));

    // Blackstone — toughest stone variant: heavy swing, hardest hits
    public static final RegistryObject<Item> BLACKSTONE_SWORD = ITEMS.register("blackstone_sword",
            () -> new SwordItem(ModToolTiers.STONE_BLACKSTONE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_BLACKSTONE, 4, -2.5f))));
    public static final RegistryObject<Item> BLACKSTONE_PICKAXE = ITEMS.register("blackstone_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_BLACKSTONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_BLACKSTONE, 1, -2.9f))));
    public static final RegistryObject<Item> BLACKSTONE_SHOVEL = ITEMS.register("blackstone_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_BLACKSTONE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_BLACKSTONE, 2.0f, -3.1f))));
    public static final RegistryObject<Item> BLACKSTONE_AXE = ITEMS.register("blackstone_axe",
            () -> new AxeItem(ModToolTiers.STONE_BLACKSTONE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_BLACKSTONE, 7, -3.35f))));
    public static final RegistryObject<Item> BLACKSTONE_HOE = ITEMS.register("blackstone_hoe",
            () -> new HoeItem(ModToolTiers.STONE_BLACKSTONE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_BLACKSTONE, 0, -3.1f))));

    // Calcite — fragile, light, enchantable: fast swing, weaker hits
    public static final RegistryObject<Item> CALCITE_SWORD = ITEMS.register("calcite_sword",
            () -> new SwordItem(ModToolTiers.STONE_CALCITE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_CALCITE, 2, -2.2f))));
    public static final RegistryObject<Item> CALCITE_PICKAXE = ITEMS.register("calcite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_CALCITE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_CALCITE, 1, -2.6f))));
    public static final RegistryObject<Item> CALCITE_SHOVEL = ITEMS.register("calcite_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_CALCITE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_CALCITE, 1.0f, -2.8f))));
    public static final RegistryObject<Item> CALCITE_AXE = ITEMS.register("calcite_axe",
            () -> new AxeItem(ModToolTiers.STONE_CALCITE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_CALCITE, 5, -3.0f))));
    public static final RegistryObject<Item> CALCITE_HOE = ITEMS.register("calcite_hoe",
            () -> new HoeItem(ModToolTiers.STONE_CALCITE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_CALCITE, 0, -2.6f))));

    // Deepslate — most durable stone variant, sluggish: heaviest swing, big hits
    public static final RegistryObject<Item> DEEPSLATE_SWORD = ITEMS.register("deepslate_sword",
            () -> new SwordItem(ModToolTiers.STONE_DEEPSLATE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_DEEPSLATE, 4, -2.55f))));
    public static final RegistryObject<Item> DEEPSLATE_PICKAXE = ITEMS.register("deepslate_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_DEEPSLATE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_DEEPSLATE, 1, -2.95f))));
    public static final RegistryObject<Item> DEEPSLATE_SHOVEL = ITEMS.register("deepslate_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_DEEPSLATE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_DEEPSLATE, 2.0f, -3.15f))));
    public static final RegistryObject<Item> DEEPSLATE_AXE = ITEMS.register("deepslate_axe",
            () -> new AxeItem(ModToolTiers.STONE_DEEPSLATE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_DEEPSLATE, 7, -3.4f))));
    public static final RegistryObject<Item> DEEPSLATE_HOE = ITEMS.register("deepslate_hoe",
            () -> new HoeItem(ModToolTiers.STONE_DEEPSLATE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_DEEPSLATE, 0, -3.1f))));

    // Diorite — slightly better all-round than andesite: marginally faster hoe
    public static final RegistryObject<Item> DIORITE_SWORD = ITEMS.register("diorite_sword",
            () -> new SwordItem(ModToolTiers.STONE_DIORITE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_DIORITE, 3, -2.4f))));
    public static final RegistryObject<Item> DIORITE_PICKAXE = ITEMS.register("diorite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_DIORITE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_DIORITE, 1, -2.8f))));
    public static final RegistryObject<Item> DIORITE_SHOVEL = ITEMS.register("diorite_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_DIORITE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_DIORITE, 1.5f, -3f))));
    public static final RegistryObject<Item> DIORITE_AXE = ITEMS.register("diorite_axe",
            () -> new AxeItem(ModToolTiers.STONE_DIORITE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_DIORITE, 6, -3.2f))));
    public static final RegistryObject<Item> DIORITE_HOE = ITEMS.register("diorite_hoe",
            () -> new HoeItem(ModToolTiers.STONE_DIORITE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_DIORITE, 0, -2.9f))));

    // End Stone — hard alien material, highly enchantable: slightly faster across the board
    public static final RegistryObject<Item> END_STONE_SWORD = ITEMS.register("end_stone_sword",
            () -> new SwordItem(ModToolTiers.STONE_END_STONE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_END_STONE, 3, -2.35f))));
    public static final RegistryObject<Item> END_STONE_PICKAXE = ITEMS.register("end_stone_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_END_STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_END_STONE, 1, -2.75f))));
    public static final RegistryObject<Item> END_STONE_SHOVEL = ITEMS.register("end_stone_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_END_STONE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_END_STONE, 1.5f, -2.95f))));
    public static final RegistryObject<Item> END_STONE_AXE = ITEMS.register("end_stone_axe",
            () -> new AxeItem(ModToolTiers.STONE_END_STONE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_END_STONE, 6, -3.15f))));
    public static final RegistryObject<Item> END_STONE_HOE = ITEMS.register("end_stone_hoe",
            () -> new HoeItem(ModToolTiers.STONE_END_STONE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_END_STONE, 0, -2.8f))));

    // Granite — hard igneous, strong and heavy: heavy swing, harder axe/shovel
    public static final RegistryObject<Item> GRANITE_SWORD = ITEMS.register("granite_sword",
            () -> new SwordItem(ModToolTiers.STONE_GRANITE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_GRANITE, 3, -2.5f))));
    public static final RegistryObject<Item> GRANITE_PICKAXE = ITEMS.register("granite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_GRANITE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_GRANITE, 1, -2.9f))));
    public static final RegistryObject<Item> GRANITE_SHOVEL = ITEMS.register("granite_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_GRANITE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_GRANITE, 2.0f, -3.1f))));
    public static final RegistryObject<Item> GRANITE_AXE = ITEMS.register("granite_axe",
            () -> new AxeItem(ModToolTiers.STONE_GRANITE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_GRANITE, 7, -3.3f))));
    public static final RegistryObject<Item> GRANITE_HOE = ITEMS.register("granite_hoe",
            () -> new HoeItem(ModToolTiers.STONE_GRANITE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_GRANITE, 0, -3.1f))));

    // Netherrack — crumbly, barely functional, extremely fast: fastest swing, weakest hits
    public static final RegistryObject<Item> NETHERRACK_SWORD = ITEMS.register("netherrack_sword",
            () -> new SwordItem(ModToolTiers.STONE_NETHERRACK, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_NETHERRACK, 2, -2.2f))));
    public static final RegistryObject<Item> NETHERRACK_PICKAXE = ITEMS.register("netherrack_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_NETHERRACK, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_NETHERRACK, 1, -2.6f))));
    public static final RegistryObject<Item> NETHERRACK_SHOVEL = ITEMS.register("netherrack_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_NETHERRACK, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_NETHERRACK, 1.0f, -2.8f))));
    public static final RegistryObject<Item> NETHERRACK_AXE = ITEMS.register("netherrack_axe",
            () -> new AxeItem(ModToolTiers.STONE_NETHERRACK, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_NETHERRACK, 5, -3.0f))));
    public static final RegistryObject<Item> NETHERRACK_HOE = ITEMS.register("netherrack_hoe",
            () -> new HoeItem(ModToolTiers.STONE_NETHERRACK, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_NETHERRACK, 0, -2.5f))));

    // Sandstone — soft sedimentary, brittle but quick: light swing, weaker hits
    public static final RegistryObject<Item> SANDSTONE_SWORD = ITEMS.register("sandstone_sword",
            () -> new SwordItem(ModToolTiers.STONE_SANDSTONE, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_SANDSTONE, 2, -2.3f))));
    public static final RegistryObject<Item> SANDSTONE_PICKAXE = ITEMS.register("sandstone_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_SANDSTONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_SANDSTONE, 1, -2.7f))));
    public static final RegistryObject<Item> SANDSTONE_SHOVEL = ITEMS.register("sandstone_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_SANDSTONE, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_SANDSTONE, 1.0f, -2.9f))));
    public static final RegistryObject<Item> SANDSTONE_AXE = ITEMS.register("sandstone_axe",
            () -> new AxeItem(ModToolTiers.STONE_SANDSTONE, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_SANDSTONE, 5, -3.1f))));
    public static final RegistryObject<Item> SANDSTONE_HOE = ITEMS.register("sandstone_hoe",
            () -> new HoeItem(ModToolTiers.STONE_SANDSTONE, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_SANDSTONE, 0, -2.7f))));

    // Smooth Basalt — polished volcanic, balanced between basalt and andesite: slightly heavy
    public static final RegistryObject<Item> SMOOTH_BASALT_SWORD = ITEMS.register("smooth_basalt_sword",
            () -> new SwordItem(ModToolTiers.STONE_SMOOTH_BASALT, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_SMOOTH_BASALT, 3, -2.45f))));
    public static final RegistryObject<Item> SMOOTH_BASALT_PICKAXE = ITEMS.register("smooth_basalt_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_SMOOTH_BASALT, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_SMOOTH_BASALT, 1, -2.85f))));
    public static final RegistryObject<Item> SMOOTH_BASALT_SHOVEL = ITEMS.register("smooth_basalt_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_SMOOTH_BASALT, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_SMOOTH_BASALT, 1.5f, -3.05f))));
    public static final RegistryObject<Item> SMOOTH_BASALT_AXE = ITEMS.register("smooth_basalt_axe",
            () -> new AxeItem(ModToolTiers.STONE_SMOOTH_BASALT, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_SMOOTH_BASALT, 6, -3.25f))));
    public static final RegistryObject<Item> SMOOTH_BASALT_HOE = ITEMS.register("smooth_basalt_hoe",
            () -> new HoeItem(ModToolTiers.STONE_SMOOTH_BASALT, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_SMOOTH_BASALT, 0, -3.0f))));

    // Terracotta — baked clay, moderate with better enchantability: slightly faster, lighter
    public static final RegistryObject<Item> TERRACOTTA_SWORD = ITEMS.register("terracotta_sword",
            () -> new SwordItem(ModToolTiers.STONE_TERRACOTTA, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_TERRACOTTA, 3, -2.35f))));
    public static final RegistryObject<Item> TERRACOTTA_PICKAXE = ITEMS.register("terracotta_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_TERRACOTTA, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_TERRACOTTA, 1, -2.75f))));
    public static final RegistryObject<Item> TERRACOTTA_SHOVEL = ITEMS.register("terracotta_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_TERRACOTTA, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_TERRACOTTA, 1.5f, -2.95f))));
    public static final RegistryObject<Item> TERRACOTTA_AXE = ITEMS.register("terracotta_axe",
            () -> new AxeItem(ModToolTiers.STONE_TERRACOTTA, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_TERRACOTTA, 6, -3.15f))));
    public static final RegistryObject<Item> TERRACOTTA_HOE = ITEMS.register("terracotta_hoe",
            () -> new HoeItem(ModToolTiers.STONE_TERRACOTTA, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_TERRACOTTA, 0, -2.8f))));

    // Tuff — compressed volcanic ash, below-average overall: slightly faster, slightly weaker
    public static final RegistryObject<Item> TUFF_SWORD = ITEMS.register("tuff_sword",
            () -> new SwordItem(ModToolTiers.STONE_TUFF, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.STONE_TUFF, 2, -2.35f))));
    public static final RegistryObject<Item> TUFF_PICKAXE = ITEMS.register("tuff_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_TUFF, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_TUFF, 1, -2.75f))));
    public static final RegistryObject<Item> TUFF_SHOVEL = ITEMS.register("tuff_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_TUFF, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.STONE_TUFF, 1.5f, -2.95f))));
    public static final RegistryObject<Item> TUFF_AXE = ITEMS.register("tuff_axe",
            () -> new AxeItem(ModToolTiers.STONE_TUFF, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.STONE_TUFF, 5, -3.15f))));
    public static final RegistryObject<Item> TUFF_HOE = ITEMS.register("tuff_hoe",
            () -> new HoeItem(ModToolTiers.STONE_TUFF, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.STONE_TUFF, 0, -2.8f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
