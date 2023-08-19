package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.SpinoEntity;
import com.dragn0007.deadlydinos.model.SpinoModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SpinoRender extends GeoEntityRenderer<SpinoEntity> {
    public SpinoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SpinoModel());
    }
}
