package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {

    //Under here are listed all the fluid's resources.
    public static final ResourceLocation OXYGEN_STILL_RL = new ResourceLocation(ProjectSpace.MOD_ID,"blocks/fluids/oxygen_still");
    public static final ResourceLocation OXYGEN_FLOWING_RL = new ResourceLocation(ProjectSpace.MOD_ID,"blocks/fluids/oxygen_flowing");
    public static final ResourceLocation OXYGEN_OVERLAY_RL = new ResourceLocation(ProjectSpace.MOD_ID,"blocks/fluids/oxygen_overlay");

    //This is used to register the class.
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ProjectSpace.MOD_ID);

    //Under here are listed all the fluids.
    public static final RegistryObject<FlowingFluid> OXYGEN_FLUID = FLUIDS.register("oxygen_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.OXYGEN_PROPERTIES));
    public static final RegistryObject<FlowingFluid> OXYGEN_FLOWING = FLUIDS.register("oxygen_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.OXYGEN_PROPERTIES));

    //Under here are listed all the fluid's properties.
    public static final ForgeFlowingFluid.Properties OXYGEN_PROPERTIES = new ForgeFlowingFluid.Properties(() -> OXYGEN_FLUID.get(), () -> OXYGEN_FLOWING.get(),
            FluidAttributes.builder(OXYGEN_STILL_RL,OXYGEN_FLOWING_RL).rarity(Rarity.RARE).overlay(OXYGEN_OVERLAY_RL).density(35).luminosity(10).sound(SoundEvents.WATER_AMBIENT)
                    .viscosity(20)).block(()-> ModBlocks.OXYGEN_BLOCK.get());
}
