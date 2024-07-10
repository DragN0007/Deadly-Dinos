package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Dilo;
import com.dragn0007.deadlydinos.entity.carni.Eocarchar;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EocarcharModel extends AnimatedGeoModel<Eocarchar> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/eocarcharmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/eocarcharfemale.png")),
        WARM(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/eocarcharwarm.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/eocarchar.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/eocarchar.animation.json");



    @Override
    public ResourceLocation getModelLocation(Eocarchar object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Eocarchar object) {return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Eocarchar animatable) {
        return animation;
    }
}
