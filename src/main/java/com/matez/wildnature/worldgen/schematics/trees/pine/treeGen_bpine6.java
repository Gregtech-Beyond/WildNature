package com.matez.wildnature.worldgen.schematics.trees.pine;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_bpine6 extends WorldGenSchematicTree
{


    public treeGen_bpine6(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-7,0,-7,DIRT);
Block(-4,4,-4,LEAVES);
Block(-4,5,-4,LEAVES);
Block(-4,6,-4,LEAVES);
Block(-4,7,-4,LEAVES);
Block(-4,11,-4,LEAVES);
Block(-4,12,-4,LEAVES);
Block(-4,14,-4,LEAVES);
Block(-4,16,-4,LEAVES);
Block(-4,19,-4,LEAVES);
Block(-4,20,-4,LEAVES);
Block(-4,22,-4,LEAVES);
Block(-4,25,-4,LEAVES);
Block(-3,0,-4,DIRT);
Block(-3,1,-4,LOG);
Block(-3,2,-4,LOG);
Block(-3,3,-4,LOG);
Block(-3,4,-4,LOG);
Block(-3,4,-3,LEAVES);
Block(-3,5,-5,LEAVES);
Block(-3,5,-4,LOG);
Block(-3,6,-5,LEAVES);
Block(-3,6,-4,LOG);
Block(-3,6,-3,LEAVES);
Block(-3,7,-5,LEAVES);
Block(-3,7,-4,LOG);
Block(-3,7,-3,LEAVES);
Block(-3,8,-4,LOG);
Block(-3,8,-3,LEAVES);
Block(-3,9,-5,LEAVES);
Block(-3,9,-4,LOG);
Block(-3,9,-3,LEAVES);
Block(-3,10,-5,LEAVES);
Block(-3,10,-4,LOG);
Block(-3,10,-3,LEAVES);
Block(-3,11,-4,LOG);
Block(-3,11,-3,LEAVES);
Block(-3,12,-5,LEAVES);
Block(-3,12,-4,LOG);
Block(-3,12,-3,LEAVES);
Block(-3,13,-4,LOG);
Block(-3,13,-3,LEAVES);
Block(-3,14,-4,LOG);
Block(-3,15,-5,LEAVES);
Block(-3,15,-4,LOG);
Block(-3,15,-3,LEAVES);
Block(-3,16,-4,LOG);
Block(-3,16,-3,LEAVES);
Block(-3,17,-4,LOG);
Block(-3,18,-4,LOG);
Block(-3,19,-5,LEAVES);
Block(-3,19,-4,LOG);
Block(-3,19,-3,LEAVES);
Block(-3,20,-4,LOG);
Block(-3,20,-3,LEAVES);
Block(-3,21,-5,LEAVES);
Block(-3,21,-4,LOG);
Block(-3,21,-3,LEAVES);
Block(-3,22,-5,LEAVES);
Block(-3,22,-4,LOG);
Block(-3,22,-3,LEAVES);
Block(-3,23,-4,LOG);
Block(-3,24,-4,LOG);
Block(-3,24,-3,LEAVES);
Block(-3,25,-5,LEAVES);
Block(-3,25,-4,LOG);
Block(-3,25,-3,LEAVES);
Block(-3,26,-4,LEAVES);
Block(-2,4,-4,LEAVES);
Block(-2,6,-5,LEAVES);
Block(-2,7,-5,LEAVES);
Block(-2,7,-4,LEAVES);
Block(-2,8,-5,LEAVES);
Block(-2,8,-4,LEAVES);
Block(-2,9,-5,LEAVES);
Block(-2,9,-4,LEAVES);
Block(-2,10,-4,LEAVES);
Block(-2,11,-4,LEAVES);
Block(-2,12,-5,LEAVES);
Block(-2,20,-4,LEAVES);
Block(-2,22,-4,LEAVES);
Block(-2,25,-4,LEAVES);
Block(0,0,0,DIRT);
//   biomeMod 2019/05/11 17:09:53
//           created by matez 
//            all rights reserved   
    }

}
