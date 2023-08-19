package com.dragn0007.deadlydinos.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.SauroEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SauroModel extends AnimatedGeoModel<SauroEntity> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/sauromale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/saurofemale.png")),
        SPECIAL(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/saurospecial.png"));

        public final ResourceLocation resourceLocation;

        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) {
            return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/sauro.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/sauro.animation.json");


    @Override
    public ResourceLocation getModelLocation(SauroEntity object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(SauroEntity object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SauroEntity animatable) {
        return animation;
    }
}
