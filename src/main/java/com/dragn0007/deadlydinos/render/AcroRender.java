package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.AcroEntity;
import com.dragn0007.deadlydinos.model.AcroModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AcroRender extends GeoEntityRenderer<AcroEntity> {
    public AcroRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AcroModel());
    }
}
