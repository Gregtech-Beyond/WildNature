package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.entity.EntityDuckChild;
import com.matez.wildnature.entity.EntityDuckFemale;
import com.matez.wildnature.entity.EntityDuckMale;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

import java.util.ArrayList;
import java.util.Random;

public class BiomeTropicalCavern extends Biome {

    protected static final WorldGenAbstractTree TREE = new WorldGenBigTree(true);

    public BiomeTropicalCavern() {
        super(new BiomeProperties("Tropical Cavern").setBaseHeight(0.3F).setHeightVariation(0.05F).setTemperature(0.70F).setRainfall(0.7F));



    }


    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xb2d709;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
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

        decorator.treesPerChunk = 0;
        decorator.grassPerChunk = 20;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;




        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());
        decorator.generateFalls=false;


        decorator.flowersPerChunk = 20;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 7, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 7, 3, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDuckMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDuckFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDuckChild.class, 1, 1, 2));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBoar.class, 3, 1, 3));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 1, 3, 5));
        //this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        topBlock = Blocks.GRASS.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.DIRT.getDefaultState(); // zwykle to ziemia

        if (noiseVal > 1.75D) {

        } else if (noiseVal > -0.95D) {
            this.topBlock = ModBlocks.WHITE_SAND.getDefaultState();
            this.fillerBlock = Blocks.OBSIDIAN.getDefaultState();
        }

        this.generateTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    private ArrayList<BlockPos> toReplace = new ArrayList<>();

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

                        if (j1 >= i - 1)
                        {
                            setBlockState(chunkPrimerIn, i1, j1, l, iblockstate);
                        }
                        else if (j1 < i - 7 - k)
                        {
                            iblockstate = AIR;
                            iblockstate1 = STONE;
                            setBlockState(chunkPrimerIn, i1, j1, l, GRAVEL);
                        }
                        else
                        {
                            setBlockState(chunkPrimerIn, i1, j1, l, iblockstate1);
                        }
                    }
                    else if (j > 0)
                    {
                        --j;
                        setBlockState(chunkPrimerIn, i1, j1, l, iblockstate1);

                        if (j == 0 && iblockstate1.getBlock() == Blocks.SAND && k > 1)
                        {
                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = iblockstate1.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? RED_SANDSTONE : SANDSTONE;
                        }
                    }
                }
            }
        }

        replaceBlocks(chunkPrimerIn,worldIn);
    }

    private void setBlockState(ChunkPrimer chunkPrimer, int x, int y, int z, IBlockState state){
        if(state.getBlock()==Blocks.OBSIDIAN){
            toReplace.add(new BlockPos(x,y,z));
        }
        chunkPrimer.setBlockState(x,y,z,state);
    }

    private void replaceBlocks(ChunkPrimer primer, World world){
        int x = 0;
        int dig = 4;
        IBlockState GROUND = ModBlocks.WHITE_SAND.getDefaultState();
        while(x<toReplace.size()){
            BlockPos pos = toReplace.get(x);
            if(primer.getBlockState(pos.getX(),pos.getY()-1,pos.getZ()).getBlock()==Blocks.OBSIDIAN){
                x++;
                continue;
            }else{
                int y = 0;
                while(y<=dig){
                    int i = pos.getY()-1-y;
                    IBlockState b = Blocks.AIR.getDefaultState();
                    if(i<world.getSeaLevel()){
                        b = Blocks.FLOWING_WATER.getDefaultState();
                    }
                    primer.setBlockState(pos.getX(),i,pos.getZ(),b);
                    y++;
                }
                int i = pos.getY()-2-y;
                primer.setBlockState(pos.getX(),i,pos.getZ(),GROUND);
            }

            x++;
        }
    }
}