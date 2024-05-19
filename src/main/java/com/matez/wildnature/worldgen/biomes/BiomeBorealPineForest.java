package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.trees.pine.*;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeBorealPineForest extends Biome {

    protected static final IBlockState LEAVES = ModBlocks.PINE_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY,false).withProperty(BlockLeaves.DECAYABLE,false);
    protected static final IBlockState LOG = ModBlocks.PINE_LOG.getDefaultState();
    protected static final WorldGenAbstractTree TREE = new treeGen_pine1(true,LOG,LEAVES);
    protected static final WorldGenAbstractTree TREE2 = new treeGen_pine2(true,LOG,LEAVES);
    protected static final WorldGenAbstractTree TREE3 = new treeGen_pine3(true,LOG,LEAVES);
    protected static final WorldGenAbstractTree TREE4 = new treeGen_pine4(true,LOG,LEAVES);
    protected static final WorldGenAbstractTree TREE5 = new treeGen_pine5(true,LOG,LEAVES);
    protected static final WorldGenAbstractTree TREE6 = new treeGen_pine6(true,LOG,LEAVES);


    public BiomeBorealPineForest() {
        super(new BiomeProperties("Boreal Forest").setBaseHeight(0.1F).setHeightVariation(0.15F).setTemperature(0.20F).setRainfall(0.4F));



    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        switch (Main.generateRandomInt(1,6,rand)){
            case 1:
                return TREE;
            case 2:
                return TREE2;
            case 3:
                return TREE3;
            case 4:
                return TREE4;
            case 5:
                return TREE5;
            case 6:
                return TREE6;
        }
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
        topBlock = ModBlocks.BROWN_PODZOL.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.ZIEMA_BRUNATNA.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = 14;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;

        decorator.flowers.add(ModBlocks.WRZOS.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.WRZOS_PINK.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.WRZOS_WHITE.getDefaultState(),10);
        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());



        decorator.flowersPerChunk = 20;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 5, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 5, 3, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBoar.class, 3, 1, 3));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 2, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }
}