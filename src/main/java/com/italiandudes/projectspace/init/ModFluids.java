package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.rmi.registry.Registry;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ProjectSpace.MOD_ID);

    //Under here are listed all the fluid's resources
    public static final ResourceLocation DEBUG_STILL_RL = new ResourceLocation("blocks/fluids/still/debug_still");
    public static final ResourceLocation DEBUG_FLOWING_RL = new ResourceLocation("blocks/fluids/flowing/debug_flowing");
    public static final ResourceLocation DEBUG_OVERLAY_RL = new ResourceLocation("blocks/fluids/debug_overlay");

    //Under here are listed all the fluids.
    public static final RegistryObject<FlowingFluid> DEBUG_FLUID = FLUIDS.register("debug_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.DEBUG_PROPERTIES));
    public static final RegistryObject<FlowingFluid> DEBUG_FLOWING = FLUIDS.register("debug_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.DEBUG_PROPERTIES));

    //Under here are listed all the fluid's properties.
    public static final ForgeFlowingFluid.Properties DEBUG_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> DEBUG_FLUID.get(), () -> DEBUG_FLOWING.get(), FluidAttributes.builder(DEBUG_STILL_RL,DEBUG_FLOWING_RL).density(15).
            luminosity(2).viscosity(5).sound(SoundEvents.WATER_AMBIENT,SoundEvents.BUCKET_EMPTY).overlay(DEBUG_OVERLAY_RL)
            .color(0xbffed0d8)).slopeFindDistance(2).levelDecreasePerBlock(2).block(() -> ModBlocks.DEBUG_BLOCK.get())
            .bucket(() -> ModItems.DEBUG_BUCKET.get());
    /*
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ProjectSpace.MOD_ID);

    //Under here are listed all the fluid's resources.
    public static final ResourceLocation DEBUG_STILL_RL = new ResourceLocation(ProjectSpace.MOD_ID,"blocks/fluids/still/debug_still");
    public static final ResourceLocation DEBUG_FLOWING_RL = new ResourceLocation(ProjectSpace.MOD_ID,"blocks/fluids/flowing/debug_flowing");
    public static final ResourceLocation DEBUG_OVERLAY_RL = new ResourceLocation(ProjectSpace.MOD_ID,"blocks/fluids/debug_overlay");

    //Under here are listed all the fluids.
    public static final RegistryObject<FlowingFluid> DEBUG_FLUID = FLUIDS.register("debug_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.DEBUG_PROPERTIES));
    public static final RegistryObject<FlowingFluid> DEBUG_FLOWING = FLUIDS.register("debug_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.DEBUG_PROPERTIES));

    //Under here are listed all the fluid's properties.
    public static final ForgeFlowingFluid.Properties DEBUG_PROPERTIES = new ForgeFlowingFluid.Properties(() -> DEBUG_FLUID.get(), () -> DEBUG_FLOWING.get(),
            FluidAttributes.builder(DEBUG_STILL_RL,DEBUG_FLOWING_RL).overlay(DEBUG_OVERLAY_RL).density(1000).viscosity(1000).luminosity(10)
                    .sound(SoundEvents.WATER_AMBIENT,SoundEvents.BUCKET_EMPTY)).block(()-> ModBlocks.DEBUG_BLOCK.get()).bucket(() -> ModItems.DEBUG_BUCKET.get());
    */
}