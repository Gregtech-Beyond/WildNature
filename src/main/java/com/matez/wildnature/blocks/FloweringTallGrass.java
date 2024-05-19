package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.MyAPI.API;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import javafx.scene.control.ProgressBar;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class FloweringTallGrass extends BlockBush implements IHasModel {
    public static final PropertyBool FLOWERING = PropertyBool.create("flowering");
    private int growChance = 30;
    public FloweringTallGrass(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.mbtab);
        setDefaultState(this.blockState.getBaseState().withProperty(FLOWERING,true ));
        setSoundType(SoundType.PLANT);
        setTickRandomly(true);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.4000000357627869D, 0.9375D);
    }
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FLOWERING});
    }
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(FLOWERING, Boolean.valueOf((meta & 1) == 0));
    }

    /**
     * Convert the BlockState into the correct metadata value.
     *
     * @param state the state
     * @return the meta from state
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        if (!state.getValue(FLOWERING).booleanValue())
        {
            i |= 1;
        }



        return i;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);

        if(placer== Minecraft.getMinecraft().player) {
            if (worldIn.getBlockState(pos).getBlock() == this) {
                worldIn.setBlockState(pos, worldIn.getBlockState(pos).withProperty(FLOWERING, false), 2);
            }
        }else{
            if (worldIn.getBlockState(pos).getBlock() == this) {
                worldIn.setBlockState(pos, worldIn.getBlockState(pos).withProperty(FLOWERING, true), 2);
            }
        }
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if(!worldIn.getBlockState(pos).getValue(FLOWERING)) {
            int x = Main.generateRandomInt(0, growChance);
            if(x==0){
                worldIn.setBlockState(pos,worldIn.getBlockState(pos).withProperty(FLOWERING,true),2);
            }
        }

    }
}