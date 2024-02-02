package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.CropSnailModel;
import com.dragn0007.deadlydinos.entity.herbi.CropSnail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CropSnailRender extends GeoEntityRenderer<CropSnail> {
    public CropSnailRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CropSnailModel());
    }
}
