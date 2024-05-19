package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityDuckFemale;
import com.matez.wildnature.entity.EntityDuckMale;
import com.matez.wildnature.entity.model.ModelDuckFemale;
import com.matez.wildnature.entity.model.ModelDuckMale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDuckFemale extends RenderLiving<EntityDuckFemale> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/duck_female.png");
    public RenderDuckFemale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDuckFemale(), 0.3F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDuckFemale entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityDuckFemale entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}