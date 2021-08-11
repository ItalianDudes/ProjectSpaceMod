package com.italiandudes.projectspace.world.gen;

import com.italiandudes.projectspace.ProjectSpace;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ProjectSpace.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event){
        //This cycle loops through every Biome registered in the Forge Registries and saves it in "biome".
        for(Biome biome : ForgeRegistries.BIOMES){

        }
    }

    private static void genOre(Biome biome, int rarity, int bottomOffSet, int max, OreFeatureConfig.FillerBlockType filler, BlockState block, int size){
        FeatureSpreadConfig featureSpreadConfig = new FeatureSpreadConfig()
        OreFeatureConfig featureConfig = new OreFeatureConfig(filler,block,size);
        ConfiguredPlacement configuredPlacement = Placement.COUNT.configured(rangeConfig);
    }
}
