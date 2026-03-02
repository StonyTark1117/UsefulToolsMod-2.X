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
        basicItem(ModItems.RAW_RGOLD.get());
        basicItem(ModItems.OBSHARD.get());
        basicItem(ModItems.OBINGOT.get());
        basicItem(ModItems.HRED.get());
        basicItem(ModItems.HGLOW.get());
        basicItem(ModItems.SEM.get());
        basicItem(ModItems.RLAPIS.get());

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

        handheldItem(ModItems.HGLOWSTONE_SWORD);
        handheldItem(ModItems.HGLOWSTONE_PICKAXE);
        handheldItem(ModItems.HGLOWSTONE_SHOVEL);
        handheldItem(ModItems.HGLOWSTONE_AXE);
        handheldItem(ModItems.HGLOWSTONE_HOE);

        handheldItem(ModItems.RGOLD_SWORD);
        handheldItem(ModItems.RGOLD_PICKAXE);
        handheldItem(ModItems.RGOLD_SHOVEL);
        handheldItem(ModItems.RGOLD_AXE);
        handheldItem(ModItems.RGOLD_HOE);

        handheldItem(ModItems.RLAPIS_SWORD);
        handheldItem(ModItems.RLAPIS_PICKAXE);
        handheldItem(ModItems.RLAPIS_SHOVEL);
        handheldItem(ModItems.RLAPIS_AXE);
        handheldItem(ModItems.RLAPIS_HOE);

        trimmedArmorItem(ModItems.EMERALD_HELMET);
        trimmedArmorItem(ModItems.EMERALD_CHESTPLATE);
        trimmedArmorItem(ModItems.EMERALD_LEGGINGS);
        trimmedArmorItem(ModItems.EMERALD_BOOTS);

        trimmedArmorItem(ModItems.HRED_HELMET);
        trimmedArmorItem(ModItems.HRED_CHESTPLATE);
        trimmedArmorItem(ModItems.HRED_LEGGINGS);
        trimmedArmorItem(ModItems.HRED_BOOTS);

        trimmedArmorItem(ModItems.HGLOW_HELMET);
        trimmedArmorItem(ModItems.HGLOW_CHESTPLATE);
        trimmedArmorItem(ModItems.HGLOW_LEGGINGS);
        trimmedArmorItem(ModItems.HGLOW_BOOTS);

        trimmedArmorItem(ModItems.OBSIDIAN_HELMET);
        trimmedArmorItem(ModItems.OBSIDIAN_CHESTPLATE);
        trimmedArmorItem(ModItems.OBSIDIAN_LEGGINGS);
        trimmedArmorItem(ModItems.OBSIDIAN_BOOTS);

        trimmedArmorItem(ModItems.RGOLD_HELMET);
        trimmedArmorItem(ModItems.RGOLD_CHESTPLATE);
        trimmedArmorItem(ModItems.RGOLD_LEGGINGS);
        trimmedArmorItem(ModItems.RGOLD_BOOTS);

        trimmedArmorItem(ModItems.RLAPIS_HELMET);
        trimmedArmorItem(ModItems.RLAPIS_CHESTPLATE);
        trimmedArmorItem(ModItems.RLAPIS_LEGGINGS);
        trimmedArmorItem(ModItems.RLAPIS_BOOTS);

        trimmedArmorItem(ModItems.OVERPOWER_HELMET);
        trimmedArmorItem(ModItems.OVERPOWER_CHESTPLATE);
        trimmedArmorItem(ModItems.OVERPOWER_LEGGINGS);
        trimmedArmorItem(ModItems.OVERPOWER_BOOTS);

        withExistingParent(ModItems.GHOST_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        basicItem(ModItems.ECTOPLASM.get());

        // Coal material and tools
        basicItem(ModItems.COAL_DUST.get());
        basicItem(ModItems.HARDENED_COAL.get());

        handheldItem(ModItems.COAL_SWORD);
        handheldItem(ModItems.COAL_PICKAXE);
        handheldItem(ModItems.COAL_SHOVEL);
        handheldItem(ModItems.COAL_AXE);
        handheldItem(ModItems.COAL_HOE);

        trimmedArmorItem(ModItems.COAL_HELMET);
        trimmedArmorItem(ModItems.COAL_CHESTPLATE);
        trimmedArmorItem(ModItems.COAL_LEGGINGS);
        trimmedArmorItem(ModItems.COAL_BOOTS);

        // Raw metal jagged tools
        handheldItem(ModItems.JRAW_GOLD_SWORD);
        handheldItem(ModItems.JRAW_GOLD_PICKAXE);
        handheldItem(ModItems.JRAW_GOLD_SHOVEL);
        handheldItem(ModItems.JRAW_GOLD_AXE);
        handheldItem(ModItems.JRAW_GOLD_HOE);

        handheldItem(ModItems.JRAW_COPPER_SWORD);
        handheldItem(ModItems.JRAW_COPPER_PICKAXE);
        handheldItem(ModItems.JRAW_COPPER_SHOVEL);
        handheldItem(ModItems.JRAW_COPPER_AXE);
        handheldItem(ModItems.JRAW_COPPER_HOE);

        handheldItem(ModItems.JRAW_IRON_SWORD);
        handheldItem(ModItems.JRAW_IRON_PICKAXE);
        handheldItem(ModItems.JRAW_IRON_SHOVEL);
        handheldItem(ModItems.JRAW_IRON_AXE);
        handheldItem(ModItems.JRAW_IRON_HOE);

        handheldItem(ModItems.JRAW_RGOLD_SWORD);
        handheldItem(ModItems.JRAW_RGOLD_PICKAXE);
        handheldItem(ModItems.JRAW_RGOLD_SHOVEL);
        handheldItem(ModItems.JRAW_RGOLD_AXE);
        handheldItem(ModItems.JRAW_RGOLD_HOE);

        handheldItem(ModItems.JSCRAP_SWORD);
        handheldItem(ModItems.JSCRAP_PICKAXE);
        handheldItem(ModItems.JSCRAP_SHOVEL);
        handheldItem(ModItems.JSCRAP_AXE);
        handheldItem(ModItems.JSCRAP_HOE);

        // Crystal / element material items
        basicItem(ModItems.CALCIFIED_AMETHYST.get());
        basicItem(ModItems.GLACIAL_SHARD.get());
        basicItem(ModItems.POLISHED_QUARTZ.get());
        basicItem(ModItems.POLISHED_PRISMARINE.get());

        // Jagged crystal tools
        handheldItem(ModItems.JAMETHYST_SWORD);
        handheldItem(ModItems.JAMETHYST_PICKAXE);
        handheldItem(ModItems.JAMETHYST_SHOVEL);
        handheldItem(ModItems.JAMETHYST_AXE);
        handheldItem(ModItems.JAMETHYST_HOE);

        handheldItem(ModItems.SNOW_SWORD);
        handheldItem(ModItems.SNOW_PICKAXE);
        handheldItem(ModItems.SNOW_SHOVEL);
        handheldItem(ModItems.SNOW_AXE);
        handheldItem(ModItems.SNOW_HOE);

        handheldItem(ModItems.JQUARTZ_SWORD);
        handheldItem(ModItems.JQUARTZ_PICKAXE);
        handheldItem(ModItems.JQUARTZ_SHOVEL);
        handheldItem(ModItems.JQUARTZ_AXE);
        handheldItem(ModItems.JQUARTZ_HOE);

        handheldItem(ModItems.JPRISM_SWORD);
        handheldItem(ModItems.JPRISM_PICKAXE);
        handheldItem(ModItems.JPRISM_SHOVEL);
        handheldItem(ModItems.JPRISM_AXE);
        handheldItem(ModItems.JPRISM_HOE);

        // Smooth crystal tools + armor
        handheldItem(ModItems.CAMETHYST_SWORD);
        handheldItem(ModItems.CAMETHYST_PICKAXE);
        handheldItem(ModItems.CAMETHYST_SHOVEL);
        handheldItem(ModItems.CAMETHYST_AXE);
        handheldItem(ModItems.CAMETHYST_HOE);
        trimmedArmorItem(ModItems.CAMETHYST_HELMET);
        trimmedArmorItem(ModItems.CAMETHYST_CHESTPLATE);
        trimmedArmorItem(ModItems.CAMETHYST_LEGGINGS);
        trimmedArmorItem(ModItems.CAMETHYST_BOOTS);

        handheldItem(ModItems.ICE_SWORD);
        handheldItem(ModItems.ICE_PICKAXE);
        handheldItem(ModItems.ICE_SHOVEL);
        handheldItem(ModItems.ICE_AXE);
        handheldItem(ModItems.ICE_HOE);
        trimmedArmorItem(ModItems.ICE_HELMET);
        trimmedArmorItem(ModItems.ICE_CHESTPLATE);
        trimmedArmorItem(ModItems.ICE_LEGGINGS);
        trimmedArmorItem(ModItems.ICE_BOOTS);

        handheldItem(ModItems.SQUARTZ_SWORD);
        handheldItem(ModItems.SQUARTZ_PICKAXE);
        handheldItem(ModItems.SQUARTZ_SHOVEL);
        handheldItem(ModItems.SQUARTZ_AXE);
        handheldItem(ModItems.SQUARTZ_HOE);
        trimmedArmorItem(ModItems.SQUARTZ_HELMET);
        trimmedArmorItem(ModItems.SQUARTZ_CHESTPLATE);
        trimmedArmorItem(ModItems.SQUARTZ_LEGGINGS);
        trimmedArmorItem(ModItems.SQUARTZ_BOOTS);

        handheldItem(ModItems.SPRISM_SWORD);
        handheldItem(ModItems.SPRISM_PICKAXE);
        handheldItem(ModItems.SPRISM_SHOVEL);
        handheldItem(ModItems.SPRISM_AXE);
        handheldItem(ModItems.SPRISM_HOE);
        trimmedArmorItem(ModItems.SPRISM_HELMET);
        trimmedArmorItem(ModItems.SPRISM_CHESTPLATE);
        trimmedArmorItem(ModItems.SPRISM_LEGGINGS);
        trimmedArmorItem(ModItems.SPRISM_BOOTS);

        // Flint and FNI
        handheldItem(ModItems.JFLINT_SWORD); handheldItem(ModItems.JFLINT_PICKAXE); handheldItem(ModItems.JFLINT_SHOVEL); handheldItem(ModItems.JFLINT_AXE); handheldItem(ModItems.JFLINT_HOE);
        handheldItem(ModItems.FNI_SWORD); handheldItem(ModItems.FNI_PICKAXE); handheldItem(ModItems.FNI_SHOVEL); handheldItem(ModItems.FNI_AXE); handheldItem(ModItems.FNI_HOE);
        trimmedArmorItem(ModItems.FNI_HELMET);
        trimmedArmorItem(ModItems.FNI_CHESTPLATE);
        trimmedArmorItem(ModItems.FNI_LEGGINGS);
        trimmedArmorItem(ModItems.FNI_BOOTS);

        // Stone Rock Variants
        handheldItem(ModItems.ANDESITE_SWORD); handheldItem(ModItems.ANDESITE_PICKAXE); handheldItem(ModItems.ANDESITE_SHOVEL); handheldItem(ModItems.ANDESITE_AXE); handheldItem(ModItems.ANDESITE_HOE);
        handheldItem(ModItems.BASALT_SWORD); handheldItem(ModItems.BASALT_PICKAXE); handheldItem(ModItems.BASALT_SHOVEL); handheldItem(ModItems.BASALT_AXE); handheldItem(ModItems.BASALT_HOE);
        handheldItem(ModItems.BLACKSTONE_SWORD); handheldItem(ModItems.BLACKSTONE_PICKAXE); handheldItem(ModItems.BLACKSTONE_SHOVEL); handheldItem(ModItems.BLACKSTONE_AXE); handheldItem(ModItems.BLACKSTONE_HOE);
        handheldItem(ModItems.CALCITE_SWORD); handheldItem(ModItems.CALCITE_PICKAXE); handheldItem(ModItems.CALCITE_SHOVEL); handheldItem(ModItems.CALCITE_AXE); handheldItem(ModItems.CALCITE_HOE);
        handheldItem(ModItems.DEEPSLATE_SWORD); handheldItem(ModItems.DEEPSLATE_PICKAXE); handheldItem(ModItems.DEEPSLATE_SHOVEL); handheldItem(ModItems.DEEPSLATE_AXE); handheldItem(ModItems.DEEPSLATE_HOE);
        handheldItem(ModItems.DIORITE_SWORD); handheldItem(ModItems.DIORITE_PICKAXE); handheldItem(ModItems.DIORITE_SHOVEL); handheldItem(ModItems.DIORITE_AXE); handheldItem(ModItems.DIORITE_HOE);
        handheldItem(ModItems.END_STONE_SWORD); handheldItem(ModItems.END_STONE_PICKAXE); handheldItem(ModItems.END_STONE_SHOVEL); handheldItem(ModItems.END_STONE_AXE); handheldItem(ModItems.END_STONE_HOE);
        handheldItem(ModItems.GRANITE_SWORD); handheldItem(ModItems.GRANITE_PICKAXE); handheldItem(ModItems.GRANITE_SHOVEL); handheldItem(ModItems.GRANITE_AXE); handheldItem(ModItems.GRANITE_HOE);
        handheldItem(ModItems.NETHERRACK_SWORD); handheldItem(ModItems.NETHERRACK_PICKAXE); handheldItem(ModItems.NETHERRACK_SHOVEL); handheldItem(ModItems.NETHERRACK_AXE); handheldItem(ModItems.NETHERRACK_HOE);
        handheldItem(ModItems.SANDSTONE_SWORD); handheldItem(ModItems.SANDSTONE_PICKAXE); handheldItem(ModItems.SANDSTONE_SHOVEL); handheldItem(ModItems.SANDSTONE_AXE); handheldItem(ModItems.SANDSTONE_HOE);
        handheldItem(ModItems.SMOOTH_BASALT_SWORD); handheldItem(ModItems.SMOOTH_BASALT_PICKAXE); handheldItem(ModItems.SMOOTH_BASALT_SHOVEL); handheldItem(ModItems.SMOOTH_BASALT_AXE); handheldItem(ModItems.SMOOTH_BASALT_HOE);
        handheldItem(ModItems.TERRACOTTA_SWORD); handheldItem(ModItems.TERRACOTTA_PICKAXE); handheldItem(ModItems.TERRACOTTA_SHOVEL); handheldItem(ModItems.TERRACOTTA_AXE); handheldItem(ModItems.TERRACOTTA_HOE);
        handheldItem(ModItems.TUFF_SWORD); handheldItem(ModItems.TUFF_PICKAXE); handheldItem(ModItems.TUFF_SHOVEL); handheldItem(ModItems.TUFF_AXE); handheldItem(ModItems.TUFF_HOE);
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