package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.EdmontoModel;
import com.dragn0007.deadlydinos.entity.herbi.Edmonto;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EdmontoRender extends GeoEntityRenderer<Edmonto> {
    public EdmontoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EdmontoModel());
    }
}
