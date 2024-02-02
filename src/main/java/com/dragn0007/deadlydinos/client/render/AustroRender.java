package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.AustroModel;
import com.dragn0007.deadlydinos.entity.carni.Austro;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AustroRender extends GeoEntityRenderer<Austro> {
    public AustroRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AustroModel());
    }
}
