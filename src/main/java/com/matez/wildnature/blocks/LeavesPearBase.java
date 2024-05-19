package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import com.matez.wildnature.blocks.WNBlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.Sys;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class LeavesPearBase extends WNBlockLeaves implements IHasModel {
    public static final PropertyInteger VARIANT = PropertyInteger.create("variant",0,3);
    public static int BlockVariant;
    public static boolean placedByPlayer=false;
    NBTTagCompound tag;
    public LeavesPearBase(String name, Material material){
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.mbtab);
        //setGraphicsLevel(true);
        setHardness(0.2F);
        setLightOpacity(1);
        if(getDefaultState().toString().isEmpty() || getDefaultState().toString()==null) {
            setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, 0).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
        }

        if(tag==null){
            tag = new NBTTagCompound();
        }


        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if(this==ModBlocks.BEECH_LEAVES) {
            return Item.getItemFromBlock(ModBlocks.BEECH_SAPLING);
        }else if(this==ModBlocks.REDWOOD_LEAVES){
            return Item.getItemFromBlock(ModBlocks.REDWOOD_SAPLING);
        }else if(this==ModBlocks.EUCALYPTUS_LEAVES){
            return Item.getItemFromBlock(ModBlocks.EUCALYPTUS_SAPLING);
        }else if(this==ModBlocks.HORNBEAM_LEAVES){
            return Item.getItemFromBlock(ModBlocks.HORNBEAM_SAPLING);
        }else if(this==ModBlocks.PEAR_LEAVES){
            return Item.getItemFromBlock(ModBlocks.PEAR_SAPLING);
        }else if(this==ModBlocks.APPLE_LEAVES){
            return Item.getItemFromBlock(ModBlocks.APPLE_SAPLING);
        }else if(this==ModBlocks.JACARANDA_LEAVES){
            return Item.getItemFromBlock(ModBlocks.JACARANDA_SAPLING);
        }else if(this==ModBlocks.ROWAN_LEAVES){
            return Item.getItemFromBlock(ModBlocks.ROWAN_SAPLING);
        }else if(this==ModBlocks.FIR_LEAVES){
            return Item.getItemFromBlock(ModBlocks.FIR_SAPLING);
        }else if(this==ModBlocks.HAZEL_LEAVES){
            return Item.getItemFromBlock(ModBlocks.HAZEL_SAPLING);
        }else if(this==ModBlocks.CHERRY_PINK_LEAVES){
            return Item.getItemFromBlock(ModBlocks.CHERRY_PINK_SAPLING);
        }else if(this==ModBlocks.CHERRY_WHITE_LEAVES){
            return Item.getItemFromBlock(ModBlocks.CHERRY_WHITE_SAPLING);
        }else if(this==ModBlocks.BAOBAB_LEAVES){
            return Item.getItemFromBlock(ModBlocks.BAOBAB_SAPLING);
        }else if(this==ModBlocks.EBONY_LEAVES){
            return Item.getItemFromBlock(ModBlocks.EBONY_SAPLING);
        }else if(this==ModBlocks.PINE_LEAVES){
            return Item.getItemFromBlock(ModBlocks.PINE_SAPLING);
        }else if(this==ModBlocks.PALM_LEAVES){
            return Item.getItemFromBlock(ModBlocks.PALM_SAPLING);
        }else if(this==ModBlocks.MAHOGANY_LEAVES){
            return Item.getItemFromBlock(ModBlocks.MAHOGANY_SAPLING);
        }else if(this==ModBlocks.CEDAR_LEAVES){
            return Item.getItemFromBlock(ModBlocks.CEDAR_SAPLING);
        }else if(this==ModBlocks.WILLOW_LEAVES){
            return Item.getItemFromBlock(ModBlocks.WILLOW_SAPLING);
        }
        return null;
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (tag == null) {
            tag = new NBTTagCompound();
        }else{
            placedByPlayer=tag.getBoolean("placedByPlayer");
        }
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return null;
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack(this));
    }



    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(VARIANT,(meta &3)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
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

        i = i | state.getValue(VARIANT);

        if (!state.getValue(DECAYABLE).booleanValue())
        {
            i |= 4;
        }

        if (state.getValue(CHECK_DECAY).booleanValue())
        {
        i |= 8;
        }







            return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE,VARIANT});
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return Blocks.LEAVES.getBlockLayer();
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return Blocks.LEAVES.isOpaqueCube(state);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return Blocks.LEAVES.shouldSideBeRendered(state, world, pos, side);
    }


    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);
        if(!placedByPlayer) {
            updateVariant(worldIn, pos);


            if (Main.generateRandomInt(0, 30) == 0) {

                //spawnAsEntity(worldIn, pos, new ItemStack(Items.APPLE));
                int gen = 0;
                gen = Main.generateRandomInt(0, 3);
                if (gen == 0) {
                    worldIn.setBlockState(pos, ModBlocks.PEAR_LEAVES.getDefaultState().withProperty(VARIANT, 1));
                } else if (gen == 1) {
                    worldIn.setBlockState(pos, ModBlocks.PEAR_LEAVES.getDefaultState().withProperty(VARIANT, 2));
                } else if (gen == 2) {
                    worldIn.setBlockState(pos, ModBlocks.PEAR_LEAVES.getDefaultState().withProperty(VARIANT, 3));
                } else if (gen == 3) {
                    if (worldIn.getBlockState(pos).toString().contains("variant=0")) {
                        gen = Main.generateRandomInt(0, 2);
                        if (gen == 0) {
                            worldIn.setBlockState(pos, ModBlocks.PEAR_LEAVES.getDefaultState().withProperty(VARIANT, 1));
                        } else if (gen == 1) {
                            worldIn.setBlockState(pos, ModBlocks.PEAR_LEAVES.getDefaultState().withProperty(VARIANT, 2));
                        } else if (gen == 2) {
                            worldIn.setBlockState(pos, ModBlocks.PEAR_LEAVES.getDefaultState().withProperty(VARIANT, 3));
                        }
                    } else {
                        updateVariant(worldIn, pos);
                        if (BlockVariant != 0) {
                            worldIn.setBlockState(pos, ModBlocks.PEAR_LEAVES.getDefaultState().withProperty(VARIANT, 0));
                            spawnAsEntity(worldIn, pos, new ItemStack(ModItems.GRUSZKA));
                        }

                    }
                }


            }
        }
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);
        updateVariant(worldIn,pos);
        if(BlockVariant!=0){
            worldIn.setBlockState(pos, ModBlocks.PEAR_LEAVES.getDefaultState().withProperty(VARIANT,0));
            spawnAsEntity(worldIn, pos, new ItemStack(ModItems.GRUSZKA));
        }

    }


    public void updateVariant(World worldIn,BlockPos pos){
        if(worldIn.getBlockState(pos).toString().contains("variant=0")){
            BlockVariant = 0;
        }else if(worldIn.getBlockState(pos).toString().contains("variant=1")){
            BlockVariant = 1;
        }else if(worldIn.getBlockState(pos).toString().contains("variant=2")){
            BlockVariant = 2;
        }else if(worldIn.getBlockState(pos).toString().contains("variant=3")){
            BlockVariant = 3;
        }
    }

    @Override
    public int tickRate(World worldIn) {

        return 20;

    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);

        if(tag==null){
            tag = new NBTTagCompound();
        }

        tag.setBoolean("placedByPlayer",true);

        placedByPlayer=true;

    }
}