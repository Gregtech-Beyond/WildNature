package com.matez.wildnature.worldgen.schematics.other.shrubs;


import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class otherGen_shrub1 extends WorldGenSchematicTree
{


    public otherGen_shrub1(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-4,1,-1,LEAVES);
Block(-3,1,-4,LEAVES);
Block(-3,1,-3,LEAVES);
Block(-3,2,-1,LEAVES);
Block(-3,2,0,LEAVES);
Block(-3,2,2,LEAVES);
Block(-3,3,1,LEAVES);
Block(-2,1,-4,LEAVES);
Block(-2,1,-2,LEAVES);
Block(-2,1,-1,LOG);
Block(-2,2,-1,LOG);
Block(-2,2,2,LEAVES);
Block(-2,3,-2,LEAVES);
Block(-2,3,-1,LOG);
Block(-2,3,1,LOG);
Block(-2,3,3,LEAVES);
Block(-2,4,-1,LEAVES);
Block(-2,4,0,LEAVES);
Block(-1,1,1,LOG);
Block(-1,2,-1,LEAVES);
Block(-1,2,1,LOG);
Block(-1,2,2,LEAVES);
Block(-1,2,3,LEAVES);
Block(-1,3,-2,LEAVES);
Block(-1,3,0,LEAVES);
Block(-1,3,2,LEAVES);
Block(0,0,0,DIRT);
Block(0,2,-2,LEAVES);
Block(0,2,2,LEAVES);
Block(0,3,-1,LEAVES);
Block(1,1,0,LOG);
Block(1,2,-2,LEAVES);
Block(1,2,0,LOG);
Block(1,2,2,LEAVES);
Block(1,3,-2,LEAVES);
Block(1,3,-1,LEAVES);
Block(1,3,1,LOG);
Block(1,3,2,LEAVES);
Block(1,3,3,LEAVES);
Block(1,4,1,LEAVES);
Block(2,1,-3,LEAVES);
Block(2,2,-1,LEAVES);
Block(2,2,0,LEAVES);
Block(2,2,1,LEAVES);
Block(2,3,0,LEAVES);
Block(2,3,3,LEAVES);
Block(3,1,0,LEAVES);
Block(4,2,0,LEAVES);
Block(4,2,1,LEAVES);
//   biomeMod 2019/05/11 17:09:53
//           created by matez 
//            all rights reserved   
    }

}
