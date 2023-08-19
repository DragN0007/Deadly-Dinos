package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.CompyEntity;
import com.dragn0007.deadlydinos.model.CompyModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CompyRender extends GeoEntityRenderer<CompyEntity> {
    public CompyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CompyModel());
    }
}
