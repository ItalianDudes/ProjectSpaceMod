package com.italiandudes.projectspace.blocks.blockItemBases;

import com.italiandudes.projectspace.ProjectSpace;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BauxiteBase extends BlockItem {
    //Can this item be analized inside the analizers?
    final boolean canBeAnalized = true;

    public BauxiteBase(Block block) {
        super(block, new Item.Properties().tab(ProjectSpace.RESOURCES_TAB));
    }

    boolean getCanBeAnalized(){
        return canBeAnalized;
    }
}
