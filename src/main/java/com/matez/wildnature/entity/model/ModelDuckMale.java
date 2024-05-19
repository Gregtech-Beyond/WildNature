package com.matez.wildnature.entity.model.animal;

import com.matez.wildnature.entity.EntityDuck;
import com.matez.wildnature.util.handlers.SoundHandler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.MathHelper;

/**
 * ModelDuckFemale - Matheus
 * Created using Tabula 7.0.0
 */
public class ModelDuckMale extends ModelBase {
    public ModelRenderer RightLeg2;
    public ModelRenderer LeftLeg2;
    public ModelRenderer Body1;
    public ModelRenderer RightLeg1;
    public ModelRenderer RightLeg3;
    public ModelRenderer LeftLeg1;
    public ModelRenderer LeftLeg3;
    public ModelRenderer Body2;
    public ModelRenderer Body3;
    public ModelRenderer RightWing;
    public ModelRenderer LeftWing;
    public ModelRenderer Neck;
    public ModelRenderer Head;
    public ModelRenderer Beak1;
    public ModelRenderer Beak2;
    public ModelRenderer Body4;
    public ModelRenderer Body5;


    public ModelDuckMale() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Body2 = new ModelRenderer(this, 46, 11);
        this.Body2.setRotationPoint(0.0F, -2.0F, -3.0F);
        this.Body2.addBox(-1.5F, -2.13F, -4.0F, 3, 3, 4, 0.0F);
        this.setRotateAngle(Body2, -0.6981317007977318F, 0.0F, 0.0F);
        this.Body3 = new ModelRenderer(this, 37, 0);
        this.Body3.setRotationPoint(0.0F, -0.4F, 0.6F);
        this.Body3.addBox(-2.5F, -4.13F, 1.03F, 5, 4, 3, 0.0F);
        this.setRotateAngle(Body3, 0.3665191429188092F, -0.0F, 0.0F);
        this.LeftLeg2 = new ModelRenderer(this, 12, 27);
        this.LeftLeg2.setRotationPoint(1.0F, 20.6F, 0.7F);
        this.LeftLeg2.addBox(-0.5F, -2.0F, -1.47F, 2, 3, 2, 0.0F);
        this.setRotateAngle(LeftLeg2, 0.15707963267948966F, -0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 13);
        this.Head.setRotationPoint(-1.0F, -3.4F, -1.63F);
        this.Head.addBox(-1.5F, -2.87F, -3.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(Head, 1.3613568165555772F, 0.0F, 0.0F);
        this.RightLeg1 = new ModelRenderer(this, 20, 26);
        this.RightLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightLeg1.addBox(-1.0F, -1.5F, -1.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(RightLeg1, -0.15707963267948966F, -0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 40, 20);
        this.Body1.setRotationPoint(0.0F, 20.5F, 1.0F);
        this.Body1.addBox(-3.0F, -5.53F, -4.0F, 6, 5, 6, 0.0F);
        this.RightLeg3 = new ModelRenderer(this, 0, 29);
        this.RightLeg3.setRotationPoint(0.5F, 0.4F, 1.4F);
        this.RightLeg3.addBox(-2.0F, 3.0F, -4.0F, 2, 1, 3, 0.0F);
        this.Beak2 = new ModelRenderer(this, 0, 9);
        this.Beak2.setRotationPoint(-0.5F, 0.3F, -0.33F);
        this.Beak2.addBox(-0.5F, -1.2F, -4.6F, 2, 1, 3, 0.0F);
        this.LeftLeg1 = new ModelRenderer(this, 20, 26);
        this.LeftLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftLeg1.addBox(0.0F, -1.47F, -1.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(LeftLeg1, -0.15707963267948966F, -0.0F, 0.0F);
        this.RightLeg2 = new ModelRenderer(this, 12, 27);
        this.RightLeg2.setRotationPoint(-1.0F, 20.6F, 0.7F);
        this.RightLeg2.addBox(-1.5F, -2.0F, -1.47F, 2, 3, 2, 0.0F);
        this.setRotateAngle(RightLeg2, 0.15707963267948966F, -0.0F, 0.0F);
        this.LeftWing = new ModelRenderer(this, 54, 0);
        this.LeftWing.setRotationPoint(2.7F, -4.7F, -2.7F);
        this.LeftWing.addBox(0.0F, -0.13F, -1.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(LeftWing, 0.10471975511965977F, 0.13962634015954636F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 20);
        this.Neck.setRotationPoint(1.0F, 1.1F, -5.03F);
        this.Neck.addBox(-2.0F, -3.13F, -2.93F, 2, 2, 4, 0.0F);
        this.setRotateAngle(Neck, -0.5585053606381855F, 0.0F, 0.0F);
        this.Body5 = new ModelRenderer(this, 24, 5);
        this.Body5.setRotationPoint(0.0F, 1.0F, -1.0F);
        this.Body5.addBox(-1.5F, -0.13F, 4.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(Body5, 0.5410520681182421F, -0.0F, 0.0F);
        this.LeftLeg3 = new ModelRenderer(this, 0, 29);
        this.LeftLeg3.setRotationPoint(0.5F, 0.4F, 1.4F);
        this.LeftLeg3.addBox(-1.0F, 3.0F, -4.0F, 2, 1, 3, 0.0F);
        this.Beak1 = new ModelRenderer(this, 0, 4);
        this.Beak1.setRotationPoint(0.0F, 0.1F, -0.03F);
        this.Beak1.addBox(-0.5F, -2.07F, -4.2F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Beak1, 0.24434609527920614F, -0.0F, 0.0F);
        this.RightWing = new ModelRenderer(this, 54, 0);
        this.RightWing.setRotationPoint(-2.7F, -4.7F, -2.7F);
        this.RightWing.addBox(-1.0F, -0.13F, -1.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(RightWing, 0.10471975511965977F, -0.13962634015954636F, 0.0F);
        this.Body4 = new ModelRenderer(this, 22, 0);
        this.Body4.setRotationPoint(0.0F, 0.8F, -0.5F);
        this.Body4.addBox(-2.0F, -4.13F, 4.5F, 4, 2, 3, 0.0F);
        this.setRotateAngle(Body4, 0.12217304763960307F, -0.0F, 0.0F);
        this.Body1.addChild(this.Body2);
        this.Body1.addChild(this.Body3);
        this.Neck.addChild(this.Head);
        this.RightLeg2.addChild(this.RightLeg1);
        this.RightLeg1.addChild(this.RightLeg3);
        this.Head.addChild(this.Beak2);
        this.LeftLeg2.addChild(this.LeftLeg1);
        this.Body1.addChild(this.LeftWing);
        this.Body2.addChild(this.Neck);
        this.Body3.addChild(this.Body5);
        this.LeftLeg1.addChild(this.LeftLeg3);
        this.Head.addChild(this.Beak1);
        this.Body1.addChild(this.RightWing);
        this.Body3.addChild(this.Body4);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.LeftLeg2.render(f5);
        this.Body1.render(f5);
        this.RightLeg2.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    int stateFlap = 0;
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        float flap = ageInTicks*2;
        /*this.Head.rotateAngleX = (headPitch * 0.017453292F)-150;
        this.Head.rotateAngleY = (netHeadYaw * 0.017453292F);
        this.Neck.rotateAngleX = headPitch / 57.295776F - 6.8F;*/

        this.Body2.rotateAngleX = headPitch * 0.017453292F-0.8F;
        this.Body2.rotateAngleY = netHeadYaw * 0.017453292F;
        //this.Body1.rotateAngleX = 0.05609987F;

        if(((EntityDuck) entityIn).onGround){
            this.RightLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            this.LeftLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.LeftWing.rotateAngleZ = 0;
            this.RightWing.rotateAngleZ = 0;
        }else{
            this.RightLeg2.rotateAngleX = 20;
            this.LeftLeg2.rotateAngleX = 20;
            if(stateFlap==0){
                this.LeftWing.rotateAngleZ = -0.0873F - -flap;
                this.RightWing.rotateAngleZ = 0.0873F + -flap;
                if(this.RightWing.rotateAngleZ>=0){
                    stateFlap=1;
                    entityIn.playSound(SoundHandler.ENTITY_DUCK_FLAP, 0.8F, 1.0F);
                }
            }else{
                this.LeftWing.rotateAngleZ = -0.0873F - flap;
                this.RightWing.rotateAngleZ = 0.0873F + flap;
                if(this.RightWing.rotateAngleZ>=60){
                    stateFlap=0;
                }
            }


        }
    }


}
