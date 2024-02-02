package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.AcroModel;
import com.dragn0007.deadlydinos.entity.carni.Acro;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AcroRender extends GeoEntityRenderer<Acro> {
    public AcroRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AcroModel());
    }
}
