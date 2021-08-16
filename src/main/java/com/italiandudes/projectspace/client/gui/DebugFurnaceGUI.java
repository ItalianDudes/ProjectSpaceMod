package com.italiandudes.projectspace.client.gui;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.container.DebugFurnaceContainers;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;

@OnlyIn(Dist.CLIENT)
public class DebugFurnaceGUI extends ContainerScreen<DebugFurnaceContainers> {

    private static final ResourceLocation DEBUG_FURNACE_GUI = new ResourceLocation(ProjectSpace.MOD_ID, "textures/gui/debug_furnace.png");

    public DebugFurnaceGUI(DebugFurnaceContainers screenContainer, PlayerInventory inventory, ITextComponent titleIn) {
        super(screenContainer, inventory, titleIn);
    }

    //This method glues everything together.
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack,mouseX,mouseY);
    }

    //This method renders the words rendered on the GUI.
    @Override
    protected void renderTooltip(MatrixStack matrixStack, int x, int y) {
        this.font.draw(matrixStack,this.inventory.getDisplayName(),(float) this.inventoryLabelX, (float) this.inventoryLabelY,
                4210752);
    }

    //This method renders the actual GUI.
    @SuppressWarnings("deprecation")
    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.color4f(1f,1f,1f,1f);
        Objects.requireNonNull(this.minecraft).textureManager.bind(DEBUG_FURNACE_GUI);
        int x = (this.width - this.getXSize())/2;
        int y = (this.height - this.getYSize())/2;
        this.blit(matrixStack,x,y,0,0,this.getXSize(),this.getYSize());
    }
}
