package com.matez.wildnature.event;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;

public class ChunkReplaceableBlocks {
    private  ArrayList<ReplaceBase> bases;
    private  ArrayList<Biome> biomesTemp;
    public ChunkReplaceableBlocks(ArrayList<ReplaceBase> bases, ArrayList<Biome> biomesTemp){
        this.bases=bases;
        this.biomesTemp=biomesTemp;
    }

    public ArrayList<ReplaceBase> getBases() {
        return bases;
    }

    public ArrayList<Biome> getBiomesTemp() {
        return biomesTemp;
    }


}
