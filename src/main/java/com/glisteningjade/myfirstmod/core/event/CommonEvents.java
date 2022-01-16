package com.glisteningjade.myfirstmod.core.event;

import com.glisteningjade.myfirstmod.MyFirstMod;
import com.glisteningjade.myfirstmod.common.entity.Mimic;
import com.glisteningjade.myfirstmod.core.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= MyFirstMod.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.MIMIC.get(), Mimic.createAttributes().build());
    }
}
