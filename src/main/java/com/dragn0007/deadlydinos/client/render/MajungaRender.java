package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.MajungaModel;
import com.dragn0007.deadlydinos.entity.carni.Majunga;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MajungaRender extends GeoEntityRenderer<Majunga> {
    public MajungaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MajungaModel());
    }
}
