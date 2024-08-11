package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.ArganModel;
import com.dragn0007.deadlydinos.entity.marine.Argan;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ArganRender extends GeoEntityRenderer<Argan> {
    public ArganRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ArganModel());
    }
}
