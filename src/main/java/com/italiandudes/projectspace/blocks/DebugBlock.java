package com.italiandudes.projectspace.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DebugBlock extends Block {

    public DebugBlock() {
        super(AbstractBlock.Properties.of(Material.METAL).noCollission());
    }
}