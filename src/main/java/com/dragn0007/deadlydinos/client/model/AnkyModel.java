package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.herbi.Anky;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnkyModel extends AnimatedGeoModel<Anky> {
    
    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ankymale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ankyfemale.png")),
        FOREST(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ankyforest.png"));
        
        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/anky.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/anky.animation.json");



    @Override
    public ResourceLocation getModelLocation(Anky object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Anky object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Anky animatable) {
        return animation;
    }
}
