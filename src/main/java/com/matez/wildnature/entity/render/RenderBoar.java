package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.entity.model.ModelBoar;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.sql.Ref;

public class RenderBoar extends RenderLiving<EntityBoar> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/boar.png");
    public RenderBoar(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBoar(), 0.8F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBoar entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityBoar entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}