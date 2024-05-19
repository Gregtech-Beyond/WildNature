package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.entity.EntityDuckChild;
import com.matez.wildnature.entity.EntityDuckFemale;
import com.matez.wildnature.entity.EntityDuckMale;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.treeGen_pear;
import com.matez.wildnature.worldgen.treeGen_apple;
import com.matez.wildnature.worldgen.treeGen_pinkCherry;
import com.matez.wildnature.worldgen.treeGen_whiteCherry;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;

import java.util.Random;

public class BiomeCherryOrchard extends Biome {

    protected static WorldGenAbstractTree TREE = new treeGen_pinkCherry(true);
    protected static WorldGenAbstractTree TREE2 = new treeGen_whiteCherry(true);
    protected static WorldGenAbstractTree TREE3 = new WorldGenBigTree(true);


    public BiomeCherryOrchard() {
        super(new BiomeProperties("Cherry Orchard").setBaseHeight(0.05F).setHeightVariation(0.25F).setTemperature(0.60F).setRainfall(0.8F).setWaterColor(206));



    }


    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x4FBA53 : 0x3CB133);
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x4FBA53 : 0x3CB133);
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        TREE = new treeGen_pinkCherry(true);
        TREE2 = new treeGen_whiteCherry(true);
        TREE3 = new WorldGenBigTree(true);

        int x = Main.generateRandomInt(0,2);
        if(x==0){
            return TREE;
        } else if(x==1){
            return TREE2;
        } else if(x==2){
            return TREE3;
        }else{
            return null;
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
        topBlock = ModBlocks.MOLD_GRASS_BLOCK.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.ZIEMA_CZARNOZIEM.getDefaultState(); // zwykle to ziemia

        decorator.treesPerChunk = 4;
        decorator.grassPerChunk = 20;
        decorator.sandPatchesPerChunk = 0;

        decorator.flowers.clear();
        decorator.flowers.add(ModBlocks.LEAF_PILE.getDefaultState(),5);
        decorator.flowers.add(ModBlocks.CLOVER.getDefaultState(),3);
        decorator.flowers.add(ModBlocks.SASANKA.getDefaultState(),2);

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
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 3, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckChild.class, 1, 1, 2));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }


}