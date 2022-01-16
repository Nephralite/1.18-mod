package com.glisteningjade.myfirstmod.client.renderer;

import com.glisteningjade.myfirstmod.MyFirstMod;
import com.glisteningjade.myfirstmod.client.renderer.model.MimicModel;
import com.glisteningjade.myfirstmod.common.entity.Mimic;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MimicRenderer<Type extends Mimic> extends MobRenderer<Type, MimicModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(MyFirstMod.MODID, "textures/entity/mimic.png");

    public MimicRenderer(EntityRendererProvider.Context context) {
        super(context, new MimicModel<>(context.bakeLayer(MimicModel.LAYER_LOCATION)), 1.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }
}
