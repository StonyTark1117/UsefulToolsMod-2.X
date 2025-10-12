package com.stonytark.usefultoolsmod.util;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;



public class ModTags {
 public static class Blocks {
     private static TagKey<Block> NEEDS_RGOLD_TOOL = createTag("needs_rgold_tool");
     private static TagKey<Block> INCORRECT_RGOLD_TOOL = createTag("incorrect_rgold_tool");

     private static TagKey<Block> createTag(String name) {
         return BlockTags.create(ResourceLocation.fromNamespaceAndPath(UsefultoolsMod.MOD_ID, name));
     }
 }

 public static class Items {
     public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

     private static TagKey<Item> createTag(String name) {
         return ItemTags.create(ResourceLocation.fromNamespaceAndPath(UsefultoolsMod.MOD_ID, name));
     }
 }
}