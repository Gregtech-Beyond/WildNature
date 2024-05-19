package com.matez.wildnature.worldgen.generators.block;

import com.matez.wildnature.blocks.RockBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Fossil {
    private ArrayList<WorldGenerator> fossilGens;
    private int size,chance,minY,maxY;
    private ArrayList<Block> states;
    private IBlockState fossil;
    private ArrayList<Biome> biomes;
    private boolean waterRequired = false;
    public Fossil(IBlockState fossil, int blockCount, int chance, int minY, int maxY, Block... whereToSpawn){
        fossilGens=new ArrayList<>();
        this.fossil=fossil;
        this.states=new ArrayList<>(Arrays.asList(whereToSpawn));
        this.chance=chance;
        this.maxY=maxY;
        this.minY=minY;
        int x = 0;
        while(x<this.states.size()){
            WorldGenerator gen = new WorldGenMinable(fossil,blockCount, BlockMatcher.forBlock(states.get(x)));
            fossilGens.add(gen);
            x++;
        }
    }

    public Fossil(IBlockState fossil, int blockCount, int chance, Block... whereToSpawn){
        fossilGens=new ArrayList<>();
        this.fossil=fossil;
        this.states=new ArrayList<>(Arrays.asList(whereToSpawn));
        this.chance=chance;
        int x = 0;
        while(x<this.states.size()){
            WorldGenerator gen = new WorldGenMinable(fossil,blockCount, BlockMatcher.forBlock(states.get(x)));
            fossilGens.add(gen);
            x++;
        }
    }

    public void spawnNearWater(boolean bool){
        waterRequired=bool;
    }

    public boolean isWaterRequired() {
        return waterRequired;
    }

    public void addAllowedBiomes(Biome... biomes){
        this.biomes=new ArrayList<>(Arrays.asList(biomes));
    }

    public boolean canSpawnOnAllBiomes(){
        return biomes==null;
    }

    public ArrayList<Biome> getAllowedBiomes() {
        return biomes;
    }

    public IBlockState getFossil() {
        return fossil;
    }

    public int getChance() {
        return chance;
    }

    public int getMaxY(World world) {
        if(fossil.getBlock() instanceof RockBase){
            maxY = ((RockBase) fossil.getBlock()).getMaxYByType(world);
        }
        return maxY;
    }

    public int getMinY(World world) {
        if(fossil.getBlock() instanceof RockBase){
            minY = ((RockBase) fossil.getBlock()).getMinYByType(world);
        }
        return minY;
    }

    public ArrayList<WorldGenerator> getFossilGens() {
        return fossilGens;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Block> getStates() {
        return states;
    }
}
