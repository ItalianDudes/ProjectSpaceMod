package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.blocks.*;
import com.italiandudes.projectspace.blocks.energyContainers.DebugChargerBlock;
import com.italiandudes.projectspace.blocks.ores.*;
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
    public static final RegistryObject<Block> DEBUG_QUARRY = BLOCKS.register("debug_quarry", DebugQuarryBlock::new);
    public static final RegistryObject<Block> DEBUG_DISPLAY_CASE = BLOCKS.register("debug_display_case", DebugDisplayCaseBlock::new);
    public static final RegistryObject<Block> DEBUG_CHARGER = BLOCKS.register("debug_charger", DebugChargerBlock::new);
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", CopperOre::new);
    public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore", LeadOre::new);
    public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", TinOre::new);
    public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore", UraniumOre::new);
    public static final RegistryObject<Block> BAUXITE_ORE = BLOCKS.register("bauxite_ore", BauxiteOre::new);
    public static final RegistryObject<Block> ALUMINIUM_BLOCK = BLOCKS.register("aluminium_block", AluminiumBlock::new);
    public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", CopperBlock::new);
    public static final RegistryObject<Block> LEAD_BLOCK = BLOCKS.register("lead_block", LeadBlock::new);
    public static final RegistryObject<Block> TIN_BLOCK = BLOCKS.register("tin_block", TinBlock::new);
    public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", UraniumBlock::new);
    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", SteelBlock::new);

    //Under here are listed all the fluid's blocks.
    public static final RegistryObject<FlowingFluidBlock> DEBUG_BLOCK = BLOCKS.register("debug_fluid",
            () -> new FlowingFluidBlock(() -> ModFluids.DEBUG_FLUID.get(), AbstractBlock.Properties.of(Material.WATER).noCollission()
                    .strength(100f).noDrops()));

    //Under here are listed all the 3D's models.
    public static final RegistryObject<Block> DEBUG_BLOCK_MODEL = BLOCKS.register("debug_model", DebugBlock::new);

}
