package com.matez.wildnature.event;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;

public class RockLevel {
    private IBlockState blockState;
    private int min,max;
    private ArrayList<Biome> allowedBiomes;
    public RockLevel(IBlockState blockState, int min, int max, ArrayList<Biome> allowedBiomes){
        this.blockState=blockState;
        this.min=min;
        this.max=max;
        this.allowedBiomes=allowedBiomes;
    }

    public ArrayList<Biome> getAllowedBiomes() {
        return allowedBiomes;
    }

    public IBlockState getBlockState() {
        return blockState;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
