package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.Random;

public class BiomeLightMesa extends Biome {

    protected static final IBlockState COARSE_DIRT = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
    protected static final IBlockState GRASS = Blocks.GRASS.getDefaultState();
    protected static final IBlockState HARDENED_CLAY = Blocks.HARDENED_CLAY.getDefaultState();
    protected static final IBlockState STAINED_HARDENED_CLAY = Blocks.STAINED_HARDENED_CLAY.getDefaultState();
    protected static final IBlockState ORANGE_STAINED_HARDENED_CLAY = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.GRAY);
    protected static final IBlockState RED_SAND = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND);
    private IBlockState[] clayBands;
    private long worldSeed;
    private NoiseGeneratorPerlin pillarNoise;
    private NoiseGeneratorPerlin pillarRoofNoise;
    private NoiseGeneratorPerlin clayBandsOffsetNoise;
    private final boolean brycePillars = true;
    private final boolean hasForest = false;

    public BiomeLightMesa() {
        super(new BiomeProperties("Light Mesa").setBaseBiome("mesa").setBaseHeight(0.8F).setHeightVariation(0.3F).setTemperature(0.80F).setRainfall(0.2F));



    }


    @Override
    public void plantFlower(World world, Random rand, BlockPos pos) {

    }





    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = Blocks.RED_SANDSTONE.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.RED_SANDSTONE.getDefaultState(); // zwykle to ziemia
        spawnableCreatureList.clear();
        spawnableCreatureList.clear();
        decorator.generateFalls=false;
        decorator.treesPerChunk = -999;
        decorator.grassPerChunk = -999;
        decorator.sandPatchesPerChunk = -999;
        decorator.deadBushPerChunk = 20;
        decorator.reedsPerChunk = 3;
        decorator.cactiPerChunk = 5;
        

        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());


        decorator.flowersPerChunk = 20;

        return getModdedBiomeDecorator(decorator);
    }

    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        if (this.clayBands == null || this.worldSeed != worldIn.getSeed())
        {
            this.generateBands(worldIn.getSeed());
        }

        if (this.pillarNoise == null || this.pillarRoofNoise == null || this.worldSeed != worldIn.getSeed())
        {
            Random random = new Random(this.worldSeed);
            this.pillarNoise = new NoiseGeneratorPerlin(random, 4);
            this.pillarRoofNoise = new NoiseGeneratorPerlin(random, 1);
        }

        this.worldSeed = worldIn.getSeed();
        double d4 = 0.0D;

        if (this.brycePillars)
        {
            int i = (x & -16) + (z & 15);
            int j = (z & -16) + (x & 15);
            double d0 = Math.min(Math.abs(noiseVal), this.pillarNoise.getValue((double)i * 0.25D, (double)j * 0.25D));

            if (d0 > 0.0D)
            {
                double d1 = 0.001953125D;
                double d2 = Math.abs(this.pillarRoofNoise.getValue((double)i * 0.001953125D, (double)j * 0.001953125D));
                d4 = d0 * d0 * 2.5D;
                double d3 = Math.ceil(d2 * 50.0D) + 14.0D;

                if (d4 > d3)
                {
                    d4 = d3;
                }

                d4 = d4 + 64.0D;
            }
        }

        int k1 = x & 15;
        int l1 = z & 15;
        int i2 = worldIn.getSeaLevel();
        IBlockState iblockstate = STAINED_HARDENED_CLAY;
        IBlockState iblockstate3 = this.fillerBlock;
        int k = (int)(noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        boolean flag = Math.cos(noiseVal / 3.0D * Math.PI) > 0.0D;
        int l = -1;
        boolean flag1 = false;
        int i1 = 0;

        for (int j1 = 255; j1 >= 0; --j1)
        {
            if (chunkPrimerIn.getBlockState(l1, j1, k1).getMaterial() == Material.AIR && j1 < (int)d4)
            {
                chunkPrimerIn.setBlockState(l1, j1, k1, STAINED_HARDENED_CLAY);
            }

            if (j1 <= rand.nextInt(5))
            {
                chunkPrimerIn.setBlockState(l1, j1, k1, BEDROCK);
            }
            else if (i1 < 15 || this.brycePillars)
            {
                IBlockState iblockstate1 = chunkPrimerIn.getBlockState(l1, j1, k1);

                if (iblockstate1.getMaterial() == Material.AIR)
                {
                    l = -1;
                }
                else if (iblockstate1.getBlock() == Blocks.STONE)
                {
                    if (l == -1)
                    {
                        flag1 = false;

                        if (k <= 0)
                        {
                            iblockstate = AIR;
                            iblockstate3 = STAINED_HARDENED_CLAY;
                        }
                        else if (j1 >= i2 - 4 && j1 <= i2 + 1)
                        {
                            iblockstate = STAINED_HARDENED_CLAY;
                            iblockstate3 = this.fillerBlock;
                        }

                        if (j1 < i2 && (iblockstate == null || iblockstate.getMaterial() == Material.AIR))
                        {
                            iblockstate = WATER;
                        }

                        l = k + Math.max(0, j1 - i2);

                        if (j1 >= i2 - 1)
                        {
                            if (this.hasForest && j1 > 86 + k * 2)
                            {
                                if (flag)
                                {
                                    chunkPrimerIn.setBlockState(l1, j1, k1, COARSE_DIRT);
                                }
                                else
                                {
                                    chunkPrimerIn.setBlockState(l1, j1, k1, GRASS);
                                }
                            }
                            else if (j1 > i2 + 3 + k)
                            {
                                IBlockState iblockstate2;

                                if (j1 >= 64 && j1 <= 127)
                                {
                                    if (flag)
                                    {
                                        iblockstate2 = HARDENED_CLAY;
                                    }
                                    else
                                    {
                                        iblockstate2 = this.getBand(x, j1, z);
                                    }
                                }
                                else
                                {
                                    iblockstate2 = ORANGE_STAINED_HARDENED_CLAY;
                                }

                                chunkPrimerIn.setBlockState(l1, j1, k1, iblockstate2);
                            }
                            else
                            {
                                chunkPrimerIn.setBlockState(l1, j1, k1, this.topBlock);
                                flag1 = true;
                            }
                        }
                        else
                        {
                            chunkPrimerIn.setBlockState(l1, j1, k1, iblockstate3);

                            if (iblockstate3.getBlock() == Blocks.STAINED_HARDENED_CLAY)
                            {
                                chunkPrimerIn.setBlockState(l1, j1, k1, ORANGE_STAINED_HARDENED_CLAY);
                            }
                        }
                    }
                    else if (l > 0)
                    {
                        --l;

                        if (flag1)
                        {
                            chunkPrimerIn.setBlockState(l1, j1, k1, ORANGE_STAINED_HARDENED_CLAY);
                        }
                        else
                        {
                            chunkPrimerIn.setBlockState(l1, j1, k1, this.getBand(x, j1, z));
                        }
                    }

                    ++i1;
                }
            }
        }
    }

    public void generateBands(long p_150619_1_)
    {
        this.clayBands = new IBlockState[64];
        Arrays.fill(this.clayBands, HARDENED_CLAY);
        Random random = new Random(p_150619_1_);
        this.clayBandsOffsetNoise = new NoiseGeneratorPerlin(random, 1);

        for (int l1 = 0; l1 < 64; ++l1)
        {
            l1 += random.nextInt(5) + 1;

            if (l1 < 64)
            {
                this.clayBands[l1] = ORANGE_STAINED_HARDENED_CLAY;
            }
        }

        int i2 = random.nextInt(4) + 2;

        for (int i = 0; i < i2; ++i)
        {
            int j = random.nextInt(3) + 1;
            int k = random.nextInt(64);

            for (int l = 0; k + l < 64 && l < j; ++l)
            {
                this.clayBands[k + l] = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.WHITE);
            }
        }

        int j2 = random.nextInt(4) + 2;

        for (int k2 = 0; k2 < j2; ++k2)
        {
            int i3 = random.nextInt(3) + 2;
            int l3 = random.nextInt(64);

            for (int i1 = 0; l3 + i1 < 64 && i1 < i3; ++i1)
            {
                this.clayBands[l3 + i1] = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);
            }
        }

        int l2 = random.nextInt(4) + 2;

        for (int j3 = 0; j3 < l2; ++j3)
        {
            int i4 = random.nextInt(3) + 1;
            int k4 = random.nextInt(64);

            for (int j1 = 0; k4 + j1 < 64 && j1 < i4; ++j1)
            {
                this.clayBands[k4 + j1] = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.BLACK);
            }
        }

        int k3 = random.nextInt(3) + 3;
        int j4 = 0;

        for (int l4 = 0; l4 < k3; ++l4)
        {
            int i5 = 1;
            j4 += random.nextInt(16) + 4;

            for (int k1 = 0; j4 + k1 < 64 && k1 < 1; ++k1)
            {
                this.clayBands[j4 + k1] = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.WHITE);

                if (j4 + k1 > 1 && random.nextBoolean())
                {
                    this.clayBands[j4 + k1 - 1] = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.SILVER);
                }

                if (j4 + k1 < 63 && random.nextBoolean())
                {
                    this.clayBands[j4 + k1 + 1] = STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.SILVER);
                }
            }
        }
    }

    public IBlockState getBand(int p_180629_1_, int p_180629_2_, int p_180629_3_)
    {
        int i = (int)Math.round(this.clayBandsOffsetNoise.getValue((double)p_180629_1_ / 512.0D, (double)p_180629_1_ / 512.0D) * 2.0D);
        return this.clayBands[(p_180629_2_ + i + 64) % 64];
    }

    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 10387789;
    }

    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos)
    {
        return 9470285;
    }




}