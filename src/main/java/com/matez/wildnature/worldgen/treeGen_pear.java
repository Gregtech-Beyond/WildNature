package com.matez.wildnature.worldgen;

import com.google.common.collect.Lists;
import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.LeavesBase;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.List;
import java.util.Random;

public class treeGen_pear extends WorldGenAbstractTree
{

    private static final IBlockState LOG = ModBlocks.PEAR_LOG.getDefaultState();
    private static final IBlockState LEAVES = ModBlocks.PEAR_LEAVES.getDefaultState().withProperty(LeavesBase.CHECK_DECAY, Boolean.valueOf(false)).withProperty(LeavesBase.DECAYABLE, Boolean.valueOf(false));

    public treeGen_pear(boolean notify)
    {
        super(notify);
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        BigTree tree = new BigTree(true,Main.generateRandomInt(6,7,rand),1,1.0,LOG,LEAVES,Blocks.SAPLING.getDefaultState());
        return tree.generate(worldIn,rand,position);
    }


}