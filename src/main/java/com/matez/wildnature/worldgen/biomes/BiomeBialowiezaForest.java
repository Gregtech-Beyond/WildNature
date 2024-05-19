package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.*;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.trees.bialowieza.*;
import com.matez.wildnature.worldgen.schematics.trees.birch.*;
import com.matez.wildnature.worldgen.treeGen_beech;
import com.matez.wildnature.worldgen.treeGen_miniTree;
import com.matez.wildnature.worldgen.treeGen_rowan;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

public class BiomeBialowiezaForest extends Biome {

    public static IBlockState LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
    public static IBlockState LEAVES = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState PINE_LOG = ModBlocks.PINE_LOG.getDefaultState();
    public static IBlockState PINE_LEAVES = ModBlocks.PINE_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState DARKLOG = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
    public static IBlockState DARKLEAVES = Blocks.LEAVES2.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

    protected static WorldGenAbstractTree TREE = null,TREE2 = null,TREE3 = null,TREE4,TREE5,TREE6,TREE7,TREE8,TREE9,TREE10,TREE11,TREE12,TREE13,TREE14,TREE15;




    public BiomeBialowiezaForest() {
        super(new BiomeProperties("The Bialowieza Forest").setBaseHeight(0.1F).setHeightVariation(0.025F).setTemperature(0.30F).setRainfall(0.6F));



    }

    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x458547 : 0x539855);
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        int x = Main.generateRandomInt(1,6);
        switch (x){
            case 1:
                return new treeGen_bialowiezaTree1(true,DARKLOG,LEAVES);
            case 2:
                return new treeGen_bialowiezaTree2(true,DARKLOG,LEAVES);
            case 3:
                return new treeGen_bialowiezaTree3(true,DARKLOG,LEAVES);
            case 4:
                return new treeGen_bialowiezaTree4(true,DARKLOG,LEAVES);
            case 5:
                return new treeGen_bialowiezaTree5(true,DARKLOG,LEAVES);
            case 6:
                return new WorldGenShrub(DARKLOG,LEAVES);

        }



        return null;
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

        decorator.treesPerChunk = 6;
        decorator.grassPerChunk = 5;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;

        decorator.flowers.clear();
        decorator.flowers.add(Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.FERN),15);
        decorator.flowers.add(Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.GRASS),11);
        decorator.flowers.add(Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.SYRINGA),2);
        decorator.flowers.add(Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.FERN),20);
        decorator.flowers.add(Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), BlockRedFlower.EnumFlowerType.HOUSTONIA),4);
        decorator.flowers.add(Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), BlockRedFlower.EnumFlowerType.ALLIUM),5);

        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());



        addDefaultFlowers();
        decorator.flowersPerChunk = 25;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWisentMale.class, 3, 2, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWisentFemale.class, 3, 2, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWisentChild.class, 3, 1, 1));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 4, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckMale.class, 6, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckFemale.class, 6, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckChild.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 2, 2, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityForester.class, 7, 1, 1));
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        int a = Main.generateRandomInt(0,16,rand);
        if(a==0){
            topBlock = Blocks.WATER.getDefaultState();
        }else{
            topBlock = ModBlocks.BROWN_GRASS_BLOCK.getDefaultState(); // zwykle to blok trawy
        }

        super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}