package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;

public class ItemCustomAxe extends net.minecraft.item.ItemAxe implements IHasModel {

    public ItemCustomAxe(String name, ToolMaterial material,float damage, float speed){
        super(material,damage,speed);
        setUnlocalizedName(name);
        setRegistryName(name);



        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {

        Main.proxy.registerItemRenderer(this,0,"inventory");

    }
}