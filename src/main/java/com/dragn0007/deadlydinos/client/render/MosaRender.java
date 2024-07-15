package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.MosaModel;
import com.dragn0007.deadlydinos.entity.marine.Mosa;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MosaRender extends GeoEntityRenderer<Mosa> {
    public MosaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MosaModel());
    }
}
