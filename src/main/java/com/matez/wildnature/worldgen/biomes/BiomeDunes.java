package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.BlockLeaves;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;

import java.util.Random;

public class BiomeDunes extends Biome {

    protected static final WorldGenAbstractTree TREE = new WorldGenBigTree(true);

    public BiomeDunes() {
        super(new BiomeProperties("Dunes").setBaseHeight(1F).setHeightVariation(0.3F).setTemperature(0.90F).setRainfall(0.4F));



    }


    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xA3B650;
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
        topBlock = Blocks.SAND.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.SANDSTONE.getDefaultState(); // zwykle to ziemia
        spawnableCreatureList.clear();

        decorator.treesPerChunk = -9999;
        decorator.grassPerChunk = -9999;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;
        decorator.deadBushPerChunk = 5;
        decorator.cactiPerChunk=4;
        decorator.flowers.clear();
        decorator.flowers.add(ModBlocks.DEAD_SHORT_GRASS.getDefaultState(),5);
        decorator.flowers.add(ModBlocks.DESERT_GRASS.getDefaultState(),12 );
        decorator.flowers.add(Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false)),4);

        

        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());


        decorator.flowersPerChunk = 40;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombie.class, 19, 4, 4));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 1, 1, 1));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityHusk.class, 80, 4, 4));
    }
}