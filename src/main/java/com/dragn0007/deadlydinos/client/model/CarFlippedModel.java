package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.nonliving.CarFlipped;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CarFlippedModel extends AnimatedGeoModel<CarFlipped> {

    public enum Variant {
        GREY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/carg.png")),
        GREYD(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/cargdamaged.png")),

        BLACK(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/card.png")),
        BLACKD(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/carddamaged.png")),

        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/carb.png")),
        BLUED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/carbdamaged.png")),

        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/carr.png")),
        REDD(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/carrdamaged.png"));

        public final ResourceLocation resourceLocation;

        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) {
            return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/carflipped.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "");


    @Override
    public ResourceLocation getModelLocation(CarFlipped object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(CarFlipped object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CarFlipped animatable) {
        return animation;
    }
}
