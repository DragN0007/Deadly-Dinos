package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.AnkyModel;
import com.dragn0007.deadlydinos.entity.herbi.Anky;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AnkyRender extends GeoEntityRenderer<Anky> {
    public AnkyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnkyModel());
    }
}
