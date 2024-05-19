package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityCowFemale;
import com.matez.wildnature.entity.model.ModelCowFemale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCowFemale extends RenderLiving<EntityCowFemale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/cow_female.png");
    public RenderCowFemale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCowFemale(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCowFemale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityCowFemale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }



}