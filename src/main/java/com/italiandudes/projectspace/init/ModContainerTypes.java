package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.container.DebugChargerContainers;
import com.italiandudes.projectspace.container.DebugDisplayCaseContainers;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//This class lists all the ContainerTypes objects in the mod.
public class ModContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, ProjectSpace.MOD_ID);

    public static final RegistryObject<ContainerType<DebugDisplayCaseContainers>> DEBUG_DISPLAY_CASE_CONTAINERS_TYPE = CONTAINER_TYPES
            .register("debug_display_case",()-> IForgeContainerType.create(DebugDisplayCaseContainers::new));
    public static final RegistryObject<ContainerType<DebugChargerContainers>> DEBUG_CHARGER_CONTAINER_TYPE = CONTAINER_TYPES
            .register("debug_charger",()->IForgeContainerType.create(DebugChargerContainers::new));
}
