package com.matez.wildnature.entity.AI;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class EntityAISwordSetter extends EntityAIBase {

    private EntityLivingBase entity;
    private Item swordItem;
    public EntityAISwordSetter(EntityLivingBase entity, Item swordItem){
        this.entity=entity;
        this.swordItem=swordItem;
    }
    @Override
    public boolean shouldExecute() {
        return entity.getRevengeTarget() !=null || entity.getAttackingEntity() !=null;
    }

    @Override
    public void startExecuting() {
        entity.setHeldItem(EnumHand.MAIN_HAND,new ItemStack(swordItem));
    }

    @Override
    public void resetTask() {
        entity.setHeldItem(EnumHand.MAIN_HAND,ItemStack.EMPTY);
    }
}
