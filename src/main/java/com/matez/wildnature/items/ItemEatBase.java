package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemEatBase extends ItemFood implements IHasModel {

    public ItemEatBase(String name,int foodPoints,float saturation,boolean wolf){
        super(foodPoints,saturation,wolf);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);



        ModItems.ITEMS.add(this);

    }

    @Override
    public void registerModels() {

        Main.proxy.registerItemRenderer(this,0,"inventory");

    }


}