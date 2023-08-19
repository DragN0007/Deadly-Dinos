package com.dragn0007.deadlydinos.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.ArchaeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArchaeModel extends AnimatedGeoModel<ArchaeEntity> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/archaemale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/archaefemale.png")),
        SPECIAL (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/archaespecial.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/archae.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/archae.animation.json");



    @Override
    public ResourceLocation getModelLocation(ArchaeEntity object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(ArchaeEntity object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ArchaeEntity animatable) {
        return animation;
    }
}
