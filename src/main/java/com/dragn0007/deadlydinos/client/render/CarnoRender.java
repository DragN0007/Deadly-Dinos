package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.CarnoModel;
import com.dragn0007.deadlydinos.entity.carni.Carno;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CarnoRender extends GeoEntityRenderer<Carno> {
    public CarnoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CarnoModel());
    }
}
