package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.EocarcharModel;
import com.dragn0007.deadlydinos.client.model.MegarapModel;
import com.dragn0007.deadlydinos.entity.carni.Eocarchar;
import com.dragn0007.deadlydinos.entity.carni.Megarap;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EocarcharRender extends GeoEntityRenderer<Eocarchar> {
    public EocarcharRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EocarcharModel());
    }
}
