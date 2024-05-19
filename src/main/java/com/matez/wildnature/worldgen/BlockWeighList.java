package com.matez.wildnature.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;

import java.util.ArrayList;

public class BlockWeighList {

    protected ArrayList<IBlockState> blocks;
    protected ArrayList<Integer> weigh;

    public BlockWeighList(){
        blocks  = new ArrayList<>();
        weigh  = new ArrayList<>();
    }
    
    public ArrayList<IBlockState> getNormalArrayList(){
        ArrayList<IBlockState> states = new ArrayList<>();
        int x = 0;
        while(x<this.size()){
            int a = this.getWeighList().get(x);
            int z = 0;
            while(z<a){
                states.add(this.getBlockList().get(x));
                z++;
            }
            x++;
        }
        
        
        return states;
    }

    public void add(IBlockState block, Integer iWeigh){


        blocks.add(block);
        weigh.add(iWeigh);
    }

    public void remove(Block block, Integer iWeigh){
        blocks.remove(block);
        weigh.remove(iWeigh);
    }

    public void remove(Block block){
        weigh.remove(weigh.get(blocks.indexOf(block)));
        blocks.remove(block);
    }

    public void clear(){
        weigh.clear();
        blocks.clear();
    }

    public Integer size(){

        if(checkIfEquals()){
            return blocks.size();
        }else{
            return -99999;
        }

    }
    

    public boolean checkIfEquals(){
        if(blocks.size()==weigh.size()){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Integer> getWeighList(){
        return weigh;
    }

    public ArrayList<IBlockState> getBlockList(){
        return blocks;
    }

}