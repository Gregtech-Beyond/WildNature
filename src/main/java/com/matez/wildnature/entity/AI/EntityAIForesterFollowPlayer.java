package com.matez.wildnature.entity.AI;


import com.google.common.base.Predicate;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import java.util.Arrays;

public class EntityAIForesterFollowPlayer extends EntityAIBase
{
    private final EntityLiving entity;
    private EntityLivingBase followingEntity;
    private double speedModifier;

    private int timeToRecalcPath;
    private final int stopDistance;
    private float oldWaterCost;
    private final int areaSize;
    private final ArrayList<Biome> followingBiomes;

    public EntityAIForesterFollowPlayer(final EntityLiving entity, double speedModifier, int stopDistance, int followArea, Biome... followOnBiomes)
    {
        this.entity = entity;
        this.speedModifier = speedModifier;
        this.stopDistance = stopDistance;
        this.areaSize = followArea;
        if(followOnBiomes==null){
            this.followingBiomes=new ArrayList<>();
        }else {
            this.followingBiomes = new ArrayList<>(Arrays.asList(followOnBiomes));
        }
        this.setMutexBits(3);

        if (!(entity.getNavigator() instanceof PathNavigateGround) && !(entity.getNavigator() instanceof PathNavigateFlying))
        {
            throw new IllegalArgumentException("Unsupported mob type for FollowMobGoal");
        }
    }

    public EntityLivingBase getFollowingEntity() {
        return followingEntity;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        List<EntityPlayer> entities = this.entity.getEntityWorld().playerEntities;
        int x = 0;
        while(x<entities.size()){
            EntityPlayer entityliving=entities.get(x);
            if(!( entityliving).isCreative() && !( entityliving).isSpectator() && !entityliving.isInvisible() && canFollowOnBiome( entityliving)) {
                double distance = this.entity.getDistance(entityliving);
                if(distance>stopDistance && distance<=areaSize) {
                    this.followingEntity = entityliving;
                    return true;
                }
            }
            x++;
        }

        return false;
    }

    public boolean canFollowOnBiome(EntityLivingBase entity){
        if(followingBiomes==null || followingBiomes.isEmpty()){
            return true;
        }else {
            int x = 0;
            while(x<followingBiomes.size()) {
                if (entity.getEntityWorld().getBiome(entity.getPosition())==followingBiomes.get(x)) {
                    return true;
                }
                x++;
            }
        }
        return false;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting()
    {
        if(followingEntity==null) {
            return shouldExecute();
        }else{
            List<EntityPlayer> entities = this.entity.getEntityWorld().playerEntities;
            int x = 0;
            while(x<entities.size()){
                EntityPlayer entityliving=entities.get(x);
                if(!( entityliving).isCreative() && !( entityliving).isSpectator() && !entityliving.isInvisible() && canFollowOnBiome( entityliving)) {
                    return true;
                }
                x++;
            }
        }
        return shouldExecute();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.entity.getPathPriority(PathNodeType.WATER);
        this.entity.setPathPriority(PathNodeType.WATER, 0.1F);
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        this.entity.setSneaking(false);
        this.entity.setSprinting(false);
        this.followingEntity = null;
        this.entity.getNavigator().clearPath();
        this.entity.setPathPriority(PathNodeType.WATER, this.oldWaterCost);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        if (this.followingEntity != null)
        {
            boolean sprint = false;
            this.entity.getLookHelper().setLookPositionWithEntity(this.followingEntity, 10.0F, (float)this.entity.getVerticalFaceSpeed());
            double distance = this.entity.getDistance(this.followingEntity);
            if (--this.timeToRecalcPath <= 0)
            {
                this.timeToRecalcPath = 10;


            }

            if(distance>stopDistance && distance<areaSize){
                entity.getNavigator().clearPath();
                if(distance>stopDistance*2){
                    speedModifier=speedModifier+speedModifier*0.5;
                    sprint=true;
                }
                boolean path = this.entity.getNavigator().tryMoveToEntityLiving(followingEntity,speedModifier);
            }else{
                this.entity.getNavigator().clearPath();
            }
            this.entity.setSneaking(!this.entity.getNavigator().noPath() && !sprint);
            this.entity.setSprinting(!this.entity.getNavigator().noPath() && sprint);
        }

    }
}