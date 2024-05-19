package com.matez.wildnature.worldgen.schematics.trees.pine;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_bpine5 extends WorldGenSchematicTree
{


    public treeGen_bpine5(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-6,0,-5,DIRT);
Block(-4,6,-3,LEAVES);
Block(-4,7,-3,LEAVES);
Block(-4,10,-3,LEAVES);
Block(-4,12,-3,LEAVES);
Block(-4,13,-3,LEAVES);
Block(-4,14,-3,LEAVES);
Block(-4,15,-3,LEAVES);
Block(-4,16,-3,LEAVES);
Block(-4,20,-3,LEAVES);
Block(-4,23,-3,LEAVES);
Block(-3,0,-3,DIRT);
Block(-3,1,-3,LOG);
Block(-3,2,-3,LOG);
Block(-3,3,-3,LOG);
Block(-3,4,-3,LOG);
Block(-3,5,-3,LOG);
Block(-3,6,-3,LOG);
Block(-3,6,-2,LEAVES);
Block(-3,7,-4,LEAVES);
Block(-3,7,-3,LOG);
Block(-3,8,-3,LOG);
Block(-3,9,-3,LOG);
Block(-3,9,-2,LEAVES);
Block(-3,10,-3,LOG);
Block(-3,11,-3,LOG);
Block(-3,11,-2,LEAVES);
Block(-3,12,-3,LOG);
Block(-3,12,-2,LEAVES);
Block(-3,13,-3,LOG);
Block(-3,14,-4,LEAVES);
Block(-3,14,-3,LOG);
Block(-3,14,-2,LEAVES);
Block(-3,15,-4,LEAVES);
Block(-3,15,-3,LOG);
Block(-3,15,-2,LEAVES);
Block(-3,16,-4,LEAVES);
Block(-3,16,-3,LOG);
Block(-3,17,-3,LOG);
Block(-3,17,-2,LEAVES);
Block(-3,18,-4,LEAVES);
Block(-3,18,-3,LOG);
Block(-3,18,-2,LEAVES);
Block(-3,19,-3,LOG);
Block(-3,19,-2,LEAVES);
Block(-3,20,-4,LEAVES);
Block(-3,20,-3,LOG);
Block(-3,21,-3,LOG);
Block(-3,22,-3,LOG);
Block(-3,23,-4,LEAVES);
Block(-3,23,-3,LOG);
Block(-3,23,-2,LEAVES);
Block(-3,24,-3,LEAVES);
Block(-2,5,-2,LEAVES);
Block(-2,6,-3,LEAVES);
Block(-2,6,-2,LEAVES);
Block(-2,7,-2,LEAVES);
Block(-2,8,-3,LEAVES);
Block(-2,8,-2,LEAVES);
Block(-2,9,-3,LEAVES);
Block(-2,10,-3,LEAVES);
Block(-2,11,-2,LEAVES);
Block(-2,13,-3,LEAVES);
Block(-2,14,-3,LEAVES);
Block(-2,14,-2,LEAVES);
Block(-2,15,-3,LEAVES);
Block(-2,16,-3,LEAVES);
Block(-2,19,-2,LEAVES);
Block(-2,22,-3,LEAVES);
Block(-2,23,-3,LEAVES);
Block(0,0,0,DIRT);
//   biomeMod 2019/05/11 17:09:53
//           created by matez 
//            all rights reserved   
    }

}
