package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.*;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.trees.birch.*;
import com.matez.wildnature.worldgen.schematics.trees.fir.*;
import com.matez.wildnature.worldgen.schematics.trees.spruce.*;
import com.matez.wildnature.worldgen.treeGen_pine;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeTatraMountains extends Biome {

    public static IBlockState LOG1 = ModBlocks.PINE_LOG.getDefaultState();
    public static IBlockState LOG2 = ModBlocks.FIR_LOG.getDefaultState();
    public static IBlockState LOG3 = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
    public static IBlockState LOG4 = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);

    public static IBlockState LEAVES1 = ModBlocks.PINE_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState LEAVES2 = ModBlocks.FIR_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState LEAVES3 = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState LEAVES4 = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));


    protected static WorldGenAbstractTree TREE = null,TREE2 = null,TREE3 = null,TREE4 = null,TREE5 = null,TREE6 = null,TREE7 = null,TREE8 = null,TREE9 = null,TREE10 = null,TREE11 = null,TREE12 = null,TREE13 = null,TREE14 = null,TREE15 = null,TREE16 = null,TREE17 = null,TREE18 = null,TREE19 = null,TREE20 = null,TREE21 = null,TREE22 = null;

    protected static IBlockState LOG = null, LEAVES = null;

    protected static  void randomLog(){
        int x = Main.generateRandomInt(1,3);
        if(x==1){
            LOG = LOG1;
            LEAVES = LEAVES1;
        }else if(x==2){
            LOG = LOG2;
            LEAVES = LEAVES2;
        }else if(x==3){
            LOG = LOG3;
            LEAVES = LEAVES3;
        }
    }
    protected static void randomTrees(){

        randomLog();
        TREE = new treeGen_taiga1(true,LOG,LEAVES);
        randomLog();
        TREE2 = new treeGen_taiga2(true,LOG,LEAVES);
        randomLog();
        TREE3 = new treeGen_taiga4(true,LOG,LEAVES);
        randomLog();
        TREE4 = new treeGen_taiga5(true,LOG,LEAVES);
        randomLog();
        TREE5= new treeGen_taiga8(true,LOG,LEAVES);
        randomLog();
        TREE6= new treeGen_taiga9(true,LOG,LEAVES);
        randomLog();
        TREE7= new treeGen_taiga18(true,LOG,LEAVES);
        randomLog();
        TREE8= new treeGen_taiga17(true,LOG,LEAVES);
        randomLog();
        TREE9= new treeGen_taiga16(true,LOG,LEAVES);
        randomLog();
        TREE10= new treeGen_taiga14(true,LOG,LEAVES);
        randomLog();
        TREE11= new treeGen_fir13(true,LOG,LEAVES);
        randomLog();
        TREE12= new treeGen_fir9(true,LOG,LEAVES);
        randomLog();
        TREE13= new treeGen_fir7(true,LOG,LEAVES);
        randomLog();
        TREE14= new treeGen_fir20(true,LOG,LEAVES);
        randomLog();
        TREE15= new treeGen_fir19(true,LOG,LEAVES);
        TREE16= new treeGen_pine(true);
        TREE15= new treeGen_fir19(true,LOG,LEAVES);
        TREE17= new treeGen_birch1(true,LOG4,LEAVES4);
        TREE18= new treeGen_birch2(true,LOG4,LEAVES4);
        TREE19= new treeGen_birch7(true,LOG4,LEAVES4);
        TREE20= new treeGen_birch10(true,LOG4,LEAVES4);
        TREE21= new treeGen_birch11(true,LOG4,LEAVES4);
        TREE22= new treeGen_birch12(true,LOG4,LEAVES4);
    }


    public BiomeTatraMountains() {
        super(new BiomeProperties("Tatra Mountains").setBaseHeight(2.7F).setHeightVariation(0.3F).setTemperature(0.3F).setRainfall(0.3F).setSnowEnabled());


    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        randomTrees();
        int x = Main.generateRandomInt(1,22);
        switch(x){
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
            case 7:
                return TREE7;
            case 8:
                return TREE8;
            case 9:
                return TREE9;
            case 10:
                return TREE10;
            case 11:
                return TREE11;
            case 12:
                return TREE12;
            case 13:
                return TREE13;
            case 14:
                return TREE14;
            case 15:
                return TREE15;
            case 16:
                return TREE16;
            case 17:
                return TREE17;
            case 18:
                return TREE18;
            case 19:
                return TREE19;
            case 20:
                return TREE20;
            case 21:
                return TREE21;
            case 22:
                return TREE22;
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
        topBlock = ModBlocks.BROWN_GRASS_BLOCK.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.ZIEMA_BRUNATNA.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = 2;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;
        /*decorator.flowers.add(ModBlocks.WRZOS.getDefaultState());
        decorator.flowers.add(ModBlocks.DZWONECZEK.getDefaultState());
        decorator.flowers.add(ModBlocks.SASANKA.getDefaultState());
        decorator.flowers.add(ModBlocks.MALA_TRAWA.getDefaultState());
        decorator.flowers.add(ModBlocks.TALLGRASS_THISTLE.getDefaultState());
        decorator.flowers.add(ModBlocks.CLOVER.getDefaultState());
        decorator.flowers.add(Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.FERN));
        decorator.flowers.add(Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.FERN));
        decorator.flowers.add(Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.GRASS));*/

        decorator.flowers.clear();
        decorator.flowers.add(ModBlocks.WRZOS.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.DZWONECZEK.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.SASANKA.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.MALA_TRAWA.getDefaultState(),40);
        decorator.flowers.add(ModBlocks.TALLGRASS_THISTLE.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.CLOVER.getDefaultState(),10);
        decorator.flowers.add(Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.FERN),25);
        decorator.flowers.add(Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.FERN),30);;
        decorator.flowers.add(Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.GRASS),30);;


        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());



        decorator.flowersPerChunk = 30;

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



}