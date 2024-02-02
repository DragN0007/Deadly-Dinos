package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.CarSideModel;
import com.dragn0007.deadlydinos.entity.nonliving.CarSide;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CarSideRender extends GeoEntityRenderer<CarSide> {
    public CarSideRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CarSideModel());
    }
}
