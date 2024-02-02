package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Majunga;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MajungaModel extends AnimatedGeoModel<Majunga> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/majungamale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/majungafemale.png")),
        SPECIAL(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/majungaspecial.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/majunga.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/majunga.animation.json");



    @Override
    public ResourceLocation getModelLocation(Majunga object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Majunga object) {return object.getTextureLocation();}

    @Override
    public ResourceLocation getAnimationFileLocation(Majunga animatable) {
        return animation;
    }
}
