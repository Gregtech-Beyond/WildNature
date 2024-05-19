package com.matez.wildnature.worldgen.schematics.trees.palm;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_palm13 extends WorldGenSchematicTree
{


    public treeGen_palm13(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-6,10,1,LEAVES);
Block(-5,7,-4,LEAVES);
Block(-5,7,3,LEAVES);
Block(-5,8,-3,LEAVES);
Block(-5,9,-3,LEAVES);
Block(-5,11,1,LEAVES);
Block(-5,12,1,LEAVES);
Block(-4,8,2,LEAVES);
Block(-4,8,3,LEAVES);
Block(-4,9,-3,LEAVES);
Block(-4,9,-2,LEAVES);
Block(-4,9,2,LEAVES);
Block(-4,12,1,LEAVES);
Block(-4,13,2,LEAVES);
Block(-3,9,-5,LEAVES);
Block(-3,9,-2,LEAVES);
Block(-3,9,1,LEAVES);
Block(-3,9,2,LEAVES);
Block(-3,10,-4,LEAVES);
Block(-3,10,-2,LEAVES);
Block(-3,10,-1,LEAVES);
Block(-3,10,0,LEAVES);
Block(-3,10,1,LEAVES);
Block(-3,11,0,LEAVES);
Block(-3,11,1,LEAVES);
Block(-3,12,-2,LEAVES);
Block(-2,9,-2,LEAVES);
Block(-2,9,-1,LEAVES);
Block(-2,9,0,LOG);
Block(-2,10,-4,LEAVES);
Block(-2,10,-1,LEAVES);
Block(-2,10,0,LEAVES);
Block(-2,10,1,LEAVES);
Block(-2,10,2,LEAVES);
Block(-2,11,-4,LEAVES);
Block(-2,11,-3,LEAVES);
Block(-2,11,-2,LEAVES);
Block(-2,11,-1,LEAVES);
Block(-2,11,0,LEAVES);
Block(-2,12,-2,LEAVES);
Block(-2,13,-3,LEAVES);
Block(-1,1,0,LOG);
Block(-1,2,0,LOG);
Block(-1,6,-1,LOG);
Block(-1,7,-1,LOG);
Block(-1,8,-1,LOG);
Block(-1,8,0,LOG);
Block(-1,8,3,LEAVES);
Block(-1,8,4,LEAVES);
Block(-1,9,-3,LEAVES);
Block(-1,9,-2,LEAVES);
Block(-1,9,2,LEAVES);
Block(-1,9,3,LEAVES);
Block(-1,9,4,LEAVES);
Block(-1,10,-1,LEAVES);
Block(-1,10,0,LEAVES);
Block(-1,10,1,LEAVES);
Block(-1,10,2,LEAVES);
Block(-1,11,-1,LEAVES);
Block(-1,11,1,LEAVES);
Block(-1,12,-2,LEAVES);
Block(-1,12,-1,LEAVES);
Block(-1,13,1,LEAVES);
Block(0,0,0,DIRT);
Block(0,1,-1,LOG);
Block(0,1,0,LOG);
Block(0,1,1,LOG);
Block(0,2,-1,LOG);
Block(0,2,0,LOG);
Block(0,3,0,LOG);
Block(0,4,-1,LOG);
Block(0,4,0,LOG);
Block(0,5,-1,LOG);
Block(0,6,-1,LOG);
Block(0,7,5,LEAVES);
Block(0,8,-4,LEAVES);
Block(0,8,-3,LEAVES);
Block(0,8,4,LEAVES);
Block(0,9,-3,LEAVES);
Block(0,9,1,LEAVES);
Block(0,10,-1,LEAVES);
Block(0,10,1,LEAVES);
Block(0,11,1,LEAVES);
Block(0,11,2,LEAVES);
Block(0,12,-3,LEAVES);
Block(0,12,-2,LEAVES);
Block(0,12,2,LEAVES);
Block(1,1,0,LOG);
Block(1,7,-4,LEAVES);
Block(1,8,-4,LEAVES);
Block(1,8,1,LEAVES);
Block(1,8,2,LEAVES);
Block(1,9,1,LEAVES);
Block(1,9,2,LEAVES);
Block(1,10,-2,LEAVES);
Block(1,10,-1,LEAVES);
Block(1,11,-5,LEAVES);
Block(1,11,-4,LEAVES);
Block(1,12,-4,LEAVES);
Block(1,12,-3,LEAVES);
Block(1,12,2,LEAVES);
Block(1,12,3,LEAVES);
Block(2,6,-5,LEAVES);
Block(2,7,-4,LEAVES);
Block(2,8,2,LEAVES);
Block(2,8,3,LEAVES);
Block(2,10,-5,LEAVES);
Block(2,10,-2,LEAVES);
Block(2,11,3,LEAVES);
Block(2,12,3,LEAVES);
Block(3,7,3,LEAVES);
Block(3,9,-2,LEAVES);
Block(3,10,4,LEAVES);
Block(3,11,4,LEAVES);
//   biomeMod 2019/02/06 20:35:23
//           created by matez 
//            all rights reserved   
    }

}