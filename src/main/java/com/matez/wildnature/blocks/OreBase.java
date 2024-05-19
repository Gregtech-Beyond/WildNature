package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.init.ModBlocks;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class OreBase extends Block implements IHasModel {

    public OreBase(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.wnTabUnderground);
        setSoundType(getPerfectSoundForMaterial(material));
        setHardness(1.4F);

        if (this == ModBlocks.RUBY_ORE)
        {
            setHarvestLevel("pickaxe",4);
        }
        else if (this == ModBlocks.MALACHITE_ORE)
        {
            setHarvestLevel("pickaxe",2);
        }
        else if (this == ModBlocks.SAPPHIRE_ORE)
        {
            setHarvestLevel("pickaxe",3);
        }
        else if (this == ModBlocks.AMETHYST_ORE) {
            setHarvestLevel("pickaxe",2);
        }else if( this == ModBlocks.SILVER_ORE){
            setHarvestLevel("pickaxe",3);
        }


        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }


    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }

    public SoundType getPerfectSoundForMaterial(Material material){
        if(material==Material.IRON){
            return SoundType.METAL;
        }else if(material==Material.GRASS){
            return SoundType.PLANT;
        }else if(material==Material.WOOD){
            return SoundType.WOOD;
        }else if(material==Material.SAND){
            return SoundType.SAND;
        }else{
            return SoundType.STONE;
        }
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = 0;

            if (this == ModBlocks.RUBY_ORE)
            {
                i = MathHelper.getInt(rand, 3, 8);
            }
            else if (this == ModBlocks.MALACHITE_ORE)
            {
                i = MathHelper.getInt(rand, 2, 4);
            }
            else if (this == ModBlocks.SAPPHIRE_ORE)
            {
                i = MathHelper.getInt(rand, 3, 5);
            }
            else if (this == ModBlocks.AMETHYST_ORE)
            {
                i = MathHelper.getInt(rand, 2, 3);
            }


            return i;
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
        if (this == ModBlocks.RUBY_ORE)
        {
            return ModItems.RUBY_SHARD;
        }
        else if (this == ModBlocks.MALACHITE_ORE)
        {
            return ModItems.MALACHITE_SHARD;
        }
        else if (this == ModBlocks.SAPPHIRE_ORE)
        {
            return ModItems.SAPPHIRE_SHARD;
        }
        else if (this == ModBlocks.AMETHYST_ORE)
        {
            return ModItems.AMETHYST_SHARD;
        }

        return Item.getItemFromBlock(state.getBlock());


    }

    @Override
    public int quantityDropped(Random rand) {

        int i = 1;

        if (this == ModBlocks.RUBY_ORE)
        {
            i = MathHelper.getInt(rand, 1, 2);
        }
        else if (this == ModBlocks.MALACHITE_ORE)
        {
            i = MathHelper.getInt(rand, 1, 2);
        }
        else if (this == ModBlocks.SAPPHIRE_ORE)
        {
            i = MathHelper.getInt(rand, 1, 2);
        }
        else if (this == ModBlocks.AMETHYST_ORE)
        {
            i = MathHelper.getInt(rand, 1, 2);
        }else{

        }


        return i;
    }


    /*@Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        System.out.println("Foliage" + BiomeColorHelper.getFoliageColorAtPos(worldIn,pos));
        System.out.println("Grass" + BiomeColorHelper.getGrassColorAtPos(worldIn,pos));
        System.out.println("Water" + BiomeColorHelper.getWaterColorAtPos(worldIn,pos));
    }*/
}