package com.matez.wildnature.entity;

import com.matez.wildnature.util.handlers.LootTableHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityCowMale extends EntityHCow {
    public EntityCowMale(World worldIn) {
        super(worldIn);
        setType(0);
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableHandler.DUCK_MALE_LOOT;
    }
}
