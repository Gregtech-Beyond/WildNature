package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.entity.EntityDuckChild;
import com.matez.wildnature.entity.EntityDuckFemale;
import com.matez.wildnature.entity.EntityDuckMale;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.*;
import com.matez.wildnature.worldgen.schematics.trees.hornbeam.*;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

public class BiomeHornbeamForest extends Biome {



    public BiomeHornbeamForest() {
        super(new BiomeProperties("Hornbeam Forest").setBaseHeight(0.3F).setHeightVariation(0.15F).setTemperature(0.35F).setRainfall(0.5F));



    }



    public static IBlockState LOG = ModBlocks.HORNBEAM_LOG.getDefaultState();
    public static IBlockState LEAVES =  ModBlocks.HORNBEAM_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x579D20 : 0x189D44);
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        double noise = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return getModdedBiomeGrassColor(noise < -0.1D ? 0x6DA854 : 0x6A9855);
    }


    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {

        int x = Main.generateRandomInt(1, 6);
        switch (x) {
            case 1:
                return new treeGen_hornbeam1(true,LOG,LEAVES);
            case 2:
                return new treeGen_hornbeam2(true,LOG,LEAVES);
            case 3:
                return new treeGen_hornbeam1(true,LOG,LEAVES);
            case 4:
                return new treeGen_hornbeam4(true,LOG,LEAVES);
            case 5:
                return new treeGen_hornbeam5(true,LOG,LEAVES);
            case 6:
                return new treeGen_hornbeam7(true,LOG,LEAVES);
        }
        return null;
    }


    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = Blocks.GRASS.getDefaultState(); // zwykle to blok trawy
        fillerBlock = Blocks.DIRT.getDefaultState(); // zwykle to ziemia

        decorator.treesPerChunk = 1;
        decorator.grassPerChunk = 16;
        decorator.sandPatchesPerChunk = 6;
        decorator.clayPerChunk=0;

        decorator.flowers.clear();
        decorator.flowers.add(ModBlocks.TALLGRASS_THISTLE.getDefaultState(),4);
        decorator.flowers.add(ModBlocks.CLOVER.getDefaultState(),3);
        decorator.flowers.add(ModBlocks.LEAF_PILE.getDefaultState(),2);
        decorator.flowers.add(ModBlocks.DEAD_LEAF_PILE.getDefaultState(),1);
        decorator.flowers.add(ModBlocks.MALA_TRAWA.getDefaultState(),3);

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


}