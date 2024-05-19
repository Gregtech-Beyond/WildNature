package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityCustomPlayer;
import com.matez.wildnature.entity.EntityForester;
import com.matez.wildnature.entity.model.ModelForester;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderForester extends RenderLivingBase<EntityForester> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/forester.png");
    public RenderForester(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelForester(0.0F,false), 0.5F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityForester entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityForester entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}