package com.matez.wildnature.blocks;

import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;

public class RockBaseTranslucent extends RockBase {
    public RockBaseTranslucent(String name, Material material, CreativeTabs tab, int type) {
        super(name, material, tab, type);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
}
