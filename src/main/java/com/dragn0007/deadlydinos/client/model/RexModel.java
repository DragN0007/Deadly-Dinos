package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Rex;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RexModel extends AnimatedGeoModel<Rex> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/rexmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/rexfemale.png")),
        CORAL(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/rexcoral.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/rex.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/rex.animation.json");



    @Override
    public ResourceLocation getModelLocation(Rex object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Rex object) {return object.getTextureLocation();}

    @Override
    public ResourceLocation getAnimationFileLocation(Rex animatable) {
        return animation;
    }
}
