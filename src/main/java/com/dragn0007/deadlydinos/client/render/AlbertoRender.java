package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.AlbertoModel;
import com.dragn0007.deadlydinos.entity.carni.Alberto;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AlbertoRender extends GeoEntityRenderer<Alberto> {
    public AlbertoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AlbertoModel());
    }
}
