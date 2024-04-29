package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.herbi.Grypo;
import com.dragn0007.deadlydinos.entity.herbi.Para;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GrypoModel extends AnimatedGeoModel<Grypo> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/grypomale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/grypofemale.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/grypo.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/grypo.animation.json");



    @Override
    public ResourceLocation getModelLocation(Grypo object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Grypo object) {return object.getTextureLocation();}

    @Override
    public ResourceLocation getAnimationFileLocation(Grypo animatable) {
        return animation;
    }
}
