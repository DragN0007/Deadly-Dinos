package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.GalliModel;
import com.dragn0007.deadlydinos.entity.herbi.Galli;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GalliRender extends GeoEntityRenderer<Galli> {
    public GalliRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GalliModel());
    }
}
