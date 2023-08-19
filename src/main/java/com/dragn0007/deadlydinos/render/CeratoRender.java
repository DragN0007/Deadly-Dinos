package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.CeratoEntity;
import com.dragn0007.deadlydinos.model.CeratoModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CeratoRender extends GeoEntityRenderer<CeratoEntity> {
    public CeratoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CeratoModel());
    }
}

