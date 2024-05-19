package com.matez.wildnature.entity.AI;

import java.util.List;
import java.util.Random;

import com.matez.wildnature.entity.EntityDuckFemale;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityAIAdvancedMate extends EntityAIBase
{
    private EntityAnimal thisAnimal,baby,mate;
    private final Class <? extends EntityAnimal > mateClass,animalMale,animalFemale;
    World world;
    private EntityAnimal targetMate;
    /** Delay preventing a baby from spawning immediately when two mate-able animals find each other. */
    int spawnBabyDelay;
    /** The speed the creature moves at during mating behavior. */
    double moveSpeed;



    public EntityAIAdvancedMate(EntityAnimal thisAnimal, Class <? extends EntityAnimal > male,Class <? extends EntityAnimal > female, double speed, Class <? extends EntityAnimal > babyClass)
    {
        this.animalMale = male;
        this.animalFemale = female;
        this.thisAnimal = thisAnimal;
        this.world = thisAnimal.world;
        this.mateClass = babyClass;
        this.moveSpeed = speed;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.thisAnimal.isInLove())
        {
            return false;
        }
        else
        {
            this.targetMate = this.getNearbyMate();
            return this.targetMate != null;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting()
    {
        return this.targetMate.isEntityAlive() && this.targetMate.isInLove() && this.spawnBabyDelay < 60;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        this.targetMate = null;
        this.spawnBabyDelay = 0;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        this.thisAnimal.getLookHelper().setLookPositionWithEntity(this.targetMate, 10.0F, (float)this.thisAnimal.getVerticalFaceSpeed());
        this.thisAnimal.getNavigator().tryMoveToEntityLiving(this.targetMate, this.moveSpeed);
        ++this.spawnBabyDelay;

        if (this.spawnBabyDelay >= 60 && this.thisAnimal.getDistanceSq(this.targetMate) < 9.0D)
        {
            this.spawnBaby();
        }
    }

    /**
     * Loops through nearby animals and finds another animal of the same type that can be mated with. Returns the first
     * valid mate found.
     */
    private EntityAnimal getNearbyMate()
    {
        List<EntityAnimal> list = this.world.<EntityAnimal>getEntitiesWithinAABB(this.animalMale, this.thisAnimal.getEntityBoundingBox().grow(8.0D));
        list.addAll(this.world.<EntityAnimal>getEntitiesWithinAABB(this.animalFemale, this.thisAnimal.getEntityBoundingBox().grow(8.0D)));
        double d0 = Double.MAX_VALUE;
        EntityAnimal entityanimal = null;

        for (EntityAnimal entityanimal1 : list)
        {
            if (this.thisAnimal.canMateWith(entityanimal1) && this.thisAnimal.getDistanceSq(entityanimal1) < d0)
            {
                entityanimal = entityanimal1;
                d0 = this.thisAnimal.getDistanceSq(entityanimal1);
            }
        }

        return entityanimal;
    }

    /**
     * Spawns a baby animal of the same type.
     */
    private void spawnBaby()
    {
        EntityAgeable entityageable;
        EntityAnimal producer = null;
        if(thisAnimal instanceof EntityDuckFemale) {
             producer = thisAnimal;
        }else{
             producer = targetMate;
        }
        entityageable = producer.createChild(this.targetMate);

        final net.minecraftforge.event.entity.living.BabyEntitySpawnEvent event = new net.minecraftforge.event.entity.living.BabyEntitySpawnEvent(thisAnimal, targetMate, entityageable);
        final boolean cancelled = net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
        entityageable = event.getChild();
        if (cancelled) {
            //Reset the "inLove" state for the animals
            this.thisAnimal.setGrowingAge(6000);
            this.targetMate.setGrowingAge(6000);
            this.thisAnimal.resetInLove();
            this.targetMate.resetInLove();
            return;
        }

        if (entityageable != null)
        {
            EntityPlayerMP entityplayermp = this.thisAnimal.getLoveCause();

            if (entityplayermp == null && this.targetMate.getLoveCause() != null)
            {
                entityplayermp = this.targetMate.getLoveCause();
            }

            if (entityplayermp != null)
            {
                entityplayermp.addStat(StatList.ANIMALS_BRED);
                CriteriaTriggers.BRED_ANIMALS.trigger(entityplayermp, this.thisAnimal, this.targetMate, entityageable);
            }

            this.thisAnimal.setGrowingAge(6000);
            this.targetMate.setGrowingAge(6000);
            this.thisAnimal.resetInLove();
            this.targetMate.resetInLove();
            entityageable.setGrowingAge(-24000);
            entityageable.setLocationAndAngles(producer.posX, producer.posY, producer.posZ, 0.0F, 0.0F);
            this.world.spawnEntity(entityageable);
            Random random = this.thisAnimal.getRNG();




            for (int i = 0; i < 7; ++i)
            {
                double d0 = random.nextGaussian() * 0.02D;
                double d1 = random.nextGaussian() * 0.02D;
                double d2 = random.nextGaussian() * 0.02D;
                double d3 = random.nextDouble() * (double)this.thisAnimal.width * 2.0D - (double)this.thisAnimal.width;
                double d4 = 0.5D + random.nextDouble() * (double)this.thisAnimal.height;
                double d5 = random.nextDouble() * (double)this.thisAnimal.width * 2.0D - (double)this.thisAnimal.width;
                this.world.spawnParticle(EnumParticleTypes.HEART, this.thisAnimal.posX + d3, this.thisAnimal.posY + d4, this.thisAnimal.posZ + d5, d0, d1, d2);
            }

            if (this.world.getGameRules().getBoolean("doMobLoot"))
            {
                this.world.spawnEntity(new EntityXPOrb(this.world, this.thisAnimal.posX, this.thisAnimal.posY, this.thisAnimal.posZ, random.nextInt(7) + 1));
            }
        }
    }
}