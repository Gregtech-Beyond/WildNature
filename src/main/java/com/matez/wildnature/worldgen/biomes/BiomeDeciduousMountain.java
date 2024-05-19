package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.entity.EntityDuckChild;
import com.matez.wildnature.entity.EntityDuckFemale;
import com.matez.wildnature.entity.EntityDuckMale;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.trees.birch.*;
import com.matez.wildnature.worldgen.treeGen_beech;
import com.matez.wildnature.worldgen.treeGen_miniTree;
import com.matez.wildnature.worldgen.treeGen_rowan;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

public class BiomeDeciduousMountain extends Biome {

    public static IBlockState LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
    public static IBlockState LEAVES = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState DARKLOG = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
    public static IBlockState DARKLEAVES = Blocks.LEAVES2.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState BIRCHLOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
    public static IBlockState BIRCHLEAVES = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));


    protected static WorldGenAbstractTree TREE = null,TREE2 = null,TREE3 = null,TREE4,TREE5,TREE6,TREE7,TREE8,TREE9,TREE10,TREE11,TREE12,TREE13,TREE14,TREE15;




    public BiomeDeciduousMountain() {
        super(new BiomeProperties("Deciduous Mountain").setBaseHeight(1F).setHeightVariation(0.8F).setTemperature(0.40F).setRainfall(0.4F));



    }

    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 7190528 : 6854678);
    }


    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeFoliageColor(noise < -0.1D ? 6994176 : 10279424);
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        TREE = new treeGen_birch10(true,LOG,LEAVES);
        TREE2 = new treeGen_birch1(true,LOG,LEAVES);
        TREE3 = new WorldGenShrub(LOG,LEAVES);
        TREE4 = new treeGen_birch10(true,DARKLOG,DARKLEAVES);
        TREE5 = new treeGen_birch1(true,DARKLOG,DARKLEAVES);
        //
        TREE6= new treeGen_birch1(true,BIRCHLOG,BIRCHLEAVES);
        TREE7= new treeGen_birch2(true,BIRCHLOG,BIRCHLEAVES);
        TREE8= new treeGen_birch7(true,BIRCHLOG,BIRCHLEAVES);
        TREE9= new treeGen_birch10(true,BIRCHLOG,BIRCHLEAVES);
        TREE10= new treeGen_birch11(true,BIRCHLOG,BIRCHLEAVES);
        TREE11= new treeGen_birch12(true,BIRCHLOG,BIRCHLEAVES);
        //


        switch(Main.generateRandomInt(0,2,rand)){
            case 0:{
                switch (Main.generateRandomInt(0,1,rand)){
                    case 0:{
                        return TREE;
                    }
                    case 1:{
                        return TREE2;
                    }

                }
            }
            case 1:{
                switch (Main.generateRandomInt(0,2,rand)){
                    case 0:{
                        return TREE4;
                    }
                    case 1:{
                        return TREE5;
                    }
                    case 2:{
                        return TREE3;
                    }
                }
            }
            case 2:{
                switch (Main.generateRandomInt(0,5,rand)){
                    case 0:{
                        return TREE6;
                    }
                    case 1:{
                        return TREE7;
                    }
                    case 2:{
                        return TREE8;
                    }
                    case 3:{
                        return TREE9;
                    }
                    case 4:{
                        return TREE10;
                    }
                    case 5:{
                        return TREE11;
                    }
                }
            }


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

        decorator.treesPerChunk = 6;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 6;
        decorator.clayPerChunk=0;


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
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 7, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 7, 3, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBoar.class, 3, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckChild.class, 1, 1, 2));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }
}