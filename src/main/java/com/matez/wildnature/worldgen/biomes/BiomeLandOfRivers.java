package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.entity.EntityDuckChild;
import com.matez.wildnature.entity.EntityDuckFemale;
import com.matez.wildnature.entity.EntityDuckMale;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.treeGen_pine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
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
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BiomeLandOfRivers extends Biome {

    protected static final WorldGenAbstractTree TREE = new WorldGenTaiga2(true);
    protected static final WorldGenAbstractTree TREE2 = new WorldGenTrees(true);

    public BiomeLandOfRivers() {
        super(new BiomeProperties("Land Of Rivers").setBaseHeight(0.00F).setHeightVariation(0.00F).setTemperature(0.50F).setRainfall(0.9F));



    }



    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        int x = Main.generateRandomInt(1,2);
        switch (x){
            case 1:
                return TREE;
            case 2:
                return TREE2;
        }
        return TREE;
    }



    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 13410673 : 13419628);
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeFoliageColor(noise < -0.1D ? 12766316 : 10730594);
    }

    /**
     * Gets the flower list.
     *
     * @return the flower list
     */




    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();



        decorator.treesPerChunk = 12;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;
        decorator.waterlilyPerChunk=4;


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