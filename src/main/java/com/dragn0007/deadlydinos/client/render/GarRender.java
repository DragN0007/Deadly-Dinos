package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.GarModel;
import com.dragn0007.deadlydinos.entity.marine.Gar;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GarRender extends GeoEntityRenderer<Gar> {
    public GarRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GarModel());
    }
}
