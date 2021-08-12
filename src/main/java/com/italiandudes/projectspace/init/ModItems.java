package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.blocks.blockItemBases.*;
import com.italiandudes.projectspace.items.CarbonFiber;
import com.italiandudes.projectspace.items.DebugBattery;
import com.italiandudes.projectspace.items.GlassFiber;
import com.italiandudes.projectspace.items.SulfurDust;
import com.italiandudes.projectspace.items.ingots.*;
import com.italiandudes.projectspace.items.nuggets.*;
import com.italiandudes.projectspace.items.piles.*;
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
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", AluminiumIngot::new);
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", CopperIngot::new);
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", LeadIngot::new);
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", SteelIngot::new);
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", TinIngot::new);
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", UraniumIngot::new);
    public static final RegistryObject<Item> ALUMINIUM_NUGGET = ITEMS.register("aluminium_nugget", AluminiumNugget::new);
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", CopperNugget::new);
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", LeadNugget::new);
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", SteelNugget::new);
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget", TinNugget::new);
    public static final RegistryObject<Item> URANIUM_NUGGET = ITEMS.register("uranium_nugget", UraniumNugget::new);
    public static final RegistryObject<Item> ALUMINIUM_PILE = ITEMS.register("aluminium_pile", AluminiumPile::new);
    public static final RegistryObject<Item> COPPER_PILE = ITEMS.register("copper_pile", CopperPile::new);
    public static final RegistryObject<Item> LEAD_PILE = ITEMS.register("lead_pile", LeadPile::new);
    public static final RegistryObject<Item> TIN_PILE = ITEMS.register("tin_pile", TinPile::new);
    public static final RegistryObject<Item> URANIUM_PILE = ITEMS.register("uranium_pile", UraniumPile::new);
    public static final RegistryObject<Item> CARBON_FIBER = ITEMS.register("carbon_fiber", CarbonFiber::new);
    public static final RegistryObject<Item> GLASS_FIBER = ITEMS.register("glass_fiber", GlassFiber::new);
    public static final RegistryObject<Item> SULFUR_DUST = ITEMS.register("sulfur_dust", SulfurDust::new);

    //Under here are listed all the block items.
    public static final RegistryObject<Item> DEBUG_QUARRY_BLOCK_ITEM = ITEMS.register("debug_quarry", () -> new BlockItemBase(ModBlocks.DEBUG_QUARRY.get()));
    public static final RegistryObject<Item> BAUXITE_ORE_ITEM = ITEMS.register("bauxite_ore",()->new BauxiteBase(ModBlocks.BAUXITE_ORE.get()));
    public static final RegistryObject<Item> COPPER_ORE_ITEM = ITEMS.register("copper_ore",()->new CopperBase(ModBlocks.COPPER_ORE.get()));
    public static final RegistryObject<Item> LEAD_ORE_ITEM = ITEMS.register("lead_ore",()->new LeadBase(ModBlocks.LEAD_ORE.get()));
    public static final RegistryObject<Item> TIN_ORE_ITEM = ITEMS.register("tin_ore",()->new TinBase(ModBlocks.TIN_ORE.get()));
    public static final RegistryObject<Item> URANIUM_ORE_ITEM = ITEMS.register("uranium_ore",()->new UraniumBase(ModBlocks.URANIUM_ORE.get()));
    public static final RegistryObject<Item> ALUMINIUM_BLOCK_ITEM = ITEMS.register("aluminium_block",()->new ResourcesItemBase(ModBlocks.ALUMINIUM_BLOCK.get()));
    public static final RegistryObject<Item> COPPER_BLOCK_ITEM = ITEMS.register("copper_block",()->new ResourcesItemBase(ModBlocks.COPPER_BLOCK.get()));
    public static final RegistryObject<Item> LEAD_BLOCK_ITEM = ITEMS.register("lead_block",()->new ResourcesItemBase(ModBlocks.LEAD_BLOCK.get()));
    public static final RegistryObject<Item> TIN_BLOCK_ITEM = ITEMS.register("tin_block",()->new ResourcesItemBase(ModBlocks.TIN_BLOCK.get()));
    public static final RegistryObject<Item> URANIUM_BLOCK_ITEM = ITEMS.register("uranium_block",()->new ResourcesItemBase(ModBlocks.URANIUM_BLOCK.get()));
    public static final RegistryObject<Item> STEEL_BLOCK_ITEM = ITEMS.register("steel_block",()->new ResourcesItemBase(ModBlocks.STEEL_BLOCK.get()));

    //Under here are listed all the fluid buckets.
    public static final RegistryObject<BucketItem> DEBUG_BUCKET = ITEMS.register("debug_bucket",
            () -> new BucketItem(() -> ModFluids.DEBUG_FLUID.get(), new Item.Properties().tab(ProjectSpace.TAB).stacksTo(1)));
}
