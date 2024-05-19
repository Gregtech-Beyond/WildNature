package com.matez.wildnature.worldgen;

import com.matez.wildnature.Main;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class blockGen extends WorldGenerator {

    public BlockWeighList bpList;
    public Integer chance;
    public blockGen(BlockWeighList list, Integer genChance){
       bpList = list;
       chance = genChance;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if (Main.generateRandomInt(0, 100) <= chance) {
            int x = Main.generateRandomInt(0, bpList.size() - 1);
        }

        return false;
    }

    /*
    if(worldIn.isAirBlock(position) && !worldIn.isAirBlock(position.down())){
            int x = 0;
            while(x<bpList.size()) {
                if (Main.generateRandomInt(0, 100) <= chance) {
                    int y = Main.generateRandomInt(0, bpList.size() - 1);
                    System.out.println("GENERATING FLOWER");

                    int z = Main.generateRandomInt(0, 100);
                    if (z <= bpList.getPercentList().get(y)) {
                        IBlockState state = bpList.getBlockList().get(y);
                        System.out.println("FLOWERSTATE: " + state.getBlock().getLocalizedName());
                        try {
                            for (int i = 0; i < 64; ++i) {
                                position = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
                                if (worldIn.isAirBlock(position)&&worldIn.getBlockState(position.down()).getBlock().canSustainPlant(worldIn.getBlockState(position.down()), worldIn, position.down(), EnumFacing.UP, ((IPlantable) state.getBlock()))) {
                                    worldIn.setBlockState(position, state, 2);
                                    System.out.println("FLOWER: " + position);
                                }

                            }
                        } catch (Exception e) {

                        }

                    }
                }
                x++;
            }
        }
     */


}