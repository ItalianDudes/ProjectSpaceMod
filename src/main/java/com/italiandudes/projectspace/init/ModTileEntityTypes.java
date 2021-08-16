package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.blocks.DebugQuarryBlock;
import com.italiandudes.projectspace.tileEntity.DebugDisplayCaseTileEntity;
import com.italiandudes.projectspace.tileEntity.DebugFurnaceTileEntity;
import com.italiandudes.projectspace.tileEntity.DebugQuarryTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//This class lists all the TileEntityTypes in the mod.
public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister
            .create(ForgeRegistries.TILE_ENTITIES, ProjectSpace.MOD_ID);

    //Here tileEntities are registered.
    public static final RegistryObject<TileEntityType<DebugQuarryTileEntity>> DEBUG_QUARRY_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
            .register("debug_quarry", ()-> TileEntityType.Builder.of(DebugQuarryTileEntity::new, ModBlocks.DEBUG_QUARRY.get()).build(null));
    public static final RegistryObject<TileEntityType<DebugDisplayCaseTileEntity>> DEBUG_DISPLAY_CASE_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
            .register("debug_display_case", () -> TileEntityType.Builder.of(DebugDisplayCaseTileEntity::new, ModBlocks.DEBUG_DISPLAY_CASE.get()).build(null));
    public static final RegistryObject<TileEntityType<DebugFurnaceTileEntity>> DEBUG_FURNACE_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
            .register("debug_furnace", ()-> TileEntityType.Builder.of(DebugFurnaceTileEntity::new, ModBlocks.DEBUG_FURNACE.get()).build(null));
}
