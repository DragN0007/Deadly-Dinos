package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.marine.Meg;
import com.dragn0007.deadlydinos.entity.marine.Meg;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MegModel extends AnimatedGeoModel<Meg> {
    
    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/megmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/megfemale.png")),
        NAVY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/megnavy.png")),
        BATTERED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/megbattered.png"));
        
        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/meg.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/meg.animation.json");



    @Override
    public ResourceLocation getModelLocation(Meg object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Meg object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Meg animatable) {
        return animation;
    }
}
