package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Ichthy;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IchthyModel extends AnimatedGeoModel<Ichthy> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ichthymale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ichthyfemale.png")),
        BLACK(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ichthyblack.png")),
        PALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ichthypale.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/ichthy.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/ichthy.animation.json");



    @Override
    public ResourceLocation getModelLocation(Ichthy object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Ichthy object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Ichthy animatable) {
        return animation;
    }
}
