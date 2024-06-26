package com.matez.wildnature.worldgen.schematics.trees.palm;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_palm6 extends WorldGenSchematicTree
{


    public treeGen_palm6(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-5,14,2,LEAVES);
Block(-4,15,2,LEAVES);
Block(-4,20,2,LEAVES);
Block(-3,12,5,LEAVES);
Block(-3,13,-1,LEAVES);
Block(-3,13,5,LEAVES);
Block(-3,14,-1,LEAVES);
Block(-3,15,2,LEAVES);
Block(-3,16,2,LEAVES);
Block(-3,18,-1,LEAVES);
Block(-3,18,5,LEAVES);
Block(-3,19,-1,LEAVES);
Block(-3,19,2,LEAVES);
Block(-3,19,5,LEAVES);
Block(-2,13,4,LEAVES);
Block(-2,14,0,LEAVES);
Block(-2,14,4,LEAVES);
Block(-2,15,0,LEAVES);
Block(-2,16,2,LEAVES);
Block(-2,17,0,LEAVES);
Block(-2,17,2,LEAVES);
Block(-2,17,4,LEAVES);
Block(-2,18,0,LEAVES);
Block(-2,18,4,LEAVES);
Block(-2,19,2,LEAVES);
Block(-1,14,2,LEAVES);
Block(-1,14,3,LEAVES);
Block(-1,15,2,LEAVES);
Block(-1,15,3,LEAVES);
Block(-1,16,1,LEAVES);
Block(-1,16,2,LEAVES);
Block(-1,16,3,LEAVES);
Block(-1,17,1,LEAVES);
Block(-1,17,2,LEAVES);
Block(-1,17,3,LEAVES);
Block(-1,18,2,LEAVES);
Block(0,0,0,DIRT);
Block(0,1,0,LOG);
Block(0,2,0,LOG);
Block(0,3,0,LOG);
Block(0,4,0,LOG);
Block(0,5,0,LOG);
Block(0,5,1,LOG);
Block(0,6,1,LOG);
Block(0,7,1,LOG);
Block(0,8,1,LOG);
Block(0,9,1,LOG);
Block(0,9,2,LOG);
Block(0,10,2,LOG);
Block(0,11,2,LOG);
Block(0,12,2,LOG);
Block(0,13,-3,LEAVES);
Block(0,13,1,LEAVES);
Block(0,13,2,LOG);
Block(0,13,3,LEAVES);
Block(0,14,-2,LEAVES);
Block(0,14,-1,LEAVES);
Block(0,14,2,LOG);
Block(0,14,7,LEAVES);
Block(0,15,-1,LEAVES);
Block(0,15,0,LEAVES);
Block(0,15,1,LEAVES);
Block(0,15,2,LEAVES);
Block(0,15,3,LEAVES);
Block(0,15,5,LEAVES);
Block(0,15,6,LEAVES);
Block(0,16,0,LEAVES);
Block(0,16,1,LEAVES);
Block(0,16,2,LEAVES);
Block(0,16,3,LEAVES);
Block(0,16,4,LEAVES);
Block(0,16,5,LEAVES);
Block(0,17,1,LEAVES);
Block(0,17,2,LEAVES);
Block(0,17,3,LEAVES);
Block(0,18,2,LEAVES);
Block(1,14,1,LEAVES);
Block(1,14,3,LEAVES);
Block(1,15,1,LEAVES);
Block(1,15,2,LEAVES);
Block(1,15,3,LEAVES);
Block(1,16,2,LEAVES);
Block(1,16,3,LEAVES);
Block(1,17,0,LEAVES);
Block(1,17,2,LEAVES);
Block(1,18,0,LEAVES);
Block(2,13,4,LEAVES);
Block(2,14,0,LEAVES);
Block(2,14,4,LEAVES);
Block(2,15,2,LEAVES);
Block(2,16,2,LEAVES);
Block(2,16,4,LEAVES);
Block(2,17,4,LEAVES);
Block(2,18,-1,LEAVES);
Block(2,18,2,LEAVES);
Block(2,19,-1,LEAVES);
Block(3,13,-1,LEAVES);
Block(3,13,5,LEAVES);
Block(3,14,0,LEAVES);
Block(3,15,2,LEAVES);
Block(3,17,5,LEAVES);
Block(3,18,5,LEAVES);
Block(3,19,2,LEAVES);
Block(4,13,-1,LEAVES);
Block(4,15,2,LEAVES);
Block(4,19,2,LEAVES);
Block(5,14,2,LEAVES);
//   biomeMod 2019/02/06 20:35:23
//           created by matez 
//            all rights reserved   
    }

}