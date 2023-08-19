package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.ParaEntity;
import com.dragn0007.deadlydinos.model.ParaModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ParaRender extends GeoEntityRenderer<ParaEntity> {
    public ParaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ParaModel());
    }
}
