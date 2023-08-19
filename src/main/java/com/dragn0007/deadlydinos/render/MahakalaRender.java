package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.MahakalaEntity;
import com.dragn0007.deadlydinos.model.MahakalaModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MahakalaRender extends GeoEntityRenderer<MahakalaEntity> {
    public MahakalaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MahakalaModel());
    }
}
