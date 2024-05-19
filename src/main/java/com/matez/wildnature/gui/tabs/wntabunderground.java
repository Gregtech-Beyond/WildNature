package com.matez.wildnature.gui.tabs;

import com.matez.wildnature.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class wntabunderground extends CreativeTabs {

    public wntabunderground(String text) {
        super(CreativeTabs.getNextID(), "wildnature_underground");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem() {

        ItemStack stack = new ItemStack(ModItems.AMBER_ITEM);
        return stack;
    }


    @Override
    public boolean hasSearchBar() {
        return true;
    }

    @Override
    public CreativeTabs setBackgroundImageName(String texture) {
        return super.setBackgroundImageName(texture);
    }
}