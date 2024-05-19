package com.matez.wildnature.blocks.recipes;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.matez.wildnature.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import java.util.Map;

public class IronworksRecipes
{
    public static final RecipeList smeltingList = new RecipeList();
    public static final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
    public static final ItemStack EMPTY = ItemStack.EMPTY;




    private IronworksRecipes()
    {
        //addIronworksRecipe(new ItemStack(Blocks.,1),new ItemStack(Blocks.,1),new ItemStack(Blocks.,1),new ItemStack(Blocks.,1),new ItemStack(Blocks.,1),new ItemStack(Blocks.,1), 5.0F);
        //addIronworksRecipe(new ItemStack(ModBlocks.,1),new ItemStack(ModBlocks.,1),new ItemStack(ModBlocks.,1),new ItemStack(ModBlocks.,1),new ItemStack(Blocks.,1),new ItemStack(Blocks.,1), 5.0F);

        /*
        addIronworksRecipe(
                new ItemStack(ModItems.,1),new ItemStack(ModItems.,1),
                new ItemStack(ModItems.,1),new ItemStack(ModItems.,1),
                new ItemStack(ModItems.,1),new ItemStack(ModItems.,1), 5.0F);
         */


    }


    public static void addIronworksRecipe(ItemStack input1, ItemStack input2,ItemStack input3,ItemStack input4, ItemStack resultTrash,ItemStack result, float experience)
    {
        //if(getIronworksResult(input1, input2, input3, input4) == ItemStack.EMPTY) return;
        smeltingList.put(result,resultTrash, input1, input2,input3,input4);
        experienceList.put(result, Float.valueOf(experience));
    }

    public static ItemStack getIronworksResult(ItemStack input1, ItemStack input2,ItemStack input3,ItemStack input4)
    {
        return smeltingList.getResult(input1,input2,input3,input4);
    }
    public static ItemStack getIronworksResultTrash(ItemStack input1, ItemStack input2,ItemStack input3,ItemStack input4)
    {
        return smeltingList.getResultTrash(input1,input2,input3,input4);
    }



    public RecipeList getSmeltingList()
    {
        return this.smeltingList;
    }

    public float getIronworksExperience(ItemStack stack)
    {
        return 0.0F;
    }
}