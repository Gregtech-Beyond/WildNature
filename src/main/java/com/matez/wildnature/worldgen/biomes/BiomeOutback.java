package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.other.shrubs.otherGen_shrubLeaf;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;

import java.util.Random;

import static net.minecraft.block.BlockLeaves.CHECK_DECAY;
import static net.minecraft.block.BlockLeaves.DECAYABLE;

public class BiomeOutback extends Biome {


    public BiomeOutback() {
        super(new BiomeProperties("Outback").setBaseHeight(0.2F).setHeightVariation(0.05F).setTemperature(0.80F).setRainfall(0.1F));



    }


    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xC6B653;
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x98B072;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return new otherGen_shrubLeaf(true,Blocks.LEAVES2.getDefaultState(),Blocks.LEAVES.getDefaultState().withProperty(DECAYABLE,false).withProperty(CHECK_DECAY,false).withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.ACACIA));
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
        topBlock = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND); // zwykle to blok trawy
        fillerBlock = Blocks.DIRT.getDefaultState(); // zwykle to ziemia
        spawnableCreatureList.clear();

        decorator.treesPerChunk = 1;
        decorator.grassPerChunk = 10;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;
        decorator.deadBushPerChunk = 3;
        decorator.cactiPerChunk=4;
        decorator.generateFalls=false;
        decorator.cactiPerChunk=7;
        decorator.flowers.clear();





        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 19, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombieVillager.class, 1, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityHusk.class, 80, 4, 4));
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        int a = Main.generateRandomInt(0,1,rand);
        if(a==0){
            topBlock = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND); // zwykle to blok trawy
        }else{
            topBlock = ModBlocks.DRIED_GRASS_BLOCK.getDefaultState(); // zwykle to blok trawy
        }

        super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}