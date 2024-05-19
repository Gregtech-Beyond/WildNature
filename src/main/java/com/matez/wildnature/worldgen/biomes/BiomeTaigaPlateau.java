package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.trees.fir.*;
import com.matez.wildnature.worldgen.schematics.trees.spruce.treeGen_bigSpruce1;
import com.matez.wildnature.worldgen.schematics.trees.spruce.treeGen_bigSpruce2;
import com.matez.wildnature.worldgen.schematics.trees.spruce.treeGen_bigSpruce3;
import com.matez.wildnature.worldgen.schematics.trees.spruce.treeGen_bigSpruce4;
import com.matez.wildnature.worldgen.treeGen_pine;
import com.matez.wildnature.worldgen.treeGen_pineMini;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class BiomeTaigaPlateau extends Biome {

    public static IBlockState LOG1 = ModBlocks.PINE_LOG.getDefaultState();
    public static IBlockState LOG2 = ModBlocks.FIR_LOG.getDefaultState();
    public static IBlockState LOG3 = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);

    public static IBlockState LEAVES1 = ModBlocks.PINE_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState LEAVES2 = ModBlocks.FIR_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState LEAVES3 = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

    protected static WorldGenAbstractTree TREE = null,TREE2 = null,TREE3 = null,TREE4 = null,TREE5 = null,TREE6 = null,TREE7 = null,TREE8 = null;
    public BiomeTaigaPlateau() {
        super(new BiomeProperties("Taiga Plateau").setBaseBiome("pine_forest").setBaseHeight(0.3F).setHeightVariation(0.025F).setTemperature(0.25F).setRainfall(0.6F));



    }


    protected static IBlockState LOG , LEAVES;

    protected static  void randomLog(){
        int x = Main.generateRandomInt(1,3);
        if(x==1){
            LOG = LOG1;
            LEAVES = LEAVES1;
        }else if(x==2){
            LOG = LOG2;
            LEAVES = LEAVES2;
        }else if(x==3){
            LOG = LOG3;
            LEAVES = LEAVES3;
        }
    }
    protected static void randomTrees(){


        randomLog();
        TREE = new treeGen_fir19(true,LOG,LEAVES);
        randomLog();
        TREE2 = new treeGen_fir11(true,LOG,LEAVES);
        randomLog();
        TREE3 = new treeGen_fir12(true,LOG,LEAVES);
        randomLog();
        TREE4 = new treeGen_fir15(true,LOG,LEAVES);
        randomLog();
        TREE5 = new treeGen_fir32(true,LOG,LEAVES);
        randomLog();
        TREE6 = new treeGen_fir30(true,LOG,LEAVES);
        randomLog();
        TREE7 = new treeGen_fir16(true,LOG,LEAVES);
        randomLog();
        TREE8 = new treeGen_fir31(true,LOG,LEAVES);


    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        randomTrees();

        int a = Main.generateRandomInt(0,7);
        switch (a){
            case 0:
                 return TREE;
            case 1:
                return TREE2;
            case 2:
                return TREE3;
            case 3:
                return TREE4;
            case 4:
                return TREE5;
            case 5:
                return TREE6;
            case 6:
                return TREE7;
            case 7:
                return TREE8;
        }

        return TREE;

    }

    @Override
    public void plantFlower(World world, Random rand, BlockPos pos) {

    }





    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();



        decorator.treesPerChunk = 2;
        decorator.grassPerChunk = 20;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=1;
        decorator.flowers.add(ModBlocks.WRZOS.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.WRZOS_PINK.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.WRZOS_WHITE.getDefaultState(),10);


        decorator.flowersPerChunk = 5;

        return getModdedBiomeDecorator(decorator);
    }
    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 5, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 5, 3, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 3, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 2, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        {
            this.topBlock = Blocks.GRASS.getDefaultState();
            this.fillerBlock = Blocks.DIRT.getDefaultState();

            if (noiseVal > 2D) {

            } else if (noiseVal > -0.95D) {
                int a = Main.generateRandomInt(0,1);
                switch (a) {
                    case 0:
                        this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
                    case 1:
                        this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
                }

            }

            this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
        }


    }


}