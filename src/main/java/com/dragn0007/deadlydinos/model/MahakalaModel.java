package com.dragn0007.deadlydinos.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.MahakalaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MahakalaModel extends AnimatedGeoModel<MahakalaEntity> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/mahakalamale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/mahakalafemale.png")),
        SPECIAL(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/mahakalaspecial.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) {
            return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/mahakala.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/mahakala.animation.json");



    @Override
    public ResourceLocation getModelLocation(MahakalaEntity object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(MahakalaEntity object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MahakalaEntity animatable) {
        return animation;
    }
}
