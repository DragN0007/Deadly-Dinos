package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.HeliModel;
import com.dragn0007.deadlydinos.entity.marine.Heli;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HeliRender extends GeoEntityRenderer<Heli> {
    public HeliRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HeliModel());
    }
}
