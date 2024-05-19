package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.BigTree;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

public class BiomeTropicalWaterRocks extends Biome {

    private static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
    private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    protected static final WorldGenAbstractTree TREE = new BigTree(true,16,1,1.0D,Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY,false),Blocks.SAPLING.getDefaultState());
    protected static final WorldGenAbstractTree TREE2 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());
    protected static final WorldGenAbstractTree TREE3 = new WorldGenShrub(JUNGLE_LOG,JUNGLE_LEAF);
    protected static final WorldGenAbstractTree TREE4 = new WorldGenTrees(true,11,JUNGLE_LOG,JUNGLE_LEAF,true);





    public BiomeTropicalWaterRocks() {
        super(new BiomeProperties("Tropical Water Rocks").setBaseBiome("jungle").setBaseHeight(-0.2F).setHeightVariation(0.6F).setTemperature(0.80F).setRainfall(0.8F));



    }



    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {

        switch (Main.generateRandomInt(2,4)){

            case 2:
                return TREE2;
            case 3:
                return TREE4;
            case 4:
                return TREE3;

        }



        return TREE;
    }





    /**
     * Gets the flower list.
     *
     * @return the flower list
     */




    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = Blocks.GRASS.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.DIRT.getDefaultState(); // zwykle to ziemia

        decorator.treesPerChunk = 6;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 8;
        decorator.clayPerChunk=9;



        decorator.flowersPerChunk = 20;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        {
            topBlock = Blocks.GRASS.getDefaultState(); // zwykle to blok trawy
            fillerBlock = Blocks.DIRT.getDefaultState(); // zwykle to ziemia

            if (noiseVal > 1.75D) {
                topBlock = Blocks.GRAVEL.getDefaultState(); // zwykle to blok trawy

            } else if (noiseVal > -1D) {
                topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT); // zwykle to blok trawy
            }

            this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
        }


    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 5949756;
    }
    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 3258892;
    }

    //Water16777215
    //Grass5949756
    //Foliage3258892

}