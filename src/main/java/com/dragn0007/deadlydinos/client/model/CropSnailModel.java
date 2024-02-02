package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.herbi.CropSnail;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CropSnailModel extends AnimatedGeoModel<CropSnail> {

    public enum Variant {
        BROWN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/cropsnailbrown.png")),
        DARKBROWN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/cropsnaildarkbrown.png")),
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/cropsnailred.png")),
        GOLD(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/cropsnailgold.png")),
        WHITE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/cropsnailwhite.png"));

        public final ResourceLocation resourceLocation;

        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/cropsnail.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "");



    @Override
    public ResourceLocation getModelLocation(CropSnail object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(CropSnail object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CropSnail animatable) {
        return animation;
    }
}
