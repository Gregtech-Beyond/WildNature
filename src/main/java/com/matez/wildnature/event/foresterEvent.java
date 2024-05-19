package com.matez.wildnature.event;

import com.matez.wildnature.entity.EntityForester;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Arrays;

public class foresterEvent {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void playerBreakBlockEvent(BlockEvent.BreakEvent event){

            try {
                //if(event.getPlayer().getEntityWorld().getLoadedEntityList()!=null)
                ArrayList<Entity> entities = new ArrayList(Arrays.asList(event.getPlayer().getEntityWorld().getLoadedEntityList().toArray()));
                ArrayList<EntityForester> foresters = new ArrayList<>();
                int x = 0;
                while (x < entities.size()) {
                    if (entities.get(x) instanceof EntityForester) {
                        foresters.add((EntityForester) entities.get(x));
                    }
                    x++;
                }
                x = 0;
                float closestDistance = -1;
                EntityForester closestForester = null;
                while (x < foresters.size()) {
                    if (foresters.get(x).getForesterAttack() != null) {
                        if (foresters.get(x).getForesterAttack().getPlayers().contains(event.getPlayer())) {
                            if (closestDistance == -1) {
                                closestDistance = foresters.get(x).getDistance(event.getPlayer());
                                closestForester = foresters.get(x);
                            } else {
                                float distance = foresters.get(x).getDistance(event.getPlayer());
                                if (distance < closestDistance) {
                                    closestDistance = distance;
                                    closestForester = foresters.get(x);
                                }
                            }
                        }
                    }
                    x++;
                }


                if (closestForester != null) {
                    Block broken = event.getWorld().getBlockState(event.getPos()).getBlock();

                    if (closestForester.getForesterAttack().getCannotBreakThis().contains(broken)) {
                        if (closestForester.getForesterAttack().containsFirstWarned(event.getPlayer()) || closestForester.getForesterAttack().containsWarned(event.getPlayer())) {
                            closestForester.getForesterAttack().removeFirstWarned(event.getPlayer());
                            closestForester.getForesterAttack().addSuspectedForBreak(event.getPlayer());
                        } else {
                            closestForester.getForesterAttack().addFirstWarned(event.getPlayer());
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception thrown: " + e.getLocalizedMessage() + " - " + e.getCause() + "REPORT IT TO AUTHOR. THIS SHOULDN'T HAPPEN");
            }

    }
}
