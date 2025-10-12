package com.stonytark.usefultoolsmod.item;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import com.stonytark.usefultoolsmod.item.custom.Dynamite;
import com.stonytark.usefultoolsmod.item.custom.Grenade;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UsefultoolsMod.MOD_ID);

    public static final RegistryObject<Item> RGOLD = ITEMS.register("rgold",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> OBSHARD = ITEMS.register("obshard",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> SEM = ITEMS.register("sem",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> OBINGOT = ITEMS.register("obingot",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> GRENADE = ITEMS.register("grenade",
            () -> new Grenade(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> DYNAMITE = ITEMS.register("dynamite",
                    () -> new Dynamite(new Item.Properties()
                            .stacksTo(16)
                            .fireResistant()  // optional
                    )
            );


    public static final RegistryObject<Item> HRED = ITEMS.register("hred",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
