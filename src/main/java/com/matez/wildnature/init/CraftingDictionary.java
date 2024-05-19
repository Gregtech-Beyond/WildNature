package com.matez.wildnature.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

import static com.matez.wildnature.init.ModBlocks.*;

public class CraftingDictionary {

    public CraftingDictionary(){

    }

    public void registerAll(){
        regByListB("logWood",LOGS);
        regByListB("plankWood",PLANKS);
        regByListB("parquetWood",PARQUETS);
        regByListB("stairWood",STAIRS_PLANKS);
        regByListB("stairParquet",STAIRS_PARQUETS);
        regByListB("treeLeaves",LEAVES);
        regByListB("treeSapling",SAPLINGS);
        regByListB("dirt",DIRTS);
        reg("sand", WHITE_SAND);
        reg("Sand", WHITE_SAND);
        reg("blockSand", WHITE_SAND);
        reg("IngotSilver",ModItems.SILVER_INGOT);
        reg("IngotSteel",ModItems.STEEL_INGOT);
        reg("IngotAmethyst",ModItems.AMETHYST_ITEM);
        reg("IngotAmber",ModItems.AMBER_ITEM);
        reg("IngotSapphire",ModItems.SAPPHIRE_ITEM);
        reg("IngotMalachite",ModItems.MALACHITE_ITEM);
        reg("IngotRuby",ModItems.RUBY_ITEM);
        reg("BlockSilver", SILVER_BLOCK);
        reg("BlockSteel",STEEL_BLOCK);
        reg("BlockAmethyst",AMETHYST_BLOCK);
        reg("BlockAmber",AMBER_BLOCK);
        reg("BlockSapphire",SAPPHIRE_BLOCK);
        reg("BlockMalachite",MALACHITE_BLOCK);
        reg("BlockRuby",RUBY_BLOCK);
        reg("ingotSilver",ModItems.SILVER_INGOT);
        reg("ingotSteel",ModItems.STEEL_INGOT);
        reg("ingotAmethyst",ModItems.AMETHYST_ITEM);
        reg("ingotAmber",ModItems.AMBER_ITEM);
        reg("ingotSapphire",ModItems.SAPPHIRE_ITEM);
        reg("ingotMalachite",ModItems.MALACHITE_ITEM);
        reg("ingotRuby",ModItems.RUBY_ITEM);
        reg("blockSilver", SILVER_BLOCK);
        reg("blockSteel",STEEL_BLOCK);
        reg("blockAmethyst",AMETHYST_BLOCK);
        reg("blockAmber",AMBER_BLOCK);
        reg("blockSapphire",SAPPHIRE_BLOCK);
        reg("blockMalachite",MALACHITE_BLOCK);
        reg("blockRuby",RUBY_BLOCK);
        regByListB("stone",ROCKS);
        regByListB("Stone",ROCKS);
        regByListB("blockStone",ROCKS);
        regByListB("rock",ROCKS);
        regByListB("rocks",ROCKS);

    }

    private void regByListB(String name, List<Block> blocks){
        int x = 0;
        while(x<blocks.size()){
            reg(name,blocks.get(x));
            x++;
        }
    }
    private void regByListI(String name, List<Item> items){
        int x = 0;
        while(x<items.size()){
            reg(name,items.get(x));
        }
    }
    private void regByListIS(String name, List<ItemStack> items){
        int x = 0;
        while(x<items.size()){
            reg(name,items.get(x));
        }
    }

    private void reg(String name, ItemStack stack){
        OreDictionary.registerOre(name,stack);
    }
    private void reg(String name, Block block){
        OreDictionary.registerOre(name,block);
    }
    private void reg(String name, Item item){
        OreDictionary.registerOre(name,item);
    }
}
