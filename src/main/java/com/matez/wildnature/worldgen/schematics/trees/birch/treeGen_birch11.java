package com.matez.wildnature.worldgen.schematics.trees.birch;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_birch11 extends WorldGenSchematicTree
{


    public treeGen_birch11(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-2,8,0,LEAVES);
Block(-2,10,-1,LEAVES);
Block(-2,10,1,LEAVES);
Block(-2,11,-1,LEAVES);
Block(-2,13,0,LEAVES);
Block(-2,13,1,LEAVES);
Block(-2,15,0,LEAVES);
Block(-1,1,0,LOG);
Block(-1,2,0,LOG);
Block(-1,6,-1,LEAVES);
Block(-1,7,-1,LEAVES);
Block(-1,7,0,LEAVES);
Block(-1,8,-1,LEAVES);
Block(-1,8,0,LEAVES);
Block(-1,8,1,LEAVES);
Block(-1,9,-1,LEAVES);
Block(-1,9,0,LEAVES);
Block(-1,9,1,LEAVES);
Block(-1,9,2,LEAVES);
Block(-1,10,-1,LEAVES);
Block(-1,10,1,LEAVES);
Block(-1,10,2,LEAVES);
Block(-1,11,-2,LEAVES);
Block(-1,11,-1,LEAVES);
Block(-1,12,0,LEAVES);
Block(-1,12,1,LEAVES);
Block(-1,13,-2,LEAVES);
Block(-1,13,1,LEAVES);
Block(-1,14,-2,LEAVES);
Block(-1,14,0,LEAVES);
Block(-1,14,1,LEAVES);
Block(-1,15,-1,LEAVES);
Block(-1,15,0,LEAVES);
Block(-1,16,0,LEAVES);
Block(-1,16,1,LEAVES);
Block(-1,17,0,LEAVES);
Block(-1,17,1,LEAVES);
Block(-1,18,-1,LEAVES);
Block(-1,18,0,LEAVES);
Block(-1,19,0,LEAVES);
Block(0,0,0,DIRT);
Block(0,1,-1,LOG);
Block(0,1,0,LOG);
Block(0,1,1,LOG);
Block(0,2,0,LOG);
Block(0,2,1,LOG);
Block(0,3,0,LOG);
Block(0,3,1,LOG);
Block(0,4,0,LOG);
Block(0,4,1,LOG);
Block(0,5,0,LOG);
Block(0,6,-1,LEAVES);
Block(0,6,0,LOG);
Block(0,7,0,LOG);
Block(0,8,0,LOG);
Block(0,8,1,LEAVES);
Block(0,9,0,LOG);
Block(0,9,1,LEAVES);
Block(0,10,-1,LEAVES);
Block(0,10,0,LOG);
Block(0,10,2,LEAVES);
Block(0,11,0,LOG);
Block(0,11,1,LEAVES);
Block(0,11,2,LEAVES);
Block(0,12,0,LOG);
Block(0,12,2,LEAVES);
Block(0,13,-1,LEAVES);
Block(0,13,0,LOG);
Block(0,13,1,LEAVES);
Block(0,13,2,LEAVES);
Block(0,14,-2,LEAVES);
Block(0,14,-1,LEAVES);
Block(0,14,0,LOG);
Block(0,14,1,LEAVES);
Block(0,15,0,LOG);
Block(0,16,-1,LEAVES);
Block(0,16,0,LOG);
Block(0,16,1,LEAVES);
Block(0,17,0,LOG);
Block(0,17,1,LEAVES);
Block(0,18,-1,LEAVES);
Block(0,18,0,LOG);
Block(0,19,-1,LEAVES);
Block(0,19,1,LEAVES);
Block(0,20,0,LEAVES);
Block(0,21,0,LEAVES);
Block(1,1,0,LOG);
Block(1,2,0,LOG);
Block(1,6,-1,LEAVES);
Block(1,7,0,LEAVES);
Block(1,8,0,LEAVES);
Block(1,9,1,LEAVES);
Block(1,10,0,LEAVES);
Block(1,10,1,LEAVES);
Block(1,10,2,LEAVES);
Block(1,11,0,LEAVES);
Block(1,11,1,LEAVES);
Block(1,12,-1,LEAVES);
Block(1,12,0,LEAVES);
Block(1,12,1,LEAVES);
Block(1,13,-2,LEAVES);
Block(1,13,-1,LEAVES);
Block(1,13,0,LEAVES);
Block(1,13,1,LEAVES);
Block(1,14,-1,LEAVES);
Block(1,14,0,LEAVES);
Block(1,14,1,LEAVES);
Block(1,14,2,LEAVES);
Block(1,15,-2,LEAVES);
Block(1,15,-1,LEAVES);
Block(1,15,1,LEAVES);
Block(1,16,-1,LEAVES);
Block(1,16,0,LEAVES);
Block(1,17,-1,LEAVES);
Block(1,17,0,LEAVES);
Block(1,18,-1,LEAVES);
Block(1,18,0,LEAVES);
Block(1,18,1,LEAVES);
Block(2,8,-1,LEAVES);
Block(2,8,0,LEAVES);
Block(2,9,0,LEAVES);
Block(2,11,-1,LEAVES);
Block(2,11,0,LEAVES);
Block(2,13,1,LEAVES);
Block(2,14,0,LEAVES);
Block(2,14,1,LEAVES);
Block(2,15,-1,LEAVES);
//   biomeMod 2019/02/06 18:41:49
//           created by matez 
//            all rights reserved   
    }

}