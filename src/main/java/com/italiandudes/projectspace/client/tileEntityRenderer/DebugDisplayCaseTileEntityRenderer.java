package com.italiandudes.projectspace.client.tileEntityRenderer;

import com.italiandudes.projectspace.tileEntity.DebugDisplayCaseTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

import java.util.Objects;

public class DebugDisplayCaseTileEntityRenderer extends TileEntityRenderer<DebugDisplayCaseTileEntity> {

    private Minecraft mc = Minecraft.getInstance();

    public DebugDisplayCaseTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(DebugDisplayCaseTileEntity caseTileEntity, float partialTicks, MatrixStack matrixStack,
                       IRenderTypeBuffer buffer, int combinedLightIn, int combinedOverlayIn) {
        if (caseTileEntity.getItem().equals(ItemStack.EMPTY) || caseTileEntity.getItem().equals(Items.AIR)){
            return;
        }

        ClientPlayerEntity player = mc.player;
        int lightLevel=getLightLevel(Objects.requireNonNull(caseTileEntity.getLevel()),caseTileEntity.getBlockPos().above());
        renderItem(caseTileEntity.getItem(),new double[] {0.5d,1d,0.5d},
                Vector3f.YP.rotationDegrees(180f - player.yRot),matrixStack, buffer, partialTicks,
                combinedOverlayIn,lightLevel,0.8f);

        ITextComponent label = caseTileEntity.getItem().hasCustomHoverName() ? caseTileEntity.getItem().getDisplayName() : new TranslationTextComponent(caseTileEntity.getItem().getDescriptionId());

        renderLabel(matrixStack,buffer,lightLevel,new double[] {.5d,1.3d,.5d}, label,0xffffff);
    }

    //This method renders the item that is contained inside the tile Entity.
    private void renderItem(ItemStack stack, double[] translation, Quaternion rotation, MatrixStack matrixStack, IRenderTypeBuffer buffer,
                            float partialTicks, int combinedOverlay, int lightLevel, float scale){
        matrixStack.pushPose();
        matrixStack.translate(translation[0],translation[1],translation[2]);
        matrixStack.mulPose(rotation);
        matrixStack.scale(scale,scale,scale);
        //Item's model inside the TileEntity.
        IBakedModel model = mc.getItemRenderer().getModel(stack,null,null);
        mc.getItemRenderer().render(stack, ItemCameraTransforms.TransformType.GROUND,true,matrixStack,buffer,
                lightLevel,combinedOverlay,model);
        matrixStack.popPose();
    }

    //This method renders the label that appears above the rendered item contained inside the tile Entity.
    private void renderLabel(MatrixStack stack, IRenderTypeBuffer buffer, int lightLevel, double[] corner, ITextComponent text,
                             int color){

        FontRenderer font = mc.font;

        stack.pushPose();
        float scale = 0.01f;
        int opacity = (int) (.4*255.0f) << 24;
        float offset = (float) (-font.width(text)/2);
        Matrix4f matrix = stack.last().pose();

        stack.translate(corner[0],corner[1] + .4f,corner[2]);
        stack.scale(scale,scale,scale);
        stack.mulPose(mc.getEntityRenderDispatcher().cameraOrientation());
        stack.mulPose(Vector3f.ZP.rotationDegrees(180f));

        font.drawInBatch(text,offset,0,color,false,matrix,buffer,false,opacity,lightLevel);
        stack.popPose();
    }

    @SuppressWarnings("deprecation")
    private int getLightLevel(World world, BlockPos pos){
        int blockLight=world.getBrightness(LightType.BLOCK, pos);
        int skyLight=world.getBrightness(LightType.SKY,pos);

        return LightTexture.pack(blockLight,skyLight);
    }
}
