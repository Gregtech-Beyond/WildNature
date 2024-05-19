package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityGoatFemale;
import com.matez.wildnature.entity.EntityGoatSaanenFemale;
import com.matez.wildnature.entity.model.ModelGoatFemale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderGoatSaanenFemale extends RenderLiving<EntityGoatSaanenFemale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/goat_saanen_female.png");
    public RenderGoatSaanenFemale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGoatFemale(), 0.5F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGoatSaanenFemale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityGoatSaanenFemale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}