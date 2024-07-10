package com.dragn0007.deadlydinos.event;


import com.dragn0007.deadlydinos.entity.util.EntityTypes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)

public class ForgeEvent {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerBiomes(BiomeLoadingEvent event) {
        switch (event.getCategory()) {

            case MESA:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                break;

            case PLAINS:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                break;

            case SWAMP:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 1, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 1, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 1, 1, 1));

            case TAIGA:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));

            case EXTREME_HILLS:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                break;

            case BEACH:
                break;

            case FOREST:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                break;

            case RIVER:
                break;

            case DESERT:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                break;

            case SAVANNA:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                break;

            case JUNGLE:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                break;

            case OCEAN:
                break;

            case NETHER:
                break;
        }
    }
}