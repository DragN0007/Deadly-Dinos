package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.TheriEntity;
import com.dragn0007.deadlydinos.model.TheriModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TheriRender extends GeoEntityRenderer<TheriEntity> {
    public TheriRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TheriModel());
    }
}
