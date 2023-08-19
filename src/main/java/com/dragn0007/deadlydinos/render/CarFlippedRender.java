package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.CarFlippedEntity;
import com.dragn0007.deadlydinos.model.CarFlippedModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CarFlippedRender extends GeoEntityRenderer<CarFlippedEntity> {
    public CarFlippedRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CarFlippedModel());
    }
}
