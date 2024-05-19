package com.matez.wildnature.entity;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Set;
import javax.annotation.Nullable;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.AI.*;
import com.matez.wildnature.util.handlers.LootTableHandler;
import com.matez.wildnature.util.handlers.SoundHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityFlying;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityDuck extends EntityAnimal implements EntityFlying
{
    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
    //public float wingRotation;
    public float destPos;

    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    public float flapping = 1.0F;
    /** The time until the next egg is spawned. */
    public int timeUntilNextEgg;
    public int type = 0;
    public EntityAnimal mate,baby;
    private ArrayList<Item> eatableItems;
    public EntityAIBase aiGoToHot;

    public EntityDuck(World worldIn)
    {
        super(worldIn);
        this.setSize(0.4F, 0.7F);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.setPathPriority(PathNodeType.WATER, 1.0F);

        //type = 0 (male)
        //type = 1 (female)
        //type = 2 (child)
    }


    protected PathNavigate createNavigator(World worldIn)
    {
        if (!isChild()) {
            this.moveHelper = new EntityFlyHelper(this);
            b = true;
        }
        PathNavigateFlying pathnavigateflying = new PathNavigateFlying(this, worldIn);
        pathnavigateflying.setCanOpenDoors(false);
        pathnavigateflying.setCanFloat(true);
        pathnavigateflying.setCanEnterDoors(false);
        pathnavigateflying.setSpeed(1.3D);
        if (!isChild()) {
            this.moveHelper = new EntityFlyHelper(this);
            b = true;
        }
        return pathnavigateflying;
    }



    public void setType(int type){
        this.type = type;
    }

    protected void initEntityAI()
    {
        eatableItems = new ArrayList<>();
        eatableItems.add(Items.WHEAT_SEEDS);
        eatableItems.add(Items.MELON_SEEDS);
        eatableItems.add(Items.PUMPKIN_SEEDS);
        eatableItems.add(Items.BEETROOT_SEEDS);
        aiGoToHot = new EntityAIGoToHot(this,0.35F,0.75F,0.45F,1.1F);
        this.tasks.addTask(0, new EntityAIProffesionalSwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.1D));
        this.tasks.addTask(2, new EntityAIAdvancedMate(this,EntityDuckMale.class,EntityDuckFemale.class, 1.0D,EntityDuckChild.class));
//        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, false, TEMPTATION_ITEMS));
        this.tasks.addTask(4, new EntityAIAdvancedFollowParent(this,EntityDuckFemale.class, 1.1D));
        //this.tasks.addTask(4, new EntityAIFollow(this,EntityDuckFemale.class, 1.1D));
        //this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask( 7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(7, aiGoToHot);
        this.tasks.addTask(5,new EntityAIEatItem(this,0.7D,10,eatableItems));
        if(!this.isChild()) {
            this.targetTasks.addTask(5, new EntityAIRunOver(this, EntityPlayer.class, 15, 0.90, 1));
        }
    }

    public float getEyeHeight()
    {
        return this.height;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        if(isChild()){
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3.0D);
        }else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        }
        this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(1.3D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.70000000298023224D);
    }



    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    protected float playFlySound(float p_191954_1_)
    {
        this.playSound(SoundEvents.ENTITY_PARROT_FLY, 0.45F, (float)(Main.generateRandomInt(8,12)/10));
        return p_191954_1_ + this.flapSpeed / 4;
    }

    protected boolean makeFlySound()
    {
        return true;
    }

    private boolean b = false;
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        calculateFlapping();
    }

    private void calculateFlapping()
    {
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed = (float)((double)this.flapSpeed + (double)(this.onGround ? -1 : 4) * 0.3D);
        this.flapSpeed = MathHelper.clamp(this.flapSpeed, 0.0F, 1.0F);

        if (!this.onGround && this.flapping < 1.0F)
        {
            this.flapping = 1.0F;
        }

        this.flapping = (float)((double)this.flapping * 0.9D);

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        this.flap += this.flapping * 2.0F;
    }

    public void fall(float distance, float damageMultiplier)
    {
    }

    protected SoundEvent getAmbientSound()
    {
        if(getType()==2){
            return SoundHandler.ENTITY_DUCK_CHICK;
        }else {
            return SoundHandler.ENTITY_DUCK_QUACK;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundHandler.ENTITY_DUCK_SCARED;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_PARROT_STEP, 0.15F, 0.3F);
    }




    @Nullable
    protected ResourceLocation getLootTable()
    {
        if(getType()==0){
            return LootTableHandler.DUCK_MALE_LOOT;
        }else if(getType()==1){
            return LootTableHandler.DUCK_FEMALE_LOOT;
        }else{
            return LootTableHandler.DUCK_BABY_LOOT;
        }
    }



    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack)
    {
        return TEMPTATION_ITEMS.contains(stack.getItem());
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints(EntityPlayer player)
    {
        return this.isChickenJockey() ? 10 : super.getExperiencePoints(player);
    }



    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);

        if (compound.hasKey("EggLayTime"))
        {
            this.timeUntilNextEgg = compound.getInteger("EggLayTime");
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("EggLayTime", this.timeUntilNextEgg);
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return this.isChickenJockey() && !this.isBeingRidden();
    }

    public void updatePassenger(Entity passenger)
    {
        super.updatePassenger(passenger);
        float f = MathHelper.sin(this.renderYawOffset * 0.017453292F);
        float f1 = MathHelper.cos(this.renderYawOffset * 0.017453292F);
        float f2 = 0.1F;
        float f3 = 0.0F;
        passenger.setPosition(this.posX + (double)(0.1F * f), this.posY + (double)(this.height * 0.5F) + passenger.getYOffset() + 0.0D, this.posZ - (double)(0.1F * f1));

        if (passenger instanceof EntityLivingBase)
        {
            ((EntityLivingBase)passenger).renderYawOffset = this.renderYawOffset;
        }
    }

    /**
     * Determines if this chicken is a jokey with a zombie riding it.
     */
    public boolean isChickenJockey()
    {
        return false;
    }

    public int getType(){
        return type;
    }

    @Override
    public boolean canMateWith(EntityAnimal otherAnimal)
    {
        if(otherAnimal instanceof EntityDuck){
            if(((EntityDuck)otherAnimal).getType()!=this.getType() && ((EntityDuck)otherAnimal).getType() != 2 && this.getType()!=2){
                return this.isInLove() && otherAnimal.isInLove();
            }
        }
        return false;
    }

    public EntityAgeable createChild(EntityAgeable ageable)
    {
        EntityDuckChild child = new EntityDuckChild(this.world);
        child.setType(2);
        return child;
    }

    @Override
    protected void onGrowingAdult() {
        super.onGrowingAdult();
    }
}