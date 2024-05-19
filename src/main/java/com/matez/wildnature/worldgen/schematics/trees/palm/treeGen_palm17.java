package com.matez.wildnature.worldgen.schematics.trees.palm;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_palm17 extends WorldGenSchematicTree
{


    public treeGen_palm17(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-3,13,3,LEAVES);
Block(-3,14,2,LEAVES);
Block(-2,12,-1,LEAVES);
Block(-2,13,0,LEAVES);
Block(-2,14,2,LEAVES);
Block(-2,14,5,LEAVES);
Block(-2,15,4,LEAVES);
Block(-2,16,2,LEAVES);
Block(-1,1,-1,LOG);
Block(-1,1,0,LOG);
Block(-1,1,1,LOG);
Block(-1,2,0,LOG);
Block(-1,13,0,LEAVES);
Block(-1,13,1,LEAVES);
Block(-1,14,1,LEAVES);
Block(-1,14,2,LEAVES);
Block(-1,15,2,LEAVES);
Block(-1,15,3,LEAVES);
Block(-1,15,4,LEAVES);
Block(-1,16,5,LEAVES);
Block(0,0,0,DIRT);
Block(0,1,-2,LOG);
Block(0,1,-1,LOG);
Block(0,1,0,LOG);
Block(0,1,1,LOG);
Block(0,2,-2,LOG);
Block(0,2,-1,LOG);
Block(0,2,0,LOG);
Block(0,2,1,LOG);
Block(0,3,-1,LOG);
Block(0,3,0,LOG);
Block(0,4,-1,LOG);
Block(0,4,0,LOG);
Block(0,5,-1,LOG);
Block(0,5,0,LOG);
Block(0,6,0,LOG);
Block(0,6,1,LOG);
Block(0,13,6,LEAVES);
Block(0,14,1,LEAVES);
Block(0,14,2,LEAVES);
Block(0,14,5,LEAVES);
Block(0,15,2,LEAVES);
Block(0,15,3,LOG);
Block(0,15,4,LEAVES);
Block(0,16,1,LEAVES);
Block(0,16,2,LEAVES);
Block(0,16,3,LEAVES);
Block(1,1,-1,LOG);
Block(1,1,0,LOG);
Block(1,1,1,LOG);
Block(1,2,0,LOG);
Block(1,3,0,LOG);
Block(1,4,-1,LOG);
Block(1,5,0,LOG);
Block(1,6,1,LOG);
Block(1,7,1,LOG);
Block(1,8,1,LOG);
Block(1,11,2,LOG);
Block(1,12,2,LOG);
Block(1,12,3,LOG);
Block(1,12,7,LEAVES);
Block(1,13,0,LEAVES);
Block(1,13,3,LOG);
Block(1,14,3,LOG);
Block(1,15,-1,LEAVES);
Block(1,15,3,LEAVES);
Block(1,16,0,LEAVES);
Block(1,16,2,LEAVES);
Block(1,16,3,LEAVES);
Block(1,17,2,LEAVES);
Block(1,17,4,LEAVES);
Block(2,8,2,LOG);
Block(2,9,1,LOG);
Block(2,9,2,LOG);
Block(2,10,2,LOG);
Block(2,11,2,LOG);
Block(2,13,6,LEAVES);
Block(2,13,7,LEAVES);
Block(2,14,0,LEAVES);
Block(2,14,1,LEAVES);
Block(2,14,4,LEAVES);
Block(2,14,5,LEAVES);
Block(2,14,6,LEAVES);
Block(2,15,0,LEAVES);
Block(2,15,1,LEAVES);
Block(2,15,2,LEAVES);
Block(2,15,3,LEAVES);
Block(2,15,4,LEAVES);
Block(2,15,5,LEAVES);
Block(2,16,1,LEAVES);
Block(2,16,2,LEAVES);
Block(2,16,3,LEAVES);
Block(3,14,0,LEAVES);
Block(3,14,3,LEAVES);
Block(3,15,1,LEAVES);
Block(3,15,3,LEAVES);
Block(3,16,4,LEAVES);
Block(3,17,3,LEAVES);
Block(4,11,-2,LEAVES);
Block(4,12,-1,LEAVES);
Block(4,13,-1,LEAVES);
Block(4,13,3,LEAVES);
Block(4,13,4,LEAVES);
Block(4,14,0,LEAVES);
Block(4,14,2,LEAVES);
Block(4,14,3,LEAVES);
Block(4,14,4,LEAVES);
Block(4,14,5,LEAVES);
Block(5,12,4,LEAVES);
Block(5,14,3,LEAVES);
//   biomeMod 2019/02/06 20:35:23
//           created by matez 
//            all rights reserved   
    }

}