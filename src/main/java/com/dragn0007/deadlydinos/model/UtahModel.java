package com.dragn0007.deadlydinos.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.UtahEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class UtahModel extends AnimatedGeoModel<UtahEntity> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahmale.png")),
        MALEGREEN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahmalegreen.png")),
        MALEBLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahmaleblue.png")),
        MALEYELLOW(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahmaleyellow.png")),
        FEMALE1(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahfemale.png")),
        FEMALE2(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahfemale2.png")),
        FEMALE3(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahfemale3.png")),
        MIDNIGHT(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahmidnight.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/utah.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/utah.animation.json");



    @Override
    public ResourceLocation getModelLocation(UtahEntity object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(UtahEntity object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(UtahEntity animatable) {
        return animation;
    }
}
