package com.matez.wildnature.init;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.*;
import com.matez.wildnature.blocks.BlockMycelium;
import com.matez.wildnature.blocks.BlockSand;
import com.matez.wildnature.blocks.slabs.BlockSlabDoubleBase;
import com.matez.wildnature.blocks.slabs.BlockSlabHalfBase;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {


    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final List<Block> LOGS = new ArrayList<Block>();
    public static final List<Block> PLANKS = new ArrayList<Block>();
    public static final List<Block> PARQUETS = new ArrayList<Block>();
    public static final List<Block> STAIRS_PLANKS = new ArrayList<Block>();
    public static final List<Block> STAIRS_PARQUETS = new ArrayList<Block>();
    public static final List<Block> LEAVES = new ArrayList<Block>();
    public static final List<Block> SAPLINGS = new ArrayList<Block>();
    public static final List<Block> DIRTS = new ArrayList<Block>();
    public static final List<Block> SLABS = new ArrayList<Block>();
    public static final List<Block> ROCKS = new ArrayList<Block>();





    //
    public static final Block BEECH_LOG = new LogBase("beech_log", Material.WOOD);
    public static final Block BEECH_PARQUET = new BlockBase("beech_parquet", Material.WOOD,PARQUETS);
    public static final Block BEECH_PLANKS = new BlockBase("beech_planks", Material.WOOD,PLANKS);
    public static final Block BEECH_LEAVES = new LeavesBase("beech_leaves", Material.LEAVES);
    public static final Block BEECH_STAIRS_PLANKS = new StairsBase("beech_stairs_planks", Material.WOOD,BEECH_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block BEECH_STAIRS_PARQUET = new StairsBase("beech_stairs_parquet", Material.WOOD,BEECH_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block BEECH_SAPLING = new SaplingBase("beech_sapling", Material.GRASS);

    public static final Block BEECH_SLAB_DOUBLE = new BlockSlabDoubleBase("beech_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.BEECH_SLAB_HALF);
    public static final Block BEECH_SLAB_HALF = new BlockSlabHalfBase("beech_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.BEECH_SLAB_HALF,(BlockSlab)ModBlocks.BEECH_SLAB_DOUBLE);
    //
    public static final Block REDWOOD_LOG = new LogBase("redwood_log", Material.WOOD);
    public static final Block REDWOOD_PARQUET = new BlockBase("redwood_parquet", Material.WOOD,PARQUETS);
    public static final Block REDWOOD_PLANKS = new BlockBase("redwood_planks", Material.WOOD,PLANKS);
    public static final Block REDWOOD_LEAVES = new LeavesBase("redwood_leaves", Material.LEAVES);
    public static final Block REDWOOD_STAIRS_PLANKS = new StairsBase("redwood_stairs_planks", Material.WOOD,REDWOOD_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block REDWOOD_STAIRS_PARQUET = new StairsBase("redwood_stairs_parquet", Material.WOOD,REDWOOD_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block REDWOOD_SAPLING = new SaplingBase("redwood_sapling", Material.GRASS);

    public static final Block REDWOOD_SLAB_DOUBLE = new BlockSlabDoubleBase("redwood_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.REDWOOD_SLAB_HALF);
    public static final Block REDWOOD_SLAB_HALF = new BlockSlabHalfBase("redwood_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.REDWOOD_SLAB_HALF,(BlockSlab)ModBlocks.REDWOOD_SLAB_DOUBLE);
    //
    public static final Block EUCALYPTUS_LOG = new LogBase("eucalyptus_log", Material.WOOD);
    public static final Block EUCALYPTUS_PARQUET = new BlockBase("eucalyptus_parquet", Material.WOOD,PARQUETS);
    public static final Block EUCALYPTUS_PLANKS = new BlockBase("eucalyptus_planks", Material.WOOD,PLANKS);
    public static final Block EUCALYPTUS_LEAVES = new LeavesBase("eucalyptus_leaves", Material.LEAVES);
    public static final Block EUCALYPTUS_STAIRS_PLANKS = new StairsBase("eucalyptus_stairs_planks", Material.WOOD,EUCALYPTUS_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block EUCALYPTUS_STAIRS_PARQUET = new StairsBase("eucalyptus_stairs_parquet", Material.WOOD,EUCALYPTUS_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block EUCALYPTUS_SAPLING = new SaplingBase("eucalyptus_sapling", Material.GRASS);

    public static final Block EUCALYPTUS_SLAB_DOUBLE = new BlockSlabDoubleBase("eucalyptus_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.EUCALYPTUS_SLAB_HALF);
    public static final Block EUCALYPTUS_SLAB_HALF = new BlockSlabHalfBase("eucalyptus_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.EUCALYPTUS_SLAB_HALF,(BlockSlab)ModBlocks.EUCALYPTUS_SLAB_DOUBLE);
    //
    public static final Block HORNBEAM_LOG = new LogBase("hornbeam_log", Material.WOOD);
    public static final Block HORNBEAM_PARQUET = new BlockBase("hornbeam_parquet", Material.WOOD,PARQUETS);
    public static final Block HORNBEAM_PLANKS = new BlockBase("hornbeam_planks", Material.WOOD,PLANKS);
    public static final Block HORNBEAM_LEAVES = new LeavesBase("hornbeam_leaves", Material.LEAVES);
    public static final Block HORNBEAM_STAIRS_PLANKS = new StairsBase("hornbeam_stairs_planks", Material.WOOD,HORNBEAM_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block HORNBEAM_STAIRS_PARQUET = new StairsBase("hornbeam_stairs_parquet", Material.WOOD,HORNBEAM_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block HORNBEAM_SAPLING = new SaplingBase("hornbeam_sapling", Material.GRASS);

    public static final Block HORNBEAM_SLAB_DOUBLE = new BlockSlabDoubleBase("hornbeam_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.HORNBEAM_SLAB_HALF);
    public static final Block HORNBEAM_SLAB_HALF = new BlockSlabHalfBase("hornbeam_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.HORNBEAM_SLAB_HALF,(BlockSlab)ModBlocks.HORNBEAM_SLAB_DOUBLE);
    //
    public static final Block PEAR_LOG = new LogBase("pear_log", Material.WOOD);
    public static final Block PEAR_PARQUET= new BlockBase("pear_parquet", Material.WOOD,PARQUETS);
    public static final Block PEAR_PLANKS = new BlockBase("pear_planks", Material.WOOD,PLANKS);
    public static final Block PEAR_LEAVES = new LeavesPearBase("pear_leaves", Material.LEAVES);
    public static final Block PEAR_STAIRS_PLANKS = new StairsBase("pear_stairs_planks", Material.WOOD,PEAR_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block PEAR_STAIRS_PARQUET = new StairsBase("pear_stairs_parquet", Material.WOOD,PEAR_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block PEAR_SAPLING = new SaplingBase("pear_sapling", Material.GRASS);

    public static final Block PEAR_SLAB_DOUBLE = new BlockSlabDoubleBase("pear_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.PEAR_SLAB_HALF);
    public static final Block PEAR_SLAB_HALF = new BlockSlabHalfBase("pear_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.PEAR_SLAB_HALF,(BlockSlab)ModBlocks.PEAR_SLAB_DOUBLE);
    //
    public static final Block APPLE_LOG = new LogBase("apple_log", Material.WOOD);
    public static final Block APPLE_PARQUET = new BlockBase("apple_parquet", Material.WOOD,PARQUETS);
    public static final Block APPLE_PLANKS = new BlockBase("apple_planks", Material.WOOD,PLANKS);
    public static final Block APPLE_LEAVES = new LeavesAppleBase("apple_leaves", Material.LEAVES);
    public static final Block APPLE_STAIRS_PLANKS = new StairsBase("apple_stairs_planks", Material.WOOD,APPLE_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block APPLE_STAIRS_PARQUET = new StairsBase("apple_stairs_parquet", Material.WOOD,APPLE_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block APPLE_SAPLING = new SaplingBase("apple_sapling", Material.GRASS);

    public static final Block APPLE_SLAB_DOUBLE = new BlockSlabDoubleBase("apple_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.APPLE_SLAB_HALF);
    public static final Block APPLE_SLAB_HALF = new BlockSlabHalfBase("apple_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.APPLE_SLAB_HALF,(BlockSlab)ModBlocks.APPLE_SLAB_DOUBLE);
    //
    public static final Block JACARANDA_LOG = new LogBase("jacaranda_log", Material.WOOD);
    public static final Block JACARANDA_PARQUET = new BlockBase("jacaranda_parquet", Material.WOOD,PARQUETS);
    public static final Block JACARANDA_PLANKS = new BlockBase("jacaranda_planks", Material.WOOD,PLANKS);
    public static final Block JACARANDA_LEAVES = new LeavesJacarandaBase("jacaranda_leaves", Material.LEAVES);
    public static final Block JACARANDA_STAIRS_PLANKS = new StairsBase("jacaranda_stairs_planks", Material.WOOD,JACARANDA_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block JACARANDA_STAIRS_PARQUET = new StairsBase("jacaranda_stairs_parquet", Material.WOOD,JACARANDA_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block JACARANDA_SAPLING = new SaplingBase("jacaranda_sapling", Material.GRASS);

    public static final Block JACARANDA_SLAB_DOUBLE = new BlockSlabDoubleBase("jacaranda_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.JACARANDA_SLAB_HALF);
    public static final Block JACARANDA_SLAB_HALF = new BlockSlabHalfBase("jacaranda_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.JACARANDA_SLAB_HALF,(BlockSlab)ModBlocks.JACARANDA_SLAB_DOUBLE);
    //
    public static final Block ROWAN_LOG = new LogBase("rowan_log", Material.WOOD);
    public static final Block ROWAN_PARQUET = new BlockBase("rowan_parquet", Material.WOOD,PARQUETS);
    public static final Block ROWAN_PLANKS = new BlockBase("rowan_planks", Material.WOOD,PLANKS);
    public static final Block ROWAN_LEAVES = new LeavesRowanBase("rowan_leaves", Material.LEAVES);
    public static final Block ROWAN_STAIRS_PLANKS = new StairsBase("rowan_stairs_planks", Material.WOOD,ROWAN_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block ROWAN_STAIRS_PARQUET = new StairsBase("rowan_stairs_parquet", Material.WOOD,ROWAN_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block ROWAN_SAPLING = new SaplingBase("rowan_sapling", Material.GRASS);

    public static final Block ROWAN_SLAB_DOUBLE = new BlockSlabDoubleBase("rowan_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.ROWAN_SLAB_HALF);
    public static final Block ROWAN_SLAB_HALF = new BlockSlabHalfBase("rowan_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.ROWAN_SLAB_HALF,(BlockSlab)ModBlocks.ROWAN_SLAB_DOUBLE);
    //
    public static final Block FIR_LOG = new LogBase("fir_log", Material.WOOD);
    public static final Block FIR_PARQUET = new BlockBase("fir_parquet", Material.WOOD,PARQUETS);
    public static final Block FIR_PLANKS = new BlockBase("fir_planks", Material.WOOD,PLANKS);
    public static final Block FIR_LEAVES = new LeavesFirBase("fir_leaves", Material.LEAVES);
    public static final Block FIR_STAIRS_PLANKS = new StairsBase("fir_stairs_planks", Material.WOOD,FIR_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block FIR_STAIRS_PARQUET = new StairsBase("fir_stairs_parquet", Material.WOOD,FIR_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block FIR_SAPLING = new SaplingBase("fir_sapling", Material.GRASS);

    public static final Block FIR_SLAB_DOUBLE = new BlockSlabDoubleBase("fir_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.FIR_SLAB_HALF);
    public static final Block FIR_SLAB_HALF = new BlockSlabHalfBase("fir_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.FIR_SLAB_HALF,(BlockSlab)ModBlocks.FIR_SLAB_DOUBLE);
    //
    public static final Block HAZEL_LOG = new LogBase("hazel_log", Material.WOOD);
    public static final Block HAZEL_PARQUET = new BlockBase("hazel_parquet", Material.WOOD,PARQUETS);
    public static final Block HAZEL_PLANKS = new BlockBase("hazel_planks", Material.WOOD,PLANKS);
    public static final Block HAZEL_LEAVES = new LeavesHazelBase("hazel_leaves", Material.LEAVES);
    public static final Block HAZEL_STAIRS_PLANKS = new StairsBase("hazel_stairs_planks", Material.WOOD,HAZEL_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block HAZEL_STAIRS_PARQUET = new StairsBase("hazel_stairs_parquet", Material.WOOD,HAZEL_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block HAZEL_SAPLING = new SaplingBase("hazel_sapling", Material.GRASS);

    public static final Block HAZEL_SLAB_DOUBLE = new BlockSlabDoubleBase("hazel_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.HAZEL_SLAB_HALF);
    public static final Block HAZEL_SLAB_HALF = new BlockSlabHalfBase("hazel_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.HAZEL_SLAB_HALF,(BlockSlab)ModBlocks.HAZEL_SLAB_DOUBLE);
    //
    public static final Block CHERRY_LOG = new LogBase("cherry_log", Material.WOOD);
    public static final Block CHERRY_PARQUET = new BlockBase("cherry_parquet", Material.WOOD,PARQUETS);
    public static final Block CHERRY_PLANKS = new BlockBase("cherry_planks", Material.WOOD,PLANKS);
    public static final Block CHERRY_PINK_LEAVES = new LeavesCherryPinkBase("cherry_pink_leaves", Material.LEAVES);
    public static final Block CHERRY_WHITE_LEAVES = new LeavesCherryWhiteBase("cherry_white_leaves", Material.LEAVES);
    public static final Block CHERRY_STAIRS_PLANKS = new StairsBase("cherry_stairs_planks", Material.WOOD,CHERRY_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block CHERRY_STAIRS_PARQUET = new StairsBase("cherry_stairs_parquet", Material.WOOD,CHERRY_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block CHERRY_PINK_SAPLING = new SaplingBase("cherry_pink_sapling", Material.GRASS);
    public static final Block CHERRY_WHITE_SAPLING = new SaplingBase("cherry_white_sapling", Material.GRASS);

    public static final Block CHERRY_SLAB_DOUBLE = new BlockSlabDoubleBase("cherry_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.CHERRY_SLAB_HALF);
    public static final Block CHERRY_SLAB_HALF = new BlockSlabHalfBase("cherry_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.CHERRY_SLAB_HALF,(BlockSlab)ModBlocks.CHERRY_SLAB_DOUBLE);
    //
    public static final Block BAOBAB_LOG = new LogBase("baobab_log", Material.WOOD);
    public static final Block BAOBAB_PARQUET = new BlockBase("baobab_parquet", Material.WOOD,PARQUETS);
    public static final Block BAOBAB_PLANKS = new BlockBase("baobab_planks", Material.WOOD,PLANKS);
    public static final Block BAOBAB_LEAVES = new LeavesBase("baobab_leaves", Material.LEAVES);
    public static final Block BAOBAB_STAIRS_PLANKS = new StairsBase("baobab_stairs_planks", Material.WOOD,BAOBAB_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block BAOBAB_STAIRS_PARQUET = new StairsBase("baobab_stairs_parquet", Material.WOOD,BAOBAB_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block BAOBAB_SAPLING = new SaplingBase("baobab_sapling", Material.GRASS);

    public static final Block BAOBAB_SLAB_DOUBLE = new BlockSlabDoubleBase("baobab_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.BAOBAB_SLAB_HALF);
    public static final Block BAOBAB_SLAB_HALF = new BlockSlabHalfBase("baobab_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.BAOBAB_SLAB_HALF,(BlockSlab)ModBlocks.BAOBAB_SLAB_DOUBLE);
    //
    public static final Block EBONY_LOG = new LogBase("ebony_log", Material.WOOD);
    public static final Block EBONY_PARQUET = new BlockBase("ebony_parquet", Material.WOOD,PARQUETS);
    public static final Block EBONY_PLANKS = new BlockBase("ebony_planks", Material.WOOD,PLANKS);
    public static final Block EBONY_LEAVES = new LeavesBase("ebony_leaves", Material.LEAVES);
    public static final Block EBONY_STAIRS_PLANKS = new StairsBase("ebony_stairs_planks", Material.WOOD,EBONY_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block EBONY_STAIRS_PARQUET = new StairsBase("ebony_stairs_parquet", Material.WOOD,EBONY_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block EBONY_SAPLING = new SaplingBase("ebony_sapling", Material.GRASS);

    public static final Block EBONY_SLAB_DOUBLE = new BlockSlabDoubleBase("ebony_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.EBONY_SLAB_HALF);
    public static final Block EBONY_SLAB_HALF = new BlockSlabHalfBase("ebony_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.EBONY_SLAB_HALF,(BlockSlab)ModBlocks.EBONY_SLAB_DOUBLE);
    //
    public static final Block PINE_LOG = new LogBase("pine_log", Material.WOOD);
    public static final Block PINE_PARQUET = new BlockBase("pine_parquet", Material.WOOD,PARQUETS);
    public static final Block PINE_PLANKS = new BlockBase("pine_planks", Material.WOOD,PLANKS);
    public static final Block PINE_LEAVES = new LeavesPineBase("pine_leaves", Material.LEAVES);
    public static final Block PINE_STAIRS_PLANKS = new StairsBase("pine_stairs_planks", Material.WOOD,PINE_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block PINE_STAIRS_PARQUET = new StairsBase("pine_stairs_parquet", Material.WOOD,PINE_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block PINE_SAPLING = new SaplingBase("pine_sapling", Material.GRASS);

    public static final Block PINE_SLAB_DOUBLE = new BlockSlabDoubleBase("pine_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.PINE_SLAB_HALF);
    public static final Block PINE_SLAB_HALF = new BlockSlabHalfBase("pine_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.PINE_SLAB_HALF,(BlockSlab)ModBlocks.PINE_SLAB_DOUBLE);
    //
    public static final Block PALM_LOG = new LogBase("palm_log", Material.WOOD);
    public static final Block PALM_PARQUET = new BlockBase("palm_parquet", Material.WOOD,PARQUETS);
    public static final Block PALM_PLANKS = new BlockBase("palm_planks", Material.WOOD,PLANKS);
    public static final Block PALM_LEAVES = new LeavesBase("palm_leaves", Material.LEAVES);
    public static final Block PALM_STAIRS_PLANKS = new StairsBase("palm_stairs_planks", Material.WOOD,PALM_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block PALM_STAIRS_PARQUET = new StairsBase("palm_stairs_parquet", Material.WOOD,PALM_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block PALM_SAPLING = new SaplingBase("palm_sapling", Material.GRASS);

    public static final Block PALM_SLAB_DOUBLE = new BlockSlabDoubleBase("palm_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.PALM_SLAB_HALF);
    public static final Block PALM_SLAB_HALF = new BlockSlabHalfBase("palm_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.PALM_SLAB_HALF,(BlockSlab)ModBlocks.PALM_SLAB_DOUBLE);
    //
    public static final Block MAHOGANY_LOG = new LogBase("mahogany_log", Material.WOOD);
    public static final Block MAHOGANY_PARQUET = new BlockBase("mahogany_parquet", Material.WOOD,PARQUETS);
    public static final Block MAHOGANY_PLANKS = new BlockBase("mahogany_planks", Material.WOOD,PLANKS);
    public static final Block MAHOGANY_LEAVES = new LeavesBase("mahogany_leaves", Material.LEAVES);
    public static final Block MAHOGANY_STAIRS_PLANKS = new StairsBase("mahogany_stairs_planks", Material.WOOD,MAHOGANY_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block MAHOGANY_STAIRS_PARQUET = new StairsBase("mahogany_stairs_parquet", Material.WOOD,MAHOGANY_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block MAHOGANY_SAPLING = new SaplingBase("mahogany_sapling", Material.GRASS);

    public static final Block MAHOGANY_SLAB_DOUBLE = new BlockSlabDoubleBase("mahogany_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.MAHOGANY_SLAB_HALF);
    public static final Block MAHOGANY_SLAB_HALF = new BlockSlabHalfBase("mahogany_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.MAHOGANY_SLAB_HALF,(BlockSlab)ModBlocks.MAHOGANY_SLAB_DOUBLE);
    //
    public static final Block CEDAR_LOG = new LogBase("cedar_log", Material.WOOD);
    public static final Block CEDAR_PARQUET = new BlockBase("cedar_parquet", Material.WOOD,PARQUETS);
    public static final Block CEDAR_PLANKS = new BlockBase("cedar_planks", Material.WOOD,PLANKS);
    public static final Block CEDAR_LEAVES = new LeavesBase("cedar_leaves", Material.LEAVES);
    public static final Block CEDAR_STAIRS_PLANKS = new StairsBase("cedar_stairs_planks", Material.WOOD,BEECH_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block CEDAR_STAIRS_PARQUET = new StairsBase("cedar_stairs_parquet", Material.WOOD,BEECH_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block CEDAR_SAPLING = new SaplingBase("cedar_sapling", Material.GRASS);

    public static final Block CEDAR_SLAB_DOUBLE = new BlockSlabDoubleBase("cedar_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.CEDAR_SLAB_HALF);
    public static final Block CEDAR_SLAB_HALF = new BlockSlabHalfBase("cedar_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.CEDAR_SLAB_HALF,(BlockSlab)ModBlocks.CEDAR_SLAB_DOUBLE);
    //
    public static final Block WILLOW_LOG = new LogBase("willow_log", Material.WOOD);
    public static final Block WILLOW_PARQUET = new BlockBase("willow_parquet", Material.WOOD,PARQUETS);
    public static final Block WILLOW_PLANKS = new BlockBase("willow_planks", Material.WOOD,PLANKS);
    public static final Block WILLOW_LEAVES = new LeavesBase("willow_leaves", Material.LEAVES);
    public static final Block WILLOW_STAIRS_PLANKS = new StairsBase("willow_stairs_planks", Material.WOOD,BEECH_PLANKS.getDefaultState(),STAIRS_PLANKS);
    public static final Block WILLOW_STAIRS_PARQUET = new StairsBase("willow_stairs_parquet", Material.WOOD,BEECH_PARQUET.getDefaultState(),STAIRS_PARQUETS);
    public static final Block WILLOW_SAPLING = new SaplingBase("willow_sapling", Material.GRASS);

    public static final Block WILLOW_SLAB_DOUBLE = new BlockSlabDoubleBase("willow_slab_double", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.WILLOW_SLAB_HALF);
    public static final Block WILLOW_SLAB_HALF = new BlockSlabHalfBase("willow_slab_half", Material.WOOD,Main.mbtab,(BlockSlab)ModBlocks.WILLOW_SLAB_HALF,(BlockSlab)ModBlocks.WILLOW_SLAB_DOUBLE);
    //
    public static final Block RED_AUTUMN = new LeavesBase("red_autumn_leaves", Material.LEAVES);
    public static final Block ORANGE_AUTUMN = new LeavesBase("orange_autumn_leaves", Material.LEAVES);
    public static final Block YELLOW_AUTUMN = new LeavesBase("yellow_autumn_leaves", Material.LEAVES);
    //
    public static final Block ROTTEN_LEAVES = new LeavesBase("rotten_leaves", Material.LEAVES);
    public static final Block ROTTEN_LOG = new LogBase("rotten_log", Material.WOOD);
    public static final Block DEAD_LOG = new LogBase("dead_log", Material.WOOD);

    ////////////////////


    public static final Block MALA_TRAWA = new SimpleFlowerBase("small_grass", Material.GRASS);
    public static final Block DEAD_SHORT_GRASS = new SimpleDesertBushBase("dead_short_grass");
    public static final Block DESERT_GRASS = new SimpleDesertBushBase("desert_grass");
    public static final Block TALLGRASS_WHEAT = new FloweringTallGrass("tallgrass_wheat");
    public static final Block TALLGRASS_THISTLE = new FloweringTallGrass("tallgrass_thistle");
    public static final Block TALLGRASS_FLOWER = new FloweringTallGrass("tallgrass_flower");
    public static final Block TALLGRASS_FERNSPROUT = new SimpleFlowerBase("tallgrass_fernsprout",Material.GRASS);
    public static final Block WILD_WHEAT = new FloweringTallGrass("wild_wheat");
    public static final Block LEAF_PILE = new SimpleFlowerBase("leaf_pile",Material.GRASS);
    public static final Block DEAD_LEAF_PILE = new SimpleFlowerBase("dead_leaf_pile",Material.GRASS);
    public static final Block CORN_BUSH = new CornBush("corn_bush");

    public static final Block JACARANDA_KWIAT = new SimpleFlowerBase("jacaranda_flower", Material.GRASS);
    public static final Block CHERRY_KWIAT = new SimpleFlowerBase("cherry_flower", Material.GRASS);
    public static final Block STOKROTKA = new SimpleFlowerBase("daisy", Material.GRASS);
    public static final Block CLOVER = new SimpleFlowerBase("clover", Material.GRASS);

    public static final Block SREDNIA_TRAWA = new SimpleFlowerBase("medium_grass", Material.GRASS);
    public static final Block DZWONECZEK = new SimpleFlowerBase("bluebell", Material.GRASS);
    public static final Block SASANKA = new SimpleFlowerBase("pulsatilla", Material.GRASS);
    public static final Block WRZOS = new FloweringTallGrass("heather_purple");
    public static final Block WRZOS_PINK = new FloweringTallGrass("heather_pink");
    public static final Block WRZOS_WHITE = new FloweringTallGrass("heather_white");

    public static final Block LUPINE_VIOLET = new FloweringTallGrass("lupine_violet");
    public static final Block LUPINE_BLUE = new FloweringTallGrass("lupine_blue");
    public static final Block LUPINE_RED = new FloweringTallGrass("lupine_red");
    public static final Block LUPINE_PINK = new FloweringTallGrass("lupine_pink");
    public static final Block LUPINE_YELLOW = new FloweringTallGrass("lupine_yellow");

    public static final Block IRIS_VIOLET = new FloweringTallGrass("iris_violet");
    public static final Block IRIS_PURPLE = new FloweringTallGrass("iris_purple");

    public static final Block FORGET_ME_NOT_BLUE = new FloweringTallGrass("forget_me_not_blue");
    public static final Block FORGET_ME_NOT_PINK = new FloweringTallGrass("forget_me_not_pink");


    ////////////////////

    public static final Block BROWN_GRASS_BLOCK = new GrassBase("brown_grass_block", Material.GRASS);
    public static final Block MOLD_GRASS_BLOCK = new GrassBase("mold_grass_block", Material.GRASS);
    public static final Block DESERT_GRASS_BLOCK = new GrassBase("desert_grass_block", Material.GRASS);
    public static final Block DRIED_GRASS_BLOCK = new GrassBase("dried_grass_block", Material.GRASS);
    public static final Block ZAROSNIETY_KAMIEN = new GrassBase("overgrown_stone", Material.GRASS);
    public static final Block ZIEMA_BRUNATNA = new DirtBase("browndirt");
    public static final Block ZIEMA_CZARNOZIEM = new DirtBase("molddirt");
    public static final Block ZIEMA_PUSTYNNA = new DirtBase("desertdirt");
    public static final Block ZIEMA_SUCHA = new DirtBase("drieddirt");
    public static final Block FROZEN_DIRT = new DirtBase("frozen_dirt");
    public static final Block BROWN_PODZOL = new BlockPodzol("brown_podzol");
    public static final Block MOLD_PODZOL = new BlockPodzol("mold_podzol");
    public static final Block BROWN_MYCELIUM = new BlockMycelium("brown_mycelium");
    public static final Block MOLD_MYCELIUM = new BlockMycelium("mold_mycelium");
    public static final Block MUD = new BlockMud("mud",Material.GROUND);
    ////////////////////

    public static final Block DRIED_SAND = new BlockBase("dried_sand",Material.ROCK);
    public static final Block ASH_BLOCK = new BlockBase("ash_block",Material.ROCK);
    public static final Block WHITE_SAND = new BlockSand("white_sand",0xF4FFB9);
    public static final Block ASH = new BlockSand("ash",0x1F2318);

    //0 - skały typu kamień(normalne) (0-255)
    //1 - skały osadowe (55-255)
    //2 - skały metamorficzne (30-55)
    //3 - skały magmowe (5-30)

    public static final Block DARK_STONE = new RockBase("darkstone",Material.ROCK,Main.wnTabUnderground,0);
    public static final Block HARDENED_SANDSTONE = new RockBase("hardened_sandstone",Material.ROCK,Main.wnTabUnderground,0, Item.getItemFromBlock(Blocks.SANDSTONE));
    public static final Block RED_HARDENED_SANDSTONE = new RockBase("red_hardened_sandstone",Material.ROCK,Main.wnTabUnderground,0, Item.getItemFromBlock(Blocks.RED_SANDSTONE));
    public static final Block FROZEN_STONE = new RockBase("frozen_stone",Material.ROCK,Main.wnTabUnderground,0, Item.getItemFromBlock(ModBlocks.FROZEN_COBBLESTONE));



    public static final Block BASALT = new RockBase("basalt",Material.ROCK,Main.wnTabUnderground,3);
    public static final Block CARBONATITE = new RockBase("carbonatite",Material.ROCK,Main.wnTabUnderground,3);
    public static final Block CHALK = new RockBase("chalk",Material.ROCK,Main.wnTabUnderground,2);
    public static final Block CONGLOMERATE = new RockBase("conglomerate",Material.ROCK,Main.wnTabUnderground,2);
    public static final Block DOLOMITE = new RockBase("dolomite",Material.ROCK,Main.wnTabUnderground,2);
    public static final Block EPIDOSITE = new RockBase("epidosite",Material.ROCK,Main.wnTabUnderground,1);
    public static final Block GABBRO = new RockBase("gabbro",Material.ROCK,Main.wnTabUnderground,3);
    public static final Block GNEISS = new RockBase("gneiss",Material.ROCK,Main.wnTabUnderground,1);
    public static final Block GYPSUM = new RockBase("gypsum",Material.ROCK,Main.wnTabUnderground,2);
    public static final Block LIMESTONE = new RockBase("limestone",Material.ROCK,Main.wnTabUnderground,2);
    public static final Block MARBLE = new RockBase("marble",Material.ROCK,Main.wnTabUnderground,1);
    public static final Block MONZONITE = new RockBase("monzonite",Material.ROCK,Main.wnTabUnderground,3);
    public static final Block PEGMATITE = new RockBase("pegmatite",Material.ROCK,Main.wnTabUnderground,3);
    public static final Block PHYLLITE = new RockBase("phyllite",Material.ROCK,Main.wnTabUnderground,1);
    public static final Block PUMICE = new RockBase("pumice",Material.ROCK,Main.wnTabUnderground,3);
    public static final Block PYROXENITE = new RockBase("pyroxenite",Material.ROCK,Main.wnTabUnderground,3);
    public static final Block RHYOLITE = new RockBase("rhyolite",Material.ROCK,Main.wnTabUnderground,3);
    public static final Block SLATE = new RockBase("slate",Material.ROCK,Main.wnTabUnderground,1);
    public static final Block SYENITE = new RockBase("syenite",Material.ROCK,Main.wnTabUnderground,1);
    public static final Block UMBER = new RockBase("umber",Material.ROCK,Main.wnTabUnderground,2);




    ////////////////////

    public static final Block FROZEN_COBBLESTONE = new BlockBase("frozen_cobblestone",Material.ROCK,Main.wnTabUnderground);


    ////////////////////

    public static final Block AMETHYST_BLOCK = new BlockBase("amethyst_block",Material.IRON,Main.wnTabUnderground);
    public static final Block AMETHYST_ORE = new OreBase("amethyst_ore",Material.ROCK);
    public static final Block AMBER_BLOCK = new BlockBaseTransparent("amber_block",Material.IRON,Main.wnTabUnderground);
    public static final Block AMBER_ORE = new OreSandBase("amber_ore",0xDECDA1);
    public static final Block RUBY_BLOCK = new BlockBase("ruby_block",Material.IRON,Main.wnTabUnderground);
    public static final Block RUBY_ORE = new OreBase("ruby_ore",Material.ROCK);
    public static final Block SILVER_BLOCK = new BlockBase("silver_block",Material.IRON,Main.wnTabUnderground);
    public static final Block SILVER_ORE = new OreBase("silver_ore",Material.ROCK);
    public static final Block MALACHITE_BLOCK = new BlockBase("malachite_block",Material.IRON,Main.wnTabUnderground);
    public static final Block MALACHITE_ORE = new OreBase("malachite_ore",Material.ROCK);
    public static final Block SAPPHIRE_BLOCK = new BlockBase("sapphire_block",Material.IRON,Main.wnTabUnderground);
    public static final Block SAPPHIRE_ORE = new OreBase("sapphire_ore",Material.ROCK);
    public static final Block STEEL_BLOCK = new BlockBase("steel_block",Material.IRON,Main.wnTabUnderground);



    ////////////////////

    public static final Block BOROWIK_SZLACHETNY = new BlockMushroomBase("mushroom_1");
    public static final Block BOROWIK_WYSMUKLY = new BlockMushroomBase("mushroom_8");
    public static final Block KOZLARZ_CZERWONY = new BlockMushroomBase("mushroom_7");
    public static final Block MASLAK_ZWYCZAJNY = new BlockMushroomBase("mushroom_2");
    public static final Block MLECZAJ_RYDZ = new BlockMushroomBase("mushroom_6");
    public static final Block MUCHOMOR_JADOWITY = new BlockMushroomBase("mushroom_5");
    public static final Block MUCHOMOR_SROMOTNIKOWY = new BlockMushroomBase("mushroom_4");
    public static final Block PIECZARKA = new BlockMushroomBase("mushroom_3");
    public static final Block PIEPRZNIK_JADALNY = new BlockMushroomBase("mushroom_9");

    public static final Block IRONWORKS = new BlockIronworks("ironworks");
    public static final Block STEEL_LADDER = new LadderBase("steel_ladder");


    //////////////////// FLUIDS
    public static final Block NEW_WATER = new BlockFluid("mb_water",FluidInit.NEW_WATER,Material.WATER);


    public ModBlocks(){
        LEAVES.remove(ROTTEN_LEAVES);
        LOGS.remove(ROTTEN_LOG);
        LOGS.remove(DEAD_LOG);
        //Block block = Block.REGISTRY.getObject(new ResourceLocation("leaves"));


    }





}