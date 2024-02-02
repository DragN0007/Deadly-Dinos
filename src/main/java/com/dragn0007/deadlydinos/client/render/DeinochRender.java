package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.DeinochModel;
import com.dragn0007.deadlydinos.entity.herbi.Deinoch;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DeinochRender extends GeoEntityRenderer<Deinoch> {
    public DeinochRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeinochModel());
    }
}
