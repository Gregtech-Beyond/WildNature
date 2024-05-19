package com.matez.wildnature.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidInit {
    public static final Fluid NEW_WATER = new FluidLiquid("mb_water",new ResourceLocation("wildnature:blocks/fluid/water_still"),new ResourceLocation("wildnature:blocks/fluid/water_flow"));

    public static void registerFluid(){
        registerFluids(NEW_WATER);
    }

    public static void registerFluids(Fluid fluid){
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }}