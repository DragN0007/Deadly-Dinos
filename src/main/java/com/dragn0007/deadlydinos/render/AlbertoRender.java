package com.dragn0007.deadlydinos.render;

import com.dragn0007.deadlydinos.entity.AlbertoEntity;
import com.dragn0007.deadlydinos.model.AlbertoModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AlbertoRender extends GeoEntityRenderer<AlbertoEntity> {
    public AlbertoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AlbertoModel());
    }
}
