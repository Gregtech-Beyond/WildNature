package com.matez.wildnature.entity.AI;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.pathfinding.PathNavigateGround;

public class EntityAIProffesionalSwimming extends EntityAIBase
{
    private final EntityLiving entity;

    public EntityAIProffesionalSwimming(EntityLiving entityIn)
    {
        this.entity = entityIn;
        this.setMutexBits(4);

        if (entityIn.getNavigator() instanceof PathNavigateGround)
        {
            ((PathNavigateGround)entityIn.getNavigator()).setCanSwim(true);
        }
        else if (entityIn.getNavigator() instanceof PathNavigateFlying)
        {
            ((PathNavigateFlying)entityIn.getNavigator()).setCanFloat(true);
        }
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return this.entity.isInWater() || this.entity.isInLava();
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {

    }
}