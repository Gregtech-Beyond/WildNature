package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

public class BiomeTundra extends Biome {

    public static IBlockState LOG1 = ModBlocks.BEECH_LOG.getDefaultState();
    public static IBlockState LOG2 = ModBlocks.FIR_LOG.getDefaultState();
    public static IBlockState LOG3 = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
    public static IBlockState LOG4 = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);


    public static IBlockState LEAVES1 = ModBlocks.BEECH_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState LEAVES2 = ModBlocks.FIR_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState LEAVES3 = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState LEAVES4 = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));



    protected static WorldGenAbstractTree TREE = null,TREE2 = null,TREE3 = null,TREE4 = null,TREE5 = null,TREE6 = null,TREE7= null,TREE8=null,TREE9=null,TREE10=null;

    protected static IBlockState LOG = null, LEAVES = null;




    public BiomeTundra() {
        super(new BiomeProperties("Tundra").setBaseHeight(0.2F).setHeightVariation(0.05F).setTemperature(0.25F).setRainfall(0.4F));

    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x7F6732;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {

        TREE= new treeGen_birch1(true,LOG4,LEAVES4);
        TREE2= new treeGen_birch2(true,LOG4,LEAVES4);
        TREE3= new treeGen_birch7(true,LOG4,LEAVES4);
        TREE4= new treeGen_birch10(true,LOG4,LEAVES4);
        TREE5= new treeGen_birch11(true,LOG4,LEAVES4);
        TREE6= new treeGen_birch12(true,LOG4,LEAVES4);
        TREE7= new WorldGenShrub(LOG4,LEAVES4);
        TREE8= new treeGen_birch10(true,LOG1,LEAVES1);
        TREE9= new treeGen_birch11(true,LOG1,LEAVES1);
        TREE10= new treeGen_birch12(true,LOG1,LEAVES1);


        int x = Main.generateRandomInt(1,25);
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
                return TREE7;
            case 12:
                return TREE7;
            case 13:
                return TREE7;
            case 14:
                return TREE7;
            case 15:
                return TREE7;
            case 16:
                return TREE7;
            case 17:
                return TREE7;
            case 18:
                return TREE7;
            case 19:
                return TREE7;
            case 20:
                return TREE7;
            case 21:
                return TREE7;
            case 22:
                return TREE7;
            case 23:
                return TREE7;
            case 24:
                return TREE7;
            case 25:
                return TREE7;
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


        decorator.treesPerChunk = 1;
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
        decorator.flowers.add(ModBlocks.WRZOS_PINK.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.WRZOS_WHITE.getDefaultState(),10);
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
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 4, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 5, 3, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 3, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 2, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }


}