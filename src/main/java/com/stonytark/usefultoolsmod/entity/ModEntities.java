package com.stonytark.usefultoolsmod.entity;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, UsefultoolsMod.MOD_ID);

    public static final RegistryObject<EntityType<EntityGrenade>> GRENADE =
            ENTITY_TYPES.register("grenade",
                    () -> EntityType.Builder.<EntityGrenade>of(EntityGrenade::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(10)
                            .build("grenade") // <-- just use the name as a string
            );

    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
    }
}