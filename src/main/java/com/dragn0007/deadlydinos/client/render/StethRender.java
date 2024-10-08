package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.StethModel;
import com.dragn0007.deadlydinos.entity.marine.Steth;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class StethRender extends GeoEntityRenderer<Steth> {
    public StethRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new StethModel());
    }
}
