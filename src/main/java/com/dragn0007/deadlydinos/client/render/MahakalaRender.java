package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.MahakalaModel;
import com.dragn0007.deadlydinos.entity.carni.Mahakala;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MahakalaRender extends GeoEntityRenderer<Mahakala> {
    public MahakalaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MahakalaModel());
    }
}
