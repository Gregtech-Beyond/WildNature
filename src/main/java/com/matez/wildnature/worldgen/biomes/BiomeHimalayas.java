package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityGoatFemale;
import com.matez.wildnature.entity.EntityGoatMale;
import com.matez.wildnature.entity.EntityGoatSaanenFemale;
import com.matez.wildnature.entity.EntityGoatSaanenMale;
import net.minecraft.block.BlockSnow;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomeHimalayas extends Biome {







    public BiomeHimalayas() {
        super(new BiomeProperties("Himalayas").setBaseHeight(1.5F).setHeightVariation(1.7F).setTemperature(-0.4F).setRainfall(0.6F));



    }



    @Override
    public int getWaterColorMultiplier() {
        return 0x000477;
    }


    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x6E7D5F : 0x737D70);
    }


    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeFoliageColor(noise < -0.1D ? 0x45693D : 0x737D70);
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0xA8EBD7;
    }







    /**
     * Gets the flower list.
     *
     * @return the flower list
     */




    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecoratorMountain decorator = new BiomeDecoratorMountain();
        topBlock = Blocks.SNOW.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.SNOW.getDefaultState(); // zwykle to ziemia

        decorator.treesPerChunk = -9999;
        decorator.grassPerChunk = -9999;
        decorator.sandPatchesPerChunk = -9999;
        decorator.clayPerChunk=9;

        decorator.flowers.clear();




        decorator.flowersPerChunk = -9999;



        return getModdedBiomeDecorator(decorator);
    }
    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 1, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGoatSaanenMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGoatSaanenFemale.class, 3, 1, 2));
    }
    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        topBlock = Blocks.SNOW_LAYER.getDefaultState().withProperty(BlockSnow.LAYERS, Main.generateRandomInt(1,3,rand));
        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }


}