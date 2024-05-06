package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.herbi.Ava;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AvaModel extends AnimatedGeoModel<Ava> {
    
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
    public static final ResourceLocation babyModel = new ResourceLocation(DeadlyDinos.MODID, "geo/baby_ava.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/ava.animation.json");



    @Override
    public ResourceLocation getModelLocation(Ava object) {
        if(object.isBaby())
            return babyModel;
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Ava object) {
        if(object.isBaby())
            return (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/avafemale.png"));
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Ava animatable) {
        if(animatable.isBaby())
            return (new ResourceLocation(DeadlyDinos.MODID, "animations/baby_ava.animation.json"));
        return animation;
    }
}
