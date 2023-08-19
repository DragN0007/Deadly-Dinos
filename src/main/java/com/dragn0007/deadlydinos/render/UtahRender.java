package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.UtahEntity;
import com.dragn0007.deadlydinos.model.UtahModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class UtahRender extends GeoEntityRenderer<UtahEntity> {
    public UtahRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new UtahModel());
    }
}
