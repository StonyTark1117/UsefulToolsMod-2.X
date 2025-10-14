package com.stonytark.usefultoolsmod.datagen;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import com.stonytark.usefultoolsmod.block.ModBlocks;
import com.stonytark.usefultoolsmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;


public class ModItemModelProvider extends ItemModelProvider {

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UsefultoolsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RGOLD.get());
        basicItem(ModItems.OBSHARD.get());
        basicItem(ModItems.OBINGOT.get());
        basicItem(ModItems.HRED.get());
        basicItem(ModItems.SEM.get());

        //simpleBlockItem(ModBlocks.RGOLDBLOCK);
        //simpleBlockItem(ModBlocks.HRBLOCK);
        //simpleBlockItem(ModBlocks.RGOLDORE);
        //simpleBlockItem(ModBlocks.SEMBLOCK);
        //simpleBlockItem(ModBlocks.SOBLOCK);

        handheldItem(ModItems.JEMERALD_SWORD);
        handheldItem(ModItems.JEMERALD_PICKAXE);
        handheldItem(ModItems.JEMERALD_SHOVEL);
        handheldItem(ModItems.JEMERALD_AXE);
        handheldItem(ModItems.JEMERALD_HOE);

        handheldItem(ModItems.SEMERALD_SWORD);
        handheldItem(ModItems.SEMERALD_PICKAXE);
        handheldItem(ModItems.SEMERALD_SHOVEL);
        handheldItem(ModItems.SEMERALD_AXE);
        handheldItem(ModItems.SEMERALD_HOE);

        handheldItem(ModItems.JOBSIDIAN_SWORD);
        handheldItem(ModItems.JOBSIDIAN_PICKAXE);
        handheldItem(ModItems.JOBSIDIAN_SHOVEL);
        handheldItem(ModItems.JOBSIDIAN_AXE);
        handheldItem(ModItems.JOBSIDIAN_HOE);

        handheldItem(ModItems.SOBSIDIAN_SWORD);
        handheldItem(ModItems.SOBSIDIAN_PICKAXE);
        handheldItem(ModItems.SOBSIDIAN_SHOVEL);
        handheldItem(ModItems.SOBSIDIAN_AXE);
        handheldItem(ModItems.SOBSIDIAN_HOE);

        handheldItem(ModItems.OVERPOWER_SWORD);
        handheldItem(ModItems.OVERPOWER_PICKAXE);
        handheldItem(ModItems.OVERPOWER_SHOVEL);
        handheldItem(ModItems.OVERPOWER_AXE);

        handheldItem(ModItems.HREDSTONE_SWORD);
        handheldItem(ModItems.HREDSTONE_PICKAXE);
        handheldItem(ModItems.HREDSTONE_SHOVEL);
        handheldItem(ModItems.HREDSTONE_AXE);
        handheldItem(ModItems.HREDSTONE_HOE);

        handheldItem(ModItems.RGOLD_SWORD);
        handheldItem(ModItems.RGOLD_PICKAXE);
        handheldItem(ModItems.RGOLD_SHOVEL);
        handheldItem(ModItems.RGOLD_AXE);
        handheldItem(ModItems.RGOLD_HOE);

        trimmedArmorItem(ModItems.EMERALD_HELMET);
        trimmedArmorItem(ModItems.EMERALD_CHESTPLATE);
        trimmedArmorItem(ModItems.EMERALD_LEGGINGS);
        trimmedArmorItem(ModItems.EMERALD_BOOTS);

        trimmedArmorItem(ModItems.HRED_HELMET);
        trimmedArmorItem(ModItems.HRED_CHESTPLATE);
        trimmedArmorItem(ModItems.HRED_LEGGINGS);
        trimmedArmorItem(ModItems.HRED_BOOTS);

        trimmedArmorItem(ModItems.OBSIDIAN_HELMET);
        trimmedArmorItem(ModItems.OBSIDIAN_CHESTPLATE);
        trimmedArmorItem(ModItems.OBSIDIAN_LEGGINGS);
        trimmedArmorItem(ModItems.OBSIDIAN_BOOTS);

        trimmedArmorItem(ModItems.RGOLD_HELMET);
        trimmedArmorItem(ModItems.RGOLD_CHESTPLATE);
        trimmedArmorItem(ModItems.RGOLD_LEGGINGS);
        trimmedArmorItem(ModItems.RGOLD_BOOTS);

        trimmedArmorItem(ModItems.OVERPOWER_HELMET);
        trimmedArmorItem(ModItems.OVERPOWER_CHESTPLATE);
        trimmedArmorItem(ModItems.OVERPOWER_LEGGINGS);
        trimmedArmorItem(ModItems.OVERPOWER_BOOTS);

        withExistingParent(ModItems.GHOST_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = UsefultoolsMod.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(UsefultoolsMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(UsefultoolsMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(UsefultoolsMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(UsefultoolsMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(UsefultoolsMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}