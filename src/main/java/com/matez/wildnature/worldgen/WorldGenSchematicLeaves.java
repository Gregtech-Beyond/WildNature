package com.matez.wildnature.worldgen;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockVine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Random;

// TODO: Auto-generated Javadoc
public class WorldGenSchematicLeaves extends WorldGenAbstractTree
{

    public IBlockState AIR = Blocks.AIR.getDefaultState();
    public IBlockState LEAVES = ModBlocks.FIR_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public IBlockState FLOOR = Blocks.AIR.getDefaultState();
    /** The minimum height of a generated tree. */
    private final int minTreeHeight = 15;
    World world;
    BlockPos pos;
    int rotate;

    ArrayList<BlockPos> addedBlocks = new ArrayList<>();
    ArrayList<BlockPos> bottomBlocks = new ArrayList<>();
    int doneBlocks = 0;
    public boolean canRotate = true;
    public boolean spawnVines = false;
    public int vineChance = 4;


    public WorldGenSchematicLeaves(boolean parShouldNotify, @Nullable IBlockState leavesState)
    {
        super(parShouldNotify);

        if(!(leavesState==null)){
            LEAVES = leavesState;
        }





    }
    public WorldGenSchematicLeaves(boolean parShouldNotify, @Nullable IBlockState leavesState,boolean canRotate)
    {
        super(parShouldNotify);

        if(!(leavesState==null)){
            LEAVES = leavesState;
        }
        this.canRotate=canRotate;





    }


    /* (non-Javadoc)
     * @see net.minecraft.world.gen.feature.WorldGenerator#generate(net.minecraft.world.World, java.util.Random, net.minecraft.util.math.BlockPos)
     */

    public void spawnVines(ArrayList<BlockPos> leaves,World world, Random random){
        if(spawnVines){
            int x = 0;
            int y = 0;
            while(x<leaves.size()){
                int chance = Main.generateRandomInt(1,vineChance,random);
                if(chance == 1){
                    while(true) {
                        int vineFacing = Main.generateRandomInt(1,4,random);
                        y++;
                        BlockPos vinePos;
                        //1 = north 2 = south 3 = east 4 = west
                        if(vineFacing==1) {
                            vinePos = leaves.get(x).north();
                            int a = 0;
                            while(true){
                                if (world.isAirBlock(vinePos.down(a))) {
                                    setBlockAndNotifyAdequately(world,vinePos.down(a),Blocks.VINE.getDefaultState().withProperty(BlockVine.SOUTH,true));
                                }else{
                                    break;
                                }
                                a++;

                            }
                        }else if(vineFacing==2) {
                            vinePos = leaves.get(x).south();
                            int a = 0;
                            while(true){
                                if (world.isAirBlock(vinePos.down(a))) {
                                    setBlockAndNotifyAdequately(world,vinePos.down(a),Blocks.VINE.getDefaultState().withProperty(BlockVine.NORTH,true));
                                }else{
                                    break;
                                }
                                a++;

                            }
                        }else if(vineFacing==3) {
                            vinePos = leaves.get(x).east();
                            int a = 0;
                            while(true){
                                if (world.isAirBlock(vinePos.down(a))) {
                                    setBlockAndNotifyAdequately(world,vinePos.down(a),Blocks.VINE.getDefaultState().withProperty(BlockVine.WEST,true));
                                }else{
                                    break;
                                }
                                a++;

                            }
                        }else if(vineFacing==4) {
                            vinePos = leaves.get(x).west();
                            int a = 0;
                            while(true){
                                if (world.isAirBlock(vinePos.down(a))) {
                                    setBlockAndNotifyAdequately(world,vinePos.down(a),Blocks.VINE.getDefaultState().withProperty(BlockVine.EAST,true));
                                }else{
                                    break;
                                }
                                a++;

                            }
                        }

                        if(y==4){
                            y=0;
                            break;
                        }
                    }
                }


                x++;
            }
        }
    }

    @Override
    public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos)
    {
        world = parWorld;
        pos = parBlockPos;

        if(canRotate) {
            rotate = Main.generateRandomInt(1, 4,parRandom);
        }else{
            rotate = 1;
        }

        addedBlocks.clear();
        generateBlocks(parWorld, parBlockPos, 0, parRandom);
        spawnVines(addedBlocks,parWorld,parRandom);

        return true;
    }

    public void generatePlatform(World world){
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
            if(world.isAirBlock(downBlock(bottomBlocks.get(x),loop))){
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


}