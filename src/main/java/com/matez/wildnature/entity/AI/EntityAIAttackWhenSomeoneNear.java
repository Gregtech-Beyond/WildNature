package com.matez.wildnature.entity.AI;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EntityAIAttackWhenSomeoneNear extends EntityAIBase {
    EntityCreature creature;
    EntityLivingBase thisOneAttack;
    Class<? extends Entity> target;
    double distance;

    public EntityAIAttackWhenSomeoneNear(EntityCreature creature,Class<? extends Entity> target, double distance){
        this.creature = creature;
        this.target= target;
        this.distance = distance;
    }
    @Override
    public boolean shouldExecute() {
        thisOneAttack = getClosestEntity(creature,target,distance);

        return thisOneAttack!=null;
    }

    @Override
    public void startExecuting() {
        creature.setRevengeTarget(thisOneAttack);
        creature.setAttackTarget(thisOneAttack);
    }

    @Override
    public void updateTask() {
        if(thisOneAttack.isDead){
            this.resetTask();
        }
        if(creature.getDistance(thisOneAttack.getPosition().getX(),thisOneAttack.getPosition().getY(),thisOneAttack.getPosition().getZ())>=distance){
            creature.setRevengeTarget(null);
            creature.setAttackTarget(null);
            this.resetTask();
        }
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        return shouldExecute();
    }

    public EntityLivingBase getClosestEntity(EntityCreature creature, Class<? extends Entity> target, double maxDistance){
        int a = 0;
        EntityLivingBase closestEntity = null;

        if(!(target== EntityPlayer.class)) {
            while (a < creature.getEntityWorld().loadedEntityList.size()) {
                Entity entity = creature.getEntityWorld().loadedEntityList.get(a);

                EntityCreature entityCreature = null;
                try {
                    entityCreature = (EntityCreature) entity;
                } catch (Exception e) {
                    a++;
                    continue;
                }

                if (!(entityCreature.getClass().isInstance(target))) {
                    a++;
                    continue;
                }

                if (entityCreature.getPosition().getDistance(creature.getPosition().getX(), creature.getPosition().getY(), creature.getPosition().getZ()) > maxDistance) {
                    a++;
                    continue;
                }


                if (closestEntity == null) {
                    closestEntity = entityCreature;
                } else {
                    if (closestEntity.getPosition().getDistance(creature.getPosition().getX(), creature.getPosition().getY(), creature.getPosition().getZ()) < closestEntity.getPosition().getDistance(creature.getPosition().getX(), creature.getPosition().getY(), creature.getPosition().getZ())) {

                    } else {
                        closestEntity = entityCreature;
                    }
                }
                a++;
            }
        }else{
            closestEntity=creature.getEntityWorld().getNearestPlayerNotCreative(creature,maxDistance);
        }

        if(closestEntity!=null){
            if(closestEntity.getDistance(creature.getPosition().getX(),creature.getPosition().getY(),creature.getPosition().getZ())>distance){
                return null;
            }
        }


        return closestEntity;
    }
}
