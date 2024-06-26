package com.matez.wildnature.worldgen.schematics.trees.birch;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_birch5 extends WorldGenSchematicTree
{


    public treeGen_birch5(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-3,5,1,LEAVES);
Block(-2,5,-1,LEAVES);
Block(-2,5,0,LEAVES);
Block(-2,5,1,LEAVES);
Block(-2,6,-1,LEAVES);
Block(-2,7,-2,LEAVES);
Block(-2,7,0,LEAVES);
Block(-2,8,-2,LEAVES);
Block(-2,8,0,LEAVES);
Block(-2,10,-1,LEAVES);
Block(-2,10,0,LEAVES);
Block(-1,4,1,LEAVES);
Block(-1,5,1,LEAVES);
Block(-1,6,-3,LEAVES);
Block(-1,6,-2,LEAVES);
Block(-1,6,-1,LEAVES);
Block(-1,6,0,LEAVES);
Block(-1,6,1,LEAVES);
Block(-1,7,-2,LEAVES);
Block(-1,7,0,LEAVES);
Block(-1,7,1,LEAVES);
Block(-1,7,2,LEAVES);
Block(-1,8,-1,LEAVES);
Block(-1,8,1,LEAVES);
Block(-1,9,-1,LEAVES);
Block(-1,9,0,LEAVES);
Block(-1,9,1,LEAVES);
Block(-1,9,2,LEAVES);
Block(-1,10,-1,LEAVES);
Block(-1,10,0,LEAVES);
Block(-1,11,-1,LEAVES);
Block(-1,11,0,LEAVES);
Block(0,0,0,DIRT);
Block(0,1,0,LOG);
Block(0,2,0,LOG);
Block(0,3,0,LOG);
Block(0,4,0,LOG);
Block(0,5,-1,LEAVES);
Block(0,5,0,LOG);
Block(0,5,1,LEAVES);
Block(0,6,-2,LEAVES);
Block(0,6,-1,LEAVES);
Block(0,6,0,LEAVES);
Block(0,6,1,LEAVES);
Block(0,6,2,LEAVES);
Block(0,7,-3,LEAVES);
Block(0,7,-2,LEAVES);
Block(0,7,-1,LEAVES);
Block(0,7,0,LEAVES);
Block(0,7,1,LEAVES);
Block(0,7,2,LEAVES);
Block(0,7,3,LEAVES);
Block(0,8,-2,LEAVES);
Block(0,8,-1,LEAVES);
Block(0,8,0,LOG);
Block(0,8,1,LEAVES);
Block(0,9,-2,LEAVES);
Block(0,9,-1,LEAVES);
Block(0,9,0,LEAVES);
Block(0,9,1,LEAVES);
Block(0,10,-2,LEAVES);
Block(0,10,-1,LEAVES);
Block(0,10,0,LEAVES);
Block(0,10,1,LEAVES);
Block(0,10,2,LEAVES);
Block(0,11,-1,LEAVES);
Block(0,11,0,LEAVES);
Block(0,11,1,LEAVES);
Block(0,12,-1,LEAVES);
Block(0,12,0,LEAVES);
Block(0,13,0,LEAVES);
Block(1,4,0,LEAVES);
Block(1,5,-2,LEAVES);
Block(1,5,1,LEAVES);
Block(1,5,2,LEAVES);
Block(1,6,-2,LEAVES);
Block(1,6,-1,LEAVES);
Block(1,6,0,LEAVES);
Block(1,6,1,LEAVES);
Block(1,6,2,LEAVES);
Block(1,6,3,LEAVES);
Block(1,7,-3,LEAVES);
Block(1,7,-2,LEAVES);
Block(1,7,-1,LEAVES);
Block(1,7,0,LEAVES);
Block(1,7,1,LEAVES);
Block(1,8,-3,LEAVES);
Block(1,8,-1,LEAVES);
Block(1,8,0,LEAVES);
Block(1,8,1,LEAVES);
Block(1,9,-2,LEAVES);
Block(1,9,-1,LEAVES);
Block(1,9,0,LEAVES);
Block(1,9,1,LEAVES);
Block(1,10,-1,LEAVES);
Block(1,10,0,LEAVES);
Block(1,10,2,LEAVES);
Block(1,11,0,LEAVES);
Block(2,6,-1,LEAVES);
Block(2,7,-2,LEAVES);
Block(2,7,-1,LEAVES);
Block(2,8,-3,LEAVES);
Block(2,8,-1,LEAVES);
Block(2,8,0,LEAVES);
Block(2,9,0,LEAVES);
Block(2,10,0,LEAVES);
//   biomeMod 2019/02/06 18:41:49
//           created by matez 
//            all rights reserved   
    }

}