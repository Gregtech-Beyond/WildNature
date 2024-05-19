package com.matez.wildnature.worldgen;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

// TODO: Auto-generated Javadoc
public class treeGen_miniTree extends WorldGenAbstractTree
{
    private IBlockState blockStateWood = ModBlocks.PINE_LOG.getDefaultState();
    public static IBlockState blockStateLeaves = ModBlocks.PINE_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    /** The minimum height of a generated tree. */
    private final int minTreeHeight = 2;

    /**
     * Instantiates a new world gen trees cloud.
     *
     * @param parShouldNotify the par should notify
     */
    public treeGen_miniTree(boolean parShouldNotify, IBlockState LOG, IBlockState LEAVES) {
        super(parShouldNotify);
        blockStateWood = LOG;
        blockStateLeaves = LEAVES;
    }

    /* (non-Javadoc)
     * @see net.minecraft.world.gen.feature.WorldGenerator#generate(net.minecraft.world.World, java.util.Random, net.minecraft.util.math.BlockPos)
     */
    @Override
    public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos)
    {
        int minHeight = Main.generateRandomInt(0,4) + minTreeHeight;

        // Check if tree fits in world
        if (parBlockPos.getY() >= 1 && parBlockPos.getY() + minHeight + 1 <= parWorld.getHeight())
        {
            if (!isSuitableLocation(parWorld, parBlockPos, minHeight))
            {
                return false;
            }
            else
            {
                IBlockState state = parWorld.getBlockState(parBlockPos.down());

                if (state.getBlock().canSustainPlant(state, parWorld, parBlockPos.down(), EnumFacing.UP, (IPlantable) Blocks.SAPLING) && parBlockPos.getY() < parWorld.getHeight() - minHeight - 1)
                {
                    state.getBlock().onPlantGrow(state, parWorld, parBlockPos.down(), parBlockPos);
                    generateLeaves(parWorld, parBlockPos, minHeight, parRandom);
                    generateTrunk(parWorld, parBlockPos, minHeight);
                    return true;
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

    private void generateLeaves(World parWorld, BlockPos parBlockPos, int height, Random parRandom)
    {

        /** @parBlockPos - XYZ dolnego pnia
         * @height - długość pnia
         **/

        BlockPos upperBlockPos = new BlockPos(parBlockPos.up(height));
        generateBlock(upperBlockPos,parWorld,100);
        generateBlock(upperBlockPos.south(),parWorld,100);
        generateBlock(upperBlockPos.west(),parWorld,100);
        generateBlock(upperBlockPos.east(),parWorld,100);
        generateBlock(upperBlockPos.north(),parWorld,100);
        generateBlock(upperBlockPos.up(),parWorld,100);
        int x = 0;
        while(true){
            x++;
            BlockPos pos = upperBlockPos.down(x);
            if(parWorld.isAirBlock(pos.down())){
                generateLeavesAt(parWorld,pos);
                x++;
            }else{
                break;
            }


        }




    }

    private void generateLeavesAt(World world, BlockPos logPos){

        generateBlock(new BlockPos(logPos.getX()+1,logPos.getY(),logPos.getZ()),world,95);
        generateBlock(new BlockPos(logPos.getX()-1,logPos.getY(),logPos.getZ()),world,95);
        generateBlock(new BlockPos(logPos.getX(),logPos.getY(),logPos.getZ()+1),world,95);
        generateBlock(new BlockPos(logPos.getX(),logPos.getY(),logPos.getZ()-1),world,95);
        generateBlock(new BlockPos(logPos.getX()+1,logPos.getY(),logPos.getZ()+1),world,95);
        generateBlock(new BlockPos(logPos.getX()+1,logPos.getY(),logPos.getZ()-1),world,95);
        generateBlock(new BlockPos(logPos.getX()-1,logPos.getY(),logPos.getZ()+1),world,95);
        generateBlock(new BlockPos(logPos.getX()-1,logPos.getY(),logPos.getZ()-1),world,95);
    }

        private void generateBlock(BlockPos pos,World world,int chance){
        if(!(chance==100)){
            int gen;
            gen = Main.generateRandomInt(0, 100);
            if((gen<=chance)){
                int foliageX = pos.getX();
                int foliageY = pos.getY();
                int foliageZ = pos.getZ();


                BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
                IBlockState state = world.getBlockState(blockPos);


                if (state.getBlock().isAir(state, world, blockPos) || state.getBlock().isLeaves(state, world, blockPos))
                {

                    setBlockAndNotifyAdequately(world, blockPos, blockStateLeaves);
                }
            }
        }else {

            int foliageX = pos.getX();
            int foliageY = pos.getY();
            int foliageZ = pos.getZ();


            BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
            IBlockState state = world.getBlockState(blockPos);


            if (state.getBlock().isAir(state, world, blockPos) || state.getBlock().isLeaves(state, world, blockPos)) {

                setBlockAndNotifyAdequately(world, blockPos, blockStateLeaves);
            }
        }

    }

    public void generateBlock(BlockPos pos,World world,int chance, EnumFacing facing){
        if(EnumFacing.DOWN.equals(facing)) {
            BlockPos checkPos = new BlockPos(pos.getX(),pos.getY()-1,pos.getZ());
            IBlockState stateBlock = world.getBlockState(checkPos);
            if(stateBlock.getBlock()==blockStateLeaves.getBlock()){
                if(!(chance==100)){
                    int gen;
                    gen = Main.generateRandomInt(0, 100);
                    if((gen<=chance)){
                        int foliageX = pos.getX();
                        int foliageY = pos.getY();
                        int foliageZ = pos.getZ();

                        System.out.println("GENERATING BLOCK AT x" + foliageX + " y" + foliageY + " z" +foliageZ);

                        BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
                        IBlockState state = world.getBlockState(blockPos);


                        if (state.getBlock().isAir(state, world, blockPos) || state.getBlock().isLeaves(state, world, blockPos))
                        {

                            setBlockAndNotifyAdequately(world, blockPos, blockStateLeaves);
                        }
                    }
                }else {

                    int foliageX = pos.getX();
                    int foliageY = pos.getY();
                    int foliageZ = pos.getZ();

                    System.out.println("GENERATING BLOCK AT x" + foliageX + " y" + foliageY + " z" + foliageZ);

                    BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
                    IBlockState state = world.getBlockState(blockPos);


                    if (state.getBlock().isAir(state, world, blockPos) || state.getBlock().isLeaves(state, world, blockPos)) {

                        setBlockAndNotifyAdequately(world, blockPos, blockStateLeaves);
                    }
                }
            }
        }


    }

    public void fillBlockY(BlockPos pos,int toY, World world, int chancePerBlock){
        int posY = pos.getY();

        if(posY==toY){
            generateBlock(pos,world,chancePerBlock);
        }else if(posY>toY){
            //posY=5 toY=1
            int setBlockToPos=toY;
            while((setBlockToPos<=posY)){
                generateBlock(new BlockPos(pos.getX(),setBlockToPos,pos.getZ()),world,chancePerBlock);
                setBlockToPos++;
            }
        }else if(posY<toY){
            //posY=1 toY=5
            int setBlockToPos=posY;
            while((setBlockToPos<=toY)){
                generateBlock(new BlockPos(pos.getX(),setBlockToPos,pos.getZ()),world,chancePerBlock);
                setBlockToPos++;
            }

        }

    }

    private void generateTrunk(World parWorld, BlockPos parBlockPos, int minHeight)
    {
        for (int height = 0; height < minHeight; ++height)
        {
            BlockPos upN = parBlockPos.up(height);
            IBlockState state = parWorld.getBlockState(upN);

            if (state.getBlock().isAir(state, parWorld, upN) || state.getBlock().isLeaves(state, parWorld, upN))
            {
                setBlockAndNotifyAdequately(parWorld, parBlockPos.up(height), blockStateWood.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
            }
        }
    }

    private boolean isSuitableLocation(World parWorld, BlockPos parBlockPos, int minHeight)
    {
        boolean isSuitableLocation = true;

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

    /*for (int foliageY = parBlockPos.getY() - 7 + height; foliageY <= parBlockPos.getY() + height; ++foliageY)
        {
            int foliageLayer = foliageY - (parBlockPos.getY() + height);
            int foliageLayerRadius = 1 - foliageLayer / 2;

            for (int foliageX = parBlockPos.getX() - foliageLayerRadius; foliageX <= parBlockPos.getX() + foliageLayerRadius; ++foliageX)
            {
                int foliageRelativeX = foliageX - parBlockPos.getX();

                for (int foliageZ = parBlockPos.getZ() - foliageLayerRadius; foliageZ <= parBlockPos.getZ() + foliageLayerRadius; ++foliageZ)
                {
                    int foliageRelativeZ = foliageZ - parBlockPos.getZ();

                    // Fill in layer with some randomness
                    if (Math.abs(foliageRelativeX) != foliageLayerRadius || Math.abs(foliageRelativeZ) != foliageLayerRadius || parRandom.nextInt(2) != 0 && foliageLayer != 0)
                    {
                        BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
                        IBlockState state = parWorld.getBlockState(blockPos);


                        if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos))
                        {
                            System.out.println("FOLIAGEY " + foliageY + " FOLIAGELAYER " + foliageLayer + " FOLIAGELAYERRADIUS "+ foliageLayerRadius + "\n FOLIAGEX " + foliageX + " FOLIAGERELATIVEX " + foliageRelativeX + "\n FOLIAGEZ " + foliageZ + " FOLIAGERELATIVEZ " + foliageRelativeZ );

                            setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
                        }
                    }
                }
            }
        }*/

}