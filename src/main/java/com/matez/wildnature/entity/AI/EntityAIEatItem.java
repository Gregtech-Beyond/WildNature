package com.matez.wildnature.entity.AI;

import com.matez.wildnature.MyAPI.Wait;
import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class EntityAIEatItem extends EntityAIBase {
    private ArrayList<Item> items = new ArrayList<>();
    private EntityCreature creature;
    private double speed;
    protected int runDelay;
    private int timeoutCounter;
    private int maxStayTicks;
    protected BlockPos destinationBlock = BlockPos.ORIGIN;
    private boolean isAboveDestination;
    private double maxDistance = 10;
    private EntityItem thisItem;


    public EntityAIEatItem(EntityCreature entityCreature, double speed,double maxDistance, ArrayList<Item> eatableItems){
        creature = entityCreature;
        this.speed = speed;
        items=eatableItems;
        this.maxDistance = maxDistance;
    }



    public boolean shouldExecute()
    {
        return searchForDestination();
    }

    public boolean searchForDestination(){
        EntityItem nearestItem = null;
        int a = 0;
        while(a<items.size()){
            try {
                EntityItem itemClosest = getClosestItem(creature, items.get(a), maxDistance);
                if (nearestItem == null) {
                    nearestItem = itemClosest;
                } else {
                    if (nearestItem.getPosition().getDistance(creature.getPosition().getX(), creature.getPosition().getY(), creature.getPosition().getZ()) < itemClosest.getPosition().getDistance(creature.getPosition().getX(), creature.getPosition().getY(), creature.getPosition().getZ())) {

                    } else {
                        nearestItem = itemClosest;
                    }
                }
            }catch(Exception e){}
            a++;
        }

        if(nearestItem==null){
            return false;
        }else{
            this.destinationBlock=nearestItem.getPosition();
            this.thisItem=nearestItem;

            return true;
        }

    }

    public EntityItem getClosestItem(EntityCreature creature, Item item, double distance){
        int a = 0;
        EntityItem closestItem = null;
        while(a<creature.getEntityWorld().loadedEntityList.size()){
            Entity entity = creature.getEntityWorld().loadedEntityList.get(a);

            EntityItem eitem = null;
            try{
                eitem = (EntityItem) entity;
            }catch(Exception e){
                a++;
                continue;
            }

            if(!eitem.getItem().isItemEqual(new ItemStack(item))){
                a++;
                continue;
            }

            if(eitem.getPosition().getDistance(creature.getPosition().getX(),creature.getPosition().getY(),creature.getPosition().getZ())>distance){
                a++;
                continue;
            }



            if(closestItem==null){
                closestItem = eitem;
            }else{
                if(closestItem.getPosition().getDistance(creature.getPosition().getX(),creature.getPosition().getY(),creature.getPosition().getZ())<eitem.getPosition().getDistance(creature.getPosition().getX(),creature.getPosition().getY(),creature.getPosition().getZ())){

                }else{
                    closestItem = eitem;
                }
            }
            a++;
        }

        return closestItem;

    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting()
    {
        return shouldExecute();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        //this.creature.getNavigator().clearPath();
        this.creature.getNavigator().tryMoveToEntityLiving(thisItem,this.speed);
        //this.creature.getNavigator().tryMoveToXYZ((double)(this.destinationBlock.getX()), (double)(this.destinationBlock.getY()), (double)(this.destinationBlock.getZ()), this.speed);
        this.creature.getLookHelper().setLookPosition((double)(this.destinationBlock.getX()), (double)(this.destinationBlock.getY()), (double)(this.destinationBlock.getZ()),creature.getHorizontalFaceSpeed(),creature.getVerticalFaceSpeed());
        /*if(creature.getPosition().distanceSqToCenter(destinationBlock.getX(),destinationBlock.getY(),destinationBlock.getZ())<=0.8){
            System.out.println("EATING");
            this.creature.getNavigator().clearPath();
        }*/
        this.timeoutCounter = 0;
        this.maxStayTicks = this.creature.getRNG().nextInt(this.creature.getRNG().nextInt(1200) + 1200) + 1200;
    }


    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        if(!consuming) {
            this.creature.getNavigator().tryMoveToEntityLiving(thisItem,this.speed);
            this.creature.getLookHelper().setLookPosition((double) (this.destinationBlock.getX()), (double) (this.destinationBlock.getY()), (double) (this.destinationBlock.getZ()), creature.getHorizontalFaceSpeed(), creature.getVerticalFaceSpeed());
        }
        if(creature.getPosition().getDistance(thisItem.getPosition().getX(),thisItem.getPosition().getY(),thisItem.getPosition().getZ())<=1.3){
            consumeItem();
            this.creature.getNavigator().clearPath();
        }

    }

    private boolean consuming = false;
    private void consumeItem(){
        if(!consuming) {
            if(creature.getPosition().getDistance(thisItem.getPosition().getX(),thisItem.getPosition().getY(),thisItem.getPosition().getZ())<=1.3) {
                this.creature.getNavigator().tryMoveToEntityLiving(thisItem,this.speed);
                consuming = true;
                new Wait(1000, true, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        creature.getLookHelper().setLookPositionWithEntity(thisItem, creature.getHorizontalFaceSpeed(), creature.getVerticalFaceSpeed());
                        creature.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1F, 0.9F);
                        creature.getNavigator().tryMoveToEntityLiving(thisItem,speed);
                        creature.getLookHelper().setLookPosition((double) (destinationBlock.getX()), (double) (destinationBlock.getY()), (double) (destinationBlock.getZ()), creature.getHorizontalFaceSpeed(), creature.getVerticalFaceSpeed());

                    }
                });

                new Wait(2000, true, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        creature.getLookHelper().setLookPosition((double) (destinationBlock.getX()), (double) (destinationBlock.getY()), (double) (destinationBlock.getZ()), creature.getHorizontalFaceSpeed(), creature.getVerticalFaceSpeed());
                        creature.getNavigator().tryMoveToEntityLiving(thisItem,speed);
                        thisItem.getEntityWorld().spawnParticle(EnumParticleTypes.ITEM_TAKE, true, thisItem.posX, thisItem.posY, thisItem.posZ, 0.01D, 0.01D, 0.01D, 100);
                        thisItem.setDead();
                        if(creature instanceof EntityAnimal) {
                            if (creature.isChild()) {
                                ((EntityAnimal)creature).addGrowth(1);
                            }
                        }
                        consuming = false;
                        creature.getNavigator().clearPath();

                    }
                });
            }else{
                this.creature.getNavigator().tryMoveToEntityLiving(thisItem,this.speed);
            }
        }
    }


    protected boolean getIsAboveDestination()
    {
        return this.isAboveDestination;
    }
    protected boolean shouldMoveTo(World worldIn, BlockPos pos){
        return !creature.getPosition().equals(pos);
    }
}
