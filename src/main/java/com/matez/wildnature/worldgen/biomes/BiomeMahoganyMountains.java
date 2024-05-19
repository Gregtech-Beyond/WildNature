package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.trees.big.treeGen_bigJungle;
import com.matez.wildnature.worldgen.treeGen_mahogany;
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
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

public class BiomeMahoganyMountains extends Biome {

    private static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
    private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    protected static  WorldGenAbstractTree TREE2 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());
    protected static  WorldGenAbstractTree TREE3 = new WorldGenShrub(JUNGLE_LOG,JUNGLE_LEAF);
    protected static  WorldGenAbstractTree TREE4 = new treeGen_bigJungle(true,JUNGLE_LOG,JUNGLE_LEAF);





    public BiomeMahoganyMountains() {
        super(new BiomeProperties("Mahogany Cliffs").setBaseBiome("mahogany_rainforest").setBaseHeight(1F).setHeightVariation(1.2F).setTemperature(0.90F).setRainfall(0.8F));



    }



    @Override
    public int getWaterColorMultiplier() {
        return 0x00ffd8;
    }


    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x89D036 : 0x81D417);
    }


    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeFoliageColor(noise < -0.1D ? 0x72D624 : 0x92DD29);
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0xB1EB7D;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {

        TREE2 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());;
        TREE3 = new WorldGenShrub(JUNGLE_LOG,JUNGLE_LEAF);
        TREE4 = new treeGen_mahogany(true);

        switch (Main.generateRandomInt(1,4)){
            case 1:
                return TREE4;
            case 2:
                return TREE2;
            case 3:
                return TREE4;
            case 4:
                return TREE3;


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
        topBlock = ModBlocks.ZAROSNIETY_KAMIEN.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.STONE.getDefaultState(); // zwykle to ziemia

        decorator.treesPerChunk = 10;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 8;
        decorator.clayPerChunk=9;

        decorator.flowers.clear();
        decorator.flowers.add(Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), BlockRedFlower.EnumFlowerType.BLUE_ORCHID),10);
        decorator.flowers.add(ModBlocks.TALLGRASS_FERNSPROUT.getDefaultState(),7);
        decorator.flowers.add(ModBlocks.LEAF_PILE.getDefaultState(),5);
        decorator.flowers.add(Blocks.MELON_STEM.getDefaultState(),4);



        decorator.flowersPerChunk = 15;

        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityParrot.class, 50, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 5, 4, 4));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityOcelot.class, 2, 1, 1));


        return getModdedBiomeDecorator(decorator);
    }


}