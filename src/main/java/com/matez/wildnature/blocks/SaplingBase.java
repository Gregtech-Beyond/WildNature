package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import com.matez.wildnature.worldgen.*;
import com.matez.wildnature.worldgen.schematics.*;
import com.matez.wildnature.worldgen.generators.*;
import com.matez.wildnature.worldgen.schematics.trees.birch.treeGen_birch10;
import com.matez.wildnature.worldgen.schematics.trees.birch.treeGen_birch11;
import com.matez.wildnature.worldgen.schematics.trees.birch.treeGen_birch12;
import com.matez.wildnature.worldgen.schematics.trees.fir.*;
import com.matez.wildnature.worldgen.schematics.trees.hornbeam.*;
import com.matez.wildnature.worldgen.schematics.trees.palm.*;
import com.matez.wildnature.worldgen.schematics.trees.pine.*;
import com.matez.wildnature.worldgen.schematics.trees.redwood.treeGen_redwood1;
import com.matez.wildnature.worldgen.schematics.trees.redwood.treeGen_redwood2;
import com.matez.wildnature.worldgen.schematics.trees.redwood.treeGen_redwood3;
import com.matez.wildnature.worldgen.schematics.trees.redwood.treeGen_redwood4;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;


import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.world.gen.feature.WorldGenerator;

// TODO: Auto-generated Javadoc
public class SaplingBase extends BlockBush implements IGrowable, IHasModel

{
    public static int abc = 0;
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

    public static Block thisBlock;
    /**
     * Instantiates a new block sapling cloud.
     */
    public SaplingBase(String name, Material material)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.mbtab);
        setSoundType(SoundType.PLANT);

        thisBlock=this;

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        ModBlocks.SAPLINGS.add(this);
    }


    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }

    /* (non-Javadoc)
     * @see net.minecraft.block.BlockBush#getBoundingBox(net.minecraft.block.state.IBlockState, net.minecraft.world.IBlockAccess, net.minecraft.util.math.BlockPos)
     */
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return SAPLING_AABB;
    }

    /* (non-Javadoc)
     * @see net.minecraft.block.BlockBush#updateTick(net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState, java.util.Random)
     */
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                grow(worldIn, rand, pos, state);
            }
        }
    }

    /**
     * Generate tree.
     *
     * @param worldIn the world in
     * @param pos the pos
     * @param state the state
     * @param rand the rand
     */
    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        System.out.println(this.getUnlocalizedName());
        IBlockState LOGBEECH = ModBlocks.BEECH_LOG.getDefaultState();
        IBlockState LOGREDWOOD = ModBlocks.REDWOOD_LOG.getDefaultState();
        IBlockState LOGHORNBEAM = ModBlocks.HORNBEAM_LOG.getDefaultState();
        IBlockState LOGBAOBAB = ModBlocks.BAOBAB_LOG.getDefaultState();
        IBlockState LOGPINE = ModBlocks.PINE_LOG.getDefaultState();
        IBlockState LOGFIR = ModBlocks.FIR_LOG.getDefaultState();
        IBlockState LOGPALM = ModBlocks.PALM_LOG.getDefaultState();

        IBlockState LEAVESBEECH = ModBlocks.BEECH_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
        IBlockState LEAVESREDWOOD = ModBlocks.REDWOOD_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
        IBlockState LEAVESHORNBEAM = ModBlocks.HORNBEAM_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
        IBlockState LEAVESBAOBAB = ModBlocks.BAOBAB_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
        IBlockState LEAVESPINE = ModBlocks.PINE_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
        IBlockState LEAVESFIR = ModBlocks.FIR_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
        IBlockState LEAVESPALM = ModBlocks.PALM_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

        if(this==ModBlocks.BEECH_SAPLING) {
            int x = Main.generateRandomInt(0,2,rand);
            if(x == 0){
                generate(new treeGen_birch10(false,LOGBEECH,LEAVESBEECH),worldIn,rand,pos);
            }else if(x==1){
                generate(new treeGen_birch11(false,LOGBEECH,LEAVESBEECH),worldIn,rand,pos);
            }else{
                generate(new treeGen_birch12(false,LOGBEECH,LEAVESBEECH),worldIn,rand,pos);
            }
        }else if(this==ModBlocks.REDWOOD_SAPLING){
            int x = Main.generateRandomInt(0,3,rand);
            if(x == 0){
                generate(new treeGen_redwood1(false,LOGREDWOOD,LEAVESREDWOOD),worldIn,rand,pos);
            }else if(x==1){
                generate(new treeGen_redwood2(false,LOGREDWOOD,LEAVESREDWOOD),worldIn,rand,pos);
            }else if (x==2){
                generate(new treeGen_redwood3(false,LOGREDWOOD,LEAVESREDWOOD),worldIn,rand,pos);
            }else{
                generate(new treeGen_redwood4(false,LOGREDWOOD,LEAVESREDWOOD),worldIn,rand,pos);
            }
        }else if(this==ModBlocks.EUCALYPTUS_SAPLING){
            generate(new treeGen_eucalyptus(false),worldIn,rand,pos);
        }else if(this==ModBlocks.HORNBEAM_SAPLING){
            int x = Main.generateRandomInt(0,6,rand);
            if(x == 0){
                generate(new treeGen_hornbeam1(false,LOGHORNBEAM,LEAVESHORNBEAM),worldIn,rand,pos);
            }else if(x==1){
                generate(new treeGen_hornbeam2(false,LOGHORNBEAM,LEAVESHORNBEAM),worldIn,rand,pos);
            }else if (x==2){
                generate(new treeGen_hornbeam3(false,LOGHORNBEAM,LEAVESHORNBEAM),worldIn,rand,pos);
            }else if (x==3){
                generate(new treeGen_hornbeam4(false,LOGHORNBEAM,LEAVESHORNBEAM),worldIn,rand,pos);
            }else if (x==4){
                generate(new treeGen_hornbeam5(false,LOGHORNBEAM,LEAVESHORNBEAM),worldIn,rand,pos);
            }else if (x==5){
                generate(new treeGen_hornbeam6(false,LOGHORNBEAM,LEAVESHORNBEAM),worldIn,rand,pos);
            }else if (x==6){
                generate(new treeGen_hornbeam7(false,LOGHORNBEAM,LEAVESHORNBEAM),worldIn,rand,pos);
            }
        }else if(this==ModBlocks.PEAR_SAPLING){
            generate(new treeGen_pear(false),worldIn,rand,pos);
        }else if(this==ModBlocks.APPLE_SAPLING){
            generate(new treeGen_apple(false),worldIn,rand,pos);
        }else if(this==ModBlocks.JACARANDA_SAPLING){
            generate(new treeGen_jacaranda(false),worldIn,rand,pos);
        }else if(this==ModBlocks.ROWAN_SAPLING){
            generate(new treeGen_rowan(false),worldIn,rand,pos);
        }else if(this==ModBlocks.FIR_SAPLING){
            int x = Main.generateRandomInt(0,6,rand);
            if(x == 0){
                generate(new treeGen_fir1(false,LOGFIR,LEAVESFIR),worldIn,rand,pos);
            }else if(x==1){
                generate(new treeGen_fir2(false,LOGFIR,LEAVESFIR),worldIn,rand,pos);
            }else if (x==2){
                generate(new treeGen_fir3(false,LOGFIR,LEAVESFIR),worldIn,rand,pos);
            }else if (x==3){
                generate(new treeGen_fir4(false,LOGFIR,LEAVESFIR),worldIn,rand,pos);
            }else if (x==4){
                generate(new treeGen_fir5(false,LOGFIR,LEAVESFIR),worldIn,rand,pos);
            }else if (x==5){
                generate(new treeGen_fir6(false,LOGFIR,LEAVESFIR),worldIn,rand,pos);
            }else if (x==6){
                generate(new treeGen_fir7(false,LOGFIR,LEAVESFIR),worldIn,rand,pos);
            }
        }else if(this==ModBlocks.HAZEL_SAPLING){
            generate(new treeGen_hazel(false),worldIn,rand,pos);
        }else if(this==ModBlocks.CHERRY_PINK_SAPLING){
            generate(new treeGen_pinkCherry(false),worldIn,rand,pos);
        }else if(this==ModBlocks.CHERRY_WHITE_SAPLING){
            generate(new treeGen_whiteCherry(false),worldIn,rand,pos);
        }else if(this==ModBlocks.BAOBAB_SAPLING){
            generate(new WorldGenFromFile(false,LOGBAOBAB,LEAVESBAOBAB,"baobab.txt"),worldIn,rand,pos);
        }else if(this==ModBlocks.EBONY_SAPLING){
            generate(new treeGen_ebony(false),worldIn,rand,pos);
        }else if(this==ModBlocks.PINE_SAPLING){
            int x = Main.generateRandomInt(0,6,rand);
            if(x == 0){
                generate(new treeGen_pine(false),worldIn,rand,pos);
            }else if(x==1){
                generate(new treeGen_bpine1(false,LOGPINE,LEAVESPINE),worldIn,rand,pos);
            }else if (x==2){
                generate(new treeGen_bpine2(false,LOGPINE,LEAVESPINE),worldIn,rand,pos);
            }else if (x==3){
                generate(new treeGen_bpine3(false,LOGPINE,LEAVESPINE),worldIn,rand,pos);
            }else if (x==4){
                generate(new treeGen_bpine4(false,LOGPINE,LEAVESPINE),worldIn,rand,pos);
            }else if (x==5){
                generate(new treeGen_bpine5(false,LOGPINE,LEAVESPINE),worldIn,rand,pos);
            }else if (x==6){
                generate(new treeGen_pine(false),worldIn,rand,pos);
            }
        }else if(this==ModBlocks.PALM_SAPLING){
            int x = Main.generateRandomInt(0,6,rand);
            if(x == 0){
                generate(new treeGen_palm1(false,LOGPALM,LEAVESPALM),worldIn,rand,pos);
            }else if(x==1){
                generate(new treeGen_palm2(false,LOGPALM,LEAVESPALM),worldIn,rand,pos);
            }else if (x==2){
                generate(new treeGen_palm3(false,LOGPALM,LEAVESPALM),worldIn,rand,pos);
            }else if (x==3){
                generate(new treeGen_palm4(false,LOGPALM,LEAVESPALM),worldIn,rand,pos);
            }else if (x==4){
                generate(new treeGen_palm5(false,LOGPALM,LEAVESPALM),worldIn,rand,pos);
            }else if (x==5){
                generate(new treeGen_palm6(false,LOGPALM,LEAVESPALM),worldIn,rand,pos);
            }else if (x==6){
                generate(new treeGen_palm7(false,LOGPALM,LEAVESPALM),worldIn,rand,pos);
            }
        }else if(this==ModBlocks.MAHOGANY_SAPLING){
            generate(new treeGen_mahogany(false),worldIn,rand,pos);
        }else if(this==ModBlocks.CEDAR_SAPLING){
            generate(new treeGen_sekwoja(false),worldIn,rand,pos);
        }else if(this==ModBlocks.WILLOW_SAPLING){
            generate(new treeGen_willow(false),worldIn,rand,pos);
        }
    }

    private void generate(WorldGenerator generator, World world, Random rand, BlockPos pos){
        if (!TerrainGen.saplingGrowTree(world, rand, pos)) return;

        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
        generator.generate(world, rand, pos);
    }

    /**
     * Whether this IGrowable can grow.
     *
     * @param worldIn the world in
     * @param pos the pos
     * @param state the state
     * @param isClient the is client
     * @return true, if successful
     */
    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    /* (non-Javadoc)
     * @see net.minecraft.block.IGrowable#canUseBonemeal(net.minecraft.world.World, java.util.Random, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState)
     */
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return worldIn.rand.nextFloat() < 0.45D;
    }

    /* (non-Javadoc)
     * @see net.minecraft.block.IGrowable#grow(net.minecraft.world.World, java.util.Random, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState)
     */
    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        if (state.getValue(STAGE).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            generateTree(worldIn, pos, state, rand);
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block.
     *
     * @param meta the meta
     * @return the state from meta
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
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
        i = i | state.getValue(STAGE).intValue() << 3;
        return i;
    }

    /* (non-Javadoc)
     * @see net.minecraft.block.Block#createBlockState()
     */
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {STAGE});
    }

    private boolean isTwoByTwoOfType(World worldIn, BlockPos pos, int p_181624_3_, int p_181624_4_, BlockPlanks.EnumType type)
    {
        return this.isTypeAt(worldIn, pos.add(p_181624_3_, 0, p_181624_4_), type) && this.isTypeAt(worldIn, pos.add(p_181624_3_ + 1, 0, p_181624_4_), type) && this.isTypeAt(worldIn, pos.add(p_181624_3_, 0, p_181624_4_ + 1), type) && this.isTypeAt(worldIn, pos.add(p_181624_3_ + 1, 0, p_181624_4_ + 1), type);
    }

    public boolean isTypeAt(World worldIn, BlockPos pos, BlockPlanks.EnumType type)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock() == ModBlocks.REDWOOD_SAPLING.getDefaultState().getBlock();
    }

}