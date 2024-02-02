package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.RexModel;
import com.dragn0007.deadlydinos.entity.carni.Rex;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RexRender extends GeoEntityRenderer<Rex> {
    public RexRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RexModel());
    }
}
