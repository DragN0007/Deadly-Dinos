package com.dragn0007.deadlydinos.world.gen;

import com.dragn0007.deadlydinos.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;

public class ModFlowerGeneration {

    public static void generateFlowers(final BiomeLoadingEvent event) {
        ResourceKey<Biome> key = ResourceKey.create(ForgeRegistries.Keys.BIOMES, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);



        if (types.contains(BiomeDictionary.Type.LUSH)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.COOKSONIA_PLACED);
        }
        if (types.contains(BiomeDictionary.Type.HOT)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.COOKSONIA_PLACED);
        }


        if (types.contains(BiomeDictionary.Type.LUSH)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.CYCADS_PLACED);
        }
        if (types.contains(BiomeDictionary.Type.HOT)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.CYCADS_PLACED);
        }


        if (types.contains(BiomeDictionary.Type.LUSH)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.ZOSTER_PLACED);
        }
        if (types.contains(BiomeDictionary.Type.HOT)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.ZOSTER_PLACED);
        }


        if (types.contains(BiomeDictionary.Type.LUSH)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.CYCAS_PLACED);
        }
        if (types.contains(BiomeDictionary.Type.HOT)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.CYCAS_PLACED);
        }


        if (types.contains(BiomeDictionary.Type.LUSH)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.CYPERUS_PLACED);
        }
        if (types.contains(BiomeDictionary.Type.HOT)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.CYPERUS_PLACED);
        }



    }
}
