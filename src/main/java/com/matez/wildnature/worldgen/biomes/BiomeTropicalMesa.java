package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.Random;

public class BiomeTropicalMesa extends Biome {

    protected static final IBlockState GRASS = Blocks.GRASS.getDefaultState();
    protected static final IBlockState HARDENED_CLAY = Blocks.HARDENED_CLAY.getDefaultState();
    protected static final IBlockState STAINED_HARDENED_CLAY = Blocks.STAINED_HARDENED_CLAY.getDefaultState();
    protected static final IBlockState ORANGE_STAINED_HARDENED_CLAY = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE);
    protected static final IBlockState RED_STAINED_HARDENED_CLAY = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.RED);
    protected static final IBlockState YELLOW_STAINED_HARDENED_CLAY = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW);

    protected static final IBlockState RED_SAND = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND);

    private static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
    private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

    protected static final WorldGenAbstractTree TREE2 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());
    protected static final WorldGenAbstractTree TREE3 = new WorldGenShrub(JUNGLE_LOG,JUNGLE_LEAF);
    protected static final WorldGenAbstractTree TREE4 = new WorldGenMegaJungle(true,17,5,JUNGLE_LOG,JUNGLE_LEAF);

    private IBlockState[] clayBands;
    private long worldSeed;
    private NoiseGeneratorPerlin pillarNoise;
    private NoiseGeneratorPerlin pillarRoofNoise;
    private NoiseGeneratorPerlin clayBandsOffsetNoise;
    private final boolean brycePillars = false;
    private final boolean hasForest = false;

    public BiomeTropicalMesa() {
        super(new BiomeProperties("Tropical Mesa").setBaseBiome("jungle").setBaseHeight(0.3F).setHeightVariation(0.28F).setTemperature(0.85F).setRainfall(0.2F));



    }


    @Override
    public void plantFlower(World world, Random rand, BlockPos pos) {

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



        return TREE2;


    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = Blocks.RED_SANDSTONE.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.RED_SANDSTONE.getDefaultState(); // zwykle to ziemia
        spawnableCreatureList.clear();

        decorator.treesPerChunk = 4;
        decorator.grassPerChunk = 20;
        decorator.sandPatchesPerChunk = -999;
        decorator.deadBushPerChunk = 20;
        decorator.reedsPerChunk = 3;
        decorator.cactiPerChunk = 5;


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

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        {
            this.topBlock = RED_STAINED_HARDENED_CLAY;
            this.fillerBlock = ORANGE_STAINED_HARDENED_CLAY;

            if (noiseVal > 1.75D) {
                this.topBlock = YELLOW_STAINED_HARDENED_CLAY;
                this.fillerBlock = ORANGE_STAINED_HARDENED_CLAY;
            } else if (noiseVal > -0.95D) {
                this.topBlock = GRASS;
                this.fillerBlock = Blocks.DIRT.getDefaultState();
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




}