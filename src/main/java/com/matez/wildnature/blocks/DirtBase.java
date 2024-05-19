package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class DirtBase extends Block implements IHasModel {

    public DirtBase(String name){
        super(Material.GROUND);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.mbtab);
        setSoundType(SoundType.GROUND);
        setHardness(0.5F);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        ModBlocks.DIRTS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }


}