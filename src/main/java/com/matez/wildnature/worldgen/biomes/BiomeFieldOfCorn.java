package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.blocks.FloweringTallGrass;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.WorldGenCornGrass;
import com.matez.wildnature.worldgen.WorldGenGrass;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockGrassPath;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeFieldOfCorn extends Biome {

    protected static final WorldGenAbstractTree TREE = new WorldGenBigTree(true);

    public BiomeFieldOfCorn() {
        super(new BiomeProperties("Field Of Corn").setBaseBiome("grasslands").setBaseHeight(0.2F).setHeightVariation(0.0F).setTemperature(0.60F).setRainfall(0.6F));



    }


    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xAAC82B;
    }
    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x7BBE37;
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
    public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {
        return new WorldGenCornGrass(ModBlocks.CORN_BUSH.getDefaultState());
    }


    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT); // zwykle to blok trawy
        fillerBlock = ModBlocks.ZIEMA_BRUNATNA.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = -9999;
        decorator.grassPerChunk = 32;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;
        decorator.generateFalls=false;

        decorator.flowers.clear();
        decorator.flowers.add(ModBlocks.TALLGRASS_WHEAT.getDefaultState(),15);
        decorator.flowers.add(ModBlocks.TALLGRASS_FLOWER.getDefaultState(),8);
        decorator.flowers.add(ModBlocks.CLOVER.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.STOKROTKA.getDefaultState(),7);
        decorator.flowers.add(Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS),75);
        

        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());


        decorator.flowersPerChunk = 50;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT); // zwykle to blok trawy
        fillerBlock = ModBlocks.ZIEMA_BRUNATNA.getDefaultState(); // zwykle to ziemia
        if (noiseVal > 1.55D) {
            topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT); // zwykle to blok trawy
            fillerBlock = ModBlocks.ZIEMA_BRUNATNA.getDefaultState(); // zwykle to ziemia
        } else if (noiseVal > -0.95D) {
            topBlock = ModBlocks.BROWN_GRASS_BLOCK.getDefaultState();
            fillerBlock = ModBlocks.ZIEMA_BRUNATNA.getDefaultState();
        }
        super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}