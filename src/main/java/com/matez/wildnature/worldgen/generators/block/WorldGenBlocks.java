package com.matez.wildnature.worldgen.generators.block;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.RockBase;
import com.matez.wildnature.init.BiomeInit;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import java.util.Arrays;

import static com.matez.wildnature.Main.getBiomeByName;
import static com.matez.wildnature.init.ModBlocks.*;

import java.util.ArrayList;
import java.util.Random;

public class WorldGenBlocks implements IWorldGenerator {
    private Block[] defaultRocks = {Blocks.STONE,FROZEN_STONE,HARDENED_SANDSTONE,RED_HARDENED_SANDSTONE};
    private Block[] defaultGround = {Blocks.GRASS,BROWN_GRASS_BLOCK,DESERT_GRASS_BLOCK,DRIED_GRASS_BLOCK,MOLD_GRASS_BLOCK,Blocks.DIRT,ZIEMA_BRUNATNA,ZIEMA_CZARNOZIEM,ZIEMA_PUSTYNNA,ZIEMA_SUCHA};
    private ArrayList<Block> defaultRocksAr = new ArrayList<>(Arrays.asList(defaultRocks));
    private Fossil BASALT_GEN, CARBONATITE_GEN, CHALK_GEN, CONGLOMERATE_GEN, DOLOMITE_GEN, EPIDOSITE_GEN, GABBRO_GEN, GNEISS_GEN, GYPSUM_GEN, LIMESTONE_GEN,
    MARBLE_GEN, MONZONITE_GEN, PEGMATITE_GEN, PHYLLITE_GEN, PUMICE_GEN, PYROXENITE_GEN, RHYOLLITE_GEN, SLATE_GEN, SYENITE_GEN, UMBER_GEN;

    private Fossil MUD_GEN,HS_GEN,RHS_GEN,ASH_GEN,DS_GEN,FS_GEN;

    private int defaultBlockCountForRocks = 5;
    public WorldGenBlocks(){
        BASALT_GEN = new Fossil(BASALT.getDefaultState(),defaultBlockCountForRocks,60,defaultRocks);
        CARBONATITE_GEN = new Fossil(CARBONATITE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        CHALK_GEN = new Fossil(CHALK.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        CONGLOMERATE_GEN = new Fossil(CONGLOMERATE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        DOLOMITE_GEN = new Fossil(DOLOMITE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        EPIDOSITE_GEN = new Fossil(EPIDOSITE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        GABBRO_GEN = new Fossil(GABBRO.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        GNEISS_GEN = new Fossil(GNEISS.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        GYPSUM_GEN = new Fossil(GYPSUM.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        LIMESTONE_GEN = new Fossil(LIMESTONE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        MARBLE_GEN = new Fossil(MARBLE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        MONZONITE_GEN = new Fossil(MONZONITE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        PEGMATITE_GEN = new Fossil(PEGMATITE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        PHYLLITE_GEN = new Fossil(PHYLLITE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        PUMICE_GEN = new Fossil(PUMICE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        PYROXENITE_GEN = new Fossil(PYROXENITE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        RHYOLLITE_GEN = new Fossil(RHYOLITE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        SLATE_GEN = new Fossil(SLATE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        SYENITE_GEN = new Fossil(SYENITE.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);
        UMBER_GEN = new Fossil(UMBER.getDefaultState(),defaultBlockCountForRocks,80,defaultRocks);

        MUD_GEN = new Fossil(MUD.getDefaultState(),7,140,55,69,defaultGround);
        MUD_GEN.spawnNearWater(true);
        MUD_GEN.addAllowedBiomes(getBiomeByName("swampland"),getBiomeByName("mutated_swampland"), BiomeInit.MISTY_SWAMP);
        HS_GEN = new Fossil(HARDENED_SANDSTONE.getDefaultState(),15,20,255,66,Blocks.STONE);
        HS_GEN.addAllowedBiomes(Main.BiomesDESERT.toArray(new Biome[Main.BiomesDESERT.size()]));
        RHS_GEN = new Fossil(RED_HARDENED_SANDSTONE.getDefaultState(),15,20,255,66,Blocks.STONE);
        RHS_GEN.addAllowedBiomes(Main.mesaBiomes.toArray(new Biome[Main.mesaBiomes.size()]));
        ASH_GEN = new Fossil(ASH_BLOCK.getDefaultState(),15,70,20,255,Blocks.STONE);
        ASH_GEN.addAllowedBiomes(Main.volcanoBiomes.toArray(new Biome[Main.volcanoBiomes.size()]));
        DS_GEN = new Fossil(DARK_STONE.getDefaultState(),15,70,20,255,Blocks.STONE);
        DS_GEN.addAllowedBiomes(Main.mistyMountainsBiomes.toArray(new Biome[Main.mistyMountainsBiomes.size()]));
        FS_GEN = new Fossil(FROZEN_STONE.getDefaultState(),15,70,20,255,Blocks.STONE);
        FS_GEN.addAllowedBiomes(Main.BiomesICY.toArray(new Biome[Main.BiomesICY.size()]));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int dim = world.provider.getDimension();
        if(dim==0){
            runGenerator(BASALT_GEN,world,random,chunkX,chunkZ);
            runGenerator(CARBONATITE_GEN,world,random,chunkX,chunkZ);
            runGenerator(CHALK_GEN,world,random,chunkX,chunkZ);
            runGenerator(CONGLOMERATE_GEN,world,random,chunkX,chunkZ);
            runGenerator(DOLOMITE_GEN,world,random,chunkX,chunkZ);
            runGenerator(EPIDOSITE_GEN,world,random,chunkX,chunkZ);
            runGenerator(GABBRO_GEN,world,random,chunkX,chunkZ);
            runGenerator(GNEISS_GEN,world,random,chunkX,chunkZ);
            runGenerator(GYPSUM_GEN,world,random,chunkX,chunkZ);
            runGenerator(LIMESTONE_GEN,world,random,chunkX,chunkZ);
            runGenerator(MARBLE_GEN,world,random,chunkX,chunkZ);
            runGenerator(MONZONITE_GEN,world,random,chunkX,chunkZ);
            runGenerator(PEGMATITE_GEN,world,random,chunkX,chunkZ);
            runGenerator(PHYLLITE_GEN,world,random,chunkX,chunkZ);
            runGenerator(PUMICE_GEN,world,random,chunkX,chunkZ);
            runGenerator(PYROXENITE_GEN,world,random,chunkX,chunkZ);
            runGenerator(RHYOLLITE_GEN,world,random,chunkX,chunkZ);
            runGenerator(SLATE_GEN,world,random,chunkX,chunkZ);
            runGenerator(SYENITE_GEN,world,random,chunkX,chunkZ);
            runGenerator(UMBER_GEN,world,random,chunkX,chunkZ);

            runGenerator(MUD_GEN,world,random,chunkX,chunkZ);
            runGenerator(HS_GEN,world,random,chunkX,chunkZ);
            runGenerator(RHS_GEN,world,random,chunkX,chunkZ);
            runGenerator(ASH_GEN,world,random,chunkX,chunkZ);
            runGenerator(DS_GEN,world,random,chunkX,chunkZ);
            runGenerator(FS_GEN,world,random,chunkX,chunkZ);
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
                maxDistance = Main.generateRandomInt(5, 7, rand);
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
