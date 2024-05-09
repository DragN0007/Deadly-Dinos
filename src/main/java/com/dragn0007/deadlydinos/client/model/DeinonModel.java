package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Deinon;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DeinonModel extends AnimatedGeoModel<Deinon> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/deinonmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/deinonfemale.png")),
        PEARL(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/deinonpearl.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/deinon.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/deinon.animation.json");



    @Override
    public ResourceLocation getModelLocation(Deinon object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Deinon object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Deinon animatable) {
        return animation;
    }
}
