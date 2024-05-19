package com.matez.wildnature.blocks.slabs;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSlabHalfBase extends BlockSlabBase implements IHasModel
{
	public BlockSlabHalfBase(String name, Material materialIn, CreativeTabs tab, BlockSlab half, BlockSlab doubleSlab)
	{
		super(name, materialIn, tab, half);

		ModItems.ITEMS.add(new ItemSlab(this, this, doubleSlab).setRegistryName(name));
		ModBlocks.SLABS.add(this);
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(half);
	}
	
	@Override
	public boolean isDouble() 
	{
		return false;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
	}
}
