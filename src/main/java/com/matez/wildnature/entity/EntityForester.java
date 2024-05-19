package com.matez.wildnature.entity;

import com.matez.wildnature.entity.AI.*;
import com.matez.wildnature.init.BiomeInit;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class EntityForester extends EntityCustomPlayer
{

    private Biome[] canFollowOnBiomes;
    private EntityAIForesterFollowPlayer foresterFollowPlayer;
    private EntityAIForesterAttack foresterAttack;
    private BlockPos homePos;

    public EntityForester(World worldIn)
    {
        super(worldIn);
        this.setSize(0.7F, 1.9F);
        this.setFollowOnBiomes(BiomeInit.BIALOWIEZA_FOREST,BiomeInit.SNOWY_BIALOWIEZA_FOREST);
        setAlwaysRenderNameTag(false);
    }





    public EntityAIForesterAttack getForesterAttack() {
        return foresterAttack;
    }

    public EntityAIForesterFollowPlayer getForesterFollowPlayer() {
        return foresterFollowPlayer;
    }


    public void setFollowOnBiomes(Biome... biomes){
        if(canFollowOnBiomes==null){

        }else{
            //this.targetTasks.removeTask(foresterFollowPlayer);
        }
        //this.foresterFollowPlayer = new EntityAIForesterFollowPlayer(this,0.7F,20,100,biomes);
        this.foresterAttack = new EntityAIForesterAttack(this,EntityPlayer.class,300,biomes, Blocks.LOG,Blocks.LOG2,Blocks.LEAVES,Blocks.LEAVES2);
        //this.targetTasks.addTask(2, foresterFollowPlayer);
        this.targetTasks.addTask(1,foresterAttack);
        this.canFollowOnBiomes=biomes;
    }

    public void setHomePos(BlockPos homePos){
        this.tasks.addTask(6, new EntityAIBackHome(this,homePos,0.8F));
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWanderAvoidWater(this,1.0D));
        this.tasks.addTask(7,new EntityAIShiftToClosest(this,4));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.2D, true));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        //this.tasks.addTask(5,new EntityAIAttackWhenSomeoneNear(this, EntityMob.class,6));
        //this.tasks.addTask(1,new EntityAISwordSetter(this, Items.IRON_SWORD));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 7.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest2(this, EntityLiving.class, 10.0F, 1.0F));



    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);

    }

    @Override
    protected PathNavigate createNavigator(World worldIn) {
        return super.createNavigator(worldIn);
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
        return 5;
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


    public EntityForester createChild(EntityAgeable ageable)
    {
        return null;
    }


    @Override
    public void onUpdate() {
        super.onUpdate();
        if(homePos==null){
            if(getPosition().getX()!=0 && getPosition().getY()!=0 && getPosition().getZ()!=0){
                homePos=getPosition();
                //setHomePos(homePos);
            }
        }
    }
}