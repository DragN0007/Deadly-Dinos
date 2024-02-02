package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.ParaModel;
import com.dragn0007.deadlydinos.entity.herbi.Para;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ParaRender extends GeoEntityRenderer<Para> {
    public ParaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ParaModel());
    }
}
