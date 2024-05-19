package com.matez.wildnature.worldgen.schematics.trees.oak;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_oak1 extends WorldGenSchematicTree
{


    public treeGen_oak1(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-3,3,2,LEAVES);
Block(-3,4,1,LEAVES);
Block(-3,5,2,LEAVES);
Block(-3,13,11,LEAVES);
Block(-3,15,11,LEAVES);
Block(-2,2,0,LEAVES);
Block(-2,3,-2,LEAVES);
Block(-2,3,2,LEAVES);
Block(-2,4,-2,LEAVES);
Block(-2,4,-1,LEAVES);
Block(-2,4,1,LEAVES);
Block(-2,5,2,LEAVES);
Block(-2,6,0,LEAVES);
Block(-2,13,11,LEAVES);
Block(-1,2,0,LEAVES);
Block(-1,2,1,LEAVES);
Block(-1,2,2,LEAVES);
Block(-1,3,-3,LEAVES);
Block(-1,3,-1,LEAVES);
Block(-1,3,0,LEAVES);
Block(-1,3,1,LEAVES);
Block(-1,3,2,LEAVES);
Block(-1,3,3,LEAVES);
Block(-1,4,-2,LEAVES);
Block(-1,4,1,LEAVES);
Block(-1,4,3,LEAVES);
Block(-1,5,-3,LEAVES);
Block(-1,5,1,LEAVES);
Block(-1,5,2,LEAVES);
Block(-1,6,-1,LEAVES);
Block(-1,6,1,LEAVES);
Block(-1,6,2,LEAVES);
Block(0,0,0,DIRT);
Block(0,1,0,LOG);
Block(0,2,0,LOG);
Block(0,2,1,LEAVES);
Block(0,3,0,LOG);
Block(0,3,3,LEAVES);
Block(0,4,-1,LOG);
Block(0,4,0,LEAVES);
Block(0,4,2,LEAVES);
Block(0,4,3,LEAVES);
Block(0,5,-3,LEAVES);
Block(0,5,-2,LEAVES);
Block(0,5,1,LEAVES);
Block(0,5,3,LEAVES);
Block(0,6,-1,LEAVES);
Block(0,6,0,LEAVES);
Block(1,4,-3,LEAVES);
Block(1,4,-2,LEAVES);
Block(1,4,1,LEAVES);
Block(1,5,-2,LEAVES);
Block(1,6,-2,LEAVES);
Block(1,6,-1,LEAVES);
Block(1,6,0,LEAVES);
Block(1,7,-1,LEAVES);
Block(1,7,0,LEAVES);
Block(1,12,11,LEAVES);
Block(1,14,11,LEAVES);
Block(2,3,-2,LEAVES);
Block(2,3,1,LEAVES);
Block(2,4,-2,LEAVES);
Block(2,4,0,LEAVES);
Block(2,4,2,LEAVES);
Block(2,5,-2,LEAVES);
Block(2,5,1,LEAVES);
Block(2,6,0,LEAVES);
Block(2,6,1,LEAVES);
Block(2,6,2,LEAVES);
Block(2,7,-1,LEAVES);
Block(3,3,1,LEAVES);
Block(3,4,-2,LEAVES);
Block(3,4,-1,LEAVES);
Block(3,5,-2,LEAVES);
Block(3,5,0,LEAVES);
Block(3,7,-1,LEAVES);
Block(3,7,0,LEAVES);
Block(3,13,11,LEAVES);
Block(4,4,-1,LEAVES);
Block(4,5,0,LEAVES);
Block(4,5,1,LEAVES);
Block(4,6,0,LEAVES);
Block(4,12,11,LEAVES);
Block(4,14,11,LEAVES);
//   biomeMod 2019/02/06 20:34:40
//           created by matez 
//            all rights reserved   
    }

}