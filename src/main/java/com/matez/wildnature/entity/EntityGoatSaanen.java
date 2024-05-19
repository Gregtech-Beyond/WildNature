package com.matez.wildnature.entity;

import com.matez.wildnature.entity.AI.EntityAIAdvancedFollowParent;
import com.matez.wildnature.entity.AI.EntityAIAdvancedMate;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityGoatSaanen extends EntityGoat {
    public EntityGoatSaanen(World worldIn) {
        super(worldIn);
    }
    @Override
    protected void mateAI(){
        this.tasks.addTask(2, new EntityAIAdvancedMate(this,EntityGoatSaanenMale.class,EntityGoatSaanenFemale.class, 1.0D,EntityGoatSaanenChild.class));
        this.tasks.addTask(3, new EntityAIAdvancedFollowParent(this,EntityGoatSaanenFemale.class, 1.1D));
    }
    @Override
    public EntityGoat createChild(EntityAgeable ageable)
    {

        EntityGoatSaanenChild child = new EntityGoatSaanenChild(this.world);
        child.setType(2);
        return child;
    }
    @Override
    public boolean canMateWith(EntityAnimal otherAnimal)
    {
        if(otherAnimal instanceof EntityGoatSaanen){
            if(((EntityGoat)otherAnimal).getType()!=this.getType() && ((EntityGoat)otherAnimal).getType() != 2 && this.getType()!=2){
                return this.isInLove() && otherAnimal.isInLove();
            }
        }
        return false;
    }

}
