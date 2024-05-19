package com.matez.wildnature.blocks.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class RecipeList {
    private ArrayList<Recipe> recipes = new ArrayList<>();
    public RecipeList(){

    }
    public void put(ItemStack result,ItemStack resultTrash, ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4){
        recipes.add(new Recipe(result,resultTrash,input1,input2,input3,input4));
    }

    public ItemStack getResult(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4){

        int a = 0;
        int b = 0;
        boolean x = false;
        while(a<recipes.size()){
            ItemStack i1 = recipes.get(a).getInput1();
            ItemStack i2 = recipes.get(a).getInput2();
            ItemStack i3 = recipes.get(a).getInput3();
            ItemStack i4 = recipes.get(a).getInput4();

            if(compare(i1,i2,i3,i4,input1)){
                if(compare(i1,i2,i3,i4,input2)){
                    if(compare(i1,i2,i3,i4,input3)){
                        if(compare(i1,i2,i3,i4,input4)){
                            if(recipes.get(a).getResult().getItem() != ItemStack.EMPTY.getItem() && recipes.get(a).getResult().getItem() !=new ItemStack(Blocks.AIR).getItem()) {
                                return recipes.get(a).getResult();
                            }else{
                                if(b<=2){
                                    recipes.clear();
                                    new IronworksRecipeAdd();
                                    a = 0;
                                    b++;
                                }
                            }
                        };
                    };
                };
            };
            a++;
        }

        return ItemStack.EMPTY;
    }

    public ItemStack getResultTrash(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4){
        int b = 0;
        int a = 0;
        boolean x = false;
        while(a<recipes.size()){
            ItemStack i1 = recipes.get(a).getInput1();
            ItemStack i2 = recipes.get(a).getInput2();
            ItemStack i3 = recipes.get(a).getInput3();
            ItemStack i4 = recipes.get(a).getInput4();
            if(compare(i1,i2,i3,i4,input1)){
                if(compare(i1,i2,i3,i4,input2)){
                    if(compare(i1,i2,i3,i4,input3)){
                        if(compare(i1,i2,i3,i4,input4)){
                            if(recipes.get(a).getResultTrash().getItem() != ItemStack.EMPTY.getItem() && recipes.get(a).getResultTrash().getItem() !=new ItemStack(Blocks.AIR).getItem()) {
                                return recipes.get(a).getResultTrash();
                            }else{
                                if(b<=2){
                                    recipes.clear();
                                    new IronworksRecipeAdd();
                                    a = 0;
                                    b++;
                                }
                            }
                        };
                    };
                };
            };
            a++;
        }
        return ItemStack.EMPTY;
    }

    private boolean compare(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack compareWith){
        if(compareWith.isItemEqual(input1)){
            return true;
        }
        if(compareWith.isItemEqual(input2)){
            return true;
        }
        if(compareWith.isItemEqual(input3)){
            return true;
        }
        if(compareWith.isItemEqual(input4)){
            return true;
        }
        return false;
    }
}
