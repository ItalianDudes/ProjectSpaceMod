package com.italiandudes.projectspace.config;

import net.minecraftforge.common.ForgeConfigSpec;

// As the class name indicates, this class sets the configs for the mod.
public class ProjectSpaceConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    //Examples!!
    public static final ForgeConfigSpec.ConfigValue<Integer> example_integer;
    public static final ForgeConfigSpec.ConfigValue<String> example_string;

    static {
        BUILDER.push("Config for ProjectSpace mod!");

        example_integer = BUILDER.comment("This is an integer. Default value is 3.").define("Example Integer",3);
        example_string = BUILDER.comment("This is a string. Default value is \"Ciao\".").define("Example String","Ciao");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
