package com.matez.wildnature.entity.AI;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.EntityDuck;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityAIGoToHot extends EntityAIBase {
    EntityCreature thisCreature;
    float minTemperature, maxTemperature, prefTemp;
    BlockPos startBlockPos,wantedPos;
    float movingSpeed;
    int random;
    boolean canMove = false,wasMoving=false,notified=false;
    int prefY;
    int sameFacing = 0;
    EnumFacing facing,oldFacing,notifiedFacing;
    int chance = -1;
    public EntityAIGoToHot(EntityCreature creature, float minTemp, float maxTemp,float prefTemp,float movingSpeed){
        this.thisCreature = creature;
        this.minTemperature = minTemp;
        this.maxTemperature = maxTemp;
        this.prefTemp = prefTemp;
        this.movingSpeed = movingSpeed;
    }
    @Override
    public boolean shouldExecute() {
        float currentTemp = checkTemperature(this.thisCreature);
        if(!thisCreature.getNavigator().noPath()){
            return false;
        }
        if(currentTemp>maxTemperature || currentTemp<minTemperature){
            if(wasMoving){
                return true;
            }

            if(chance!=-7){
                chance=Main.generateRandomInt(0,30);
            }else{
                chance=0;
            }
            if(chance==0){
                return true;
            }else{
                return false;
            }
        }else{
            if(startBlockPos!=null){

            }
            canMove = false;
            startBlockPos=null;
            wasMoving=false;
            notified=false;
            return false;
        }
    }

    @Override
    public boolean shouldContinueExecuting() {
        return super.shouldContinueExecuting();
    }

    @Override
    public void startExecuting() {

        if(startBlockPos==null){
            random = Main.generateRandomInt(1,4);
            startBlockPos=thisCreature.getPosition();
        }


        wantedPos = checkWhereIsBetter(thisCreature.getPosition());
        int prefY = wantedPos.getY();

        if(!wasMoving && !notified){
            notifyOtherDucks(10,this.thisCreature,facing);
        }

        if(canMove) {
            this.thisCreature.getNavigator().tryMoveToXYZ(wantedPos.getX(), this.thisCreature.getPosition().getY(), wantedPos.getZ(), movingSpeed);
            if(this.thisCreature.getPosition().getY()!=prefY){
                if(this.thisCreature.getPosition().getY()>prefY){
                    switch(Main.generateRandomInt(0,10)){
                        case 0:
                            moveVertically(thisCreature,-0.1F);
                    }

                }else{
                    moveVertically(thisCreature,0.1F);
                }

            }else{
                this.thisCreature.getNavigator().tryMoveToXYZ(wantedPos.getX(), this.thisCreature.getPosition().getY(), wantedPos.getZ(), movingSpeed);
            }

            if(this.thisCreature.onGround){
                this.thisCreature.getNavigator().clearPath();
                moveVertically(thisCreature,1F);
                beOnGround=false;
            }else{
                if(!beOnGround) {
                    beOnGround=true;

                }
            }

        }

        wasMoving=true;
        canMove = true;
    }
    boolean beOnGround = false;

    @Override
    public void updateTask() {
        if(canMove) {
            this.thisCreature.getNavigator().tryMoveToXYZ(wantedPos.getX(), this.thisCreature.getPosition().getY(), wantedPos.getZ(), movingSpeed);
            if(this.thisCreature.getPosition().getY()!=prefY){
                if(this.thisCreature.getPosition().getY()>prefY){
                    switch(Main.generateRandomInt(0,10)){
                        case 0:
                            moveVertically(thisCreature,-0.1F);
                    }

                }else{
                    moveVertically(thisCreature,0.1F);
                }

            }else{
                this.thisCreature.getNavigator().tryMoveToXYZ(wantedPos.getX(), this.thisCreature.getPosition().getY(), wantedPos.getZ(), movingSpeed);
            }

            if(this.thisCreature.onGround){
                this.thisCreature.getNavigator().clearPath();
                moveVertically(thisCreature,1F);
                beOnGround=false;
            }else{
                if(!beOnGround) {
                    beOnGround=true;

                }
            }

        }
    }

    /*private boolean goUpDown(EntityCreature creature, int y){
        int a = y-creature.getPosition().getY();//jak wysokość creature to 100 a wymagana to 150, "a" będzie 50
        int b = 0;
        boolean moving = false;

        if(a>0) {
            while (a > b) {
                moving = this.thisCreature.getNavigator().tryMoveToXYZ(creature.getPosition().getX(), creature.getPosition().getY() + 1, creature.getPosition().getZ(), movingSpeed);

                System.out.println("GoUP " + a + " " + b);
                b++;
            }
        }else if(a<0) {
            while (a < b) {
                moving = this.thisCreature.getNavigator().tryMoveToXYZ(creature.getPosition().getX(), creature.getPosition().getY() - 1, creature.getPosition().getZ(), movingSpeed);
                System.out.println("GoDOWN " + a + " " + b);
                a++;
            }
        }else{
            System.out.println("Good!");
        }

        return moving;
    }*/
    private int ax = 0;

    public BlockPos checkWhereIsBetter(BlockPos entityPos){
        float currentTemp = checkTemperature(this.thisCreature);
        boolean tooCold = false;
        if(currentTemp>maxTemperature){
            tooCold = false;
        }else if(currentTemp<minTemperature){
            tooCold = true;
        }
        BlockPos checkPos = null;
        int timer = 1;
        int change = 1;
        while(true) {
            if (tooCold) {
                if (checkTemperature(this.thisCreature.getEntityWorld(), getHigherBlock(thisCreature.getEntityWorld(), entityPos.north(change * timer))) > currentTemp) {
                    checkPos = getHigherBlock(thisCreature.getEntityWorld(),entityPos.north(change).up(30));
                    facing = EnumFacing.NORTH;
                    break;
                } else if (checkTemperature(this.thisCreature.getEntityWorld(), getHigherBlock(thisCreature.getEntityWorld(), entityPos.south(change * timer))) > currentTemp) {
                    checkPos = getHigherBlock(thisCreature.getEntityWorld(),entityPos.south(change).up(30));
                    facing = EnumFacing.SOUTH;
                    break;
                } else if (checkTemperature(this.thisCreature.getEntityWorld(), getHigherBlock(thisCreature.getEntityWorld(), entityPos.west(change * timer))) > currentTemp) {
                    checkPos = getHigherBlock(thisCreature.getEntityWorld(),entityPos.west(change).up(30));
                    facing = EnumFacing.WEST;
                    break;
                } else if (checkTemperature(this.thisCreature.getEntityWorld(), getHigherBlock(thisCreature.getEntityWorld(), entityPos.east(change * timer))) > currentTemp) {
                    checkPos = getHigherBlock(thisCreature.getEntityWorld(),entityPos.east(change).up(30));
                    facing = EnumFacing.EAST;
                    break;
                } else {
                    timer++;
                    if (timer >= 50) {
                        checkPos = randomizePosition(random, entityPos);
                        break;
                    }
                }
            } else {
                if (checkTemperature(this.thisCreature.getEntityWorld(), getHigherBlock(thisCreature.getEntityWorld(), entityPos.north(change * timer))) < currentTemp) {
                    checkPos = getHigherBlock(thisCreature.getEntityWorld(),entityPos.north(change).up(30));
                    facing = EnumFacing.NORTH;
                    break;
                } else if (checkTemperature(this.thisCreature.getEntityWorld(), getHigherBlock(thisCreature.getEntityWorld(), entityPos.south(change * timer))) < currentTemp) {
                    checkPos = getHigherBlock(thisCreature.getEntityWorld(),entityPos.south(change).up(30));
                    facing = EnumFacing.SOUTH;
                    break;
                } else if (checkTemperature(this.thisCreature.getEntityWorld(), getHigherBlock(thisCreature.getEntityWorld(), entityPos.west(change * timer))) < currentTemp) {
                    checkPos = getHigherBlock(thisCreature.getEntityWorld(),entityPos.west(change).up(30));
                    facing = EnumFacing.WEST;
                    break;
                } else if (checkTemperature(this.thisCreature.getEntityWorld(), getHigherBlock(thisCreature.getEntityWorld(), entityPos.east(change * timer))) < currentTemp) {
                    checkPos = getHigherBlock(thisCreature.getEntityWorld(),entityPos.east(change).up(30));
                    facing = EnumFacing.EAST;
                    break;
                } else {
                    timer++;
                    if (timer >= 50) {
                        checkPos = randomizePosition(random, entityPos);
                        break;
                    }
                }
            }
        }
        if(oldFacing!=null){
            if(oldFacing!=facing){
                ax++;

                if(ax<5){
                    int rand = 0;
                    if(oldFacing==EnumFacing.NORTH){
                        rand = 1;
                    }else if(oldFacing==EnumFacing.SOUTH){
                        rand = 2;
                    }else if(oldFacing==EnumFacing.WEST){
                        rand = 3;
                    }else if(oldFacing==EnumFacing.EAST){
                        rand = 4;
                    }
                    checkPos=randomizePosition(rand,entityPos);
                }else{
                    ax=0;
                }
            }else{
                ax=0;
                sameFacing++;
            }
        }

        if(oldFacing!=null) {
            if (sameFacing <= 10) {
                int rand = 0;
                if (oldFacing == EnumFacing.NORTH) {
                    rand = 1;
                } else if (oldFacing == EnumFacing.SOUTH) {
                    rand = 2;
                } else if (oldFacing == EnumFacing.WEST) {
                    rand = 3;
                } else if (oldFacing == EnumFacing.EAST) {
                    rand = 4;
                }
                checkPos = randomizePosition(rand, entityPos);
                sameFacing = 0;
                notifiedFacing=null;
            }
        }

        if(notifiedFacing!=null){
            int rand = 0;
            if (notifiedFacing == EnumFacing.NORTH) {
                rand = 1;
            } else if (notifiedFacing == EnumFacing.SOUTH) {
                rand = 2;
            } else if (notifiedFacing == EnumFacing.WEST) {
                rand = 3;
            } else if (notifiedFacing == EnumFacing.EAST) {
                rand = 4;
            }
            checkPos = randomizePosition(rand, entityPos);
            facing=notifiedFacing;

        }

        oldFacing = facing;
        return checkPos;

    };
    public void notifyOtherDucks(int distance,EntityCreature creature,EnumFacing facing){
        int a=0;

        while(a<creature.getEntityWorld().loadedEntityList.size()) {
            Entity entity = creature.getEntityWorld().loadedEntityList.get(a);

            EntityDuck duck = null;
            try {
                duck = (EntityDuck) entity;
            } catch (Exception e) {
                a++;
                continue;
            }

            if(duck==(EntityDuck)creature){
                a++;
                continue;
            }


            if (duck.getPosition().getDistance(creature.getPosition().getX(), creature.getPosition().getY(), creature.getPosition().getZ()) > distance) {
                a++;
                continue;
            }

            ((EntityAIGoToHot)duck.aiGoToHot).notifyDuck(facing);

            a++;
        }
    }
    private void moveVertically(EntityCreature creature,float y){
        Vec3d pos = creature.getPositionVector();
        creature.motionY=y;

    }

    private void notifyDuck(EnumFacing facing){
        notified=true;
        notifiedFacing=facing;

    }

    private BlockPos randomizePosition(int random,BlockPos pos){
        BlockPos randomPos = pos;
        int change = 1;
        if(random==1){
            randomPos = getHigherBlock(thisCreature.getEntityWorld(),pos.north(change));
        }else if(random==2){
            randomPos = getHigherBlock(thisCreature.getEntityWorld(),pos.south(change));
        }else if(random==3){
            randomPos = getHigherBlock(thisCreature.getEntityWorld(),pos.west(change));
        }else if(random==4){
            randomPos = getHigherBlock(thisCreature.getEntityWorld(),pos.east(change));
        }else{
            randomizePosition(Main.generateRandomInt(1,4),pos);
        }
        return randomPos.up(30);
    }

    private float checkTemperature(EntityCreature creature){
        return creature.getEntityWorld().getBiome(creature.getPosition()).getTemperature(creature.getPosition());
    }
    private float checkTemperature(World world, BlockPos pos){
        return world.getBiome(pos).getTemperature(pos);
    }

    private BlockPos getHigherBlock(World world, BlockPos pos){
        int max = world.getHeight();
        while(max>0){
            BlockPos bp = new BlockPos(pos.getX(), max, pos.getZ());
            if(!world.getBlockState(bp).getBlock().equals(Blocks.AIR)){
                return bp.up(30);
            }
            max--;
        }
        return pos.up(30);
    }


}
