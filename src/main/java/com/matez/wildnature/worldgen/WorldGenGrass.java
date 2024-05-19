package com.matez.wildnature.worldgen;


import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;

import java.util.Random;


// TODO: Auto-generated Javadoc
public class WorldGenGrass extends WorldGenerator
{

    private IBlockState block;

    public WorldGenGrass(IBlockState blockIn)
    {
        this.block = blockIn;
    }
    private boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
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


    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (IBlockState iblockstate = worldIn.getBlockState(position); (iblockstate.getBlock().isAir(iblockstate, worldIn, position) || iblockstate.getBlock().isLeaves(iblockstate, worldIn, position)) && position.getY() > 0; iblockstate = worldIn.getBlockState(position))
        {
            position = position.down();
        }

        for (int i = 0; i < 128; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < worldIn.getHeight() - 1) && canBlockStay(worldIn, blockpos, this.block))
            {
                worldIn.setBlockState(blockpos, this.block, 2);
            }

        }

        return true;
    }

    public void setGeneratedBlock(IBlockState blockbush){
        block = blockbush;
    }
}