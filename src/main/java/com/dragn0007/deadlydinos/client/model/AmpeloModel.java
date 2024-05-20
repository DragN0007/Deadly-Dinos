package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.herbi.Amarga;
import com.dragn0007.deadlydinos.entity.herbi.Ampelo;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AmpeloModel extends AnimatedGeoModel<Ampelo> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ampelomale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ampelofemale.png")),
        LAVENDER(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ampelolavender.png")),
        GREY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ampelogrey.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/ampelo.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/ampelo.animation.json");



    public static final ResourceLocation baby_model = new ResourceLocation(DeadlyDinos.MODID, "geo/baby_ampelo.geo.json");
    @Override
    public ResourceLocation getModelLocation(Ampelo object) {
        if(object.isBaby())
            return baby_model;
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Ampelo object) {
        if(object.isBaby())
            return (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/ampelobaby.png"));
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Ampelo animatable) {
        if(animatable.isBaby())
            return (new ResourceLocation(DeadlyDinos.MODID, "animations/baby_ampelo.animation.json"));
        return animation;
    }
}
