package com.italiandudes.projectspace.events;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//This class handles all PlayerRelated events
@Mod.EventBusSubscriber(modid = ProjectSpace.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEvents {

    //This is an example event (Must be deleted if not needed).
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        //This runs everytime the player ticks.
        PlayerEntity player = event.player;
        player.inventory.armor.set(0, new ItemStack(Items.GOLDEN_HELMET));
    }

    //This is an example event (Must be deleted if not needed).
    @SubscribeEvent
    public static void onPlayerToss(ItemTossEvent event){
        PlayerEntity player = event.getPlayer();
        World world = player.level;
        BlockState state = world.getBlockState(player.blockPosition().below());

        if (state.getBlock() == ModBlocks.ALUMINIUM_BLOCK.get()){
            player.addItem(new ItemStack(Items.DIAMOND));
        }
    }
}
