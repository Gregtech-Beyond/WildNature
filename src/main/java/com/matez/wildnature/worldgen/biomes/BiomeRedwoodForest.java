package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.entity.EntityDuckChild;
import com.matez.wildnature.entity.EntityDuckFemale;
import com.matez.wildnature.entity.EntityDuckMale;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.trees.redwood.treeGen_redwood1;
import com.matez.wildnature.worldgen.schematics.trees.redwood.treeGen_redwood2;
import com.matez.wildnature.worldgen.schematics.trees.redwood.treeGen_redwood3;
import com.matez.wildnature.worldgen.schematics.trees.redwood.treeGen_redwood4;
import com.matez.wildnature.worldgen.treeGen_sekwoja;
import com.matez.wildnature.worldgen.world.MBBiome;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

public class BiomeRedwoodForest extends MBBiome {

    //protected static final WorldGenAbstractTree TREE,TREE2,TREE3,TREE4,TREE5,TREE6;
    private static final IBlockState LOG = ModBlocks.REDWOOD_LOG.getDefaultState();
    private static final IBlockState LEAVES = ModBlocks.REDWOOD_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

    public BiomeRedwoodForest() {
        super(new BiomeProperties("Redwood Forest").setBaseBiome("deciduous_forest").setBaseHeight(0.1F).setHeightVariation(0.07F).setTemperature(0.40F).setRainfall(0.6F));


    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        int x = Main.generateRandomInt(0, 22,rand);
        if (x < 16) {
            if(Main.generateRandomInt(0,2)==0){
                return new WorldGenShrub(Blocks.LOG.getDefaultState(), Blocks.LEAVES.getDefaultState());
            }else{
                return new WorldGenShrub(LOG,LEAVES);
            }
        } else {
            switch (Main.generateRandomInt(1,4,rand)){
                case 1:
                    return new treeGen_redwood1(true,LOG,LEAVES);
                case 2:
                    return new treeGen_redwood2(true,LOG,LEAVES);
                case 3:
                    return new treeGen_redwood3(true,LOG,LEAVES);
                case 4:
                    return new treeGen_redwood4(true,LOG,LEAVES);
            }
        }
        return null;

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
        topBlock = Blocks.GRASS.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.DIRT.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = 11;
        decorator.grassPerChunk = 10;
        decorator.sandPatchesPerChunk = 5;
        decorator.clayPerChunk = 2;
        decorator.reedsPerChunk = 4;
        

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
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 7, 3, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 2, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckChild.class, 1, 1, 2));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        {
            this.topBlock = Blocks.GRASS.getDefaultState();
            this.fillerBlock = Blocks.DIRT.getDefaultState();

            if (noiseVal > 1.75D) {
                this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
            } else if (noiseVal > -0.95D) {
                this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
            }

            this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
        }


    }
}