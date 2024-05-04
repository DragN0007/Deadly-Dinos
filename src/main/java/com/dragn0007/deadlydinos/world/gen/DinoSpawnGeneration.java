package com.dragn0007.deadlydinos.world.gen;

import com.dragn0007.deadlydinos.entity.util.EntityTypes;
import com.dragn0007.deadlydinos.util.config.DeadlyDinosCommonConfig;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;
import java.util.List;

public class DinoSpawnGeneration {
    public static void onEntitySpawn(final BiomeLoadingEvent event) {

        addEntityToSpecificBiomes(event, EntityTypes.ACRO_ENTITY.get(),
                DeadlyDinosCommonConfig.ACRO_WEIGHT.get(), 1, 1,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS
        );

        addEntityToSpecificBiomes(event, EntityTypes.ALBERTO_ENTITY.get(),
                DeadlyDinosCommonConfig.ALBERTO_WEIGHT.get(), 1, 1,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
                Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.STONY_PEAKS,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU
        );

        addEntityToSpecificBiomes(event, EntityTypes.ANDAL_ENTITY.get(),
                DeadlyDinosCommonConfig.ANDAL_WEIGHT.get(), 1, 3,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.DESERT,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU
                );

        addEntityToSpecificBiomes(event, EntityTypes.ARCHAE_ENTITY.get(),
                DeadlyDinosCommonConfig.ARCHAE_WEIGHT.get(), 1, 3,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE
        );

        addEntityToSpecificBiomes(event, EntityTypes.AUSTRO_ENTITY.get(),
                DeadlyDinosCommonConfig.AUSTRO_WEIGHT.get(), 2, 4,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.STONY_PEAKS,
                Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST
        );

        addEntityToSpecificBiomes(event, EntityTypes.CARCHAR_ENTITY.get(),
                DeadlyDinosCommonConfig.CARCHAR_WEIGHT.get(), 1, 1,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.STONY_PEAKS,
                Biomes.DESERT
        );

        addEntityToSpecificBiomes(event, EntityTypes.CARNO_ENTITY.get(),
                DeadlyDinosCommonConfig.CARNO_WEIGHT.get(), 1, 1,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.DESERT,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU
                );

        addEntityToSpecificBiomes(event, EntityTypes.CERATO_ENTITY.get(),
                DeadlyDinosCommonConfig.CERATO_WEIGHT.get(), 1, 3,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.SWAMP,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE
        );

        addEntityToSpecificBiomes(event, EntityTypes.COMPY_ENTITY.get(),
                DeadlyDinosCommonConfig.COMPY_WEIGHT.get(), 2, 3,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.STONY_PEAKS,
                Biomes.BEACH,
                Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST,
                Biomes.DESERT,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE
                );

        addEntityToSpecificBiomes(event, EntityTypes.DEINON_ENTITY.get(),
                DeadlyDinosCommonConfig.DEINON_WEIGHT.get(), 2, 3,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.STONY_PEAKS,
                Biomes.BEACH,
                Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE
        );

        addEntityToSpecificBiomes(event, EntityTypes.GIGA_ENTITY.get(),
                DeadlyDinosCommonConfig.GIGA_WEIGHT.get(), 1, 1,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.STONY_PEAKS
        );

        addEntityToSpecificBiomes(event, EntityTypes.MAHAKALA_ENTITY.get(),
                DeadlyDinosCommonConfig.MAHAKALA_WEIGHT.get(), 1, 3,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.BEACH,
                Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST
        );

        addEntityToSpecificBiomes(event, EntityTypes.MAJUNGA_ENTITY.get(),
                DeadlyDinosCommonConfig.MAJUNGA_WEIGHT.get(), 1, 2,
                Biomes.DESERT,
                Biomes.ERODED_BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.SPARSE_JUNGLE, Biomes.JUNGLE,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE
        );

        addEntityToSpecificBiomes(event, EntityTypes.REX_ENTITY.get(),
                DeadlyDinosCommonConfig.REX_WEIGHT.get(), 1, 1,
                Biomes.SWAMP,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA
        );

        addEntityToSpecificBiomes(event, EntityTypes.SPINO_ENTITY.get(),
                DeadlyDinosCommonConfig.SPINO_WEIGHT.get(), 1, 1,
                Biomes.SWAMP,
                Biomes.BEACH,
                Biomes.RIVER
        );

        addEntityToSpecificBiomes(event, EntityTypes.TARBO_ENTITY.get(),
                DeadlyDinosCommonConfig.TARBO_WEIGHT.get(), 1, 1,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.DESERT,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU
        );

        addEntityToSpecificBiomes(event, EntityTypes.TROODON_ENTITY.get(),
                DeadlyDinosCommonConfig.TROODON_WEIGHT.get(), 1, 1,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.SWAMP,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.STONY_PEAKS,
                Biomes.BEACH,
                Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST,
                Biomes.DESERT,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE
        );

        addEntityToSpecificBiomes(event, EntityTypes.UTAH_ENTITY.get(),
                DeadlyDinosCommonConfig.UTAH_WEIGHT.get(), 2, 4,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.DESERT,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU
        );



        addEntityToSpecificBiomes(event, EntityTypes.AMARGA_ENTITY.get(),
                DeadlyDinosCommonConfig.AMARGA_WEIGHT.get(), 1, 1,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.STONY_PEAKS,
                Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE
        );

        addEntityToSpecificBiomes(event, EntityTypes.ANKY_ENTITY.get(),
                DeadlyDinosCommonConfig.ANKY_WEIGHT.get(), 1, 1,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.BEACH
        );

        addEntityToSpecificBiomes(event, EntityTypes.AVA_ENTITY.get(),
                DeadlyDinosCommonConfig.AVA_WEIGHT.get(), 1, 3,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.SWAMP,
                Biomes.BEACH,
                Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE
        );

        addEntityToSpecificBiomes(event, EntityTypes.CROPSNAIL_ENTITY.get(),
                DeadlyDinosCommonConfig.CROPSNAIL_WEIGHT.get(), 1, 3,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.SWAMP,
                Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE
        );

        addEntityToSpecificBiomes(event, EntityTypes.DEINOCH_ENTITY.get(),
                DeadlyDinosCommonConfig.DEINOCH_WEIGHT.get(), 1, 1,
                Biomes.SWAMP,
                Biomes.BEACH,
                Biomes.RIVER
        );

        addEntityToSpecificBiomes(event, EntityTypes.GALLI_ENTITY.get(),
                DeadlyDinosCommonConfig.GALLI_WEIGHT.get(), 2, 3,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.STONY_PEAKS,
                Biomes.DESERT,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU
        );

        addEntityToSpecificBiomes(event, EntityTypes.GRYPO_ENTITY.get(),
                DeadlyDinosCommonConfig.GRYPO_WEIGHT.get(), 2, 3,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.SWAMP,
                Biomes.SNOWY_PLAINS, Biomes.SNOWY_BEACH, Biomes.SNOWY_SLOPES
        );

        addEntityToSpecificBiomes(event, EntityTypes.PARA_ENTITY.get(),
                DeadlyDinosCommonConfig.PARA_WEIGHT.get(), 1, 2,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.SWAMP,
                Biomes.BEACH,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU
        );

        addEntityToSpecificBiomes(event, EntityTypes.SAURO_ENTITY.get(),
                DeadlyDinosCommonConfig.SAURO_WEIGHT.get(), 1, 1,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA,  Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.STONY_PEAKS,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU
        );

        addEntityToSpecificBiomes(event, EntityTypes.SHANT_ENTITY.get(),
                DeadlyDinosCommonConfig.SHANT_WEIGHT.get(), 1, 3,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.SWAMP,
                Biomes.BEACH,
                Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST
        );

        addEntityToSpecificBiomes(event, EntityTypes.STEGO_ENTITY.get(),
                DeadlyDinosCommonConfig.STEGO_WEIGHT.get(), 2, 3,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE
        );

        addEntityToSpecificBiomes(event, EntityTypes.THERI_ENTITY.get(),
                DeadlyDinosCommonConfig.THERI_WEIGHT.get(), 1, 1,
                Biomes.BADLANDS, Biomes.WOODED_BADLANDS,
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
                Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST,
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE
        );

    }





    private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type,
                                                        int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(!isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }
    @SafeVarargs
    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }
    private static void addEntityToAllOverworldBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                      int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }
    private static void addEntityToAllBiomesNoNether(BiomeLoadingEvent event, EntityType<?> type,
                                                     int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }
    private static void addEntityToAllBiomesNoEnd(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }
    private static void addEntityToAllBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                             int weight, int minCount, int maxCount) {
        List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
        base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
    }
}
