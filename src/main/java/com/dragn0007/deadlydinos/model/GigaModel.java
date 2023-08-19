package com.dragn0007.deadlydinos.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.GigaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GigaModel extends AnimatedGeoModel<GigaEntity> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/gigamale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/gigafemale.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/giga.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/giga.animation.json");



    @Override
    public ResourceLocation getModelLocation(GigaEntity object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(GigaEntity object) {return object.getTextureLocation();}

    @Override
    public ResourceLocation getAnimationFileLocation(GigaEntity animatable) {
        return animation;
    }
}
