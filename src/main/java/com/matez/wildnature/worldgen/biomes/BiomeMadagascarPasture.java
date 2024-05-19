package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.BigTree;
import com.matez.wildnature.worldgen.WorldGenFromFile;
import com.matez.wildnature.worldgen.schematics.other.shrubs.otherGen_shrub1;
import com.matez.wildnature.worldgen.treeGen_mahogany;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockRedFlower;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

public class BiomeMadagascarPasture extends Biome {

    protected static  WorldGenAbstractTree TREE,TREE2,TREE3,TREE4,TREE5;

    public BiomeMadagascarPasture() {
        super(new BiomeProperties("Madagascar Pasture").setBaseHeight(0.2F).setHeightVariation(0.0F).setTemperature(0.40F).setRainfall(0.7F));



    }


    @Override
    public int getWaterColorMultiplier() {
        return 0x00ffd8;
    }

    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x4BC434 : 0x74D455);
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
        TREE = new WorldGenFromFile(true,ModBlocks.BAOBAB_LOG.getDefaultState(),ModBlocks.BAOBAB_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false)),"baobab.txt");;
        TREE2 = new treeGen_mahogany(true);
        TREE3 = new otherGen_shrub1(true, Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());
        TREE4 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());
        TREE5 = new BigTree(true,16,1,1.0D,Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY,false).withProperty(BlockLeaves.DECAYABLE,false),Blocks.SAPLING.getDefaultState());;
        switch (Main.generateRandomInt(0,5)){
            case 0:
                switch (Main.generateRandomInt(0,3)){
                    case 0:
                        return TREE;
                    case 1:
                        return TREE2;
                    case 2:
                        return TREE5;
                    case 3:
                        return TREE3;
                }
            case 1:
                return TREE2;
            case 2:
                return TREE3;
            case 3:
                return TREE4;
            case 4:
                return TREE2;
            case 5:
                return TREE5;
        }
        return TREE2;
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
        topBlock = Blocks.GRASS.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.DIRT.getDefaultState(); // zwykle to ziemia

        decorator.treesPerChunk = 0;
        decorator.grassPerChunk = 20;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;

        decorator.flowers.clear();
        decorator.flowers.add(Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), BlockRedFlower.EnumFlowerType.BLUE_ORCHID),10);
        decorator.flowers.add(ModBlocks.TALLGRASS_FERNSPROUT.getDefaultState(),7);
        decorator.flowers.add(ModBlocks.LEAF_PILE.getDefaultState(),5);
        decorator.flowers.add(Blocks.MELON_STEM.getDefaultState(),4);


        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());
        decorator.generateFalls=false;


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