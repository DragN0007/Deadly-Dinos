package com.dragn0007.deadlydinos.event;


import com.dragn0007.deadlydinos.entity.util.EntityTypes;
import com.dragn0007.deadlydinos.util.config.DeadlyDinosCommonConfig;
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
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), DeadlyDinosCommonConfig.COMPY_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GIGA_ENTITY.get(), DeadlyDinosCommonConfig.GIGA_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CERATO_ENTITY.get(), DeadlyDinosCommonConfig.CERATO_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TARBO_ENTITY.get(), DeadlyDinosCommonConfig.TARBO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ALBERTO_ENTITY.get(), DeadlyDinosCommonConfig.ALBERTO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), DeadlyDinosCommonConfig.TROODON_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARNO_ENTITY.get(), DeadlyDinosCommonConfig.CARNO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.THERI_ENTITY.get(), DeadlyDinosCommonConfig.THERI_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), DeadlyDinosCommonConfig.GALLI_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), DeadlyDinosCommonConfig.AVA_WEIGHT.get(), 1, 3));
                break;

            case PLAINS:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), DeadlyDinosCommonConfig.TROODON_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), DeadlyDinosCommonConfig.COMPY_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CERATO_ENTITY.get(), DeadlyDinosCommonConfig.CERATO_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ACRO_ENTITY.get(), DeadlyDinosCommonConfig.ACRO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARNO_ENTITY.get(), DeadlyDinosCommonConfig.CARNO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.UTAH_ENTITY.get(), DeadlyDinosCommonConfig.UTAH_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), DeadlyDinosCommonConfig.CROPSNAIL_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.PARA_ENTITY.get(), DeadlyDinosCommonConfig.PARA_WEIGHT.get(), 2, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.THERI_ENTITY.get(), DeadlyDinosCommonConfig.THERI_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.STEGO_ENTITY.get(), DeadlyDinosCommonConfig.STEGO_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SHANT_ENTITY.get(), DeadlyDinosCommonConfig.SHANT_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), DeadlyDinosCommonConfig.GALLI_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ANKY_ENTITY.get(), DeadlyDinosCommonConfig.ANKY_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SAURO_ENTITY.get(), DeadlyDinosCommonConfig.SAURO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), DeadlyDinosCommonConfig.AVA_WEIGHT.get(), 1, 3));
                break;

            case SWAMP:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), DeadlyDinosCommonConfig.TROODON_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), DeadlyDinosCommonConfig.COMPY_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.REX_ENTITY.get(), DeadlyDinosCommonConfig.REX_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CERATO_ENTITY.get(), DeadlyDinosCommonConfig.CERATO_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SPINO_ENTITY.get(), DeadlyDinosCommonConfig.SPINO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINOCH_ENTITY.get(), DeadlyDinosCommonConfig.DEINOCH_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.PARA_ENTITY.get(), DeadlyDinosCommonConfig.PARA_WEIGHT.get(), 2, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 1, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 1, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 1, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), DeadlyDinosCommonConfig.CROPSNAIL_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SHANT_ENTITY.get(), DeadlyDinosCommonConfig.SHANT_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), DeadlyDinosCommonConfig.AVA_WEIGHT.get(), 1, 3));

            case TAIGA:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ARCHAE_ENTITY.get(), DeadlyDinosCommonConfig.ARCHAE_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AUSTRO_ENTITY.get(), DeadlyDinosCommonConfig.AUSTRO_WEIGHT.get(), 2, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), DeadlyDinosCommonConfig.TROODON_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), DeadlyDinosCommonConfig.COMPY_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GIGA_ENTITY.get(), DeadlyDinosCommonConfig.GIGA_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.REX_ENTITY.get(), DeadlyDinosCommonConfig.REX_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAHAKALA_ENTITY.get(), DeadlyDinosCommonConfig.MAHAKALA_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINON_ENTITY.get(), DeadlyDinosCommonConfig.DEINON_WEIGHT.get(), 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.UTAH_ENTITY.get(), DeadlyDinosCommonConfig.UTAH_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AMARGA_ENTITY.get(), DeadlyDinosCommonConfig.AMARGA_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), DeadlyDinosCommonConfig.GALLI_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ANKY_ENTITY.get(), DeadlyDinosCommonConfig.ANKY_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SAURO_ENTITY.get(), DeadlyDinosCommonConfig.SAURO_WEIGHT.get(), 1, 1));


            case EXTREME_HILLS:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AUSTRO_ENTITY.get(), DeadlyDinosCommonConfig.AUSTRO_WEIGHT.get(), 2, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), DeadlyDinosCommonConfig.TROODON_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), DeadlyDinosCommonConfig.COMPY_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ALBERTO_ENTITY.get(), DeadlyDinosCommonConfig.ALBERTO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GIGA_ENTITY.get(), DeadlyDinosCommonConfig.GIGA_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINON_ENTITY.get(), DeadlyDinosCommonConfig.DEINON_WEIGHT.get(), 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), DeadlyDinosCommonConfig.CROPSNAIL_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AMARGA_ENTITY.get(), DeadlyDinosCommonConfig.AMARGA_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), DeadlyDinosCommonConfig.GALLI_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SAURO_ENTITY.get(), DeadlyDinosCommonConfig.SAURO_WEIGHT.get(), 1, 1));
                break;

            case BEACH:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), DeadlyDinosCommonConfig.TROODON_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), DeadlyDinosCommonConfig.COMPY_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINON_ENTITY.get(), DeadlyDinosCommonConfig.DEINON_WEIGHT.get(), 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAHAKALA_ENTITY.get(), DeadlyDinosCommonConfig.MAHAKALA_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SPINO_ENTITY.get(), DeadlyDinosCommonConfig.SPINO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINOCH_ENTITY.get(), DeadlyDinosCommonConfig.DEINOCH_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.PARA_ENTITY.get(), DeadlyDinosCommonConfig.PARA_WEIGHT.get(), 2, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SHANT_ENTITY.get(), DeadlyDinosCommonConfig.SHANT_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ANKY_ENTITY.get(), DeadlyDinosCommonConfig.ANKY_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), DeadlyDinosCommonConfig.AVA_WEIGHT.get(), 1, 3));
                break;

            case FOREST:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ARCHAE_ENTITY.get(), DeadlyDinosCommonConfig.ARCHAE_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), DeadlyDinosCommonConfig.TROODON_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), DeadlyDinosCommonConfig.COMPY_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINON_ENTITY.get(), DeadlyDinosCommonConfig.DEINON_WEIGHT.get(), 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AUSTRO_ENTITY.get(), DeadlyDinosCommonConfig.AUSTRO_WEIGHT.get(), 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAHAKALA_ENTITY.get(), DeadlyDinosCommonConfig.MAHAKALA_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), DeadlyDinosCommonConfig.CROPSNAIL_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.THERI_ENTITY.get(), DeadlyDinosCommonConfig.THERI_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.STEGO_ENTITY.get(), DeadlyDinosCommonConfig.STEGO_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AMARGA_ENTITY.get(), DeadlyDinosCommonConfig.AMARGA_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SHANT_ENTITY.get(), DeadlyDinosCommonConfig.SHANT_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ANKY_ENTITY.get(), DeadlyDinosCommonConfig.ANKY_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), DeadlyDinosCommonConfig.AVA_WEIGHT.get(), 1, 3));
                break;

            case RIVER:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SPINO_ENTITY.get(), DeadlyDinosCommonConfig.SPINO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINOCH_ENTITY.get(), DeadlyDinosCommonConfig.DEINOCH_WEIGHT.get(), 1, 1));
                break;

            case DESERT:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TARBO_ENTITY.get(), DeadlyDinosCommonConfig.TARBO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), DeadlyDinosCommonConfig.TROODON_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), DeadlyDinosCommonConfig.COMPY_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARNO_ENTITY.get(), DeadlyDinosCommonConfig.CARNO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAJUNGA_ENTITY.get(), DeadlyDinosCommonConfig.MAJUNGA_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.UTAH_ENTITY.get(), DeadlyDinosCommonConfig.UTAH_WEIGHT.get(), 2, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), DeadlyDinosCommonConfig.GALLI_WEIGHT.get(), 1, 4));
                break;

            case SAVANNA:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TARBO_ENTITY.get(), DeadlyDinosCommonConfig.TARBO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), DeadlyDinosCommonConfig.TROODON_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), DeadlyDinosCommonConfig.COMPY_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAJUNGA_ENTITY.get(), DeadlyDinosCommonConfig.MAJUNGA_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CERATO_ENTITY.get(), DeadlyDinosCommonConfig.CERATO_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ALBERTO_ENTITY.get(), DeadlyDinosCommonConfig.ALBERTO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARNO_ENTITY.get(), DeadlyDinosCommonConfig.CARNO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ACRO_ENTITY.get(), DeadlyDinosCommonConfig.ACRO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.UTAH_ENTITY.get(), DeadlyDinosCommonConfig.UTAH_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), DeadlyDinosCommonConfig.CROPSNAIL_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.PARA_ENTITY.get(), DeadlyDinosCommonConfig.PARA_WEIGHT.get(), 2, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.THERI_ENTITY.get(), DeadlyDinosCommonConfig.THERI_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.STEGO_ENTITY.get(), DeadlyDinosCommonConfig.STEGO_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AMARGA_ENTITY.get(), DeadlyDinosCommonConfig.AMARGA_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.GALLI_ENTITY.get(), DeadlyDinosCommonConfig.GALLI_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.SAURO_ENTITY.get(), DeadlyDinosCommonConfig.SAURO_WEIGHT.get(), 1, 1));
                break;

            case JUNGLE:
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ARCHAE_ENTITY.get(), DeadlyDinosCommonConfig.ARCHAE_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.TROODON_ENTITY.get(), DeadlyDinosCommonConfig.TROODON_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.COMPY_ENTITY.get(), DeadlyDinosCommonConfig.COMPY_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CERATO_ENTITY.get(), DeadlyDinosCommonConfig.CERATO_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.MAJUNGA_ENTITY.get(), DeadlyDinosCommonConfig.MAJUNGA_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.ACRO_ENTITY.get(), DeadlyDinosCommonConfig.ACRO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.DEINON_ENTITY.get(), DeadlyDinosCommonConfig.DEINON_WEIGHT.get(), 1, 5));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CAR_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARFLIPPED_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CARSIDE_ENTITY.get(), 2, 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.CROPSNAIL_ENTITY.get(), DeadlyDinosCommonConfig.CROPSNAIL_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.THERI_ENTITY.get(), DeadlyDinosCommonConfig.THERI_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.STEGO_ENTITY.get(), DeadlyDinosCommonConfig.STEGO_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AMARGA_ENTITY.get(), DeadlyDinosCommonConfig.AMARGA_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityTypes.AVA_ENTITY.get(), DeadlyDinosCommonConfig.ACRO_WEIGHT.get(), 1, 3));
                break;

            case OCEAN:
                break;

            case NETHER:
                break;
        }
    }
}