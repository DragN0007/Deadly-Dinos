package com.dragn0007.deadlydinos.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.AlbertoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AlbertoModel extends AnimatedGeoModel<AlbertoEntity> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/albertomale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/albertofemale.png"));

        public final ResourceLocation resourceLocation;

        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) {
            return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/alberto.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/alberto.animation.json");


    @Override
    public ResourceLocation getModelLocation(AlbertoEntity object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(AlbertoEntity object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AlbertoEntity animatable) {
        return animation;
    }
}
