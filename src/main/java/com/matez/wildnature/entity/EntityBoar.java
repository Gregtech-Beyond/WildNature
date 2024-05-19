package com.matez.wildnature.entity;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Set;
import javax.annotation.Nullable;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.AI.EntityAIAttackWhenSomeoneNear;
import com.matez.wildnature.entity.AI.EntityAIChase;
import com.matez.wildnature.entity.AI.EntityAIEatItem;
import com.matez.wildnature.entity.AI.EntityAIRunOver;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.handlers.LootTableHandler;
import com.matez.wildnature.util.handlers.SoundHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
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
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityBoar extends EntityAnimal
{
    private static final DataParameter<Integer> BOOST_TIME = EntityDataManager.<Integer>createKey(EntityBoar.class, DataSerializers.VARINT);
    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.CARROT, Items.POTATO, Items.BEETROOT, ModItems.ACORN, ModItems.CORN);
    private boolean boosting;
    private int boostTime;
    private int totalBoostTime;
    private ArrayList<Item> eatableItems;

    public EntityBoar(World worldIn)
    {
        super(worldIn);
        this.setSize(1F, 1F);
    }

    protected void initEntityAI()
    {
        eatableItems = new ArrayList<>();
        eatableItems.add(ModItems.ACORN);
        eatableItems.add(ModItems.CORN);
        eatableItems.add(Items.CARROT);
        eatableItems.add(Items.POTATO);
        eatableItems.add(Items.BEETROOT);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, true, TEMPTATION_ITEMS));
        this.tasks.addTask(6, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.4D, true));
        //this.targetTasks.addTask(3, new EntityAIChase<>(this, EntityPlayer.class, false));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(5, new EntityAIRunOver(this,EntityPlayer.class,40,0.90,1.8));
        this.tasks.addTask(5,new EntityAIEatItem(this,0.7D,10,eatableItems));
        this.tasks.addTask(4,new EntityAIAttackWhenSomeoneNear(this,EntityPlayer.class,6));

    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.40D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);

    }

    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, and Boats are generally "steered" by the controlling passenger.
     */
    @Nullable
    public Entity getControllingPassenger()
    {
        return this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
    }

    /**
     * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
     * by a player and the player is holding a carrot-on-a-stick
     */
    public boolean canBeSteered()
    {
        return false;
    }

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

    public static void registerFixesPig(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityBoar.class);
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
        switch(Main.generateRandomInt(0,5)){
            case 0:
                return SoundHandler.ENTITY_BOAR_OINK;
            case 1:
                return SoundHandler.ENTITY_BOAR_OINK2;
            case 2:
                return SoundHandler.ENTITY_BOAR_OINK3;
            case 3:
                return SoundHandler.ENTITY_BOAR_OINK4;
            case 4:
                return SoundHandler.ENTITY_BOAR_SNORT;
            case 5:
                return SoundHandler.ENTITY_BOAR_SNORT2;
        }
        return null;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        switch(Main.generateRandomInt(0,1)){
            case 0:
                return SoundHandler.ENTITY_BOAR_SCARED;
            case 1:
                return SoundHandler.ENTITY_BOAR_SCARED2;
        }
        return null;
    }

    protected SoundEvent getDeathSound()
    {
        switch(Main.generateRandomInt(0,1)){
            case 0:
                return SoundHandler.ENTITY_BOAR_DEATH;
            case 1:
                return SoundHandler.ENTITY_BOAR_DEATH2;
        }
        return null;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.25F, 0.6F);
    }



    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);

        if (!this.world.isRemote)
        {
            if (this.getSaddled())
            {
                this.dropItem(Items.SADDLE, 1);
            }
        }
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableHandler.BOAR_LOOT;
    }

    /**
     * Returns true if the pig is saddled.
     */
    public boolean getSaddled()
    {
        return false;
    }




    /**
     * Called when a lightning bolt hits the entity.
     */
    public void onStruckByLightning(EntityLightningBolt lightningBolt)
    {

    }

    public void travel(float strafe, float vertical, float forward)
    {
        Entity entity = this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);

        if (this.isBeingRidden() && this.canBeSteered())
        {
            this.rotationYaw = entity.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = entity.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.renderYawOffset = this.rotationYaw;
            this.rotationYawHead = this.rotationYaw;
            this.stepHeight = 1.0F;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (this.boosting && this.boostTime++ > this.totalBoostTime)
            {
                this.boosting = false;
            }

            if (this.canPassengerSteer())
            {
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.225F;

                if (this.boosting)
                {
                    f += f * 1.15F * MathHelper.sin((float)this.boostTime / (float)this.totalBoostTime * (float)Math.PI);
                }

                this.setAIMoveSpeed(f);
                super.travel(0.0F, 0.0F, 1.0F);
            }
            else
            {
                this.motionX = 0.0D;
                this.motionY = 0.0D;
                this.motionZ = 0.0D;
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.posX - this.prevPosX;
            double d0 = this.posZ - this.prevPosZ;
            float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;

            if (f1 > 1.0F)
            {
                f1 = 1.0F;
            }

            this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        }
        else
        {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.travel(strafe, vertical, forward);
        }
    }


    public boolean boost()
    {
        if (this.boosting)
        {
            return false;
        }
        else
        {
            this.boosting = true;
            this.boostTime = 0;
            this.totalBoostTime = this.getRNG().nextInt(841) + 140;
            this.getDataManager().set(BOOST_TIME, Integer.valueOf(this.totalBoostTime));
            return true;

        }
    }

    public EntityBoar createChild(EntityAgeable ageable)
    {

        return new EntityBoar(this.world);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack)
    {
        return TEMPTATION_ITEMS.contains(stack.getItem());
    }


}