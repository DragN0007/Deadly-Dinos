package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.AvaEntity;
import com.dragn0007.deadlydinos.model.AvaModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AvaRender extends GeoEntityRenderer<AvaEntity> {
    public AvaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AvaModel());
    }
}
