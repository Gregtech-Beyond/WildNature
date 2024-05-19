package com.matez.wildnature.blocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSlabDoubleBase extends BlockSlabBase
{
	public BlockSlabDoubleBase(String name, Material materialIn, CreativeTabs tab, BlockSlab half) 
	{
		super(name, materialIn, tab, half);
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(half);
	}

	@Override
	public boolean isDouble() 
	{	
		return true;
	}
}
