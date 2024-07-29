package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Bary;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BaryModel extends AnimatedGeoModel<Bary> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/barymale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/baryfemale.png")),
        STORM(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/barystorm.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/bary.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/bary.animation.json");



    @Override
    public ResourceLocation getModelLocation(Bary object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Bary object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Bary animatable) {
        return animation;
    }
}
