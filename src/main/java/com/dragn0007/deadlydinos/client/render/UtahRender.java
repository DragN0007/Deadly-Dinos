package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.UtahModel;
import com.dragn0007.deadlydinos.entity.carni.Utah;
import net.minecraft.client.model.EndermanModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.EnderEyesLayer;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class UtahRender extends GeoEntityRenderer<Utah> {
    public UtahRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new UtahModel());
//        super(renderManager, new UtahModel<>(renderManager.bakeLayer(UtahModel.nightEyes)), 0.5F);
//        this.addLayer(new UtahNightEyes<>(this));
    }
}
