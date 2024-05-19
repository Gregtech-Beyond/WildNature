package com.matez.wildnature.worldgen;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.LeavesBase;
import com.matez.wildnature.blocks.LogBase;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.leaves.mahogany.leafGen_mahogany;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class treeGen_mahogany extends WorldGenAbstractTree {

    IBlockState LEAVES = ModBlocks.MAHOGANY_LEAVES.getDefaultState().withProperty(LeavesBase.CHECK_DECAY,false);
    IBlockState LOG = ModBlocks.MAHOGANY_LOG.getDefaultState();
    int height = 6;

    public treeGen_mahogany(boolean notify) {
        super(notify);
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int realHeight = Main.generateRandomInt(height-1,height+3);
        if(worldIn.getBlockState(position.down()).getBlock().canSustainPlant(worldIn.getBlockState(position.down()),worldIn,position.down(),EnumFacing.UP,(IPlantable)Blocks.SAPLING)) {
            generateLog(realHeight, worldIn, position, rand);
        }

        return true;
    }


    public boolean generateLog(int realHeight, World world, BlockPos pos,Random rand){

        BlockPos upper = pos;


        int x = 0;
        while(x<realHeight){
            if((x)==Integer.parseInt(String.valueOf(Math.round(realHeight/2)))){
                upper = upper.offset(randomFacing(false));
            }


            setLog(world,upper);

            upper = upper.up();


            x++;
        }

        generateBranch(world,upper,rand);


        return true;
    }

    public boolean generateBranch(World world, BlockPos startPos,Random rand){
        EnumFacing facing = null;
        BlockPos endPos;
        while(true){
            if(facing==null){
                facing = EnumFacing.NORTH;
            }else if(facing == EnumFacing.NORTH){
                facing = EnumFacing.SOUTH;
            }else if(facing == EnumFacing.SOUTH){
                facing = EnumFacing.WEST;
            }else if(facing == EnumFacing.WEST){
                facing = EnumFacing.EAST;
            }else {
                break;
            }

            int x = 0;
            BlockPos pos = null;
            while(x<Main.generateRandomInt(1,2)){
                x++;
                pos = startPos.offset(facing,x);
                setBlock(world,pos,LOG.withProperty(LogBase.LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis())));

            }
            pos = pos.offset(facing,1);
            x = 0;
            while(x<Main.generateRandomInt(2,3)){
                x++;
                setLog(world,pos.up(x));
            }
        }
        generateLeaves(startPos.up(2),world,rand);

        return true;
    }

    public boolean generateLeaves(BlockPos center,World world,Random rand){
        WorldGenSchematicLeaves leavesGen =new leafGen_mahogany(true,ModBlocks.MAHOGANY_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false)));
        leavesGen.generate(world,rand,center);

        return true;
    }


    private boolean isSuitableLocation(World parWorld, BlockPos parBlockPos, int minHeight)
    {
        boolean isSuitableLocation = true;

        if(!parWorld.getBlockState(parBlockPos.down()).isFullBlock()){
            return false;
        }

        for (int checkY = parBlockPos.getY(); checkY <= parBlockPos.getY() + 1 + minHeight; ++checkY)
        {
            // Handle increasing space towards top of tree
            int extraSpaceNeeded = 1;
            // Handle base location
            if (checkY == parBlockPos.getY())
            {
                extraSpaceNeeded = 0;
            }
            // Handle top location
            if (checkY >= parBlockPos.getY() + 1 + minHeight - 2)
            {
                extraSpaceNeeded = 2;
            }

            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for (int checkX = parBlockPos.getX() - extraSpaceNeeded; checkX <= parBlockPos.getX() + extraSpaceNeeded && isSuitableLocation; ++checkX)
            {
                for (int checkZ = parBlockPos.getZ() - extraSpaceNeeded; checkZ <= parBlockPos.getZ() + extraSpaceNeeded && isSuitableLocation; ++checkZ)
                {
                    isSuitableLocation = isReplaceable(parWorld,blockPos.setPos(checkX, checkY, checkZ));
                }
            }
        }

        return isSuitableLocation;
    }



    public EnumFacing randomFacing(boolean upDown){
        if(upDown){
            switch (Main.generateRandomInt(1,6)){
                case 1:
                    return EnumFacing.NORTH;
                case 2:
                    return EnumFacing.SOUTH;
                case 3:
                    return EnumFacing.WEST;
                case 4:
                    return EnumFacing.EAST;
                case 5:
                    return EnumFacing.UP;
                case 6:
                    return EnumFacing.DOWN;
            }

        }else{
            switch (Main.generateRandomInt(1,4)){
                case 1:
                    return EnumFacing.NORTH;
                case 2:
                    return EnumFacing.SOUTH;
                case 3:
                    return EnumFacing.WEST;
                case 4:
                    return EnumFacing.EAST;
            }
        }

        return null;
    }

    public void setLeaves(World world, BlockPos pos){
        world.setBlockState(pos,LEAVES,2);
    }

    public void setLeaves(World world, BlockPos pos, int chance){
        if(Main.generateRandomInt(0,100)<=chance) {
            world.setBlockState(pos, LEAVES, 2);
        }
    }

    public void setLog(World world, BlockPos pos){
        world.setBlockState(pos,LOG,2);
    }

    public void setLog(World world, BlockPos pos, int chance){
        if(Main.generateRandomInt(0,100)<=chance) {
            world.setBlockState(pos, LOG, 2);
        }
    }

    public void setBlock(World world, BlockPos pos, IBlockState state){
        world.setBlockState(pos,state,2);
    }

    public void setBlock(World world, BlockPos pos, IBlockState state, int chance){
        if(Main.generateRandomInt(0,100)<=chance) {
            world.setBlockState(pos, state, 2);
        }
    }


}