package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Cerato;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CeratoModel extends AnimatedGeoModel<Cerato> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ceratomale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ceratofemale.png")),
        SPECIAL(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ceratospecial.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/cerato.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/cerato.animation.json");



    @Override
    public ResourceLocation getModelLocation(Cerato object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Cerato object) {return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Cerato animatable) {
        return animation;
    }
}
