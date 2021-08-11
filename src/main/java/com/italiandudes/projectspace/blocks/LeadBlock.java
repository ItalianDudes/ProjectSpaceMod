package com.italiandudes.projectspace.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LeadBlock extends Block {
    public LeadBlock() {
        super(AbstractBlock.Properties.of(Material.METAL)
                .harvestLevel(2)
                .strength(15f));
    }
}
