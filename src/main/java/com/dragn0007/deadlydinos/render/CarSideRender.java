package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.CarSideEntity;
import com.dragn0007.deadlydinos.model.CarSideModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CarSideRender extends GeoEntityRenderer<CarSideEntity> {
    public CarSideRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CarSideModel());
    }
}
