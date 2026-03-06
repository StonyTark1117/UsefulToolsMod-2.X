package com.stonytark.usefultoolsmod.item;

import com.stonytark.usefultoolsmod.Config;
import com.stonytark.usefultoolsmod.UsefultoolsMod;
import com.stonytark.usefultoolsmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UsefultoolsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> USEFUL_TOOLS_TAB = CREATIVE_MODE_TABS.register("useful_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RGOLD.get()))
                    .title(Component.translatable( "creativetab.usefultoolsmod.useful_tools"))
                    .displayItems((itemDisplayParameters, output) -> {

                        // =============================================================
                        //  UTILITY
                        // =============================================================

                        if (Config.explosivesEnabled) {
                            output.accept(ModItems.DYNAMITE.get());
                            output.accept(ModItems.GRENADE.get());
                        }

                        // =============================================================
                        //  VANILLA VARIANT TOOLS (wood & stone tier reskins)
                        // =============================================================

                        // --- Leather ---
                        if (Config.leatherEnabled) {
                            output.accept(ModItems.LEATHER_SWORD.get());
                            output.accept(ModItems.LEATHER_PICKAXE.get());
                            output.accept(ModItems.LEATHER_SHOVEL.get());
                            output.accept(ModItems.LEATHER_AXE.get());
                            output.accept(ModItems.LEATHER_HOE.get());
                        }

                        // --- Wood Variants ---
                        if (Config.woodVariantsEnabled) {
                            output.accept(ModItems.OAK_SWORD.get());
                            output.accept(ModItems.OAK_PICKAXE.get());
                            output.accept(ModItems.OAK_SHOVEL.get());
                            output.accept(ModItems.OAK_AXE.get());
                            output.accept(ModItems.OAK_HOE.get());
                            output.accept(ModItems.SPRUCE_SWORD.get());
                            output.accept(ModItems.SPRUCE_PICKAXE.get());
                            output.accept(ModItems.SPRUCE_SHOVEL.get());
                            output.accept(ModItems.SPRUCE_AXE.get());
                            output.accept(ModItems.SPRUCE_HOE.get());
                            output.accept(ModItems.BIRCH_SWORD.get());
                            output.accept(ModItems.BIRCH_PICKAXE.get());
                            output.accept(ModItems.BIRCH_SHOVEL.get());
                            output.accept(ModItems.BIRCH_AXE.get());
                            output.accept(ModItems.BIRCH_HOE.get());
                            output.accept(ModItems.JUNGLE_SWORD.get());
                            output.accept(ModItems.JUNGLE_PICKAXE.get());
                            output.accept(ModItems.JUNGLE_SHOVEL.get());
                            output.accept(ModItems.JUNGLE_AXE.get());
                            output.accept(ModItems.JUNGLE_HOE.get());
                            output.accept(ModItems.ACACIA_SWORD.get());
                            output.accept(ModItems.ACACIA_PICKAXE.get());
                            output.accept(ModItems.ACACIA_SHOVEL.get());
                            output.accept(ModItems.ACACIA_AXE.get());
                            output.accept(ModItems.ACACIA_HOE.get());
                            output.accept(ModItems.DARK_OAK_SWORD.get());
                            output.accept(ModItems.DARK_OAK_PICKAXE.get());
                            output.accept(ModItems.DARK_OAK_SHOVEL.get());
                            output.accept(ModItems.DARK_OAK_AXE.get());
                            output.accept(ModItems.DARK_OAK_HOE.get());
                            output.accept(ModItems.MANGROVE_SWORD.get());
                            output.accept(ModItems.MANGROVE_PICKAXE.get());
                            output.accept(ModItems.MANGROVE_SHOVEL.get());
                            output.accept(ModItems.MANGROVE_AXE.get());
                            output.accept(ModItems.MANGROVE_HOE.get());
                            output.accept(ModItems.CHERRY_SWORD.get());
                            output.accept(ModItems.CHERRY_PICKAXE.get());
                            output.accept(ModItems.CHERRY_SHOVEL.get());
                            output.accept(ModItems.CHERRY_AXE.get());
                            output.accept(ModItems.CHERRY_HOE.get());
                            output.accept(ModItems.BAMBOO_SWORD.get());
                            output.accept(ModItems.BAMBOO_PICKAXE.get());
                            output.accept(ModItems.BAMBOO_SHOVEL.get());
                            output.accept(ModItems.BAMBOO_AXE.get());
                            output.accept(ModItems.BAMBOO_HOE.get());
                            output.accept(ModItems.CRIMSON_SWORD.get());
                            output.accept(ModItems.CRIMSON_PICKAXE.get());
                            output.accept(ModItems.CRIMSON_SHOVEL.get());
                            output.accept(ModItems.CRIMSON_AXE.get());
                            output.accept(ModItems.CRIMSON_HOE.get());
                            output.accept(ModItems.WARPED_SWORD.get());
                            output.accept(ModItems.WARPED_PICKAXE.get());
                            output.accept(ModItems.WARPED_SHOVEL.get());
                            output.accept(ModItems.WARPED_AXE.get());
                            output.accept(ModItems.WARPED_HOE.get());
                        }

                        // --- Stone Rock Variants ---
                        if (Config.stoneVariantsEnabled) {
                            output.accept(ModItems.ANDESITE_SWORD.get());
                            output.accept(ModItems.ANDESITE_PICKAXE.get());
                            output.accept(ModItems.ANDESITE_SHOVEL.get());
                            output.accept(ModItems.ANDESITE_AXE.get());
                            output.accept(ModItems.ANDESITE_HOE.get());
                            output.accept(ModItems.BASALT_SWORD.get());
                            output.accept(ModItems.BASALT_PICKAXE.get());
                            output.accept(ModItems.BASALT_SHOVEL.get());
                            output.accept(ModItems.BASALT_AXE.get());
                            output.accept(ModItems.BASALT_HOE.get());
                            output.accept(ModItems.BLACKSTONE_SWORD.get());
                            output.accept(ModItems.BLACKSTONE_PICKAXE.get());
                            output.accept(ModItems.BLACKSTONE_SHOVEL.get());
                            output.accept(ModItems.BLACKSTONE_AXE.get());
                            output.accept(ModItems.BLACKSTONE_HOE.get());
                            output.accept(ModItems.CALCITE_SWORD.get());
                            output.accept(ModItems.CALCITE_PICKAXE.get());
                            output.accept(ModItems.CALCITE_SHOVEL.get());
                            output.accept(ModItems.CALCITE_AXE.get());
                            output.accept(ModItems.CALCITE_HOE.get());
                            output.accept(ModItems.DEEPSLATE_SWORD.get());
                            output.accept(ModItems.DEEPSLATE_PICKAXE.get());
                            output.accept(ModItems.DEEPSLATE_SHOVEL.get());
                            output.accept(ModItems.DEEPSLATE_AXE.get());
                            output.accept(ModItems.DEEPSLATE_HOE.get());
                            output.accept(ModItems.DIORITE_SWORD.get());
                            output.accept(ModItems.DIORITE_PICKAXE.get());
                            output.accept(ModItems.DIORITE_SHOVEL.get());
                            output.accept(ModItems.DIORITE_AXE.get());
                            output.accept(ModItems.DIORITE_HOE.get());
                            output.accept(ModItems.END_STONE_SWORD.get());
                            output.accept(ModItems.END_STONE_PICKAXE.get());
                            output.accept(ModItems.END_STONE_SHOVEL.get());
                            output.accept(ModItems.END_STONE_AXE.get());
                            output.accept(ModItems.END_STONE_HOE.get());
                            output.accept(ModItems.GRANITE_SWORD.get());
                            output.accept(ModItems.GRANITE_PICKAXE.get());
                            output.accept(ModItems.GRANITE_SHOVEL.get());
                            output.accept(ModItems.GRANITE_AXE.get());
                            output.accept(ModItems.GRANITE_HOE.get());
                            output.accept(ModItems.NETHERRACK_SWORD.get());
                            output.accept(ModItems.NETHERRACK_PICKAXE.get());
                            output.accept(ModItems.NETHERRACK_SHOVEL.get());
                            output.accept(ModItems.NETHERRACK_AXE.get());
                            output.accept(ModItems.NETHERRACK_HOE.get());
                            output.accept(ModItems.SANDSTONE_SWORD.get());
                            output.accept(ModItems.SANDSTONE_PICKAXE.get());
                            output.accept(ModItems.SANDSTONE_SHOVEL.get());
                            output.accept(ModItems.SANDSTONE_AXE.get());
                            output.accept(ModItems.SANDSTONE_HOE.get());
                            output.accept(ModItems.SMOOTH_BASALT_SWORD.get());
                            output.accept(ModItems.SMOOTH_BASALT_PICKAXE.get());
                            output.accept(ModItems.SMOOTH_BASALT_SHOVEL.get());
                            output.accept(ModItems.SMOOTH_BASALT_AXE.get());
                            output.accept(ModItems.SMOOTH_BASALT_HOE.get());
                            output.accept(ModItems.TERRACOTTA_SWORD.get());
                            output.accept(ModItems.TERRACOTTA_PICKAXE.get());
                            output.accept(ModItems.TERRACOTTA_SHOVEL.get());
                            output.accept(ModItems.TERRACOTTA_AXE.get());
                            output.accept(ModItems.TERRACOTTA_HOE.get());
                            output.accept(ModItems.TUFF_SWORD.get());
                            output.accept(ModItems.TUFF_PICKAXE.get());
                            output.accept(ModItems.TUFF_SHOVEL.get());
                            output.accept(ModItems.TUFF_AXE.get());
                            output.accept(ModItems.TUFF_HOE.get());
                        }

                        // =============================================================
                        //  NATURAL MATERIAL SETS (flint, coal)
                        // =============================================================

                        // --- Flint ---
                        if (Config.flintEnabled) {
                            output.accept(ModItems.RFLINT_SWORD.get());
                            output.accept(ModItems.RFLINT_PICKAXE.get());
                            output.accept(ModItems.RFLINT_SHOVEL.get());
                            output.accept(ModItems.RFLINT_AXE.get());
                            output.accept(ModItems.RFLINT_HOE.get());
                        }

                        // --- Flint-Iron (FNI) ---
                        if (Config.fniEnabled) {
                            output.accept(ModItems.FNI_SWORD.get());
                            output.accept(ModItems.FNI_PICKAXE.get());
                            output.accept(ModItems.FNI_SHOVEL.get());
                            output.accept(ModItems.FNI_AXE.get());
                            output.accept(ModItems.FNI_HOE.get());
                            output.accept(ModItems.FNI_HELMET.get());
                            output.accept(ModItems.FNI_CHESTPLATE.get());
                            output.accept(ModItems.FNI_LEGGINGS.get());
                            output.accept(ModItems.FNI_BOOTS.get());
                        }

                        // --- Coal ---
                        if (Config.coalEnabled) {
                            output.accept(ModItems.COAL_DUST.get());
                            output.accept(ModBlocks.COAL_DUST_BLOCK.get());
                            output.accept(ModItems.HARDENED_COAL.get());
                            output.accept(ModBlocks.HARDENED_COAL_BLOCK.get());
                            output.accept(ModItems.COAL_SWORD.get());
                            output.accept(ModItems.COAL_PICKAXE.get());
                            output.accept(ModItems.COAL_SHOVEL.get());
                            output.accept(ModItems.COAL_AXE.get());
                            output.accept(ModItems.COAL_HOE.get());
                            output.accept(ModItems.COAL_HELMET.get());
                            output.accept(ModItems.COAL_CHESTPLATE.get());
                            output.accept(ModItems.COAL_LEGGINGS.get());
                            output.accept(ModItems.COAL_BOOTS.get());
                        }

                        // --- Raw Metal Rough ---
                        if (Config.rawMetalRoughEnabled) {
                            output.accept(ModItems.RRAW_GOLD_SWORD.get());
                            output.accept(ModItems.RRAW_GOLD_PICKAXE.get());
                            output.accept(ModItems.RRAW_GOLD_SHOVEL.get());
                            output.accept(ModItems.RRAW_GOLD_AXE.get());
                            output.accept(ModItems.RRAW_GOLD_HOE.get());
                            output.accept(ModItems.RRAW_COPPER_SWORD.get());
                            output.accept(ModItems.RRAW_COPPER_PICKAXE.get());
                            output.accept(ModItems.RRAW_COPPER_SHOVEL.get());
                            output.accept(ModItems.RRAW_COPPER_AXE.get());
                            output.accept(ModItems.RRAW_COPPER_HOE.get());
                            output.accept(ModItems.RRAW_IRON_SWORD.get());
                            output.accept(ModItems.RRAW_IRON_PICKAXE.get());
                            output.accept(ModItems.RRAW_IRON_SHOVEL.get());
                            output.accept(ModItems.RRAW_IRON_AXE.get());
                            output.accept(ModItems.RRAW_IRON_HOE.get());
                            output.accept(ModItems.RRAW_RGOLD_SWORD.get());
                            output.accept(ModItems.RRAW_RGOLD_PICKAXE.get());
                            output.accept(ModItems.RRAW_RGOLD_SHOVEL.get());
                            output.accept(ModItems.RRAW_RGOLD_AXE.get());
                            output.accept(ModItems.RRAW_RGOLD_HOE.get());
                            output.accept(ModItems.RSCRAP_SWORD.get());
                            output.accept(ModItems.RSCRAP_PICKAXE.get());
                            output.accept(ModItems.RSCRAP_SHOVEL.get());
                            output.accept(ModItems.RSCRAP_AXE.get());
                            output.accept(ModItems.RSCRAP_HOE.get());
                        }

                        // =============================================================
                        //  CRYSTAL & ICE SETS
                        // =============================================================

                        // --- Crystal material items ---
                        if (Config.roughCrystalEnabled || Config.polishedCrystalEnabled) {
                            output.accept(ModItems.CALCIFIED_AMETHYST.get());
                            output.accept(ModBlocks.CALCIFIED_AMETHYST_BLOCK.get());
                            output.accept(ModItems.POLISHED_QUARTZ.get());
                            output.accept(ModBlocks.POLISHED_QUARTZ_BLOCK.get());
                        }
                        if (Config.iceEnabled || Config.snowEnabled) {
                            output.accept(ModItems.GLACIAL_SHARD.get());
                            output.accept(ModBlocks.GLACIAL_SHARD_BLOCK.get());
                        }
                        if (Config.roughCrystalEnabled || Config.pprismEnabled) {
                            output.accept(ModItems.POLISHED_PRISMARINE.get());
                            output.accept(ModBlocks.POLISHED_PRISMARINE_BLOCK.get());
                        }

                        // --- Rough Crystal ---
                        if (Config.roughCrystalEnabled) {
                            output.accept(ModItems.RAMETHYST_SWORD.get());
                            output.accept(ModItems.RAMETHYST_PICKAXE.get());
                            output.accept(ModItems.RAMETHYST_SHOVEL.get());
                            output.accept(ModItems.RAMETHYST_AXE.get());
                            output.accept(ModItems.RAMETHYST_HOE.get());
                            output.accept(ModItems.RQUARTZ_SWORD.get());
                            output.accept(ModItems.RQUARTZ_PICKAXE.get());
                            output.accept(ModItems.RQUARTZ_SHOVEL.get());
                            output.accept(ModItems.RQUARTZ_AXE.get());
                            output.accept(ModItems.RQUARTZ_HOE.get());
                            output.accept(ModItems.RPRISM_SWORD.get());
                            output.accept(ModItems.RPRISM_PICKAXE.get());
                            output.accept(ModItems.RPRISM_SHOVEL.get());
                            output.accept(ModItems.RPRISM_AXE.get());
                            output.accept(ModItems.RPRISM_HOE.get());
                        }

                        // --- Snow ---
                        if (Config.snowEnabled) {
                            output.accept(ModItems.SNOW_SWORD.get());
                            output.accept(ModItems.SNOW_PICKAXE.get());
                            output.accept(ModItems.SNOW_SHOVEL.get());
                            output.accept(ModItems.SNOW_AXE.get());
                            output.accept(ModItems.SNOW_HOE.get());
                        }

                        // --- Ice (Glacial) ---
                        if (Config.iceEnabled) {
                            output.accept(ModItems.ICE_SWORD.get());
                            output.accept(ModItems.ICE_PICKAXE.get());
                            output.accept(ModItems.ICE_SHOVEL.get());
                            output.accept(ModItems.ICE_AXE.get());
                            output.accept(ModItems.ICE_HOE.get());
                            output.accept(ModItems.ICE_HELMET.get());
                            output.accept(ModItems.ICE_CHESTPLATE.get());
                            output.accept(ModItems.ICE_LEGGINGS.get());
                            output.accept(ModItems.ICE_BOOTS.get());
                        }

                        // --- Polished Crystal ---
                        if (Config.polishedCrystalEnabled) {
                            output.accept(ModItems.CAMETHYST_SWORD.get());
                            output.accept(ModItems.CAMETHYST_PICKAXE.get());
                            output.accept(ModItems.CAMETHYST_SHOVEL.get());
                            output.accept(ModItems.CAMETHYST_AXE.get());
                            output.accept(ModItems.CAMETHYST_HOE.get());
                            output.accept(ModItems.CAMETHYST_HELMET.get());
                            output.accept(ModItems.CAMETHYST_CHESTPLATE.get());
                            output.accept(ModItems.CAMETHYST_LEGGINGS.get());
                            output.accept(ModItems.CAMETHYST_BOOTS.get());
                            output.accept(ModItems.PQUARTZ_SWORD.get());
                            output.accept(ModItems.PQUARTZ_PICKAXE.get());
                            output.accept(ModItems.PQUARTZ_SHOVEL.get());
                            output.accept(ModItems.PQUARTZ_AXE.get());
                            output.accept(ModItems.PQUARTZ_HOE.get());
                            output.accept(ModItems.PQUARTZ_HELMET.get());
                            output.accept(ModItems.PQUARTZ_CHESTPLATE.get());
                            output.accept(ModItems.PQUARTZ_LEGGINGS.get());
                            output.accept(ModItems.PQUARTZ_BOOTS.get());
                        }

                        // --- Polished Prismarine ---
                        if (Config.pprismEnabled) {
                            output.accept(ModItems.PPRISM_SWORD.get());
                            output.accept(ModItems.PPRISM_PICKAXE.get());
                            output.accept(ModItems.PPRISM_SHOVEL.get());
                            output.accept(ModItems.PPRISM_AXE.get());
                            output.accept(ModItems.PPRISM_HOE.get());
                            output.accept(ModItems.PPRISM_HELMET.get());
                            output.accept(ModItems.PPRISM_CHESTPLATE.get());
                            output.accept(ModItems.PPRISM_LEGGINGS.get());
                            output.accept(ModItems.PPRISM_BOOTS.get());
                        }

                        // =============================================================
                        //  METAL & GEM SETS
                        // =============================================================

                        // --- Ferrous Gold ---
                        if (Config.ferrousGoldEnabled) {
                            output.accept(ModBlocks.RGOLDBLOCK.get());
                            output.accept(ModBlocks.RAW_RGOLD_BLOCK.get());
                            output.accept(ModBlocks.RGOLDORE.get());
                            output.accept(ModBlocks.RGOLD_NETHER_ORE.get());
                            output.accept(ModBlocks.RGOLD_END_ORE.get());
                            output.accept(ModBlocks.RGOLD_DEEPSLATE_ORE.get());
                            output.accept(ModItems.RAW_RGOLD.get());
                            output.accept(ModItems.RGOLD.get());
                            output.accept(ModItems.RGOLD_AXE.get());
                            output.accept(ModItems.RGOLD_PICKAXE.get());
                            output.accept(ModItems.RGOLD_SWORD.get());
                            output.accept(ModItems.RGOLD_SHOVEL.get());
                            output.accept(ModItems.RGOLD_HOE.get());
                            output.accept(ModItems.RGOLD_HELMET.get());
                            output.accept(ModItems.RGOLD_CHESTPLATE.get());
                            output.accept(ModItems.RGOLD_LEGGINGS.get());
                            output.accept(ModItems.RGOLD_BOOTS.get());
                        }

                        // --- Lapis ---
                        if (Config.lapisEnabled) {
                            output.accept(ModBlocks.LBLOCK.get());
                            output.accept(ModItems.RLAPIS.get());
                            output.accept(ModItems.RLAPIS_AXE.get());
                            output.accept(ModItems.RLAPIS_PICKAXE.get());
                            output.accept(ModItems.RLAPIS_SWORD.get());
                            output.accept(ModItems.RLAPIS_SHOVEL.get());
                            output.accept(ModItems.RLAPIS_HOE.get());
                            output.accept(ModItems.RLAPIS_HELMET.get());
                            output.accept(ModItems.RLAPIS_CHESTPLATE.get());
                            output.accept(ModItems.RLAPIS_LEGGINGS.get());
                            output.accept(ModItems.RLAPIS_BOOTS.get());
                        }

                        // --- Hardened Redstone ---
                        if (Config.hardenedRedstoneEnabled) {
                            output.accept(ModItems.HRED.get());
                            output.accept(ModBlocks.HRBLOCK.get());
                            output.accept(ModItems.HREDSTONE_AXE.get());
                            output.accept(ModItems.HREDSTONE_PICKAXE.get());
                            output.accept(ModItems.HREDSTONE_SWORD.get());
                            output.accept(ModItems.HREDSTONE_SHOVEL.get());
                            output.accept(ModItems.HREDSTONE_HOE.get());
                            output.accept(ModItems.HRED_HELMET.get());
                            output.accept(ModItems.HRED_CHESTPLATE.get());
                            output.accept(ModItems.HRED_LEGGINGS.get());
                            output.accept(ModItems.HRED_BOOTS.get());
                        }

                        // --- Hardened Glowstone ---
                        if (Config.hardenedGlowstoneEnabled) {
                            output.accept(ModItems.HGLOW.get());
                            output.accept(ModBlocks.HGLOW_BLOCK.get());
                            output.accept(ModItems.HGLOWSTONE_AXE.get());
                            output.accept(ModItems.HGLOWSTONE_PICKAXE.get());
                            output.accept(ModItems.HGLOWSTONE_SWORD.get());
                            output.accept(ModItems.HGLOWSTONE_SHOVEL.get());
                            output.accept(ModItems.HGLOWSTONE_HOE.get());
                            output.accept(ModItems.HGLOW_HELMET.get());
                            output.accept(ModItems.HGLOW_CHESTPLATE.get());
                            output.accept(ModItems.HGLOW_LEGGINGS.get());
                            output.accept(ModItems.HGLOW_BOOTS.get());
                        }

                        // --- Emerald ---
                        if (Config.emeraldEnabled) {
                            output.accept(ModBlocks.SEMBLOCK.get());
                            output.accept(ModItems.SEM.get());
                            output.accept(ModItems.PEMERALD_AXE.get());
                            output.accept(ModItems.PEMERALD_PICKAXE.get());
                            output.accept(ModItems.PEMERALD_SWORD.get());
                            output.accept(ModItems.PEMERALD_SHOVEL.get());
                            output.accept(ModItems.PEMERALD_HOE.get());
                            output.accept(ModItems.REMERALD_AXE.get());
                            output.accept(ModItems.REMERALD_PICKAXE.get());
                            output.accept(ModItems.REMERALD_SWORD.get());
                            output.accept(ModItems.REMERALD_SHOVEL.get());
                            output.accept(ModItems.REMERALD_HOE.get());
                            output.accept(ModItems.EMERALD_HELMET.get());
                            output.accept(ModItems.EMERALD_CHESTPLATE.get());
                            output.accept(ModItems.EMERALD_LEGGINGS.get());
                            output.accept(ModItems.EMERALD_BOOTS.get());
                        }

                        // --- Obsidian ---
                        if (Config.obsidianEnabled) {
                            output.accept(ModItems.OBINGOT.get());
                            output.accept(ModItems.OBSHARD.get());
                            output.accept(ModBlocks.SOBLOCK.get());
                            output.accept(ModBlocks.OBSHARD_BLOCK.get());
                            output.accept(ModItems.ROBSIDIAN_AXE.get());
                            output.accept(ModItems.ROBSIDIAN_PICKAXE.get());
                            output.accept(ModItems.ROBSIDIAN_SWORD.get());
                            output.accept(ModItems.ROBSIDIAN_SHOVEL.get());
                            output.accept(ModItems.ROBSIDIAN_HOE.get());
                            output.accept(ModItems.POBSIDIAN_AXE.get());
                            output.accept(ModItems.POBSIDIAN_PICKAXE.get());
                            output.accept(ModItems.POBSIDIAN_SWORD.get());
                            output.accept(ModItems.POBSIDIAN_SHOVEL.get());
                            output.accept(ModItems.POBSIDIAN_HOE.get());
                            output.accept(ModItems.OBSIDIAN_HELMET.get());
                            output.accept(ModItems.OBSIDIAN_CHESTPLATE.get());
                            output.accept(ModItems.OBSIDIAN_LEGGINGS.get());
                            output.accept(ModItems.OBSIDIAN_BOOTS.get());
                        }

                        // =============================================================
                        //  GHOST & ECTOPLASM
                        // =============================================================

                        if (Config.ghostEnabled) {
                            output.accept(ModItems.GHOST_SPAWN_EGG.get());
                            output.accept(ModItems.ECTOPLASM.get());
                        }

                        if (Config.spectralInfuserEnabled) {
                            output.accept(ModBlocks.SPECTRAL_INFUSER.get());
                        }

                        if (Config.ectoplasmSetEnabled) {
                            output.accept(ModBlocks.ECTOPLASM_BLOCK.get());
                            output.accept(ModItems.RECTO_SWORD.get());
                            output.accept(ModItems.RECTO_PICKAXE.get());
                            output.accept(ModItems.RECTO_SHOVEL.get());
                            output.accept(ModItems.RECTO_AXE.get());
                            output.accept(ModItems.RECTO_HOE.get());
                            output.accept(ModItems.REFINED_ECTOPLASM.get());
                            output.accept(ModBlocks.REFINED_ECTOPLASM_BLOCK.get());
                            output.accept(ModItems.ECTO_SWORD.get());
                            output.accept(ModItems.ECTO_PICKAXE.get());
                            output.accept(ModItems.ECTO_SHOVEL.get());
                            output.accept(ModItems.ECTO_AXE.get());
                            output.accept(ModItems.ECTO_HOE.get());
                            output.accept(ModItems.ECTO_HELMET.get());
                            output.accept(ModItems.ECTO_CHESTPLATE.get());
                            output.accept(ModItems.ECTO_LEGGINGS.get());
                            output.accept(ModItems.ECTO_BOOTS.get());
                        }

                        // =============================================================
                        //  OVERPOWER (end-game)
                        // =============================================================

                        if (Config.overpowerEnabled) {
                            output.accept(ModItems.OVERPOWER_AXE.get());
                            output.accept(ModItems.OVERPOWER_PICKAXE.get());
                            output.accept(ModItems.OVERPOWER_SWORD.get());
                            output.accept(ModItems.OVERPOWER_SHOVEL.get());
                            output.accept(ModItems.OVERPOWER_HELMET.get());
                            output.accept(ModItems.OVERPOWER_CHESTPLATE.get());
                            output.accept(ModItems.OVERPOWER_LEGGINGS.get());
                            output.accept(ModItems.OVERPOWER_BOOTS.get());
                        }

                        // =============================================================
                        //  FOOD SETS (edible novelty — weakest to strongest)
                        // =============================================================

                        // --- Cake ---
                        if (Config.cakeEnabled) {
                            output.accept(ModItems.CAKE_SWORD.get());
                            output.accept(ModItems.CAKE_PICKAXE.get());
                            output.accept(ModItems.CAKE_SHOVEL.get());
                            output.accept(ModItems.CAKE_AXE.get());
                            output.accept(ModItems.CAKE_HOE.get());
                            output.accept(ModItems.CAKE_HELMET.get());
                            output.accept(ModItems.CAKE_CHESTPLATE.get());
                            output.accept(ModItems.CAKE_LEGGINGS.get());
                            output.accept(ModItems.CAKE_BOOTS.get());
                        }

                        // --- Dried Kelp ---
                        if (Config.driedKelpEnabled) {
                            output.accept(ModItems.DRIED_KELP_SWORD.get());
                            output.accept(ModItems.DRIED_KELP_PICKAXE.get());
                            output.accept(ModItems.DRIED_KELP_SHOVEL.get());
                            output.accept(ModItems.DRIED_KELP_AXE.get());
                            output.accept(ModItems.DRIED_KELP_HOE.get());
                            output.accept(ModItems.DRIED_KELP_HELMET.get());
                            output.accept(ModItems.DRIED_KELP_CHESTPLATE.get());
                            output.accept(ModItems.DRIED_KELP_LEGGINGS.get());
                            output.accept(ModItems.DRIED_KELP_BOOTS.get());
                        }

                        // --- Rotten Flesh ---
                        if (Config.rottenFleshEnabled) {
                            output.accept(ModItems.ROTTEN_FLESH_SWORD.get());
                            output.accept(ModItems.ROTTEN_FLESH_PICKAXE.get());
                            output.accept(ModItems.ROTTEN_FLESH_SHOVEL.get());
                            output.accept(ModItems.ROTTEN_FLESH_AXE.get());
                            output.accept(ModItems.ROTTEN_FLESH_HOE.get());
                            output.accept(ModItems.ROTTEN_FLESH_HELMET.get());
                            output.accept(ModItems.ROTTEN_FLESH_CHESTPLATE.get());
                            output.accept(ModItems.ROTTEN_FLESH_LEGGINGS.get());
                            output.accept(ModItems.ROTTEN_FLESH_BOOTS.get());
                        }

                        // --- Bread ---
                        if (Config.breadEnabled) {
                            output.accept(ModItems.BREAD_SWORD.get());
                            output.accept(ModItems.BREAD_PICKAXE.get());
                            output.accept(ModItems.BREAD_SHOVEL.get());
                            output.accept(ModItems.BREAD_AXE.get());
                            output.accept(ModItems.BREAD_HOE.get());
                            output.accept(ModItems.BREAD_HELMET.get());
                            output.accept(ModItems.BREAD_CHESTPLATE.get());
                            output.accept(ModItems.BREAD_LEGGINGS.get());
                            output.accept(ModItems.BREAD_BOOTS.get());
                        }

                        // --- Sweet Berries ---
                        if (Config.sweetBerryEnabled) {
                            output.accept(ModItems.SWEET_BERRY_SWORD.get());
                            output.accept(ModItems.SWEET_BERRY_PICKAXE.get());
                            output.accept(ModItems.SWEET_BERRY_SHOVEL.get());
                            output.accept(ModItems.SWEET_BERRY_AXE.get());
                            output.accept(ModItems.SWEET_BERRY_HOE.get());
                            output.accept(ModItems.SWEET_BERRY_HELMET.get());
                            output.accept(ModItems.SWEET_BERRY_CHESTPLATE.get());
                            output.accept(ModItems.SWEET_BERRY_LEGGINGS.get());
                            output.accept(ModItems.SWEET_BERRY_BOOTS.get());
                        }

                        // --- Pumpkin Pie ---
                        if (Config.pumpkinPieEnabled) {
                            output.accept(ModItems.PUMPKIN_PIE_SWORD.get());
                            output.accept(ModItems.PUMPKIN_PIE_PICKAXE.get());
                            output.accept(ModItems.PUMPKIN_PIE_SHOVEL.get());
                            output.accept(ModItems.PUMPKIN_PIE_AXE.get());
                            output.accept(ModItems.PUMPKIN_PIE_HOE.get());
                            output.accept(ModItems.PUMPKIN_PIE_HELMET.get());
                            output.accept(ModItems.PUMPKIN_PIE_CHESTPLATE.get());
                            output.accept(ModItems.PUMPKIN_PIE_LEGGINGS.get());
                            output.accept(ModItems.PUMPKIN_PIE_BOOTS.get());
                        }

                        // --- Melon ---
                        if (Config.melonEnabled) {
                            output.accept(ModItems.MELON_SWORD.get());
                            output.accept(ModItems.MELON_PICKAXE.get());
                            output.accept(ModItems.MELON_SHOVEL.get());
                            output.accept(ModItems.MELON_AXE.get());
                            output.accept(ModItems.MELON_HOE.get());
                            output.accept(ModItems.MELON_HELMET.get());
                            output.accept(ModItems.MELON_CHESTPLATE.get());
                            output.accept(ModItems.MELON_LEGGINGS.get());
                            output.accept(ModItems.MELON_BOOTS.get());
                        }

                        // --- Mushroom ---
                        if (Config.mushroomEnabled) {
                            output.accept(ModItems.MUSHROOM_SWORD.get());
                            output.accept(ModItems.MUSHROOM_PICKAXE.get());
                            output.accept(ModItems.MUSHROOM_SHOVEL.get());
                            output.accept(ModItems.MUSHROOM_AXE.get());
                            output.accept(ModItems.MUSHROOM_HOE.get());
                            output.accept(ModItems.MUSHROOM_HELMET.get());
                            output.accept(ModItems.MUSHROOM_CHESTPLATE.get());
                            output.accept(ModItems.MUSHROOM_LEGGINGS.get());
                            output.accept(ModItems.MUSHROOM_BOOTS.get());
                        }

                        // --- Pufferfish ---
                        if (Config.pufferfishEnabled) {
                            output.accept(ModItems.PUFFERFISH_SWORD.get());
                            output.accept(ModItems.PUFFERFISH_PICKAXE.get());
                            output.accept(ModItems.PUFFERFISH_SHOVEL.get());
                            output.accept(ModItems.PUFFERFISH_AXE.get());
                            output.accept(ModItems.PUFFERFISH_HOE.get());
                            output.accept(ModItems.PUFFERFISH_HELMET.get());
                            output.accept(ModItems.PUFFERFISH_CHESTPLATE.get());
                            output.accept(ModItems.PUFFERFISH_LEGGINGS.get());
                            output.accept(ModItems.PUFFERFISH_BOOTS.get());
                        }

                        // --- Honey ---
                        if (Config.honeyEnabled) {
                            output.accept(ModItems.HONEY_SWORD.get());
                            output.accept(ModItems.HONEY_PICKAXE.get());
                            output.accept(ModItems.HONEY_SHOVEL.get());
                            output.accept(ModItems.HONEY_AXE.get());
                            output.accept(ModItems.HONEY_HOE.get());
                            output.accept(ModItems.HONEY_HELMET.get());
                            output.accept(ModItems.HONEY_CHESTPLATE.get());
                            output.accept(ModItems.HONEY_LEGGINGS.get());
                            output.accept(ModItems.HONEY_BOOTS.get());
                        }

                        // --- Chorus Fruit ---
                        if (Config.chorusFruitEnabled) {
                            output.accept(ModItems.CHORUS_FRUIT_SWORD.get());
                            output.accept(ModItems.CHORUS_FRUIT_PICKAXE.get());
                            output.accept(ModItems.CHORUS_FRUIT_SHOVEL.get());
                            output.accept(ModItems.CHORUS_FRUIT_AXE.get());
                            output.accept(ModItems.CHORUS_FRUIT_HOE.get());
                            output.accept(ModItems.CHORUS_FRUIT_HELMET.get());
                            output.accept(ModItems.CHORUS_FRUIT_CHESTPLATE.get());
                            output.accept(ModItems.CHORUS_FRUIT_LEGGINGS.get());
                            output.accept(ModItems.CHORUS_FRUIT_BOOTS.get());
                        }

                        // --- Golden Apple ---
                        if (Config.goldenAppleEnabled) {
                            output.accept(ModItems.GOLDEN_APPLE_SWORD.get());
                            output.accept(ModItems.GOLDEN_APPLE_PICKAXE.get());
                            output.accept(ModItems.GOLDEN_APPLE_SHOVEL.get());
                            output.accept(ModItems.GOLDEN_APPLE_AXE.get());
                            output.accept(ModItems.GOLDEN_APPLE_HOE.get());
                            output.accept(ModItems.GOLDEN_APPLE_HELMET.get());
                            output.accept(ModItems.GOLDEN_APPLE_CHESTPLATE.get());
                            output.accept(ModItems.GOLDEN_APPLE_LEGGINGS.get());
                            output.accept(ModItems.GOLDEN_APPLE_BOOTS.get());
                        }

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
