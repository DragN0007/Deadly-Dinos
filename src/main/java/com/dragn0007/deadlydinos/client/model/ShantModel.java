package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.herbi.Shant;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShantModel extends AnimatedGeoModel<Shant> {
    
    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/shantmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/shantfemale.png")),
        ROYAL(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/shantroyal.png"));
        
        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/shant.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/shant.animation.json");



    @Override
    public ResourceLocation getModelLocation(Shant object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Shant object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Shant animatable) {
        return animation;
    }
}
