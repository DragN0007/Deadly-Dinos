package com.dragn0007.deadlydinos.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {

    public static final CreativeModeTab DDD_GROUP = new CreativeModeTab("dddModTab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DDDENTITIES.get());
        }
    };

    public static final CreativeModeTab DINO_GROUP = new CreativeModeTab("dinoModTab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DDDBLOCKS.get());
        }
    };

    public static final CreativeModeTab FOOD_GROUP = new CreativeModeTab("foodModTab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DDDITEMS.get());
        }
    };

    public static final CreativeModeTab BLOCK_GROUP = new CreativeModeTab("blockModTab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DDDFOOD.get());
        }
    };
}
