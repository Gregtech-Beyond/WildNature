package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.entity.EntityDuckChild;
import com.matez.wildnature.entity.EntityDuckFemale;
import com.matez.wildnature.entity.EntityDuckMale;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.BigTree;
import com.matez.wildnature.worldgen.schematics.trees.birch.*;
import com.matez.wildnature.worldgen.treeGen_ebony;
import com.matez.wildnature.worldgen.treeGen_mahogany;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.ArrayList;
import java.util.Random;

public class BiomeMasuria extends Biome {

    public static IBlockState LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
    public static IBlockState LEAVES = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState DARKLOG = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
    public static IBlockState DARKLEAVES = Blocks.LEAVES2.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public static IBlockState BIRCHLOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
    public static IBlockState BIRCHLEAVES = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    protected static  WorldGenAbstractTree TREE1;
    protected static  WorldGenAbstractTree TREE2;
    protected static  WorldGenAbstractTree TREE3;
    protected static  WorldGenAbstractTree TREE4;
    protected static  WorldGenAbstractTree TREE5;
    protected static  WorldGenAbstractTree TREE6;
    protected static  WorldGenAbstractTree TREE7;
    protected static  WorldGenAbstractTree TREE8;
    protected static  WorldGenAbstractTree TREE9;
    protected static  WorldGenAbstractTree TREE10;
    protected static  WorldGenAbstractTree TREE11;
    protected static  WorldGenAbstractTree TREE;




    public BiomeMasuria() {
        super(new BiomeProperties("Masuria").setBaseHeight(0.01F).setHeightVariation(0.0F).setTemperature(0.50F).setRainfall(0.8F));



    }



    @Override
    public int getWaterColorMultiplier() {
        return 0x0083C9;
    }


    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x6CC511 : 0x8DC557);
    }


    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeFoliageColor(noise < -0.1D ? 0x65AC46 : 0x7BAC3F);
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0xA8EBE8;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        TREE = new WorldGenBigTree(true);
        TREE1 = new treeGen_birch10(true,LOG,LEAVES);
        TREE2 = new treeGen_birch1(true,LOG,LEAVES);
        TREE4 = new treeGen_birch10(true,DARKLOG,DARKLEAVES);
        TREE5 = new treeGen_birch1(true,DARKLOG,DARKLEAVES);
        //
        TREE6= new treeGen_birch1(true,BIRCHLOG,BIRCHLEAVES);
        TREE7= new treeGen_birch2(true,BIRCHLOG,BIRCHLEAVES);
        TREE8= new treeGen_birch7(true,BIRCHLOG,BIRCHLEAVES);
        TREE9= new treeGen_birch10(true,BIRCHLOG,BIRCHLEAVES);
        TREE10= new treeGen_birch11(true,BIRCHLOG,BIRCHLEAVES);
        TREE11= new treeGen_birch12(true,BIRCHLOG,BIRCHLEAVES);


        switch (Main.generateRandomInt(0,4)){
            case 0:
                return TREE;
            case 1:
                switch (Main.generateRandomInt(0,1)){
                    case 0:
                        return TREE1;
                    case 1:
                        return TREE2;
                }
            case 2:
                switch (Main.generateRandomInt(0,1)){
                    case 0:
                        return TREE4;
                    case 1:
                        return TREE5;
                }
            case 3:case4:
            {
                switch (Main.generateRandomInt(0, 5)) {
                    case 0:
                        return TREE6;
                    case 1:
                        return TREE7;
                    case 2:
                        return TREE8;
                    case 3:
                        return TREE9;
                    case 4:
                        return TREE10;
                    case 5:
                        return TREE11;
                }
            }
        }

        return TREE;
    }





    /**
     * Gets the flower list.
     *
     * @return the flower list
     */




    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = ModBlocks.MOLD_GRASS_BLOCK.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.ZIEMA_CZARNOZIEM.getDefaultState(); // zwykle to ziemia

        decorator.treesPerChunk = 3;
        decorator.grassPerChunk = 12;
        decorator.sandPatchesPerChunk = 8;
        decorator.clayPerChunk=9;



        decorator.flowers.clear();
        decorator.flowers.add(Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), BlockRedFlower.EnumFlowerType.HOUSTONIA),5);
        decorator.flowers.add(ModBlocks.CLOVER.getDefaultState(),7);
        decorator.flowers.add(ModBlocks.LEAF_PILE.getDefaultState(),8);
        decorator.flowers.add(ModBlocks.DZWONECZEK.getDefaultState(),2);



        decorator.flowersPerChunk = 12;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 7, 4, 4));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 7, 3, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 2, 1, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDuckChild.class, 1, 1, 2));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
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