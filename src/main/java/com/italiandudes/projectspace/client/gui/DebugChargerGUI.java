package com.italiandudes.projectspace.client.gui;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.container.DebugChargerContainers;
import com.italiandudes.projectspace.container.DebugDisplayCaseContainers;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.util.Objects;

public class DebugChargerGUI extends ContainerScreen<DebugChargerContainers> {

    private static final ResourceLocation DEBUG_CHARGER_GUI = new ResourceLocation(ProjectSpace.MOD_ID,"textures/gui/debug_charger.png");

    public DebugChargerGUI(DebugChargerContainers screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);

        this.leftPos = 0;
        this.topPos = 0;
        //Texture dimensions
        this.width = 176;
        this.height = 166;
    }

    //This method glues everything together.
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    //This method renders the actual GUI.
    @SuppressWarnings("deprecation")
    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.color4f(1f,1f,1f,1f); //This is a completely white color.
        Objects.requireNonNull(this.minecraft).textureManager.bind(DEBUG_CHARGER_GUI);
        int x = (this.width - this.getXSize())/2;
        int y = (this.height - this.getYSize())/2;
        this.blit(matrixStack,x,y,0,0,this.getXSize(),this.getYSize());
    }
}
