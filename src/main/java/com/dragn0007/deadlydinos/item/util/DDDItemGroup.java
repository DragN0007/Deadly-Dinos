package com.dragn0007.deadlydinos.item.util;

import com.dragn0007.deadlydinos.item.DDDItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class DDDItemGroup {

    public static final CreativeModeTab DDD_GROUP = new CreativeModeTab("dddmodtab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DDDItems.DDDENTITIES.get());
        }
    };

    public static final CreativeModeTab DINO_GROUP = new CreativeModeTab("dinomodtab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DDDItems.DDDBLOCKS.get());
        }
    };

    public static final CreativeModeTab FOOD_GROUP = new CreativeModeTab("foodmodtab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DDDItems.DDDITEMS.get());
        }
    };

    public static final CreativeModeTab BLOCK_GROUP = new CreativeModeTab("blockmodtab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DDDItems.DDDFOOD.get());
        }
    };
}
