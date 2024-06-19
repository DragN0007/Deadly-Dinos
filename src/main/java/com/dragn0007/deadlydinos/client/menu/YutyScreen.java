package com.dragn0007.deadlydinos.client.menu;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class YutyScreen extends AbstractContainerScreen<YutyMenu> {

    private static final ResourceLocation SADDLED = new ResourceLocation(DeadlyDinos.MODID, "textures/gui/yuty_empty_gui.png");
    private static final ResourceLocation CHESTED = new ResourceLocation(DeadlyDinos.MODID, "textures/gui/yuty_gui.png");


    private final ResourceLocation texture;

    public YutyScreen(YutyMenu paraMenu, Inventory inventory, Component component) {
        super(paraMenu, inventory, component);
        this.texture = paraMenu.yuty.isChested() ? CHESTED : SADDLED;
        this.imageWidth = 175;
        this.imageHeight = 221;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTick);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, this.texture);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }
}
