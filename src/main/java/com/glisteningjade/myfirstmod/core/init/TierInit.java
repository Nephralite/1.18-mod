package com.glisteningjade.myfirstmod.core.init;

import com.glisteningjade.myfirstmod.MyFirstMod;
import com.glisteningjade.myfirstmod.core.util.ArmorTier;
import com.glisteningjade.myfirstmod.core.util.ItemTier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class TierInit {
    private TierInit() {}

    protected static final Tier JADE_TOOL = new ItemTier(3.0F,13,3,7.0F,250,() -> Ingredient.of(ItemInit.JADE.get()));
    protected static final ArmorMaterial JADE_ARMOR = new ArmorTier(18, new int[]{11, 16, 15, 13}, new int[] {2,5,6,2}, 0,1.0F, MyFirstMod.MODID+":jade", SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.of(ItemInit.JADE.get()));
}
