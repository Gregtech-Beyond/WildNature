package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class CornBush extends Block implements IHasModel, IGrowable {
    public static final PropertyInteger STAGE = PropertyInteger.create("stage",0,2);
    private int growChance = 30;
    private int height = 1;
    private boolean grown = false,wild=false;
    private NBTTagCompound tag;
    public boolean canGrow = true;
    private World cornWorld;
    public CornBush(String name){
        super(Material.PLANTS);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.mbtab);
        setDefaultState(this.blockState.getBaseState().withProperty(STAGE,0 ));
        setSoundType(SoundType.PLANT);
        setTickRandomly(true);
        setLightOpacity(0);


        grown = false;

        if(tag==null){
            tag = new NBTTagCompound();

        }


        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        if(blockState.getValue(STAGE)==0){
            setHardness(0.1F);
            return 0.1F;
        }else{
            setHardness(0.5F);
            return 0.5F;
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (tag == null) {
            tag = new NBTTagCompound();
        }else{
            height = tag.getInteger("height");
            grown = tag.getBoolean("grown");
            wild = tag.getBoolean("wild");
        }
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if(state.getValue(STAGE)>0){
            return new AxisAlignedBB(0,0,0,1,1,1);
        }
        return new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.4000000357627869D, 0.9375D);
    }
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {STAGE});
    }
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(STAGE, meta);
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
        return state.getValue(STAGE);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        BlockPos down = pos.down();
        if(worldIn.getBlockState(down).getBlock() instanceof CornBush){
            if(worldIn.getBlockState(down).getValue(STAGE)==0){
                return false;
            }
            return true;
        }
        if(worldIn.getBlockState(down).getBlock()==this){
            if(worldIn.getBlockState(down).getValue(STAGE)==0){
                return false;
            }
            return true;
        }
        return isSuitableLocation(worldIn,pos,(BlockBush)Blocks.SAPLING);
    }
    private boolean isSuitableLocation(World parWorld, BlockPos parBlockPos, BlockBush block) {
        if(parWorld.getBlockState(parBlockPos.down()).equals(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT))){
            return true;
        }else{
            return false;
        }
        //return block.canPlaceBlockAt(parWorld,parBlockPos);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if(!canPlaceBlockAt(worldIn,pos)){
            destroy(worldIn,pos);
        }
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return !grown && canGrow;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return !grown && canSustainPlant(worldIn.getBlockState(pos.down()),worldIn,pos.down(), EnumFacing.UP,(IPlantable) Blocks.SAPLING);

    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {

        destroy(worldIn,pos);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    public boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return this.canPlaceBlockAt(worldIn, pos);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        grown = false;
        height = 1;
        tag.setBoolean("grown",false);
        if(getCornHeight(worldIn,pos.down())==-1){
            setHeight(1);
        }else{
            setHeight(getCornHeight(worldIn,pos.down())+1);
        }
        tag.setInteger("height",getHeight());

        tag.setBoolean("wild",true);
        if(worldIn.isRemote) {
            if (placer.equals(Minecraft.getMinecraft().player)){
                tag.setBoolean("wild",false);
            }
        }

    }

    @Override
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
        //super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
        dropCorn(worldIn,pos,state,wild);
    }
    public void dropCorn(World worldIn, BlockPos pos, IBlockState state,boolean isWild){
        if(state.getValue(STAGE)==2){
            if(!isWild) {
                switch (Main.generateRandomInt(0, 1)) {
                    case 0:
                        spawnAsEntity(worldIn, pos, new ItemStack(ModItems.CORN));
                    case 1:
                        spawnAsEntity(worldIn, pos, new ItemStack(ModItems.CORN));
                        spawnAsEntity(worldIn, pos, new ItemStack(ModItems.CORN));
                }
            }else{
                spawnAsEntity(worldIn, pos, new ItemStack(ModItems.CORN));
            }

        }
    }


    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        int currentState = state.getValue(STAGE);
        if(height<5) {

        if(getCornHeight(worldIn,pos.down())==-1){
            setHeight(1);
        }else{
            setHeight(getCornHeight(worldIn,pos.down())+1);
        }


            BlockPos upper = pos.up();
            if (currentState == 0) {
                setCornState(worldIn, pos, 1, getCornHeight(worldIn, pos));
            } else if (currentState == 1) {
                if (worldIn.isAirBlock(upper)) {
                    setCornState(worldIn, upper, 0, getCornHeight(worldIn, pos) + 1);
                } else if (worldIn.getBlockState(upper).getBlock() instanceof CornBush) {
                    CornBush bush = (CornBush) worldIn.getBlockState(upper).getBlock();
                    bush.grow(worldIn, rand, upper, worldIn.getBlockState(upper));
                } else {

                }
                setCornState(worldIn, pos, 1, getCornHeight(worldIn, pos));
            }
        }else{
            if(!grown) {
                int x = Main.generateRandomInt(0, 20,rand);
                if (x == 0) {
                    makeGrown(worldIn, pos);
                }
            }
        }
    }

    public void setHeight(int newHeight){
        this.height=newHeight;
    }
    public int getHeight(){
        return this.height;
    }

    public boolean setCornState(World world, BlockPos pos, int stage, int height){
        CornBush cornBush = (CornBush)ModBlocks.CORN_BUSH;
        cornBush.setHeight(height);
        IBlockState cornState = cornBush.getDefaultState().withProperty(STAGE,stage);
        world.setBlockState(pos,cornState);

        return world.getBlockState(pos).equals(cornState) && ((CornBush)world.getBlockState(pos).getBlock()).getHeight()==height;
    }

    public int getCornHeight(World world, BlockPos pos){
        if(world.getBlockState(pos).getBlock() instanceof CornBush){
            CornBush bush = (CornBush)world.getBlockState(pos).getBlock();
            return bush.getHeight();
        }else{
            return -1;
        }
    }

    public boolean setCornHeight(World world, BlockPos pos, int height){
        if(world.getBlockState(pos).getBlock() instanceof CornBush){
            CornBush bush = (CornBush)world.getBlockState(pos).getBlock();
            bush.setHeight(height);
            world.setBlockState(pos,bush.getDefaultState().withProperty(STAGE,world.getBlockState(pos).getValue(STAGE)));
            bush = (CornBush)world.getBlockState(pos).getBlock();
            return bush.getHeight()==height;
        }else{
            return false;
        }
    }

    public boolean hasGrown(BlockPos pos, World world){
        if(height==1) {
            int blocks = 1;
            int a = 0;
            while (a < 4) {
                if(world.getBlockState(pos.up(a)).getBlock()!= Blocks.AIR && !(world.getBlockState(pos.up(a)).getBlock() instanceof CornBush)){
                    destroy(world,pos);
                    return false;
                }
                if(world.getBlockState(pos.up(a))==(this.getDefaultState().withProperty(STAGE,1))){
                    blocks++;
                }

                a++;
            }
            if(blocks==4){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public void destroy(World worldIn,BlockPos pos){
        this.grown = false;
        int a = -4;
        while(a<8){
            try {
                if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + a, pos.getZ())).getValue(STAGE) == 2) {
                    dropCorn(worldIn,new BlockPos(pos.getX(), pos.getY() + a, pos.getZ()),worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + a, pos.getZ())),wild);

                }
                worldIn.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + a, pos.getZ()));
            }catch(Exception e){}
            a++;
        }
    }
    public void makeGrown(World worldIn,BlockPos pos){
        if(!grown) {
            int a = -4;
            while (a < 8) {
                try {

                    if (getCornHeight(worldIn, new BlockPos(pos.getX(), pos.getY() + a, pos.getZ())) > 0 && getCornHeight(worldIn, new BlockPos(pos.getX(), pos.getY() + a, pos.getZ())) <= 5) {
                        if(worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + a, pos.getZ())).getValue(STAGE)==0){}else {
                            setCornState(worldIn, new BlockPos(pos.getX(), pos.getY() + a, pos.getZ()), 2, getCornHeight(worldIn, new BlockPos(pos.getX(), pos.getY() + a, pos.getZ())));
                        }
                    }
                } catch (Exception e) {
                }
                a++;
            }
            grown = true;
            tag.setBoolean("grown",true);
            tag.setInteger("height",height);
        }
    }
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.motionX *= 0.6D;
        entityIn.motionZ *= 0.6D;
    }



}