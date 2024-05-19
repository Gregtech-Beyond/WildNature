package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import net.minecraft.block.BlockSnow;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomePolarPlateau extends Biome {



    public BiomePolarPlateau() {
        super(new BiomeProperties("Polar Plateau").setBaseBiome("ice_flats").setBaseHeight(0.8F).setHeightVariation(0.0F).setTemperature(-0.3F).setRainfall(0.9F).setSnowEnabled());



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
        topBlock = Blocks.SNOW_LAYER.getDefaultState().withProperty(BlockSnow.LAYERS,1); // zwykle to blok trawy
        fillerBlock = Blocks.SNOW.getDefaultState(); // zwykle to ziemia



        decorator.treesPerChunk = -9999;
        decorator.grassPerChunk = -9999;
        decorator.sandPatchesPerChunk = -9999;
        decorator.generateFalls=false;

        decorator.clayPerChunk=-9999;




        decorator.flowersPerChunk = -9999;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPolarBear.class, 3, 1, 2));
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        topBlock = Blocks.SNOW_LAYER.getDefaultState().withProperty(BlockSnow.LAYERS, Main.generateRandomInt(1,3,rand));
        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}