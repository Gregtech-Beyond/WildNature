package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.BigTree;
import com.matez.wildnature.worldgen.treeGen_miniTree;
import com.matez.wildnature.worldgen.treeGen_pine;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;

import java.util.Random;

public class BiomeSteppe extends Biome {


    protected static  WorldGenAbstractTree TREE3 = new WorldGenSavannaTree(true);

    public BiomeSteppe() {
        super(new BiomeProperties("Steppe").setBaseBiome("savanna").setBaseHeight(0.2F).setHeightVariation(0.1F).setTemperature(0.85F).setRainfall(0.2F));



    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xB49D5D;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        TREE3 = new WorldGenSavannaTree(true);

        return TREE3;

    }

    @Override
    public void plantFlower(World world, Random rand, BlockPos pos) {

    }





    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = ModBlocks.DRIED_GRASS_BLOCK.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.ZIEMA_SUCHA.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = -1;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 5;
        decorator.clayPerChunk=0;
        decorator.extraTreeChance=1.1F;
        

        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());


        decorator.flowersPerChunk = 20;

        return getModdedBiomeDecorator(decorator);
    }


}