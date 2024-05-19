package com.matez.wildnature.blocks.recipes;

import com.matez.wildnature.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static com.matez.wildnature.blocks.recipes.IronworksRecipes.*;

public class IronworksRecipeAdd {
    public IronworksRecipeAdd(){
        addIronworksRecipe(
                new ItemStack(ModItems.AMETHYST_SHARD,1),new ItemStack(ModItems.AMETHYST_SHARD,1),
                new ItemStack(ModItems.AMETHYST_SHARD,1),new ItemStack(ModItems.AMETHYST_SHARD,1),
                new ItemStack(ModItems.PEBBLE,1),new ItemStack(ModItems.AMETHYST_ITEM,1), 5.0F);
        addIronworksRecipe(
                new ItemStack(ModItems.SAPPHIRE_SHARD,1),new ItemStack(ModItems.SAPPHIRE_SHARD,1),
                new ItemStack(ModItems.SAPPHIRE_SHARD,1),new ItemStack(ModItems.SAPPHIRE_SHARD,1),
                new ItemStack(ModItems.PEBBLE,1),new ItemStack(ModItems.SAPPHIRE_ITEM,1), 5.0F);
        addIronworksRecipe(
                new ItemStack(ModItems.MALACHITE_SHARD,1),new ItemStack(ModItems.MALACHITE_SHARD,1),
                new ItemStack(ModItems.MALACHITE_SHARD,1),new ItemStack(ModItems.MALACHITE_SHARD,1),
                new ItemStack(ModItems.PEBBLE,1),new ItemStack(ModItems.MALACHITE_ITEM,1), 5.0F);
        addIronworksRecipe(
                new ItemStack(ModItems.RUBY_SHARD,1),new ItemStack(ModItems.RUBY_SHARD,1),
                new ItemStack(ModItems.RUBY_SHARD,1),new ItemStack(ModItems.RUBY_SHARD,1),
                new ItemStack(ModItems.PEBBLE,1),new ItemStack(ModItems.RUBY_ITEM,1), 5.0F);
        addIronworksRecipe(
                new ItemStack(Items.IRON_INGOT,1),new ItemStack(Items.COAL,1),
                new ItemStack(Items.COAL,1),new ItemStack(Items.IRON_INGOT,1),
                EMPTY,new ItemStack(ModItems.STEEL_INGOT,2), 5.0F);
    }
}
