package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.SauroEntity;
import com.dragn0007.deadlydinos.model.SauroModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SauroRender extends GeoEntityRenderer<SauroEntity> {
    public SauroRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SauroModel());
    }
}
