package com.glisteningjade.myfirstmod.world.features;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PlacedFeatures {
    public static final PlacedFeature CHERRY_PLACED = PlacementUtils.register("cherry_placed", WorldConfiguredFeatures.CHERRY_TREE_CHECKED.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(1,0.1f,2))));
}
