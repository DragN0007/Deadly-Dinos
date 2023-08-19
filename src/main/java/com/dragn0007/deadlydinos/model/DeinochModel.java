package com.dragn0007.deadlydinos.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.DeinochEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DeinochModel extends AnimatedGeoModel<DeinochEntity> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/deinochmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/deinochfemale.png"));

        public final ResourceLocation resourceLocation;

        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) {
            return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/deinoch.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/deinoch.animation.json");


    @Override
    public ResourceLocation getModelLocation(DeinochEntity object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(DeinochEntity object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DeinochEntity animatable) {
        return animation;
    }
}
