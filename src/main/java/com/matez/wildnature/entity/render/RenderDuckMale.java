package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityBoar;
import com.matez.wildnature.entity.EntityDuckMale;
import com.matez.wildnature.entity.model.ModelBoar;
import com.matez.wildnature.entity.model.ModelDuckMale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDuckMale extends RenderLiving<EntityDuckMale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/duck_male.png");
    public RenderDuckMale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDuckMale(), 0.3F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDuckMale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityDuckMale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}