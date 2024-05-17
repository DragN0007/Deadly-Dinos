package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.PachyrModel;
import com.dragn0007.deadlydinos.entity.herbi.Pachyr;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PachyrRender extends GeoEntityRenderer<Pachyr> {
    public PachyrRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PachyrModel());
    }
}
