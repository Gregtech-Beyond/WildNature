package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityWisentMale;
import com.matez.wildnature.entity.model.ModelWisentMale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWisentMale extends RenderLiving<EntityWisentMale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/wisent_male.png");
    public RenderWisentMale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelWisentMale(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWisentMale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityWisentMale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}