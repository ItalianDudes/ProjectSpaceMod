package com.italiandudes.projectspace.tileEntity;

import com.italiandudes.projectspace.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class QuarryTileEntity extends TileEntity implements ITickableTileEntity {
    public QuarryTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public QuarryTileEntity() {
        this(ModTileEntityTypes.QUARRY_TILE_ENTITY_TYPE.get());
    }

    //This method will run every single time the world ticks!
    @Override
    public void tick() {
        this.worldPosition.;
    }
}
