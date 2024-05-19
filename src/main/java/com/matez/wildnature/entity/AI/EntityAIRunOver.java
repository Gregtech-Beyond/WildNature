package com.matez.wildnature.entity.AI;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class EntityAIRunOver extends EntityAIAvoidEntity {
    public EntityAIRunOver(EntityCreature entityIn, Class classToAvoidIn, float avoidDistanceIn, double farSpeedIn, double nearSpeedIn) {
        super(entityIn, classToAvoidIn, avoidDistanceIn, farSpeedIn, nearSpeedIn);
    }
}
