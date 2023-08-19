package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.MajungaEntity;
import com.dragn0007.deadlydinos.model.MajungaModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MajungaRender extends GeoEntityRenderer<MajungaEntity> {
    public MajungaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MajungaModel());
    }
}
