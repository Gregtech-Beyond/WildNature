package com.matez.wildnature.entity.AI;

import com.matez.wildnature.Main;
import net.minecraft.block.Block;
import net.minecraft.command.server.CommandMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.biome.Biome;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;

public class EntityAIForesterAttack extends EntityAIBase {
    EntityCreature creature;
    EntityLivingBase thisOneAttack;
    Class<? extends Entity> target;
    double distance;
    ArrayList<Block> cannotBreakThis;
    ArrayList<EntityPlayer> suspectedForBreak = new ArrayList<>();
    ArrayList<EntityPlayer> players;
    ArrayList<EntityPlayer> warned = new ArrayList<>();
    ArrayList<EntityPlayer> firstWarned = new ArrayList<>();
    private final ArrayList<Biome> followingBiomes;

    public EntityAIForesterAttack(EntityCreature creature, Class<? extends Entity> target, double distance, Biome[] canFollowOnBiomes, Block... cannotBreakThisOnes){
        this.creature = creature;
        this.target= target;
        this.distance = distance;
        this.cannotBreakThis=new ArrayList<>(Arrays.asList(cannotBreakThisOnes));
        if(canFollowOnBiomes==null){
            this.followingBiomes=new ArrayList<>();
        }else {
            this.followingBiomes = new ArrayList<>(Arrays.asList(canFollowOnBiomes));
        }
    }


    @Override
    public boolean shouldExecute() {
        return this.creature.getEntityWorld().getClosestPlayerToEntity(creature,distance)!=null;
    }

    public ArrayList<EntityPlayer> getPlayers() {
        List<Entity> entities = creature.getEntityWorld().getLoadedEntityList();
        players = new ArrayList<>();
        int x = 0;
        while(x<entities.size()){
            if(entities.get(x) instanceof EntityPlayer){

            }else{
                x++;
                continue;
            }

            if(entities.get(x).getEntityWorld().equals(creature.getEntityWorld()) && entities.get(x).getPosition().getDistance(creature.getPosition().getX(),creature.getPosition().getY(),creature.getPosition().getZ())<=distance){

            }else{
                x++;
                continue;
            }
            if (followingBiomes.contains(entities.get(x).getEntityWorld().getBiome(entities.get(x).getPosition()))){

            }else{
                x++;
                continue;
            }

            players.add((EntityPlayer) entities.get(x));


            x++;
        }


        return players;
    }


    public void addSuspectedForBreak(EntityPlayer player){
        suspectedForBreak.add(player);
    }

    public ArrayList<Block> getCannotBreakThis() {
        return cannotBreakThis;
    }

    @Override
    public void startExecuting() {

    }


    boolean canRemove = false;

    @Override
    public void updateTask() {


        /*thisOneAttack=getClosestEntity(creature,EntityPlayer.class,distance);
        if(thisOneAttack==null){

        }else {

            if (!followingBiomes.contains(thisOneAttack.getEntityWorld().getBiome(thisOneAttack.getPosition()))) {

            } else {
                creature.setRevengeTarget(thisOneAttack);
                creature.setAttackTarget(thisOneAttack);
            }


            if (thisOneAttack.isDead) {
                try {
                    suspectedForBreak.remove(thisOneAttack);
                } catch (Exception e) {
                }
                ;
            }
        }*/
        EntityPlayer suspected = getClosestSuspectedEntity(this.creature,distance);
        EntityPlayer fWarned = getClosestFirstWarnedEntity(this.creature,distance);


        if(firstWarned.contains(fWarned)){
            this.creature.getNavigator().tryMoveToEntityLiving(fWarned,1.2F);
            warnEntity(fWarned);
            warned.add(fWarned);
            firstWarned.remove(fWarned);
        }

        if(suspectedForBreak.contains(suspected) && warned.contains(suspected)){
            attackEntity(suspected);
        }



        if(this.creature.getRevengeTarget()!=null && canRemove && (this.creature.getRevengeTarget().isDead || this.creature.getRevengeTarget().getDistance(this.creature)>100)){
            warned=new ArrayList<>();
            canRemove=false;
            firstWarned = new ArrayList<>();
            suspectedForBreak = new ArrayList<>();
        }

    }

    public void attackEntity(EntityPlayer player){

        if(this.creature.getNavigator().getPathToEntityLiving(player)==null && player.onGround && player.getDistance(creature)>15){
            this.creature.moveToBlockPosAndAngles(player.getPosition(),this.creature.rotationYaw,this.creature.rotationPitch);
        }
        this.creature.getNavigator().tryMoveToEntityLiving(player,1.2F);

        this.creature.setSprinting(true);
        this.creature.setRevengeTarget(player);
        this.creature.setAttackTarget(player);
        canRemove=true;
    }


    public void addFirstWarned(EntityPlayer firstWarned){
        this.firstWarned.add(firstWarned);
    }
    public void removeFirstWarned(EntityPlayer firstWarned){
        this.firstWarned.remove(firstWarned);
    }
    public boolean containsFirstWarned(EntityPlayer firstWarned){
        return this.firstWarned.contains(firstWarned);
    }
    public boolean containsWarned(EntityPlayer firstWarned){
        return this.warned.contains(firstWarned);
    }

    private void warnEntity(EntityPlayer player){
        int x = Main.generateRandomInt(1,3);
        ITextComponent msg;
        if(x==1){
             msg =  new TextComponentTranslation("messages.foresterWarn1");
        }else if(x==2){
             msg =  new TextComponentTranslation("messages.foresterWarn2");
        }else{
             msg =  new TextComponentTranslation("messages.foresterWarn3");
        }
        ITextComponent forester = new TextComponentTranslation("entity.forester.name");
        ITextComponent done = new TextComponentString(TextFormatting.DARK_AQUA+"["+forester.getFormattedText()+TextFormatting.DARK_AQUA+"]" + " " +TextFormatting.GRAY+ msg.getFormattedText());
        player.sendMessage(done);
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        return shouldExecute();
    }



    public EntityPlayer getClosestSuspectedEntity(EntityCreature creature, double maxDistance){
        int x = 0;
        double y = 0;
        EntityPlayer closest = null;
        while(x<suspectedForBreak.size()){
            if(creature.getDistance(suspectedForBreak.get(x))<=maxDistance){
                if(closest==null) {
                    closest = suspectedForBreak.get(x);
                    y = creature.getDistance(suspectedForBreak.get(x));
                }else{
                    double z = creature.getDistance(suspectedForBreak.get(x));
                    if(z<y){
                        closest=suspectedForBreak.get(x);
                        y = z;
                    }
                }
            }
            x++;
        }

        return closest;
    }

    public EntityPlayer getClosestFirstWarnedEntity(EntityCreature creature, double maxDistance){
        int x = 0;
        double y = 0;
        EntityPlayer closest = null;
        while(x<firstWarned.size()){
            if(creature.getDistance(firstWarned.get(x))<=maxDistance){
                if(closest==null) {
                    closest = firstWarned.get(x);
                    y = creature.getDistance(firstWarned.get(x));
                }else{
                    double z = creature.getDistance(firstWarned.get(x));
                    if(z<y){
                        closest=firstWarned.get(x);
                        y = z;
                    }
                }
            }
            x++;
        }

        return closest;
    }

    @Override
    public void resetTask() {

    }
}
