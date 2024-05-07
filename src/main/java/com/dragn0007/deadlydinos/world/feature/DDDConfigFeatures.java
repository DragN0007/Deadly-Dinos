package com.dragn0007.deadlydinos.world.feature;

import com.dragn0007.deadlydinos.block.DDDBlocks;
import com.dragn0007.deadlydinos.block.DDDBlocksDataGen;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class DDDConfigFeatures {


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> COOKSONIA =
            FeatureUtils.register("cooksonia", Feature.FLOWER,
                    new RandomPatchConfiguration(15, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(DDDBlocks.COOKSONIA.get())))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CYCAS =
            FeatureUtils.register("cycas", Feature.FLOWER,
                    new RandomPatchConfiguration(15, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(DDDBlocks.CYCAS.get())))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CYPERUS =
            FeatureUtils.register("cyperus", Feature.FLOWER,
                    new RandomPatchConfiguration(15, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(DDDBlocks.CYPERUS.get())))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ZOSTER =
            FeatureUtils.register("zoster", Feature.FLOWER,
                    new RandomPatchConfiguration(15, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(DDDBlocks.ZOSTER.get())))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CYCADS =
            FeatureUtils.register("cycads", Feature.FLOWER,
                    new RandomPatchConfiguration(15, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(DDDBlocks.CYCADS.get())))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CALAMITES =
            FeatureUtils.register("calamites", Feature.FLOWER,
                    new RandomPatchConfiguration(15, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(DDDBlocks.CALAMITES.get())))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> HORSETAIL =
            FeatureUtils.register("horsetail", Feature.FLOWER,
                    new RandomPatchConfiguration(15, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(DDDBlocksDataGen.HORSETAIL.get())))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ASTEROXYLON =
            FeatureUtils.register("asteroxylon", Feature.FLOWER,
                    new RandomPatchConfiguration(15, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(DDDBlocksDataGen.ASTEROXYLON.get())))));



    //CONIFER
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CONIFER = FeatureUtils.register("conifer",Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(DDDBlocks.CONIFERLOG.get()),
            new GiantTrunkPlacer(17, 8, 18),
            BlockStateProvider.simple(DDDBlocks.CONIFERLEAVES.get()),
            new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)),
            new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(
            new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL)))).build());
    public static final Holder<PlacedFeature> CONIFER_CHECKED =
            PlacementUtils.register("conifer_checked",
            CONIFER, PlacementUtils.filteredByBlockSurvival(DDDBlocks.CONIFERSAPLING.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CONIFER_SPAWN =
            FeatureUtils.register("conifer_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(CONIFER_CHECKED, 0.1F)), CONIFER_CHECKED));


    //YEW
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> YEW = FeatureUtils.register("yew",Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(DDDBlocks.YEWLOG.get()),
            new StraightTrunkPlacer(2, 1, 0),
            BlockStateProvider.simple(DDDBlocks.YEWLEAVES.get()),
            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 1),
            new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
    public static final Holder<PlacedFeature> YEW_CHECKED =
            PlacementUtils.register("yew_checked",
                    YEW, PlacementUtils.filteredByBlockSurvival(DDDBlocks.YEWSAPLING.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> YEW_SPAWN =
            FeatureUtils.register("yew_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(
                            new WeightedPlacedFeature(YEW_CHECKED, 0.3F)), YEW_CHECKED));


    //SEQUOIA
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SEQUOIA = FeatureUtils.register("sequoia",Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(DDDBlocks.SEQUOIALOG.get()),
            new GiantTrunkPlacer(17, 8, 18),
            BlockStateProvider.simple(DDDBlocks.SEQUOIALEAVES.get()),
            new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)),
            new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(
            new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL)))).build());
    public static final Holder<PlacedFeature> SEQUOIA_CHECKED =
            PlacementUtils.register("sequoia_checked",
                    SEQUOIA, PlacementUtils.filteredByBlockSurvival(DDDBlocks.SEQUOIASAPLING.get()));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SEQUOIA_SPAWN =
            FeatureUtils.register("sequoia_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(
                            new WeightedPlacedFeature(SEQUOIA_CHECKED, 0.1F)), SEQUOIA_CHECKED));

}


