package com.matez.wildnature.worldgen.schematics.trees.palm;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class treeGen_palm12 extends WorldGenSchematicTree
{


    public treeGen_palm12(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(2,6,6,LEAVES);
Block(3,7,6,LEAVES);
Block(3,10,3,LEAVES);
Block(4,5,9,LEAVES);
Block(4,6,3,LEAVES);
Block(4,7,4,LEAVES);
Block(4,8,6,LEAVES);
Block(4,9,4,LEAVES);
Block(5,6,8,LEAVES);
Block(5,7,7,LEAVES);
Block(5,8,5,LEAVES);
Block(5,8,6,LEAVES);
Block(5,9,6,LEAVES);
Block(5,9,7,LEAVES);
Block(5,10,7,LEAVES);
Block(5,11,8,LEAVES);
Block(6,1,6,LOG);
Block(6,2,6,LOG);
Block(6,3,6,LOG);
Block(6,4,6,LOG);
Block(6,5,6,LOG);
Block(6,5,7,LEAVES);
Block(6,6,4,LEAVES);
Block(6,6,5,LEAVES);
Block(6,6,6,LOG);
Block(6,7,4,LEAVES);
Block(6,7,5,LEAVES);
Block(6,7,6,LOG);
Block(6,7,8,LEAVES);
Block(6,8,5,LEAVES);
Block(6,8,6,LEAVES);
Block(6,8,7,LEAVES);
Block(6,9,4,LEAVES);
Block(6,9,5,LEAVES);
Block(6,9,6,LEAVES);
Block(6,10,4,LEAVES);
Block(7,5,2,LEAVES);
Block(7,5,9,LEAVES);
Block(7,6,3,LEAVES);
Block(7,6,6,LEAVES);
Block(7,6,9,LEAVES);
Block(7,7,5,LEAVES);
Block(7,7,6,LEAVES);
Block(7,8,6,LEAVES);
Block(7,9,6,LEAVES);
Block(7,9,7,LEAVES);
Block(7,11,4,LEAVES);
Block(8,6,5,LEAVES);
Block(8,7,7,LEAVES);
Block(8,9,6,LEAVES);
Block(8,10,8,LEAVES);
Block(8,11,8,LEAVES);
Block(9,5,5,LEAVES);
Block(9,10,6,LEAVES);
Block(10,11,6,LEAVES);
//   biomeMod 2019/02/06 20:35:23
//           created by matez 
//            all rights reserved   
    }

}