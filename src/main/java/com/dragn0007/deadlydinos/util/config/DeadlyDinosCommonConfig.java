package com.dragn0007.deadlydinos.util.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeadlyDinosCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> TROPHYITEM_DURABILITY;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWNCONFIGHELPER;
//    public static final ForgeConfigSpec.ConfigValue<Boolean> DINO_GRIEFING_ENABLED;
    public static final ForgeConfigSpec.ConfigValue<Integer> BIG_DINO_BREAK_RADIUS;
    public static final ForgeConfigSpec.ConfigValue<Integer> SMALL_DINO_BREAK_RADIUS;
    public static final ForgeConfigSpec.ConfigValue<Integer> ACRO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ALBERTO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ALLO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ANDAL_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> AMARGA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> AMPELO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ANKY_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ARCHAE_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ATROCI_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> AUSTRALO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> AUSTRO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> AVA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CARCHAR_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CARNO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CERATO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> COMPY_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CROPSNAIL_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CRYO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> DEINOCH_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> DEINON_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> DILO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> EDMONTO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> EOCARCHAR_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> GALLI_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> GIGA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> GRYPO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ICHTHY_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> IGUA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAHAKALA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAJUNGA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> MEGARAP_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PACHYR_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PARA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> REX_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SAURO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHANT_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPINO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> STEGO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> TARBO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> THERI_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRIKE_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> TROODON_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> UTAH_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> YUTY_WEIGHT;





    static {
        BUILDER.push("Configs for Deadly Dinos!");

        TROPHYITEM_DURABILITY = BUILDER.comment("Amount of uses of Dino Trophies. Set to 0 for inifinite durability. Default is 10.")
                .define("How much durabiltiy should Dino Trophies have?", 10);

//        DINO_GRIEFING_ENABLED = BUILDER.comment("Should Dinos be able to break blocks? True or False. Default: True")
//                .define("Dino Grief", true);

        //Large Dinos - How many blocks should they break?
        BIG_DINO_BREAK_RADIUS = BUILDER.comment("What should the radius be that Large Deadly Dinos can destroy when attacking? 5 Blocks is Default.")
                .define("Large Dino destroy radius", 5);

        //Small Dinos - How many blocks should they break?
        SMALL_DINO_BREAK_RADIUS = BUILDER.comment("What should the radius be that Small Deadly Dinos can destroy when attacking? 3 Blocks is Default.")
                .define("Small Dino destroy radius", 3);


        SPAWNCONFIGHELPER = BUILDER.comment("Dino spawn configs have 1 integer: Weight. You can play with this number to get the perfect spawn rate for you. Set it to 0 to stop a certain dino from spawning entirely.")
                .define("<<SPAWN CONFIG HELPER>> - Look here ^ for help!", 7777);


        ACRO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 4.")
                .define("ACRO Spawn Weight", 4);

        ALBERTO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("ALBERTO Spawn Weight", 2);

        ALLO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("ALLO Spawn Weight", 2);

        ANDAL_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 4.")
                .define("ANDAL Spawn Weight", 4);

        AMARGA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("AMARGA Spawn Weight", 1);

        AMPELO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("AMPELO Spawn Weight", 1);

        ANKY_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("ANKY Spawn Weight", 1);

        ARCHAE_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("ARCHAE Spawn Weight", 3);

        ATROCI_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("ATROCI Spawn Weight", 2);

        AUSTRALO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 4.")
                .define("AUSTRALO Spawn Weight", 4);

        AUSTRO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("AUSTRO Spawn Weight", 2);

        AVA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("AVA Spawn Weight", 1);

        CARCHAR_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("CARCHAR Spawn Weight", 3);

        CARNO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 4.")
                .define("CARNO Spawn Weight", 4);

        CERATO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 5.")
                .define("CERATO Spawn Weight", 5);

        COMPY_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("COMPY Spawn Weight", 2);

        CROPSNAIL_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 5.")
                .define("CROPSNAIL Spawn Weight", 5);

        CRYO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("CRYO Spawn Weight", 3);

        DEINOCH_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("DEINOCH Spawn Weight", 1);

        DEINON_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("DEINON Spawn Weight", 2);

        DILO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("DILO Spawn Weight", 2);

        EDMONTO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("EDMONTO Spawn Weight", 1);

        EOCARCHAR_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("EOCARCHAR Spawn Weight", 1);

        GALLI_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("GALLI Spawn Weight", 1);

        GIGA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 4.")
                .define("GIGA Spawn Weight", 4);

        GRYPO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("GRYPO Spawn Weight", 1);

        ICHTHY_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("ICHTHY Spawn Weight", 1);

        IGUA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("IGUA Spawn Weight", 1);

        MAHAKALA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 6.")
                .define("MAHAKALA Spawn Weight", 6);

        MAJUNGA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 4.")
                .define("MAJUNGA Spawn Weight", 4);

        MEGARAP_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("MEGARAP Spawn Weight", 3);

        PACHYR_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("PACHYR Spawn Weight", 3);

        PARA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("PARA Spawn Weight", 2);

        REX_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 4.")
                .define("REX Spawn Weight", 4);

        SAURO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("SAURO Spawn Weight", 1);

        SHANT_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("SHANT Spawn Weight", 2);

        SPINO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("SPINO Spawn Weight", 2);

        STEGO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("STEGO Spawn Weight", 3);

        TARBO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("TARBO Spawn Weight", 1);

        THERI_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("THERI Spawn Weight", 1);

        TRIKE_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("TRIKE Spawn Weight", 1);

        TROODON_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("TROODON Spawn Weight", 2);

        UTAH_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 4.")
                .define("UTAH Spawn Weight", 4);

        YUTY_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("YUTY Spawn Weight", 1);



        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
