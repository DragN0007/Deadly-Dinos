package com.dragn0007.deadlydinos.client.model;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entity.carni.Mahakala;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ParrotModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.GeoModelProvider;

public class MahakalaModel extends AnimatedGeoModel<Mahakala> {

    public enum Variant {
        MALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/mahakalamale.png")),
        FEMALE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/mahakalafemale.png")),
        SPECIAL(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/mahakalaspecial.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) {
            return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation model = new ResourceLocation(DeadlyDinos.MODID, "geo/mahakala.geo.json");
    public static final ResourceLocation babyModel = new ResourceLocation(DeadlyDinos.MODID, "geo/baby_mahakala.geo.json");
    public static final ResourceLocation animation = new ResourceLocation(DeadlyDinos.MODID, "animations/mahakala.animation.json");



    @Override
    public ResourceLocation getModelLocation(Mahakala object) {
        if(object.isBaby())
            return babyModel;
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(Mahakala object) {
        if(object.isBaby())
            return (new ResourceLocation(DeadlyDinos.MODID, "textures/entity/mahakalafemale.png"));
        return object.getTextureLocation();
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Mahakala animatable) {
        return animation;
    }


}
