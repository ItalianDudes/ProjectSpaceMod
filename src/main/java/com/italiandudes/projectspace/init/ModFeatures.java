package com.italiandudes.projectspace.init;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModFeatures {

    public static void addOres(final BiomeLoadingEvent event){
        addOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.BAUXITE_ORE.get().defaultBlockState(),13,0,64,0);
        addOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.LEAD_ORE.get().defaultBlockState(),13,0,64,0);
        addOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.URANIUM_ORE.get().defaultBlockState(),13,0,64,0);
        addOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.COPPER_ORE.get().defaultBlockState(),13,0,64,0);
        addOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.TIN_ORE.get().defaultBlockState(),13,0,64,0);
    }

    public static void addOre(final BiomeLoadingEvent event, RuleTest rule, BlockState state, int veinSize, int minHeight, int maxHeight, int rarity){
        event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreFeatureConfig(rule, state, veinSize))
                        .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                        .squared().chance(rarity)
        );
    }
}
