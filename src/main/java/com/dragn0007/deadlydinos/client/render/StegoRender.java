package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.StegoModel;
import com.dragn0007.deadlydinos.entity.herbi.Stego;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class StegoRender extends GeoEntityRenderer<Stego> {
    public StegoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new StegoModel());
    }
}
