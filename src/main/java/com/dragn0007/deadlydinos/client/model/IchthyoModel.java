package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.marine.Heli;
import com.dragn0007.deadlydinos.entity.marine.Ichthyo;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IchthyoModel extends AnimatedGeoModel<Ichthyo> {
    
    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ichthyomale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ichthyofemale.png")),
        GRAPE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ichthyogrape.png"));
        
        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/ichthyo.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/ichthyo.animation.json");



    @Override
    public ResourceLocation getModelLocation(Ichthyo object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Ichthyo object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Ichthyo animatable) {
        return animation;
    }
}
