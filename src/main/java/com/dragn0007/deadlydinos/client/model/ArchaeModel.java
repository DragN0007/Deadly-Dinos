package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Archae;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArchaeModel extends AnimatedGeoModel<Archae> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/archaemale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/archaefemale.png")),
        SPECIAL (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/archaespecial.png")),
        BLOOD (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/archaeblood.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/archae.geo.json");
    public static final ResourceLocation babyModel = new ResourceLocation(DeadlyDinos.MODID, "geo/baby_archae.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/archae.animation.json");



    @Override
    public ResourceLocation getModelLocation(Archae object) {
        if(object.isBaby())
            return babyModel;
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Archae object) {
        if(object.isBaby())
            return (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/archaefemale.png"));
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Archae animatable) {
        return animation;
    }
}
