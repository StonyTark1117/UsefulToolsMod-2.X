package com.stonytark.usefultoolsmod.client;

import com.stonytark.usefultoolsmod.entity.ModEntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderers {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Registers your grenade entity to use the ThrownItemRenderer
        event.registerEntityRenderer(ModEntities.GRENADE.get(), ThrownItemRenderer::new);
    }

}