package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityGoatChild;
import com.matez.wildnature.entity.EntityGoatSaanenChild;
import com.matez.wildnature.entity.model.ModelGoatBaby;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderGoatSaanenBaby extends RenderLiving<EntityGoatSaanenChild> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/goat_saanen_baby.png");
    public RenderGoatSaanenBaby(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGoatBaby(), 0.5F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGoatSaanenChild entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityGoatSaanenChild entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}