package com.dragn0007.deadlydinos.entity;

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

    public static final RegistryObject<EntityType<AcroEntity>> ACRO_ENTITY = ENTITY_TYPES.register("acro_entity",
            () -> EntityType.Builder.of(AcroEntity::new,
                    MobCategory.CREATURE)
                    .sized(3f,4f)
                    .build(new ResourceLocation(MODID,"acro").toString()));
    public static final RegistryObject<EntityType<UtahEntity>> UTAH_ENTITY = ENTITY_TYPES.register("utah_entity",
            () -> EntityType.Builder.of(UtahEntity::new,
                            MobCategory.CREATURE)
                    .sized(0.8f,1.8f)
                    .build(new ResourceLocation(MODID,"utah").toString()));

    public static final RegistryObject<EntityType<CarnoEntity>> CARNO_ENTITY = ENTITY_TYPES.register("carno_entity",
            () -> EntityType.Builder.of(CarnoEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,3f)
                    .build(new ResourceLocation(MODID,"carno").toString()));

    public static final RegistryObject<EntityType<CeratoEntity>> CERATO_ENTITY = ENTITY_TYPES.register("cerato_entity",
            () -> EntityType.Builder.of(CeratoEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,3f)
                    .build(new ResourceLocation(MODID,"cerato").toString()));

    public static final RegistryObject<EntityType<GigaEntity>> GIGA_ENTITY = ENTITY_TYPES.register("giga_entity",
            () -> EntityType.Builder.of(GigaEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"giga").toString()));

    public static final RegistryObject<EntityType<RexEntity>> REX_ENTITY = ENTITY_TYPES.register("rex_entity",
            () -> EntityType.Builder.of(RexEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"rex").toString()));

    public static final RegistryObject<EntityType<SpinoEntity>> SPINO_ENTITY = ENTITY_TYPES.register("spino_entity",
            () -> EntityType.Builder.of(SpinoEntity::new,
                            MobCategory.WATER_CREATURE)
                    .sized(2f,5f)
                    .build(new ResourceLocation(MODID,"spino").toString()));
    public static final RegistryObject<EntityType<CompyEntity>> COMPY_ENTITY = ENTITY_TYPES.register("compy_entity",
            () -> EntityType.Builder.of(CompyEntity::new,
                            MobCategory.CREATURE)
                    .sized(0.5f,0.5f)
                    .build(new ResourceLocation(MODID,"compy").toString()));

    public static final RegistryObject<EntityType<MahakalaEntity>> MAHAKALA_ENTITY = ENTITY_TYPES.register("mahakala_entity",
            () -> EntityType.Builder.of(MahakalaEntity::new,
                            MobCategory.CREATURE)
                    .sized(0.3f,0.3f)
                    .build(new ResourceLocation(MODID,"mahakala").toString()));

    public static final RegistryObject<EntityType<AustroEntity>> AUSTRO_ENTITY = ENTITY_TYPES.register("austro_entity",
            () -> EntityType.Builder.of(AustroEntity::new,
                            MobCategory.CREATURE)
                    .sized(0.8f,1.5f)
                    .build(new ResourceLocation(MODID,"austro").toString()));

    public static final RegistryObject<EntityType<DeinonEntity>> DEINON_ENTITY = ENTITY_TYPES.register("deinon_entity",
            () -> EntityType.Builder.of(DeinonEntity::new,
                            MobCategory.CREATURE)
                    .sized(0.6f,1.3f)
                    .build(new ResourceLocation(MODID,"deinon").toString()));

    public static final RegistryObject<EntityType<AlbertoEntity>> ALBERTO_ENTITY = ENTITY_TYPES.register("alberto_entity",
            () -> EntityType.Builder.of(AlbertoEntity::new,
                            MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"alberto").toString()));

    public static final RegistryObject<EntityType<MajungaEntity>> MAJUNGA_ENTITY = ENTITY_TYPES.register("majunga_entity",
            () -> EntityType.Builder.of(MajungaEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,3f)
                    .build(new ResourceLocation(MODID,"majunga").toString()));

    public static final RegistryObject<EntityType<TroodonEntity>> TROODON_ENTITY = ENTITY_TYPES.register("troodon_entity",
            () -> EntityType.Builder.of(TroodonEntity::new,
                            MobCategory.CREATURE)
                    .sized(0.5f,1f)
                    .build(new ResourceLocation(MODID,"troodon").toString()));

    public static final RegistryObject<EntityType<ArchaeEntity>> ARCHAE_ENTITY = ENTITY_TYPES.register("archae_entity",
            () -> EntityType.Builder.of(ArchaeEntity::new,
                            MobCategory.CREATURE)
                    .sized(0.5f,1f)
                    .build(new ResourceLocation(MODID,"archae").toString()));

    public static final RegistryObject<EntityType<TarboEntity>> TARBO_ENTITY = ENTITY_TYPES.register("tarbo_entity",
            () -> EntityType.Builder.of(TarboEntity::new,
                            MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"tarbo").toString()));



    //Herbivores

    public static final RegistryObject<EntityType<CropSnailEntity>> CROPSNAIL_ENTITY = ENTITY_TYPES.register("cropsnail_entity",
            () -> EntityType.Builder.of(CropSnailEntity::new,
                            MobCategory.CREATURE)
                    .sized(1f,1f)
                    .build(new ResourceLocation(MODID,"cropsnail").toString()));

    public static final RegistryObject<EntityType<AmargaEntity>> AMARGA_ENTITY = ENTITY_TYPES.register("amarga_entity",
            () -> EntityType.Builder.of(AmargaEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"amarga").toString()));

    public static final RegistryObject<EntityType<ParaEntity>> PARA_ENTITY = ENTITY_TYPES.register("para_entity",
            () -> EntityType.Builder.of(ParaEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"amarga").toString()));
    public static final RegistryObject<EntityType<TheriEntity>> THERI_ENTITY = ENTITY_TYPES.register("theri_entity",
            () -> EntityType.Builder.of(TheriEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,5f)
                    .build(new ResourceLocation(MODID,"amarga").toString()));
    public static final RegistryObject<EntityType<DeinochEntity>> DEINOCH_ENTITY = ENTITY_TYPES.register("deinoch_entity",
            () -> EntityType.Builder.of(DeinochEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,5f)
                    .build(new ResourceLocation(MODID,"deinoch").toString()));
    public static final RegistryObject<EntityType<StegoEntity>> STEGO_ENTITY = ENTITY_TYPES.register("stego_entity",
            () -> EntityType.Builder.of(StegoEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,4f)
                    .build(new ResourceLocation(MODID,"stego").toString()));
    public static final RegistryObject<EntityType<ShantEntity>> SHANT_ENTITY = ENTITY_TYPES.register("shant_entity",
            () -> EntityType.Builder.of(ShantEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,4.5f)
                    .build(new ResourceLocation(MODID,"shant").toString()));
    public static final RegistryObject<EntityType<GalliEntity>> GALLI_ENTITY = ENTITY_TYPES.register("galli_entity",
            () -> EntityType.Builder.of(GalliEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,2.5f)
                    .build(new ResourceLocation(MODID,"galli").toString()));
    public static final RegistryObject<EntityType<SauroEntity>> SAURO_ENTITY = ENTITY_TYPES.register("sauro_entity",
            () -> EntityType.Builder.of(SauroEntity::new,
                            MobCategory.CREATURE)
                    .sized(5f,8f)
                    .build(new ResourceLocation(MODID,"sauro").toString()));
    public static final RegistryObject<EntityType<AnkyEntity>> ANKY_ENTITY = ENTITY_TYPES.register("anky_entity",
            () -> EntityType.Builder.of(AnkyEntity::new,
                            MobCategory.CREATURE)
                    .sized(2f,2.5f)
                    .build(new ResourceLocation(MODID,"anky").toString()));
    public static final RegistryObject<EntityType<AvaEntity>> AVA_ENTITY = ENTITY_TYPES.register("ava_entity",
            () -> EntityType.Builder.of(AvaEntity::new,
                            MobCategory.CREATURE)
                    .sized(1.5f,1.5f)
                    .build(new ResourceLocation(MODID,"ava").toString()));






    //Cars

    public static final RegistryObject<EntityType<CarEntity>> CAR_ENTITY = ENTITY_TYPES.register("car_entity",
            () -> EntityType.Builder.of(CarEntity::new,
                            MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"car").toString()));

    public static final RegistryObject<EntityType<CarSideEntity>> CARSIDE_ENTITY = ENTITY_TYPES.register("carside_entity",
            () -> EntityType.Builder.of(CarSideEntity::new,
                            MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"carside").toString()));

    public static final RegistryObject<EntityType<CarFlippedEntity>> CARFLIPPED_ENTITY = ENTITY_TYPES.register("carflipped_entity",
            () -> EntityType.Builder.of(CarFlippedEntity::new,
                            MobCategory.CREATURE)
                    .sized(3f,3f)
                    .build(new ResourceLocation(MODID,"carflipped").toString()));

}

