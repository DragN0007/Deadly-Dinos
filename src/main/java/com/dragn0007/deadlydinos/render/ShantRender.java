package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.ShantEntity;
import com.dragn0007.deadlydinos.model.ShantModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ShantRender extends GeoEntityRenderer<ShantEntity> {
    public ShantRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShantModel());
    }
}
