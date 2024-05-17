package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.CryoModel;
import com.dragn0007.deadlydinos.entity.carni.Cryo;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CryoRender extends GeoEntityRenderer<Cryo> {
    public CryoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CryoModel());
    }
}
