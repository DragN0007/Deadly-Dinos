package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.DeinochEntity;
import com.dragn0007.deadlydinos.model.DeinochModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DeinochRender extends GeoEntityRenderer<DeinochEntity> {
    public DeinochRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeinochModel());
    }
}
