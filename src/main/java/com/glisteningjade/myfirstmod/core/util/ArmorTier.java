package com.glisteningjade.myfirstmod.core.util;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class ArmorTier implements ArmorMaterial {
    private final int enchantability;
    private final int[] durability, damageReduction; // 1){11, 16, 15, 13} on normal armor  2)Armor Bar Protection, 1 = 1/2 armor bar
    private final float knockbackResistance, toughness; //1.0F=No Knockback, 0.0F=Disabled. Toughness Increases Protection, 0.0F=Iron/Gold/Leather, 2.0F=Diamond, 3.0F=Netherite
    private final String name;
    private final SoundEvent equipSound;
    private final Supplier<Ingredient> repairMaterial;

    public ArmorTier(int enchantability, int[] durability, int[] damageReduction,
                     float knockbackResistance, float toughness, String name, SoundEvent equipSound,
                     Supplier<Ingredient> repairMaterial) {
        this.enchantability = enchantability;
        this.durability = durability;
        this.damageReduction = damageReduction;
        this.knockbackResistance = knockbackResistance;
        this.toughness = toughness;
        this.name = name;
        this.equipSound = equipSound;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return this.durability[slot.getIndex()];
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.damageReduction[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
