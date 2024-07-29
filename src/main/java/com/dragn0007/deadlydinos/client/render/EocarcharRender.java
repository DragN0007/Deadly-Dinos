package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.EocarcharModel;
import com.dragn0007.deadlydinos.entity.carni.Eocarchar;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.ExtendedGeoEntityRenderer;

public class EocarcharRender extends ExtendedGeoEntityRenderer<Eocarchar> {
    public EocarcharRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EocarcharModel());
    }

    @Override
    public void render(GeoModel model, Eocarchar animatable, float partialTick, RenderType type, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if(animatable.isSaddled()) {
            model.getBone("Saddle").ifPresent(b -> b.setHidden(false));
            model.getBone("Saddle3").ifPresent(b -> b.setHidden(false));
            model.getBone("Saddle5").ifPresent(b -> b.setHidden(false));
            model.getBone("UnderSaddleSpikes").ifPresent(b -> b.setHidden(true));
        } else {
            model.getBone("Saddle").ifPresent(b -> b.setHidden(true));
            model.getBone("Saddle3").ifPresent(b -> b.setHidden(true));
            model.getBone("Saddle5").ifPresent(b -> b.setHidden(true));
            model.getBone("UnderSaddleSpikes").ifPresent(b -> b.setHidden(false));
        }

        if(animatable.isChested()) {
            model.getBone("Harness").ifPresent(b -> b.setHidden(false));
            model.getBone("Harness2").ifPresent(b -> b.setHidden(false));
        } else {
            model.getBone("Harness").ifPresent(b -> b.setHidden(true));
            model.getBone("Harness2").ifPresent(b -> b.setHidden(true));
        }

        if(animatable.isArmored()) {
            model.getBone("Armor").ifPresent(b -> b.setHidden(false));
            model.getBone("Armor2").ifPresent(b -> b.setHidden(false));
            model.getBone("Armor3").ifPresent(b -> b.setHidden(false));
            model.getBone("Armor4").ifPresent(b -> b.setHidden(false));
            model.getBone("UnderSaddleSpikes").ifPresent(b -> b.setHidden(true));
        } else {
            model.getBone("Armor").ifPresent(b -> b.setHidden(true));
            model.getBone("Armor2").ifPresent(b -> b.setHidden(true));
            model.getBone("Armor3").ifPresent(b -> b.setHidden(true));
            model.getBone("Armor4").ifPresent(b -> b.setHidden(true));
            model.getBone("UnderSaddleSpikes").ifPresent(b -> b.setHidden(false));
        }

        if(animatable.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }

        super.render(model, animatable, partialTick, type, poseStack, bufferSource, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    protected boolean isArmorBone(GeoBone bone) {
        return false;
    }

    @Nullable
    @Override
    protected ResourceLocation getTextureForBone(String boneName, Eocarchar animatable) {
        return null;
    }

    @Nullable
    @Override
    protected ItemStack getHeldItemForBone(String boneName, Eocarchar animatable) {
        return null;
    }

    @Override
    protected ItemTransforms.TransformType getCameraTransformForItemAtBone(ItemStack stack, String boneName) {
        return null;
    }

    @Nullable
    @Override
    protected BlockState getHeldBlockForBone(String boneName, Eocarchar animatable) {
        return null;
    }

    @Override
    protected void preRenderItem(PoseStack poseStack, ItemStack stack, String boneName, Eocarchar animatable, IBone bone) {

    }

    @Override
    protected void preRenderBlock(PoseStack poseStack, BlockState state, String boneName, Eocarchar animatable) {

    }

    @Override
    protected void postRenderItem(PoseStack poseStack, ItemStack stack, String boneName, Eocarchar animatable, IBone bone) {

    }

    @Override
    protected void postRenderBlock(PoseStack poseStack, BlockState state, String boneName, Eocarchar animatable) {

    }
}
