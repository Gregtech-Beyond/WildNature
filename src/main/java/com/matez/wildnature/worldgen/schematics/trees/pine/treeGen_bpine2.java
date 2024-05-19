package com.matez.wildnature.worldgen.schematics.trees.pine;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_bpine2 extends WorldGenSchematicTree
{


    public treeGen_bpine2(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-1,7,0,LEAVES);
Block(-1,10,0,LEAVES);
Block(-1,11,0,LEAVES);
Block(-1,14,0,LEAVES);
Block(-1,15,0,LEAVES);
Block(0,0,0,DIRT);
Block(0,1,0,LOG);
Block(0,2,0,LOG);
Block(0,3,0,LOG);
Block(0,4,0,LOG);
Block(0,5,0,LOG);
Block(0,6,0,LOG);
Block(0,7,0,LOG);
Block(0,7,1,LEAVES);
Block(0,8,-1,LEAVES);
Block(0,8,0,LOG);
Block(0,9,0,LOG);
Block(0,10,-1,LEAVES);
Block(0,10,0,LOG);
Block(0,10,1,LEAVES);
Block(0,11,0,LOG);
Block(0,12,-1,LEAVES);
Block(0,12,0,LOG);
Block(0,13,0,LOG);
Block(0,14,-1,LEAVES);
Block(0,14,0,LOG);
Block(0,15,-1,LEAVES);
Block(0,15,0,LOG);
Block(0,15,1,LEAVES);
Block(0,16,0,LEAVES);
Block(1,7,0,LEAVES);
Block(1,10,0,LEAVES);
Block(1,11,0,LEAVES);
Block(1,14,0,LEAVES);
Block(1,15,0,LEAVES);
//   biomeMod 2019/05/11 17:09:53
//           created by matez 
//            all rights reserved   
    }

}
