package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Andal;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AndalModel extends AnimatedGeoModel<Andal> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/andalmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/andalfemale.png")),
        BLACK (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/andalblack.png")),
        BLUE (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/andalblue.png")),
        GREEN (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/andalgreen.png")),
        RED (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/andalred.png")),
        WHITE (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/andalwhite.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/andal.geo.json");
    public static final ResourceLocation babyModel = new ResourceLocation(DeadlyDinos.MODID, "geo/baby_andal.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/andal.animation.json");



    @Override
    public ResourceLocation getModelLocation(Andal object) {
        if(object.isBaby())
            return babyModel;
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Andal object) {
        if(object.isBaby())
            return (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/andalfemale.png"));
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Andal animatable) {
        return animation;
    }
}
