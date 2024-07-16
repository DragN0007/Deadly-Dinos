package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Acro;
import com.dragn0007.deadlydinos.entity.marine.Gar;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GarModel extends AnimatedGeoModel<Gar> {
    
    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/garmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/garfemale.png")),
        GREEN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/gargreen.png"));
        
        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/gar.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/gar.animation.json");



    @Override
    public ResourceLocation getModelLocation(Gar object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Gar object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Gar animatable) {
        return animation;
    }
}
