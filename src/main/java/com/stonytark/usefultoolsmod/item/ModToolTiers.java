package com.stonytark.usefultoolsmod.item;

import com.stonytark.usefultoolsmod.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier JEMERALD = new ForgeTier(1561, 6, 3.5f, 22,
            ModTags.Blocks.NEEDS_JEM_TOOL, () -> Ingredient.of(Items.EMERALD),
            ModTags.Blocks.INCORRECT_JEM_TOOL);

    public static final Tier SEMERALD = new ForgeTier(1361, 7, 3.2f, 30,
            ModTags.Blocks.NEEDS_SEM_TOOL, () -> Ingredient.of(ModItems.SEM.get()),
            ModTags.Blocks.INCORRECT_SEM_TOOL);

    public static final Tier JOBSIDIAN = new ForgeTier(2031, 9, 6f, 15,
            ModTags.Blocks.NEEDS_JOB_TOOL, () -> Ingredient.of(ModItems.OBSHARD.get()),
            ModTags.Blocks.INCORRECT_JOB_TOOL);

    public static final Tier SOBSIDIAN = new ForgeTier(1750, 10, 4f, 18,
            ModTags.Blocks.NEEDS_SOB_TOOL, () -> Ingredient.of(ModItems.OBINGOT.get()),
            ModTags.Blocks.INCORRECT_SOB_TOOL);

    public static final Tier OVERPOWER = new ForgeTier(9999, 25, 25f, 35,
            ModTags.Blocks.NEEDS_OP_TOOL, () -> Ingredient.of(Blocks.DIAMOND_BLOCK),
            ModTags.Blocks.INCORRECT_OP_TOOL);

    public static final Tier HREDSTONE = new ForgeTier(600, 8, 3f, 20,
            ModTags.Blocks.NEEDS_HRED_TOOL, () -> Ingredient.of(ModItems.HRED.get()),
            ModTags.Blocks.INCORRECT_HRED_TOOL);

    public static final Tier RGOLD = new ForgeTier(400, 8, 3.5f, 16,
            ModTags.Blocks.NEEDS_RGOLD_TOOL, () -> Ingredient.of(ModItems.RGOLD.get()),
            ModTags.Blocks.INCORRECT_RGOLD_TOOL);
}
