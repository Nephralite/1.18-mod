package com.glisteningjade.myfirstmod.core.init;

import com.glisteningjade.myfirstmod.MyFirstMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lwjgl.system.CallbackI;

public final class ItemInit {
    private ItemInit() {}

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MyFirstMod.MODID);

    public static final Item.Properties BASIC = new Item.Properties().tab(MyFirstMod.TAB);
    public static final Item.Properties UNSTACKABLE = new Item.Properties().tab(MyFirstMod.TAB);

    //regular items
    public static final RegistryObject<Item> JADE = ITEMS.register("jade", () -> new Item(BASIC));

    public static final RegistryObject<ForgeSpawnEggItem> MIMIC_SPAWN_EGG = ITEMS.register("mimic_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.MIMIC, 0xA26B23,0xB24848, BASIC));

    //tools
    public static final RegistryObject<SwordItem> JADE_SWORD = ITEMS.register("jade_sword", () -> new SwordItem(TierInit.JADE_TOOL, 2, -2.4F, UNSTACKABLE));
    public static final RegistryObject<ShovelItem> JADE_SHOVEL = ITEMS.register("jade_shovel", () -> new ShovelItem(TierInit.JADE_TOOL, 5, -3.1F, UNSTACKABLE));
    public static final RegistryObject<HoeItem> JADE_HOE = ITEMS.register("jade_hoe", () -> new HoeItem(TierInit.JADE_TOOL, -3, -1.0F, UNSTACKABLE));
    public static final RegistryObject<PickaxeItem> JADE_PICKAXE = ITEMS.register("jade_pickaxe", () -> new PickaxeItem(TierInit.JADE_TOOL, 0, -2.8F,UNSTACKABLE));
    public static final RegistryObject<AxeItem> JADE_AXE = ITEMS.register("jade_axe", () -> new AxeItem(TierInit.JADE_TOOL, 0.5F, -3.0F, UNSTACKABLE));

    //armour
    public static final RegistryObject<ArmorItem> JADE_HELMET = ITEMS.register("jade_helmet", ()-> new ArmorItem(TierInit.JADE_ARMOR, EquipmentSlot.HEAD, UNSTACKABLE));
    public static final RegistryObject<ArmorItem> JADE_CHESTPLATE = ITEMS.register("jade_chestplate", ()-> new ArmorItem(TierInit.JADE_ARMOR, EquipmentSlot.CHEST, UNSTACKABLE));
    public static final RegistryObject<ArmorItem> JADE_LEGGINGS = ITEMS.register("jade_leggings", ()-> new ArmorItem(TierInit.JADE_ARMOR, EquipmentSlot.LEGS, UNSTACKABLE));
    public static final RegistryObject<ArmorItem> JADE_BOOTS = ITEMS.register("jade_boots", ()-> new ArmorItem(TierInit.JADE_ARMOR, EquipmentSlot.FEET, UNSTACKABLE));

    //BlockItems
    public static final RegistryObject<BlockItem> JADE_ORE_ITEM = ITEMS.register("jade_ore", () ->  new BlockItem(BlockInit.JADE_ORE.get(), BASIC));
    public static final RegistryObject<BlockItem> JADE_BLOCK_ITEM = ITEMS.register("jade_block", () ->  new BlockItem(BlockInit.JADE_BLOCK.get(), BASIC));
    public static final RegistryObject<BlockItem> JADE_BLOCK_SLAB_ITEM = ITEMS.register("jade_block_slab", () ->  new BlockItem(BlockInit.JADE_BLOCK_SLAB.get(), BASIC));
    public static final RegistryObject<BlockItem> JADE_BLOCK_STAIR_ITEM = ITEMS.register("jade_block_stairs", () ->  new BlockItem(BlockInit.JADE_BLOCK_STAIRS.get(), BASIC));
    public static final RegistryObject<BlockItem> DULLED_JADE_ITEM = ITEMS.register("dulled_jade", () ->  new BlockItem(BlockInit.DULLED_JADE.get(), BASIC));
    public static final RegistryObject<BlockItem> DEEPSLATE_JADE_ORE_ITEM = ITEMS.register("deepslate_jade_ore",() ->new BlockItem(BlockInit.DEEPSLATE_JADE_ORE.get(), BASIC));
    public static final RegistryObject<BlockItem> CHERRY_LOG_ITEM = ITEMS.register("cherry_log",() ->new BlockItem(BlockInit.CHERRY_LOG.get(), BASIC));
    public static final RegistryObject<BlockItem> STRIPPED_CHERRY_LOG_ITEM = ITEMS.register("stripped_cherry_log",() ->new BlockItem(BlockInit.STRIPPED_CHERRY_LOG.get(), BASIC));
    public static final RegistryObject<BlockItem> CHERRY_PLANKS_ITEM = ITEMS.register("cherry_planks",() ->new BlockItem(BlockInit.CHERRY_PLANKS.get(), BASIC));
    public static final RegistryObject<BlockItem> CHERRY_WOOD_ITEM = ITEMS.register("cherry_wood",() ->new BlockItem(BlockInit.CHERRY_WOOD.get(), BASIC));
    public static final RegistryObject<BlockItem> STRIPPED_CHERRY_WOOD_ITEM = ITEMS.register("stripped_cherry_wood",() ->new BlockItem(BlockInit.STRIPPED_CHERRY_WOOD.get(), BASIC));
    public static final RegistryObject<BlockItem> CHERRY_PLANKS_SLAB_ITEM = ITEMS.register("cherry_planks_slab",() ->new BlockItem(BlockInit.CHERRY_PLANKS_SLAB.get(), BASIC));
    public static final RegistryObject<BlockItem> CHERRY_PLANKS_STAIRS_ITEM = ITEMS.register("cherry_planks_stairs",() ->new BlockItem(BlockInit.CHERRY_PLANKS_STAIRS.get(), BASIC));
    public static final RegistryObject<SignItem> CHERRY_SIGN_ITEM = ITEMS.register("cherry_sign", () ->new SignItem(BASIC, BlockInit.CHERRY_SIGN.get(), BlockInit.CHERRY_SIGN_WALL.get()));
    public static final RegistryObject<BlockItem> CHERRY_BUTTON_ITEM = ITEMS.register("cherry_button",() ->new BlockItem(BlockInit.CHERRY_BUTTON.get(), BASIC));
    public static final RegistryObject<BlockItem> CHERRY_FENCE_ITEM = ITEMS.register("cherry_fence",() ->new BlockItem(BlockInit.CHERRY_FENCE.get(), BASIC));
    public static final RegistryObject<BlockItem> CHERRY_FENCE_GATE_ITEM = ITEMS.register("cherry_fence_gate",() ->new BlockItem(BlockInit.CHERRY_FENCE_GATE.get(), BASIC));
    public static final RegistryObject<BlockItem> CHERRY_PRESSURE_PLATE_ITEM = ITEMS.register("cherry_pressure_plate",() ->new BlockItem(BlockInit.CHERRY_PRESSURE_PLATE.get(), BASIC));
    public static final RegistryObject<BlockItem> CHERRY_DOOR_ITEM = ITEMS.register("cherry_door",() ->new BlockItem(BlockInit.CHERRY_DOOR.get(), BASIC));
    public static final RegistryObject<BlockItem> CHERRY_TRAPDOOR_ITEM = ITEMS.register("cherry_trapdoor",() ->new BlockItem(BlockInit.CHERRY_TRAPDOOR.get(), BASIC));
    public static final RegistryObject<BlockItem> CHERRY_LEAVES_ITEM = ITEMS.register("cherry_leaves",() ->new BlockItem(BlockInit.CHERRY_LEAVES.get(),BASIC));
    public static final RegistryObject<BlockItem> CHERRY_SAPLING_ITEM = ITEMS.register("cherry_sapling",() ->new BlockItem(BlockInit.CHERRY_SAPLING.get(),BASIC));
}