package com.dragn0007.deadlydinos.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeadlyDinosClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for Deadly Dinos!");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
