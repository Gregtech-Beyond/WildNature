package com.matez.wildnature.entity;

import com.google.common.collect.Sets;
import com.matez.wildnature.Main;
import com.matez.wildnature.entity.AI.EntityAIAttackWhenSomeoneNear;
import com.matez.wildnature.entity.AI.EntityAIEatItem;
import com.matez.wildnature.entity.AI.EntityAIRunOver;
import com.matez.wildnature.init.ModItems;
import com.matez.wildnature.util.handlers.LootTableHandler;
import com.matez.wildnature.util.handlers.SoundHandler;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.*;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Set;

public class EntityCustomPlayer extends EntityCreature
{


    public EntityCustomPlayer(World worldIn)
    {
        super(worldIn);
        this.setSize(1F, 1.9F);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.4D, true));
        //this.targetTasks.addTask(3, new EntityAIChase<>(this, EntityPlayer.class, false));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.tasks.addTask(4,new EntityAIAttackWhenSomeoneNear(this,EntityPlayer.class,6));

    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.60D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);

    }

    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, and Boats are generally "steered" by the controlling passenger.
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

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        if (damageSourceIn == DamageSource.ON_FIRE)
        {
            return SoundEvents.ENTITY_PLAYER_HURT_ON_FIRE;
        }
        else
        {
            return damageSourceIn == DamageSource.DROWN ? SoundEvents.ENTITY_PLAYER_HURT_DROWN : SoundEvents.ENTITY_PLAYER_HURT;
        }
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    public SoundCategory getSoundCategory()
    {
        return SoundCategory.PLAYERS;
    }

    protected SoundEvent getFallSound(int heightIn)
    {
        return heightIn > 4 ? SoundEvents.ENTITY_PLAYER_BIG_FALL : SoundEvents.ENTITY_PLAYER_SMALL_FALL;
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




    /**
     * Called when the mob's health reaches 0.
     */


    /**
     * Returns true if the pig is saddled.
     */




    /**
     * Called when a lightning bolt hits the entity.
     */
    public void onStruckByLightning(EntityLightningBolt lightningBolt)
    {

    }


    public EntityCustomPlayer createChild(EntityAgeable ageable)
    {
        return null;
    }



}