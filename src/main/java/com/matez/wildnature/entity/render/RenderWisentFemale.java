package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityWisentFemale;
import com.matez.wildnature.entity.model.ModelWisentFemale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWisentFemale extends RenderLiving<EntityWisentFemale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/wisent_female.png");
    public RenderWisentFemale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelWisentFemale(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWisentFemale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityWisentFemale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }



}