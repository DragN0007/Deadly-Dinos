package com.dragn0007.deadlydinos.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.CarSideEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CarSideModel extends AnimatedGeoModel<CarSideEntity> {

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

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/carside.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "");


    @Override
    public ResourceLocation getModelLocation(CarSideEntity object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(CarSideEntity object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CarSideEntity animatable) {
        return animation;
    }
}


