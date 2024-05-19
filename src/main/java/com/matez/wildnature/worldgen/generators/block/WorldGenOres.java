package com.matez.wildnature.worldgen.generators.block;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.BiomeInit;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Random;

import static com.matez.wildnature.Main.getBiomeByName;
import static com.matez.wildnature.init.ModBlocks.*;

public class WorldGenOres implements IWorldGenerator {
    private Block[] defaultRocks = {Blocks.STONE,FROZEN_STONE,HARDENED_SANDSTONE,RED_HARDENED_SANDSTONE};
    private Block[] defaultGround = {Blocks.GRASS,BROWN_GRASS_BLOCK,DESERT_GRASS_BLOCK,DRIED_GRASS_BLOCK,MOLD_GRASS_BLOCK,Blocks.DIRT,ZIEMA_BRUNATNA,ZIEMA_CZARNOZIEM,ZIEMA_PUSTYNNA,ZIEMA_SUCHA};

    private Fossil AMBER_GEN,AMETHYST_GEN,RUBY_GEN,SILVER_GEN,MALACHITE_GEN,SAPPHIRE_GEN;

    public WorldGenOres(){
        AMBER_GEN = new Fossil(AMBER_ORE.getDefaultState(),3,2,50,64,Blocks.SAND);
        AMETHYST_GEN = new Fossil(AMETHYST_ORE.getDefaultState(),3,3,15,30,defaultRocks);
        MALACHITE_GEN = new Fossil(MALACHITE_ORE.getDefaultState(),3,3,15,30,defaultRocks);
        SAPPHIRE_GEN = new Fossil(SAPPHIRE_ORE.getDefaultState(),3,2,15,30,defaultRocks);
        SILVER_GEN = new Fossil(SILVER_ORE.getDefaultState(),3,1,20,35,defaultRocks);
        RUBY_GEN = new Fossil(RUBY_ORE.getDefaultState(),3,1,10,16,defaultRocks);


    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int dim = world.provider.getDimension();
        if(dim==0){
            runGenerator(AMBER_GEN,world,random,chunkX,chunkZ);
            runGenerator(AMETHYST_GEN,world,random,chunkX,chunkZ);
            runGenerator(RUBY_GEN,world,random,chunkX,chunkZ);
            runGenerator(SILVER_GEN,world,random,chunkX,chunkZ);
            runGenerator(MALACHITE_GEN,world,random,chunkX,chunkZ);
            runGenerator(SAPPHIRE_GEN,world,random,chunkX,chunkZ);
        }else{

        }
    }

    private void runGenerator(Fossil fossil, World world, Random rand, int chunkX, int chunkZ){
        int minHeight = fossil.getMinY(world);
        int maxHeight = fossil.getMaxY(world);
        int chance = fossil.getChance();
        int fossilSize = fossil.getSize();
        int maxDistance = 0;

        if(minHeight>maxHeight || minHeight<0 || maxHeight > world.getHeight()){throw new IllegalArgumentException("While generating " + fossil.getFossil().getBlock().getLocalizedName() + " something went wrong.");}

        int heightDiff = maxHeight-minHeight+1;

        for(int i = 0;i<chance;i++){
            if(fossil.isWaterRequired()) {
                maxDistance = Main.generateRandomInt(4, 6, rand);
            }
            int x = chunkX*16+rand.nextInt(16);
            int y = minHeight+rand.nextInt(heightDiff);
            int z = chunkZ*16+rand.nextInt(16);

            int a = 0;

            boolean canSpawn = true;
            /*if(fossil.getFossil().getBlock() instanceof RockBase){
                Block b = world.getBiome(new BlockPos(x,y,z)).topBlock.getBlock();
                if(y>world.getSeaLevel() && defaultRocksAr.contains(b)){
                    canSpawn=false;
                }

            }*/


            if(canSpawn) {
                if (fossil.canSpawnOnAllBiomes()) {
                    if(fossil.isWaterRequired()){
                        if(isWaterNear(new BlockPos(x,y,z),world,maxDistance)){
                            while (a < fossil.getFossilGens().size()) {
                                fossil.getFossilGens().get(a).generate(world, rand, new BlockPos(x, y, z));
                                a++;
                            }
                        }
                    }else {
                        while (a < fossil.getFossilGens().size()) {
                            fossil.getFossilGens().get(a).generate(world, rand, new BlockPos(x, y, z));
                            a++;
                        }
                    }
                } else {
                    int b = 0;
                    while (b < fossil.getAllowedBiomes().size()) {
                        if (fossil.getAllowedBiomes().contains(world.getBiome(new BlockPos(x, y, z)))) {

                            if(fossil.isWaterRequired()){
                                if(isWaterNear(new BlockPos(x,y,z),world,maxDistance)){
                                    while (a < fossil.getFossilGens().size()) {
                                        fossil.getFossilGens().get(a).generate(world, rand, new BlockPos(x, y, z));
                                        a++;
                                    }
                                }
                            }else {
                                while (a < fossil.getFossilGens().size()) {
                                    fossil.getFossilGens().get(a).generate(world, rand, new BlockPos(x, y, z));
                                    a++;
                                }
                            }
                        }
                        b++;
                    }
                }
            }
        }
    }

    public boolean isWaterNear(BlockPos pos, World world,int maxDistance){
        boolean near = false;
        int x =1;
        while(!near && x<maxDistance) {
            near = checkWater(pos.east(x), world);
            if (!near) {
                near = checkWater(pos.west(x), world);
                if (!near) {
                    near = checkWater(pos.east(x), world);
                    if (!near) {
                        near = checkWater(pos.north(x), world);
                        if (!near) {
                            near = checkWater(pos.up(x), world);
                        }
                    }
                }
            }
            x++;
        }

        return near;
    }

    private boolean checkWater(BlockPos pos, World world){
        return world.getBlockState(pos).getBlock().equals(Blocks.WATER) || world.getBlockState(pos).getBlock().equals(Blocks.FLOWING_WATER);
    }


}
