package com.matez.wildnature.worldgen.schematics.other.shrubs;


import com.matez.wildnature.Main;
import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class otherGen_shrubLeaf extends WorldGenSchematicTree
{


    public otherGen_shrubLeaf(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){

        bb(0,0);
        bb(1,0);
        bb(2,0);
        bb(-1,0);
        bb(-2,0);
        bb(1,1);
        bb(1,2);
        bb(-2,1);

//   biomeMod 2019/05/11 17:09:53
//           created by matez 
//            all rights reserved   
    }

    private void bb(int x, int z){
        Block(x,1,z,LEAVES);
        if(Main.generateRandomInt(0,4)!=0) {
            Block(x, 2, z, LEAVES);
            if (Main.generateRandomInt(0, 2) != 0) {
                Block(x, 3, z, LEAVES);
                if (Main.generateRandomInt(0, 2) != 0) {
                    Block(x, 4, z, LEAVES);
                    if (Main.generateRandomInt(0, 1) != 0) {
                        Block(x, 5, z, LEAVES);
                    }
                }
            }
        }
    }

}
