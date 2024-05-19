package com.matez.wildnature.event;

import com.matez.wildnature.Main;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

public class fogEvent {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onFogDensityRender(EntityViewRenderEvent.FogDensity event){
        boolean change = false;
        Biome b = event.getEntity().getEntityWorld().getBiome(event.getEntity().getPosition());

        int a = 0;
        while(a< Main.fogBiomeList.size()){
            FogBiome fogBiome = Main.fogBiomeList.get(a);
            if(b==fogBiome.getBiome()){
                change=true;
                event.setDensity(fogBiome.getDensity());
                break;
            }
            a++;
        }

        event.setCanceled(change);

    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onFogColorRender(EntityViewRenderEvent.FogColors event){
        if(true) {
            event.setRed(200);
            event.setGreen(10);
            event.setBlue(10);
        }
    }
}
