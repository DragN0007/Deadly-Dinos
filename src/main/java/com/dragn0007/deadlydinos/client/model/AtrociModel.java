package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Atroci;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AtrociModel extends AnimatedGeoModel<Atroci> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/atrocimale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/atrocifemale.png")),
        BRICK (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/atrocibrick.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/atroci.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/atroci.animation.json");

    @Override
    public ResourceLocation getModelLocation(Atroci object) {
        return model;
    }
    @Override
    public ResourceLocation getTextureLocation(Atroci object) {
        return object.getTextureLocation();
    }
    @Override
    public ResourceLocation getAnimationFileLocation(Atroci animatable) {
        return animation;
    }
}
