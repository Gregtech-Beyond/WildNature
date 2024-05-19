package com.matez.wildnature.entity.render;

import com.matez.wildnature.entity.EntityBisonChild;
import com.matez.wildnature.entity.EntityCustomPlayer;
import com.matez.wildnature.entity.model.ModelBisonBaby;
import com.matez.wildnature.entity.model.ModelForester;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCustomPlayer extends RenderLivingBase<EntityCustomPlayer> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/forester.png");
    public RenderCustomPlayer(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelForester(0.0F,false), 0.5F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCustomPlayer entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityCustomPlayer entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}