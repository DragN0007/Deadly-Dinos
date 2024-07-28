package com.dragn0007.deadlydinos.client.render;

import com.dragn0007.deadlydinos.client.model.HeliModel;
import com.dragn0007.deadlydinos.client.model.IchthyoModel;
import com.dragn0007.deadlydinos.entity.marine.Heli;
import com.dragn0007.deadlydinos.entity.marine.Ichthyo;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class IchthyoRender extends GeoEntityRenderer<Ichthyo> {
    public IchthyoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IchthyoModel());
    }
}
