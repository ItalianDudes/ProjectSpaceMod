package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.blocks.BlockItemBase;
import com.italiandudes.projectspace.items.DebugBattery;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//Organize the items.
public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectSpace.MOD_ID);

    //Under here are listed all the items.
    public static final RegistryObject<Item> DEBUG_BATTERY = ITEMS.register("debug_battery", DebugBattery::new);

    //Under here are listed all the block items.
    public static final RegistryObject<Item> QUARRY_BLOCK_ITEM = ITEMS.register("quarry", () -> new BlockItemBase(ModBlocks.QUARRY.get()));
}
