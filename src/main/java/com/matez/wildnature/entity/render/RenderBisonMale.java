package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityBisonMale;
import com.matez.wildnature.entity.model.ModelBisonMale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBisonMale extends RenderLiving<EntityBisonMale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bison_male.png");
    public RenderBisonMale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBisonMale(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBisonMale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityBisonMale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}