package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Cryo;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CryoModel extends AnimatedGeoModel<Cryo> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/cryomale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/cryofemale.png")),
        ICY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/cryoicy.png")),
        LIME(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/cryolime.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/cryo.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/cryo.animation.json");


    @Override
    public ResourceLocation getModelLocation(Cryo object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Cryo object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Cryo animatable) {
        return animation;
    }
}
