package com.glisteningjade.myfirstmod.core.init;

import com.glisteningjade.myfirstmod.MyFirstMod;
import com.glisteningjade.myfirstmod.world.features.tree.CherryTreeGrower;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    private BlockInit() {}
    //note: strength(hardness, blast r.)
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MyFirstMod.MODID);
    //shortcuts
    private static final BlockBehaviour.Properties JADEY = BlockBehaviour.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_GREEN).strength(3.0f, 4.0f).sound(SoundType.METAL).requiresCorrectToolForDrops();
    private static final BlockBehaviour.Properties CHERRY = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(2.0f,2.0f).sound(SoundType.WOOD); //not flammable
    //blocks
    public static final RegistryObject<Block> JADE_ORE = BLOCKS.register("jade_ore", () ->new Block(Block.Properties.of(Material.METAL).strength(3.0f, 4.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> JADE_BLOCK = BLOCKS.register("jade_block", () ->new Block(JADEY));
    public static final RegistryObject<Block> DULLED_JADE = BLOCKS.register("dulled_jade", () ->new Block(JADEY));
    public static final RegistryObject<SlabBlock> JADE_BLOCK_SLAB = BLOCKS.register("jade_block_slab", () ->new SlabBlock(JADEY));
    public static final RegistryObject<StairBlock> JADE_BLOCK_STAIRS = BLOCKS.register("jade_block_stairs", () ->new StairBlock(() -> JADE_BLOCK.get().defaultBlockState(), JADEY));
    public static final RegistryObject<Block> DEEPSLATE_JADE_ORE = BLOCKS.register("deepslate_jade_ore", () ->new Block(Block.Properties.of(Material.METAL).strength(4.5f,4.0f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final RegistryObject<RotatedPillarBlock> CHERRY_LOG = BLOCKS.register("cherry_log", () ->new RotatedPillarBlock(CHERRY));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_CHERRY_LOG = BLOCKS.register("stripped_cherry_log", () ->new RotatedPillarBlock(CHERRY));//uncraftable
    public static final RegistryObject<Block> CHERRY_WOOD = BLOCKS.register("cherry_wood", () ->new Block(CHERRY));//uncraftable
    public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = BLOCKS.register("stripped_cherry_wood", () ->new Block(CHERRY));//uncraftable
    public static final RegistryObject<LeavesBlock> CHERRY_LEAVES = BLOCKS.register("cherry_leaves", () ->new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<SaplingBlock> CHERRY_SAPLING = BLOCKS.register("cherry_sapling", () ->new SaplingBlock(new CherryTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> CHERRY_PLANKS = BLOCKS.register("cherry_planks", () ->new Block(CHERRY));
    public static final RegistryObject<SlabBlock> CHERRY_PLANKS_SLAB = BLOCKS.register("cherry_planks_slab", () ->new SlabBlock(CHERRY));
    public static final RegistryObject<StairBlock> CHERRY_PLANKS_STAIRS = BLOCKS.register("cherry_planks_stairs", () ->new StairBlock(() -> CHERRY_PLANKS.get().defaultBlockState(), CHERRY));
    public static final RegistryObject<DoorBlock> CHERRY_DOOR = BLOCKS.register("cherry_door", () ->new DoorBlock(CHERRY));
    public static final RegistryObject<TrapDoorBlock> CHERRY_TRAPDOOR = BLOCKS.register("cherry_trapdoor", () -> new TrapDoorBlock(CHERRY));
    //cherry boat?
    public static final RegistryObject<WoodButtonBlock> CHERRY_BUTTON = BLOCKS.register("cherry_button", () ->new WoodButtonBlock(CHERRY));
    public static final RegistryObject<FenceBlock> CHERRY_FENCE = BLOCKS.register("cherry_fence", () ->new FenceBlock(CHERRY));//uncraftable
    public static final RegistryObject<FenceGateBlock> CHERRY_FENCE_GATE = BLOCKS.register("cherry_fence_gate",() ->new FenceGateBlock(CHERRY));//uncraftable
    public static final RegistryObject<PressurePlateBlock> CHERRY_PRESSURE_PLATE = BLOCKS.register("cherry_pressure_plate", () ->new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, CHERRY));
    public static final RegistryObject<StandingSignBlock> CHERRY_SIGN = BLOCKS.register("cherry_sign", () ->new StandingSignBlock(CHERRY, WoodType.OAK)); //make new woodtype, not working
    public static final RegistryObject<WallSignBlock> CHERRY_SIGN_WALL = BLOCKS.register("cherry_sign_wall", () ->new WallSignBlock(CHERRY, WoodType.OAK)); //ditto


}
