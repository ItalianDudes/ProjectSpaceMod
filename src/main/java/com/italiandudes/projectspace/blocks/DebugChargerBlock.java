package com.italiandudes.projectspace.blocks;

import com.italiandudes.projectspace.tileEntity.DebugChargerTileEntity;
import com.italiandudes.projectspace.tileEntity.DebugDisplayCaseTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class DebugChargerBlock extends Block {
    public DebugChargerBlock() {
        super(AbstractBlock.Properties.of(Material.METAL)
                .sound(SoundType.METAL));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return super.createTileEntity(state, world);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                                Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isClientSide()){
            TileEntity te = worldIn.getBlockEntity(pos);
            if (te instanceof DebugChargerTileEntity){
                NetworkHooks.openGui( (ServerPlayerEntity) player,(DebugChargerTileEntity) te, pos);
            }
        }
        return super.use(state, worldIn, pos, player, handIn, hit);
    }
}
