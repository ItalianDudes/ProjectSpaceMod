package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.ProjectSpace;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ProjectSpace.MOD_ID);

    //Short for register sounds. Sound names must have same name of their file.
    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, ()-> new SoundEvent(new ResourceLocation(ProjectSpace.MOD_ID,name)));
    }

    //Under here are listed all the sounds.
    public static final RegistryObject<SoundEvent> DEBUG_SOUND = registerSoundEvent("debug_sound");
}
