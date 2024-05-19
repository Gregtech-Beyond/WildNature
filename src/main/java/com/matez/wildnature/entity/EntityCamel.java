package com.matez.wildnature.entity;

import com.google.common.collect.Sets;
import com.matez.wildnature.Main;
import com.matez.wildnature.entity.AI.EntityAIAdvancedFollowParent;
import com.matez.wildnature.entity.AI.EntityAIAdvancedMate;
import com.matez.wildnature.entity.AI.EntityAIEatItem;
import com.matez.wildnature.entity.AI.EntityAIMountainClimb;
import com.matez.wildnature.util.handlers.LootTableHandler;
import com.matez.wildnature.util.handlers.SoundHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
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
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Set;

public class EntityCamel extends EntityAnimal
{
    private static final DataParameter<Integer> BOOST_TIME = EntityDataManager.<Integer>createKey(EntityCamel.class, DataSerializers.VARINT);
    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.CARROT, Items.POTATO, Items.BEETROOT, Items.WHEAT, Items.BREAD);
    private boolean boosting;
    private int boostTime;
    private int totalBoostTime;
    public int type = 0;
    private ArrayList<Item> eatableItems;

    public EntityCamel(World worldIn)
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
        eatableItems = new ArrayList<>(ForgeRegistries.ITEMS.getValuesCollection());
        this.tasks.addTask(0, new EntityAISwimming(this));
        mateAI();
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, false, TEMPTATION_ITEMS));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(5,new EntityAIEatItem(this,0.7D,4,eatableItems));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.1D));

    }

    protected void mateAI(){
        this.tasks.addTask(2, new EntityAIAdvancedMate(this,EntityCamelMale.class,EntityCamelFemale.class, 1.0D,EntityCamelChild.class));
        this.tasks.addTask(3, new EntityAIAdvancedFollowParent(this,EntityCamelFemale.class, 1.1D));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        if(isChild()){
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        }else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        }
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.50D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);

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
        {
            switch (Main.generateRandomInt(0,3)){
                case 0: case 2:{
                    return SoundEvents.ENTITY_LLAMA_SWAG;
                }
                case 3:{
                    return SoundHandler.ENTITY_CAMEL_GROWL;
                }
            }
        }
        return null;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        {
            switch (Main.generateRandomInt(0,1)){
                case 0:{
                    return SoundHandler.ENTITY_CAMEL_HURT1;
                }
                case 1:{
                    return SoundHandler.ENTITY_CAMEL_HURT2;
                }
            }
        }
        return null;
    }

    protected SoundEvent getDeathSound()
    {
        {
           return SoundHandler.ENTITY_CAMEL_DEATH;
        }
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_LLAMA_STEP, 0.4F, 0.6F);
    }






    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableHandler.CAMEL_LOOT;
    }





    /**
     * Called when a lightning bolt hits the entity.
     */
    public void onStruckByLightning(EntityLightningBolt lightningBolt)
    {

    }


    public EntityCamel createChild(EntityAgeable ageable)
    {

        EntityCamelChild child = new EntityCamelChild(this.world);
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
        if(otherAnimal instanceof EntityCamel){
            if(((EntityCamel)otherAnimal).getType()!=this.getType() && ((EntityCamel)otherAnimal).getType() != 2 && this.getType()!=2){
                return this.isInLove() && otherAnimal.isInLove();
            }
        }
        return false;
    }


}