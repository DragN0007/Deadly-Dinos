package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.AmargaModel;
import com.dragn0007.deadlydinos.entity.herbi.Amarga;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AmargaRender extends GeoEntityRenderer<Amarga> {
    public AmargaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AmargaModel());
    }
}
