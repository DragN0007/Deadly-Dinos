package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.SauroModel;
import com.dragn0007.deadlydinos.entity.herbi.Sauro;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SauroRender extends GeoEntityRenderer<Sauro> {
    public SauroRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SauroModel());
    }
}
