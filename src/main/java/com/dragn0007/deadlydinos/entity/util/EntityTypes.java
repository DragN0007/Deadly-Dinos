package com.dragn0007.deadlydinos.entity.util;

import com.dragn0007.deadlydinos.entity.carni.*;
import com.dragn0007.deadlydinos.entity.herbi.*;
import com.dragn0007.deadlydinos.entity.nonliving.Car;
import com.dragn0007.deadlydinos.entity.nonliving.CarFlipped;
import com.dragn0007.deadlydinos.entity.nonliving.CarSide;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.dragn0007.deadlydinos.DeadlyDinos.MODID;

public class EntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);


    //Carnivores

    public static final RegistryObject<EntityType<Acro>> ACRO_ENTITY = ENTITY_TYPES.register("acro_entity",
            () -> EntityType.Builder.of(Acro::new,
                    MobCategory.CREATURE)
                    .sized(3f,4f)
                    .build(new ResourceLocation(MODID,"acro").toString()));
    public static final RegistryObject<EntityType<Utah>> UTAH_ENTITY = ENTITY_TYPES.register("utah_entity",
            () -> EntityType.Builder.of(Utah::new,
                            MobCategory.CREATURE)
                    .sized(0.8f,1.8f)
                    .build(new ResourceLocation(MODID,"utah").toString()));

    public static final RegistryObject<EntityType<Carno>> CARNO_ENTITY = ENTITY_TYPES.register("carno_entity",
            () -> EntityType.Builder.of(Carno::new,
                            MobCategory.CREATURE)
                    .sized(2f,3f)
                    .build(new ResourceLocation(MODID,"carno").toString()));

    public static final RegistryObject<EntityType<Cerato>> CERATO_ENTITY = ENTITY_TYPES.register("cerato_entity",
            () -> EntityType.Builder.of(Cerato::new,
                            MobCategory.CREATURE)
                    .sized(2f,2.8f)
                    .build(new ResourceLocation(MODID,"cerato").toString()));

    public static final RegistryObject<EntityType<Giga>> GIGA_ENTITY = ENTITY_TYPES.register("giga_entity",
            () -> EntityType.Builder.of(Giga::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"giga").toString()));

    public static final RegistryObject<EntityType<Rex>> REX_ENTITY = ENTITY_TYPES.register("rex_entity",
            () -> EntityType.Builder.of(Rex::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"rex").toString()));

    public static final RegistryObject<EntityType<Spino>> SPINO_ENTITY = ENTITY_TYPES.register("spino_entity",
            () -> EntityType.Builder.of(Spino::new,
                            MobCategory.WATER_CREATURE)
                    .sized(2f,5f)
                    .build(new ResourceLocation(MODID,"spino").toString()));
    public static final RegistryObject<EntityType<Compy>> COMPY_ENTITY = ENTITY_TYPES.register("compy_entity",
            () -> EntityType.Builder.of(Compy::new,
                            MobCategory.CREATURE)
                    .sized(0.5f,0.5f)
                    .build(new ResourceLocation(MODID,"compy").toString()));

    public static final RegistryObject<EntityType<Mahakala>> MAHAKALA_ENTITY = ENTITY_TYPES.register("mahakala_entity",
            () -> EntityType.Builder.of(Mahakala::new,
                            MobCategory.CREATURE)
                    .sized(0.4f,0.4f)
                    .build(new ResourceLocation(MODID,"mahakala").toString()));

    public static final RegistryObject<EntityType<Austro>> AUSTRO_ENTITY = ENTITY_TYPES.register("austro_entity",
            () -> EntityType.Builder.of(Austro::new,
                            MobCategory.CREATURE)
                    .sized(0.8f,1.5f)
                    .build(new ResourceLocation(MODID,"austro").toString()));

    public static final RegistryObject<EntityType<Deinon>> DEINON_ENTITY = ENTITY_TYPES.register("deinon_entity",
            () -> EntityType.Builder.of(Deinon::new,
                            MobCategory.CREATURE)
                    .sized(0.6f,1.3f)
                    .build(new ResourceLocation(MODID,"deinon").toString()));

    public static final RegistryObject<EntityType<Alberto>> ALBERTO_ENTITY = ENTITY_TYPES.register("alberto_entity",
            () -> EntityType.Builder.of(Alberto::new,
                            MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"alberto").toString()));

    public static final RegistryObject<EntityType<Majunga>> MAJUNGA_ENTITY = ENTITY_TYPES.register("majunga_entity",
            () -> EntityType.Builder.of(Majunga::new,
                            MobCategory.CREATURE)
                    .sized(2f,3f)
                    .build(new ResourceLocation(MODID,"majunga").toString()));

    public static final RegistryObject<EntityType<Troodon>> TROODON_ENTITY = ENTITY_TYPES.register("troodon_entity",
            () -> EntityType.Builder.of(Troodon::new,
                            MobCategory.CREATURE)
                    .sized(0.5f,1f)
                    .build(new ResourceLocation(MODID,"troodon").toString()));

    public static final RegistryObject<EntityType<Archae>> ARCHAE_ENTITY = ENTITY_TYPES.register("archae_entity",
            () -> EntityType.Builder.of(Archae::new,
                            MobCategory.CREATURE)
                    .sized(0.5f,1f)
                    .build(new ResourceLocation(MODID,"archae").toString()));

    public static final RegistryObject<EntityType<Tarbo>> TARBO_ENTITY = ENTITY_TYPES.register("tarbo_entity",
            () -> EntityType.Builder.of(Tarbo::new,
                            MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"tarbo").toString()));

    public static final RegistryObject<EntityType<Andal>> ANDAL_ENTITY = ENTITY_TYPES.register("andal_entity",
            () -> EntityType.Builder.of(Andal::new,
                            MobCategory.CREATURE)
                    .sized(1.5f,1f)
                    .build(new ResourceLocation(MODID,"andal").toString()));

    public static final RegistryObject<EntityType<Carchar>> CARCHAR_ENTITY = ENTITY_TYPES.register("carchar_entity",
            () -> EntityType.Builder.of(Carchar::new,
                            MobCategory.CREATURE)
                    .sized(2.5f,5f)
                    .build(new ResourceLocation(MODID,"carchar").toString()));

    public static final RegistryObject<EntityType<Allo>> ALLO_ENTITY = ENTITY_TYPES.register("allo_entity",
            () -> EntityType.Builder.of(Allo::new,
                            MobCategory.CREATURE)
                    .sized(2f,3f)
                    .build(new ResourceLocation(MODID,"allo").toString()));

    public static final RegistryObject<EntityType<Dilo>> DILO_ENTITY = ENTITY_TYPES.register("dilo_entity",
            () -> EntityType.Builder.of(Dilo::new,
                            MobCategory.CREATURE)
                    .sized(0.8f,1.8f)
                    .build(new ResourceLocation(MODID,"dilo").toString()));



    //Herbivores

    public static final RegistryObject<EntityType<CropSnail>> CROPSNAIL_ENTITY = ENTITY_TYPES.register("cropsnail_entity",
            () -> EntityType.Builder.of(CropSnail::new,
                            MobCategory.CREATURE)
                    .sized(1f,1f)
                    .build(new ResourceLocation(MODID,"cropsnail").toString()));

    public static final RegistryObject<EntityType<Amarga>> AMARGA_ENTITY = ENTITY_TYPES.register("amarga_entity",
            () -> EntityType.Builder.of(Amarga::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"amarga").toString()));

    public static final RegistryObject<EntityType<Para>> PARA_ENTITY = ENTITY_TYPES.register("para_entity",
            () -> EntityType.Builder.of(Para::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"para").toString()));
    public static final RegistryObject<EntityType<Theri>> THERI_ENTITY = ENTITY_TYPES.register("theri_entity",
            () -> EntityType.Builder.of(Theri::new,
                            MobCategory.CREATURE)
                    .sized(2f,5f)
                    .build(new ResourceLocation(MODID,"theri").toString()));
    public static final RegistryObject<EntityType<Deinoch>> DEINOCH_ENTITY = ENTITY_TYPES.register("deinoch_entity",
            () -> EntityType.Builder.of(Deinoch::new,
                            MobCategory.CREATURE)
                    .sized(2f,5f)
                    .build(new ResourceLocation(MODID,"deinoch").toString()));
    public static final RegistryObject<EntityType<Stego>> STEGO_ENTITY = ENTITY_TYPES.register("stego_entity",
            () -> EntityType.Builder.of(Stego::new,
                            MobCategory.CREATURE)
                    .sized(2f,4f)
                    .build(new ResourceLocation(MODID,"stego").toString()));
    public static final RegistryObject<EntityType<Shant>> SHANT_ENTITY = ENTITY_TYPES.register("shant_entity",
            () -> EntityType.Builder.of(Shant::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"shant").toString()));
    public static final RegistryObject<EntityType<Galli>> GALLI_ENTITY = ENTITY_TYPES.register("galli_entity",
            () -> EntityType.Builder.of(Galli::new,
                            MobCategory.CREATURE)
                    .sized(2f,2.5f)
                    .build(new ResourceLocation(MODID,"galli").toString()));
    public static final RegistryObject<EntityType<Sauro>> SAURO_ENTITY = ENTITY_TYPES.register("sauro_entity",
            () -> EntityType.Builder.of(Sauro::new,
                            MobCategory.CREATURE)
                    .sized(5f,8f)
                    .build(new ResourceLocation(MODID,"sauro").toString()));
    public static final RegistryObject<EntityType<Anky>> ANKY_ENTITY = ENTITY_TYPES.register("anky_entity",
            () -> EntityType.Builder.of(Anky::new,
                            MobCategory.CREATURE)
                    .sized(2f,2.5f)
                    .build(new ResourceLocation(MODID,"anky").toString()));
    public static final RegistryObject<EntityType<Ava>> AVA_ENTITY = ENTITY_TYPES.register("ava_entity",
            () -> EntityType.Builder.of(Ava::new,
                            MobCategory.CREATURE)
                    .sized(1.5f,1.5f)
                    .build(new ResourceLocation(MODID,"ava").toString()));
    public static final RegistryObject<EntityType<Grypo>> GRYPO_ENTITY = ENTITY_TYPES.register("grypo_entity",
            () -> EntityType.Builder.of(Grypo::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"grypo").toString()));
    public static final RegistryObject<EntityType<Ampelo>> AMPELO_ENTITY = ENTITY_TYPES.register("ampelo_entity",
            () -> EntityType.Builder.of(Ampelo::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"ampelo").toString()));






    //Cars

    public static final RegistryObject<EntityType<Car>> CAR_ENTITY = ENTITY_TYPES.register("car_entity",
            () -> EntityType.Builder.of(Car::new,
                            MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"car").toString()));

    public static final RegistryObject<EntityType<CarSide>> CARSIDE_ENTITY = ENTITY_TYPES.register("carside_entity",
            () -> EntityType.Builder.of(CarSide::new,
                            MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"carside").toString()));

    public static final RegistryObject<EntityType<CarFlipped>> CARFLIPPED_ENTITY = ENTITY_TYPES.register("carflipped_entity",
            () -> EntityType.Builder.of(CarFlipped::new,
                            MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"carflipped").toString()));

}

