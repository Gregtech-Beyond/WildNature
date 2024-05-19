package com.matez.wildnature.entity;

import com.google.common.collect.Sets;
import com.matez.wildnature.entity.AI.EntityAIAdvancedFollowParent;
import com.matez.wildnature.entity.AI.EntityAIAdvancedMate;
import com.matez.wildnature.entity.AI.EntityAIEatItem;
import com.matez.wildnature.entity.AI.EntityAIMountainClimb;
import com.matez.wildnature.util.handlers.LootTableHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
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
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Set;

public class EntityHCow extends EntityAnimal
{
    private static final DataParameter<Integer> BOOST_TIME = EntityDataManager.<Integer>createKey(EntityHCow.class, DataSerializers.VARINT);
    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.CARROT, Items.POTATO, Items.BEETROOT, Items.WHEAT, Items.BREAD);
    private boolean boosting;
    private int boostTime;
    private int totalBoostTime;
    public int type = 0;
    private ArrayList<Item> eatableItems;

    public EntityHCow(World worldIn)
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
        this.tasks.addTask(1, new EntityAIPanic(this, 0.7D));
        mateAI();
        this.tasks.addTask(3, new EntityAITempt(this, 0.4D, Items.WHEAT, false));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));


    }

    protected void mateAI(){
        this.tasks.addTask(2, new EntityAIAdvancedMate(this,EntityCowMale.class,EntityCowFemale.class, 0.6D,EntityCowChild.class));
        this.tasks.addTask(4, new EntityAIAdvancedFollowParent(this,EntityCowFemale.class, 0.5D));
    }




    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        if(this.getType()==2){
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        }else{
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        }
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
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
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_COW_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_COW_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }



    /**
     * Called when the mob's health reaches 0.
     */


    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableList.ENTITIES_COW;
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == Items.BUCKET && !player.capabilities.isCreativeMode && !this.isChild())
        {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            itemstack.shrink(1);

            if (itemstack.isEmpty())
            {
                player.setHeldItem(hand, new ItemStack(Items.MILK_BUCKET));
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.MILK_BUCKET)))
            {
                player.dropItem(new ItemStack(Items.MILK_BUCKET), false);
            }

            return true;
        }
        else
        {
            return super.processInteract(player, hand);
        }
    }


    public float getEyeHeight()
    {
        return this.isChild() ? this.height : 1.3F;
    }

    public EntityHCow createChild(EntityAgeable ageable)
    {

        EntityCowChild child = new EntityCowChild(this.world);
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
        if(otherAnimal instanceof EntityHCow){
            if(((EntityHCow)otherAnimal).getType()!=this.getType() && ((EntityHCow)otherAnimal).getType() != 2 && this.getType()!=2){
                return this.isInLove() && otherAnimal.isInLove();
            }
        }
        return false;
    }


}