package com.dragn0007.deadlydinos.item.util;

import com.dragn0007.deadlydinos.item.DDDItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class DDDItemGroup {

    public static final CreativeModeTab DDD_GROUP = new CreativeModeTab("dddModTab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DDDItems.DDDENTITIES.get());
        }
    };

    public static final CreativeModeTab DINO_GROUP = new CreativeModeTab("dinoModTab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DDDItems.DDDBLOCKS.get());
        }
    };

    public static final CreativeModeTab FOOD_GROUP = new CreativeModeTab("foodModTab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DDDItems.DDDITEMS.get());
        }
    };

    public static final CreativeModeTab BLOCK_GROUP = new CreativeModeTab("blockModTab")
    {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DDDItems.DDDFOOD.get());
        }
    };
}
