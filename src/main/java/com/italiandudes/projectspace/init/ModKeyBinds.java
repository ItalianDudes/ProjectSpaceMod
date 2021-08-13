package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.awt.event.KeyEvent;

@OnlyIn(Dist.CLIENT)
public class ModKeyBinds {
    public static KeyBinding exampleKey;

    public static void register(final FMLClientSetupEvent event){
        exampleKey = create("example_key", KeyEvent.VK_G);

        ClientRegistry.registerKeyBinding(exampleKey);
    }

    private static KeyBinding create(String name, int key){
        return new KeyBinding("key."+ ProjectSpace.MOD_ID+"."+name,key,"key.category."+ProjectSpace.MOD_ID);
    }
}
