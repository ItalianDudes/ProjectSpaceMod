package com.italiandudes.projectspace.blocks;

import com.italiandudes.projectspace.ProjectSpace;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;

public class DebugBlock extends Block {

    OBJLoader loader = new OBJLoader();

    public void setLoader(OBJLoader loader) {
        this.loader = loader;
        ResourceLocation location = new ResourceLocation(ProjectSpace.MOD_ID,"block/debug_test.obj");
        String matLocation = new String("block/debug_test.mtl");

        loader.loadModel(new OBJModel.ModelSettings(location,true,true, false, true,matLocation));
    }

    public DebugBlock() {
        super(AbstractBlock.Properties.of(Material.METAL));

        setLoader(new OBJLoader());
    }

}