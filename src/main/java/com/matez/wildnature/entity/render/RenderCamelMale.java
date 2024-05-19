package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.entity.EntityCamelMale;
import com.matez.wildnature.entity.model.ModelBoar;
import com.matez.wildnature.entity.model.ModelCamelMale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCamelMale extends RenderLiving<EntityCamelMale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/camel_male.png");
    public RenderCamelMale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCamelMale(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCamelMale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityCamelMale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}