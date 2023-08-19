package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.AustroEntity;
import com.dragn0007.deadlydinos.model.AustroModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AustroRender extends GeoEntityRenderer<AustroEntity> {
    public AustroRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AustroModel());
    }
}
