package com.matez.wildnature.worldgen.schematics.trees.oak;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_oak5 extends WorldGenSchematicTree
{


    public treeGen_oak5(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-5,7,1,LEAVES);
Block(-4,5,0,LEAVES);
Block(-4,5,1,LEAVES);
Block(-4,6,0,LEAVES);
Block(-4,6,1,LEAVES);
Block(-4,6,2,LEAVES);
Block(-4,7,0,LEAVES);
Block(-4,7,1,LEAVES);
Block(-4,7,2,LEAVES);
Block(-4,8,0,LEAVES);
Block(-4,8,1,LEAVES);
Block(-3,4,0,LEAVES);
Block(-3,5,0,LEAVES);
Block(-3,5,1,LEAVES);
Block(-3,5,2,LEAVES);
Block(-3,6,-1,LEAVES);
Block(-3,6,0,LEAVES);
Block(-3,6,1,LEAVES);
Block(-3,7,-1,LEAVES);
Block(-3,7,0,LEAVES);
Block(-3,7,1,LOG);
Block(-3,7,2,LEAVES);
Block(-3,8,-2,LEAVES);
Block(-3,8,-1,LEAVES);
Block(-3,8,0,LEAVES);
Block(-3,8,1,LOG);
Block(-3,8,2,LEAVES);
Block(-3,9,0,LEAVES);
Block(-3,9,1,LEAVES);
Block(-2,4,1,LEAVES);
Block(-2,5,-1,LEAVES);
Block(-2,5,0,LOG);
Block(-2,5,1,LOG);
Block(-2,5,2,LEAVES);
Block(-2,6,-2,LEAVES);
Block(-2,6,-1,LOG);
Block(-2,6,0,LEAVES);
Block(-2,6,1,LOG);
Block(-2,6,2,LEAVES);
Block(-2,6,3,LEAVES);
Block(-2,7,-2,LEAVES);
Block(-2,7,-1,LEAVES);
Block(-2,7,0,LEAVES);
Block(-2,7,1,LOG);
Block(-2,7,2,LEAVES);
Block(-2,7,3,LEAVES);
Block(-2,8,-2,LEAVES);
Block(-2,8,-1,LEAVES);
Block(-2,8,0,LEAVES);
Block(-2,8,1,LEAVES);
Block(-2,9,-2,LEAVES);
Block(-2,9,-1,LEAVES);
Block(-2,9,0,LEAVES);
Block(-1,1,0,LOG);
Block(-1,1,1,LOG);
Block(-1,4,0,LOG);
Block(-1,5,0,LOG);
Block(-1,5,1,LEAVES);
Block(-1,6,-1,LOG);
Block(-1,6,1,LEAVES);
Block(-1,6,2,LEAVES);
Block(-1,7,-2,LEAVES);
Block(-1,7,-1,LOG);
Block(-1,7,2,LEAVES);
Block(-1,7,3,LEAVES);
Block(-1,8,-3,LEAVES);
Block(-1,8,-2,LEAVES);
Block(-1,8,-1,LOG);
Block(-1,8,0,LEAVES);
Block(-1,8,1,LEAVES);
Block(-1,8,3,LEAVES);
Block(-1,9,-3,LEAVES);
Block(-1,9,-2,LEAVES);
Block(-1,9,-1,LOG);
Block(-1,9,0,LEAVES);
Block(-1,10,-1,LEAVES);
Block(-1,10,0,LEAVES);
Block(-1,11,-1,LEAVES);
Block(0,0,0,DIRT);
Block(0,1,0,LOG);
Block(0,1,1,LOG);
Block(0,2,0,LOG);
Block(0,2,1,LOG);
Block(0,3,0,LOG);
Block(0,4,-1,LOG);
Block(0,4,0,LOG);
Block(0,5,-1,LOG);
Block(0,5,0,LOG);
Block(0,5,1,LOG);
Block(0,6,-2,LEAVES);
Block(0,6,-1,LOG);
Block(0,6,0,LOG);
Block(0,6,2,LEAVES);
Block(0,7,-3,LEAVES);
Block(0,7,-1,LOG);
Block(0,7,0,LOG);
Block(0,7,2,LEAVES);
Block(0,7,3,LEAVES);
Block(0,8,-3,LEAVES);
Block(0,8,-2,LEAVES);
Block(0,8,-1,LEAVES);
Block(0,8,0,LEAVES);
Block(0,8,1,LEAVES);
Block(0,8,2,LEAVES);
Block(0,8,3,LEAVES);
Block(0,8,4,LEAVES);
Block(0,9,-1,LEAVES);
Block(0,9,0,LEAVES);
Block(0,9,1,LEAVES);
Block(0,9,2,LEAVES);
Block(0,9,3,LEAVES);
Block(0,10,-2,LEAVES);
Block(0,10,0,LEAVES);
Block(0,11,-1,LEAVES);
Block(1,1,0,LOG);
Block(1,1,1,LOG);
Block(1,2,0,LOG);
Block(1,3,0,LOG);
Block(1,4,-1,LOG);
Block(1,5,-3,LEAVES);
Block(1,5,-2,LEAVES);
Block(1,5,-1,LOG);
Block(1,5,1,LOG);
Block(1,6,-3,LEAVES);
Block(1,6,-2,LOG);
Block(1,6,-1,LOG);
Block(1,6,0,LOG);
Block(1,6,1,LOG);
Block(1,6,2,LOG);
Block(1,6,3,LEAVES);
Block(1,7,-4,LEAVES);
Block(1,7,-3,LEAVES);
Block(1,7,0,LOG);
Block(1,7,2,LEAVES);
Block(1,7,3,LEAVES);
Block(1,7,4,LEAVES);
Block(1,8,-4,LEAVES);
Block(1,8,-2,LEAVES);
Block(1,8,0,LOG);
Block(1,8,1,LEAVES);
Block(1,8,2,LEAVES);
Block(1,8,3,LEAVES);
Block(1,8,4,LEAVES);
Block(1,8,5,LEAVES);
Block(1,9,-3,LEAVES);
Block(1,9,-2,LEAVES);
Block(1,9,-1,LOG);
Block(1,9,0,LOG);
Block(1,9,1,LEAVES);
Block(1,9,3,LEAVES);
Block(1,9,4,LEAVES);
Block(1,10,-2,LEAVES);
Block(1,10,-1,LOG);
Block(1,10,0,LEAVES);
Block(1,11,-2,LEAVES);
Block(1,11,-1,LEAVES);
Block(1,11,0,LEAVES);
Block(2,5,-3,LEAVES);
Block(2,5,-2,LEAVES);
Block(2,5,-1,LEAVES);
Block(2,5,2,LEAVES);
Block(2,5,3,LEAVES);
Block(2,6,-4,LEAVES);
Block(2,6,-3,LEAVES);
Block(2,6,-2,LOG);
Block(2,6,-1,LEAVES);
Block(2,6,1,LEAVES);
Block(2,6,2,LOG);
Block(2,6,3,LOG);
Block(2,6,4,LEAVES);
Block(2,7,-5,LEAVES);
Block(2,7,-4,LEAVES);
Block(2,7,-3,LOG);
Block(2,7,-2,LOG);
Block(2,7,-1,LEAVES);
Block(2,7,1,LEAVES);
Block(2,7,2,LEAVES);
Block(2,7,3,LOG);
Block(2,7,4,LEAVES);
Block(2,8,-4,LEAVES);
Block(2,8,-3,LEAVES);
Block(2,8,-2,LEAVES);
Block(2,8,-1,LEAVES);
Block(2,8,0,LEAVES);
Block(2,8,1,LEAVES);
Block(2,8,2,LEAVES);
Block(2,8,3,LOG);
Block(2,8,4,LEAVES);
Block(2,9,-3,LEAVES);
Block(2,9,-2,LEAVES);
Block(2,9,-1,LEAVES);
Block(2,9,0,LEAVES);
Block(2,9,3,LEAVES);
Block(2,10,-3,LEAVES);
Block(2,10,-2,LEAVES);
Block(2,10,-1,LEAVES);
Block(2,10,0,LEAVES);
Block(2,11,-2,LEAVES);
Block(2,11,-1,LEAVES);
Block(3,5,-2,LEAVES);
Block(3,5,3,LEAVES);
Block(3,6,-3,LEAVES);
Block(3,6,-2,LEAVES);
Block(3,6,-1,LEAVES);
Block(3,6,2,LEAVES);
Block(3,6,3,LEAVES);
Block(3,6,4,LEAVES);
Block(3,7,-4,LEAVES);
Block(3,7,-3,LOG);
Block(3,7,-2,LEAVES);
Block(3,7,-1,LEAVES);
Block(3,7,1,LEAVES);
Block(3,7,2,LEAVES);
Block(3,7,3,LEAVES);
Block(3,7,4,LEAVES);
Block(3,8,-4,LEAVES);
Block(3,8,-3,LEAVES);
Block(3,8,2,LEAVES);
Block(3,8,3,LEAVES);
Block(3,9,-1,LEAVES);
Block(3,10,-2,LEAVES);
Block(3,10,-1,LEAVES);
Block(4,6,-2,LEAVES);
Block(4,6,2,LEAVES);
Block(4,6,3,LEAVES);
Block(4,7,-3,LEAVES);
Block(4,7,-2,LEAVES);
Block(4,7,3,LEAVES);
Block(4,8,3,LEAVES);
//   biomeMod 2019/02/06 20:34:42
//           created by matez 
//            all rights reserved   
    }

}