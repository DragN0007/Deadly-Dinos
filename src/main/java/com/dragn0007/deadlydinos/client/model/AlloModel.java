package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Allo;
import com.dragn0007.deadlydinos.entity.carni.Cerato;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AlloModel extends AnimatedGeoModel<Allo> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/allomale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/allofemale.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/allo.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/allo.animation.json");

    public static final ResourceLocation white_banner = new ResourceLocation(DeadlyDinos.MODID, "textures/entity/banner/dino_banner_white.png");
    public static final ResourceLocation black_banner = new ResourceLocation(DeadlyDinos.MODID, "textures/entity/banner/dino_banner_black.png");



    @Override
    public ResourceLocation getModelLocation(Allo object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Allo object) {return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Allo animatable) {
        return animation;
    }
}
