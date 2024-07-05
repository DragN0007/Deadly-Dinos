package com.dragn0007.deadlydinos.world.feature.tree;

import com.dragn0007.deadlydinos.world.feature.DDDConfigFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ConiferTreeGrower extends AbstractMegaTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(Random p_204306_) {
        return DDDConfigFeatures.CONIFER;
    }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204307_, boolean p_204308_) {
        return null;
    }
}
