package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;

import java.util.List;

public class BlockMycelium extends net.minecraft.block.BlockMycelium implements IHasModel {



    public BlockMycelium(String name, List<Block> list){
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.mbtab);

        setHardness(0.6F);
        setSoundType(SoundType.PLANT);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        list.add(this);
    }
    public BlockMycelium(String name) {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.mbtab);

        setHardness(0.6F);
        setSoundType(SoundType.PLANT);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }
    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
        return true;
    }


    /*@Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        System.out.println("Foliage" + BiomeColorHelper.getFoliageColorAtPos(worldIn,pos));
        System.out.println("Grass" + BiomeColorHelper.getGrassColorAtPos(worldIn,pos));
        System.out.println("Water" + BiomeColorHelper.getWaterColorAtPos(worldIn,pos));
    }*/
}