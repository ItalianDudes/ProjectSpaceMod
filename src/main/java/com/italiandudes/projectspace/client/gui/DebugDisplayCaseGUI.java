package com.italiandudes.projectspace.client.gui;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.container.DebugDisplayCaseContainers;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;

//This class manages and sets up the DisplayCaseTileEntity's GUI.
@OnlyIn(Dist.CLIENT)
public class DebugDisplayCaseGUI extends ContainerScreen<DebugDisplayCaseContainers> {

    private static final ResourceLocation DEBUG_DISPLAY_CASE_GUI = new ResourceLocation(ProjectSpace.MOD_ID,"textures/gui/debug_display_case.png");

    public DebugDisplayCaseGUI(DebugDisplayCaseContainers screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);

        this.leftPos = 0;
        this.topPos = 0;
        //Texture dimensions
        this.width = 175;
        this.height = 201;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack,mouseX,mouseY);
    }

    @Override
    protected void renderTooltip(MatrixStack matrixStack, int x, int y) {
        this.font.draw(matrixStack,this.inventory.getDisplayName(),(float) this.inventoryLabelX, (float) this.inventoryLabelY,
                4210752);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.color4f(1f,1f,1f,1f);
        Objects.requireNonNull(this.minecraft).textureManager.bind(DEBUG_DISPLAY_CASE_GUI);
        int x = (this.width - this.height)/2;
        int y = (this.height - this.width)/2;
        this.blit(matrixStack,x,y,0,0,this.width,this.height);
    }
}
