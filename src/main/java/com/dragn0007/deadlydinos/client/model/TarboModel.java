package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Tarbo;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TarboModel extends AnimatedGeoModel<Tarbo> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/tarbomale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/tarbofemale.png")),
        NIGHT(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/tarbonight.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/tarbo.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/tarbo.animation.json");



    @Override
    public ResourceLocation getModelLocation(Tarbo object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Tarbo object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Tarbo animatable) {
        return animation;
    }
}
