package com.matez.wildnature.entity;

import com.matez.wildnature.Main;
import net.minecraft.world.World;

public class EntityGoatChild extends EntityGoat {
    public EntityGoatChild(World worldIn) {
        super(worldIn);
        setType(2);
    }


    @Override
    protected void onGrowingAdult() {
        super.onGrowingAdult();
        if(Main.generateRandomInt(0,1)==0){
            EntityGoatMale male = new EntityGoatMale(world);
            male.setPositionAndRotation(this.getPosition().getX(),this.getPosition().getY(),this.getPosition().getZ(),rotationYaw,rotationPitch);
            this.world.spawnEntity(male);
            this.setPosition(0,-100,0);
            this.setDead();
        }else{
            EntityGoatFemale female = new EntityGoatFemale(world);
            female.setPositionAndRotation(this.getPosition().getX(),this.getPosition().getY(),this.getPosition().getZ(),rotationYaw,rotationPitch);
            this.world.spawnEntity(female);
            this.setPosition(0,-100,0);
            this.setDead();
        }
    }
}
