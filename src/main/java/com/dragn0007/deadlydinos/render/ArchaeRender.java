package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.ArchaeEntity;
import com.dragn0007.deadlydinos.model.ArchaeModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ArchaeRender extends GeoEntityRenderer<ArchaeEntity> {
    public ArchaeRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ArchaeModel());
    }
}
