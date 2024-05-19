package com.matez.wildnature.worldgen;


import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.CornBush;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;

import java.util.Random;


// TODO: Auto-generated Javadoc
public class WorldGenCornGrass extends WorldGenerator
{

    private IBlockState block;

    public WorldGenCornGrass(IBlockState blockIn)
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
                return ModBlocks.CORN_BUSH.canPlaceBlockAt(worldIn,pos);
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
                setBlockCorn(worldIn,blockpos,rand);
            }

        }

        return true;
    }

    public boolean setBlockCorn(World world, BlockPos pos,Random rand){
        try {
            int x = 0;
            int max = Main.generateRandomInt(4, 5, rand);
            boolean isGrown = false;
            switch (Main.generateRandomInt(0, 12)) {
                case 0: {
                    isGrown = true;
                }
            }
            while (x < max) {
                CornBush bush = (CornBush) ModBlocks.CORN_BUSH;
                bush.setHeight(x + 1);
                bush.canGrow = false;
                if ((x + 1) == max) {
                    world.setBlockState(pos.up(x), bush.getDefaultState().withProperty(CornBush.STAGE, 0), 2);
                    if (isGrown) {
                        bush.makeGrown(world, pos.down());
                    }
                } else {
                    world.setBlockState(pos.up(x), bush.getDefaultState().withProperty(CornBush.STAGE, 1), 2);
                }

                x++;
            }
            return true;
        }catch (Exception e){
            return false;
        }

    }

}