package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RockBase extends Block implements IHasModel {

    private int type;
    Item drop = null;

    public RockBase(String name, Material material, CreativeTabs tab, int type){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setSoundType(getPerfectSoundForMaterial(material));
        setHardness(1F);
        this.type = type;



        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        ModBlocks.ROCKS.add(this);
    }


    public RockBase(String name, Material material, CreativeTabs tab, int type, Item drop){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setSoundType(getPerfectSoundForMaterial(material));
        setHardness(1F);
        this.type = type;
        this.drop=drop;


        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        ModBlocks.ROCKS.add(this);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if(drop==null) {
            return Item.getItemFromBlock(Blocks.COBBLESTONE);
        }else{
            return drop;
        }
    }

    public int getType() {
        return type;
    }

    public int getMinYByType(World world){
        int defaultMinY = Math.round(world.getSeaLevel()/3);
        if(type==0){
            return 0;
        }else if(type==1){
            return defaultMinY+defaultMinY+5;
        }else if(type==2){
            return defaultMinY+5;
        }else if(type==3){
            return 5;
        }
        return 0;
    }

    public int getMaxYByType(World world){
        int defaultMaxY = Math.round(world.getSeaLevel()/3);
        if(type==0){
            return world.getHeight();
        }else if(type==1){
            return world.getSeaLevel();//47-63
        }else if(type==2){
            return defaultMaxY+defaultMaxY+5;//26-47
        }else if(type==3){
            return defaultMaxY+5;//5-26
        }
        return 0;
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



    /**
     * Get the geometry of the queried face at the given position and state. This is used to decide whether things like
     * buttons are allowed to be placed on the face, or how glass panes connect to the face, among other things.
     * <p>
     * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED}, which represents something that
     * does not fit the other descriptions and will generally cause other things not to connect to the face.
     *
     * @return an approximation of the form of the given face
     */
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.SOLID;
    }



    /*@Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        System.out.println("Foliage" + BiomeColorHelper.getFoliageColorAtPos(worldIn,pos));
        System.out.println("Grass" + BiomeColorHelper.getGrassColorAtPos(worldIn,pos));
        System.out.println("Water" + BiomeColorHelper.getWaterColorAtPos(worldIn,pos));
    }*/
}