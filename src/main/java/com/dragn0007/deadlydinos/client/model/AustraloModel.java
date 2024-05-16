package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Australo;
import com.dragn0007.deadlydinos.entity.carni.Cryo;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AustraloModel extends AnimatedGeoModel<Australo> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/australomale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/australofemale.png")),
        COLD(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/australocold.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/australo.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/australo.animation.json");


    @Override
    public ResourceLocation getModelLocation(Australo object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Australo object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Australo animatable) {
        return animation;
    }
}
