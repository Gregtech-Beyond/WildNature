package com.matez.wildnature.worldgen.schematics.trees.spruce;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

// TODO: Auto-generated Javadoc
public class treeGen_taiga1 extends WorldGenSchematicTree
{


    public treeGen_taiga1(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState) {
        super(parShouldNotify, logState, leavesState);
    }



    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){

        Block(-3,4,0,LEAVES);
        Block(-3,5,0,LEAVES);
        Block(-2,2,-1,LEAVES);
        Block(-2,2,0,LEAVES);
        Block(-2,2,2,LEAVES);
        Block(-2,3,-2,LEAVES);
        Block(-2,3,-1,LEAVES);
        Block(-2,3,1,LEAVES);
        Block(-2,3,2,LEAVES);
        Block(-2,4,-1,LEAVES);
        Block(-2,4,0,LEAVES);
        Block(-2,4,2,LEAVES);
        Block(-2,5,-1,LEAVES);
        Block(-2,5,0,LEAVES);
        Block(-2,5,1,LEAVES);
        Block(-2,6,0,LEAVES);
        Block(-2,6,1,LEAVES);
        Block(-2,7,-1,LEAVES);
        Block(-2,7,0,LEAVES);
        Block(-2,8,-1,LEAVES);
        Block(-2,8,0,LEAVES);
        Block(-2,8,1,LEAVES);
        Block(-2,9,1,LEAVES);
        Block(-1,2,-2,LEAVES);
        Block(-1,2,-1,LEAVES);
        Block(-1,2,0,LEAVES);
        Block(-1,2,1,LEAVES);
        Block(-1,2,2,LEAVES);
        Block(-1,3,-2,LEAVES);
        Block(-1,3,-1,LEAVES);
        Block(-1,3,0,LEAVES);
        Block(-1,3,1,LEAVES);
        Block(-1,3,2,LEAVES);
        Block(-1,3,3,LEAVES);
        Block(-1,4,-1,LEAVES);
        Block(-1,4,0,LEAVES);
        Block(-1,4,1,LEAVES);
        Block(-1,4,2,LEAVES);
        Block(-1,4,3,LEAVES);
        Block(-1,5,-1,LEAVES);
        Block(-1,5,0,LEAVES);
        Block(-1,5,1,LEAVES);
        Block(-1,5,2,LEAVES);
        Block(-1,6,-2,LEAVES);
        Block(-1,6,-1,LEAVES);
        Block(-1,6,0,LEAVES);
        Block(-1,6,1,LEAVES);
        Block(-1,6,2,LEAVES);
        Block(-1,7,-2,LEAVES);
        Block(-1,7,-1,LEAVES);
        Block(-1,7,0,LEAVES);
        Block(-1,7,1,LEAVES);
        Block(-1,7,2,LEAVES);
        Block(-1,8,-2,LEAVES);
        Block(-1,8,-1,LEAVES);
        Block(-1,8,0,LEAVES);
        Block(-1,8,1,LEAVES);
        Block(-1,9,-1,LEAVES);
        Block(-1,9,0,LEAVES);
        Block(-1,9,1,LEAVES);
        Block(-1,10,-1,LEAVES);
        Block(-1,10,0,LEAVES);
        Block(-1,10,2,LEAVES);
        Block(-1,11,-2,LEAVES);
        Block(-1,11,-1,LEAVES);
        Block(-1,11,0,LEAVES);
        Block(-1,11,1,LEAVES);
        Block(-1,12,-1,LEAVES);
        Block(-1,12,0,LEAVES);
        Block(-1,13,-1,LEAVES);
        Block(-1,13,0,LEAVES);
        Block(-1,13,1,LEAVES);
        Block(-1,14,-1,LEAVES);
        Block(-1,14,0,LEAVES);
        Block(-1,14,1,LEAVES);
        Block(-1,15,0,LEAVES);
        Block(0,0,0,DIRT);
        Block(0,1,0,LOG);
        Block(0,2,-1,LEAVES);
        Block(0,2,0,LOG);
        Block(0,2,1,LEAVES);
        Block(0,2,2,LEAVES);
        Block(0,2,3,LEAVES);
        Block(0,3,-2,LEAVES);
        Block(0,3,-1,LEAVES);
        Block(0,3,0,LOG);
        Block(0,3,1,LEAVES);
        Block(0,3,2,LEAVES);
        Block(0,3,3,LEAVES);
        Block(0,4,-1,LEAVES);
        Block(0,4,0,LOG);
        Block(0,4,1,LEAVES);
        Block(0,4,2,LEAVES);
        Block(0,4,3,LEAVES);
        Block(0,5,-1,LEAVES);
        Block(0,5,0,LOG);
        Block(0,5,1,LEAVES);
        Block(0,5,2,LEAVES);
        Block(0,5,3,LEAVES);
        Block(0,6,-1,LEAVES);
        Block(0,6,0,LOG);
        Block(0,6,1,LEAVES);
        Block(0,6,2,LEAVES);
        Block(0,7,-2,LEAVES);
        Block(0,7,-1,LEAVES);
        Block(0,7,0,LOG);
        Block(0,7,1,LEAVES);
        Block(0,7,2,LEAVES);
        Block(0,8,-1,LEAVES);
        Block(0,8,0,LOG);
        Block(0,8,1,LEAVES);
        Block(0,8,2,LEAVES);
        Block(0,9,-2,LEAVES);
        Block(0,9,-1,LEAVES);
        Block(0,9,0,LOG);
        Block(0,9,1,LEAVES);
        Block(0,10,-1,LEAVES);
        Block(0,10,0,LOG);
        Block(0,10,1,LEAVES);
        Block(0,11,-1,LEAVES);
        Block(0,11,0,LOG);
        Block(0,11,1,LEAVES);
        Block(0,11,2,LEAVES);
        Block(0,12,-2,LEAVES);
        Block(0,12,-1,LEAVES);
        Block(0,12,0,LOG);
        Block(0,12,1,LEAVES);
        Block(0,13,-1,LEAVES);
        Block(0,13,0,LOG);
        Block(0,13,1,LEAVES);
        Block(0,14,-1,LEAVES);
        Block(0,14,0,LOG);
        Block(0,14,1,LEAVES);
        Block(0,15,-1,LEAVES);
        Block(0,15,0,LOG);
        Block(0,15,1,LEAVES);
        Block(0,16,-1,LEAVES);
        Block(0,16,0,LEAVES);
        Block(0,16,1,LEAVES);
        Block(0,17,0,LEAVES);
        Block(0,18,0,LEAVES);
        Block(0,19,0,LEAVES);
        Block(1,2,-2,LEAVES);
        Block(1,2,-1,LEAVES);
        Block(1,2,0,LEAVES);
        Block(1,2,1,LEAVES);
        Block(1,2,2,LEAVES);
        Block(1,3,-2,LEAVES);
        Block(1,3,-1,LEAVES);
        Block(1,3,0,LEAVES);
        Block(1,3,1,LEAVES);
        Block(1,3,2,LEAVES);
        Block(1,3,3,LEAVES);
        Block(1,4,-2,LEAVES);
        Block(1,4,-1,LEAVES);
        Block(1,4,0,LEAVES);
        Block(1,4,1,LEAVES);
        Block(1,4,2,LEAVES);
        Block(1,5,-2,LEAVES);
        Block(1,5,-1,LEAVES);
        Block(1,5,0,LEAVES);
        Block(1,5,1,LEAVES);
        Block(1,5,2,LEAVES);
        Block(1,6,-1,LEAVES);
        Block(1,6,0,LEAVES);
        Block(1,6,1,LEAVES);
        Block(1,7,-2,LEAVES);
        Block(1,7,-1,LEAVES);
        Block(1,7,0,LEAVES);
        Block(1,7,1,LEAVES);
        Block(1,8,-2,LEAVES);
        Block(1,8,-1,LEAVES);
        Block(1,8,0,LEAVES);
        Block(1,8,1,LEAVES);
        Block(1,8,2,LEAVES);
        Block(1,9,-1,LEAVES);
        Block(1,9,0,LEAVES);
        Block(1,9,1,LEAVES);
        Block(1,10,-2,LEAVES);
        Block(1,10,-1,LEAVES);
        Block(1,10,0,LEAVES);
        Block(1,10,1,LEAVES);
        Block(1,11,-1,LEAVES);
        Block(1,11,0,LEAVES);
        Block(1,11,1,LEAVES);
        Block(1,12,-1,LEAVES);
        Block(1,12,0,LEAVES);
        Block(1,13,0,LEAVES);
        Block(1,13,1,LEAVES);
        Block(1,14,0,LEAVES);
        Block(1,15,-1,LEAVES);
        Block(1,15,0,LEAVES);
        Block(1,15,1,LEAVES);
        Block(1,16,0,LEAVES);
        Block(2,2,-1,LEAVES);
        Block(2,2,0,LEAVES);
        Block(2,2,1,LEAVES);
        Block(2,2,2,LEAVES);
        Block(2,3,-2,LEAVES);
        Block(2,3,-1,LEAVES);
        Block(2,3,0,LEAVES);
        Block(2,3,1,LEAVES);
        Block(2,3,2,LEAVES);
        Block(2,3,3,LEAVES);
        Block(2,4,-1,LEAVES);
        Block(2,4,0,LEAVES);
        Block(2,4,1,LEAVES);
        Block(2,4,2,LEAVES);
        Block(2,5,0,LEAVES);
        Block(2,5,1,LEAVES);
        Block(2,5,2,LEAVES);
        Block(2,6,0,LEAVES);
        Block(2,6,1,LEAVES);
        Block(2,6,2,LEAVES);
        Block(2,7,-1,LEAVES);
        Block(2,7,0,LEAVES);
        Block(2,7,1,LEAVES);
        Block(2,8,-1,LEAVES);
        Block(2,8,0,LEAVES);
        Block(2,8,1,LEAVES);
        Block(2,9,0,LEAVES);
        Block(2,11,0,LEAVES);
        Block(3,4,1,LEAVES);
        Block(3,4,2,LEAVES);
        Block(3,5,1,LEAVES);
        Block(3,5,2,LEAVES);
        Block(3,6,1,LEAVES);
    }

}