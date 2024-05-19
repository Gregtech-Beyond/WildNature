package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.*;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.trees.fir.treeGen_fir18;
import com.matez.wildnature.worldgen.schematics.trees.fir.treeGen_fir22;
import com.matez.wildnature.worldgen.schematics.trees.fir.treeGen_fir6;
import com.matez.wildnature.worldgen.schematics.trees.spruce.*;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

import java.util.Random;

public class BiomeRockySpruceForest extends Biome {



    protected static WorldGenAbstractTree TREE = null,TREE2 = null,TREE3 = null,TREE4 = null,TREE5 = null,TREE6 = null,TREE7 = null,TREE8 = null,TREE9 = null,TREE10 = null,TREE11 = null,TREE12 = null,TREE13 = null,TREE14 = null,TREE15 = null,TREE16 = null,TREE17 = null,TREE18 = null,TREE19 = null,TREE20 = null,TREE21 = null,TREE22 = null;


    public BiomeRockySpruceForest() {
        super(new BiomeProperties("Rocky Spruce Forest").setBaseHeight(1.4F).setHeightVariation(0.1F).setTemperature(0.25F).setRainfall(0.4F));



    }



    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return new WorldGenTaiga2(true);


    }


    public int getGrassColorAtPos(BlockPos pos)
    {

        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x429156 : 0x46905A);
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

        decorator.treesPerChunk = 5;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;
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

        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 7, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 7, 3, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 3, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));

        decorator.flowersPerChunk = 35;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        {

            if (noiseVal > 1.75D) {
                topBlock = ModBlocks.BROWN_GRASS_BLOCK.getDefaultState(); // zwykle to blok trawy
                fillerBlock = ModBlocks.ZIEMA_BRUNATNA.getDefaultState(); // zwykle to ziemia
            } else if (noiseVal > -0.95D) {
                topBlock = STONE;
                fillerBlock = STONE;
            }

            this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
        }


    }
    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 3, 2, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatSaanenMale.class, 1, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityGoatSaanenFemale.class, 1, 1, 2));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 3, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));

    }


}