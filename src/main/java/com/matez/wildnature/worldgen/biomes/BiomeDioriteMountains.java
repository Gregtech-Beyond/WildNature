package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.*;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.treeGen_pine;
import com.matez.wildnature.worldgen.treeGen_pineMini;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

import java.util.Random;

public class BiomeDioriteMountains extends Biome {

    protected static final WorldGenAbstractTree TREE = new treeGen_pine(true);


    public BiomeDioriteMountains() {
        super(new BiomeProperties("Diorite Mountains").setBaseHeight(2.5F).setHeightVariation(0.2F).setTemperature(0.3F).setRainfall(0.3F).setSnowEnabled());



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
        topBlock = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE); // zwykle to blok trawy
        fillerBlock = Blocks.STONE.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = -9999;
        decorator.grassPerChunk = -9999;
        decorator.sandPatchesPerChunk = -9999;
        decorator.clayPerChunk=-9999;



        decorator.flowersPerChunk = -9999;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatSaanenMale.class, 1, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatSaanenFemale.class, 1, 1, 2));

    }


}