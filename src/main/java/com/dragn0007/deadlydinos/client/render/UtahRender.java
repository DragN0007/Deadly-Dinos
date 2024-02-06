package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.UtahModel;
import com.dragn0007.deadlydinos.entity.carni.Utah;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class UtahRender extends GeoEntityRenderer<Utah> {
    public UtahRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new UtahModel());
    }
}
