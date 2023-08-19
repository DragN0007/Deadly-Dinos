package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.TarboEntity;
import com.dragn0007.deadlydinos.model.TarboModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TarboRender extends GeoEntityRenderer<TarboEntity> {
    public TarboRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TarboModel());
    }
}
