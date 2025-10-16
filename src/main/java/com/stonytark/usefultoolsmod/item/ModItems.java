package com.stonytark.usefultoolsmod.item;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import com.stonytark.usefultoolsmod.entity.ModEntities;
import com.stonytark.usefultoolsmod.item.custom.Dynamite;
import com.stonytark.usefultoolsmod.item.custom.Grenade;
import com.stonytark.usefultoolsmod.item.custom.ModArmorItem;
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



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
