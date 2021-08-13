package com.italiandudes.projectspace.recipes;

import com.italiandudes.projectspace.ProjectSpace;
import net.minecraft.item.crafting.IRecipeType;

public class ExampleRecipeType implements IRecipeType<ExampleRecipe> {

    @Override
    public String toString() {
        return ProjectSpace.MOD_ID + ":example_recipe";
    }
}
