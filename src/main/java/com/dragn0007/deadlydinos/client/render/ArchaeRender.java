package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.ArchaeModel;
import com.dragn0007.deadlydinos.entity.carni.Archae;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ArchaeRender extends GeoEntityRenderer<Archae> {
    public ArchaeRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ArchaeModel());
    }
}
