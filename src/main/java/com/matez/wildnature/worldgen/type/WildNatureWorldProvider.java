package com.matez.wildnature.worldgen.type;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;

public class WildNatureWorldProvider extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return DimensionType.OVERWORLD;
    }
}