package com.glisteningjade.myfirstmod.world.gen;

import com.glisteningjade.myfirstmod.MyFirstMod;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MyFirstMod.MODID)
public class WorldGenerationEvents {
    @SubscribeEvent
    public static void ModWorldGeneration(final BiomeLoadingEvent event) {
        TreeGeneration.generateTrees(event);
    }
}
