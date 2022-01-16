package com.glisteningjade.myfirstmod.core.init;

import com.glisteningjade.myfirstmod.MyFirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit { //hook on register to use, here as demonstration
    private SoundInit() {}

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MyFirstMod.MODID);

    public static final RegistryObject<SoundEvent> MIMIC_AMBIENT = SOUNDS.register("entity.mimic.ambient", () -> new SoundEvent(new ResourceLocation(MyFirstMod.MODID, "enitity.mimic.ambient")));
}
