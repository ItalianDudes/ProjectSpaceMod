package com.italiandudes.projectspace.network;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.network.packets.InputMessage;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import static com.sun.imageio.plugins.jpeg.JPEG.version;

public class ProjectSpaceNetwork {

    public static final String NETWORK_VERSION = "0.1.0"; //The middle number MUST be changed every time the network is changed!

    public static final SimpleChannel CHANNEL = NetworkRegistry
            .newSimpleChannel(new ResourceLocation(ProjectSpace.MOD_ID,"network"), ()->NETWORK_VERSION,
                    version -> version.equals(NETWORK_VERSION),version -> version.equals(NETWORK_VERSION));

    //Here all packages are initialized.
    public static void init(){

        //To create a new message, remember to change the index to the following number.
        CHANNEL.registerMessage(0, InputMessage.class, InputMessage::encode, InputMessage::decode, InputMessage::handle);

    }
}
