package com.matez.wildnature.worldgen;

import com.matez.wildnature.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import java.util.Arrays;

import javax.annotation.Nullable;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WorldGenFromFile extends WorldGenSchematicTree {
    private String name;
    public WorldGenFromFile(boolean parShouldNotify, @Nullable IBlockState logState, @Nullable IBlockState leavesState, String nameTXT) {
        super(parShouldNotify, logState, leavesState);
        this.name = nameTXT;
    }

    public String getName(){
        return name;
    }

    @Override
    public void generateBlocks(World parWorld, BlockPos parBlockPos, int height, Random parRandom){
        try {
            //System.out.println("generating");
            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                    .getResourceAsStream("assets/"+ Reference.MOD_ID+"/worldgen/"+name), "UTF-8"));
            Scanner s = new Scanner(reader);
            while(s.hasNextLine()){
                String line = s.nextLine();
                if(!line.startsWith("//")){
                    if(line.startsWith("Block(")){
                        ArrayList<Integer> indexes = new ArrayList<>();
                        int x = 0;
                        while(x<line.length()-1){
                            if(line.charAt(x)==',') {
                                indexes.add(x);
                            }
                            x++;
                        }
                        String s1 = line.substring(line.indexOf('(')+1,indexes.get(0)).replace(",","");//x
                        String s2 = line.substring(indexes.get(0),indexes.get(1)).replace(",","");//y
                        String s3 = line.substring(indexes.get(1),indexes.get(2)).replace(",","");//z
                        String s4 = line.substring(indexes.get(2),line.indexOf(')')).replace(",","");//block
                        IBlockState b = null;
                        if(s4.equals("LOG")){
                            b = LOG;
                        }else if(s4.equals("LEAVES")){
                            b = LEAVES;
                        }else if(s4.equals("DIRT")){
                            b = DIRT;
                        }else if(s4.equals("FLOOR")){
                            b = FLOOR;
                        }else{
                            b = LOG;
                        }

                        //System.out.println("Generating block at " + Integer.parseInt(s1)+"x " + Integer.parseInt(s2)+"y " + Integer.parseInt(s3)+"z " + " " + b.getBlock().getLocalizedName());
                        Block(Integer.parseInt(s1),Integer.parseInt(s2),Integer.parseInt(s3),b);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
