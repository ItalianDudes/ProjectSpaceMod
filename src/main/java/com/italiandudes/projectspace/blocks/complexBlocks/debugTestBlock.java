package com.italiandudes.projectspace.blocks.complexBlocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class debugTestBlock extends Block {

    public debugTestBlock() {
        super(AbstractBlock.Properties.of(Material.METAL)
                .sound(SoundType.METAL));
    }

}