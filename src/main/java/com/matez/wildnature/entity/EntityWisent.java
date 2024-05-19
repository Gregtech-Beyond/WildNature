package com.matez.wildnature.entity;

import com.google.common.collect.Sets;
import com.matez.wildnature.Main;
import com.matez.wildnature.entity.AI.EntityAIAdvancedFollowParent;
import com.matez.wildnature.entity.AI.EntityAIAdvancedMate;
import com.matez.wildnature.entity.AI.EntityAIAttackWhenSomeoneNear;
import com.matez.wildnature.entity.AI.EntityAIEatItem;
import com.matez.wildnature.util.handlers.LootTableHandler;
import com.matez.wildnature.util.handlers.SoundHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Set;

public class EntityWisent extends EntityAnimal
{
    private static final DataParameter<Integer> BOOST_TIME = EntityDataManager.<Integer>createKey(EntityWisent.class, DataSerializers.VARINT);
    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.WHEAT, Items.POTATO);
    private boolean boosting;
    private int boostTime;
    private int totalBoostTime;
    public int type = 0;
    private ArrayList<Item> eatableItems;

    public EntityWisent(World worldIn)
    {
        super(worldIn);
        this.setSize(1F, 2F);
    }

    public void setType(int type){
        this.type = type;
    }

    public void makeChild(){
        this.setGrowingAge(-24000);
    }

    protected void initEntityAI()
    {
        eatableItems=new ArrayList<>();
        eatableItems.add(Items.WHEAT);
        eatableItems.add(Items.POTATO);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.7D));
        mateAI();
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(5,new EntityAIEatItem(this,0.2D,5,eatableItems));
        this.tasks.addTask(4,new EntityAIAttackWhenSomeoneNear(this, EntityPlayer.class,3));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
    }

    protected void mateAI(){
        this.tasks.addTask(2, new EntityAIAdvancedMate(this,EntityWisentMale.class,EntityWisentFemale.class, 0.6D,EntityWisentChild.class));
        this.tasks.addTask(3, new EntityAIAdvancedFollowParent(this,EntityWisentFemale.class, 0.4D));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        if(isChild()){
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
        }else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(65.0D);
        }
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);

    }





    /**
     * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
     * by a player and the player is holding a carrot-on-a-stick
     */

    public boolean canAttackClass(Class <? extends EntityLivingBase> cls)
    {
        return true;
    }
    public int getMaxSpawnedInChunk()
    {
        return 7;
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

        if (flag)
        {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    public void notifyDataManagerChange(DataParameter<?> key)
    {
        if (BOOST_TIME.equals(key) && this.world.isRemote)
        {
            this.boosting = true;
            this.boostTime = 0;
            this.totalBoostTime = ((Integer)this.dataManager.get(BOOST_TIME)).intValue();
        }

        super.notifyDataManagerChange(key);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(BOOST_TIME, Integer.valueOf(0));
    }


    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
    }

    protected SoundEvent getAmbientSound()
    {
        if(Main.generateRandomInt(0,1)==0){
            return SoundHandler.ENTITY_BISON_SNORT1;
        }else{
            return SoundHandler.ENTITY_BISON_SNORT2;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        {
            return SoundHandler.ENTITY_BISON_HURT;
        }
    }

    protected SoundEvent getDeathSound()
    {
        {
            return SoundHandler.ENTITY_BISON_DEATH;
        }
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.4F, 0.5F);
    }






    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableHandler.WISENT_LOOT;
    }




    /**
     * Called when a lightning bolt hits the entity.
     */
    public void onStruckByLightning(EntityLightningBolt lightningBolt)
    {

    }



    public EntityWisent createChild(EntityAgeable ageable)
    {

        EntityWisentChild child = new EntityWisentChild(this.world);
        child.setType(2);
        return child;
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack)
    {
        return TEMPTATION_ITEMS.contains(stack.getItem());
    }

    public int getType() {
        return type;
    }

    @Override
    public boolean canMateWith(EntityAnimal otherAnimal)
    {
        if(otherAnimal instanceof EntityWisent){
            if(((EntityWisent)otherAnimal).getType()!=this.getType() && ((EntityWisent)otherAnimal).getType() != 2 && this.getType()!=2){
                return this.isInLove() && otherAnimal.isInLove();
            }
        }
        return false;
    }


}