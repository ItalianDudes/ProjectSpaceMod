package com.italiandudes.projectspace.command.impl;

import com.italiandudes.projectspace.command.BaseCommand;
import com.italiandudes.projectspace.init.ModItems;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;

//This is the giveDebugBatteryCommand's class.
public class GiveDebugBatteryCommand extends BaseCommand {
    public GiveDebugBatteryCommand(String name, int permissionLevel, boolean enabled) {
        super(name, permissionLevel, enabled);
    }

    @Override
    public LiteralArgumentBuilder<CommandSource> setExecution() {
        return builder.then(Commands.argument("player", EntityArgument.player())
                .executes(source -> execute(source.getSource(),EntityArgument.getPlayer(source,"player"))));
    }

    private int execute(CommandSource source, ServerPlayerEntity player){
        player.addItem(new ItemStack(ModItems.DEBUG_BATTERY.get()));
        return Command.SINGLE_SUCCESS;
    }
}
