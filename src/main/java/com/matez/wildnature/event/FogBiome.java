package com.matez.wildnature.event;


import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.awt.*;

public class FogBiome {
    private Biome biome;
    private float density;
    private Color color;
    public FogBiome(Biome biome, float density, @Nullable Color color){
        this.biome=biome;
        this.density=density;
        this.color=color;
    }

    public Biome getBiome() {
        return biome;
    }

    public float getDensity() {
        System.out.println("DENSITY " + density);
        return density;
    }
    public boolean hasColor(){
        return color!=null;
    }
    public float getRed(){
        return (float)color.getRed()/255;
    }
    public float getGreen(){
        return (float)color.getGreen()/255;
    }
    public float getBlue(){
        return (float)color.getBlue()/255;
    }
}
