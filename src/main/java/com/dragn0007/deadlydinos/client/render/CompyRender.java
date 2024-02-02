package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.CompyModel;
import com.dragn0007.deadlydinos.entity.carni.Compy;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CompyRender extends GeoEntityRenderer<Compy> {
    public CompyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CompyModel());
    }
}
