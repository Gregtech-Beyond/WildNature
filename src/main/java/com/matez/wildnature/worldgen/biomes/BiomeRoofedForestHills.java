package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.trees.oak.*;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

import java.util.Random;

public class BiomeRoofedForestHills extends Biome {


    public static IBlockState LOG = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
    public static IBlockState LEAVES = Blocks.LEAVES2.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

    protected static WorldGenAbstractTree TREE = null,TREE2 = null,TREE3 = null,TREE4 = null,TREE5 = null,TREE6 = null,TREE7 = null,TREE8 = null,TREE9 = null,TREE10 = null,TREE11 = null,TREE12 = null,TREE13 = null,TREE14 = null,TREE15 = null,TREE16 = null,TREE17 = null,TREE18 = null,TREE19 = null,TREE20 = null,TREE21 = null,TREE22 = null;


    public BiomeRoofedForestHills() {
        super(new BiomeProperties("Roofed Forest Cliffs").setBaseHeight(1F).setHeightVariation(1.1F).setTemperature(0.70F).setRainfall(0.8F));



    }

    public int getGrassColorAtPos(BlockPos pos)
    {

        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x35A623 : 0x5CB522);
    }

    public int getFoliageColorAtPos(BlockPos pos)
    {

        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x4ACB1B : 0x25B738);
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        TREE = new treeGen_oak4(true,LOG,LEAVES);
        TREE2 = new treeGen_oak8(true,LOG,LEAVES);
        TREE3 = new treeGen_oak9(true,LOG,LEAVES);
        TREE4 = new treeGen_oak10(true,LOG,LEAVES);
        TREE5 = new treeGen_oak11(true,LOG,LEAVES);
        TREE6 = new treeGen_oak13(true,LOG,LEAVES);
        TREE7 = new treeGen_oak2(true,LOG,LEAVES);
        TREE8 = new treeGen_oak3(true,LOG,LEAVES);
        TREE9 = new treeGen_oak22(true,LOG,LEAVES);
        TREE10 = new treeGen_oak5(true,LOG,LEAVES);
        TREE11 = new treeGen_oak6(true,LOG,LEAVES);

        int x = Main.generateRandomInt(1,11,rand);
        switch (x){
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

        decorator.treesPerChunk = 5;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;
        decorator.flowers.clear();
        decorator.bigMushroomsPerChunk = 2;

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


        decorator.flowersPerChunk = 35;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 7, 4, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 7, 3, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 3, 1, 3));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }
}