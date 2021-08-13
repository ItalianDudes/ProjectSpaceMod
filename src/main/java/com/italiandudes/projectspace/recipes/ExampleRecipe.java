package com.italiandudes.projectspace.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.italiandudes.projectspace.ProjectSpace;
import com.italiandudes.projectspace.init.ModItems;
import com.italiandudes.projectspace.init.ModRecipes;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.Objects;

public class ExampleRecipe implements IRecipe<IInventory> {

    public static final Serializer SERIALIZER = new Serializer();

    private final Ingredient input;
    private final ItemStack output;
    private final Block block;
    private final ResourceLocation id;

    public ExampleRecipe(ResourceLocation id, Ingredient input, ItemStack output, Block block){
        this.id = id;
        this.input = input;
        this.output = output;
        this.block = block;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return this.input.test(inv.getItem(0));
    }

    @Override
    public ItemStack assemble(IInventory INV) {
        return this.output.copy();
    }

    @Override
    public ItemStack getResultItem() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public IRecipeType<?> getType() {
        return ModRecipes.EXAMPLE_RECIPE;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModItems.DEBUG_BATTERY.get());
    }

    public boolean isValid(ItemStack input, Block block){
        return this.input.test(input) && block==this.block;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    private static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ExampleRecipe>{
        Serializer(){
            this.setRegistryName(ProjectSpace.MOD_ID,"example_recipe");
        }

        @Override
        public ExampleRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            final JsonElement inputEl = JSONUtils.isArrayNode(json,"input") ? JSONUtils.getAsJsonArray(json,"input")
                    : JSONUtils.getAsJsonObject(json, "input");
            final Ingredient input = Ingredient.fromJson(inputEl);
            final ItemStack output = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json,"output"));
            final Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(JSONUtils.getAsString(json,"block")));

            if(block == null){
                throw new IllegalStateException("Block does not exist!");
            }

            return new ExampleRecipe(recipeId,input,output,block);
        }

        @Nullable
        @Override
        public ExampleRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            final Ingredient input = Ingredient.fromNetwork(buffer);
            final ItemStack output = buffer.readItem();
            final Block block = ForgeRegistries.BLOCKS.getValue(buffer.readResourceLocation());

            if(block == null){
                throw new IllegalStateException("Block does not exist!");
            }

            return new ExampleRecipe(recipeId,input,output,block);
        }

        @Override
        public void toNetwork(PacketBuffer buffer, ExampleRecipe recipe) {
            recipe.input.toNetwork(buffer);
            buffer.writeItem(recipe.output);
            buffer.writeResourceLocation(Objects.requireNonNull(recipe.block.getRegistryName()));
        }
    }
}
