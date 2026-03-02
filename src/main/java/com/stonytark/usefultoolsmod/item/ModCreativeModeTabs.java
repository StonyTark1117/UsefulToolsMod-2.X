package com.stonytark.usefultoolsmod.item;

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

                        output.accept(ModItems.DYNAMITE.get());
                        output.accept(ModItems.GRENADE.get());

                        output.accept(ModItems.OBINGOT.get());
                        output.accept(ModItems.OBSHARD.get());
                        output.accept(ModBlocks.SOBLOCK.get());
                        output.accept(ModItems.JOBSIDIAN_AXE.get());
                        output.accept(ModItems.JOBSIDIAN_PICKAXE.get());
                        output.accept(ModItems.JOBSIDIAN_SWORD.get());
                        output.accept(ModItems.JOBSIDIAN_SHOVEL.get());
                        output.accept(ModItems.JOBSIDIAN_HOE.get());
                        output.accept(ModItems.SOBSIDIAN_AXE.get());
                        output.accept(ModItems.SOBSIDIAN_PICKAXE.get());
                        output.accept(ModItems.SOBSIDIAN_SWORD.get());
                        output.accept(ModItems.SOBSIDIAN_SHOVEL.get());
                        output.accept(ModItems.SOBSIDIAN_HOE.get());
                        output.accept(ModItems.OBSIDIAN_HELMET.get());
                        output.accept(ModItems.OBSIDIAN_CHESTPLATE.get());
                        output.accept(ModItems.OBSIDIAN_LEGGINGS.get());
                        output.accept(ModItems.OBSIDIAN_BOOTS.get());

                        output.accept(ModBlocks.SEMBLOCK.get());
                        output.accept(ModItems.SEM.get());
                        output.accept(ModItems.SEMERALD_AXE.get());
                        output.accept(ModItems.SEMERALD_PICKAXE.get());
                        output.accept(ModItems.SEMERALD_SWORD.get());
                        output.accept(ModItems.SEMERALD_SHOVEL.get());
                        output.accept(ModItems.SEMERALD_HOE.get());
                        output.accept(ModItems.JEMERALD_AXE.get());
                        output.accept(ModItems.JEMERALD_PICKAXE.get());
                        output.accept(ModItems.JEMERALD_SWORD.get());
                        output.accept(ModItems.JEMERALD_SHOVEL.get());
                        output.accept(ModItems.JEMERALD_HOE.get());
                        output.accept(ModItems.EMERALD_HELMET.get());
                        output.accept(ModItems.EMERALD_CHESTPLATE.get());
                        output.accept(ModItems.EMERALD_LEGGINGS.get());
                        output.accept(ModItems.EMERALD_BOOTS.get());

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

                        output.accept(ModBlocks.RGOLDBLOCK.get());
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

                        output.accept(ModItems.HGLOW.get());
                        output.accept(ModItems.HGLOWSTONE_AXE.get());
                        output.accept(ModItems.HGLOWSTONE_PICKAXE.get());
                        output.accept(ModItems.HGLOWSTONE_SWORD.get());
                        output.accept(ModItems.HGLOWSTONE_SHOVEL.get());
                        output.accept(ModItems.HGLOWSTONE_HOE.get());
                        output.accept(ModItems.HGLOW_HELMET.get());
                        output.accept(ModItems.HGLOW_CHESTPLATE.get());
                        output.accept(ModItems.HGLOW_LEGGINGS.get());
                        output.accept(ModItems.HGLOW_BOOTS.get());

                        output.accept(ModItems.OVERPOWER_AXE.get());
                        output.accept(ModItems.OVERPOWER_PICKAXE.get());
                        output.accept(ModItems.OVERPOWER_SWORD.get());
                        output.accept(ModItems.OVERPOWER_SHOVEL.get());
                        output.accept(ModItems.OVERPOWER_HELMET.get());
                        output.accept(ModItems.OVERPOWER_CHESTPLATE.get());
                        output.accept(ModItems.OVERPOWER_LEGGINGS.get());
                        output.accept(ModItems.OVERPOWER_BOOTS.get());

                        output.accept(ModItems.GHOST_SPAWN_EGG.get());
                        output.accept(ModItems.ECTOPLASM.get());
                        output.accept(ModBlocks.SPECTRAL_INFUSER.get());

                        // Raw metal jagged tools
                        output.accept(ModItems.JRAW_GOLD_SWORD.get());
                        output.accept(ModItems.JRAW_GOLD_PICKAXE.get());
                        output.accept(ModItems.JRAW_GOLD_SHOVEL.get());
                        output.accept(ModItems.JRAW_GOLD_AXE.get());
                        output.accept(ModItems.JRAW_GOLD_HOE.get());

                        output.accept(ModItems.JRAW_COPPER_SWORD.get());
                        output.accept(ModItems.JRAW_COPPER_PICKAXE.get());
                        output.accept(ModItems.JRAW_COPPER_SHOVEL.get());
                        output.accept(ModItems.JRAW_COPPER_AXE.get());
                        output.accept(ModItems.JRAW_COPPER_HOE.get());

                        output.accept(ModItems.JRAW_IRON_SWORD.get());
                        output.accept(ModItems.JRAW_IRON_PICKAXE.get());
                        output.accept(ModItems.JRAW_IRON_SHOVEL.get());
                        output.accept(ModItems.JRAW_IRON_AXE.get());
                        output.accept(ModItems.JRAW_IRON_HOE.get());

                        output.accept(ModItems.JRAW_RGOLD_SWORD.get());
                        output.accept(ModItems.JRAW_RGOLD_PICKAXE.get());
                        output.accept(ModItems.JRAW_RGOLD_SHOVEL.get());
                        output.accept(ModItems.JRAW_RGOLD_AXE.get());
                        output.accept(ModItems.JRAW_RGOLD_HOE.get());

                        output.accept(ModItems.JSCRAP_SWORD.get());
                        output.accept(ModItems.JSCRAP_PICKAXE.get());
                        output.accept(ModItems.JSCRAP_SHOVEL.get());
                        output.accept(ModItems.JSCRAP_AXE.get());
                        output.accept(ModItems.JSCRAP_HOE.get());

                        // Crystal / element material items
                        output.accept(ModItems.CALCIFIED_AMETHYST.get());
                        output.accept(ModItems.GLACIAL_SHARD.get());
                        output.accept(ModItems.POLISHED_QUARTZ.get());
                        output.accept(ModItems.POLISHED_PRISMARINE.get());

                        // Jagged Amethyst tools
                        output.accept(ModItems.JAMETHYST_SWORD.get());
                        output.accept(ModItems.JAMETHYST_PICKAXE.get());
                        output.accept(ModItems.JAMETHYST_SHOVEL.get());
                        output.accept(ModItems.JAMETHYST_AXE.get());
                        output.accept(ModItems.JAMETHYST_HOE.get());

                        // Snow tools
                        output.accept(ModItems.SNOW_SWORD.get());
                        output.accept(ModItems.SNOW_PICKAXE.get());
                        output.accept(ModItems.SNOW_SHOVEL.get());
                        output.accept(ModItems.SNOW_AXE.get());
                        output.accept(ModItems.SNOW_HOE.get());

                        // Jagged Quartz tools
                        output.accept(ModItems.JQUARTZ_SWORD.get());
                        output.accept(ModItems.JQUARTZ_PICKAXE.get());
                        output.accept(ModItems.JQUARTZ_SHOVEL.get());
                        output.accept(ModItems.JQUARTZ_AXE.get());
                        output.accept(ModItems.JQUARTZ_HOE.get());

                        // Jagged Prismarine tools
                        output.accept(ModItems.JPRISM_SWORD.get());
                        output.accept(ModItems.JPRISM_PICKAXE.get());
                        output.accept(ModItems.JPRISM_SHOVEL.get());
                        output.accept(ModItems.JPRISM_AXE.get());
                        output.accept(ModItems.JPRISM_HOE.get());

                        // Calcite Amethyst set
                        output.accept(ModItems.CAMETHYST_SWORD.get());
                        output.accept(ModItems.CAMETHYST_PICKAXE.get());
                        output.accept(ModItems.CAMETHYST_SHOVEL.get());
                        output.accept(ModItems.CAMETHYST_AXE.get());
                        output.accept(ModItems.CAMETHYST_HOE.get());
                        output.accept(ModItems.CAMETHYST_HELMET.get());
                        output.accept(ModItems.CAMETHYST_CHESTPLATE.get());
                        output.accept(ModItems.CAMETHYST_LEGGINGS.get());
                        output.accept(ModItems.CAMETHYST_BOOTS.get());

                        // Ice (Glacial) set
                        output.accept(ModItems.ICE_SWORD.get());
                        output.accept(ModItems.ICE_PICKAXE.get());
                        output.accept(ModItems.ICE_SHOVEL.get());
                        output.accept(ModItems.ICE_AXE.get());
                        output.accept(ModItems.ICE_HOE.get());
                        output.accept(ModItems.ICE_HELMET.get());
                        output.accept(ModItems.ICE_CHESTPLATE.get());
                        output.accept(ModItems.ICE_LEGGINGS.get());
                        output.accept(ModItems.ICE_BOOTS.get());

                        // Smooth Quartz set
                        output.accept(ModItems.SQUARTZ_SWORD.get());
                        output.accept(ModItems.SQUARTZ_PICKAXE.get());
                        output.accept(ModItems.SQUARTZ_SHOVEL.get());
                        output.accept(ModItems.SQUARTZ_AXE.get());
                        output.accept(ModItems.SQUARTZ_HOE.get());
                        output.accept(ModItems.SQUARTZ_HELMET.get());
                        output.accept(ModItems.SQUARTZ_CHESTPLATE.get());
                        output.accept(ModItems.SQUARTZ_LEGGINGS.get());
                        output.accept(ModItems.SQUARTZ_BOOTS.get());

                        // Smooth Prismarine set
                        output.accept(ModItems.SPRISM_SWORD.get());
                        output.accept(ModItems.SPRISM_PICKAXE.get());
                        output.accept(ModItems.SPRISM_SHOVEL.get());
                        output.accept(ModItems.SPRISM_AXE.get());
                        output.accept(ModItems.SPRISM_HOE.get());
                        output.accept(ModItems.SPRISM_HELMET.get());
                        output.accept(ModItems.SPRISM_CHESTPLATE.get());
                        output.accept(ModItems.SPRISM_LEGGINGS.get());
                        output.accept(ModItems.SPRISM_BOOTS.get());

                        // Flint tools
                        output.accept(ModItems.JFLINT_SWORD.get());
                        output.accept(ModItems.JFLINT_PICKAXE.get());
                        output.accept(ModItems.JFLINT_SHOVEL.get());
                        output.accept(ModItems.JFLINT_AXE.get());
                        output.accept(ModItems.JFLINT_HOE.get());

                        // Flint-Iron set
                        output.accept(ModItems.FNI_SWORD.get());
                        output.accept(ModItems.FNI_PICKAXE.get());
                        output.accept(ModItems.FNI_SHOVEL.get());
                        output.accept(ModItems.FNI_AXE.get());
                        output.accept(ModItems.FNI_HOE.get());
                        output.accept(ModItems.FNI_HELMET.get());
                        output.accept(ModItems.FNI_CHESTPLATE.get());
                        output.accept(ModItems.FNI_LEGGINGS.get());
                        output.accept(ModItems.FNI_BOOTS.get());

                        // Stone Rock Variant tools
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

                        // Coal set
                        output.accept(ModItems.COAL_DUST.get());
                        output.accept(ModItems.HARDENED_COAL.get());
                        output.accept(ModItems.COAL_SWORD.get());
                        output.accept(ModItems.COAL_PICKAXE.get());
                        output.accept(ModItems.COAL_SHOVEL.get());
                        output.accept(ModItems.COAL_AXE.get());
                        output.accept(ModItems.COAL_HOE.get());
                        output.accept(ModItems.COAL_HELMET.get());
                        output.accept(ModItems.COAL_CHESTPLATE.get());
                        output.accept(ModItems.COAL_LEGGINGS.get());
                        output.accept(ModItems.COAL_BOOTS.get());

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
