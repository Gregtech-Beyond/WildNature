package com.matez.wildnature.util.handlers;

import com.matez.wildnature.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundHandler {

    public static SoundEvent ENTITY_BOAR_DEATH;
    public static SoundEvent ENTITY_BOAR_DEATH2;
    public static SoundEvent ENTITY_BOAR_OINK;
    public static SoundEvent ENTITY_BOAR_OINK2;
    public static SoundEvent ENTITY_BOAR_OINK3;
    public static SoundEvent ENTITY_BOAR_OINK4;
    public static SoundEvent ENTITY_BOAR_SNORT;
    public static SoundEvent ENTITY_BOAR_SNORT2;
    public static SoundEvent ENTITY_BOAR_SCARED;
    public static SoundEvent ENTITY_BOAR_SCARED2;
    public static SoundEvent ENTITY_DUCK_QUACK;
    public static SoundEvent ENTITY_DUCK_FLAP;
    public static SoundEvent ENTITY_DUCK_SCARED;
    public static SoundEvent ENTITY_DUCK_CHICK;
    public static SoundEvent ENTITY_GOAT_BEE;
    public static SoundEvent ENTITY_GOAT_BEE_BABY;
    public static SoundEvent ENTITY_GOAT_HURT;
    public static SoundEvent ENTITY_GOAT_DEATH;
    public static SoundEvent ENTITY_BISON_SNORT1;
    public static SoundEvent ENTITY_BISON_SNORT2;
    public static SoundEvent ENTITY_BISON_HURT;
    public static SoundEvent ENTITY_BISON_DEATH;
    public static SoundEvent ENTITY_CAMEL_HURT1;
    public static SoundEvent ENTITY_CAMEL_HURT2;
    public static SoundEvent ENTITY_CAMEL_DEATH;
    public static SoundEvent ENTITY_CAMEL_GROWL;



    public static SoundEvent STEP_STEELLADDER_STEP1;
    public static SoundEvent STEP_STEELLADDER_STEP2;
    public static SoundEvent STEP_STEELLADDER_STEP3;
    public static SoundEvent STEP_STEELLADDER_STEP4;
    public static SoundEvent STEP_STEELLADDER_STEP5;

    public static void registerSounds(){
        ENTITY_BOAR_DEATH = registerSound("entity.boar.death");
        ENTITY_BOAR_DEATH2 = registerSound("entity.boar.death2");
        ENTITY_BOAR_OINK = registerSound("entity.boar.oink");
        ENTITY_BOAR_OINK2 = registerSound("entity.boar.oink2");
        ENTITY_BOAR_OINK3 = registerSound("entity.boar.oink3");
        ENTITY_BOAR_OINK4 = registerSound("entity.boar.oink4");
        ENTITY_BOAR_SNORT = registerSound("entity.boar.snort");
        ENTITY_BOAR_SNORT2 = registerSound("entity.boar.snort2");
        ENTITY_BOAR_SCARED = registerSound("entity.boar.scared");
        ENTITY_BOAR_SCARED2 = registerSound("entity.boar.scared2");
        ENTITY_DUCK_QUACK = registerSound("entity.duck.quack");
        ENTITY_DUCK_FLAP = registerSound("entity.duck.flap");
        ENTITY_DUCK_SCARED = registerSound("entity.duck.scared");
        ENTITY_DUCK_CHICK = registerSound("entity.duck.chick");
        ENTITY_GOAT_BEE = registerSound("entity.goat.bee");
        ENTITY_GOAT_BEE_BABY = registerSound("entity.goat.bee_baby");
        ENTITY_GOAT_HURT = registerSound("entity.goat.hurt");
        ENTITY_GOAT_DEATH = registerSound("entity.goat.death");
        ENTITY_BISON_SNORT1 = registerSound("entity.bison.snort1");
        ENTITY_BISON_SNORT2 = registerSound("entity.bison.snort2");
        ENTITY_BISON_HURT = registerSound("entity.bison.hurt");
        ENTITY_BISON_DEATH = registerSound("entity.bison.death");
        ENTITY_CAMEL_HURT1 = registerSound("entity.camel.hurt1");
        ENTITY_CAMEL_HURT2 = registerSound("entity.camel.hurt2");
        ENTITY_CAMEL_DEATH = registerSound("entity.camel.death");
        ENTITY_CAMEL_GROWL = registerSound("entity.camel.growl");
        STEP_STEELLADDER_STEP1 = registerSound("step.steel_ladder.step1");
        STEP_STEELLADDER_STEP2 = registerSound("step.steel_ladder.step2");
        STEP_STEELLADDER_STEP3 = registerSound("step.steel_ladder.step3");
        STEP_STEELLADDER_STEP4 = registerSound("step.steel_ladder.step4");
        STEP_STEELLADDER_STEP5 = registerSound("step.steel_ladder.step5");

    }
    private static SoundEvent registerSound(String name){
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID,name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
