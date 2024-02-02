package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.CarModel;
import com.dragn0007.deadlydinos.entity.nonliving.Car;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CarRender extends GeoEntityRenderer<Car> {
    public CarRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CarModel());
    }
}
