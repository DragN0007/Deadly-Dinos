package com.dragn0007.deadlydinos.event;


import com.dragn0007.deadlydinos.entity.EntityTypes;
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
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GIGA_ENTITY.get(), 6, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CERATO_ENTITY.get(), 7, 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TARBO_ENTITY.get(), 3, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ALBERTO_ENTITY.get(), 4, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARNO_ENTITY.get(), 8, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.THERI_ENTITY.get(), 3, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), 3, 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), 3, 1, 3));
                break;

            case PLAINS:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CERATO_ENTITY.get(), 7, 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ACRO_ENTITY.get(), 6, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARNO_ENTITY.get(), 8, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.UTAH_ENTITY.get(), 8, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), 7, 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.PARA_ENTITY.get(), 4, 2, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.THERI_ENTITY.get(), 3, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.STEGO_ENTITY.get(), 5, 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SHANT_ENTITY.get(), 4, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), 3, 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ANKY_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SAURO_ENTITY.get(), 1, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), 3, 1, 3));
                break;

            case SWAMP:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.REX_ENTITY.get(), 6, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AUSTRO_ENTITY.get(), 4, 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CERATO_ENTITY.get(), 7, 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SPINO_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINOCH_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.PARA_ENTITY.get(), 4, 2, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 1, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 1, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 1, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), 8, 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SHANT_ENTITY.get(), 4, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), 3, 1, 3));

            case TAIGA:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ARCHAE_ENTITY.get(), 5, 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GIGA_ENTITY.get(), 6, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.REX_ENTITY.get(), 6, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAHAKALA_ENTITY.get(), 10, 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINON_ENTITY.get(), 4, 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.UTAH_ENTITY.get(), 8, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AMARGA_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), 3, 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ANKY_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SAURO_ENTITY.get(), 1, 1, 1));


            case EXTREME_HILLS:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ALBERTO_ENTITY.get(), 4, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GIGA_ENTITY.get(), 6, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINON_ENTITY.get(), 4, 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), 7, 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AMARGA_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), 3, 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SAURO_ENTITY.get(), 1, 1, 1));
                break;

            case BEACH:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AUSTRO_ENTITY.get(), 4, 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINON_ENTITY.get(), 4, 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAHAKALA_ENTITY.get(), 10, 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SPINO_ENTITY.get(), 3, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINOCH_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.PARA_ENTITY.get(), 4, 2, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SHANT_ENTITY.get(), 4, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ANKY_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), 3, 1, 3));
                break;

            case FOREST:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ARCHAE_ENTITY.get(), 5, 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINON_ENTITY.get(), 4, 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AUSTRO_ENTITY.get(), 4, 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAHAKALA_ENTITY.get(), 10, 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), 8, 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.THERI_ENTITY.get(), 3, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.STEGO_ENTITY.get(), 5, 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AMARGA_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SHANT_ENTITY.get(), 4, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ANKY_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), 3, 1, 3));
                break;

            case RIVER:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SPINO_ENTITY.get(), 1, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINOCH_ENTITY.get(), 1, 1, 1));
                break;

            case DESERT:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TARBO_ENTITY.get(), 3, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARNO_ENTITY.get(), 8, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAJUNGA_ENTITY.get(), 8, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.UTAH_ENTITY.get(), 5, 2, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), 3, 1, 4));
                break;

            case SAVANNA:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TARBO_ENTITY.get(), 3, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAJUNGA_ENTITY.get(), 8, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CERATO_ENTITY.get(), 7, 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ALBERTO_ENTITY.get(), 4, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARNO_ENTITY.get(), 8, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ACRO_ENTITY.get(), 6, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.UTAH_ENTITY.get(), 9, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), 6, 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.PARA_ENTITY.get(), 4, 2, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.THERI_ENTITY.get(), 3, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.STEGO_ENTITY.get(), 5, 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AMARGA_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), 3, 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SAURO_ENTITY.get(), 1, 1, 1));
                break;

            case JUNGLE:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ARCHAE_ENTITY.get(), 5, 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CERATO_ENTITY.get(), 7, 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAJUNGA_ENTITY.get(), 8, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINON_ENTITY.get(), 4, 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AUSTRO_ENTITY.get(), 4, 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), 8, 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.THERI_ENTITY.get(), 3, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.STEGO_ENTITY.get(), 5, 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AMARGA_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), 3, 1, 3));
                break;

            case OCEAN:
                break;

            case NETHER:
                break;
        }
    }
}