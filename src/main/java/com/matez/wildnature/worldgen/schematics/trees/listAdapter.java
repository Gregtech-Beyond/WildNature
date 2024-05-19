package com.matez.wildnature.worldgen.schematics.trees;


import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.worldgen.WorldGenFromFile;
import com.matez.wildnature.worldgen.schematics.other.shrubs.otherGen_shrub1;
import com.matez.wildnature.worldgen.schematics.trees.hornbeam.treeGen_hornbeam1;
import com.matez.wildnature.worldgen.schematics.trees.oak.*;
import com.matez.wildnature.worldgen.schematics.trees.pine.*;
import com.matez.wildnature.worldgen.schematics.trees.willow.*;
import com.matez.wildnature.worldgen.schematics.trees.hornbeam.*;
import com.matez.wildnature.worldgen.schematics.trees.spruce.*;
import com.matez.wildnature.worldgen.schematics.trees.fir.*;
import com.matez.wildnature.worldgen.schematics.trees.palm.*;
import com.matez.wildnature.worldgen.schematics.trees.birch.*;
import com.matez.wildnature.worldgen.schematics.trees.big.*;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class listAdapter {
    public IBlockState LOG = Blocks.LOG.getDefaultState();
    public IBlockState LEAVES = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

    public IBlockState LOG_BIRCH = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
    public IBlockState LEAVES_BIRCH = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH);

    public IBlockState LOG_SPRUCE = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
    public IBlockState LEAVES_SPRUCE = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false)).withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE);

    public IBlockState LOG_HORNBEAM = ModBlocks.HORNBEAM_LOG.getDefaultState();
    public IBlockState LEAVES_HORNBEAM = ModBlocks.HORNBEAM_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

    public IBlockState LOG_PALM = Blocks.LOG.getDefaultState();
    public IBlockState LEAVES_PALM = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

    public IBlockState LOG_BAOBAB = ModBlocks.BAOBAB_LOG.getDefaultState();
    public IBlockState LEAVES_BAOBAB = ModBlocks.BAOBAB_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

    public IBlockState LOG_FIR = ModBlocks.FIR_LOG.getDefaultState();
    public IBlockState LEAVES_FIR = ModBlocks.FIR_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));

    public IBlockState LOG_PINE = ModBlocks.PINE_LOG.getDefaultState();
    public IBlockState LEAVES_PINE = ModBlocks.PINE_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(false));
    public listAdapter(){

        Main.generatorList.add(new treeGen_oak1(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak2(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak3(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak4(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak5(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak6(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak7(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak8(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak9(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak10(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak11(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak12(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak13(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak14(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak15(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak16(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak17(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak18(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak19(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak20(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak21(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak22(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak23(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak24(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak25(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak26(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak27(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak28(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak29(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak30(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak31(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_oak32(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow1(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow2(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow3(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow4(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow5(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow6(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow7(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow8(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow9(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow10(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow11(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow12(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow13(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow14(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow15(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow16(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow17(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow18(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow19(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow20(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_willow21(true,LOG,LEAVES));
        Main.generatorList.add(new treeGen_hornbeam1(true,LOG_HORNBEAM,LEAVES_HORNBEAM));
        Main.generatorList.add(new treeGen_hornbeam2(true,LOG_HORNBEAM,LEAVES_HORNBEAM));
        Main.generatorList.add(new treeGen_hornbeam3(true,LOG_HORNBEAM,LEAVES_HORNBEAM));
        Main.generatorList.add(new treeGen_hornbeam4(true,LOG_HORNBEAM,LEAVES_HORNBEAM));
        Main.generatorList.add(new treeGen_hornbeam5(true,LOG_HORNBEAM,LEAVES_HORNBEAM));
        Main.generatorList.add(new treeGen_hornbeam6(true,LOG_HORNBEAM,LEAVES_HORNBEAM));
        Main.generatorList.add(new treeGen_hornbeam7(true,LOG_HORNBEAM,LEAVES_HORNBEAM));
        Main.generatorList.add(new treeGen_palm1(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm2(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm3(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm4(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm5(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm6(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm7(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm8(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm9(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm10(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm11(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm12(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm13(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm14(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm15(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm16(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_palm17(true,LOG_PALM,LEAVES_PALM));
        Main.generatorList.add(new treeGen_birch1(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_birch2(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_birch3(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_birch4(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_birch5(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_birch6(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_birch7(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_birch8(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_birch9(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_birch10(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_birch11(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_birch12(true,LOG_BIRCH,LEAVES_BIRCH));
        Main.generatorList.add(new treeGen_fir1(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir2(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir3(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir4(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir5(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir6(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir7(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir8(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir9(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir10(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir11(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir12(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir13(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir14(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir15(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir16(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir17(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir18(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir19(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir20(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir21(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir22(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir23(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir24(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir25(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir26(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir27(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir28(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir29(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir30(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir31(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_fir32(true,LOG_FIR,LEAVES_FIR));
        Main.generatorList.add(new treeGen_taiga1(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga2(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga3(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga4(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga5(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga6(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga7(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga8(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga9(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga10(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga11(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga12(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga13(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga14(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga15(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga16(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga17(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga18(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga19(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga20(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga21(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga22(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga23(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga24(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_taiga25(true,LOG_SPRUCE,LEAVES_SPRUCE));
        Main.generatorList.add(new treeGen_pine1(true,LOG_PINE,LEAVES_PINE));
        Main.generatorList.add(new treeGen_pine2(true,LOG_PINE,LEAVES_PINE));
        Main.generatorList.add(new treeGen_pine3(true,LOG_PINE,LEAVES_PINE));
        Main.generatorList.add(new treeGen_pine4(true,LOG_PINE,LEAVES_PINE));
        Main.generatorList.add(new treeGen_pine5(true,LOG_PINE,LEAVES_PINE));
        Main.generatorList.add(new treeGen_pine6(true,LOG_PINE,LEAVES_PINE));
        Main.generatorList.add(new otherGen_shrub1(true,LOG,LEAVES));
        Main.generatorList.add(new WorldGenFromFile(true,LOG_BAOBAB,LEAVES_BAOBAB,"baobab.txt"));



    }

    public static ArrayList<Class<?>> getClasses(File jarFile, String packageName) {
        ArrayList<Class<?>> classes = new ArrayList<>();
        try {
            JarFile file = new JarFile(jarFile);
            for (Enumeration<JarEntry> entry = file.entries(); entry.hasMoreElements();) {
                JarEntry jarEntry = entry.nextElement();
                String name = jarEntry.getName().replace("/", ".");
                if(name.startsWith(packageName) && name.endsWith(".class"))
                    classes.add(Class.forName(name.substring(0, name.length() - 6)));
            }
            file.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    public static File getJarFile(){
        try {
            return new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        } catch (Exception e) {
        }
        return null;
    }


}