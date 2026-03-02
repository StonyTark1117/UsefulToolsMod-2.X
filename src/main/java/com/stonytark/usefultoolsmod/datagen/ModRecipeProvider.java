package com.stonytark.usefultoolsmod.datagen;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import com.stonytark.usefultoolsmod.block.ModBlocks;
import com.stonytark.usefultoolsmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> RGOLD_SMELTABLES = List.of(ModItems.RAW_RGOLD.get(), ModBlocks.RGOLDORE.get(), ModBlocks.RGOLD_END_ORE.get(), ModBlocks.RGOLD_NETHER_ORE.get(), ModBlocks.RGOLD_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RGOLDBLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RGOLD.get())
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HRBLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.HRED.get())
                .unlockedBy(getHasName(ModItems.HRED.get()), has(ModItems.HRED.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SEMBLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SEM.get())
                .unlockedBy(getHasName(ModItems.SEM.get()), has(ModItems.SEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOBLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.OBINGOT.get())
                .unlockedBy(getHasName(ModItems.OBINGOT.get()), has(ModItems.OBINGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LBLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RLAPIS.get())
                .unlockedBy(getHasName(ModItems.RLAPIS.get()), has(ModItems.RLAPIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.ICE)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Items.SNOWBALL)
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RLAPIS.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.IRON_NUGGET).define('B', Items.LAPIS_LAZULI)
                .unlockedBy(getHasName(Items.LAPIS_LAZULI), has(Items.LAPIS_LAZULI)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HRED.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.CLAY_BALL).define('B', Items.REDSTONE)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE)).save(pRecipeOutput);

        // Hardened Glowstone: 4 glowstone dust in a + around a blaze rod
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HGLOW.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.GLOWSTONE_DUST).define('B', Items.BLAZE_ROD)
                .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SEM.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.IRON_INGOT).define('B', Items.EMERALD)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OBINGOT.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.IRON_INGOT).define('B', ModItems.OBSHARD.get())
                .unlockedBy(getHasName(ModItems.OBSHARD.get()), has(ModItems.OBSHARD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RGOLD.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.IRON_NUGGET).define('B', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RGOLDORE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.STONE).define('B', ModItems.RGOLD.get())
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":reverse_rgoldore");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RGOLD_END_ORE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.END_STONE).define('B', ModItems.RGOLD.get())
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":reverse_rgold_end_ore");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RGOLD_NETHER_ORE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.NETHERRACK).define('B', ModItems.RGOLD.get())
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":reverse_rgold_nether_ore");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RGOLD_DEEPSLATE_ORE.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.COBBLED_DEEPSLATE).define('B', ModItems.RGOLD.get())
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":reverse_rgold_deepslate_ore");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JEMERALD_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.EMERALD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JEMERALD_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', Items.EMERALD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JEMERALD_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.EMERALD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JEMERALD_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Items.EMERALD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JEMERALD_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', Items.EMERALD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SEMERALD_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.SEM.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.SEM.get()), has(ModItems.SEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SEMERALD_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.SEM.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.SEM.get()), has(ModItems.SEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SEMERALD_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.SEM.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.SEM.get()), has(ModItems.SEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SEMERALD_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.SEM.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.SEM.get()), has(ModItems.SEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SEMERALD_SWORD.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.SEM.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.SEM.get()), has(ModItems.SEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SOBSIDIAN_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.OBINGOT.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBINGOT.get()), has(ModItems.OBINGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SOBSIDIAN_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.OBINGOT.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBINGOT.get()), has(ModItems.OBINGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SOBSIDIAN_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.OBINGOT.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBINGOT.get()), has(ModItems.OBINGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SOBSIDIAN_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.OBINGOT.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBINGOT.get()), has(ModItems.OBINGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SOBSIDIAN_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.OBINGOT.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBINGOT.get()), has(ModItems.OBINGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JOBSIDIAN_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.OBSHARD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBSHARD.get()), has(ModItems.OBSHARD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JOBSIDIAN_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.OBSHARD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBSHARD.get()), has(ModItems.OBSHARD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JOBSIDIAN_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.OBSHARD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBSHARD.get()), has(ModItems.OBSHARD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JOBSIDIAN_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.OBSHARD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBSHARD.get()), has(ModItems.OBSHARD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JOBSIDIAN_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.OBSHARD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBSHARD.get()), has(ModItems.OBSHARD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OVERPOWER_AXE.get())
                .pattern("AAE")
                .pattern("DBD")
                .pattern("CB ")
                .define('C', ModBlocks.SOBLOCK.get()).define('B', Items.STICK).define('A', Blocks.DIAMOND_BLOCK).define('D', ModItems.RGOLD.get()).define('E', ModItems.SEM.get())
                .unlockedBy(getHasName(ModBlocks.SOBLOCK.get()), has(ModBlocks.SOBLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OVERPOWER_SHOVEL.get())
                .pattern("EAE")
                .pattern("DBD")
                .pattern("CB ")
                .define('C', ModBlocks.SOBLOCK.get()).define('B', Items.STICK).define('A', Blocks.DIAMOND_BLOCK).define('D', ModItems.RGOLD.get()).define('E', ModItems.SEM.get())
                .unlockedBy(getHasName(ModBlocks.SOBLOCK.get()), has(ModBlocks.SOBLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OVERPOWER_PICKAXE.get())
                .pattern("AAA")
                .pattern("DBE")
                .pattern("CB ")
                .define('C', ModBlocks.SOBLOCK.get()).define('B', Items.STICK).define('A', Blocks.DIAMOND_BLOCK).define('D', ModItems.RGOLD.get()).define('E', ModItems.SEM.get())
                .unlockedBy(getHasName(ModBlocks.SOBLOCK.get()), has(ModBlocks.SOBLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.OVERPOWER_SWORD.get())
                .pattern("EAE")
                .pattern("DAD")
                .pattern("CB ")
                .define('C', ModBlocks.SOBLOCK.get()).define('B', Items.STICK).define('A', Blocks.DIAMOND_BLOCK).define('D', ModItems.RGOLD.get()).define('E', ModItems.SEM.get())
                .unlockedBy(getHasName(ModBlocks.SOBLOCK.get()), has(ModBlocks.SOBLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HREDSTONE_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.HRED.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HRED.get()), has(ModItems.HRED.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HREDSTONE_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.HRED.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HRED.get()), has(ModItems.HRED.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HREDSTONE_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.HRED.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HRED.get()), has(ModItems.HRED.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HREDSTONE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.HRED.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HRED.get()), has(ModItems.HRED.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HREDSTONE_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.HRED.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HRED.get()), has(ModItems.HRED.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HGLOWSTONE_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.HGLOW.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HGLOW.get()), has(ModItems.HGLOW.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HGLOWSTONE_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.HGLOW.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HGLOW.get()), has(ModItems.HGLOW.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HGLOWSTONE_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.HGLOW.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HGLOW.get()), has(ModItems.HGLOW.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HGLOWSTONE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.HGLOW.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HGLOW.get()), has(ModItems.HGLOW.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HGLOWSTONE_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.HGLOW.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HGLOW.get()), has(ModItems.HGLOW.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RGOLD_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.RGOLD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RGOLD_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.RGOLD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RGOLD_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.RGOLD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RGOLD_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.RGOLD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RGOLD_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.RGOLD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RLAPIS_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.RLAPIS.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RLAPIS.get()), has(ModItems.RLAPIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RLAPIS_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.RLAPIS.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RLAPIS.get()), has(ModItems.RLAPIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RLAPIS_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.RLAPIS.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RLAPIS.get()), has(ModItems.RLAPIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RLAPIS_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.RLAPIS.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RLAPIS.get()), has(ModItems.RLAPIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RLAPIS_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.RLAPIS.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RLAPIS.get()), has(ModItems.RLAPIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMERALD_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SEM.get())
                .unlockedBy(getHasName(ModItems.SEM.get()), has(ModItems.SEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMERALD_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.SEM.get())
                .unlockedBy(getHasName(ModItems.SEM.get()), has(ModItems.SEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMERALD_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.SEM.get())
                .unlockedBy(getHasName(ModItems.SEM.get()), has(ModItems.SEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMERALD_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.SEM.get())
                .unlockedBy(getHasName(ModItems.SEM.get()), has(ModItems.SEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HRED_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.HRED.get())
                .unlockedBy(getHasName(ModItems.HRED.get()), has(ModItems.HRED.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HRED_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.HRED.get())
                .unlockedBy(getHasName(ModItems.HRED.get()), has(ModItems.HRED.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HRED_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.HRED.get())
                .unlockedBy(getHasName(ModItems.HRED.get()), has(ModItems.HRED.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HRED_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.HRED.get())
                .unlockedBy(getHasName(ModItems.HRED.get()), has(ModItems.HRED.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HGLOW_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.HGLOW.get())
                .unlockedBy(getHasName(ModItems.HGLOW.get()), has(ModItems.HGLOW.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HGLOW_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.HGLOW.get())
                .unlockedBy(getHasName(ModItems.HGLOW.get()), has(ModItems.HGLOW.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HGLOW_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.HGLOW.get())
                .unlockedBy(getHasName(ModItems.HGLOW.get()), has(ModItems.HGLOW.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HGLOW_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.HGLOW.get())
                .unlockedBy(getHasName(ModItems.HGLOW.get()), has(ModItems.HGLOW.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.OBINGOT.get())
                .unlockedBy(getHasName(ModItems.OBINGOT.get()), has(ModItems.OBINGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.OBINGOT.get())
                .unlockedBy(getHasName(ModItems.OBINGOT.get()), has(ModItems.OBINGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.OBINGOT.get())
                .unlockedBy(getHasName(ModItems.OBINGOT.get()), has(ModItems.OBINGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.OBINGOT.get())
                .unlockedBy(getHasName(ModItems.OBINGOT.get()), has(ModItems.OBINGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RGOLD_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RGOLD.get())
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RGOLD_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.RGOLD.get())
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RGOLD_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.RGOLD.get())
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RGOLD_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.RGOLD.get())
                .unlockedBy(getHasName(ModItems.RGOLD.get()), has(ModItems.RGOLD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RLAPIS_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RLAPIS.get())
                .unlockedBy(getHasName(ModItems.RLAPIS.get()), has(ModItems.RLAPIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RLAPIS_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.RLAPIS.get())
                .unlockedBy(getHasName(ModItems.RLAPIS.get()), has(ModItems.RLAPIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RLAPIS_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.RLAPIS.get())
                .unlockedBy(getHasName(ModItems.RLAPIS.get()), has(ModItems.RLAPIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RLAPIS_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.RLAPIS.get())
                .unlockedBy(getHasName(ModItems.RLAPIS.get()), has(ModItems.RLAPIS.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OVERPOWER_CHESTPLATE.get())
                .pattern("ACA")
                .pattern("ABA")
                .pattern("ADB")
                .define('A', Items.DIAMOND_BLOCK).define('B', ModItems.OBINGOT.get()).define('C', ModItems.SEM.get()).define('D', ModItems.RGOLD.get())
                .unlockedBy(getHasName(Items.DIAMOND_BLOCK), has(Items.DIAMOND_BLOCK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OVERPOWER_BOOTS.get())
                .pattern("ACA")
                .pattern("ABA")
                .pattern(" D ")
                .define('A', Items.DIAMOND_BLOCK).define('B', ModItems.OBINGOT.get()).define('C', ModItems.SEM.get()).define('D', ModItems.RGOLD.get())
                .unlockedBy(getHasName(Items.DIAMOND_BLOCK), has(Items.DIAMOND_BLOCK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OVERPOWER_LEGGINGS.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("ACA")
                .define('A', Items.DIAMOND_BLOCK).define('B', ModItems.OBINGOT.get()).define('C', ModItems.SEM.get())
                .unlockedBy(getHasName(Items.DIAMOND_BLOCK), has(Items.DIAMOND_BLOCK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OVERPOWER_HELMET.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("CDC")
                .define('A', Items.DIAMOND_BLOCK).define('B', ModItems.OBINGOT.get()).define('C', ModItems.SEM.get()).define('D', ModItems.RGOLD.get())
                .unlockedBy(getHasName(Items.DIAMOND_BLOCK), has(Items.DIAMOND_BLOCK)).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RGOLD.get(), 9)
                .requires(ModBlocks.RGOLDBLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RGOLDBLOCK.get()), has(ModBlocks.RGOLDBLOCK.get()))
                .save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":rgold_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HRED.get(), 9)
                .requires(ModBlocks.HRBLOCK.get())
                .unlockedBy(getHasName(ModBlocks.HRBLOCK.get()), has(ModBlocks.HRBLOCK.get()))
                .save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":hred_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OBINGOT.get(), 9)
                .requires(ModBlocks.SOBLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SOBLOCK.get()), has(ModBlocks.SOBLOCK.get()))
                .save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":sobingot_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RLAPIS.get(), 9)
                .requires(ModBlocks.LBLOCK.get())
                .unlockedBy(getHasName(ModBlocks.LBLOCK.get()), has(ModBlocks.LBLOCK.get()))
                .save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":rlapis_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OBSHARD.get(), 3)
                .requires(Items.OBSIDIAN)
                .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                .save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":obshard_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SEM.get(), 9)
                .requires(ModBlocks.SEMBLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SEMBLOCK.get()), has(ModBlocks.SEMBLOCK.get()))
                .save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":sem_from_block");

        oreSmelting(pRecipeOutput, RGOLD_SMELTABLES, RecipeCategory.MISC, ModItems.RGOLD.get(), 0.25f, 200, "rgold");
        oreBlasting(pRecipeOutput, RGOLD_SMELTABLES, RecipeCategory.MISC, ModItems.RGOLD.get(), 0.25f, 100, "rgold");

        // -----------------------------------------------------------------
        // Raw metal jagged tool recipes
        // -----------------------------------------------------------------

        // Jagged Raw Gold tools
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_GOLD_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', Items.RAW_GOLD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_GOLD), has(Items.RAW_GOLD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_GOLD_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', Items.RAW_GOLD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_GOLD), has(Items.RAW_GOLD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_GOLD_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', Items.RAW_GOLD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_GOLD), has(Items.RAW_GOLD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_GOLD_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', Items.RAW_GOLD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_GOLD), has(Items.RAW_GOLD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_GOLD_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', Items.RAW_GOLD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_GOLD), has(Items.RAW_GOLD)).save(pRecipeOutput);

        // Jagged Raw Copper tools
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_COPPER_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', Items.RAW_COPPER).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_COPPER), has(Items.RAW_COPPER)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_COPPER_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', Items.RAW_COPPER).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_COPPER), has(Items.RAW_COPPER)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_COPPER_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', Items.RAW_COPPER).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_COPPER), has(Items.RAW_COPPER)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_COPPER_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', Items.RAW_COPPER).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_COPPER), has(Items.RAW_COPPER)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_COPPER_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', Items.RAW_COPPER).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_COPPER), has(Items.RAW_COPPER)).save(pRecipeOutput);

        // Jagged Raw Iron tools
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_IRON_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', Items.RAW_IRON).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_IRON), has(Items.RAW_IRON)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_IRON_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', Items.RAW_IRON).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_IRON), has(Items.RAW_IRON)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_IRON_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', Items.RAW_IRON).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_IRON), has(Items.RAW_IRON)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_IRON_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', Items.RAW_IRON).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_IRON), has(Items.RAW_IRON)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_IRON_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', Items.RAW_IRON).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.RAW_IRON), has(Items.RAW_IRON)).save(pRecipeOutput);

        // Jagged Raw Ferrous Gold tools
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_RGOLD_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', ModItems.RAW_RGOLD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RAW_RGOLD.get()), has(ModItems.RAW_RGOLD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_RGOLD_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', ModItems.RAW_RGOLD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RAW_RGOLD.get()), has(ModItems.RAW_RGOLD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_RGOLD_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', ModItems.RAW_RGOLD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RAW_RGOLD.get()), has(ModItems.RAW_RGOLD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_RGOLD_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', ModItems.RAW_RGOLD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RAW_RGOLD.get()), has(ModItems.RAW_RGOLD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JRAW_RGOLD_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', ModItems.RAW_RGOLD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.RAW_RGOLD.get()), has(ModItems.RAW_RGOLD.get())).save(pRecipeOutput);

        // Jagged Netherite Scrap tools
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JSCRAP_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', Items.NETHERITE_SCRAP).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JSCRAP_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', Items.NETHERITE_SCRAP).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JSCRAP_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', Items.NETHERITE_SCRAP).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JSCRAP_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', Items.NETHERITE_SCRAP).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JSCRAP_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', Items.NETHERITE_SCRAP).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP)).save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Ghost breeding item
        // -----------------------------------------------------------------

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ECTOPLASM.get(), 2)
                .requires(Items.PHANTOM_MEMBRANE)
                .requires(Items.GLOWSTONE_DUST)
                .unlockedBy(getHasName(Items.PHANTOM_MEMBRANE), has(Items.PHANTOM_MEMBRANE))
                .save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":ectoplasm_from_membrane");

        // Spectral Infuser block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SPECTRAL_INFUSER.get())
                .pattern("EEE")
                .pattern("EBE")
                .pattern("SSS")
                .define('E', ModItems.ECTOPLASM.get())
                .define('B', Items.BLAZE_ROD)
                .define('S', Blocks.SMOOTH_STONE)
                .unlockedBy(getHasName(ModItems.ECTOPLASM.get()), has(ModItems.ECTOPLASM.get()))
                .save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Coal material recipes
        // -----------------------------------------------------------------

        // 1 Coal → 4 Coal Dust
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COAL_DUST.get(), 4)
                .requires(Items.COAL)
                .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                .save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":coal_dust_from_coal");

        // 1 Charcoal → 4 Coal Dust
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COAL_DUST.get(), 4)
                .requires(Items.CHARCOAL)
                .unlockedBy(getHasName(Items.CHARCOAL), has(Items.CHARCOAL))
                .save(pRecipeOutput, UsefultoolsMod.MOD_ID + ":coal_dust_from_charcoal");

        // Hardened Coal = Coal Dust surrounded by Clay Balls (follows HRED pattern)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HARDENED_COAL.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.CLAY_BALL)
                .define('B', ModItems.COAL_DUST.get())
                .unlockedBy(getHasName(ModItems.COAL_DUST.get()), has(ModItems.COAL_DUST.get()))
                .save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Coal tools
        // -----------------------------------------------------------------

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COAL_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.HARDENED_COAL.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HARDENED_COAL.get()), has(ModItems.HARDENED_COAL.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COAL_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.HARDENED_COAL.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HARDENED_COAL.get()), has(ModItems.HARDENED_COAL.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COAL_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.HARDENED_COAL.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HARDENED_COAL.get()), has(ModItems.HARDENED_COAL.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COAL_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.HARDENED_COAL.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HARDENED_COAL.get()), has(ModItems.HARDENED_COAL.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COAL_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.HARDENED_COAL.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.HARDENED_COAL.get()), has(ModItems.HARDENED_COAL.get()))
                .save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Coal armor
        // -----------------------------------------------------------------

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COAL_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.HARDENED_COAL.get())
                .unlockedBy(getHasName(ModItems.HARDENED_COAL.get()), has(ModItems.HARDENED_COAL.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COAL_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.HARDENED_COAL.get())
                .unlockedBy(getHasName(ModItems.HARDENED_COAL.get()), has(ModItems.HARDENED_COAL.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COAL_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.HARDENED_COAL.get())
                .unlockedBy(getHasName(ModItems.HARDENED_COAL.get()), has(ModItems.HARDENED_COAL.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COAL_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.HARDENED_COAL.get())
                .unlockedBy(getHasName(ModItems.HARDENED_COAL.get()), has(ModItems.HARDENED_COAL.get()))
                .save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Crystal / element material crafting
        // -----------------------------------------------------------------

        // Calcified Amethyst: + pattern with amethyst shards around calcite
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CALCIFIED_AMETHYST.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.AMETHYST_SHARD)
                .define('B', Blocks.CALCITE.asItem())
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pRecipeOutput);

        // Glacial Shard: packed ice surrounding blue ice
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GLACIAL_SHARD.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.PACKED_ICE)
                .define('B', Items.BLUE_ICE)
                .unlockedBy(getHasName(Items.PACKED_ICE), has(Items.PACKED_ICE))
                .save(pRecipeOutput);

        // Polished Quartz: + pattern with quartz around smooth quartz block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.POLISHED_QUARTZ.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.QUARTZ)
                .define('B', Blocks.SMOOTH_QUARTZ.asItem())
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ))
                .save(pRecipeOutput);

        // Polished Prismarine: + pattern with prismarine shards around prismarine crystals
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.POLISHED_PRISMARINE.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.PRISMARINE_SHARD)
                .define('B', Items.PRISMARINE_CRYSTALS)
                .unlockedBy(getHasName(Items.PRISMARINE_SHARD), has(Items.PRISMARINE_SHARD))
                .save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Jagged Amethyst tools
        // -----------------------------------------------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JAMETHYST_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', Items.AMETHYST_SHARD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JAMETHYST_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', Items.AMETHYST_SHARD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JAMETHYST_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', Items.AMETHYST_SHARD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JAMETHYST_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', Items.AMETHYST_SHARD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JAMETHYST_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', Items.AMETHYST_SHARD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD)).save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Snow tools
        // -----------------------------------------------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SNOW_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', Items.SNOWBALL).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SNOW_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', Items.SNOWBALL).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SNOW_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', Items.SNOWBALL).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SNOW_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', Items.SNOWBALL).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SNOW_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', Items.SNOWBALL).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL)).save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Jagged Quartz tools
        // -----------------------------------------------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JQUARTZ_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', Items.QUARTZ).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JQUARTZ_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', Items.QUARTZ).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JQUARTZ_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', Items.QUARTZ).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JQUARTZ_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', Items.QUARTZ).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JQUARTZ_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', Items.QUARTZ).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ)).save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Jagged Prismarine tools
        // -----------------------------------------------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JPRISM_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', Items.PRISMARINE_SHARD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.PRISMARINE_SHARD), has(Items.PRISMARINE_SHARD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JPRISM_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', Items.PRISMARINE_SHARD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.PRISMARINE_SHARD), has(Items.PRISMARINE_SHARD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JPRISM_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', Items.PRISMARINE_SHARD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.PRISMARINE_SHARD), has(Items.PRISMARINE_SHARD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JPRISM_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', Items.PRISMARINE_SHARD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.PRISMARINE_SHARD), has(Items.PRISMARINE_SHARD)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.JPRISM_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', Items.PRISMARINE_SHARD).define('B', Items.STICK)
                .unlockedBy(getHasName(Items.PRISMARINE_SHARD), has(Items.PRISMARINE_SHARD)).save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Calcified Amethyst tools + armor
        // -----------------------------------------------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CAMETHYST_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', ModItems.CALCIFIED_AMETHYST.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CALCIFIED_AMETHYST.get()), has(ModItems.CALCIFIED_AMETHYST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CAMETHYST_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', ModItems.CALCIFIED_AMETHYST.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CALCIFIED_AMETHYST.get()), has(ModItems.CALCIFIED_AMETHYST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CAMETHYST_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', ModItems.CALCIFIED_AMETHYST.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CALCIFIED_AMETHYST.get()), has(ModItems.CALCIFIED_AMETHYST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CAMETHYST_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', ModItems.CALCIFIED_AMETHYST.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CALCIFIED_AMETHYST.get()), has(ModItems.CALCIFIED_AMETHYST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CAMETHYST_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', ModItems.CALCIFIED_AMETHYST.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.CALCIFIED_AMETHYST.get()), has(ModItems.CALCIFIED_AMETHYST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CAMETHYST_HELMET.get())
                .pattern("AAA").pattern("A A").pattern("   ")
                .define('A', ModItems.CALCIFIED_AMETHYST.get())
                .unlockedBy(getHasName(ModItems.CALCIFIED_AMETHYST.get()), has(ModItems.CALCIFIED_AMETHYST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CAMETHYST_CHESTPLATE.get())
                .pattern("A A").pattern("AAA").pattern("AAA")
                .define('A', ModItems.CALCIFIED_AMETHYST.get())
                .unlockedBy(getHasName(ModItems.CALCIFIED_AMETHYST.get()), has(ModItems.CALCIFIED_AMETHYST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CAMETHYST_LEGGINGS.get())
                .pattern("AAA").pattern("A A").pattern("A A")
                .define('A', ModItems.CALCIFIED_AMETHYST.get())
                .unlockedBy(getHasName(ModItems.CALCIFIED_AMETHYST.get()), has(ModItems.CALCIFIED_AMETHYST.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CAMETHYST_BOOTS.get())
                .pattern("   ").pattern("A A").pattern("A A")
                .define('A', ModItems.CALCIFIED_AMETHYST.get())
                .unlockedBy(getHasName(ModItems.CALCIFIED_AMETHYST.get()), has(ModItems.CALCIFIED_AMETHYST.get())).save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Ice (Glacial) tools + armor
        // -----------------------------------------------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ICE_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', ModItems.GLACIAL_SHARD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.GLACIAL_SHARD.get()), has(ModItems.GLACIAL_SHARD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ICE_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', ModItems.GLACIAL_SHARD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.GLACIAL_SHARD.get()), has(ModItems.GLACIAL_SHARD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ICE_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', ModItems.GLACIAL_SHARD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.GLACIAL_SHARD.get()), has(ModItems.GLACIAL_SHARD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ICE_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', ModItems.GLACIAL_SHARD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.GLACIAL_SHARD.get()), has(ModItems.GLACIAL_SHARD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ICE_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', ModItems.GLACIAL_SHARD.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.GLACIAL_SHARD.get()), has(ModItems.GLACIAL_SHARD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ICE_HELMET.get())
                .pattern("AAA").pattern("A A").pattern("   ")
                .define('A', ModItems.GLACIAL_SHARD.get())
                .unlockedBy(getHasName(ModItems.GLACIAL_SHARD.get()), has(ModItems.GLACIAL_SHARD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ICE_CHESTPLATE.get())
                .pattern("A A").pattern("AAA").pattern("AAA")
                .define('A', ModItems.GLACIAL_SHARD.get())
                .unlockedBy(getHasName(ModItems.GLACIAL_SHARD.get()), has(ModItems.GLACIAL_SHARD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ICE_LEGGINGS.get())
                .pattern("AAA").pattern("A A").pattern("A A")
                .define('A', ModItems.GLACIAL_SHARD.get())
                .unlockedBy(getHasName(ModItems.GLACIAL_SHARD.get()), has(ModItems.GLACIAL_SHARD.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ICE_BOOTS.get())
                .pattern("   ").pattern("A A").pattern("A A")
                .define('A', ModItems.GLACIAL_SHARD.get())
                .unlockedBy(getHasName(ModItems.GLACIAL_SHARD.get()), has(ModItems.GLACIAL_SHARD.get())).save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Smooth Quartz tools + armor
        // -----------------------------------------------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SQUARTZ_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', ModItems.POLISHED_QUARTZ.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.POLISHED_QUARTZ.get()), has(ModItems.POLISHED_QUARTZ.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SQUARTZ_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', ModItems.POLISHED_QUARTZ.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.POLISHED_QUARTZ.get()), has(ModItems.POLISHED_QUARTZ.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SQUARTZ_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', ModItems.POLISHED_QUARTZ.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.POLISHED_QUARTZ.get()), has(ModItems.POLISHED_QUARTZ.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SQUARTZ_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', ModItems.POLISHED_QUARTZ.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.POLISHED_QUARTZ.get()), has(ModItems.POLISHED_QUARTZ.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SQUARTZ_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', ModItems.POLISHED_QUARTZ.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.POLISHED_QUARTZ.get()), has(ModItems.POLISHED_QUARTZ.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SQUARTZ_HELMET.get())
                .pattern("AAA").pattern("A A").pattern("   ")
                .define('A', ModItems.POLISHED_QUARTZ.get())
                .unlockedBy(getHasName(ModItems.POLISHED_QUARTZ.get()), has(ModItems.POLISHED_QUARTZ.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SQUARTZ_CHESTPLATE.get())
                .pattern("A A").pattern("AAA").pattern("AAA")
                .define('A', ModItems.POLISHED_QUARTZ.get())
                .unlockedBy(getHasName(ModItems.POLISHED_QUARTZ.get()), has(ModItems.POLISHED_QUARTZ.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SQUARTZ_LEGGINGS.get())
                .pattern("AAA").pattern("A A").pattern("A A")
                .define('A', ModItems.POLISHED_QUARTZ.get())
                .unlockedBy(getHasName(ModItems.POLISHED_QUARTZ.get()), has(ModItems.POLISHED_QUARTZ.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SQUARTZ_BOOTS.get())
                .pattern("   ").pattern("A A").pattern("A A")
                .define('A', ModItems.POLISHED_QUARTZ.get())
                .unlockedBy(getHasName(ModItems.POLISHED_QUARTZ.get()), has(ModItems.POLISHED_QUARTZ.get())).save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Smooth Prismarine tools + armor
        // -----------------------------------------------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SPRISM_SWORD.get())
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', ModItems.POLISHED_PRISMARINE.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.POLISHED_PRISMARINE.get()), has(ModItems.POLISHED_PRISMARINE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SPRISM_PICKAXE.get())
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', ModItems.POLISHED_PRISMARINE.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.POLISHED_PRISMARINE.get()), has(ModItems.POLISHED_PRISMARINE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SPRISM_SHOVEL.get())
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', ModItems.POLISHED_PRISMARINE.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.POLISHED_PRISMARINE.get()), has(ModItems.POLISHED_PRISMARINE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SPRISM_AXE.get())
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', ModItems.POLISHED_PRISMARINE.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.POLISHED_PRISMARINE.get()), has(ModItems.POLISHED_PRISMARINE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SPRISM_HOE.get())
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', ModItems.POLISHED_PRISMARINE.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.POLISHED_PRISMARINE.get()), has(ModItems.POLISHED_PRISMARINE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SPRISM_HELMET.get())
                .pattern("AAA").pattern("A A").pattern("   ")
                .define('A', ModItems.POLISHED_PRISMARINE.get())
                .unlockedBy(getHasName(ModItems.POLISHED_PRISMARINE.get()), has(ModItems.POLISHED_PRISMARINE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SPRISM_CHESTPLATE.get())
                .pattern("A A").pattern("AAA").pattern("AAA")
                .define('A', ModItems.POLISHED_PRISMARINE.get())
                .unlockedBy(getHasName(ModItems.POLISHED_PRISMARINE.get()), has(ModItems.POLISHED_PRISMARINE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SPRISM_LEGGINGS.get())
                .pattern("AAA").pattern("A A").pattern("A A")
                .define('A', ModItems.POLISHED_PRISMARINE.get())
                .unlockedBy(getHasName(ModItems.POLISHED_PRISMARINE.get()), has(ModItems.POLISHED_PRISMARINE.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SPRISM_BOOTS.get())
                .pattern("   ").pattern("A A").pattern("A A")
                .define('A', ModItems.POLISHED_PRISMARINE.get())
                .unlockedBy(getHasName(ModItems.POLISHED_PRISMARINE.get()), has(ModItems.POLISHED_PRISMARINE.get())).save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Flint Tools (jagged)
        // -----------------------------------------------------------------
        stoneVariantTools(pRecipeOutput,
                ModItems.JFLINT_SWORD.get(), ModItems.JFLINT_PICKAXE.get(),
                ModItems.JFLINT_SHOVEL.get(), ModItems.JFLINT_AXE.get(), ModItems.JFLINT_HOE.get(),
                Items.FLINT);

        // -----------------------------------------------------------------
        // Flint-Iron (FNI) Tools
        // -----------------------------------------------------------------
        // Sword: flint-iron-stick vertically
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FNI_SWORD.get())
                .pattern(" F ").pattern(" I ").pattern(" S ")
                .define('F', Items.FLINT).define('I', Items.IRON_INGOT).define('S', Items.STICK)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT)).save(pRecipeOutput);
        // Pickaxe: iron-flint-iron top, two sticks
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FNI_PICKAXE.get())
                .pattern("IFI").pattern(" S ").pattern(" S ")
                .define('F', Items.FLINT).define('I', Items.IRON_INGOT).define('S', Items.STICK)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT)).save(pRecipeOutput);
        // Shovel: iron head, flint below, stick handle
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FNI_SHOVEL.get())
                .pattern(" I ").pattern(" F ").pattern(" S ")
                .define('F', Items.FLINT).define('I', Items.IRON_INGOT).define('S', Items.STICK)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT)).save(pRecipeOutput);
        // Axe: flint-iron upper-left corner + stick column
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FNI_AXE.get())
                .pattern("FI ").pattern("FS ").pattern(" S ")
                .define('F', Items.FLINT).define('I', Items.IRON_INGOT).define('S', Items.STICK)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT)).save(pRecipeOutput);
        // Hoe: flint-iron head, two sticks below centre
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FNI_HOE.get())
                .pattern("FI ").pattern(" S ").pattern(" S ")
                .define('F', Items.FLINT).define('I', Items.IRON_INGOT).define('S', Items.STICK)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT)).save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Flint-Iron (FNI) Armor  — iron base with flint accent
        // -----------------------------------------------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FNI_HELMET.get())
                .pattern("IFI").pattern("I I").pattern("   ")
                .define('F', Items.FLINT).define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FNI_CHESTPLATE.get())
                .pattern("I I").pattern("IFI").pattern("III")
                .define('F', Items.FLINT).define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FNI_LEGGINGS.get())
                .pattern("IFI").pattern("I I").pattern("I I")
                .define('F', Items.FLINT).define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FNI_BOOTS.get())
                .pattern("   ").pattern("IFI").pattern("I I")
                .define('F', Items.FLINT).define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT)).save(pRecipeOutput);

        // -----------------------------------------------------------------
        // Stone Rock Variant Tools
        // -----------------------------------------------------------------
        stoneVariantTools(pRecipeOutput, ModItems.ANDESITE_SWORD.get(), ModItems.ANDESITE_PICKAXE.get(), ModItems.ANDESITE_SHOVEL.get(), ModItems.ANDESITE_AXE.get(), ModItems.ANDESITE_HOE.get(), Items.ANDESITE);
        stoneVariantTools(pRecipeOutput, ModItems.BASALT_SWORD.get(), ModItems.BASALT_PICKAXE.get(), ModItems.BASALT_SHOVEL.get(), ModItems.BASALT_AXE.get(), ModItems.BASALT_HOE.get(), Items.BASALT);
        stoneVariantTools(pRecipeOutput, ModItems.BLACKSTONE_SWORD.get(), ModItems.BLACKSTONE_PICKAXE.get(), ModItems.BLACKSTONE_SHOVEL.get(), ModItems.BLACKSTONE_AXE.get(), ModItems.BLACKSTONE_HOE.get(), Items.BLACKSTONE);
        stoneVariantTools(pRecipeOutput, ModItems.CALCITE_SWORD.get(), ModItems.CALCITE_PICKAXE.get(), ModItems.CALCITE_SHOVEL.get(), ModItems.CALCITE_AXE.get(), ModItems.CALCITE_HOE.get(), Items.CALCITE);
        stoneVariantTools(pRecipeOutput, ModItems.DEEPSLATE_SWORD.get(), ModItems.DEEPSLATE_PICKAXE.get(), ModItems.DEEPSLATE_SHOVEL.get(), ModItems.DEEPSLATE_AXE.get(), ModItems.DEEPSLATE_HOE.get(), Items.COBBLED_DEEPSLATE);
        stoneVariantTools(pRecipeOutput, ModItems.DIORITE_SWORD.get(), ModItems.DIORITE_PICKAXE.get(), ModItems.DIORITE_SHOVEL.get(), ModItems.DIORITE_AXE.get(), ModItems.DIORITE_HOE.get(), Items.DIORITE);
        stoneVariantTools(pRecipeOutput, ModItems.END_STONE_SWORD.get(), ModItems.END_STONE_PICKAXE.get(), ModItems.END_STONE_SHOVEL.get(), ModItems.END_STONE_AXE.get(), ModItems.END_STONE_HOE.get(), Items.END_STONE);
        stoneVariantTools(pRecipeOutput, ModItems.GRANITE_SWORD.get(), ModItems.GRANITE_PICKAXE.get(), ModItems.GRANITE_SHOVEL.get(), ModItems.GRANITE_AXE.get(), ModItems.GRANITE_HOE.get(), Items.GRANITE);
        stoneVariantTools(pRecipeOutput, ModItems.NETHERRACK_SWORD.get(), ModItems.NETHERRACK_PICKAXE.get(), ModItems.NETHERRACK_SHOVEL.get(), ModItems.NETHERRACK_AXE.get(), ModItems.NETHERRACK_HOE.get(), Items.NETHERRACK);
        stoneVariantTools(pRecipeOutput, ModItems.SANDSTONE_SWORD.get(), ModItems.SANDSTONE_PICKAXE.get(), ModItems.SANDSTONE_SHOVEL.get(), ModItems.SANDSTONE_AXE.get(), ModItems.SANDSTONE_HOE.get(), Items.SANDSTONE);
        stoneVariantTools(pRecipeOutput, ModItems.SMOOTH_BASALT_SWORD.get(), ModItems.SMOOTH_BASALT_PICKAXE.get(), ModItems.SMOOTH_BASALT_SHOVEL.get(), ModItems.SMOOTH_BASALT_AXE.get(), ModItems.SMOOTH_BASALT_HOE.get(), Items.SMOOTH_BASALT);
        stoneVariantTools(pRecipeOutput, ModItems.TERRACOTTA_SWORD.get(), ModItems.TERRACOTTA_PICKAXE.get(), ModItems.TERRACOTTA_SHOVEL.get(), ModItems.TERRACOTTA_AXE.get(), ModItems.TERRACOTTA_HOE.get(), Items.TERRACOTTA);
        stoneVariantTools(pRecipeOutput, ModItems.TUFF_SWORD.get(), ModItems.TUFF_PICKAXE.get(), ModItems.TUFF_SHOVEL.get(), ModItems.TUFF_AXE.get(), ModItems.TUFF_HOE.get(), Items.TUFF);

    }

    private static void stoneVariantTools(RecipeOutput out, ItemLike sword, ItemLike pickaxe, ItemLike shovel, ItemLike axe, ItemLike hoe, ItemLike material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword)
                .pattern(" A ").pattern(" A ").pattern(" B ")
                .define('A', material).define('B', Items.STICK)
                .unlockedBy(getHasName(material), has(material)).save(out);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .pattern("AAA").pattern(" B ").pattern(" B ")
                .define('A', material).define('B', Items.STICK)
                .unlockedBy(getHasName(material), has(material)).save(out);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
                .pattern(" A ").pattern(" B ").pattern(" B ")
                .define('A', material).define('B', Items.STICK)
                .unlockedBy(getHasName(material), has(material)).save(out);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .pattern("AA ").pattern("AB ").pattern(" B ")
                .define('A', material).define('B', Items.STICK)
                .unlockedBy(getHasName(material), has(material)).save(out);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .pattern("AA ").pattern(" B ").pattern(" B ")
                .define('A', material).define('B', Items.STICK)
                .unlockedBy(getHasName(material), has(material)).save(out);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, UsefultoolsMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}