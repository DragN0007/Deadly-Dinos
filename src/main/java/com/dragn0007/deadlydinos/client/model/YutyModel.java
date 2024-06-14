package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Yuty;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class YutyModel extends AnimatedGeoModel<Yuty> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/yutymale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/yutyfemale.png")),
        ICY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/yutyicy.png")),
        CHOCOLATE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/yutychocolate.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/yuty.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/yuty.animation.json");



    @Override
    public ResourceLocation getModelLocation(Yuty object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Yuty object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Yuty animatable) {
        return animation;
    }
}
