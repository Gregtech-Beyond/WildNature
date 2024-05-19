package com.matez.wildnature.worldgen.biomes;

import com.matez.wildnature.entity.EntityCamelChild;
import com.matez.wildnature.entity.EntityCamelFemale;
import com.matez.wildnature.entity.EntityCamelMale;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.BlockLeaves;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;

import java.util.Random;

public class BiomeDesertDesolation extends Biome {




    public BiomeDesertDesolation() {
        super(new BiomeProperties("Desert Desolation").setBaseHeight(0.1F).setHeightVariation(0.0F).setTemperature(0.85F).setRainfall(0.0F));



    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xB49D5D;
    }


    @Override
    public void plantFlower(World world, Random rand, BlockPos pos) {

    }





    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator1 decorator = new BiomeDecorator1();
        topBlock = ModBlocks.DRIED_SAND.getDefaultState(); // zwykle to blok trawy
        fillerBlock = ModBlocks.DRIED_SAND.getDefaultState(); // zwykle to ziemia


        decorator.treesPerChunk = -1;
        decorator.grassPerChunk = 0;
        decorator.sandPatchesPerChunk = 0;
        decorator.clayPerChunk=0;
        decorator.extraTreeChance=0;
        

        decorator.mushrooms.add(ModBlocks.BOROWIK_SZLACHETNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.BOROWIK_WYSMUKLY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.KOZLARZ_CZERWONY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MASLAK_ZWYCZAJNY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MLECZAJ_RYDZ.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_SROMOTNIKOWY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.MUCHOMOR_JADOWITY.getDefaultState());
        decorator.mushrooms.add(ModBlocks.PIEPRZNIK_JADALNY.getDefaultState());

        decorator.flowers.clear();
        decorator.flowers.add(ModBlocks.DEAD_SHORT_GRASS.getDefaultState(),5);

        decorator.flowersPerChunk = 2;

        return getModdedBiomeDecorator(decorator);
    }

    @Override
    public void addDefaultFlowers() {
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombie.class, 19, 4, 4));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 1, 1, 1));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityHusk.class, 80, 4, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCamelMale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCamelFemale.class, 3, 1, 2));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCamelChild.class, 2, 1, 2));
    }


}