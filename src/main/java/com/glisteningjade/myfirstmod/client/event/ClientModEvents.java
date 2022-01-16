package com.glisteningjade.myfirstmod.client.event;

import com.glisteningjade.myfirstmod.MyFirstMod;
import com.glisteningjade.myfirstmod.client.renderer.MimicRenderer;
import com.glisteningjade.myfirstmod.client.renderer.model.MimicModel;
import com.glisteningjade.myfirstmod.core.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid=MyFirstMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value= Dist.CLIENT)
public final class ClientModEvents  {
    private ClientModEvents() {}

    @SubscribeEvent
    public static void clientSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MimicModel.LAYER_LOCATION, MimicModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.MIMIC.get(), MimicRenderer::new);
    }
}
