package com.italiandudes.projectspace.network.packets;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.Objects;
import java.util.function.Supplier;

//This is an example packet.
public class InputMessage {

    public int key;

    public InputMessage(){

    }

    public InputMessage(int key){
        this.key=key;
    }

    //encode and decode methods: be careful of how you write/read the message!
    public static void encode(InputMessage message, PacketBuffer buffer){
        buffer.writeInt(message.key);
    }

    public static InputMessage decode(PacketBuffer buffer){
        return new InputMessage(buffer.readInt());
    }

    //This method handles what we want to happen on the client side.
    public static void handle(InputMessage message, Supplier<NetworkEvent.Context> contextSupplier){
        NetworkEvent.Context context = contextSupplier.get();
        //This is what will happen when the packet is decoded by the server.
        context.enqueueWork(()->{
            ServerPlayerEntity player = context.getSender();
            Objects.requireNonNull(player).addItem(new ItemStack(Items.DIAMOND));

            World world = player.getLevel();
            world.setBlockAndUpdate(player.blockPosition().below(), Blocks.DIAMOND_BLOCK.defaultBlockState());

            System.out.println(message.key);
        });
        context.setPacketHandled(true);
    }
}
