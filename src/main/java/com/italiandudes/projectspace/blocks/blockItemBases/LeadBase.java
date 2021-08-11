package com.italiandudes.projectspace.blocks.blockItemBases;

import com.italiandudes.projectspace.ProjectSpace;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class LeadBase extends BlockItem {
    //Can this item be analized inside the analizers?
    final boolean canBeAnalized = true;

    public LeadBase(Block block ) {
        super(block, new Item.Properties().tab(ProjectSpace.RESOURCES_TAB));
    }

    boolean getCanBeAnalized(){
        return canBeAnalized;
    }
}
