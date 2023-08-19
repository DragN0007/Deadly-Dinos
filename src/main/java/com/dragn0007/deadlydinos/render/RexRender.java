package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.RexEntity;
import com.dragn0007.deadlydinos.model.RexModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RexRender extends GeoEntityRenderer<RexEntity> {
    public RexRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RexModel());
    }
}
