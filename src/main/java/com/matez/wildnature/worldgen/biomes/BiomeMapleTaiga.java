package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockTallGrass;
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
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

public class BiomeMapleTaiga extends Biome {



    protected static WorldGenAbstractTree TREE = null,TREE2 = null,TREE3 = null,TREE4 = null,TREE5 = null,TREE6 = null,TREE7 = null,TREE8 = null,TREE9 = null,TREE10 = null,TREE11 = null,TREE12 = null,TREE13 = null,TREE14 = null,TREE15 = null,TREE16 = null,TREE17 = null,TREE18 = null,TREE19 = null,TREE20 = null,TREE21 = null,TREE22 = null;
    int mapleType = -1;

    public BiomeMapleTaiga() {
        super(new BiomeProperties("Maple Taiga").setBaseHeight(0.2F).setHeightVariation(0.1F).setTemperature(0.25F).setRainfall(0.4F));



    }

    private int generateMapleTaigaType(Random rand){
        int x = Main.generateRandomInt(1,3,rand);
        if(x==1){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        int x = Main.generateRandomInt(0,1,rand);
        if(x==0){
            return new WorldGenTrees(true);
        }else{
            return new WorldGenTaiga2(true);
        }



    }


    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0xACB966 : 0x48B16F);
    }
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        if(mapleType==-1){
            mapleType = generateMapleTaigaType(new Random());
        }

        if(mapleType==0){
            //orange
            return getModdedBiomeGrassColor(noise < -0.1D ? 0xB98331 : 0xB9982E);
        }else{
            //red
            return getModdedBiomeGrassColor(noise < -0.1D ? 0xB93D2D : 0xB94A37);
        }


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

        decorator.treesPerChunk = 8;
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
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 5, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 5, 3, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 10, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 6, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));

        decorator.flowersPerChunk = 35;

        return getModdedBiomeDecorator(decorator);
    }




}