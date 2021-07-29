package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ProjectSpace.MOD_ID);

    //Under here are listed all the fluids.
    public static final RegistryObject<FlowingFluid> OXYGEN_FLUID = FLUIDS.register("oxygen_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.OXYGEN_PROPERTIES));
    public static final RegistryObject<FlowingFluid> OXYGEN_FLOWING = FLUIDS.register("oxygen_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.OXYGEN_PROPERTIES));

    //Under here are listed all the fluid's resources.
    public static final ResourceLocation OXYGEN_STILL_RL = new ResourceLocation(ProjectSpace.MOD_ID,"blocks/fluids/oxygen_still");
    public static final ResourceLocation OXYGEN_FLOWING_RL = new ResourceLocation(ProjectSpace.MOD_ID,"blocks/fluids/oxygen_flowing");
    public static final ResourceLocation OXYGEN_OVERLAY_RL = new ResourceLocation(ProjectSpace.MOD_ID,"blocks/fluids/oxygen_overlay");

    //Under here are listed all the fluid's properties.
    public static final ForgeFlowingFluid.Properties OXYGEN_PROPERTIES = new ForgeFlowingFluid.Properties(OXYGEN_FLUID, OXYGEN_FLOWING,
            FluidAttributes.builder(OXYGEN_STILL_RL,OXYGEN_FLOWING_RL).rarity(Rarity.COMMON).overlay(OXYGEN_OVERLAY_RL));
}
