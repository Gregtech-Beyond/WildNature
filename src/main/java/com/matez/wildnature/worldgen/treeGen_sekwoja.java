package com.matez.wildnature.worldgen;

import com.google.common.collect.Lists;
import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.LeavesBase;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.List;
import java.util.Random;

public class treeGen_sekwoja extends WorldGenAbstractTree
{
    private Random rand;
    private World world;
    private BlockPos basePos = BlockPos.ORIGIN;
    int heightLimit = Main.generateRandomInt(20,30);;
    int height = Main.generateRandomInt(20,30);;
    double heightAttenuation = 0.618D;
    double branchSlope = 0.381D;
    double scaleWidth = 1.0D;
    double leafDensity = 1.0D;
    int trunkSize = 2;
    int heightLimitLimit = Main.generateRandomInt(20,30);
    /** Sets the distance limit for how far away the generator will populate leaves from the base leaf node. */
    int leafDistanceLimit = Main.generateRandomInt(25,35);
    List<treeGen_sekwoja.FoliageCoordinates> foliageCoords;

    public treeGen_sekwoja(boolean notify)
    {
        super(notify);
    }

    /**
     * Generates a list of leaf nodes for the tree, to be populated by generateLeaves.
     */
    void generateLeafNodeList()
    {
        this.height = (int)((double)this.heightLimit * this.heightAttenuation);

        if (this.height >= this.heightLimit)
        {
            this.height = this.heightLimit - 1;
        }

        int i = (int)(1.382D + Math.pow(this.leafDensity * (double)this.heightLimit / 13.0D, 2.0D));

        if (i < 1)
        {
            i = 1;
        }

        int j = this.basePos.getY() + this.height;
        int k = this.heightLimit - this.leafDistanceLimit;
        this.foliageCoords = Lists.<treeGen_sekwoja.FoliageCoordinates>newArrayList();
        this.foliageCoords.add(new treeGen_sekwoja.FoliageCoordinates(this.basePos.up(k), j));

        for (; k >= 0; --k)
        {
            float f = this.layerSize(k);

            if (f >= 0.0F)
            {
                for (int l = 0; l < i; ++l)
                {
                    double d0 = this.scaleWidth * (double)f * ((double)this.rand.nextFloat() + 0.328D);
                    double d1 = (double)(this.rand.nextFloat() * 2.0F) * Math.PI;
                    double d2 = d0 * Math.sin(d1) + 0.5D;
                    double d3 = d0 * Math.cos(d1) + 0.5D;
                    BlockPos blockpos = this.basePos.add(d2, (double)(k - 1), d3);
                    BlockPos blockpos1 = blockpos.up(this.leafDistanceLimit);

                    if (this.checkBlockLine(blockpos, blockpos1) == -1)
                    {
                        int i1 = this.basePos.getX() - blockpos.getX();
                        int j1 = this.basePos.getZ() - blockpos.getZ();
                        double d4 = (double)blockpos.getY() - Math.sqrt((double)(i1 * i1 + j1 * j1)) * this.branchSlope;
                        int k1 = d4 > (double)j ? j : (int)d4;
                        BlockPos blockpos2 = new BlockPos(this.basePos.getX(), k1, this.basePos.getZ());

                        if (this.checkBlockLine(blockpos2, blockpos) == -1)
                        {
                            this.foliageCoords.add(new treeGen_sekwoja.FoliageCoordinates(blockpos, blockpos2.getY()));
                        }
                    }
                }
            }
        }
    }

    void crosSection(BlockPos pos, float p_181631_2_, IBlockState p_181631_3_)
    {
        int i = (int)((double)p_181631_2_ + 0.618D);

        for (int j = -i; j <= i; ++j)
        {
            for (int k = -i; k <= i; ++k)
            {
                if (Math.pow((double)Math.abs(j) + 0.5D, 2.0D) + Math.pow((double)Math.abs(k) + 0.5D, 2.0D) <= (double)(p_181631_2_ * p_181631_2_))
                {
                    BlockPos blockpos = pos.add(j, 0, k);
                    IBlockState state = this.world.getBlockState(blockpos);

                    if (state.getBlock().isAir(state, world, blockpos) || state.getBlock().isLeaves(state, world, blockpos))
                    {
                        try {
                            this.setBlockAndNotifyAdequately(this.world, blockpos, p_181631_3_);
                        }catch(Exception e){}
                    }
                }
            }
        }
    }

    /**
     * Gets the rough size of a layer of the tree.
     */
    float layerSize(int y)
    {
        if ((float)y < (float)this.heightLimit * 0.3F)
        {
            return -1.0F;
        }
        else
        {
            float f = (float)this.heightLimit / 2.0F;
            float f1 = f - (float)y;
            float f2 = MathHelper.sqrt(f * f - f1 * f1);

            if (f1 == 0.0F)
            {
                f2 = f;
            }
            else if (Math.abs(f1) >= f)
            {
                return 0.0F;
            }

            return f2 * 0.5F;
        }
    }

    float leafSize(int y)
    {
        if (y >= 0 && y < this.leafDistanceLimit)
        {
            return y != 0 && y != this.leafDistanceLimit - 1 ? 3.0F : 2.0F;
        }
        else
        {
            return -1.0F;
        }
    }

    /**
     * Generates the leaves surrounding an individual entry in the leafNodes list.
     */
    void generateLeafNode(BlockPos pos)
    {
        for (int i = 0; i < this.leafDistanceLimit; ++i)
        {
            this.crosSection(pos.up(i), this.leafSize(i), ModBlocks.CEDAR_LEAVES.getDefaultState().withProperty(LeavesBase.CHECK_DECAY, Boolean.valueOf(false)).withProperty(LeavesBase.DECAYABLE, Boolean.valueOf(false)));
        }
    }

    void limb(BlockPos p_175937_1_, BlockPos p_175937_2_, Block p_175937_3_)
    {
        BlockPos blockpos = p_175937_2_.add(-p_175937_1_.getX(), -p_175937_1_.getY(), -p_175937_1_.getZ());
        int i = this.getGreatestDistance(blockpos);
        float f = (float)blockpos.getX() / (float)i;
        float f1 = (float)blockpos.getY() / (float)i;
        float f2 = (float)blockpos.getZ() / (float)i;

        for (int j = 0; j <= i; ++j)
        {
            BlockPos blockpos1 = p_175937_1_.add((double)(0.5F + (float)j * f), (double)(0.5F + (float)j * f1), (double)(0.5F + (float)j * f2));
            BlockLog.EnumAxis blocklog$enumaxis = this.getLogAxis(p_175937_1_, blockpos1);
            try{
            this.setBlockAndNotifyAdequately(this.world, blockpos1, p_175937_3_.getDefaultState().withProperty(BlockLog.LOG_AXIS, blocklog$enumaxis));
            }catch(Exception e){}

        }
    }

    /**
     * Returns the absolute greatest distance in the BlockPos object.
     */
    private int getGreatestDistance(BlockPos posIn)
    {
        int i = MathHelper.abs(posIn.getX());
        int j = MathHelper.abs(posIn.getY());
        int k = MathHelper.abs(posIn.getZ());

        if (k > i && k > j)
        {
            return k;
        }
        else
        {
            return j > i ? j : i;
        }
    }

    private BlockLog.EnumAxis getLogAxis(BlockPos p_175938_1_, BlockPos p_175938_2_)
    {
        BlockLog.EnumAxis blocklog$enumaxis = BlockLog.EnumAxis.Y;
        int i = Math.abs(p_175938_2_.getX() - p_175938_1_.getX());
        int j = Math.abs(p_175938_2_.getZ() - p_175938_1_.getZ());
        int k = Math.max(i, j);

        if (k > 0)
        {
            if (i == k)
            {
                blocklog$enumaxis = BlockLog.EnumAxis.X;
            }
            else if (j == k)
            {
                blocklog$enumaxis = BlockLog.EnumAxis.Z;
            }
        }

        return blocklog$enumaxis;
    }

    /**
     * Generates the leaf portion of the tree as specified by the leafNodes list.
     */
    void generateLeaves()
    {
        for (treeGen_sekwoja.FoliageCoordinates treeGen_sekwoja$foliagecoordinates : this.foliageCoords)
        {
            try {
                this.generateLeafNode(treeGen_sekwoja$foliagecoordinates);
            }catch(Exception e){
            }
        }
    }

    /**
     * Indicates whether or not a leaf node requires additional wood to be added to preserve integrity.
     */
    boolean leafNodeNeedsBase(int p_76493_1_)
    {
        return (double)p_76493_1_ >= (double)this.heightLimit * 0.2D;
    }

    /**
     * Places the trunk for the big tree that is being generated. Able to generate double-sized trunks by changing a
     * field that is always 1 to 2.
     */
    void generateTrunk()
    {
        BlockPos blockpos = this.basePos;
        /*generateBlock(blockpos.east(),world,80);
        generateBlock(blockpos.west(),world,80);
        generateBlock(blockpos.north(),world,80);
        generateBlock(blockpos.south(),world,80);

        if(!world.isAirBlock(blockpos.east())){
            generateBlock(blockpos.east().up(),world,60);
        }
        if(!world.isAirBlock(blockpos.west())){
            generateBlock(blockpos.west().up(),world,60);
        }
        if(!world.isAirBlock(blockpos.south())){
            generateBlock(blockpos.south().up(),world,60);
        }
        if(!world.isAirBlock(blockpos.north())){
            generateBlock(blockpos.north().up(),world,60);
        }*/
        BlockPos blockpos1 = this.basePos.up(this.height);
        Block block = ModBlocks.CEDAR_LOG;
        this.limb(blockpos, blockpos1, block);

        if (this.trunkSize == 2)
        {
            this.limb(blockpos.east(), blockpos1.east(), block);
            this.limb(blockpos.east().south(), blockpos1.east().south(), block);
            this.limb(blockpos.south(), blockpos1.south(), block);
        }
    }

    /**
     * Generates additional wood blocks to fill out the bases of different leaf nodes that would otherwise degrade.
     */

    public void generateBlock(BlockPos pos,World world,int chance){
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
try{
                    setBlockAndNotifyAdequately(world, blockPos, ModBlocks.CEDAR_LOG.getDefaultState());
}catch(Exception e){}

                }
            }
        }else {

            int foliageX = pos.getX();
            int foliageY = pos.getY();
            int foliageZ = pos.getZ();


            BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
            IBlockState state = world.getBlockState(blockPos);


            if (state.getBlock().isAir(state, world, blockPos) || state.getBlock().isLeaves(state, world, blockPos)) {
try{
                setBlockAndNotifyAdequately(world, blockPos, ModBlocks.CEDAR_LOG.getDefaultState());
}catch(Exception e){}

            }
        }

    }
    void generateLeafNodeBases()
    {
        for (treeGen_sekwoja.FoliageCoordinates treeGen_sekwoja$foliagecoordinates : this.foliageCoords)
        {
            int i = treeGen_sekwoja$foliagecoordinates.getBranchBase();
            BlockPos blockpos = new BlockPos(this.basePos.getX(), i, this.basePos.getZ());

            if (!blockpos.equals(treeGen_sekwoja$foliagecoordinates) && this.leafNodeNeedsBase(i - this.basePos.getY()))
            {
                this.limb(blockpos, treeGen_sekwoja$foliagecoordinates, ModBlocks.CEDAR_LOG);
            }
        }
    }

    /**
     * Checks a line of blocks in the world from the first coordinate to triplet to the second, returning the distance
     * (in blocks) before a non-air, non-leaf block is encountered and/or the end is encountered.
     */
    int checkBlockLine(BlockPos posOne, BlockPos posTwo)
    {
        BlockPos blockpos = posTwo.add(-posOne.getX(), -posOne.getY(), -posOne.getZ());
        int i = this.getGreatestDistance(blockpos);
        float f = (float)blockpos.getX() / (float)i;
        float f1 = (float)blockpos.getY() / (float)i;
        float f2 = (float)blockpos.getZ() / (float)i;

        if (i == 0)
        {
            return -1;
        }
        else
        {
            for (int j = 0; j <= i; ++j)
            {
                BlockPos blockpos1 = posOne.add((double)(0.5F + (float)j * f), (double)(0.5F + (float)j * f1), (double)(0.5F + (float)j * f2));

                if (!this.isReplaceable(world, blockpos1))
                {
                    return j;
                }
            }

            return -1;
        }
    }

    public void setDecorationDefaults()
    {
        this.leafDistanceLimit = 5;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        this.world = worldIn;
        this.basePos = position;
        this.rand = new Random(rand.nextLong());

        if (this.heightLimit == 0)
        {
            this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
        }

        if (!this.validTreeLocation())
        {
            this.world = null; //Fix vanilla Mem leak, holds latest world
            return false;
        }
        else
        {
            try {
                this.generateLeafNodeList();
                this.generateLeaves();
                this.generateTrunk();
                this.generateLeafNodeBases();
                this.world = null; //Fix vanilla Mem leak, holds latest world
                return true;
            }catch(Exception e){
                return false;
            }
        }
    }

    /**
     * Returns a boolean indicating whether or not the current location for the tree, spanning basePos to to the height
     * limit, is valid.
     */
    private boolean validTreeLocation()
    {
        BlockPos down = this.basePos.down();
        IBlockState state = this.world.getBlockState(down);
        boolean isSoil = state.getBlock().canSustainPlant(state, this.world, down, net.minecraft.util.EnumFacing.UP, ((net.minecraft.block.BlockBush) ModBlocks.CEDAR_SAPLING));

        if (!isSoil)
        {
            return false;
        }
        else
        {
            int i = this.checkBlockLine(this.basePos, this.basePos.up(this.heightLimit - 1));

            if (i == -1)
            {
                return true;
            }
            else if (i < 6)
            {
                return false;
            }
            else
            {
                this.heightLimit = i;
                return true;
            }
        }
    }

    static class FoliageCoordinates extends BlockPos
    {
        private final int branchBase;

        public FoliageCoordinates(BlockPos pos, int p_i45635_2_)
        {
            super(pos.getX(), pos.getY(), pos.getZ());
            this.branchBase = p_i45635_2_;
        }

        public int getBranchBase()
        {
            return this.branchBase;
        }
    }
}