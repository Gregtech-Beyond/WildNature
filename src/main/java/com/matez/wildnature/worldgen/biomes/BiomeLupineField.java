package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.blocks.FloweringTallGrass;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.WorldGenGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeLupineField extends Biome {

    protected static final WorldGenAbstractTree TREE = new WorldGenBigTree(true);

    public BiomeLupineField() {
        super(new BiomeProperties("Lupine Field").setBaseBiome("plains").setBaseHeight(0.2F).setHeightVariation(0.0F).setTemperature(0.40F).setRainfall(0.4F));



    }


    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x92CB14;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return TREE;
    }

    @Override
    public void plantFlower(World world, Random rand, BlockPos pos) {

    }


    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand) {
        return new WorldGenGrass(ModBlocks.LUPINE_YELLOW.getDefaultState().withProperty(FloweringTallGrass.FLOWERING,true));
    }

    /**
     * Gets the flower list.
     *
     * @return the flower list
     */





    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecoratorFlowerField decorator = new BiomeDecoratorFlowerField();
        topBlock = ModBlocks.BROWN_GRASS_BLOCK.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.ZIEMA_BRUNATNA.getDefaultState(); // zwykle to ziemia

        decorator.grass.add(ModBlocks.LUPINE_YELLOW.getDefaultState().withProperty(FloweringTallGrass.FLOWERING,true));
        decorator.grass.add(ModBlocks.TALLGRASS_WHEAT.getDefaultState().withProperty(FloweringTallGrass.FLOWERING,false));
        decorator.grass.add(Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS));
        decorator.grass.add(ModBlocks.LUPINE_YELLOW.getDefaultState().withProperty(FloweringTallGrass.FLOWERING,true));

        decorator.treesPerChunk = 0;
        decorator.grassPerChunk = 25;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;

        decorator.flowers.clear();
        decorator.flowers.add(ModBlocks.LUPINE_BLUE.getDefaultState(),15);
        decorator.flowers.add(ModBlocks.TALLGRASS_FLOWER.getDefaultState(),8);
        decorator.flowers.add(ModBlocks.CLOVER.getDefaultState(),10);
        decorator.flowers.add(ModBlocks.STOKROTKA.getDefaultState(),7);


        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());
        decorator.generateFalls=false;


        decorator.flowersPerChunk = 10;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 7, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 7, 3, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 3, 1, 3));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }
}