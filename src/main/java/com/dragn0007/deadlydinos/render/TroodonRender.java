package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.TroodonEntity;
import com.dragn0007.deadlydinos.model.TroodonModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TroodonRender extends GeoEntityRenderer<TroodonEntity> {
    public TroodonRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TroodonModel());
    }
}
