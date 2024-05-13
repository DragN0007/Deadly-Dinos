package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Allo;
import com.dragn0007.deadlydinos.entity.carni.Dilo;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DiloModel extends AnimatedGeoModel<Dilo> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/dilomale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/dilofemale.png")),
        CHOCOLATE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/dilochocolate.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/dilo.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/dilo.animation.json");



    @Override
    public ResourceLocation getModelLocation(Dilo object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Dilo object) {return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Dilo animatable) {
        return animation;
    }
}
