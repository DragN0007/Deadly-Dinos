package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.DunkleoModel;
import com.dragn0007.deadlydinos.entity.marine.Dunkleo;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DunkleoRender extends GeoEntityRenderer<Dunkleo> {
    public DunkleoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DunkleoModel());
    }
}
