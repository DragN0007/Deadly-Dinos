package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.DiloModel;
import com.dragn0007.deadlydinos.entity.carni.Dilo;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DiloRender extends GeoEntityRenderer<Dilo> {
    public DiloRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DiloModel());
    }
}
