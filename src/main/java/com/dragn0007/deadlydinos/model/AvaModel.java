package com.dragn0007.deadlydinos.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.AvaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AvaModel extends AnimatedGeoModel<AvaEntity> {
    
    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/avamale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/avafemale.png"));
        
        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/ava.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/ava.animation.json");



    @Override
    public ResourceLocation getModelLocation(AvaEntity object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(AvaEntity object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AvaEntity animatable) {
        return animation;
    }
}
