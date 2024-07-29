package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.herbi.Pachy;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PachyModel extends AnimatedGeoModel<Pachy> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/pachymale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/pachyfemale.png")),
        STONE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/pachystone.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/pachy.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/pachy.animation.json");



    @Override
    public ResourceLocation getModelLocation(Pachy object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Pachy object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Pachy animatable) {
        return animation;
    }
}
