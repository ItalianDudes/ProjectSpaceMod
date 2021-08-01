package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.container.DisplayCaseContainers;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//This class lists all the ContainerTypes objects in the mod.
public class ModContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, ProjectSpace.MOD_ID);

    public static final RegistryObject<ContainerType<DisplayCaseContainers>> DISPLAY_CASE_CONTAINERS_TYPE = CONTAINER_TYPES
            .register("display_case",()-> IForgeContainerType.create(DisplayCaseContainers::new));
}
