package com.italiandudes.projectspace.blocks.blockItemBases;

import com.italiandudes.projectspace.ProjectSpace;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class OreBase extends BlockItem {
    public OreBase(Block block) {
        super(block, new Item.Properties().tab(ProjectSpace.RESOURCES_TAB));
    }
}
