package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.schematics.trees.palm.*;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockRedFlower;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;

import java.util.ArrayList;
import java.util.Random;

public class BiomeTropics extends Biome {

    protected static final IBlockState LOG_PALM = ModBlocks.PALM_LOG.getDefaultState();
    protected static final IBlockState LEAVES_PALM = ModBlocks.PALM_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    protected static WorldGenAbstractTree TREE,TREE2,TREE3,TREE4,TREE5,TREE6,TREE7,TREE8,TREE9,TREE10,TREE11,TREE12,TREE13,TREE14,TREE15,TREE16,TREE17;



    public BiomeTropics() {
        super(new BiomeProperties("Tropics").setBaseBiome("ocean").setBaseHeight(0.1F).setHeightVariation(0.2F).setTemperature(0.90F).setRainfall(0.6F).setWaterColor(0xFFFFFF));



    }


    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 4701482 : 241214);
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeFoliageColor(noise < -0.1D ? 5543168 : 3178240);
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        TREE = new treeGen_palm1(true,LOG_PALM,LEAVES_PALM);
        TREE2 = new treeGen_palm2(true,LOG_PALM,LEAVES_PALM);
        TREE3 = new treeGen_palm3(true,LOG_PALM,LEAVES_PALM);
        TREE4 = new treeGen_palm4(true,LOG_PALM,LEAVES_PALM);
        TREE5 = new treeGen_palm5(true,LOG_PALM,LEAVES_PALM);
        TREE6 = new treeGen_palm6(true,LOG_PALM,LEAVES_PALM);
        TREE7 = new treeGen_palm7(true,LOG_PALM,LEAVES_PALM);
        TREE8 = new treeGen_palm8(true,LOG_PALM,LEAVES_PALM);
        TREE9 = new treeGen_palm9(true,LOG_PALM,LEAVES_PALM);
        TREE10 = new treeGen_palm10(true,LOG_PALM,LEAVES_PALM);
        TREE11 = new treeGen_palm11(true,LOG_PALM,LEAVES_PALM);
        TREE12 = new treeGen_palm12(true,LOG_PALM,LEAVES_PALM);
        TREE13 = new treeGen_palm13(true,LOG_PALM,LEAVES_PALM);
        TREE14 = new treeGen_palm14(true,LOG_PALM,LEAVES_PALM);
        TREE15 = new treeGen_palm15(true,LOG_PALM,LEAVES_PALM);
        TREE16 = new treeGen_palm16(true,LOG_PALM,LEAVES_PALM);
        TREE17 = new treeGen_palm17(true,LOG_PALM,LEAVES_PALM);

        int x = Main.generateRandomInt(1,17);
        switch (x){
            case 1:
                return TREE;
            case 2:
                return TREE2;
            case 3:
                return TREE3;
            case 4:
                return TREE4;
            case 5:
                return TREE5;
            case 6:
                return TREE6;
            case 7:
                return TREE7;
            case 8:
                return TREE8;
            case 9:
                return TREE9;
            case 10:
                return TREE10;
            case 11:
                return TREE11;
            case 12:
                return TREE12;
            case 13:
                return TREE13;
            case 14:
                return TREE14;
            case 15:
                return TREE15;
            case 16:
                return TREE16;
            case 17:
                return TREE17;
        }


        return TREE;
    }

    @Override
    public void plantFlower(World world, Random rand, BlockPos pos) {

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

        decorator.treesPerChunk = 3;
        decorator.grassPerChunk = 30;
        decorator.sandPatchesPerChunk = 2;
        decorator.clayPerChunk=0;
        decorator.deadBushPerChunk = 5;
        decorator.cactiPerChunk=0;


        decorator.flowers.clear();
        decorator.flowers.add(ModBlocks.LEAF_PILE.getDefaultState(),5);
        decorator.flowers.add(ModBlocks.CLOVER.getDefaultState(),5);
        decorator.flowers.add(ModBlocks.MALA_TRAWA.getDefaultState(),4);
        decorator.flowers.add(Blocks.MELON_STEM.getDefaultState(),1);
        decorator.flowers.add(Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), BlockRedFlower.EnumFlowerType.BLUE_ORCHID),2);


        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());


        decorator.flowersPerChunk = 40;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        this.generateTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    public final void generateTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        ArrayList<BlockPos> sandPos = new ArrayList<>();
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
                            if(j1==worldIn.getSeaLevel() || j1==worldIn.getSeaLevel()-1|| j1==worldIn.getSeaLevel()-2|| j1==worldIn.getSeaLevel()-3|| j1==worldIn.getSeaLevel()-4|| j1==worldIn.getSeaLevel()-5|| j1==worldIn.getSeaLevel()-6 || j1==worldIn.getSeaLevel()+1|| j1==worldIn.getSeaLevel()+2){
                                iblockstate = ModBlocks.WHITE_SAND.getDefaultState();
                            }else {
                                iblockstate = this.topBlock;
                            }
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

                        if (j1 >= i - 1)
                        {
                            if(iblockstate.getBlock()==ModBlocks.WHITE_SAND){
                                int a = 0;
                                while(a<5){
                                    chunkPrimerIn.setBlockState(i1, j1-a, l, iblockstate);
                                    a++;
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
                            chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
                        }
                    }
                    else if (j > 0)
                    {


                        --j;
                        chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
                        if(iblockstate1.getBlock()==Blocks.SAND){
                            chunkPrimerIn.setBlockState(i1, j1, l, ModBlocks.WHITE_SAND.getDefaultState());
                        }

                        if(iblockstate1==this.topBlock){
                            if(j1==worldIn.getSeaLevel() || j1==worldIn.getSeaLevel()-1|| j1==worldIn.getSeaLevel()-2|| j1==worldIn.getSeaLevel()-3|| j1==worldIn.getSeaLevel()-4|| j1==worldIn.getSeaLevel()-5|| j1==worldIn.getSeaLevel()-6 || j1==worldIn.getSeaLevel()+1|| j1==worldIn.getSeaLevel()+2){
                                chunkPrimerIn.setBlockState(i1, j1, l, ModBlocks.WHITE_SAND.getDefaultState());
                            }
                        }

                        if (j == 0 && iblockstate1.getBlock() == Blocks.SAND && k > 1)
                        {

                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = iblockstate1.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? RED_SANDSTONE : SANDSTONE;
                        }
                    }
                }
            }
        }

        int a = 0;
        while(a<sandPos.size()){
            chunkPrimerIn.setBlockState(sandPos.get(a).getX(),sandPos.get(a).getX(),sandPos.get(a).getX(),ModBlocks.WHITE_SAND.getDefaultState());
            a++;
        }
    }


}