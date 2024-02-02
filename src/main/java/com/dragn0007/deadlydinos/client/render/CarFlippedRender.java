package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.CarFlippedModel;
import com.dragn0007.deadlydinos.entity.nonliving.CarFlipped;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CarFlippedRender extends GeoEntityRenderer<CarFlipped> {
    public CarFlippedRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CarFlippedModel());
    }
}
