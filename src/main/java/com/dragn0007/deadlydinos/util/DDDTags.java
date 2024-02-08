package com.dragn0007.deadlydinos.util;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class DDDTags {

    public static class Items {
        public static final TagKey<Item> RAW_MEATS = forgeTag("raw_meats");
        public static final TagKey<Item> COOKED_MEATS = forgeTag("cooked_meats");

        public static final TagKey<Item> RAW_CHICKEN = forgeTag("raw_chicken");

        public static final TagKey<Item> RAW_DINO_MEATS = forgeTag("raw_dino_meats");
        public static final TagKey<Item> COOKED_DINO_MEATS = forgeTag("cooked_dino_meats");

        public static final TagKey<Item> MEATS = forgeTag("meats");
        public static final TagKey<Item> VEGETABLES = forgeTag("vegetables");

        public static final TagKey<Item> BONES = forgeTag("bones");
        public static final TagKey<Item> DOUGH = forgeTag("dough");


        private static TagKey<Item> tag (String name) {
            return ItemTags.create(new ResourceLocation(DeadlyDinos.MODID, name));
        }
        private static TagKey<Item> forgeTag (String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

}
