package com.matez.wildnature.worldgen;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.LeavesBase;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.leaves.willow.leafGen_willowLeaf;
import com.matez.wildnature.worldgen.schematics.leaves.willow.leafGen_willowLeafBig;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class treeGen_willow extends WorldGenAbstractTree {
    private static final IBlockState LOG = ModBlocks.WILLOW_LOG.getDefaultState();
    private static final IBlockState LEAVES = ModBlocks.WILLOW_LEAVES.getDefaultState().withProperty(LeavesBase.CHECK_DECAY, Boolean.valueOf(false)).withProperty(LeavesBase.DECAYABLE, Boolean.valueOf(false));
    public treeGen_willow(boolean notify) {
        super(notify);
    }
    private int waterSize = 0;

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if(canBlockStay(worldIn,position, Blocks.SAPLING.getDefaultState())){
            int leafGen = generateTrunk(worldIn,position.down(waterSize),rand);
            BlockPos leafPos = position.up(leafGen).down(waterSize);
            int leafType = Main.generateRandomInt(1,2,rand);
            if(leafType==1){
                WorldGenSchematicLeaves leaves = new leafGen_willowLeaf(true,LEAVES);
                leaves.generate(worldIn,rand,leafPos);
            }else{
                WorldGenSchematicLeaves leaves = new leafGen_willowLeafBig(true,LEAVES);
                leaves.generate(worldIn,rand,leafPos);
            }
        }else{
            return false;
        }


        return true;
    }

    public int generateTrunk(World world, BlockPos pos, Random rand){
        int height = Main.generateRandomInt(7,14,rand);
        int x = 0;
        while(x<height) {
            setBlockAndNotifyAdequately(world,pos.up(x), LOG);
            x++;
        }
        x=0;
        int chance = Main.generateRandomInt(1,100);
        while(x<3){
            if(chance>40) {
                setBlockAndNotifyAdequately(world,new BlockPos(pos.up(x).getX() + 1, pos.up(x).getY(), pos.up(x).getZ()), LOG);
                setBlockAndNotifyAdequately(world,new BlockPos(pos.up(x).getX() - 1, pos.up(x).getY(), pos.up(x).getZ()), LOG);
                setBlockAndNotifyAdequately(world,new BlockPos(pos.up(x).getX(), pos.up(x).getY(), pos.up(x).getZ() + 1), LOG);
                setBlockAndNotifyAdequately(world,new BlockPos(pos.up(x).getX(), pos.up(x).getY(), pos.up(x).getZ() - 1), LOG);
            }else{
                break;
            }
            x++;
        }
        return height;
    }

    private boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if(worldIn.getBlockState(pos.down()).getBlock().equals(Blocks.WATER) || worldIn.getBlockState(pos.down()).getBlock().equals(Blocks.FLOWING_WATER)){
            if(worldIn.getBlockState(pos.down().down()).getBlock().equals(Blocks.WATER) || worldIn.getBlockState(pos.down().down()).getBlock().equals(Blocks.FLOWING_WATER)){
                if(worldIn.getBlockState(pos.down().down().down()).isFullBlock()){
                    waterSize=2;
                    return true;
                }
            }else{
                if(worldIn.getBlockState(pos.down().down()).isFullBlock()){
                    waterSize=1;
                    return true;
                }
            }

        }

        if(state.isFullBlock()){
            if(worldIn.getBlockState(pos.down()).isFullBlock()) {
                return true;
            }else{
                return false;
            }
        }else {
            try {
                IBlockState soil = worldIn.getBlockState(pos.down());
                return soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, (IPlantable) state.getBlock());
            }catch(Exception e){
                return false;
            }
        }

    }
}