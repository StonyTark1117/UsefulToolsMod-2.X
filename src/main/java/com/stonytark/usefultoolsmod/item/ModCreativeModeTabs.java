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
                        output.accept(ModItems.RGOLD.get());
                        output.accept(ModItems.DYNAMITE.get());
                        output.accept(ModItems.GRENADE.get());
                        output.accept(ModItems.HRED.get());
                        output.accept(ModItems.OBINGOT.get());
                        output.accept(ModItems.OBSHARD.get());
                        output.accept(ModItems.SEM.get());
                        output.accept(ModBlocks.RGOLDBLOCK.get());
                        output.accept(ModBlocks.RGOLDORE.get());
                        output.accept(ModBlocks.HRBLOCK.get());
                        output.accept(ModBlocks.SEMBLOCK.get());
                        output.accept(ModBlocks.SOBLOCK.get());
                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
