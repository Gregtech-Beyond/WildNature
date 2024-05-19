package com.matez.wildnature.gui.tabs;

import com.matez.wildnature.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class wntab extends CreativeTabs {

    public wntab(String text) {
        super(CreativeTabs.getNextID(), "wildnature");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem() {

        ItemStack stack = new ItemStack(ModBlocks.FIR_SAPLING);
        return stack;
    }


    @Override
    public boolean hasSearchBar() {
        return true;
    }
    /*@Override
    public void displayAllRelevantItems(NonNullList<ItemStack> p_78018_1_) {
        super.displayAllRelevantItems(p_78018_1_);
        ArrayList<ItemStack> stacks = new ArrayList<>();
        int x = Main.generateRandomInt(0,ModBlocks.BLOCKS.size()-1);
        int z = 0;
        while(z<x){
            Block b = ModBlocks.BLOCKS.get(z);
            stacks.add(new ItemStack(b));
            z++;
        }
    }*/
}