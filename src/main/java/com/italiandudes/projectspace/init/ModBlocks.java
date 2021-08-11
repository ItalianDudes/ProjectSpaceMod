package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.blocks.DisplayCaseBlock;
import com.italiandudes.projectspace.blocks.QuarryBlock;
import com.italiandudes.projectspace.blocks.ores.*;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//Organize the blocks.
public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectSpace.MOD_ID);

    //Under here are listed all the blocks.
    public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry", QuarryBlock::new);
    public static final RegistryObject<Block> DISPLAY_CASE = BLOCKS.register("display_case", DisplayCaseBlock::new);
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", CopperOre::new);
    public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore", LeadOre::new);
    public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", TinOre::new);
    public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore", UraniumOre::new);
    public static final RegistryObject<Block> BAUXITE_ORE = BLOCKS.register("bauxite_ore", BauxiteOre::new);

    //Under here are listed all the fluid's blocks.
    public static final RegistryObject<FlowingFluidBlock> DEBUG_BLOCK = BLOCKS.register("debug_fluid",
            () -> new FlowingFluidBlock(ModFluids.DEBUG_FLUID, Block.Properties.of(Material.WATER).instabreak().noDrops().strength(100.0f)));
}
