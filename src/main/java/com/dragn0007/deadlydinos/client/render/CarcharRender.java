package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.CarcharModel;
import com.dragn0007.deadlydinos.entity.carni.Carchar;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CarcharRender extends GeoEntityRenderer<Carchar> {
    public CarcharRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CarcharModel());
    }
}
