package com.matez.wildnature.worldgen.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

import java.util.Random;

public class BiomeGlacier extends Biome {



    public BiomeGlacier() {
        super(new BiomeProperties("Glacier").setBaseHeight(5F).setHeightVariation(0.5F).setTemperature(-0.3F).setRainfall(0.1F).setSnowEnabled());



    }


    @Override
    public void plantFlower(World world, Random rand, BlockPos pos) {

    }



    /**
     * Gets the flower list.
     *
     * @return the flower list
     */





    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = Blocks.ICE.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.PACKED_ICE.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = -9999;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 0;
        decorator.generateFalls=false;

        decorator.clayPerChunk=0;



        decorator.flowersPerChunk = -9999;

        return getModdedBiomeDecorator(decorator);
    }


}