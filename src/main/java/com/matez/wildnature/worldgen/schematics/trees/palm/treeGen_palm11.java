package com.matez.wildnature.worldgen.schematics.trees.palm;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_palm11 extends WorldGenSchematicTree
{


    public treeGen_palm11(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-7,8,-1,LEAVES);
Block(-7,9,-1,LEAVES);
Block(-7,10,-1,LEAVES);
Block(-6,10,-2,LEAVES);
Block(-6,10,-1,LEAVES);
Block(-6,11,-1,LEAVES);
Block(-5,9,-1,LEAVES);
Block(-5,10,-5,LEAVES);
Block(-5,10,-2,LEAVES);
Block(-5,10,-1,LEAVES);
Block(-5,10,2,LEAVES);
Block(-5,11,-5,LEAVES);
Block(-5,11,-4,LEAVES);
Block(-5,11,-2,LEAVES);
Block(-5,11,1,LEAVES);
Block(-5,11,2,LEAVES);
Block(-4,9,-2,LEAVES);
Block(-4,9,-1,LEAVES);
Block(-4,10,-3,LEAVES);
Block(-4,10,-2,LEAVES);
Block(-4,11,-4,LEAVES);
Block(-4,11,-3,LEAVES);
Block(-4,11,0,LEAVES);
Block(-4,11,1,LEAVES);
Block(-3,8,-2,LEAVES);
Block(-3,9,-3,LEAVES);
Block(-3,9,-2,LEAVES);
Block(-3,10,-6,LEAVES);
Block(-3,10,-5,LEAVES);
Block(-3,10,-3,LEAVES);
Block(-3,10,-2,LEAVES);
Block(-3,10,-1,LEAVES);
Block(-3,10,0,LEAVES);
Block(-3,11,-5,LEAVES);
Block(-3,11,-2,LEAVES);
Block(-3,11,0,LEAVES);
Block(-2,6,-1,LEAVES);
Block(-2,7,-3,LEAVES);
Block(-2,7,-2,LOG);
Block(-2,8,-3,LEAVES);
Block(-2,8,-2,LOG);
Block(-2,8,-1,LEAVES);
Block(-2,9,-7,LEAVES);
Block(-2,9,-5,LEAVES);
Block(-2,9,-3,LEAVES);
Block(-2,9,-2,LOG);
Block(-2,9,-1,LEAVES);
Block(-2,9,0,LEAVES);
Block(-2,10,-7,LEAVES);
Block(-2,10,-6,LEAVES);
Block(-2,10,-5,LEAVES);
Block(-2,10,-3,LEAVES);
Block(-2,10,-2,LEAVES);
Block(-2,10,-1,LEAVES);
Block(-2,10,0,LEAVES);
Block(-2,11,-3,LEAVES);
Block(-2,11,-1,LEAVES);
Block(-1,1,-1,LOG);
Block(-1,5,-1,LOG);
Block(-1,6,-1,LOG);
Block(-1,7,-1,LOG);
Block(-1,8,-2,LEAVES);
Block(-1,9,-3,LEAVES);
Block(-1,9,-2,LEAVES);
Block(-1,9,-1,LEAVES);
Block(-1,10,-4,LEAVES);
Block(-1,10,-3,LEAVES);
Block(-1,10,-2,LEAVES);
Block(-1,10,-1,LEAVES);
Block(-1,10,0,LEAVES);
Block(-1,11,-4,LEAVES);
Block(-1,11,-2,LEAVES);
Block(-1,11,0,LEAVES);
Block(-1,11,1,LEAVES);
Block(0,0,0,DIRT);
Block(0,1,0,LOG);
Block(0,1,1,LOG);
Block(0,2,0,LOG);
Block(0,3,0,LOG);
Block(0,4,0,LOG);
Block(0,5,0,LOG);
Block(0,10,-2,LEAVES);
Block(0,10,-1,LEAVES);
Block(0,10,2,LEAVES);
Block(0,11,-5,LEAVES);
Block(0,11,-4,LEAVES);
Block(0,11,-1,LEAVES);
Block(0,11,1,LEAVES);
Block(0,11,2,LEAVES);
Block(1,1,1,LOG);
Block(1,2,1,LOG);
Block(1,10,-5,LEAVES);
Block(1,11,-5,LEAVES);
Block(1,11,-2,LEAVES);
Block(1,11,-1,LEAVES);
Block(2,10,-2,LEAVES);
Block(2,11,-2,LEAVES);
//   biomeMod 2019/02/06 20:35:23
//           created by matez 
//            all rights reserved   
    }

}