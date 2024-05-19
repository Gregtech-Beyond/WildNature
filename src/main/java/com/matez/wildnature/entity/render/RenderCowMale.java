package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityCowMale;
import com.matez.wildnature.entity.model.ModelCowMale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCowMale extends RenderLiving<EntityCowMale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/cow_male.png");
    public RenderCowMale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCowMale(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCowMale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityCowMale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}