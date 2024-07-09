package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.CompyModel;
import com.dragn0007.deadlydinos.client.model.MegarapModel;
import com.dragn0007.deadlydinos.entity.carni.Compy;
import com.dragn0007.deadlydinos.entity.carni.Megarap;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MegarapRender extends GeoEntityRenderer<Megarap> {
    public MegarapRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MegarapModel());
    }
}
