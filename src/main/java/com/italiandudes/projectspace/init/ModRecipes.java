package com.italiandudes.projectspace.init;

import com.italiandudes.projectspace.recipes.ExampleRecipe;
import com.italiandudes.projectspace.recipes.ExampleRecipeType;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.Map;
import java.util.Objects;

public class ModRecipes {
    public static final IRecipeType<ExampleRecipe> EXAMPLE_RECIPE = new ExampleRecipeType();

    public static void registerRecipes(RegistryEvent.Register<IRecipeSerializer<?>> event){
        registerRecipe(event,EXAMPLE_RECIPE,ExampleRecipe.SERIALIZER);
    }

    private static void registerRecipe(RegistryEvent.Register<IRecipeSerializer<?>> event, IRecipeType<?> type, IRecipeSerializer<?> serializer){
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(type.toString()),type);
        event.getRegistry().register(serializer);
    }

    public Map<ResourceLocation, IRecipe<?>> getRecipes(IRecipeType<?> type, RecipeManager manager){
        final Map<IRecipeType<?>,Map<ResourceLocation,IRecipe<?>>> recipes = ObfuscationReflectionHelper
                .getPrivateValue(RecipeManager.class, manager, "field_199522_d");
        return Objects.requireNonNull(recipes).get(type);
    }
}
