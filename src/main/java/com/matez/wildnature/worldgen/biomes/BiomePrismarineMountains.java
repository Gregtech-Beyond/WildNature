package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.worldgen.treeGen_pine;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomePrismarineMountains extends Biome {

    protected static final WorldGenAbstractTree TREE = new treeGen_pine(true);


    public BiomePrismarineMountains() {
        super(new BiomeProperties("Prismarine Mountains").setBaseBiome("ocean").setBaseHeight(2.5F).setHeightVariation(1.5F).setTemperature(0.3F).setRainfall(0.3F).setSnowEnabled());



    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return TREE;
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
        topBlock = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE); // zwykle to blok trawy
        fillerBlock = Blocks.STONE.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = -9999;
        decorator.grassPerChunk = -9999;
        decorator.sandPatchesPerChunk = -9999;
        decorator.clayPerChunk=-9999;



        decorator.flowersPerChunk = -9999;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        {
            this.topBlock = Blocks.STONE.getDefaultState();
            this.fillerBlock = Blocks.STONE.getDefaultState();

            if (noiseVal > 1.75D) {
                this.topBlock = Blocks.PRISMARINE.getDefaultState();
                this.fillerBlock = Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.DARK);
            } else if (noiseVal > -0.95D) {
                this.topBlock = Blocks.PRISMARINE.getDefaultState();
                this.fillerBlock = Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.DARK);
            }

            this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
        }


    }


}