package com.matez.wildnature.entity.AI;

import java.util.List;

import com.matez.wildnature.entity.EntityDuck;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityAnimal;

public class EntityAIAdvancedFollowParent extends EntityAIBase {
    /**
     * The child that is following its parent.
     */
    EntityAnimal childAnimal;
    EntityAnimal parentAnimal;
    Class<? extends EntityAnimal> parentClass;
    double moveSpeed;
    private int delayCounter;

    public EntityAIAdvancedFollowParent(EntityAnimal animal, Class<? extends EntityAnimal> parent , double speed) {
        this.childAnimal = animal;
        this.moveSpeed = speed;
        this.parentClass = parent;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        if (this.childAnimal.getGrowingAge() >= 0) {
            if(parentAnimal==null){
                return searchForParent();
            }
            return false;
        } else {
            return searchForParent();
        }

    }

    public boolean searchForParent(){
        List<EntityAnimal> list = this.childAnimal.world.<EntityAnimal>getEntitiesWithinAABB(this.parentClass, this.childAnimal.getEntityBoundingBox().grow(8.0D));
        EntityAnimal entityanimal = null;
        double d0 = Double.MAX_VALUE;

        for (EntityAnimal entityanimal1 : list) {
            if (entityanimal1.getGrowingAge() >= 0) {
                double d1 = this.childAnimal.getDistanceSq(entityanimal1);

                if (d1 <= d0) {
                    d0 = d1;
                    entityanimal = entityanimal1;
                }
            }
        }

        if (entityanimal == null) {
            return false;
        } else if (d0 < 9.0D) {
            return false;
        } else {
            this.parentAnimal = entityanimal;
            return true;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting() {
        if (this.childAnimal.getGrowingAge() >= 0) {
            return false;
        } else if (!this.parentAnimal.isEntityAlive()) {
            return false;
        } else {
            double d0 = this.childAnimal.getDistanceSq(this.parentAnimal);
            return d0 >= 9.0D && d0 <= 256.0D;
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.delayCounter = 0;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask() {
        this.parentAnimal = null;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask() {
        if (--this.delayCounter <= 0) {
            this.delayCounter = 10;
            this.childAnimal.getNavigator().tryMoveToEntityLiving(this.parentAnimal, this.moveSpeed);
        }
    }
}
