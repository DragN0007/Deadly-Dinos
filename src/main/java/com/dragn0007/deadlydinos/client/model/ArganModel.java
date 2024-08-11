package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.marine.Argan;
import com.dragn0007.deadlydinos.entity.marine.Hyneria;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArganModel extends AnimatedGeoModel<Argan> {
    
    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/arganmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/arganfemale.png")),
        MUD(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/arganmud.png"));
        
        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/argan.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/argan.animation.json");



    @Override
    public ResourceLocation getModelLocation(Argan object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Argan object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Argan animatable) {
        return animation;
    }
}
