package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityCamelFemale;
import com.matez.wildnature.entity.model.ModelCamelFemale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCamelFemale extends RenderLiving<EntityCamelFemale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/camel_female.png");
    public RenderCamelFemale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCamelFemale(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCamelFemale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityCamelFemale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }



}