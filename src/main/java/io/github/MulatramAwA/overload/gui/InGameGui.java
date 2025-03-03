package io.github.MulatramAwA.overload.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;

public class InGameGui extends Gui {
    public InGameGui() {
        super(Minecraft.getInstance(),Minecraft.getInstance().getItemRenderer());
    }
    public void redout(float f) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShaderColor(0.1F, f, f, 1.0F);

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, VIGNETTE_LOCATION);
        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuilder();
        bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilder.vertex(0.0D, this.screenHeight, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferBuilder.vertex( this.screenWidth, this.screenHeight, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferBuilder.vertex( this.screenWidth, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferBuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
        tessellator.end();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.defaultBlendFunc();
    }
    public void renderGForce(GuiGraphics guiGraphics,double gForce){
        guiGraphics.drawString(Minecraft.getInstance().font, I18n.get("overload.text",gForce),0,0,0xFF4500);
    }
    public void blackout(float f) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, f);

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, VIGNETTE_LOCATION);
        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuilder();
        bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilder.vertex(0.0D, this.screenHeight, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferBuilder.vertex(this.screenWidth, this.screenHeight, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferBuilder.vertex(this.screenWidth, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferBuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
        tessellator.end();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.defaultBlendFunc();
    }
}
