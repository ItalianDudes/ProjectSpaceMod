package com.italiandudes.projectspace.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class UraniumBlock extends Block {
    public UraniumBlock() {
        super(AbstractBlock.Properties.of(Material.METAL)
                .harvestLevel(2)
                .strength(15f));
    }
}
