package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.entity.EntityGoatFemale;
import com.matez.wildnature.entity.EntityGoatMale;
import com.matez.wildnature.entity.EntityGoatSaanenFemale;
import com.matez.wildnature.entity.EntityGoatSaanenMale;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

public class BiomeOvergrownMountains extends Biome {


    protected static final WorldGenAbstractTree TREE = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());


    public BiomeOvergrownMountains() {
        super(new BiomeProperties("Overgrown Mountains").setBaseHeight(0.7F).setHeightVariation(1.3F).setTemperature(0.85F).setRainfall(0.8F));



    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
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
        topBlock = ModBlocks.ZAROSNIETY_KAMIEN.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.STONE.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = 6;
        decorator.grassPerChunk = 20;
        decorator.sandPatchesPerChunk = -9999;
        decorator.clayPerChunk=-9999;
        decorator.reedsPerChunk=4;
        

        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());


        decorator.flowersPerChunk = 25;

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