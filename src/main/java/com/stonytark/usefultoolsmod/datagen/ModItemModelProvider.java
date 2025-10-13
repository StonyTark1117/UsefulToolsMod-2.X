package com.stonytark.usefultoolsmod.datagen;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import com.stonytark.usefultoolsmod.block.ModBlocks;
import com.stonytark.usefultoolsmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
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