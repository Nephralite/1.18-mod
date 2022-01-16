package com.glisteningjade.myfirstmod.core.init;

import com.glisteningjade.myfirstmod.MyFirstMod;
import com.glisteningjade.myfirstmod.common.entity.Mimic;
import net.minecraft.ResourceLocationException;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MyFirstMod.MODID);

    public static final RegistryObject<EntityType<Mimic>> MIMIC = ENTITIES.register("mimic", () -> EntityType.Builder.of(Mimic::new, MobCategory.CREATURE).sized(1.0F,1.0F).build(new ResourceLocation(MyFirstMod.MODID,"mimic").toString()));
}
