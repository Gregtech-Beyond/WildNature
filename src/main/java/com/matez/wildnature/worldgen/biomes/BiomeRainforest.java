package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.BigTree;
import com.matez.wildnature.worldgen.schematics.trees.big.treeGen_bigJungle;
import com.matez.wildnature.worldgen.treeGen_hazel;
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
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

import static com.matez.wildnature.worldgen.biomes.BiomeDeciduousForest.TREE5;

public class BiomeRainforest extends Biome {

    private static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
    private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    protected static final WorldGenAbstractTree TREE = new BigTree(true,16,1,1.0D,Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY,false).withProperty(BlockLeaves.DECAYABLE,false),Blocks.SAPLING.getDefaultState());
    protected static final WorldGenAbstractTree TREE2 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());
    protected static final WorldGenAbstractTree TREE3 = new WorldGenShrub(JUNGLE_LOG,JUNGLE_LEAF);
    //protected static final WorldGenAbstractTree TREE4 = new treeGen_bigJungle(true,JUNGLE_LOG,JUNGLE_LEAF);





    public BiomeRainforest() {
        super(new BiomeProperties("Rainforest").setBaseBiome("jungle").setBaseHeight(0.2F).setHeightVariation(0.5F).setTemperature(0.90F).setRainfall(0.8F));



    }



    @Override
    public int getWaterColorMultiplier() {
        return 0x00ffd8;
    }


    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 6868542 : 1630873);
    }


    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeFoliageColor(noise < -0.1D ? 3258892 : 3589222);
    }


    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {

        switch (Main.generateRandomInt(0,2)){
            case 0:
                return TREE;
            case 1:
                return TREE2;
            case 2:
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

        decorator.treesPerChunk = 20;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 8;
        decorator.clayPerChunk=9;




        decorator.flowersPerChunk = 20;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityParrot.class, 50, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityOcelot.class, 2, 1, 1));
    }
}