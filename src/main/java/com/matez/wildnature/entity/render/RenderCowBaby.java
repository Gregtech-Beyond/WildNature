package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityCowChild;
import com.matez.wildnature.entity.model.ModelCowBaby;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCowBaby extends RenderLiving<EntityCowChild> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/cow_baby.png");
    public RenderCowBaby(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCowBaby(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCowChild entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityCowChild entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}