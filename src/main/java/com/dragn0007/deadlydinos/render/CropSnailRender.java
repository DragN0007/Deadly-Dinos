package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.CropSnailEntity;
import com.dragn0007.deadlydinos.model.CropSnailModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CropSnailRender extends GeoEntityRenderer<CropSnailEntity> {
    public CropSnailRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CropSnailModel());
    }
}
