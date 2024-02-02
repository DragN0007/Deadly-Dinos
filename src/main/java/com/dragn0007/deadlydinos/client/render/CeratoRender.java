package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.CeratoModel;
import com.dragn0007.deadlydinos.entity.carni.Cerato;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CeratoRender extends GeoEntityRenderer<Cerato> {
    public CeratoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CeratoModel());
    }
}

