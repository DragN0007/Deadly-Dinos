package com.dragn0007.deadlydinos.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.AustroEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AustroModel extends AnimatedGeoModel<AustroEntity> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/austromale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/austrofemale.png"));

        public final ResourceLocation resourceLocation;

        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/austro.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/austro.animation.json");



    @Override
    public ResourceLocation getModelLocation(AustroEntity object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(AustroEntity object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AustroEntity animatable) {
        return animation;
    }
}
