package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.*;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.treeGen_pine;
import com.matez.wildnature.worldgen.treeGen_pineMini;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockSand;
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

public class BiomeTaigaMountains extends Biome {

    protected static final WorldGenAbstractTree TREE = new treeGen_pine(true);
    protected static final WorldGenAbstractTree TREE2 = new treeGen_pineMini(true);
    protected static final WorldGenAbstractTree TREE3 = new WorldGenTaiga2(true);
    protected static final WorldGenAbstractTree TREE4 = new WorldGenBirchTree(true,true);
    private static final WorldGenTaiga1 PINE_GENERATOR = new WorldGenTaiga1();
    private static final WorldGenTaiga2 SPRUCE_GENERATOR = new WorldGenTaiga2(false);
    private static final WorldGenMegaPineTree MEGA_PINE_GENERATOR = new WorldGenMegaPineTree(false, false);
    private static final WorldGenMegaPineTree MEGA_SPRUCE_GENERATOR = new WorldGenMegaPineTree(false, true);


    public BiomeTaigaMountains() {
        super(new BiomeProperties("Taiga Mountains").setBaseBiome("taiga_mountains").setBaseHeight(0.7F).setHeightVariation(0.69F).setTemperature(0.25F).setRainfall(0.5F));



    }



    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
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
                return PINE_GENERATOR;
            case 5:
                return SPRUCE_GENERATOR;
            case 6:
                return MEGA_PINE_GENERATOR;
            case 7:
                return MEGA_SPRUCE_GENERATOR;


        }

        return TREE;

    }

    @Override
    public void plantFlower(World world, Random rand, BlockPos pos) {

    }





    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();



        decorator.treesPerChunk = 4;
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
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatSaanenMale.class, 1, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatSaanenFemale.class, 1, 1, 2));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }


    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        {
            this.topBlock = ModBlocks.BROWN_GRASS_BLOCK.getDefaultState();
            this.fillerBlock = ModBlocks.ZIEMA_BRUNATNA.getDefaultState();

            if (noiseVal > 2D) {
                    this.topBlock = ModBlocks.BROWN_MYCELIUM.getDefaultState();
            } else if (noiseVal > -0.95D) {
                int a = Main.generateRandomInt(0,1);
                switch (a) {
                    case 0:
                        this.topBlock = ModBlocks.BROWN_PODZOL.getDefaultState();
                    case 1:
                        this.topBlock = ModBlocks.ZIEMA_BRUNATNA.getDefaultState();
                }

            }

            this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
        }


    }


}