package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.BigTree;
import com.matez.wildnature.worldgen.schematics.trees.big.treeGen_bigJungle;
import com.matez.wildnature.worldgen.treeGen_ebony;
import com.matez.wildnature.worldgen.treeGen_mahogany;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.ArrayList;
import java.util.Random;

public class BiomeAmazonia extends Biome {

    private static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
    private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    protected static  WorldGenAbstractTree TREE;
    protected static  WorldGenAbstractTree TREE2;
    protected static  WorldGenAbstractTree TREE3;
    protected static  WorldGenAbstractTree TREE4;
    protected static  WorldGenAbstractTree TREE5;





    public BiomeAmazonia() {
        super(new BiomeProperties("Amazonia").setBaseBiome("mahogany_rainforest").setBaseHeight(0.01F).setHeightVariation(0.0F).setTemperature(0.90F).setRainfall(0.8F));



    }



    @Override
    public int getWaterColorMultiplier() {
        return 0x00ffd8;
    }


    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x4FD038 : 0x2ACB53);
    }


    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeFoliageColor(noise < -0.1D ? 0x83DA29 : 0x8CD629);
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0xB1EB7D;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {

        TREE = new BigTree(true,16,1,1.0D,Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY,false).withProperty(BlockLeaves.DECAYABLE,false).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)),Blocks.SAPLING.getDefaultState());;
        TREE2 = new WorldGenShrub(Blocks.LOG.getDefaultState(),Blocks.LEAVES.getDefaultState());;
        TREE3 = new WorldGenShrub(JUNGLE_LOG,JUNGLE_LEAF);
        TREE4 = new treeGen_mahogany(true);
        TREE5 = new treeGen_ebony(true);


        int x = Main.generateRandomInt(1,13,rand);
        if(x<=3){
            return TREE;
        }else if(x<=5){
            return TREE2;
        }else if(x<=7){
            return TREE3;
        }else if(x<=11){
            return TREE4;
        }else{
            return TREE5;
        }


    }





    /**
     * Gets the flower list.
     *
     * @return the flower list
     */




    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = Blocks.GRASS.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.DIRT.getDefaultState(); // zwykle to ziemia

        decorator.treesPerChunk = 20;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 8;
        decorator.clayPerChunk=9;



        decorator.flowers.clear();
        decorator.flowers.add(Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), BlockRedFlower.EnumFlowerType.BLUE_ORCHID),10);
        decorator.flowers.add(ModBlocks.TALLGRASS_FERNSPROUT.getDefaultState(),7);
        decorator.flowers.add(ModBlocks.LEAF_PILE.getDefaultState(),5);
        decorator.flowers.add(Blocks.MELON_STEM.getDefaultState(),4);
        decorator.flowers.add(ModBlocks.IRIS_VIOLET.getDefaultState(),3);



        decorator.flowersPerChunk = 15;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityParrot.class, 50, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityOcelot.class, 2, 1, 1));
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();

        if (noiseVal > 1.55D) {

        } else if (noiseVal > -1.25D) {
            this.topBlock = Blocks.WATER.getDefaultState();
            this.fillerBlock = Blocks.FLOWING_WATER.getDefaultState();
        }

        this.generateTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    public ArrayList<BlockPos> posArrayList = new ArrayList<>();
    public final void generateTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        int i = worldIn.getSeaLevel();
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int j = -1;
        int k = (int)(noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int l = x & 15;
        int i1 = z & 15;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int j1 = 255; j1 >= 0; --j1)
        {
            if (j1 <= rand.nextInt(5))
            {
                chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
            }
            else
            {
                IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);

                if (iblockstate2.getMaterial() == Material.AIR)
                {
                    j = -1;
                }
                else if (iblockstate2.getBlock() == Blocks.STONE)
                {
                    if (j == -1)
                    {
                        if (k <= 0)
                        {
                            iblockstate = AIR;
                            iblockstate1 = STONE;
                        }
                        else if (j1 >= i - 4 && j1 <= i + 1)
                        {
                            iblockstate = this.topBlock;
                            iblockstate1 = this.fillerBlock;
                        }

                        if (j1 < i && (iblockstate == null || iblockstate.getMaterial() == Material.AIR))
                        {
                            if (this.getTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F)
                            {
                                iblockstate = ICE;
                            }
                            else
                            {
                                iblockstate = WATER;
                            }
                        }

                        j = k;

                        if(j1>67){
                            if(iblockstate.equals(Blocks.WATER.getDefaultState())){
                                iblockstate = Blocks.GRASS.getDefaultState();
                            }
                        }

                        if (j1 >= i - 1)
                        {
                            if(iblockstate.getBlock().equals(Blocks.WATER) || iblockstate.getBlock().equals(Blocks.FLOWING_WATER)){
                                int g =Main.generateRandomInt(1,2);
                                switch (g){
                                    case 1:
                                        chunkPrimerIn.setBlockState(i1, j1, l, Blocks.GRASS.getDefaultState());

                                    case 2:
                                        setRiver(new BlockPos(i1,j1,l),chunkPrimerIn,this.topBlock,worldIn);
                                }
                            }else {
                                chunkPrimerIn.setBlockState(i1, j1, l, iblockstate);
                            }
                        }
                        else if (j1 < i - 7 - k)
                        {
                            iblockstate = AIR;
                            iblockstate1 = STONE;
                            chunkPrimerIn.setBlockState(i1, j1, l, GRAVEL);
                        }
                        else
                        {

                            setRiver(new BlockPos(i1,j1,l),chunkPrimerIn,iblockstate1,worldIn);
                        }
                    }
                    else if (j > 0)
                    {
                        --j;

                        setRiver(new BlockPos(i1,j1,l),chunkPrimerIn,iblockstate1,worldIn);


                        if (j == 0 && iblockstate1.getBlock() == Blocks.SAND && k > 1)
                        {
                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = iblockstate1.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? RED_SANDSTONE : SANDSTONE;
                        }
                    }
                }
            }
        }

        /*int abc = 0;
        int size = posArrayList.size();
        while(abc<size){
            setRiver(posArrayList.get(abc).down(1),chunkPrimerIn,Blocks.FLOWING_WATER.getDefaultState(),worldIn);
            abc++;
        }*/
    }

    public void setRiver(BlockPos pos, ChunkPrimer chunkPrimer, IBlockState blockState, World world){

        if(blockState==Blocks.WATER.getDefaultState() || blockState==Blocks.FLOWING_WATER.getDefaultState()){
            if(pos.getY()<=(world.getSeaLevel()-1)){
                int a = 0;
                if(!(pos.getY()<=0) && !(pos.getY()+3<world.getSeaLevel()-1)) {

                    while (a < 5) {
                        chunkPrimer.setBlockState(pos.getX(), pos.getY() - a, pos.getZ(), Blocks.WATER.getDefaultState());
                        a++;
                    }
                    chunkPrimer.setBlockState(pos.getX(), pos.getY() - a, pos.getZ(), Blocks.DIRT.getDefaultState());
                }

            }else{
                chunkPrimer.setBlockState(pos.getX(),pos.getY(),pos.getZ(),Blocks.AIR.getDefaultState());
                posArrayList.add(pos);
            }
        }
    }


}