package com.matez.wildnature.worldgen;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Random;

// TODO: Auto-generated Javadoc
public class WorldGenSchematicTree extends WorldGenAbstractTree
{
    public IBlockState LOG = ModBlocks.FIR_LOG.getDefaultState();
    public IBlockState DIRT = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
    public IBlockState LEAVES = ModBlocks.FIR_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public IBlockState FLOOR = Blocks.DIRT.getDefaultState();
    /** The minimum height of a generated tree. */
    private final int minTreeHeight = 15;
    World world;
    BlockPos pos;
    int rotate;

    ArrayList<BlockPos> addedBlocks = new ArrayList<>();
    ArrayList<BlockPos> bottomBlocks = new ArrayList<>();
    int doneBlocks = 0;


    public WorldGenSchematicTree(boolean parShouldNotify, @Nullable  IBlockState logState, @Nullable IBlockState leavesState)
    {
        super(parShouldNotify);
        if(!(logState==null)){
            LOG = logState;
        }
        if(!(leavesState==null)){
            LEAVES = leavesState;
        }

        FLOOR = LOG;



    }

    public WorldGenSchematicTree(boolean parShouldNotify, @Nullable  IBlockState logState, @Nullable IBlockState leavesState, @Nullable IBlockState floorState)
    {
        super(parShouldNotify);
        if(!(logState==null)){
            LOG = logState;
        }
        if(!(leavesState==null)){
            LEAVES = leavesState;
        }

        if(!(floorState==null)){
            FLOOR = floorState;
        }else{
            FLOOR = LOG;
        }




    }

    /* (non-Javadoc)
     * @see net.minecraft.world.gen.feature.WorldGenerator#generate(net.minecraft.world.World, java.util.Random, net.minecraft.util.math.BlockPos)
     */



    @Override
    public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos)
    {
        world = parWorld;
        pos = parBlockPos;
        int minHeight = Main.generateRandomInt(-8,8) + minTreeHeight;

        // Check if tree fits in world
        if (parBlockPos.getY() >= 1 && parBlockPos.getY() + minHeight + 1 <= parWorld.getHeight())
        {
            if (!isSuitableLocation(parWorld, parBlockPos,(BlockBush)Blocks.SAPLING, minHeight))
            {
                return false;
            }
            else
            {
                IBlockState state = parWorld.getBlockState(parBlockPos.down());

                if (state.getBlock().canSustainPlant(state, parWorld, parBlockPos.down(), EnumFacing.UP, (IPlantable) Blocks.SAPLING) && parBlockPos.getY() < parWorld.getHeight() - minHeight - 1)
                {
                    if(!(state.getBlock() instanceof BlockLeaves)) {
                        state.getBlock().onPlantGrow(state, parWorld, parBlockPos.down(), parBlockPos);
                        rotate = Main.generateRandomInt(1, 4);
                        generateBlocks(parWorld, parBlockPos, minHeight, parRandom);

                        generatePlatform(parWorld);

                        return true;
                    }else{
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
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
                setBlockAndNotifyAdequately(world,downBlock(bottomBlocks.get(x),loop),FLOOR);

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

        addedBlocks.clear();
        bottomBlocks.clear();
    }

    private BlockPos downBlock(BlockPos blockPos, int down){
        return new BlockPos(blockPos.getX(),blockPos.getY()-down,blockPos.getZ());
    }

    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom)
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