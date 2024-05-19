package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.entity.EntityDuckChild;
import com.matez.wildnature.entity.EntityDuckFemale;
import com.matez.wildnature.entity.EntityDuckMale;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.BigTree;
import com.matez.wildnature.worldgen.treeGen_pear;
import com.matez.wildnature.worldgen.treeGen_apple;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

public class BiomeAutumnalForest extends Biome {

    private static final IBlockState LOG1 = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
    private static final IBlockState LOG2 = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
    private static final IBlockState LOG3 = ModBlocks.ROTTEN_LOG.getDefaultState();

    private static final IBlockState LEAVESRED = ModBlocks.RED_AUTUMN.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    private static final IBlockState LEAVESORANGE = ModBlocks.ORANGE_AUTUMN.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    private static final IBlockState LEAVESYELLOW = ModBlocks.YELLOW_AUTUMN.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    private static final IBlockState LEAVESROTTEN = ModBlocks.ROTTEN_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

    private static final IBlockState LEAVESOAK = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));



    public BiomeAutumnalForest() {
        super(new BiomeProperties("Autumnal Forest").setBaseHeight(0.2F).setHeightVariation(0.15F).setTemperature(0.4F).setRainfall(0.7F));



    }


    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0xB5B952 : 0xB98959);
    }
    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0xA3A627 : 0x2E9C18);
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        IBlockState LOG = null, LEAVES = null;
        int x = Main.generateRandomInt(1,6, rand);
        if(x<=2){
            LOG = LOG1;
        }else if(x<=5){
            LOG = LOG2;
        }else{
            LOG = LOG3;
        }

        x = Main.generateRandomInt(1,5,rand);
        if(x==1){
            LEAVES = LEAVESRED;
        } else if(x==2){
            LEAVES = LEAVESORANGE;
        } else if(x==3){
            LEAVES = LEAVESYELLOW;
        }else if(x==4){
            LEAVES = LEAVESOAK;
        }else{
            LEAVES = LEAVESROTTEN;
        }

        x = Main.generateRandomInt(1,3,rand);
        WorldGenAbstractTree TREE = null;
        if(x==1){
            TREE = new BigTree(true,8,1,1D,LOG,LEAVES,Blocks.SAPLING.getDefaultState());
        }else{
            TREE = new WorldGenTrees(true,5,LOG,LEAVES,false);
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
        topBlock = ModBlocks.MOLD_GRASS_BLOCK.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.ZIEMA_CZARNOZIEM.getDefaultState(); // zwykle to ziemia

        decorator.treesPerChunk = 6;
        decorator.grassPerChunk = 20;
        decorator.sandPatchesPerChunk = 0;
        decorator.gravelPatchesPerChunk = 8;

        decorator.flowers.clear();
        decorator.flowers.add(ModBlocks.DEAD_LEAF_PILE.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.LEAF_PILE.getDefaultState(),3);
        decorator.flowers.add(ModBlocks.CLOVER.getDefaultState(),5);
        decorator.flowers.add(ModBlocks.WRZOS.getDefaultState(),3);
        decorator.flowers.add(ModBlocks.WRZOS_PINK.getDefaultState(),3);
        decorator.flowers.add(ModBlocks.WRZOS_WHITE.getDefaultState(),3);

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
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 7, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 7, 3, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckChild.class, 1, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 3, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }
}