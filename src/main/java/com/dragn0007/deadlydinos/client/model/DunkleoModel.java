package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Acro;
import com.dragn0007.deadlydinos.entity.marine.Dunkleo;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DunkleoModel extends AnimatedGeoModel<Dunkleo> {
    
    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/dunkleomale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/dunkleofemale.png")),
        SANDY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/dunkleosandy.png"));
        
        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/dunkleo.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/dunkleo.animation.json");



    @Override
    public ResourceLocation getModelLocation(Dunkleo object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Dunkleo object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Dunkleo animatable) {
        return animation;
    }
}
