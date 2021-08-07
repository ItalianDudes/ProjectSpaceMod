package com.italiandudes.projectspace.blocks.ores;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CopperOre extends OreBlock {
    public CopperOre() {
        super(AbstractBlock.Properties.of(Material.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE)
                .strength(3.0f,4.0f)
                .requiresCorrectToolForDrops());
    }
}
