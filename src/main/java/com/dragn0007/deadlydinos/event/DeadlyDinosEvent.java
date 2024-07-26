package com.dragn0007.deadlydinos.event;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.block.DDDBlocks;
import com.dragn0007.deadlydinos.block.DDDBlocksDataGen;
import com.dragn0007.deadlydinos.client.gui.DDDMenuTypes;
import com.dragn0007.deadlydinos.client.menu.*;
import com.dragn0007.deadlydinos.client.render.*;
import com.dragn0007.deadlydinos.entity.carni.*;
import com.dragn0007.deadlydinos.entity.herbi.*;
import com.dragn0007.deadlydinos.entity.marine.Dunkleo;
import com.dragn0007.deadlydinos.entity.marine.Gar;
import com.dragn0007.deadlydinos.entity.marine.Heli;
import com.dragn0007.deadlydinos.entity.marine.Mosa;
import com.dragn0007.deadlydinos.entity.nonliving.Car;
import com.dragn0007.deadlydinos.entity.nonliving.CarFlipped;
import com.dragn0007.deadlydinos.entity.nonliving.CarSide;
import com.dragn0007.deadlydinos.entity.util.EntityTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = DeadlyDinos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class DeadlyDinosEvent {

    @SubscribeEvent
    public static void entityAttrbiuteCreationEvent(EntityAttributeCreationEvent event) {
        event.put(EntityTypes.ACRO_ENTITY.get(), Acro.createAttributes().build());
        event.put(EntityTypes.UTAH_ENTITY.get(), Utah.createAttributes().build());
        event.put(EntityTypes.CERATO_ENTITY.get(), Cerato.createAttributes().build());
        event.put(EntityTypes.GIGA_ENTITY.get(), Giga.createAttributes().build());
        event.put(EntityTypes.REX_ENTITY.get(), Rex.createAttributes().build());
        event.put(EntityTypes.SPINO_ENTITY.get(), Spino.createAttributes().build());
        event.put(EntityTypes.CARNO_ENTITY.get(), Carno.createAttributes().build());
        event.put(EntityTypes.COMPY_ENTITY.get(), Compy.createAttributes().build());
        event.put(EntityTypes.MAHAKALA_ENTITY.get(), Mahakala.createAttributes().build());
        event.put(EntityTypes.AUSTRO_ENTITY.get(), Austro.createAttributes().build());
        event.put(EntityTypes.DEINON_ENTITY.get(), Deinon.createAttributes().build());
        event.put(EntityTypes.ALBERTO_ENTITY.get(), Alberto.createAttributes().build());
        event.put(EntityTypes.MAJUNGA_ENTITY.get(), Majunga.createAttributes().build());
        event.put(EntityTypes.TROODON_ENTITY.get(), Troodon.createAttributes().build());
        event.put(EntityTypes.ARCHAE_ENTITY.get(), Archae.createAttributes().build());
        event.put(EntityTypes.TARBO_ENTITY.get(), Tarbo.createAttributes().build());
        event.put(EntityTypes.ANDAL_ENTITY.get(), Andal.createAttributes().build());
        event.put(EntityTypes.CARCHAR_ENTITY.get(), Carchar.createAttributes().build());
        event.put(EntityTypes.ALLO_ENTITY.get(), Allo.createAttributes().build());
        event.put(EntityTypes.DILO_ENTITY.get(), Dilo.createAttributes().build());
        event.put(EntityTypes.YUTY_ENTITY.get(), Yuty.createAttributes().build());
        event.put(EntityTypes.CRYO_ENTITY.get(), Cryo.createAttributes().build());
        event.put(EntityTypes.AUSTRALO_ENTITY.get(), Australo.createAttributes().build());
        event.put(EntityTypes.ATROCI_ENTITY.get(), Atroci.createAttributes().build());
        event.put(EntityTypes.ICHTHY_ENTITY.get(), Ichthy.createAttributes().build());
        event.put(EntityTypes.MEGARAP_ENTITY.get(), Megarap.createAttributes().build());
        event.put(EntityTypes.EOCARCHAR_ENTITY.get(), Megarap.createAttributes().build());

        event.put(EntityTypes.CROPSNAIL_ENTITY.get(), CropSnail.createAttributes().build());
        event.put(EntityTypes.AMARGA_ENTITY.get(), Amarga.createAttributes().build());
        event.put(EntityTypes.PARA_ENTITY.get(), Para.createAttributes().build());
        event.put(EntityTypes.THERI_ENTITY.get(), Theri.createAttributes().build());
        event.put(EntityTypes.DEINOCH_ENTITY.get(), Deinoch.createAttributes().build());
        event.put(EntityTypes.STEGO_ENTITY.get(), Stego.createAttributes().build());
        event.put(EntityTypes.SHANT_ENTITY.get(), Shant.createAttributes().build());
        event.put(EntityTypes.GALLI_ENTITY.get(), Galli.createAttributes().build());
        event.put(EntityTypes.SAURO_ENTITY.get(), Sauro.createAttributes().build());
        event.put(EntityTypes.ANKY_ENTITY.get(), Anky.createAttributes().build());
        event.put(EntityTypes.AVA_ENTITY.get(), Ava.createAttributes().build());
        event.put(EntityTypes.GRYPO_ENTITY.get(), Grypo.createAttributes().build());
        event.put(EntityTypes.AMPELO_ENTITY.get(), Ampelo.createAttributes().build());
        event.put(EntityTypes.PACHYR_ENTITY.get(), Pachyr.createAttributes().build());
        event.put(EntityTypes.EDMONTO_ENTITY.get(), Edmonto.createAttributes().build());
        event.put(EntityTypes.IGUA_ENTITY.get(), Igua.createAttributes().build());
        event.put(EntityTypes.TRIKE_ENTITY.get(), Trike.createAttributes().build());

        event.put(EntityTypes.MOSA_ENTITY.get(), Mosa.createAttributes().build());
        event.put(EntityTypes.HELI_ENTITY.get(), Heli.createAttributes().build());
        event.put(EntityTypes.GAR_ENTITY.get(), Gar.createAttributes().build());
        event.put(EntityTypes.DUNKLEO_ENTITY.get(), Dunkleo.createAttributes().build());

        event.put(EntityTypes.CAR_ENTITY.get(), Car.createAttributes().build());
        event.put(EntityTypes.CARSIDE_ENTITY.get(), CarSide.createAttributes().build());
        event.put(EntityTypes.CARFLIPPED_ENTITY.get(), CarFlipped.createAttributes().build());


        //Spawn Placements
        SpawnPlacements.register(EntityTypes.ACRO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.UTAH_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utah::checkDesertDinoSpawnRules);

        SpawnPlacements.register(EntityTypes.CERATO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Cerato::checkDesertDinoSpawnRules);

        SpawnPlacements.register(EntityTypes.GIGA_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.REX_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.CARNO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Carno::checkDesertDinoSpawnRules);

        SpawnPlacements.register(EntityTypes.COMPY_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.MAHAKALA_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.AUSTRO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.DEINON_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.ALBERTO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Alberto::checkDesertDinoSpawnRules);

        SpawnPlacements.register(EntityTypes.MAJUNGA_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Majunga::checkDesertDinoSpawnRules);

        SpawnPlacements.register(EntityTypes.TROODON_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.ARCHAE_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.TARBO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.ANDAL_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Andal::checkDesertDinoSpawnRules);

        SpawnPlacements.register(EntityTypes.SPINO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.CARCHAR_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Carchar::checkDesertDinoSpawnRules);

        SpawnPlacements.register(EntityTypes.ALLO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Allo::checkDesertDinoSpawnRules);

        SpawnPlacements.register(EntityTypes.DILO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.YUTY_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.CRYO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.AUSTRALO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.ATROCI_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.ICHTHY_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.MEGARAP_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.EOCARCHAR_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);


        SpawnPlacements.register(EntityTypes.CROPSNAIL_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.AMARGA_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.PARA_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.THERI_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.STEGO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.SHANT_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.GALLI_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.SAURO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.ANKY_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.AVA_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.DEINOCH_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.GRYPO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.AMPELO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.PACHYR_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.EDMONTO_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.IGUA_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.TRIKE_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);


        SpawnPlacements.register(EntityTypes.MOSA_ENTITY.get(), SpawnPlacements.Type.IN_WATER,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.HELI_ENTITY.get(), SpawnPlacements.Type.IN_WATER,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.GAR_ENTITY.get(), SpawnPlacements.Type.IN_WATER,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);

        SpawnPlacements.register(EntityTypes.DUNKLEO_ENTITY.get(), SpawnPlacements.Type.IN_WATER,
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
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
        EntityRenderers.register(EntityTypes.ANDAL_ENTITY.get(), AndalRender::new);
        EntityRenderers.register(EntityTypes.CARCHAR_ENTITY.get(), CarcharRender::new);
        EntityRenderers.register(EntityTypes.ALLO_ENTITY.get(), AlloRender::new);
        EntityRenderers.register(EntityTypes.DILO_ENTITY.get(), DiloRender::new);
        EntityRenderers.register(EntityTypes.YUTY_ENTITY.get(), YutyRender::new);
        EntityRenderers.register(EntityTypes.CRYO_ENTITY.get(), CryoRender::new);
        EntityRenderers.register(EntityTypes.AUSTRALO_ENTITY.get(), AustraloRender::new);
        EntityRenderers.register(EntityTypes.ATROCI_ENTITY.get(), AtrociRender::new);
        EntityRenderers.register(EntityTypes.ICHTHY_ENTITY.get(), IchthyRender::new);
        EntityRenderers.register(EntityTypes.MEGARAP_ENTITY.get(), MegarapRender::new);
        EntityRenderers.register(EntityTypes.EOCARCHAR_ENTITY.get(), EocarcharRender::new);

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
        EntityRenderers.register(EntityTypes.GRYPO_ENTITY.get(), GrypoRender::new);
        EntityRenderers.register(EntityTypes.AMPELO_ENTITY.get(), AmpeloRender::new);
        EntityRenderers.register(EntityTypes.PACHYR_ENTITY.get(), PachyrRender::new);
        EntityRenderers.register(EntityTypes.EDMONTO_ENTITY.get(), EdmontoRender::new);
        EntityRenderers.register(EntityTypes.IGUA_ENTITY.get(), IguaRender::new);
        EntityRenderers.register(EntityTypes.TRIKE_ENTITY.get(), TrikeRender::new);

        EntityRenderers.register(EntityTypes.MOSA_ENTITY.get(), MosaRender::new);
        EntityRenderers.register(EntityTypes.HELI_ENTITY.get(), HeliRender::new);
        EntityRenderers.register(EntityTypes.GAR_ENTITY.get(), GarRender::new);
        EntityRenderers.register(EntityTypes.DUNKLEO_ENTITY.get(), DunkleoRender::new);

        EntityRenderers.register(EntityTypes.CAR_ENTITY.get(), CarRender::new);
        EntityRenderers.register(EntityTypes.CARSIDE_ENTITY.get(), CarSideRender::new);
        EntityRenderers.register(EntityTypes.CARFLIPPED_ENTITY.get(), CarFlippedRender::new);


        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.RGLASS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.CONIFERLEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.CONIFERSAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.YEWLEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.YEWSAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.SEQUOIALEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.SEQUOIASAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.COOKSONIA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.CYCAS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.CYPERUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.ZOSTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.CYCADS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocksDataGen.ASTEROXYLON.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocksDataGen.HORSETAIL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DDDBlocks.CALAMITES.get(), RenderType.cutout());

        MenuScreens.register(DDDMenuTypes.GRYPO_MENU.get(), GrypoScreen::new);
        MenuScreens.register(DDDMenuTypes.AMARGA_MENU.get(), AmargaScreen::new);
        MenuScreens.register(DDDMenuTypes.PARA_MENU.get(), ParaScreen::new);
        MenuScreens.register(DDDMenuTypes.ICHTHY_MENU.get(), IchthyScreen::new);
        MenuScreens.register(DDDMenuTypes.YUTY_MENU.get(), YutyScreen::new);
        MenuScreens.register(DDDMenuTypes.IGUA_MENU.get(), IguaScreen::new);
        MenuScreens.register(DDDMenuTypes.TRIKE_MENU.get(), TrikeScreen::new);
        MenuScreens.register(DDDMenuTypes.EOCARCHAR_MENU.get(), EocarcharScreen::new);
    }
}




