package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.marine.Heli;
import com.dragn0007.deadlydinos.entity.marine.Leed;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LeedModel extends AnimatedGeoModel<Leed> {
    
    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/leedmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/leedfemale.png")),
        WHITE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/leedwhite.png"));
        
        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/leed.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/leed.animation.json");



    @Override
    public ResourceLocation getModelLocation(Leed object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Leed object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Leed animatable) {
        return animation;
    }
}
