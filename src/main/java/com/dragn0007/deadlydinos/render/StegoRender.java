package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.StegoEntity;
import com.dragn0007.deadlydinos.model.StegoModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class StegoRender extends GeoEntityRenderer<StegoEntity> {
    public StegoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new StegoModel());
    }
}
