package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityBisonFemale;
import com.matez.wildnature.entity.model.ModelBisonFemale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBisonFemale extends RenderLiving<EntityBisonFemale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bison_female.png");
    public RenderBisonFemale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBisonFemale(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBisonFemale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityBisonFemale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }



}