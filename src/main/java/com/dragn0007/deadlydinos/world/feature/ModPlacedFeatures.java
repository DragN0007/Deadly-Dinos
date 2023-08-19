package com.dragn0007.deadlydinos.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;

public class ModPlacedFeatures {

    //TREES
    public static final Holder<PlacedFeature> CONIFER_PLACED =
            PlacementUtils.register("conifer_placed",
                    ModConfigFeatures.CONIFER_SPAWN,
                    treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));

    public static final Holder<PlacedFeature> YEW_PLACED =
            PlacementUtils.register("yew_placed",
                    ModConfigFeatures.YEW_SPAWN,
                    treePlacement(PlacementUtils.countExtra(2, 0.5F, 2)));

    public static final Holder<PlacedFeature> SEQUOIA_PLACED =
            PlacementUtils.register("sequoia_placed",
                    ModConfigFeatures.SEQUOIA_SPAWN,
                    treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));



    //PLANTS
    public static final Holder<PlacedFeature> COOKSONIA_PLACED =
            PlacementUtils.register("cooksonia_placed",
                    ModConfigFeatures.COOKSONIA,
                    RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> CYPERUS_PLACED =
            PlacementUtils.register("cyperus_placed",
                    ModConfigFeatures.CYPERUS,
                    RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> CYCAS_PLACED =
            PlacementUtils.register("cycas_placed",
                    ModConfigFeatures.CYCAS,
                    RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> CYCADS_PLACED =
            PlacementUtils.register("cycads_placed",
                    ModConfigFeatures.CYCADS,
                    RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> ZOSTER_PLACED =
            PlacementUtils.register("zoster_placed",
                    ModConfigFeatures.ZOSTER,
                    RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


}
