package com.matez.wildnature.init;

import com.matez.wildnature.Main;
import com.matez.wildnature.event.FogBiome;
import com.matez.wildnature.worldgen.biomes.*;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import java.util.Arrays;

import java.awt.*;
import java.util.ArrayList;

public class BiomeInit {


    public static final Biome PINE_FOREST = new BiomePineForest();
    public static final Biome PINE_HILL = new BiomePineHill();
    public static final Biome ORCHARD = new BiomeOrchard();
    public static final Biome CHERRY_ORCHARD = new BiomeCherryOrchard();
    public static final Biome WETLANDS = new BiomeWetlands();
    public static final Biome HIGHLANDS = new BiomeHighlands();
    public static final Biome TATRA_MOUNTAINS = new BiomeTatraMountains();
    public static final Biome CONIFEROUS_FOREST = new BiomeConiferousForest();
    public static final Biome SNOWY_CONIFEROUS_FOREST = new BiomeSnowyConiferousForest();
    public static final Biome FROZEN_CONIFEROUS_FOREST = new BiomeFrozenConiferousForest();
    public static final Biome TUNDRA = new BiomeTundra();
    public static final Biome DIORITE_MOUNTAINS = new BiomeDioriteMountains();
    public static final Biome GRANITE_MOUNTAINS = new BiomeGraniteMountains();
    public static final Biome PRISMARINE_MOUNTAINS = new BiomePrismarineMountains();
    public static final Biome FROZEN_MOUNTAINS = new BiomeFrozenMountains();
    public static final Biome GLACIER = new BiomeGlacier();
    public static final Biome STEPPE = new BiomeSteppe();
    public static final Biome EUCALYPTUS_FOREST = new BiomeEucalyptusForest();
    public static final Biome GRAND_CANYON = new BiomeGrandCanyon();
    public static final Biome OVERGROWN_MOUNTAINS = new BiomeOvergrownMountains();
    public static final Biome JACARANDA_FOREST = new BiomeJacarandaForest();
    public static final Biome DECIDUOUS_FOREST = new BiomeDeciduousForest();
    public static final Biome DECIDUOUS_MOUNTAIN = new BiomeDeciduousMountain();
    public static final Biome REDWOOD_FOREST = new BiomeRedwoodForest();
    public static final Biome GRASSLAND = new BiomeGrassland();
    public static final Biome DENSE_FOREST = new BiomeDenseForest();
    public static final Biome DENSE_DARK_FOREST = new BiomeDenseDarkForest();
    public static final Biome MOOR = new BiomePeatlands();
    public static final Biome RAINFOREST = new BiomeRainforest();
    public static final Biome SAVANNA_DESERT_HILLS = new BiomeSavannaDesertHills();
    public static final Biome SAVANNA_DESERT = new BiomeSavannaDesert();
    public static final Biome SAVANNA_EDGE_HILLS = new BiomeSavannaEdgeHills();
    public static final Biome SAVANNA_EDGE = new BiomeSavannaEdge();
    public static final Biome RED_SAVANNA_DESERT_HILLS = new BiomeRedSavannaDesertHills();
    public static final Biome RED_SAVANNA_DESERT = new BiomeRedSavannaDesert();
    public static final Biome MIXED_SAVANNA_DESERT_HILLS = new BiomeMixedSavannaDesertHills();
    public static final Biome MIXED_SAVANNA_DESERT = new BiomeMixedSavannaDesert();
    public static final Biome MIXED_DESERT = new BiomeMixedDesert();
    public static final Biome MIXED_DESERT_MOUNTAINS = new BiomeMixedDesertMountains();
    public static final Biome TAIGA_MOUNTAINS = new BiomeTaigaMountains();
    public static final Biome LIGHT_MESA = new BiomeLightMesa();
    public static final Biome TROPICAL_MESA = new BiomeTropicalMesa();
    public static final Biome TROPICAL_WATER_ROCKS = new BiomeTropicalWaterRocks();
    public static final Biome HORNBEAM_FOREST = new BiomeHornbeamForest();
    public static final Biome MARSH = new BiomeMarsh();
    public static final Biome LAND_OF_RIVERS = new BiomeLandOfRivers();
    public static final Biome DUNES = new BiomeDunes();
    public static final Biome TROPICS = new BiomeTropics();
    public static final Biome AUTUMNAL_FOREST = new BiomeAutumnalForest();
    public static final Biome MISTY_MOUNTAINS = new BiomeMistyMountains();
    public static final Biome PRAIRIE = new BiomePrairie();
    public static final Biome POLAR_PLATEAU = new BiomePolarPlateau();
    public static final Biome AMAZONIA = new BiomeAmazonia();
    public static final Biome MAHOGANY_RAINFOREST = new BiomeMahoganyRainforest();
    public static final Biome MAHOGANY_OVERGROWN_MOUNTAINS = new BiomeMahoganyMountains();
    public static final Biome PRAIRIE_PLATEAU = new BiomePrairiePlateau();
    public static final Biome NATURAL_MAZE = new BiomeNaturalMaze();
    public static final Biome ROCKY_SPRUCE_FOREST = new BiomeRockySpruceForest();
    public static final Biome ROOFED_FOREST_HILLS = new BiomeRoofedForestHills();
    public static final Biome SEA_HIGHLANDS = new BiomeSeaHighlands();
    public static final Biome BIRCH_GROVE = new BiomeBirchGrove();
    public static final Biome MAPLE_TAIGA = new BiomeMapleTaiga();
    public static final Biome SANDY_TROPICS = new BiomeSandyTropics();
    public static final Biome MISTY_SWAMP = new BiomeMistySwamp();
    public static final Biome TAIGA_PLATEAU = new BiomeTaigaPlateau();
    public static final Biome ROCKY_MOUNTAINS = new BiomeRockyMountains();
    public static final Biome HIGH_PLAINS = new BiomeHighPlains();
    public static final Biome FLOWER_FIELD = new BiomeFlowerField();
    public static final Biome FIELD_OF_CORN = new BiomeFieldOfCorn();
    public static final Biome MASURIA = new BiomeMasuria();
    public static final Biome LUPINE_FIELD = new BiomeLupineField();//
    public static final Biome VOLCANO = new BiomeVulcanic();//
    public static final Biome MADAGASCAR_PASTURE = new BiomeMadagascarPasture();//
    public static final Biome MADAGASCAR_RAINFOREST = new BiomeMadascarRainforest();//
    public static final Biome BOREAL_PINE_FOREST = new BiomeBorealPineForest();//
    public static final Biome BLUE_FIELD = new BiomeBlueField();//
    public static final Biome PURPLE_FIELD = new BiomePurpleFields();//
    public static final Biome CEDAR_FOREST = new BiomeCedarForest();//
    public static final Biome HIMALAYAS = new BiomeHimalayas();//
    public static final Biome DESERT_DESOLATION = new BiomeDesertDesolation();//
    public static final Biome OUTBACK = new BiomeOutback();//
    public static final Biome BIALOWIEZA_FOREST = new BiomeBialowiezaForest();//
    public static final Biome SNOWY_BIALOWIEZA_FOREST = new BiomeSnowyBialowiezaForest();//







    public static int biomes = 0 ;

    public static void registerBiomes(){

        initBiome(BIALOWIEZA_FOREST,"bialowieza_forest", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE,BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.RARE);
        initBiome(SNOWY_BIALOWIEZA_FOREST,"snowy_bialowieza_forest", BiomeManager.BiomeType.ICY, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE,BiomeDictionary.Type.CONIFEROUS,BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.RARE);
        initBiome(PINE_FOREST,"pine_forest", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST);
        initBiome(PINE_HILL,"pine_hill", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.FOREST);
        initBiome(BOREAL_PINE_FOREST,"boreal_pine_forest", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST);
        initBiome(WETLANDS,"wetlands", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.WET , BiomeDictionary.Type.SWAMP,BiomeDictionary.Type.LUSH);
        initBiome(ORCHARD,"orchard", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET,BiomeDictionary.Type.FOREST, BiomeDictionary.Type.RARE);
        initBiome(CHERRY_ORCHARD,"cherry_orchard", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET,BiomeDictionary.Type.FOREST, BiomeDictionary.Type.RARE);
        initBiome(HIGHLANDS,"highlands", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.WET,BiomeDictionary.Type.FOREST);
        initBiome(TATRA_MOUNTAINS,"tatra_mountains", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.MOUNTAIN,BiomeDictionary.Type.FOREST, BiomeDictionary.Type.RARE);
        initBiome(CONIFEROUS_FOREST,"coniferous_forest", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE,BiomeDictionary.Type.CONIFEROUS);
        initBiome(SNOWY_CONIFEROUS_FOREST,"snowy_coniferous_forest", BiomeManager.BiomeType.ICY, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE,BiomeDictionary.Type.CONIFEROUS);
        initBiome(FROZEN_CONIFEROUS_FOREST,"frozen_coniferous_forest", BiomeManager.BiomeType.ICY, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE,BiomeDictionary.Type.CONIFEROUS);
        initBiome(TUNDRA,"tundra", BiomeManager.BiomeType.ICY,BiomeDictionary.Type.PLAINS,BiomeDictionary.Type.DEAD,BiomeDictionary.Type.WET);
        initBiome(TAIGA_MOUNTAINS,"taiga_mountains", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.MOUNTAIN,BiomeDictionary.Type.FOREST);
        initBiome(DIORITE_MOUNTAINS,"diorite_mountains", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.MOUNTAIN,BiomeDictionary.Type.HILLS, BiomeDictionary.Type.RARE);
        initBiome(GRANITE_MOUNTAINS,"granite_mountains", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.MOUNTAIN,BiomeDictionary.Type.HILLS, BiomeDictionary.Type.RARE);
        initBiome(PRISMARINE_MOUNTAINS,"prismarine_mountains", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.MOUNTAIN,BiomeDictionary.Type.HILLS, BiomeDictionary.Type.RARE,BiomeDictionary.Type.OCEAN);
        initBiome(FROZEN_MOUNTAINS,"frozen_mountains", BiomeManager.BiomeType.ICY, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.RARE);
        initBiome(MISTY_MOUNTAINS,"misty_mountains", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.MOUNTAIN,BiomeDictionary.Type.COLD,BiomeDictionary.Type.DEAD,BiomeDictionary.Type.SPOOKY,BiomeDictionary.Type.RARE);
        initBiome(GLACIER,"glacier", BiomeManager.BiomeType.ICY, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.RARE);
        initBiome(STEPPE,"steppe", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DRY , BiomeDictionary.Type.HOT,BiomeDictionary.Type.DEAD,BiomeDictionary.Type.SAVANNA);
        initBiome(EUCALYPTUS_FOREST,"eucalyptus_forest", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.WET,BiomeDictionary.Type.HOT,BiomeDictionary.Type.JUNGLE);
        initBiome(GRAND_CANYON,"grand_canyon", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.MESA,BiomeDictionary.Type.HOT,BiomeDictionary.Type.RIVER,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.HILLS);
        initBiome(OVERGROWN_MOUNTAINS,"overgrown_mountains", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.JUNGLE,BiomeDictionary.Type.HOT,BiomeDictionary.Type.HILLS,BiomeDictionary.Type.HOT);
        initBiome(JACARANDA_FOREST,"jacaranda_forest", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.RARE);
        initBiome(DECIDUOUS_FOREST,"deciduous_forest", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE);
        initBiome(DECIDUOUS_MOUNTAIN,"deciduous_mountain", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE,BiomeDictionary.Type.MOUNTAIN);
        initBiome(REDWOOD_FOREST,"redwood_forest", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE);
        initBiome(CEDAR_FOREST,"cedar_forest", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE);
        initBiome(GRASSLAND,"grassland", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.PLAINS);
        initBiome(LUPINE_FIELD,"lupine_field", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.PLAINS);
        initBiome(BLUE_FIELD,"blue_plains", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.RARE);
        initBiome(DENSE_FOREST,"dense_forest", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE);
        initBiome(DENSE_DARK_FOREST,"dark_dense_forest", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.HILLS,BiomeDictionary.Type.DENSE);
        initBiome(HORNBEAM_FOREST,"hornbeam_forest", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE);
        initBiome(MOOR,"peatlands", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.WET,BiomeDictionary.Type.LUSH);
        initBiome(RAINFOREST,"rainforest", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.WET,BiomeDictionary.Type.DENSE,BiomeDictionary.Type.JUNGLE,BiomeDictionary.Type.HILLS);
        initBiome(DUNES,"dunes", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.SANDY);
        initBiome(OUTBACK,"outback", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.DEAD);
        initBiome(SAVANNA_DESERT,"savanna_desert", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY , BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.SAVANNA);
        initBiome(SAVANNA_DESERT_HILLS,"savanna_desert_hills", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HILLS , BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.SAVANNA);
        initBiome(SAVANNA_EDGE,"savanna_desert_edge", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY , BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.SAVANNA);
        initBiome(SAVANNA_EDGE_HILLS,"savanna_desert_edge_hills", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HILLS , BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.SAVANNA);
        initBiome(RED_SAVANNA_DESERT,"red_savanna_desert", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY , BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.SAVANNA);
        initBiome(RED_SAVANNA_DESERT_HILLS,"red_savanna_desert_hills", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HILLS , BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.SAVANNA);
        initBiome(MIXED_SAVANNA_DESERT,"mixed_savanna_desert", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY , BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.SAVANNA);
        initBiome(MIXED_SAVANNA_DESERT_HILLS,"mixed_savanna_desert_hills", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY ,BiomeDictionary.Type.HILLS , BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.SAVANNA);
        initBiome(MIXED_DESERT,"mixed_desert", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY , BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY);
        initBiome(MIXED_DESERT_MOUNTAINS,"mixed_desert_mountains", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY , BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.MOUNTAIN);
        initBiome(DESERT_DESOLATION,"desert_desolation", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY , BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.DEAD);
        initBiome(LIGHT_MESA,"light_mesa", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.MESA,BiomeDictionary.Type.HOT,BiomeDictionary.Type.SANDY,BiomeDictionary.Type.HILLS,BiomeDictionary.Type.RARE);
        initBiome(TROPICAL_MESA,"tropical_mesa", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.JUNGLE , BiomeDictionary.Type.HOT,BiomeDictionary.Type.MESA);
        initBiome(TROPICAL_WATER_ROCKS,"tropical_water_rocks", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.WATER , BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.MOUNTAIN,BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.HILLS);
        initBiome(MARSH,"marsh", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DRY , BiomeDictionary.Type.WATER,BiomeDictionary.Type.WET);
        initBiome(LAND_OF_RIVERS,"land_of_rivers", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST , BiomeDictionary.Type.WATER,BiomeDictionary.Type.WET);
        initBiome(TROPICS,"tropics", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.BEACH , BiomeDictionary.Type.HOT,BiomeDictionary.Type.WET,BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.RARE);
        initBiome(SANDY_TROPICS,"sandy_tropics", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.BEACH , BiomeDictionary.Type.HOT,BiomeDictionary.Type.WET,BiomeDictionary.Type.JUNGLE,BiomeDictionary.Type.SANDY, BiomeDictionary.Type.RARE);
        initBiome(AUTUMNAL_FOREST,"autumnal_forest", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.COLD);
        initBiome(PRAIRIE,"prairie", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.PLAINS);
        initBiome(POLAR_PLATEAU,"polar_plateau", BiomeManager.BiomeType.ICY, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.SNOWY,BiomeDictionary.Type.DEAD);
        initBiome(VOLCANO,"volcano", BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.SPARSE);
        initBiome(AMAZONIA,"amazonia", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.WET,BiomeDictionary.Type.DENSE,BiomeDictionary.Type.JUNGLE,BiomeDictionary.Type.LUSH,BiomeDictionary.Type.HOT);
        initBiome(MAHOGANY_RAINFOREST,"mahogany_rainforest", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.WET,BiomeDictionary.Type.DENSE,BiomeDictionary.Type.JUNGLE,BiomeDictionary.Type.LUSH,BiomeDictionary.Type.HOT);
        initBiome(MAHOGANY_OVERGROWN_MOUNTAINS,"mahogany_mountains", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.WET,BiomeDictionary.Type.DENSE,BiomeDictionary.Type.JUNGLE,BiomeDictionary.Type.LUSH,BiomeDictionary.Type.HOT);
        initBiome(PRAIRIE_PLATEAU,"prairie_plateau", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS);
        initBiome(NATURAL_MAZE,"natural_maze", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.RARE, BiomeDictionary.Type.SPOOKY);
        initBiome(ROCKY_SPRUCE_FOREST,"rocky_spruce_forest", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.HILLS,BiomeDictionary.Type.FOREST,BiomeDictionary.Type.CONIFEROUS);
        initBiome(ROOFED_FOREST_HILLS,"roofed_forest_hills", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HILLS,BiomeDictionary.Type.FOREST,BiomeDictionary.Type.MOUNTAIN);
        initBiome(SEA_HIGHLANDS,"sea_highlands", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HILLS,BiomeDictionary.Type.PLAINS,BiomeDictionary.Type.MOUNTAIN,BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WATER);
        initBiome(BIRCH_GROVE,"birch_grove", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.DENSE);
        initBiome(MAPLE_TAIGA,"maple_taiga", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.COLD,BiomeDictionary.Type.CONIFEROUS);
        initBiome(MISTY_SWAMP,"misty_swamp", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.WET , BiomeDictionary.Type.SWAMP,BiomeDictionary.Type.LUSH);
        initBiome(TAIGA_PLATEAU,"taiga_plateau", BiomeManager.BiomeType.COOL, BiomeDictionary.Type.CONIFEROUS,BiomeDictionary.Type.FOREST, BiomeDictionary.Type.PLAINS);
        initBiome(ROCKY_MOUNTAINS,"rocky_mountains", BiomeManager.BiomeType.ICY, BiomeDictionary.Type.MOUNTAIN,BiomeDictionary.Type.HILLS, BiomeDictionary.Type.DEAD);
        initBiome(HIGH_PLAINS,"high_plains", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.MOUNTAIN);
        initBiome(FLOWER_FIELD,"flower_field", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.RARE);
        initBiome(PURPLE_FIELD,"purple_field", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.RARE);
        initBiome(FIELD_OF_CORN,"field_of_corn", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.RARE);
        initBiome(MASURIA,"masuria", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.WET,BiomeDictionary.Type.WATER,BiomeDictionary.Type.LUSH,BiomeDictionary.Type.HOT,BiomeDictionary.Type.RARE);
        initBiome(MADAGASCAR_PASTURE,"madagascar_pasture", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.PLAINS,BiomeDictionary.Type.WET,BiomeDictionary.Type.JUNGLE,BiomeDictionary.Type.LUSH,BiomeDictionary.Type.HOT,BiomeDictionary.Type.RARE);
        initBiome(MADAGASCAR_RAINFOREST,"madagascar_rainforest", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.WET,BiomeDictionary.Type.DENSE,BiomeDictionary.Type.JUNGLE,BiomeDictionary.Type.LUSH,BiomeDictionary.Type.HOT,BiomeDictionary.Type.RARE);
        initBiome(HIMALAYAS,"himalayas", BiomeManager.BiomeType.ICY, BiomeDictionary.Type.MOUNTAIN,BiomeDictionary.Type.HILLS, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SNOWY);
        //initBiome(TROPICAL_CAVERN,"tropical_cavern", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.BEACH , BiomeDictionary.Type.HOT,BiomeDictionary.Type.WET,BiomeDictionary.Type.JUNGLE,BiomeDictionary.Type.SANDY, BiomeDictionary.Type.RARE);



        setBiomeFog(Biomes.DESERT,0.01F,null);
        setBiomeFog(MISTY_MOUNTAINS,1F,null);
        setBiomeFog(MISTY_SWAMP,0.1F,null);





        System.out.println("Added " + biomes + " wildnature");
    }



    private static Biome initBiome(Biome biome, String name, BiomeManager.BiomeType biomeType, net.minecraftforge.common.BiomeDictionary.Type... types){
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome,types);
        ArrayList<net.minecraftforge.common.BiomeDictionary.Type> typeArrayList = new ArrayList<>(Arrays.asList(types));
        int weight = 10;
        if(typeArrayList.contains(BiomeDictionary.Type.RARE)){
            weight=5;
        }

        BiomeManager.addBiome(biomeType,new BiomeManager.BiomeEntry(biome,weight));
        BiomeManager.addSpawnBiome(biome);
        System.out.println("Biome Added: " + name + " with id: " + Biome.getIdForBiome(biome));
        biomes++;
        Main.biomeList.add(biome);
        return biome;
    }

    private static Biome removeBiome(Biome biome, String name, BiomeManager.BiomeType biomeType){
        BiomeManager.removeBiome(biomeType,new BiomeManager.BiomeEntry(biome,10));
        BiomeManager.removeSpawnBiome(biome);
        System.out.println("Biome Removed: " + name);
        return biome;
    }

    private static void setBiomeFog(Biome biome, float density, Color color){
        Main.fogBiomeList.add(new FogBiome(biome,density,color));
    }
}