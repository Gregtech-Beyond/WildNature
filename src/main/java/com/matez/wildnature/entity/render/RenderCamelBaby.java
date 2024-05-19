package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityCamelChild;
import com.matez.wildnature.entity.model.ModelCamelBaby;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCamelBaby extends RenderLiving<EntityCamelChild> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/camel_baby.png");
    public RenderCamelBaby(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCamelBaby(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCamelChild entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityCamelChild entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}