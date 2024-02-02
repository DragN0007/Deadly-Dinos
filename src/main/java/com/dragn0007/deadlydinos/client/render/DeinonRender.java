package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.DeinonModel;
import com.dragn0007.deadlydinos.entity.carni.Deinon;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DeinonRender extends GeoEntityRenderer<Deinon> {
    public DeinonRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeinonModel());
    }
}
