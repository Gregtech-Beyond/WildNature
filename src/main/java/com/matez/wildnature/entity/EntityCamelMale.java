package com.matez.wildnature.entity;

import com.matez.wildnature.util.handlers.LootTableHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityCamelMale extends EntityCamel {
    public EntityCamelMale(World worldIn) {
        super(worldIn);
        setType(0);
    }


}
