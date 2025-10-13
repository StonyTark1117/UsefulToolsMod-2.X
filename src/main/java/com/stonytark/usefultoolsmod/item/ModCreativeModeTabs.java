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


                        output.accept(ModBlocks.RGOLDBLOCK.get());
                        output.accept(ModBlocks.RGOLDORE.get());
                        output.accept(ModItems.RGOLD.get());
                        output.accept(ModItems.RGOLD_AXE.get());
                        output.accept(ModItems.RGOLD_PICKAXE.get());
                        output.accept(ModItems.RGOLD_SWORD.get());
                        output.accept(ModItems.RGOLD_SHOVEL.get());
                        output.accept(ModItems.RGOLD_HOE.get());

                        output.accept(ModItems.HRED.get());
                        output.accept(ModBlocks.HRBLOCK.get());
                        output.accept(ModItems.HREDSTONE_AXE.get());
                        output.accept(ModItems.HREDSTONE_PICKAXE.get());
                        output.accept(ModItems.HREDSTONE_SWORD.get());
                        output.accept(ModItems.HREDSTONE_SHOVEL.get());
                        output.accept(ModItems.HREDSTONE_HOE.get());

                        output.accept(ModItems.OVERPOWER_AXE.get());
                        output.accept(ModItems.OVERPOWER_PICKAXE.get());
                        output.accept(ModItems.OVERPOWER_SWORD.get());
                        output.accept(ModItems.OVERPOWER_SHOVEL.get());

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
