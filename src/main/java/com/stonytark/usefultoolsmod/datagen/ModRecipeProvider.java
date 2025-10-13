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
        List<ItemLike> RGOLD_SMELTABLES = List.of(ModItems.RGOLD.get(), ModBlocks.RGOLDORE.get());

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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HRED.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.CLAY).define('B', Items.REDSTONE)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE)).save(pRecipeOutput);

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