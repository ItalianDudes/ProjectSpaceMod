package com.italiandudes.projectspace.blocks;

import com.italiandudes.projectspace.init.ModTileEntityTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class QuarryBlock extends Block {
    public QuarryBlock() {
        super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(15f)
                .sound(SoundType.METAL));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.QUARRY_TILE_ENTITY_TYPE.get().create();
    }
}
