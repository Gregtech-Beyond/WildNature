package com.matez.wildnature.entity.AI;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.math.Vec3d;

public class EntityAIMountainClimb extends EntityAIBase {
    public EntityCreature creature;
    public int maxDistance;
    private float speed;
    private Vec3d climbPos;
    private int tooMany = 0;
    public EntityAIMountainClimb(EntityCreature creature, int maxDistance, float speed){
        this.creature=creature;
        this.maxDistance=maxDistance;
        this.speed=speed;
    }
    @Override
    public boolean shouldExecute() {
        tooMany=0;
        return climbSpecs();
    }

    @Override
    public void startExecuting() {
        climb();
    }

    @Override
    public void updateTask() {
        climb();
    }


    private boolean climbSpecs(){
        if(!creature.getNavigator().noPath()){
            return false;
        }
        climbPos = RandomPositionGenerator.findRandomTarget(this.creature, maxDistance, 1);
        Vec3d creaturePos = creature.getPositionVector();
        if(climbPos!=null) {
            if (climbPos.y > creaturePos.y && creature.getNavigator().getPathToXYZ(climbPos.x,climbPos.y,climbPos.z)!=null) {
                return true;
            } else {
                return false;
            }
        }else{
            tooMany++;
            if(tooMany>10){
                return false;
            }
            return climbSpecs();
        }
    }

    private void climb(){
        Vec3d creaturePos = creature.getPositionVector();
        if(climbPos!=null) {
            if (climbPos.y > creaturePos.y){
                creature.getNavigator().tryMoveToXYZ(climbPos.x,climbPos.y,climbPos.z,speed);
            }
        }
    }
}
