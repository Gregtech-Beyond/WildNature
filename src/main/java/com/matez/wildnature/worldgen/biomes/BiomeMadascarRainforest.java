package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.*;
import com.matez.wildnature.worldgen.schematics.other.shrubs.otherGen_shrub1;
import com.matez.wildnature.worldgen.schematics.trees.big.treeGen_bigJungle;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

public class BiomeMadascarRainforest extends Biome {

    private static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
    private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    protected static  WorldGenAbstractTree TREE,TREE2,TREE3,TREE4,TREE5,TREE6,TREE7,TREE8;





    public BiomeMadascarRainforest() {
        super(new BiomeProperties("Madagascar Rainforest").setBaseBiome("madagascar_pasture").setBaseHeight(0.1F).setHeightVariation(0.05F).setTemperature(0.90F).setRainfall(0.8F));



    }



    @Override
    public int getWaterColorMultiplier() {
        return 0x00ffd8;
    }


    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x78C435 : 0x5FD413);
    }


    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeFoliageColor(noise < -0.1D ? 0x72D624 : 0x92DD29);
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0x93EBD7;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {

        TREE = new BigTree(true,16,1,1.0D,Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY,false).withProperty(BlockLeaves.DECAYABLE,false),Blocks.SAPLING.getDefaultState());;
        TREE2 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());
        TREE4 = new otherGen_shrub1(true,Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());
        TREE3 = new WorldGenShrub(JUNGLE_LOG,JUNGLE_LEAF);
        TREE5 = new treeGen_mahogany(true);
        TREE6 = new treeGen_ebony(true);
        TREE7 = new treeGen_bigEucalyptus(true);
        TREE8 = new WorldGenFromFile(true,ModBlocks.BAOBAB_LOG.getDefaultState(),ModBlocks.BAOBAB_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)),"baobab.txt");

        int x = Main.generateRandomInt(0,60);
        if(x<10){
            return TREE;
        }else if(x>=10 && x<20){
            switch (Main.generateRandomInt(0,1)){
                case 0:
                    return TREE2;
                case 1:
                    return TREE3;
            }
        }else if(x>=20 && x<30){
            return TREE4;
        }else if(x>=30 && x<50){
            return TREE5;
        }else if(x>=50 && x<55){
            return TREE6;
        }else if(x>=55 && x<60){
            return TREE7;
        }
        else{
            return TREE8;
        }



        return TREE4;
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

        decorator.treesPerChunk = 4;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 8;
        decorator.clayPerChunk=9;

        decorator.flowers.clear();
        decorator.flowers.add(Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), BlockRedFlower.EnumFlowerType.BLUE_ORCHID),10);
        decorator.flowers.add(ModBlocks.TALLGRASS_FERNSPROUT.getDefaultState(),7);
        decorator.flowers.add(ModBlocks.LEAF_PILE.getDefaultState(),5);
        decorator.flowers.add(Blocks.MELON_STEM.getDefaultState(),4);



        decorator.flowersPerChunk = 15;


        this.spawnableCreatureList.add(new SpawnListEntry(EntityParrot.class, 50, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));


        return getModdedBiomeDecorator(decorator);
    }


}