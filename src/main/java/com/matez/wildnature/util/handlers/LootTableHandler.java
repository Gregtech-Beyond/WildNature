package com.matez.wildnature.util.handlers;

import com.matez.wildnature.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {

    public static final ResourceLocation BOAR_LOOT = LootTableList.register(new ResourceLocation(Reference.MOD_ID,"boar_loot"));
    public static final ResourceLocation GOAT_LOOT = LootTableList.register(new ResourceLocation(Reference.MOD_ID,"goat_loot"));
    public static final ResourceLocation DUCK_MALE_LOOT = LootTableList.register(new ResourceLocation(Reference.MOD_ID,"duck_male_loot"));
    public static final ResourceLocation DUCK_FEMALE_LOOT = LootTableList.register(new ResourceLocation(Reference.MOD_ID,"duck_female_loot"));
    public static final ResourceLocation DUCK_BABY_LOOT = LootTableList.register(new ResourceLocation(Reference.MOD_ID,"duck_baby_loot"));
    public static final ResourceLocation BISON_LOOT = LootTableList.register(new ResourceLocation(Reference.MOD_ID,"bison_loot"));
    public static final ResourceLocation WISENT_LOOT = BISON_LOOT;
    public static final ResourceLocation CAMEL_LOOT = LootTableList.register(new ResourceLocation(Reference.MOD_ID,"camel_loot"));
}
