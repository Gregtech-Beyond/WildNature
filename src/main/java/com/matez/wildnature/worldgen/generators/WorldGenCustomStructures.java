package com.matez.wildnature.worldgen.generators;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.BiomeInit;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.WorldGenFromFile;
import com.matez.wildnature.worldgen.WorldGenStructure;
import com.matez.wildnature.worldgen.schematics.buildings.strGen_forester1;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Random;

import static com.matez.wildnature.init.BiomeInit.biomes;

public class WorldGenCustomStructures implements IWorldGenerator {

    public static final strGen_forester1 forester1 = new strGen_forester1(true,null,null,null,null,null,null,null,null);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        switch(world.provider.getDimension()){
            case -1:
                break;
            case 0:
                //generateStructure(WildNature,world,random,chunkX,chunkZ,130, ModBlocks.DARK_STONE,-10, BiomeInit.MISTY_MOUNTAINS.getClass());
                //generateStructure(forester1,world,random,chunkX,chunkZ,100, ModBlocks.BROWN_GRASS_BLOCK,1, BiomeInit.BIALOWIEZA_FOREST.getClass(), BiomeInit.SNOWY_BIALOWIEZA_FOREST.getClass());
                break;
            case 1:
                break;
        }
    }



    private void generateStructure(WorldGenerator generator,World world, Random random,int chunkX, int chunkZ, int chance, Block spawnBlock, int spawnBlocksFromTop, Class<?>... biomes){
        ArrayList<Class<?>> biomesList = new ArrayList<Class<?>>(Arrays.asList(biomes));

        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = calculateGenerationHeight(world,x,z,spawnBlock)+ spawnBlocksFromTop;

        BlockPos pos = new BlockPos(x,y,z);
        Class<?> currentBiome = world.provider.getBiomeForCoords(pos).getClass();
        if(biomesList.contains(currentBiome)){
            if(Main.generateRandomInt(0,chance) == 0){
                generator.generate(world,random,pos);
            }
        }

    }

    private static int calculateGenerationHeight(World world, int x, int z, Block topBlock){
        int y = world.getHeight();
        boolean foundGround = false;
        while(!foundGround && y -- >= 0){
            Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround = block == topBlock;

        }
        return y;
    }
}