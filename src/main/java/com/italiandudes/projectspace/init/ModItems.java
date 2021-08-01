package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.blocks.BlockItemBase;
import com.italiandudes.projectspace.items.DebugBattery;
import net.minecraft.item.BucketItem;
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

    //Under here are listed all the fluid buckets.
    public static final RegistryObject<BucketItem> OXYGEN_BUCKET = ITEMS.register("oxygen_bucket",
            () -> new BucketItem(() -> ModFluids.OXYGEN_FLUID.get(), new Item.Properties().tab(ProjectSpace.TAB).stacksTo(1)));
}
