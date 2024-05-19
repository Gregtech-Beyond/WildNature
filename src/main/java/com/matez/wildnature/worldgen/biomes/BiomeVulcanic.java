package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.init.ModBlocks;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;

import java.util.Random;

public class BiomeVulcanic extends Biome {



    public BiomeVulcanic() {
        super(new BiomeProperties("Volcano").setBaseHeight(1.3F).setHeightVariation(1F).setTemperature(1F).setRainfall(0.0F));



    }


    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xAD8F72;
    }


    @Override
    public void plantFlower(World world, Random rand, BlockPos pos) {

    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0x535353;
    }




    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecoratorVulcanic decorator = new BiomeDecoratorVulcanic();
        topBlock = ModBlocks.ASH.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.ASH_BLOCK.getDefaultState(); // zwykle to ziemia

        decorator.treesPerChunk = -9999;
        decorator.grassPerChunk = -9999;
        decorator.sandPatchesPerChunk = -9999;
        decorator.clayPerChunk=-9999;

        decorator.flowers.clear();


        decorator.generateFalls=true;


        decorator.flowersPerChunk = -9999;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();

    }
}