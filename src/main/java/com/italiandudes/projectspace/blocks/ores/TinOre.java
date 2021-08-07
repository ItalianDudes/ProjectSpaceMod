package com.italiandudes.projectspace.blocks.ores;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class TinOre extends OreBlock {
    public TinOre() {
        super(AbstractBlock.Properties.of(Material.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .strength(3.0f,4.0f)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops());
    }
}
