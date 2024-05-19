package com.matez.wildnature.worldgen.schematics.buildings;

import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import com.matez.wildnature.worldgen.WorldGenStructure;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class strGen_forester1 extends WorldGenStructure
{


    public strGen_forester1(boolean parShouldNotify, @Nullable IBlockState BLOCK1, @Nullable IBlockState BLOCK2, @Nullable IBlockState BLOCK3, @Nullable IBlockState BLOCK4, @Nullable IBlockState BLOCK5, @Nullable IBlockState BLOCK6, @Nullable IBlockState BLOCK7, Vec3d size) {
        super(parShouldNotify, BLOCK1, BLOCK2, BLOCK3, BLOCK4, BLOCK5, BLOCK6, BLOCK7, size);
    }

    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, Random parRandom){
        
        IBlockState GRASS = Blocks.GRASS.getDefaultState();
        IBlockState PLANKS = Blocks.PLANKS.getDefaultState();
        IBlockState LEAVES = Blocks.PLANKS.getDefaultState();
        IBlockState WOODEN_SLAB = Blocks.WOODEN_SLAB.getDefaultState();
        IBlockState WOODEN_SLAB_UP = Blocks.WOODEN_SLAB.getDefaultState();
        IBlockState STAIRS_1 = Blocks.OAK_STAIRS.getDefaultState();
        IBlockState STAIRS_2 = Blocks.OAK_STAIRS.getDefaultState();
Block(-2,0,-2,GRASS);
Block(-2,0,-1,GRASS);
Block(-2,0,0,GRASS);
Block(-2,0,1,GRASS);
Block(-2,0,2,GRASS);
Block(-2,1,-2,LEAVES);
Block(-2,1,0,LEAVES);
Block(-2,1,2,LEAVES);
Block(-2,2,-2,LEAVES);
Block(-2,2,0,LEAVES);
Block(-2,2,2,LEAVES);
Block(-2,3,-2,LEAVES);
Block(-2,3,0,LEAVES);
Block(-2,3,2,LEAVES);
Block(-2,4,-2,PLANKS);
Block(-2,4,-1,WOODEN_SLAB_UP);
Block(-2,4,0,PLANKS);
Block(-2,4,1,WOODEN_SLAB_UP);
Block(-2,4,2,PLANKS);
Block(-2,5,-2,LEAVES);
Block(-2,5,-1,LEAVES);
Block(-2,5,0,LEAVES);
Block(-2,5,1,LEAVES);
Block(-2,5,2,LEAVES);
Block(-2,6,-2,LEAVES);
Block(-2,6,2,LEAVES);
Block(-2,7,-2,WOODEN_SLAB);
Block(-2,7,-1,WOODEN_SLAB);
Block(-2,7,0,WOODEN_SLAB);
Block(-2,7,1,WOODEN_SLAB);
Block(-2,7,2,WOODEN_SLAB);
Block(-1,0,-2,GRASS);
Block(-1,0,-1,GRASS);
Block(-1,0,0,GRASS);
Block(-1,0,1,GRASS);
Block(-1,0,2,GRASS);
Block(-1,1,1,STAIRS_2);
Block(-1,1,2,STAIRS_1);
Block(-1,2,0,STAIRS_2);
Block(-1,2,1,STAIRS_1);
Block(-1,3,-1,STAIRS_2);
Block(-1,3,0,STAIRS_1);
Block(-1,4,-2,STAIRS_2);
Block(-1,4,-1,STAIRS_1);
Block(-1,4,2,Blocks.TRAPDOOR.getDefaultState());
Block(-1,5,-2,LEAVES);
Block(-1,5,2,LEAVES);
Block(-1,7,-2,WOODEN_SLAB);
Block(-1,7,-1,WOODEN_SLAB_UP);
Block(-1,7,0,WOODEN_SLAB_UP);
Block(-1,7,1,WOODEN_SLAB_UP);
Block(-1,7,2,WOODEN_SLAB);
Block(0,0,-2,GRASS);
Block(0,0,-1,GRASS);
Block(0,0,0,GRASS);
Block(0,0,1,GRASS);
Block(0,0,2,GRASS);
Block(0,4,-2,WOODEN_SLAB_UP);
Block(0,4,-1,WOODEN_SLAB_UP);
Block(0,4,0,WOODEN_SLAB_UP);
Block(0,4,1,WOODEN_SLAB_UP);
Block(0,4,2,WOODEN_SLAB_UP);
Block(0,5,-2,LEAVES);
Block(0,5,2,LEAVES);
Block(0,7,-2,WOODEN_SLAB);
Block(0,7,-1,WOODEN_SLAB_UP);
Block(0,7,0,WOODEN_SLAB_UP);
Block(0,7,1,WOODEN_SLAB_UP);
Block(0,7,2,WOODEN_SLAB);
Block(1,0,-2,GRASS);
Block(1,0,-1,GRASS);
Block(1,0,0,GRASS);
Block(1,0,1,GRASS);
Block(1,0,2,GRASS);
Block(1,4,-2,WOODEN_SLAB_UP);
Block(1,4,-1,WOODEN_SLAB_UP);
Block(1,4,0,WOODEN_SLAB_UP);
Block(1,4,1,WOODEN_SLAB_UP);
Block(1,4,2,WOODEN_SLAB_UP);
Block(1,5,-2,LEAVES);
Block(1,5,2,LEAVES);
Block(1,7,-2,WOODEN_SLAB);
Block(1,7,-1,WOODEN_SLAB_UP);
Block(1,7,0,WOODEN_SLAB_UP);
Block(1,7,1,WOODEN_SLAB_UP);
Block(1,7,2,WOODEN_SLAB);
Block(2,0,-2,GRASS);
Block(2,0,-1,GRASS);
Block(2,0,0,GRASS);
Block(2,0,1,GRASS);
Block(2,0,2,GRASS);
Block(2,1,-2,LEAVES);
Block(2,1,0,LEAVES);
Block(2,1,2,LEAVES);
Block(2,2,-2,LEAVES);
Block(2,2,0,LEAVES);
Block(2,2,2,LEAVES);
Block(2,3,-2,LEAVES);
Block(2,3,0,LEAVES);
Block(2,3,2,LEAVES);
Block(2,4,-2,PLANKS);
Block(2,4,-1,WOODEN_SLAB_UP);
Block(2,4,0,PLANKS);
Block(2,4,1,WOODEN_SLAB_UP);
Block(2,4,2,PLANKS);
Block(2,5,-2,LEAVES);
Block(2,5,-1,LEAVES);
Block(2,5,0,LEAVES);
Block(2,5,1,LEAVES);
Block(2,5,2,LEAVES);
Block(2,6,-2,LEAVES);
Block(2,6,2,LEAVES);
Block(2,7,-2,WOODEN_SLAB);
Block(2,7,-1,WOODEN_SLAB);
Block(2,7,0,WOODEN_SLAB);
Block(2,7,1,WOODEN_SLAB);
Block(2,7,2,WOODEN_SLAB);
//   biomeMod 2019/06/26 19:23:53
//           created by matez 
//            all rights reserved   
    }

}
