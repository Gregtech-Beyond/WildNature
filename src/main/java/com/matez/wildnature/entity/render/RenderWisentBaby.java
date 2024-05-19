package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityWisentChild;
import com.matez.wildnature.entity.model.ModelWisentBaby;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWisentBaby extends RenderLiving<EntityWisentChild> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/wisent_baby.png");
    public RenderWisentBaby(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelWisentBaby(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWisentChild entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityWisentChild entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}