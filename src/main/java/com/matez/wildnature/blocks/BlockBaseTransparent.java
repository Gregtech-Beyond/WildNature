package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockBaseTransparent extends Block implements IHasModel {

    public BlockBaseTransparent(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.mbtab);
        setSoundType(getPerfectSoundForMaterial(material));
        setHardness(0.4F);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockBaseTransparent(String name, Material material, CreativeTabs tab){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setSoundType(getPerfectSoundForMaterial(material));
        setHardness(0.4F);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockBaseTransparent(String name, Material material, List<Block> list){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.mbtab);
        setSoundType(getPerfectSoundForMaterial(material));
        setHardness(0.5F);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        list.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }

    public SoundType getPerfectSoundForMaterial(Material material){
        if(material==Material.IRON){
            return SoundType.METAL;
        }else if(material==Material.GRASS){
            return SoundType.PLANT;
        }else if(material==Material.WOOD){
            return SoundType.WOOD;
        }else if(material==Material.SAND){
            return SoundType.SAND;
        }else{
            return SoundType.STONE;
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    /*@Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        System.out.println("Foliage" + BiomeColorHelper.getFoliageColorAtPos(worldIn,pos));
        System.out.println("Grass" + BiomeColorHelper.getGrassColorAtPos(worldIn,pos));
        System.out.println("Water" + BiomeColorHelper.getWaterColorAtPos(worldIn,pos));
    }*/
}