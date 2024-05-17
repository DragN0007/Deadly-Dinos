package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.AustraloModel;
import com.dragn0007.deadlydinos.entity.carni.Australo;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AustraloRender extends GeoEntityRenderer<Australo> {
    public AustraloRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AustraloModel());
    }
}
