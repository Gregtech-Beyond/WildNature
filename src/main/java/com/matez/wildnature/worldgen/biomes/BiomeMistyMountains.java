package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.treeGen_pine;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeMistyMountains extends Biome {

    protected static final WorldGenAbstractTree TREE = new treeGen_pine(true);


    public BiomeMistyMountains() {
        super(new BiomeProperties("Misty Mountains").setBaseHeight(3F).setHeightVariation(1.5F).setTemperature(0.3F).setRainfall(0.7F));



    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0x000000;
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
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = ModBlocks.DARK_STONE.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.DARK_STONE.getDefaultState(); // zwykle to ziemia
        spawnableCreatureList.clear();
        decorator.generateFalls=false;

        decorator.treesPerChunk = -9999;
        decorator.grassPerChunk = -9999;
        decorator.sandPatchesPerChunk = -9999;
        decorator.clayPerChunk=-9999;



        decorator.flowersPerChunk = -9999;

        return getModdedBiomeDecorator(decorator);
    }


}