package com.matez.wildnature.init;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.*;
import com.matez.wildnature.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

    public static void registerEntities(){

        registerEntity("boar", EntityBoar.class,Reference.BOAR,40,3943953,0);
        registerEntity("duck_male", EntityDuckMale.class,Reference.DUCK_MALE,40,0x2A6425,0x422F2B);
        registerEntity("duck_female", EntityDuckFemale.class,Reference.DUCK_FEMALE,40,0x636363,0x515151);
        registerEntityWithoutEgg("duck_baby", EntityDuckChild.class,Reference.DUCK_BABY,40);
        registerEntity("goat_male", EntityGoatMale.class,Reference.GOAT_MALE,40,0x6E4426,0xB5727D);
        registerEntity("goat_female", EntityGoatFemale.class,Reference.GOAT_FEMALE,40,0x6E4426,0xDD939F);
        registerEntityWithoutEgg("goat_baby", EntityGoatChild.class,Reference.GOAT_BABY,40);
        registerEntity("goat_saanen_male", EntityGoatSaanenMale.class,Reference.GOAT_SAANEN_MALE,40,0xECECEC,0xB5727D);
        registerEntity("goat_saanen_female", EntityGoatSaanenFemale.class,Reference.GOAT_SAANEN_FEMALE,40,0xECECEC,0xDD939F);
        registerEntityWithoutEgg("goat_saanen_baby", EntityGoatSaanenChild.class,Reference.GOAT_SAANEN_BABY,40);
        registerEntity("camel_male", EntityCamelMale.class,Reference.CAMEL_MALE,40,0xDAB125,0x31290D);
        registerEntity("camel_female", EntityCamelFemale.class,Reference.CAMEL_FEMALE,40,0xDAB125,0x91731B);
        registerEntityWithoutEgg("camel_baby", EntityCamelChild.class,Reference.CAMEL_BABY,40);
        registerEntity("bison_male", EntityBisonMale.class,Reference.BISON_MALE,40,0x433428,0x634e33);
        registerEntity("bison_female", EntityBisonFemale.class,Reference.BISON_FEMALE,40,0x433428,0x2d241e);
        registerEntityWithoutEgg("bison_baby", EntityBisonChild.class,Reference.BISON_BABY,40);
        registerEntity("cow_male", EntityCowMale.class,Reference.COW_MALE,40,0x2E2213,0x484D4E);
        registerEntity("cow_female", EntityCowFemale.class,Reference.COW_FEMALE,40,0xD1DDE0,0x252A2D);
        registerEntityWithoutEgg("cow_baby", EntityCowChild.class,Reference.COW_BABY,40);
        registerEntity("wisent_male", EntityWisentMale.class,Reference.WISENT_MALE,40,0x3B322F,0x483C31);
        registerEntity("wisent_female", EntityWisentFemale.class,Reference.WISENT_FEMALE,40,0x3B322F,0x2D2723);
        registerEntityWithoutEgg("wisent_baby", EntityWisentChild.class,Reference.WISENT_BABY,40);
        registerEntity("forester", EntityForester.class,Reference.FORESTER,75,0x455E48,0xEBC095);

    }


    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2){
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID+":"+name),entity,name,id, Main.instance,range,1,true,color1,color2);
    }
    private static void registerEntityWithoutEgg(String name, Class<? extends Entity> entity, int id, int range){
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID+":"+name),entity,name,id, Main.instance,range,1,true);
    }
}