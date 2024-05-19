package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;

public class ItemCustomShovel extends net.minecraft.item.ItemSpade implements IHasModel {

    public ItemCustomShovel(String name, ToolMaterial material){
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