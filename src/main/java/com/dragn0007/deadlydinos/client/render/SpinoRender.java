package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.SpinoModel;
import com.dragn0007.deadlydinos.entity.carni.Spino;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SpinoRender extends GeoEntityRenderer<Spino> {
    public SpinoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SpinoModel());
    }
}
