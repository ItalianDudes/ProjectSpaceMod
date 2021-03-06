package com.italiandudes.projectspace.tileEntity;

import com.italiandudes.projectspace.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import java.util.Objects;

public class DebugQuarryTileEntity extends TileEntity implements ITickableTileEntity {
    public DebugQuarryTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public DebugQuarryTileEntity() {
        this(ModTileEntityTypes.DEBUG_QUARRY_TILE_ENTITY_TYPE.get());
    }

    //This method will run every single time the world ticks!
    @Override
    public void tick() {
        if (Blocks.BEDROCK.defaultBlockState() != Objects.requireNonNull(this.level).getBlockState(this.worldPosition.below())) {
            this.level.setBlock(this.worldPosition.below(), Blocks.AIR.defaultBlockState(), 1);
        }
    }
}
