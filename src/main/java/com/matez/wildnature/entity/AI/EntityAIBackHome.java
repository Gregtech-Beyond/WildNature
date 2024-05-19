package com.matez.wildnature.entity.AI;

import com.matez.wildnature.entity.EntityCustomPlayer;
import com.matez.wildnature.entity.EntityForester;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;

public class EntityAIBackHome extends EntityAIBase {
    private EntityCreature entity;
    private BlockPos homePos;
    private float speed;
    int x = 0;
    int z = 0;
    public EntityAIBackHome(EntityCreature entity, BlockPos homePos, float speed){
        this.entity=entity;
        this.homePos=homePos;
        this.speed=speed;
    }

    @Override
    public boolean shouldExecute() {
        double distance = entity.getPosition().getDistance(homePos.getX(), homePos.getY(), homePos.getZ());
        EntityAIForesterFollowPlayer followPlayer = ((EntityForester) entity).getForesterFollowPlayer();
        z=0;
        return entity.getNavigator().noPath() && distance > 3 && followPlayer.getFollowingEntity() == null && entity.getRevengeTarget()==null;
    }

    @Override
    public void startExecuting() {
        boolean go = this.entity.getNavigator().tryMoveToXYZ(homePos.getX(),homePos.getY(),homePos.getZ(),speed);
        if(!go){
            if(x>4) {
                entity.moveToBlockPosAndAngles(homePos, entity.rotationYaw, entity.rotationPitch);
                x=0;
            }else{
                x++;
            }
        }

    }

    @Override
    public void updateTask() {
        if(this.entity.getNavigator().noPath()){
            this.entity.getNavigator().tryMoveToXYZ(homePos.getX(),homePos.getY(),homePos.getZ(),speed);
        }
    }


}
