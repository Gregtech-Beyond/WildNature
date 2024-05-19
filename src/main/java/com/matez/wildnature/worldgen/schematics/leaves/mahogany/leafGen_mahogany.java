package com.matez.wildnature.worldgen.schematics.leaves.mahogany;

import com.matez.wildnature.worldgen.WorldGenSchematicLeaves;
import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class leafGen_mahogany extends WorldGenSchematicLeaves
{


    public leafGen_mahogany(boolean parShouldNotify, @Nullable IBlockState leavesState)
    {
        super(parShouldNotify,leavesState);

        if(!(leavesState==null)){
            LEAVES = leavesState;
        }
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-5,1,-2,LEAVES);
Block(-5,1,-1,LEAVES);
Block(-5,1,0,LEAVES);
Block(-5,1,1,LEAVES);
Block(-4,1,-5,LEAVES);
Block(-4,1,-4,LEAVES);
Block(-4,1,-3,LEAVES);
Block(-4,1,-2,LEAVES);
Block(-4,1,-1,LEAVES);
Block(-4,1,0,LEAVES);
Block(-4,1,1,LEAVES);
Block(-4,1,2,LEAVES);
Block(-4,2,-1,LEAVES);
Block(-4,2,0,LEAVES);
Block(-3,1,-5,LEAVES);
Block(-3,1,-4,LEAVES);
Block(-3,1,-3,LEAVES);
Block(-3,1,-2,LEAVES);
Block(-3,1,-1,LEAVES);
Block(-3,1,0,LEAVES);
Block(-3,1,1,LEAVES);
Block(-3,1,2,LEAVES);
Block(-3,1,3,LEAVES);
Block(-3,1,4,LEAVES);
Block(-3,2,-3,LEAVES);
Block(-3,2,-2,LEAVES);
Block(-3,2,-1,LEAVES);
Block(-3,2,0,LEAVES);
Block(-3,2,1,LEAVES);
Block(-3,3,-1,LEAVES);
Block(-3,3,0,LEAVES);
Block(-2,1,-6,LEAVES);
Block(-2,1,-5,LEAVES);
Block(-2,1,-4,LEAVES);
Block(-2,1,-3,LEAVES);
Block(-2,1,-2,LEAVES);
Block(-2,1,-1,LEAVES);
Block(-2,1,0,LEAVES);
Block(-2,1,1,LEAVES);
Block(-2,1,2,LEAVES);
Block(-2,1,3,LEAVES);
Block(-2,1,4,LEAVES);
Block(-2,1,5,LEAVES);
Block(-2,2,-4,LEAVES);
Block(-2,2,-3,LEAVES);
Block(-2,2,-2,LEAVES);
Block(-2,2,-1,LEAVES);
Block(-2,2,0,LEAVES);
Block(-2,2,1,LEAVES);
Block(-2,2,2,LEAVES);
Block(-2,2,3,LEAVES);
Block(-2,3,-3,LEAVES);
Block(-2,3,-2,LEAVES);
Block(-2,3,-1,LEAVES);
Block(-2,3,0,LEAVES);
Block(-2,3,1,LEAVES);
Block(-1,1,-6,LEAVES);
Block(-1,1,-5,LEAVES);
Block(-1,1,-4,LEAVES);
Block(-1,1,-3,LEAVES);
Block(-1,1,-2,LEAVES);
Block(-1,1,-1,LEAVES);
Block(-1,1,0,LEAVES);
Block(-1,1,1,LEAVES);
Block(-1,1,2,LEAVES);
Block(-1,1,3,LEAVES);
Block(-1,1,4,LEAVES);
Block(-1,1,5,LEAVES);
Block(-1,2,-4,LEAVES);
Block(-1,2,-3,LEAVES);
Block(-1,2,-2,LEAVES);
Block(-1,2,-1,LEAVES);
Block(-1,2,0,LEAVES);
Block(-1,2,1,LEAVES);
Block(-1,2,2,LEAVES);
Block(-1,2,3,LEAVES);
Block(-1,2,4,LEAVES);
Block(-1,3,-3,LEAVES);
Block(-1,3,-2,LEAVES);
Block(-1,3,0,LEAVES);
Block(-1,3,1,LEAVES);
Block(-1,4,-1,LEAVES);
Block(-1,4,0,LEAVES);
Block(0,0,0,AIR);
Block(0,1,-6,LEAVES);
Block(0,1,-5,LEAVES);
Block(0,1,-4,LEAVES);
Block(0,1,-3,LEAVES);
Block(0,1,-2,LEAVES);
Block(0,1,-1,LEAVES);
Block(0,1,0,LEAVES);
Block(0,1,1,LEAVES);
Block(0,1,2,LEAVES);
Block(0,1,3,LEAVES);
Block(0,1,4,LEAVES);
Block(0,1,5,LEAVES);
Block(0,2,-4,LEAVES);
Block(0,2,-2,LEAVES);
Block(0,2,-1,LEAVES);
Block(0,2,0,LEAVES);
Block(0,2,1,LEAVES);
Block(0,2,2,LEAVES);
Block(0,2,3,LEAVES);
Block(0,2,4,LEAVES);
Block(0,3,-3,LEAVES);
Block(0,3,-2,LEAVES);
Block(0,3,-1,LEAVES);
Block(0,3,0,LEAVES);
Block(0,3,1,LEAVES);
Block(0,3,2,LEAVES);
Block(0,4,-1,LEAVES);
Block(0,4,0,LEAVES);
Block(1,1,-6,LEAVES);
Block(1,1,-5,LEAVES);
Block(1,1,-4,LEAVES);
Block(1,1,-3,LEAVES);
Block(1,1,-2,LEAVES);
Block(1,1,-1,LEAVES);
Block(1,1,0,LEAVES);
Block(1,1,1,LEAVES);
Block(1,1,2,LEAVES);
Block(1,1,3,LEAVES);
Block(1,1,4,LEAVES);
Block(1,1,5,LEAVES);
Block(1,2,-4,LEAVES);
Block(1,2,-3,LEAVES);
Block(1,2,-2,LEAVES);
Block(1,2,-1,LEAVES);
Block(1,2,0,LEAVES);
Block(1,2,1,LEAVES);
Block(1,2,2,LEAVES);
Block(1,2,3,LEAVES);
Block(1,3,-2,LEAVES);
Block(1,3,-1,LEAVES);
Block(1,3,0,LEAVES);
Block(1,3,1,LEAVES);
Block(1,4,-1,LEAVES);
Block(2,1,-4,LEAVES);
Block(2,1,-3,LEAVES);
Block(2,1,-2,LEAVES);
Block(2,1,-1,LEAVES);
Block(2,1,0,LEAVES);
Block(2,1,1,LEAVES);
Block(2,1,2,LEAVES);
Block(2,1,3,LEAVES);
Block(2,1,4,LEAVES);
Block(2,2,-3,LEAVES);
Block(2,2,-2,LEAVES);
Block(2,2,-1,LEAVES);
Block(2,2,0,LEAVES);
Block(2,2,1,LEAVES);
Block(2,2,2,LEAVES);
Block(2,3,-1,LEAVES);
Block(2,3,0,LEAVES);
Block(3,1,-4,LEAVES);
Block(3,1,-3,LEAVES);
Block(3,1,-2,LEAVES);
Block(3,1,-1,LEAVES);
Block(3,1,0,LEAVES);
Block(3,1,1,LEAVES);
Block(3,1,2,LEAVES);
Block(3,1,3,LEAVES);
Block(3,2,-2,LEAVES);
Block(3,2,-1,LEAVES);
Block(3,2,0,LEAVES);
Block(3,2,1,LEAVES);
Block(4,1,-3,LEAVES);
Block(4,1,-2,LEAVES);
Block(4,1,-1,LEAVES);
Block(4,1,0,LEAVES);
Block(4,1,1,LEAVES);
Block(4,1,2,LEAVES);
Block(4,2,0,LEAVES);
Block(5,1,-2,LEAVES);
Block(5,1,-1,LEAVES);
Block(5,1,0,LEAVES);
Block(5,1,1,LEAVES);
//   biomeMod 2019/02/23 21:28:53
//           created by matez 
//            all rights reserved   
    }

}