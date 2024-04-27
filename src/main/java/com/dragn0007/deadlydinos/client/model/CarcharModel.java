package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Carchar;
import com.dragn0007.deadlydinos.entity.carni.Giga;
import com.dragn0007.deadlydinos.entity.nonliving.Car;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CarcharModel extends AnimatedGeoModel<Carchar> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/carcharmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/carcharfemale.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/carchar.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/carchar.animation.json");



    @Override
    public ResourceLocation getModelLocation(Carchar object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Carchar object) {return object.getTextureLocation();}

    @Override
    public ResourceLocation getAnimationFileLocation(Carchar animatable) {
        return animation;
    }
}
