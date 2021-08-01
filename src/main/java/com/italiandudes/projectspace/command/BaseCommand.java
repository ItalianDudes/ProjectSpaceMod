package com.italiandudes.projectspace.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

//This is the model class for the arguments of commands.
public class BaseCommand {
    protected LiteralArgumentBuilder<CommandSource> builder;
    boolean enabled;

    public BaseCommand(String name, int permissionLevel, boolean enabled){
        this.builder = Commands.literal(name).requires(source -> source.hasPermission(permissionLevel));
        this.enabled = enabled;
    }

    public LiteralArgumentBuilder<CommandSource> getBuilder(){
        return builder;
    }

    public boolean isEnabled(){
        return enabled;
    }

    public LiteralArgumentBuilder<CommandSource> setExecution(){
        return null;
    }
}
