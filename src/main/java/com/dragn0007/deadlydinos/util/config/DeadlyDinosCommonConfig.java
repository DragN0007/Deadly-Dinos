package com.dragn0007.deadlydinos.util.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeadlyDinosCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> TROPHYITEM_DURABILITY;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWNCONFIGHELPER;
    public static final ForgeConfigSpec.ConfigValue<Integer> GRIEFCONFIGHELPER;
    public static final ForgeConfigSpec.ConfigValue<Integer> BIG_DINO_BREAK_WIDTH;
    public static final ForgeConfigSpec.ConfigValue<Integer> BIG_DINO_BREAK_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> BIG_DINO_BREAK_DEPTH;
    public static final ForgeConfigSpec.ConfigValue<Integer> SMALL_DINO_BREAK_WIDTH;
    public static final ForgeConfigSpec.ConfigValue<Integer> SMALL_DINO_BREAK_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SMALL_DINO_BREAK_DEPTH;
    public static final ForgeConfigSpec.ConfigValue<Integer> ACRO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ALBERTO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ALLO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ANDAL_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> AMARGA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> AMPELO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ANKY_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ARCHAE_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> AUSTRO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> AVA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CARCHAR_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CARNO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CERATO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> COMPY_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CROPSNAIL_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> DEINOCH_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> DEINON_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> DILO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> GALLI_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> GIGA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> GRYPO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAHAKALA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAJUNGA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PARA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> REX_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SAURO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SHANT_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPINO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> STEGO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> TARBO_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> THERI_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> TROODON_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> UTAH_WEIGHT;





    static {
        BUILDER.push("Configs for Deadly Dinos!");

        TROPHYITEM_DURABILITY = BUILDER.comment("Amount of uses of Dino Trophies. Set to 0 for inifinite durability. Default is 10.")
                .define("How much durabiltiy should Dino Trophies have?", 10);

        BUILDER.comment("<<GRIEF CONFIG HELPER>> Dino block-destroy configs have 3 integers: Width, Height, and Depth. You can play with these numbers to get the perfect block-break range for you. Set all to 0 to stop dinos from breaking blocks entirely.");

        GRIEFCONFIGHELPER = BUILDER.comment("Dino block-destroy configs have 3 integers: Width, Height, and Depth. You can play with these numbers to get the perfect block-break range for you. Set all to 0 to stop dinos from breaking blocks entirely.")
                .define("<<GRIEF CONFIG HELPER>> - Look here ^ for help!", 6666);

        //Large Dinos - How many blocks should they break?
        BIG_DINO_BREAK_WIDTH = BUILDER.comment("What should the width be that Large Deadly Dinos can destroy when attacking? 5 Blocks is Default.")
                .define("Large Dino destroy width", 5);
        BIG_DINO_BREAK_HEIGHT = BUILDER.comment("What should the height be that Large Deadly Dinos can destroy when attacking? 5 Blocks is Default.")
                .define("Large Dino destroy height", 5);
        BIG_DINO_BREAK_DEPTH = BUILDER.comment("What should the depth be that Large Deadly Dinos can destroy when attacking? 5 Blocks is Default.")
                .define("Large Dino destroy depth", 5);

        //Small Dinos - How many blocks should they break?
        SMALL_DINO_BREAK_WIDTH = BUILDER.comment("What should the width be that Small Deadly Dinos can destroy when attacking? 3 Blocks is Default.")
                .define("Small Dino destroy width", 3);
        SMALL_DINO_BREAK_HEIGHT = BUILDER.comment("What should the height be that Small Deadly Dinos can destroy when attacking? 3 Blocks is Default.")
                .define("Small Dino destroy height", 3);
        SMALL_DINO_BREAK_DEPTH = BUILDER.comment("What should the depth be that Small Deadly Dinos can destroy when attacking? 3 Blocks is Default.")
                .define("Small Dino destroy depth", 3);


        SPAWNCONFIGHELPER = BUILDER.comment("Dino spawn configs have 1 integer: Weight. You can play with this number to get the perfect spawn rate for you. Set it to 0 to stop a certain dino from spawning entirely.")
                .define("<<SPAWN CONFIG HELPER>> - Look here ^ for help!", 6666);


        ACRO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 5.")
                .define("ACRO Spawn Weight", 5);

        ALBERTO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("ALBERTO Spawn Weight", 3);

        ALLO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("ALLO Spawn Weight", 3);

        ANDAL_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 5.")
                .define("ANDAL Spawn Weight", 5);

        AMARGA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("AMARGA Spawn Weight", 2);

        AMPELO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("AMPELO Spawn Weight", 1);

        ANKY_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("ANKY Spawn Weight", 2);

        ARCHAE_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 4.")
                .define("ARCHAE Spawn Weight", 4);

        AUSTRO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("AUSTRO Spawn Weight", 3);

        AVA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("AVA Spawn Weight", 2);

        CARCHAR_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 4.")
                .define("CARCHAR Spawn Weight", 4);

        CARNO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 5.")
                .define("CARNO Spawn Weight", 5);

        CERATO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 6.")
                .define("CERATO Spawn Weight", 6);

        COMPY_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("COMPY Spawn Weight", 3);

        CROPSNAIL_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 6.")
                .define("CROPSNAIL Spawn Weight", 6);

        DEINOCH_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("DEINOCH Spawn Weight", 2);

        DEINON_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("DEINON Spawn Weight", 3);

        DILO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("DILO Spawn Weight", 3);

        GALLI_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("GALLI Spawn Weight", 2);

        GIGA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 5.")
                .define("GIGA Spawn Weight", 5);

        GRYPO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("GRYPO Spawn Weight", 2);

        MAHAKALA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 8.")
                .define("MAHAKALA Spawn Weight", 8);

        MAJUNGA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 5.")
                .define("MAJUNGA Spawn Weight", 5);

        PARA_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("PARA Spawn Weight", 3);

        REX_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 5.")
                .define("REX Spawn Weight", 5);

        SAURO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 1.")
                .define("SAURO Spawn Weight", 1);

        SHANT_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("SHANT Spawn Weight", 3);

        SPINO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("SPINO Spawn Weight", 3);

        STEGO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 4.")
                .define("STEGO Spawn Weight", 4);

        TARBO_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("TARBO Spawn Weight", 2);

        THERI_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 2.")
                .define("THERI Spawn Weight", 2);

        TROODON_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 3.")
                .define("TROODON Spawn Weight", 3);

        UTAH_WEIGHT = BUILDER.comment("How often should this dino spawn? Default is 5.")
                .define("UTAH Spawn Weight", 5);



        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
