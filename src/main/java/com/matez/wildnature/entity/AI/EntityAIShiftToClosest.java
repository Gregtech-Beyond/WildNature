package com.matez.wildnature.entity.AI;

import com.google.common.base.Predicates;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EntitySelectors;

public class EntityAIShiftToClosest extends EntityAIBase
{
    protected EntityLiving entity;
    /** The closest entity which is being watched by this one. */
    protected EntityPlayer closestEntity;
    /** This is the Maximum distance that the AI will look for the Entity */
    protected float maxDistanceForPlayer;

    public EntityAIShiftToClosest(EntityLiving entityIn, float maxDistance)
    {
        this.entity = entityIn;
        this.maxDistanceForPlayer = maxDistance;


    }

    @Override
    public boolean shouldExecute() {
        closestEntity = entity.getEntityWorld().getClosestPlayerToEntity(entity,maxDistanceForPlayer);
        return closestEntity!=null;
    }

    @Override
    public void resetTask() {
        closestEntity=null;
        entity.setSneaking(false);
    }

    @Override
    public void updateTask() {
        entity.setSneaking(closestEntity.isSneaking());
        if(closestEntity.isSneaking()){
            this.entity.getLookHelper().setLookPosition(this.closestEntity.posX, this.closestEntity.posY + (double)this.closestEntity.getEyeHeight(), this.closestEntity.posZ, (float)this.entity.getHorizontalFaceSpeed(), (float)this.entity.getVerticalFaceSpeed());
        }
    }
}