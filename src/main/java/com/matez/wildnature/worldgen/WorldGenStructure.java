package com.matez.wildnature.worldgen;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Random;

// TODO: Auto-generated Javadoc
public class WorldGenStructure extends WorldGenAbstractTree
{
    private IBlockState BLOCK1 = Blocks.DIRT.getDefaultState();
    private IBlockState BLOCK2 = Blocks.DIRT.getDefaultState();
    private IBlockState BLOCK3 = Blocks.DIRT.getDefaultState();
    private IBlockState BLOCK4 = Blocks.DIRT.getDefaultState();
    private IBlockState BLOCK5 = Blocks.DIRT.getDefaultState();
    private IBlockState BLOCK6 = Blocks.DIRT.getDefaultState();
    private IBlockState BLOCK7 = Blocks.DIRT.getDefaultState();
    private Vec3d SIZE;
    /** The minimum height of a generated tree. */
    private final int minTreeHeight = 15;
    World world;
    BlockPos pos;
    int rotate;

    ArrayList<BlockPos> addedBlocks = new ArrayList<>();
    ArrayList<BlockPos> bottomBlocks = new ArrayList<>();
    int doneBlocks = 0;


    public WorldGenStructure(boolean parShouldNotify, @Nullable  IBlockState BLOCK1, @Nullable IBlockState BLOCK2, @Nullable IBlockState BLOCK3, @Nullable IBlockState BLOCK4, @Nullable IBlockState BLOCK5, @Nullable IBlockState BLOCK6, @Nullable IBlockState BLOCK7, Vec3d size)
    {
        super(parShouldNotify);
        this.BLOCK1=BLOCK1;
        this.BLOCK2=BLOCK2;
        this.BLOCK3=BLOCK3;
        this.BLOCK4=BLOCK4;
        this.BLOCK5=BLOCK5;
        this.BLOCK6=BLOCK6;
        this.BLOCK7=BLOCK7;
        this.SIZE=size;
    }



    /* (non-Javadoc)
     * @see net.minecraft.world.gen.feature.WorldGenerator#generate(net.minecraft.world.World, java.util.Random, net.minecraft.util.math.BlockPos)
     */



    @Override
    public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos)
    {
        world = parWorld;
        pos = parBlockPos;
        rotate=1;
        generateBlocks(parWorld,parBlockPos,parRandom);
        return true;
    }

    public void generatePlatform(World world){
        if(bottomBlocks==null){
            return;
        }

        int x = 0;
        BlockPos down = null;
        while(x<addedBlocks.size()){
            if(down==null){
                down = addedBlocks.get(x);
            }
            if(addedBlocks.get(x).getY()<down.getY()){
                down = addedBlocks.get(x);
            }
            x++;
        }

        x = 0;
        while(x<addedBlocks.size()){
            if(addedBlocks.get(x).getY()==down.getY()+1){
                bottomBlocks.add(downBlock(addedBlocks.get(x),1));
            }
            x++;
        }
        x = 0;
        int loop = 0;
        int done = 0;
        while(true){
            if(world.isAirBlock(downBlock(bottomBlocks.get(x),loop))||!world.getBlockState((downBlock(bottomBlocks.get(x),loop))).isFullBlock()){
                setBlockAndNotifyAdequately(world,downBlock(bottomBlocks.get(x),loop),BLOCK1);

            }else{
                done++;
            }

            if((bottomBlocks.size()-1)==x){
                x = 0;
                loop++;
                done = 0;
            }
            if(loop==10){
                break;
            }
            x++;
        }
    }

    private BlockPos downBlock(BlockPos blockPos, int down){
        return new BlockPos(blockPos.getX(),blockPos.getY()-down,blockPos.getZ());
    }

    public void generateBlocks(World parWorld, BlockPos parBlockPos, Random parRandom)
    {

        /** @parBlockPos - XYZ dolnego pnia
         * @height - długość pnia
         **/
        System.out.println("Nothing happens");



    }

    public void Block(int x, int y, int z, IBlockState blockState){
        y = y-1;
        BlockPos posx = null;
        if(rotate==1) {
            posx = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
        }else if(rotate==2){
            posx = new BlockPos(pos.getX()-x,pos.getY()+y,pos.getZ()-z);
        }else if(rotate==3){
            posx = new BlockPos(pos.getX()-x,pos.getY()+y,pos.getZ()+z);
        }else if(rotate==4){
            posx = new BlockPos(pos.getX()+x,pos.getY()+y,pos.getZ()-z);
        }else{
            throw new NullPointerException("Rotation is " + rotate +", but allowed is from 1 to 4");
        }
        setBlockAndNotifyAdequately(world,posx,blockState);
        addedBlocks.add(posx);
    }




    private boolean isSuitableLocation(World parWorld, BlockPos parBlockPos, BlockBush block, int minHeight) {
        return block.canPlaceBlockAt(parWorld,parBlockPos);
    }




}