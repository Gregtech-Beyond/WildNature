package com.matez.wildnature.worldgen.schematics.leaves.willow;

import com.matez.wildnature.worldgen.WorldGenSchematicLeaves;
import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class leafGen_willowLeaf extends WorldGenSchematicLeaves
{


    public leafGen_willowLeaf(boolean parShouldNotify, @Nullable IBlockState leavesState)
    {
        super(parShouldNotify,leavesState);

        this.spawnVines = true;

        if(!(leavesState==null)){
            LEAVES = leavesState;
        }
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        
Block(-4,1,-1,LEAVES);
Block(-4,1,0,LEAVES);
Block(-4,1,1,LEAVES);
Block(-4,1,2,LEAVES);
//Block(-4,2,0,106:8);
//Block(-4,3,0,106:8);
//Block(-3,1,-3,106:1);
Block(-3,1,-2,LEAVES);
Block(-3,1,-1,LEAVES);
Block(-3,1,0,LEAVES);
Block(-3,1,1,LEAVES);
Block(-3,1,2,LEAVES);
Block(-3,1,3,LEAVES);
//Block(-3,1,4,106:4);
//Block(-3,2,-1,106:8);
Block(-3,2,0,LEAVES);
Block(-3,2,1,LEAVES);
//Block(-3,2,2,106:4);
Block(-3,3,0,LEAVES);
Block(-2,1,-3,LEAVES);
Block(-2,1,-2,LEAVES);
Block(-2,1,-1,LEAVES);
Block(-2,1,0,LEAVES);
Block(-2,1,1,LEAVES);
Block(-2,1,2,LEAVES);
Block(-2,1,3,LEAVES);
Block(-2,1,4,LEAVES);
//Block(-2,2,-3,106:1);
Block(-2,2,-2,LEAVES);
Block(-2,2,-1,LEAVES);
Block(-2,2,0,LEAVES);
Block(-2,2,1,LEAVES);
Block(-2,2,2,LEAVES);
//Block(-2,2,3,106:8);
Block(-2,3,-1,LEAVES);
Block(-2,3,0,LEAVES);
Block(-2,3,1,LEAVES);
//Block(-2,3,2,106:8);
Block(-1,1,-4,LEAVES);
Block(-1,1,-3,LEAVES);
Block(-1,1,-2,LEAVES);
Block(-1,1,-1,LEAVES);
Block(-1,1,0,LEAVES);
Block(-1,1,1,LEAVES);
Block(-1,1,2,LEAVES);
Block(-1,1,3,LEAVES);
Block(-1,1,4,LEAVES);
Block(-1,2,-3,LEAVES);
Block(-1,2,-2,LEAVES);
Block(-1,2,-1,LEAVES);
Block(-1,2,0,LEAVES);
Block(-1,2,1,LEAVES);
Block(-1,2,2,LEAVES);
Block(-1,2,3,LEAVES);
//Block(-1,2,4,106:4);
Block(-1,3,-2,LEAVES);
Block(-1,3,-1,LEAVES);
Block(-1,3,0,LEAVES);
Block(-1,3,1,LEAVES);
Block(-1,3,2,LEAVES);
Block(-1,3,3,LEAVES);
//Block(0,0,0,FLOOR);
Block(0,1,-4,LEAVES);
Block(0,1,-3,LEAVES);
Block(0,1,-2,LEAVES);
Block(0,1,-1,LEAVES);
Block(0,1,0,LEAVES);
Block(0,1,1,LEAVES);
Block(0,1,2,LEAVES);
Block(0,1,3,LEAVES);
Block(0,1,4,LEAVES);
//Block(0,2,-4,106:1);
Block(0,2,-3,LEAVES);
Block(0,2,-2,LEAVES);
Block(0,2,-1,LEAVES);
Block(0,2,0,LEAVES);
Block(0,2,1,LEAVES);
Block(0,2,2,LEAVES);
Block(0,2,3,LEAVES);
Block(0,3,-3,LEAVES);
Block(0,3,-2,LEAVES);
Block(0,3,-1,LEAVES);
Block(0,3,0,LEAVES);
Block(0,3,1,LEAVES);
Block(0,3,2,LEAVES);
Block(0,3,3,LEAVES);
Block(1,1,-4,LEAVES);
Block(1,1,-3,LEAVES);
Block(1,1,-2,LEAVES);
Block(1,1,-1,LEAVES);
Block(1,1,0,LEAVES);
Block(1,1,1,LEAVES);
Block(1,1,2,LEAVES);
Block(1,1,3,LEAVES);
Block(1,1,4,LEAVES);
//Block(1,2,-3,106:1);
Block(1,2,-2,LEAVES);
Block(1,2,-1,LEAVES);
Block(1,2,0,LEAVES);
Block(1,2,1,LEAVES);
Block(1,2,2,LEAVES);
//Block(1,2,3,106:4);
Block(1,3,-2,LEAVES);
Block(1,3,-1,LEAVES);
Block(1,3,0,LEAVES);
Block(1,3,1,LEAVES);
Block(1,3,2,LEAVES);
//Block(2,1,-4,106:2);
Block(2,1,-3,LEAVES);
Block(2,1,-2,LEAVES);
Block(2,1,-1,LEAVES);
Block(2,1,0,LEAVES);
Block(2,1,1,LEAVES);
Block(2,1,2,LEAVES);
Block(2,1,3,LEAVES);
//Block(2,1,4,106:4);
Block(2,2,-2,LEAVES);
Block(2,2,-1,LEAVES);
Block(2,2,0,LEAVES);
Block(2,2,1,LEAVES);
Block(2,3,-1,LEAVES);
Block(2,3,0,LEAVES);
Block(2,3,1,LEAVES);
//Block(3,1,-3,106:1);
Block(3,1,-2,LEAVES);
Block(3,1,-1,LEAVES);
Block(3,1,0,LEAVES);
Block(3,1,1,LEAVES);
Block(3,1,2,LEAVES);
//Block(3,1,3,106:2);
//Block(3,2,-1,106:2);
Block(3,2,0,LEAVES);
//Block(3,2,1,106:2);
Block(3,3,0,LEAVES);
Block(4,1,-1,LEAVES);
Block(4,1,0,LEAVES);
Block(4,1,1,LEAVES);
//Block(4,1,2,106:4);
//Block(4,3,0,106:2);
//   biomeMod 2019/03/10 12:42:44
//           created by matez 
//            all rights reserved   
    }

}