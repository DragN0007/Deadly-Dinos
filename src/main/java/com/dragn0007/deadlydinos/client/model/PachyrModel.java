package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Cryo;
import com.dragn0007.deadlydinos.entity.herbi.Pachyr;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PachyrModel extends AnimatedGeoModel<Pachyr> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/pachyrmale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/pachyrfemale.png")),
        SNOWY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/pachyrsnowy.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/pachyr.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/pachyr.animation.json");


    @Override
    public ResourceLocation getModelLocation(Pachyr object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Pachyr object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Pachyr animatable) {
        return animation;
    }
}
