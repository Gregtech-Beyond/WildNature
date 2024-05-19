package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;

public class ItemCustomHoe extends net.minecraft.item.ItemHoe implements IHasModel {

    public ItemCustomHoe(String name, ToolMaterial material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);



        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {

        Main.proxy.registerItemRenderer(this,0,"inventory");

    }
}