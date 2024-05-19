package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class OreSandBase extends BlockGravel implements IHasModel {

    int color = 0x000;

    public OreSandBase(String name, int particleColor){
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.wnTabUnderground);
        setSoundType(SoundType.SAND);
        color = particleColor;
        setHardness(0.6F);
        setHarvestLevel("shovel",2);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {

            return MathHelper.getInt(rand, 2, 4);
        }
        return 0;
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ModItems.AMBER_ITEM;


    }

    @Override
    public int quantityDropped(Random rand) {
        return MathHelper.getInt(rand, 0, 2);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }


    @Override
    public int getDustColor(IBlockState state) {
        return color;
    }

}