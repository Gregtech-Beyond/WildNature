package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.*;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

public class BiomeJacarandaForest extends Biome {

    protected static WorldGenAbstractTree TREE = new BigTree(true,7,1,1,ModBlocks.JACARANDA_LOG.getDefaultState(),ModBlocks.JACARANDA_LEAVES.getDefaultState(),Blocks.SAPLING.getDefaultState());
    protected static WorldGenAbstractTree TREE2 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());



    public BiomeJacarandaForest() {
        super(new BiomeProperties("Jacaranda Forest").setBaseHeight(0.3F).setHeightVariation(0.1F).setTemperature(0.65F).setRainfall(0.7F));



    }

    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 6730836 : 10381471);
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        int x = Main.generateRandomInt(0,4,rand);
        TREE = new treeGen_jacaranda(true);
        TREE2 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());
        if(x==0){
            return TREE;
        } else{
            return TREE2;
        }

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

        decorator.treesPerChunk = 4;
        decorator.grassPerChunk = 20;
        decorator.sandPatchesPerChunk = -9999;


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