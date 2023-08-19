package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.AmargaEntity;
import com.dragn0007.deadlydinos.model.AmargaModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AmargaRender extends GeoEntityRenderer<AmargaEntity> {
    public AmargaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AmargaModel());
    }
}
