package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.GigaEntity;
import com.dragn0007.deadlydinos.model.GigaModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GigaRender extends GeoEntityRenderer<GigaEntity> {
    public GigaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GigaModel());
    }
}
