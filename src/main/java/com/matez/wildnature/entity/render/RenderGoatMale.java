package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityGoatMale;
import com.matez.wildnature.entity.model.ModelGoatMale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderGoatMale extends RenderLiving<EntityGoatMale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/goat_male.png");
    public RenderGoatMale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGoatMale(), 0.6F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGoatMale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityGoatMale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}