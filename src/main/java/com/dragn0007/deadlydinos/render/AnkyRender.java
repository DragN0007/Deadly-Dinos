package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.AnkyEntity;
import com.dragn0007.deadlydinos.model.AnkyModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AnkyRender extends GeoEntityRenderer<AnkyEntity> {
    public AnkyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnkyModel());
    }
}
