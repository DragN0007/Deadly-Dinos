package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.CarEntity;
import com.dragn0007.deadlydinos.model.CarModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CarRender extends GeoEntityRenderer<CarEntity> {
    public CarRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CarModel());
    }
}
