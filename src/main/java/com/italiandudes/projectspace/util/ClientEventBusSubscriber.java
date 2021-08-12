package com.italiandudes.projectspace.util;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.client.gui.DisplayCaseGUI;
import com.italiandudes.projectspace.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ProjectSpace.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        ScreenManager.register(ModContainerTypes.DEBUG_DISPLAY_CASE_CONTAINERS_TYPE.get(), DisplayCaseGUI::new);
    }
}
