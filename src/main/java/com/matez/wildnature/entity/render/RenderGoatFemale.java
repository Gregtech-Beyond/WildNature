package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityGoatFemale;
import com.matez.wildnature.entity.model.ModelGoatFemale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderGoatFemale extends RenderLiving<EntityGoatFemale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/goat_female.png");
    public RenderGoatFemale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGoatFemale(), 0.5F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGoatFemale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityGoatFemale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}