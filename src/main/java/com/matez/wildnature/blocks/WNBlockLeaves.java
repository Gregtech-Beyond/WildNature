package com.matez.wildnature.blocks;

import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WNBlockLeaves extends BlockLeaves {

    public WNBlockLeaves(){
        super();
        ModBlocks.LEAVES.add(this);
    }
    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return null;
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        List<ItemStack> stacks = new ArrayList<>();
        stacks.add(item);
        return stacks;
    }


}
