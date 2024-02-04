package com.dragn0007.deadlydinos.client.render.NightEyesLayer;

import com.dragn0007.deadlydinos.client.model.UtahModel;
import com.dragn0007.deadlydinos.entity.carni.Utah;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EndermanModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LightLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

//@OnlyIn(Dist.CLIENT)
//public class UtahNightEyes<T extends LivingEntity> extends EyesLayer<T, UtahModel<T>> {
//    private static final RenderType UTAH_NIGHT_EYES = RenderType.eyes(new ResourceLocation("textures/entity/night_eyes/utah_night_eyes.png"));
//
//    public UtahNightEyes(RenderLayerParent<T, UtahModel<T>> layerParent) {
//        super(layerParent);
//    }
//
//
//    public RenderType renderType() {
//        return UTAH_NIGHT_EYES;
//    }
//
//}
