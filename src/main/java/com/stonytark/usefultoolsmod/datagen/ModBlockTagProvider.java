package com.stonytark.usefultoolsmod.datagen;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import com.stonytark.usefultoolsmod.block.ModBlocks;
import com.stonytark.usefultoolsmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UsefultoolsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RGOLDBLOCK.get())
                .add(ModBlocks.HRBLOCK.get())
                .add(ModBlocks.RGOLDORE.get())
                .add(ModBlocks.RGOLD_NETHER_ORE.get())
                .add(ModBlocks.RGOLD_END_ORE.get())
                .add(ModBlocks.RGOLD_DEEPSLATE_ORE.get())
                .add(ModBlocks.SEMBLOCK.get())
                .add(ModBlocks.SOBLOCK.get())
                .add(ModBlocks.LBLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RGOLDBLOCK.get())
                .add(ModBlocks.LBLOCK.get())
                .add(ModBlocks.HRBLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SOBLOCK.get())
                .add(ModBlocks.SEMBLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RGOLDORE.get())
                .add(ModBlocks.RGOLD_NETHER_ORE.get())
                .add(ModBlocks.RGOLD_END_ORE.get())
                .add(ModBlocks.RGOLD_DEEPSLATE_ORE.get());

        tag(ModTags.Blocks.NEEDS_HRED_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.NEEDS_JEM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.NEEDS_JOB_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.NEEDS_OP_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Blocks.BEDROCK);

        tag(ModTags.Blocks.NEEDS_RGOLD_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.NEEDS_RLAPIS_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.NEEDS_SEM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.NEEDS_SOB_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Blocks.BEDROCK);

        tag(ModTags.Blocks.INCORRECT_HRED_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_JEM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_JOB_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_OP_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_RGOLD_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_RLAPIS_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);


        tag(ModTags.Blocks.INCORRECT_SEM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_SOB_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(Blocks.BEDROCK);

    }
}