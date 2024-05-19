package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.blocks.FloweringTallGrass;
import com.matez.wildnature.entity.*;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.WorldGenFlower;
import com.matez.wildnature.worldgen.WorldGenGrass;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class BiomePrairie extends Biome {

    protected static final WorldGenAbstractTree TREE = new WorldGenBigTree(true);

    public BiomePrairie() {
        super(new BiomeProperties("Prairie").setBaseBiome("grasslands").setBaseHeight(0.2F).setHeightVariation(0.05F).setTemperature(0.50F).setRainfall(0.4F));



    }


    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xAAC82B;
    }
    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x7BBE37;
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
    public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {
        return new WorldGenGrass(ModBlocks.WILD_WHEAT.getDefaultState().withProperty(FloweringTallGrass.FLOWERING,true));
    }


    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = ModBlocks.BROWN_GRASS_BLOCK.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.ZIEMA_BRUNATNA.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = -9999;
        decorator.grassPerChunk = 25;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;

        decorator.flowers.clear();
        decorator.flowers.add(ModBlocks.TALLGRASS_WHEAT.getDefaultState(),15);
        decorator.flowers.add(ModBlocks.TALLGRASS_FLOWER.getDefaultState(),8);
        decorator.flowers.add(ModBlocks.CLOVER.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.STOKROTKA.getDefaultState(),7);
        decorator.flowers.add(Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS),15);
        

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
        this.spawnableCreatureList.clear();
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 7, 4, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBisonMale.class, 4, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBisonFemale.class, 4, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBisonChild.class, 2, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 7, 3, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckChild.class, 1, 1, 2));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 3, 1, 3));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }


}