package com.dragn0007.deadlydinos.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.ParaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ParaModel extends AnimatedGeoModel<ParaEntity> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/paramale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parafemale.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/para.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/para.animation.json");



    @Override
    public ResourceLocation getModelLocation(ParaEntity object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(ParaEntity object) {return object.getTextureLocation();}

    @Override
    public ResourceLocation getAnimationFileLocation(ParaEntity animatable) {
        return animation;
    }
}
