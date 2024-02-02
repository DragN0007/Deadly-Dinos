package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.AvaModel;
import com.dragn0007.deadlydinos.entity.herbi.Ava;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AvaRender extends GeoEntityRenderer<Ava> {
    public AvaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AvaModel());
    }
}
