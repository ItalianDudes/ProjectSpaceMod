package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.tileEntity.DisplayCaseTileEntity;
import com.italiandudes.projectspace.tileEntity.QuarryTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//This class lists all the TileEntityTypes in the mod.
public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister
            .create(ForgeRegistries.TILE_ENTITIES, ProjectSpace.MOD_ID);

    //Here tileEntities are registered.
    public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
            .register("quarry", () -> TileEntityType.Builder.of(QuarryTileEntity::new, ModBlocks.QUARRY.get()).build(null));
    public static final RegistryObject<TileEntityType<DisplayCaseTileEntity>> DISPLAY_CASE_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE
            .register("display_case", () -> TileEntityType.Builder.of(DisplayCaseTileEntity::new, ModBlocks.DISPLAY_CASE.get()).build(null));
}
