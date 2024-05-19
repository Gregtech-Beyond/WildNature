package com.matez.wildnature.blocks.recipes;

import net.minecraft.item.ItemStack;

public class Recipe {
    public final ItemStack result,resultTrash, input1,input2,input3,input4;
    public Recipe(ItemStack result,ItemStack resultTrash, ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4){
        this.result=result;
        this.resultTrash=resultTrash;
        this.input1=input1;
        this.input2=input2;
        this.input3=input3;
        this.input4=input4;
    }

    public ItemStack getInput1() {
        return input1;
    }

    public ItemStack getInput2() {
        return input2;
    }

    public ItemStack getInput3() {
        return input3;
    }

    public ItemStack getInput4() {
        return input4;
    }

    public ItemStack getResult() {
        return result;
    }

    public ItemStack getResultTrash() {
        return resultTrash;
    }

    @Override
    public String toString() {
        return result.getItem().getRegistryName()+" "+resultTrash.getItem().getRegistryName()+" "+input1.getItem().getRegistryName()+" "+input2.getItem().getRegistryName()+" "+input3.getItem().getRegistryName()+" "+input4.getItem().getRegistryName();
    }
}
