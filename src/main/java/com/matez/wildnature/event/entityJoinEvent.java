package com.matez.wildnature.event;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityCowChild;
import com.matez.wildnature.entity.EntityCowFemale;
import com.matez.wildnature.entity.EntityCowMale;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class entityJoinEvent {
    @SubscribeEvent
    public void OnEntityJoinWorld(EntityJoinWorldEvent event)
    {
        if (event.getEntity().getClass() == EntityCow.class) {
            Entity entity = null;
            if ((!((EntityCow) event.getEntity()).isChild())) {
                int x = Main.generateRandomInt(1,5);
                if(x==1){
                    entity = new EntityCowFemale(event.getWorld());
                }else if(x==2){
                    entity = new EntityCowFemale(event.getWorld());
                }else if(x==3){
                    entity = new EntityCowFemale(event.getWorld());
                }else if(x==4){
                    entity = new EntityCowMale(event.getWorld());
                }else if(x==5){
                    entity = new EntityCowMale(event.getWorld());
                }
            } else {
                entity = new EntityCowChild(event.getWorld());
            }

            if(entity!=null) {

                entity.copyLocationAndAnglesFrom(event.getEntity());
                event.getWorld().spawnEntity(entity);
                event.getEntity().moveToBlockPosAndAngles(new BlockPos(event.getEntity().posX,-100,event.getEntity().posZ),0,0);
                return;
            }


        }
    }
}