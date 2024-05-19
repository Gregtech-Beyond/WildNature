package com.matez.wildnature.entity;

import com.matez.wildnature.util.handlers.LootTableHandler;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class EntityDuckMale extends EntityDuck {
    public EntityDuckMale(World worldIn) {
        super(worldIn);
        setType(0);
    }


}
