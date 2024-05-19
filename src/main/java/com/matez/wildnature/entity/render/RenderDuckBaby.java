package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityDuckChild;
import com.matez.wildnature.entity.EntityDuckFemale;
import com.matez.wildnature.entity.model.ModelDuckBaby;
import com.matez.wildnature.entity.model.ModelDuckFemale;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDuckBaby extends RenderLiving<EntityDuckChild> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/duck_baby.png");
    public RenderDuckBaby(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDuckBaby(), 0.3F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDuckChild entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityDuckChild entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}