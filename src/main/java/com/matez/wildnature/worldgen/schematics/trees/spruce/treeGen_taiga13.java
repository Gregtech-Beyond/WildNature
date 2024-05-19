package com.matez.wildnature.worldgen.schematics.trees.spruce;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

// TODO: Auto-generated Javadoc
public class treeGen_taiga13 extends WorldGenSchematicTree
{


    public treeGen_taiga13(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){

        Block(-2,2,-1,LEAVES);
        Block(-2,2,1,LEAVES);
        Block(-2,3,0,LEAVES);
        Block(-1,2,-2,LEAVES);
        Block(-1,2,0,LEAVES);
        Block(-1,2,2,LEAVES);
        Block(-1,3,-1,LEAVES);
        Block(-1,3,0,LEAVES);
        Block(-1,3,1,LEAVES);
        Block(-1,4,0,LEAVES);
        Block(0,0,0,DIRT);
        Block(0,1,0,LOG);
        Block(0,2,-1,LEAVES);
        Block(0,2,0,LOG);
        Block(0,2,1,LEAVES);
        Block(0,2,2,LEAVES);
        Block(0,3,0,LOG);
        Block(0,3,1,LEAVES);
        Block(0,4,-1,LEAVES);
        Block(0,4,0,LOG);
        Block(0,4,1,LEAVES);
        Block(0,5,-1,LEAVES);
        Block(0,5,0,LEAVES);
        Block(0,6,0,LEAVES);
        Block(0,7,0,LEAVES);
        Block(1,2,-2,LEAVES);
        Block(1,2,0,LEAVES);
        Block(1,3,-1,LEAVES);
        Block(1,3,1,LEAVES);
        Block(1,4,1,LEAVES);
        Block(1,5,0,LEAVES);
        Block(2,2,1,LEAVES);
        Block(2,3,0,LEAVES);
    }

}