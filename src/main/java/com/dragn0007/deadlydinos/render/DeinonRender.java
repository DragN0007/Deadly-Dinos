package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.DeinonEntity;
import com.dragn0007.deadlydinos.model.DeinonModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DeinonRender extends GeoEntityRenderer<DeinonEntity> {
    public DeinonRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeinonModel());
    }
}
