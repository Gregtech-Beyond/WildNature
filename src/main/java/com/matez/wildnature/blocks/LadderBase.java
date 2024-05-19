package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import com.matez.wildnature.util.handlers.SoundHandler;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class LadderBase extends BlockLadder implements IHasModel {

    public static final SoundType LADDER = new SoundType(1.0F, 1.0F, SoundEvents.BLOCK_METAL_BREAK, SoundHandler.STEP_STEELLADDER_STEP1, SoundEvents.BLOCK_METAL_PLACE, SoundEvents.BLOCK_METAL_HIT, SoundHandler.STEP_STEELLADDER_STEP2);


    public LadderBase(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.mbtab);
        setSoundType(SoundType.METAL);
        setHardness(0.7F);
        setSoundType(LADDER);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }
}
