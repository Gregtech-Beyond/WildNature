package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.blocks.FloweringTallGrass;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.entity.EntityDuckChild;
import com.matez.wildnature.entity.EntityDuckFemale;
import com.matez.wildnature.entity.EntityDuckMale;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.WorldGenGrass;
import com.matez.wildnature.worldgen.treeGen_bigJacaranda;
import com.matez.wildnature.worldgen.treeGen_jacaranda;
import com.matez.wildnature.worldgen.treeGen_sekwoja;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockRedFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.ArrayList;
import java.util.Random;

public class BiomePurpleFields extends Biome {

    protected static final WorldGenAbstractTree TREE = new treeGen_bigJacaranda(true);

    public BiomePurpleFields() {
        super(new BiomeProperties("Purple Field").setBaseHeight(0.2F).setHeightVariation(0.0F).setTemperature(0.40F).setRainfall(0.4F));



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



    /**
     * Gets the flower list.
     *
     * @return the flower list
     */


    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {



        return new WorldGenGrass((Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), BlockRedFlower.EnumFlowerType.POPPY)));
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecoratorFlowerField decorator = new BiomeDecoratorFlowerField();
        topBlock = Blocks.GRASS.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.DIRT.getDefaultState(); // zwykle to ziemia

        decorator.treesPerChunk = -9999;
        decorator.grassPerChunk = 20;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;
        

        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());

        ArrayList<IBlockState> flowerStates = new ArrayList<>();
        flowerStates.add(ModBlocks.IRIS_PURPLE.getDefaultState().withProperty(FloweringTallGrass.FLOWERING,true));
        flowerStates.add(ModBlocks.IRIS_VIOLET.getDefaultState().withProperty(FloweringTallGrass.FLOWERING,true));
        flowerStates.add(ModBlocks.LUPINE_VIOLET.getDefaultState().withProperty(FloweringTallGrass.FLOWERING,true));
        flowerStates.add(ModBlocks.LUPINE_PINK.getDefaultState().withProperty(FloweringTallGrass.FLOWERING,true));
        flowerStates.add(ModBlocks.FORGET_ME_NOT_PINK.getDefaultState().withProperty(FloweringTallGrass.FLOWERING,true));
        flowerStates.add(Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS));
        flowerStates.add(ModBlocks.MALA_TRAWA.getDefaultState());

        decorator.grass=flowerStates;

        decorator.flowersPerChunk = 20;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 7, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 7, 3, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 2, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckChild.class, 1, 1, 2));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }


}