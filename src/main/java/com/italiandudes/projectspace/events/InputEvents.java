package com.italiandudes.projectspace.events;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.init.ModKeyBinds;
import com.italiandudes.projectspace.network.ProjectSpaceNetwork;
import com.italiandudes.projectspace.network.packets.InputMessage;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ProjectSpace.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT )
public class InputEvents {

    @SubscribeEvent
    public static void onKeyPressed(InputEvent.KeyInputEvent event){
        Minecraft mc = Minecraft.getInstance();
        if(mc.level==null){
            return;
        }
        onInput(mc, event.getKey(), event.getAction());
    }

    @SubscribeEvent
    public static void onMouseClicked(InputEvent.MouseInputEvent event){
        Minecraft mc = Minecraft.getInstance();
        if(mc.level==null){
            return;
        }
        onInput(mc, event.getButton(), event.getAction());
    }

    private static void onInput(Minecraft mc, int key, int action){

        if(mc.screen == null && ModKeyBinds.exampleKey.isDown()){
            System.out.println("EXAMPLE KEY PRESSED");
            ProjectSpaceNetwork.CHANNEL.sendToServer(new InputMessage(key));
        }

    }
}
