package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.herbi.Igua;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IguaModel extends AnimatedGeoModel<Igua> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/iguamale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/iguafemale.png")),
        PERIDOT(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/iguagold.png")),
        BEE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/iguabee.png")), //Texture funded by BumbleBeez32
        FOX(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/iguafox.png")); //Texture funded by Foxx

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/igua.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/igua.animation.json");



    @Override
    public ResourceLocation getModelLocation(Igua object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Igua object) {return object.getTextureLocation();}

    @Override
    public ResourceLocation getAnimationFileLocation(Igua animatable) {
        return animation;
    }
}
