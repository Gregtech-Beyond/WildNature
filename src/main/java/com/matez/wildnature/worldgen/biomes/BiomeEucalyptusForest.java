package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.treeGen_eucalyptus;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

public class BiomeEucalyptusForest extends Biome {

    protected static  WorldGenAbstractTree TREE = new treeGen_eucalyptus(true);
    protected static  WorldGenAbstractTree TREE2 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());


    public BiomeEucalyptusForest() {
        super(new BiomeProperties("Eucalyptus Forest").setBaseHeight(0.7F).setHeightVariation(0.4F).setTemperature(0.85F).setRainfall(0.6F));



    }



    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x1cd709;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        TREE = new treeGen_eucalyptus(true);
        TREE2 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());
        int x = Main.generateRandomInt(0,13);
        if(x<12){
            return TREE2;
        }else {
            return TREE;
        }

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
        topBlock = ModBlocks.MOLD_GRASS_BLOCK.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.ZIEMA_CZARNOZIEM.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = 8;
        decorator.grassPerChunk = 10;
        decorator.sandPatchesPerChunk = 5;
        decorator.clayPerChunk=2;
        decorator.reedsPerChunk=4;

        

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