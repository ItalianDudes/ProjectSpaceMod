package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.blocks.QuarryBlock;
import net.minecraft.block.AbstractBlock;
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
    public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry", () -> new QuarryBlock());

    //Under here are listed all the fluid's blocks.
    public static final RegistryObject<FlowingFluidBlock> OXYGEN_BLOCK = BLOCKS.register("oxygen",
            () -> new FlowingFluidBlock(ModFluids.OXYGEN_FLUID, Block.Properties.of(Material.WATER).instabreak().noDrops()));
}
