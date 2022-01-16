package com.glisteningjade.myfirstmod.world.features.tree;

import com.glisteningjade.myfirstmod.world.features.WorldConfiguredFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CherryTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random pRandom, boolean pLargeHive) {
         return (ConfiguredFeature<TreeConfiguration, ?>) WorldConfiguredFeatures.CHERRY;
    }
}
