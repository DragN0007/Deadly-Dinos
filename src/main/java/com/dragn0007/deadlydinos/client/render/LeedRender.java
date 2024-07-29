package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.HeliModel;
import com.dragn0007.deadlydinos.client.model.LeedModel;
import com.dragn0007.deadlydinos.entity.marine.Heli;
import com.dragn0007.deadlydinos.entity.marine.Leed;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class LeedRender extends GeoEntityRenderer<Leed> {
    public LeedRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LeedModel());
    }
}
