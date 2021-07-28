package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.command.BaseCommand;
import com.italiandudes.projectspace.command.impl.GiveDebugBatteryCommand;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;

import java.util.ArrayList;

//Here all the commands are collected.
public class ModCommand {
    private static final ArrayList<BaseCommand> commands = new ArrayList<>();

    public static void registerCommand(final RegisterCommandsEvent event){
        CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();

        commands.add(new GiveDebugBatteryCommand("giveDebugBattery",4, true));

        commands.forEach(command -> {
            if(command.isEnabled() && command.setExecution() != null){
                dispatcher.register(command.getBuilder());
            }
        });
    }
}
