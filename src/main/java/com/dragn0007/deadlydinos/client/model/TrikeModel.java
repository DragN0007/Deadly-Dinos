package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.herbi.Trike;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TrikeModel extends AnimatedGeoModel<Trike> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/trikemale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/trikefemale.png")),
        LIME(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/trikelime.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/trike.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/trike.animation.json");



    @Override
    public ResourceLocation getModelLocation(Trike object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Trike object) {
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Trike animatable) {
        return animation;
    }
}
