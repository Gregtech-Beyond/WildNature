package com.matez.wildnature.worldgen.schematics.trees.pine;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_bpine4 extends WorldGenSchematicTree
{


    public treeGen_bpine4(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-4,0,-3,DIRT);
Block(-3,9,-2,LEAVES);
Block(-3,10,-2,LEAVES);
Block(-3,11,-2,LEAVES);
Block(-3,13,-2,LEAVES);
Block(-3,14,-2,LEAVES);
Block(-3,17,-2,LEAVES);
Block(-3,19,-2,LEAVES);
Block(-3,21,-2,LEAVES);
Block(-2,0,-2,DIRT);
Block(-2,1,-2,LOG);
Block(-2,2,-2,LOG);
Block(-2,3,-2,LOG);
Block(-2,4,-2,LOG);
Block(-2,5,-2,LOG);
Block(-2,6,-2,LOG);
Block(-2,7,-2,LOG);
Block(-2,7,-1,LEAVES);
Block(-2,8,-3,LEAVES);
Block(-2,8,-2,LOG);
Block(-2,9,-2,LOG);
Block(-2,10,-2,LOG);
Block(-2,11,-2,LOG);
Block(-2,12,-2,LOG);
Block(-2,13,-2,LOG);
Block(-2,13,-1,LEAVES);
Block(-2,14,-3,LEAVES);
Block(-2,14,-2,LOG);
Block(-2,15,-2,LOG);
Block(-2,15,-1,LEAVES);
Block(-2,16,-2,LOG);
Block(-2,17,-3,LEAVES);
Block(-2,17,-2,LOG);
Block(-2,18,-2,LOG);
Block(-2,19,-3,LEAVES);
Block(-2,19,-2,LOG);
Block(-2,19,-1,LEAVES);
Block(-2,20,-2,LOG);
Block(-2,21,-3,LEAVES);
Block(-2,21,-2,LOG);
Block(-2,21,-1,LEAVES);
Block(-2,22,-2,LEAVES);
Block(-1,7,-2,LEAVES);
Block(-1,8,-2,LEAVES);
Block(-1,10,-2,LEAVES);
Block(-1,12,-2,LEAVES);
Block(-1,15,-2,LEAVES);
Block(-1,17,-2,LEAVES);
Block(-1,21,-2,LEAVES);
Block(0,0,0,DIRT);
//   biomeMod 2019/05/11 17:09:53
//           created by matez 
//            all rights reserved   
    }

}
