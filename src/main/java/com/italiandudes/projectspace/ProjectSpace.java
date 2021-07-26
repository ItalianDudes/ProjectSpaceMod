package com.italiandudes.projectspace;

import com.italiandudes.projectspace.config.ProjectSpaceConfig;
import com.italiandudes.projectspace.init.ModBlocks;
import com.italiandudes.projectspace.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("projectspace")
public class ProjectSpace
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "projectspace";

    public ProjectSpace() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        //Blocks and items are registered here.
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        //Configs are registered here!
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ProjectSpaceConfig.SPEC,"projectspace-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){}

    private void doClientStuff(final FMLClientSetupEvent event) {}
}
