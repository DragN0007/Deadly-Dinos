package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Acro;
import com.dragn0007.deadlydinos.entity.marine.Mosa;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MosaModel extends AnimatedGeoModel<Mosa> {
    
    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/mosamale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/mosafemale.png")),
        PURPLE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/mosapurple.png"));
        
        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/mosa.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/mosa.animation.json");



    @Override
    public ResourceLocation getModelLocation(Mosa object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Mosa object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Mosa animatable) {
        return animation;
    }
}