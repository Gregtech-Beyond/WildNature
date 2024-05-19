package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.*;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.treeGen_pine;
import com.matez.wildnature.worldgen.treeGen_pineMini;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

import java.util.Random;

public class BiomeFrozenMountains extends Biome {



    public BiomeFrozenMountains() {
        super(new BiomeProperties("Frozen Mountains").setBaseHeight(5F).setHeightVariation(0.3F).setTemperature(0F).setRainfall(0.3F).setSnowEnabled());



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
        topBlock = Blocks.SNOW.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.PACKED_ICE.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = 0;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;


        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 5, 3, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 10, 1, 3));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 6, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));

        decorator.flowersPerChunk = 20;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 3, 2, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatSaanenMale.class, 1, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatSaanenFemale.class, 1, 1, 2));
    }


}