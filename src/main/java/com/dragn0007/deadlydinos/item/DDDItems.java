package com.dragn0007.deadlydinos.item;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.util.EntityTypes;
import com.dragn0007.deadlydinos.item.custom.SodaItem;
import com.dragn0007.deadlydinos.item.custom.TrophyItem;
import com.dragn0007.deadlydinos.item.util.DDDArmorMaterial;
import com.dragn0007.deadlydinos.item.util.DDDItemGroup;
import com.dragn0007.deadlydinos.item.util.DDDItemTier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDDItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeadlyDinos.MODID);



    //CARNIVORE SPAWN EGGS
    public static final RegistryObject<Item> UTAH_SPAWN_EGG = ITEMS.register("utah_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.UTAH_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> COMPY_SPAWN_EGG = ITEMS.register("compy_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.COMPY_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> ACRO_SPAWN_EGG = ITEMS.register("acro_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ACRO_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> CARNO_SPAWN_EGG = ITEMS.register("carno_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.CARNO_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> CERATO_SPAWN_EGG = ITEMS.register("cerato_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.CERATO_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> GIGA_SPAWN_EGG = ITEMS.register("giga_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.GIGA_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> REX_SPAWN_EGG = ITEMS.register("rex_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.REX_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> SPINO_SPAWN_EGG = ITEMS.register("spino_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.SPINO_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> MAHAKALA_SPAWN_EGG = ITEMS.register("mahakala_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.MAHAKALA_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> AUSTRO_SPAWN_EGG = ITEMS.register("austro_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.AUSTRO_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> DEINON_SPAWN_EGG = ITEMS.register("deinon_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.DEINON_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> ALBERTO_SPAWN_EGG = ITEMS.register("alberto_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ALBERTO_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> MAJUNGA_SPAWN_EGG = ITEMS.register("majunga_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.MAJUNGA_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> TROODON_SPAWN_EGG = ITEMS.register("troodon_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.TROODON_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> ARCHAE_SPAWN_EGG = ITEMS.register("archae_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ARCHAE_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> TARBO_SPAWN_EGG = ITEMS.register("tarbo_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.TARBO_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> ANDAL_SPAWN_EGG = ITEMS.register("andal_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ANDAL_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));


    //HERBIVORE SPAWN EGGS
    public static final RegistryObject<Item> CROPSNAIL_SPAWN_EGG = ITEMS.register("cropsnail_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.CROPSNAIL_ENTITY, 0x9648273, 0xbd864b, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> AMARGA_SPAWN_EGG = ITEMS.register("amarga_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.AMARGA_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> PARA_SPAWN_EGG = ITEMS.register("para_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.PARA_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> THERI_SPAWN_EGG = ITEMS.register("theri_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.THERI_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> DEINOCH_SPAWN_EGG = ITEMS.register("deinoch_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.DEINOCH_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> STEGO_SPAWN_EGG = ITEMS.register("stego_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.STEGO_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> SHANT_SPAWN_EGG = ITEMS.register("shant_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.SHANT_ENTITY, 0x3d4947, 0xf8ffff, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> GALLI_SPAWN_EGG = ITEMS.register("galli_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.GALLI_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> SAURO_SPAWN_EGG = ITEMS.register("sauro_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.SAURO_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> ANKY_SPAWN_EGG = ITEMS.register("anky_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ANKY_ENTITY, 0xb08260, 0xe3955d, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));
    public static final RegistryObject<Item> AVA_SPAWN_EGG = ITEMS.register("ava_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.AVA_ENTITY, 0x00FFFFFF, 0x00FFFFFF, new Item.Properties().stacksTo(64).tab(DDDItemGroup.DINO_GROUP)));



    //FOOD ITEMS
    public static final RegistryObject<Item> RAWSMALLMEAT = ITEMS.register("rawsmallmeat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 250, 4) ,0.75F).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> COOKEDSMALLMEAT = ITEMS.register("cookedsmallmeat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).meat().build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> RAWMEDIUMMEAT = ITEMS.register("rawmediummeat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 5) ,0.85F).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> COOKEDMEDIUMMEAT = ITEMS.register("cookedmediummeat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).meat().build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> RAWLARGEMEAT = ITEMS.register("rawlargemeat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 5) ,0.85F).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> COOKEDLARGEMEAT = ITEMS.register("cookedlargemeat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(12).saturationMod(1).meat().build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> CRACKER = ITEMS.register("cracker",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> DINOSANDWICH = ITEMS.register("dinosandwich",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(18).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> CANNEDVEGGIES = ITEMS.register("cannedveggies",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> CANNEDMEAT = ITEMS.register("cannedmeat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> CANNEDSTEW = ITEMS.register("cannedstew",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> MRE = ITEMS.register("mre",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
//    public static final RegistryObject<Item> ALCOHOL = ITEMS.register("alcohol",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> SODA = ITEMS.register("soda",
        () -> new SodaItem(
                new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 1, true, false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 1, true, false)
        ));
    public static final RegistryObject<Item> TIGER_NUTS = ITEMS.register("tiger_nuts",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> YEW_PLUM = ITEMS.register("yew_plum",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> TIGER_NUT_BUTTER = ITEMS.register("tiger_nut_butter",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> YEW_PLUM_JAM = ITEMS.register("yew_plum_jam",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> PBJ = ITEMS.register("pbj",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(14).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> GLAZED_RIBS = ITEMS.register("glazed_ribs",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(12).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> RAWESCARGOT = ITEMS.register("rawescargot",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0).meat().effect(() -> new MobEffectInstance(MobEffects.HUNGER, 250, 4) ,0.75F).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> COOKEDESCARGOT = ITEMS.register("cookedescargot",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).meat().build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> DINO_NUGGET_1 = ITEMS.register("dino_nugget_1",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).meat().build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> DINO_NUGGET_2 = ITEMS.register("dino_nugget_2",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).meat().build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> DINO_NUGGET_3 = ITEMS.register("dino_nugget_3",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).meat().build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> HEARTY_SALAD = ITEMS.register("hearty_salad",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> SMOOTHIE = ITEMS.register("smoothie",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> DINO_DUMPLING = ITEMS.register("dino_dumpling",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> CHICKEN_NOODLE_SOUP = ITEMS.register("chicken_noodle_soup",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> DINO_ROAST = ITEMS.register("dino_roast",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(16).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> BONE_MARROW = ITEMS.register("bone_marrow",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(1).meat().build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> BROTH = ITEMS.register("broth",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));
    public static final RegistryObject<Item> DOUGH = ITEMS.register("dough",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(1).build()).tab(DDDItemGroup.FOOD_GROUP)));



    //SMALL CARNI BONES
    public static final RegistryObject<Item> SMALLCARNITOOTH = ITEMS.register("smallcarnitooth",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLCARNISKULL = ITEMS.register("smallcarniskull",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLCARNIRIBS = ITEMS.register("smallcarniribs",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLCARNICLAW = ITEMS.register("smallcarniclaw",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLCARNITAIL = ITEMS.register("smallcarnitail",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLRAPTORCLAW = ITEMS.register("smallraptorclaw",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLCARNISPINE = ITEMS.register("smallcarnispine",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLCARNILEG = ITEMS.register("smallcarnileg",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));


    //MEDIUM CARNI BONES
    public static final RegistryObject<Item> MEDCARNITOOTH = ITEMS.register("medcarnitooth",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDCARNISKULL = ITEMS.register("medcarniskull",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDCARNIRIBS= ITEMS.register("medcarniribs",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDCARNICLAW = ITEMS.register("medcarniclaw",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDCARNITAIL = ITEMS.register("medcarnitail",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDRAPTORCLAW = ITEMS.register("medraptorclaw",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDCARNISPINE = ITEMS.register("medcarnispine",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDCARNILEG = ITEMS.register("medcarnileg",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));


    //LARGE CARNI BONES
    public static final RegistryObject<Item> LARGECARNITOOTH = ITEMS.register("largecarnitooth",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGECARNISKULL = ITEMS.register("largecarniskull",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGECARNIRIBS= ITEMS.register("largecarniribs",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGECARNICLAW = ITEMS.register("largecarniclaw",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGECARNITAIL = ITEMS.register("largecarnitail",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGECARNISPINE = ITEMS.register("largecarnispine",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGECARNILEG = ITEMS.register("largecarnileg",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));


    //TOOLS
    public static final RegistryObject<Item> SMALLBONE_SWORD = ITEMS.register("smallbone_sword",
            () -> new SwordItem(DDDItemTier.SMALLBONE, 3, -2f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLBONE_PICKAXE = ITEMS.register("smallbone_pickaxe",
            () -> new PickaxeItem(DDDItemTier.SMALLBONE, 1, 1f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLBONE_AXE = ITEMS.register("smallbone_axe",
            () -> new AxeItem(DDDItemTier.SMALLBONE, 4, -2.5f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLBONE_SHOVEL = ITEMS.register("smallbone_shovel",
            () -> new ShovelItem(DDDItemTier.SMALLBONE, 1, 1f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLBONE_HOE = ITEMS.register("smallbone_hoe",
            () -> new HoeItem(DDDItemTier.SMALLBONE, 1, 1f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));


    public static final RegistryObject<Item> MEDIUMBONE_SWORD = ITEMS.register("mediumbone_sword",
            () -> new SwordItem(DDDItemTier.MEDIUMBONE, 3, -2f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDIUMBONE_PICKAXE = ITEMS.register("mediumbone_pickaxe",
            () -> new PickaxeItem(DDDItemTier.MEDIUMBONE, 1, 1f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDIUMBONE_AXE = ITEMS.register("mediumbone_axe",
            () -> new AxeItem(DDDItemTier.MEDIUMBONE, 4, -2.5f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDIUMBONE_SHOVEL = ITEMS.register("mediumbone_shovel",
            () -> new ShovelItem(DDDItemTier.MEDIUMBONE, 1, 1f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDIUMBONE_HOE = ITEMS.register("mediumbone_hoe",
            () -> new HoeItem(DDDItemTier.MEDIUMBONE, 1, 1f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));


    public static final RegistryObject<Item> LARGEBONE_SWORD = ITEMS.register("largebone_sword",
            () -> new SwordItem(DDDItemTier.LARGEBONE, 3, -1f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGEBONE_PICKAXE = ITEMS.register("largebone_pickaxe",
            () -> new PickaxeItem(DDDItemTier.LARGEBONE, 1, 1f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGEBONE_AXE = ITEMS.register("largebone_axe",
            () -> new AxeItem(DDDItemTier.LARGEBONE, 4, -2.5f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGEBONE_SHOVEL = ITEMS.register("largebone_shovel",
            () -> new ShovelItem(DDDItemTier.LARGEBONE, 1, 1f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGEBONE_HOE = ITEMS.register("largebone_hoe",
            () -> new HoeItem(DDDItemTier.LARGEBONE, 1, 1f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGEBONE_CLUB = ITEMS.register("largebone_club",
            () -> new SwordItem(DDDItemTier.LARGEBONE, 5, -3f,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));


    public static final RegistryObject<Item> BOWIE_KNIFE = ITEMS.register("bowie_knife",
            () -> new SwordItem(Tiers.IRON, 2, -1.4F,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> CROWBAR = ITEMS.register("crowbar",
            () -> new SwordItem(Tiers.IRON, 2, -2.4F,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));



    //ARMOR
    public static final RegistryObject<Item> BONENETHERITE_HELMET = ITEMS.register("bonenetherite_helmet",
            () -> new ArmorItem(DDDArmorMaterial.BONENETHERITE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONENETHERITE_CHESTPLATE = ITEMS.register("bonenetherite_chestplate",
            () -> new ArmorItem(DDDArmorMaterial.BONENETHERITE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONENETHERITE_LEGGINGS = ITEMS.register("bonenetherite_leggings",
            () -> new ArmorItem(DDDArmorMaterial.BONENETHERITE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONENETHERITE_BOOTS = ITEMS.register("bonenetherite_boots",
            () -> new ArmorItem(DDDArmorMaterial.BONENETHERITE, EquipmentSlot.FEET,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));


    public static final RegistryObject<Item> BONEDIAMOND_HELMET = ITEMS.register("bonediamond_helmet",
            () -> new ArmorItem(DDDArmorMaterial.BONEDIAMOND, EquipmentSlot.HEAD,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONEDIAMOND_CHESTPLATE = ITEMS.register("bonediamond_chestplate",
            () -> new ArmorItem(DDDArmorMaterial.BONEDIAMOND, EquipmentSlot.CHEST,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONEDIAMOND_LEGGINGS = ITEMS.register("bonediamond_leggings",
            () -> new ArmorItem(DDDArmorMaterial.BONEDIAMOND, EquipmentSlot.LEGS,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONEDIAMOND_BOOTS = ITEMS.register("bonediamond_boots",
            () -> new ArmorItem(DDDArmorMaterial.BONEDIAMOND, EquipmentSlot.FEET,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));


    public static final RegistryObject<Item> BONEGOLD_HELMET = ITEMS.register("bonegold_helmet",
            () -> new ArmorItem(DDDArmorMaterial.BONEGOLD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONEGOLD_CHESTPLATE = ITEMS.register("bonegold_chestplate",
            () -> new ArmorItem(DDDArmorMaterial.BONEGOLD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONEGOLD_LEGGINGS = ITEMS.register("bonegold_leggings",
            () -> new ArmorItem(DDDArmorMaterial.BONEGOLD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONEGOLD_BOOTS = ITEMS.register("bonegold_boots",
            () -> new ArmorItem(DDDArmorMaterial.BONEGOLD, EquipmentSlot.FEET,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));


    public static final RegistryObject<Item> BONEIRON_HELMET = ITEMS.register("boneiron_helmet",
            () -> new ArmorItem(DDDArmorMaterial.BONEIRON, EquipmentSlot.HEAD,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONEIRON_CHESTPLATE = ITEMS.register("boneiron_chestplate",
            () -> new ArmorItem(DDDArmorMaterial.BONEIRON, EquipmentSlot.CHEST,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONEIRON_LEGGINGS = ITEMS.register("boneiron_leggings",
            () -> new ArmorItem(DDDArmorMaterial.BONEIRON, EquipmentSlot.LEGS,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> BONEIRON_BOOTS = ITEMS.register("boneiron_boots",
            () -> new ArmorItem(DDDArmorMaterial.BONEIRON, EquipmentSlot.FEET,
                    new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));




    //SMALL HERBI BONES
    public static final RegistryObject<Item> SMALLHERBITOOTH = ITEMS.register("smallherbitooth",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLHERBISKULL = ITEMS.register("smallherbiskull",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLHERBIRIBS = ITEMS.register("smallherbiribs",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLHERBICLAW = ITEMS.register("smallherbiclaw",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLHERBITAIL = ITEMS.register("smallherbitail",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLHERBISPINE = ITEMS.register("smallherbispine",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> SMALLHERBILEG = ITEMS.register("smallherbileg",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));



//MEDIUM HERBI BONES
    public static final RegistryObject<Item> MEDHERBITOOTH = ITEMS.register("medherbitooth",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDHERBISKULL = ITEMS.register("medherbiskull",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDHERBIRIBS= ITEMS.register("medherbiribs",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDHERBICLAW = ITEMS.register("medherbiclaw",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDHERBITAIL = ITEMS.register("medherbitail",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDHERBISPINE = ITEMS.register("medherbispine",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> MEDHERBILEG = ITEMS.register("medherbileg",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));



//LARGE HERBI BONES
    public static final RegistryObject<Item> LARGEHERBITOOTH = ITEMS.register("largeherbitooth",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGEHERBISKULL = ITEMS.register("largeherbiskull",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGEHERBIRIBS= ITEMS.register("largeherbiribs",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGEHERBICLAW = ITEMS.register("largeherbiclaw",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGEHERBITAIL = ITEMS.register("largeherbitail",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGEHERBISPINE = ITEMS.register("largeherbispine",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));
    public static final RegistryObject<Item> LARGEHERBILEG = ITEMS.register("largeherbileg",
            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));


    //TODO;
//    public static final RegistryObject<Item> ARCHAE_HARNESS = ITEMS.register("archae_harness",
//            () -> new Item(new Item.Properties().tab(DDDItemGroup.DDD_GROUP)));


    //TROPHIES
    public static final RegistryObject<TrophyItem> ACROTROPHY = ITEMS.register("acrotrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 3,true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)

            ));
    public static final RegistryObject<TrophyItem> ALBERTOTROPHY = ITEMS.register("albertotrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 3,true, false),
                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 5, true, false)

            ));
    public static final RegistryObject<TrophyItem> ANDALTROPHY = ITEMS.register("andaltrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 1,true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)

            ));
    public static final RegistryObject<TrophyItem> ARCHAETROPHY = ITEMS.register("archaetrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.JUMP, 2880, 2, true, false)

            ));
    public static final RegistryObject<TrophyItem> AUSTROTROPHY = ITEMS.register("austrotrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.LUCK, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.JUMP, 2880, 2, true, false)

            ));
    public static final RegistryObject<TrophyItem> CARNOTROPHY = ITEMS.register("carnotrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)
            ));

    public static final RegistryObject<TrophyItem> CERATOTROPHY = ITEMS.register("ceratotrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.REGENERATION, 2880, 3, true, false)
            ));

    public static final RegistryObject<TrophyItem> COMPYTROPHY = ITEMS.register("compytrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.SATURATION, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)
            ));

    public static final RegistryObject<TrophyItem> DEINONTROPHY = ITEMS.register("deinontrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)
            ));
    public static final RegistryObject<TrophyItem> GIGATROPHY = ITEMS.register("gigatrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.REGENERATION, 2880, 3, true, false),
                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> MAHAKALATROPHY = ITEMS.register("mahakalatrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.LUCK, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.JUMP, 2880, 2, true, false)
            ));
    public static final RegistryObject<TrophyItem> MAJUNGATROPHY = ITEMS.register("majungatrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> REXTROPHY = ITEMS.register("rextrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 5, true, false),
                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> SPINOTROPHY = ITEMS.register("spinotrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2880, 1,true, false),
                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> TARBOTROPHY = ITEMS.register("tarbotrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.REGENERATION, 2880, 1,true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> TROODONTROPHY = ITEMS.register("troodontrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.LUCK, 2880, 5,true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 2, true, false)
            ));
    public static final RegistryObject<TrophyItem> UTAHTROPHY = ITEMS.register("utahtrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.JUMP, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2880, 3, true, false)
            ));

    public static final RegistryObject<TrophyItem> AMARGATROPHY = ITEMS.register("amargatrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> ANKYTROPHY = ITEMS.register("ankytrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> AVATROPHY = ITEMS.register("avatrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.HEALTH_BOOST, 2880, 2,true, false)
            ));
    public static final RegistryObject<TrophyItem> DEINOCHTROPHY = ITEMS.register("deinochtrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> GALLITROPHY = ITEMS.register("gallitrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.JUMP, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> PARATROPHY = ITEMS.register("paratrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> SAUROTROPHY = ITEMS.register("saurotrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2880, 3, true, false),
                    new MobEffectInstance(MobEffects.SATURATION, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> SHANTTROPHY = ITEMS.register("shanttrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.HEALTH_BOOST, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> STEGOTROPHY = ITEMS.register("stegotrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.REGENERATION, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.ABSORPTION, 2880, 3, true, false)
            ));
    public static final RegistryObject<TrophyItem> THERITROPHY = ITEMS.register("theritrophy",
            () -> new TrophyItem(
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2880, 2,true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 2880, 3, true, false)
            ));




    //MOD ITEM TABS (UNOBTAINABLE)
    public static final RegistryObject<Item> DDDITEMS = ITEMS.register("ddditems",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DDDENTITIES = ITEMS.register("dddentities",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DDDFOOD = ITEMS.register("dddfood",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DDDBLOCKS = ITEMS.register("dddblocks",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}