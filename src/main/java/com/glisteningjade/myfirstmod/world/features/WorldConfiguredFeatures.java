package com.glisteningjade.myfirstmod.world.features;

import com.glisteningjade.myfirstmod.core.init.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

public class WorldConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> CHERRY = register( "cherry", Feature.TREE.configured(new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(BlockInit.CHERRY_LOG.get()), //log of tree
            new StraightTrunkPlacer(5, 2, 2), //length of trunk, 5,7 or 9
            BlockStateProvider.simple(BlockInit.CHERRY_LEAVES.get()), //leaf of tree
            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), //foliage type
            new TwoLayersFeatureSize(1, 0, 1)).build())); //idk

    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> CHERRY_TREE_CHECKED = FeatureUtils.register( "cherry_feature",
            Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                    CHERRY.filteredByBlockSurvival(BlockInit.CHERRY_SAPLING.get()), 0.1f)),
                    CHERRY.filteredByBlockSurvival(BlockInit.CHERRY_SAPLING.get()))));

    private static <FC extends FeatureConfiguration>ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature){
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, name, configuredFeature);
    }
}
