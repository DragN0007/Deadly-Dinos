package com.dragn0007.deadlydinos.event;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.block.ModBlocks;
import com.dragn0007.deadlydinos.entity.*;
import com.dragn0007.deadlydinos.render.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = DeadlyDinos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class DeadlyDinosEvent {

    @SubscribeEvent
    public static void entityAttrbiuteCreationEvent(EntityAttributeCreationEvent event) {
        event.put(EntityTypes.ACRO_ENTITY.get(), AcroEntity.createAttributes().build());
        event.put(EntityTypes.UTAH_ENTITY.get(), UtahEntity.createAttributes().build());
        event.put(EntityTypes.CERATO_ENTITY.get(), CeratoEntity.createAttributes().build());
        event.put(EntityTypes.GIGA_ENTITY.get(), GigaEntity.createAttributes().build());
        event.put(EntityTypes.REX_ENTITY.get(), RexEntity.createAttributes().build());
        event.put(EntityTypes.SPINO_ENTITY.get(), SpinoEntity.createAttributes().build());
        event.put(EntityTypes.CARNO_ENTITY.get(), CarnoEntity.createAttributes().build());
        event.put(EntityTypes.COMPY_ENTITY.get(), CompyEntity.createAttributes().build());
        event.put(EntityTypes.MAHAKALA_ENTITY.get(), MahakalaEntity.createAttributes().build());
        event.put(EntityTypes.AUSTRO_ENTITY.get(), AustroEntity.createAttributes().build());
        event.put(EntityTypes.DEINON_ENTITY.get(), DeinonEntity.createAttributes().build());
        event.put(EntityTypes.ALBERTO_ENTITY.get(), AlbertoEntity.createAttributes().build());
        event.put(EntityTypes.MAJUNGA_ENTITY.get(), MajungaEntity.createAttributes().build());
        event.put(EntityTypes.TROODON_ENTITY.get(), TroodonEntity.createAttributes().build());
        event.put(EntityTypes.ARCHAE_ENTITY.get(), ArchaeEntity.createAttributes().build());
        event.put(EntityTypes.TARBO_ENTITY.get(), TarboEntity.createAttributes().build());

        event.put(EntityTypes.CROPSNAIL_ENTITY.get(), CropSnailEntity.createAttributes().build());
        event.put(EntityTypes.AMARGA_ENTITY.get(), AmargaEntity.createAttributes().build());
        event.put(EntityTypes.PARA_ENTITY.get(), ParaEntity.createAttributes().build());
        event.put(EntityTypes.THERI_ENTITY.get(), TheriEntity.createAttributes().build());
        event.put(EntityTypes.DEINOCH_ENTITY.get(), DeinochEntity.createAttributes().build());
        event.put(EntityTypes.STEGO_ENTITY.get(), StegoEntity.createAttributes().build());
        event.put(EntityTypes.SHANT_ENTITY.get(), ShantEntity.createAttributes().build());
        event.put(EntityTypes.GALLI_ENTITY.get(), GalliEntity.createAttributes().build());
        event.put(EntityTypes.SAURO_ENTITY.get(), SauroEntity.createAttributes().build());
        event.put(EntityTypes.ANKY_ENTITY.get(), AnkyEntity.createAttributes().build());
        event.put(EntityTypes.AVA_ENTITY.get(), AvaEntity.createAttributes().build());

        event.put(EntityTypes.CAR_ENTITY.get(), CarEntity.createAttributes().build());
        event.put(EntityTypes.CARSIDE_ENTITY.get(), CarSideEntity.createAttributes().build());
        event.put(EntityTypes.CARFLIPPED_ENTITY.get(), CarFlippedEntity.createAttributes().build());


        //Spawn Placements
        SpawnPlacements.register
                (EntityTypes.ACRO_ENTITY.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AcroEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.UTAH_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, UtahEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.CERATO_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CeratoEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.GIGA_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GigaEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.REX_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, RexEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.CARNO_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CarnoEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.COMPY_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CompyEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.MAHAKALA_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MahakalaEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.AUSTRO_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AustroEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.DEINON_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DeinonEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.ALBERTO_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AlbertoEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.MAJUNGA_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MajungaEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.TROODON_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TroodonEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.ARCHAE_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ArchaeEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.TARBO_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TarboEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.CROPSNAIL_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CropSnailEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.AMARGA_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmargaEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.PARA_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ParaEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.THERI_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TheriEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.STEGO_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, StegoEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.SHANT_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ShantEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.GALLI_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GalliEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.SAURO_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SauroEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.ANKY_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AnkyEntity::checkAnimalSpawnRules);

        SpawnPlacements.register
                (EntityTypes.AVA_ENTITY.get(),
                        SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AvaEntity::checkAnimalSpawnRules);


    }

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {

        EntityRenderers.register(EntityTypes.ACRO_ENTITY.get(), AcroRender::new);
        EntityRenderers.register(EntityTypes.UTAH_ENTITY.get(), UtahRender::new);
        EntityRenderers.register(EntityTypes.CERATO_ENTITY.get(), CeratoRender::new);
        EntityRenderers.register(EntityTypes.GIGA_ENTITY.get(), GigaRender::new);
        EntityRenderers.register(EntityTypes.REX_ENTITY.get(), RexRender::new);
        EntityRenderers.register(EntityTypes.SPINO_ENTITY.get(), SpinoRender::new);
        EntityRenderers.register(EntityTypes.CARNO_ENTITY.get(), CarnoRender::new);
        EntityRenderers.register(EntityTypes.COMPY_ENTITY.get(), CompyRender::new);
        EntityRenderers.register(EntityTypes.MAHAKALA_ENTITY.get(), MahakalaRender::new);
        EntityRenderers.register(EntityTypes.AUSTRO_ENTITY.get(), AustroRender::new);
        EntityRenderers.register(EntityTypes.DEINON_ENTITY.get(), DeinonRender::new);
        EntityRenderers.register(EntityTypes.ALBERTO_ENTITY.get(), AlbertoRender::new);
        EntityRenderers.register(EntityTypes.MAJUNGA_ENTITY.get(), MajungaRender::new);
        EntityRenderers.register(EntityTypes.TROODON_ENTITY.get(), TroodonRender::new);
        EntityRenderers.register(EntityTypes.ARCHAE_ENTITY.get(), ArchaeRender::new);
        EntityRenderers.register(EntityTypes.TARBO_ENTITY.get(), TarboRender::new);

        EntityRenderers.register(EntityTypes.CROPSNAIL_ENTITY.get(), CropSnailRender::new);
        EntityRenderers.register(EntityTypes.AMARGA_ENTITY.get(), AmargaRender::new);
        EntityRenderers.register(EntityTypes.PARA_ENTITY.get(), ParaRender::new);
        EntityRenderers.register(EntityTypes.THERI_ENTITY.get(), TheriRender::new);
        EntityRenderers.register(EntityTypes.DEINOCH_ENTITY.get(), DeinochRender::new);
        EntityRenderers.register(EntityTypes.STEGO_ENTITY.get(), StegoRender::new);
        EntityRenderers.register(EntityTypes.SHANT_ENTITY.get(), ShantRender::new);
        EntityRenderers.register(EntityTypes.GALLI_ENTITY.get(), GalliRender::new);
        EntityRenderers.register(EntityTypes.SAURO_ENTITY.get(), SauroRender::new);
        EntityRenderers.register(EntityTypes.ANKY_ENTITY.get(), AnkyRender::new);
        EntityRenderers.register(EntityTypes.AVA_ENTITY.get(), AvaRender::new);

        EntityRenderers.register(EntityTypes.CAR_ENTITY.get(), CarRender::new);
        EntityRenderers.register(EntityTypes.CARSIDE_ENTITY.get(), CarSideRender::new);
        EntityRenderers.register(EntityTypes.CARFLIPPED_ENTITY.get(), CarFlippedRender::new);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RGLASS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CONIFERLEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CONIFERSAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.YEWLEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.YEWSAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SEQUOIALEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SEQUOIASAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COOKSONIA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CYCAS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CYPERUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ZOSTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CYCADS.get(), RenderType.cutout());
    }
}




