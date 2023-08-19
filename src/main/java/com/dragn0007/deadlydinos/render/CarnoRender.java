package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.CarnoEntity;
import com.dragn0007.deadlydinos.model.CarnoModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CarnoRender extends GeoEntityRenderer<CarnoEntity> {
    public CarnoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CarnoModel());
    }
}
