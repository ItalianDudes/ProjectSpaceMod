package com.italiandudes.projectspace;

import com.italiandudes.projectspace.config.ProjectSpaceConfig;
import com.italiandudes.projectspace.init.*;
import com.italiandudes.projectspace.network.ProjectSpaceNetwork;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("projectspace")
@Mod.EventBusSubscriber(modid = ProjectSpace.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ProjectSpace
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "projectspace";

    public ProjectSpace() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        bus.addListener(this::commonSetup);
        bus.addGenericListener(IRecipeSerializer.class,ModRecipes::registerRecipes);

        //Blocks and items are registered here.
        //Blocks MUST be registered before items are, or MC would crash.
        ModFluids.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModTileEntityTypes.TILE_ENTITY_TYPE.register(bus);
        ModContainerTypes.CONTAINER_TYPES.register(bus);
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        //Configs are registered here!
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ProjectSpaceConfig.SPEC,"projectspace-common.toml");

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModFeatures::addOres);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){}

    private void doClientStuff(final FMLClientSetupEvent event) {
        //Under here are listed all fluid's renders
        RenderTypeLookup.setRenderLayer(ModFluids.DEBUG_FLUID.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.DEBUG_BLOCK.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModFluids.DEBUG_FLOWING.get(), RenderType.translucent());
    }

    public void commonSetup(final FMLClientSetupEvent event){
        ProjectSpaceNetwork.init();
    }

    //The mod's tabs are created here.
    public static final ItemGroup TAB = new ItemGroup("projectSpace"){
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DEBUG_BATTERY.get());
        }
    };

    public static final ItemGroup RESOURCES_TAB = new ItemGroup("projectSpaceResources") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ALUMINIUM_INGOT.get());
        }
    };

    public static final ItemGroup ENERGY_TAB = new ItemGroup("projectSpaceEnergy") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BASIC_BATTERY.get());
        }
    };

    //The commands are registered here.
    @SubscribeEvent
    public void onCommandRegister(final RegisterCommandsEvent event){
        ModCommand.registerCommand(event);
    }
}
