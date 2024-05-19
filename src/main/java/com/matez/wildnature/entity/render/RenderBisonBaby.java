package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityBisonChild;
import com.matez.wildnature.entity.model.ModelBisonBaby;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBisonBaby extends RenderLiving<EntityBisonChild> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bison_baby.png");
    public RenderBisonBaby(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBisonBaby(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBisonChild entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityBisonChild entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}