package com.italiandudes.projectspace;

import com.italiandudes.projectspace.config.ProjectSpaceConfig;
import com.italiandudes.projectspace.init.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
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

        //Blocks and items are registered here.
        //Blocks MUST be registered before items are, or MC would crash.
        ModFluids.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModTileEntityTypes.TILE_ENTITY_TYPE.register(bus);
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        //Configs are registered here!
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ProjectSpaceConfig.SPEC,"projectspace-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){}

    private void doClientStuff(final FMLClientSetupEvent event) {}

    //The mod's tab is created here.
    public static final ItemGroup TAB = new ItemGroup("projectSpace"){
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DEBUG_BATTERY.get());
        }
    };

    //The commands are registered here.
    @SubscribeEvent
    public void onCommandRegister(final RegisterCommandsEvent event){
        ModCommand.registerCommand(event);
    }
}
