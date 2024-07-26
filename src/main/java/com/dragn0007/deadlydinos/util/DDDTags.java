package com.dragn0007.deadlydinos.util;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DDDTags {

    public static class Items {
        public static final TagKey<Item> RAW_MEATS = forgeTag("raw_meats");
        public static final TagKey<Item> COOKED_MEATS = forgeTag("cooked_meats");

        public static final TagKey<Item> RAW_CHICKEN = forgeTag("raw_chicken");

        public static final TagKey<Item> RAW_DINO_MEATS = forgeTag("raw_dino_meats");
        public static final TagKey<Item> COOKED_DINO_MEATS = forgeTag("cooked_dino_meats");

        public static final TagKey<Item> MEATS = forgeTag("meats");
        public static final TagKey<Item> VEGETABLES = forgeTag("vegetables");
        public static final TagKey<Item> FISH = forgeTag("fish");

        public static final TagKey<Item> BONES = forgeTag("bones");
        public static final TagKey<Item> DOUGH = forgeTag("dough");


        public static final TagKey<Item> SEMI_AQUATIC_FOOD = tag("semi_aquatic_food");
        public static final TagKey<Item> HERBI_FOOD = tag("herbi_food");

        public static final TagKey<Item> LARGE_BONES = tag("large_bones");
        public static final TagKey<Item> MEDIUM_BONES = tag("medium_bones");
        public static final TagKey<Item> SMALL_BONES = tag("small_bones");

        public static final TagKey<Item> BEDROLL_BEDS = forgeTag("bedroll_beds");



        private static TagKey<Item> tag (String name) {
            return ItemTags.create(new ResourceLocation(DeadlyDinos.MODID, name));
        }
        private static TagKey<Item> forgeTag (String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }


        public static class Blocks {
            public static final TagKey<Block> DESERT_DINO_SPAWNABLE_ON = tag("desert_dino_spawnable_on");



            private static TagKey<Block> tag (String name) {
                return BlockTags.create(new ResourceLocation(DeadlyDinos.MODID, name));
            }
            private static TagKey<Block> forgeTag (String name) {
                return BlockTags.create(new ResourceLocation("forge", name));
        }
    }


}
