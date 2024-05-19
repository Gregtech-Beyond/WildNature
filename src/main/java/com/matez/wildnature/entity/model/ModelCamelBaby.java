package com.matez.wildnature.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * CamelBaby - Matheus
 * Created using Tabula 7.0.0
 */
public class ModelCamelBaby extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer Tail1;
    public ModelRenderer Body2;
    public ModelRenderer Body3;
    public ModelRenderer Tail2;
    public ModelRenderer Neck2;
    public ModelRenderer Head1;
    public ModelRenderer Head2;
    public ModelRenderer Head3;
    public ModelRenderer Head4;
    public ModelRenderer Mouth;
    public ModelRenderer RightEar;
    public ModelRenderer LeftEar;

    public ModelCamelBaby() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Body = new ModelRenderer(this, 77, 41);
        this.Body.setRotationPoint(-4.5F, 7.0F, -7.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 9, 8, 14, 0.0F);
        this.Neck = new ModelRenderer(this, 30, 26);
        this.Neck.setRotationPoint(0.5F, 12.4F, -5.3F);
        this.Neck.addBox(-3.0F, -4.0F, -6.0F, 5, 5, 5, 0.0F);
        this.setRotateAngle(Neck, -0.5410520681182421F, 0.0F, 0.0F);
        this.Head2 = new ModelRenderer(this, 0, 0);
        this.Head2.setRotationPoint(-0.5F, 0.2F, -4.5F);
        this.Head2.addBox(-2.0F, 1.33F, -5.5F, 4, 3, 5, 0.0F);
        this.Tail2 = new ModelRenderer(this, 10, 68);
        this.Tail2.setRotationPoint(0.0F, 4.5F, 0.1F);
        this.Tail2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Tail2, -0.2303834612632515F, -0.0F, 0.0F);
        this.leg4 = new ModelRenderer(this, 0, 51);
        this.leg4.setRotationPoint(1.75F, 7.5F, 2.5F);
        this.leg4.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.Head4 = new ModelRenderer(this, 67, 5);
        this.Head4.setRotationPoint(0.5F, -0.5F, -6.4F);
        this.Head4.addBox(-3.0F, 0.0F, -0.0F, 4, 1, 5, 0.0F);
        this.setRotateAngle(Head4, 0.06981317007977318F, 0.0F, 0.0F);
        this.RightEar = new ModelRenderer(this, 0, 31);
        this.RightEar.setRotationPoint(-3.7F, 1.8F, -3.8F);
        this.RightEar.addBox(-3.0F, 0.0F, 0.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(RightEar, 0.0F, -0.0F, 2.6179938779914944F);
        this.leg2 = new ModelRenderer(this, 0, 51);
        this.leg2.setRotationPoint(7.25F, 7.5F, 12.0F);
        this.leg2.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 68);
        this.Tail1.setRotationPoint(3.5F, 0.6F, 12.9F);
        this.Tail1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(Tail1, 0.3839724354387525F, -0.0F, 0.0F);
        this.leg3 = new ModelRenderer(this, 0, 51);
        this.leg3.setRotationPoint(7.25F, 7.5F, 2.5F);
        this.leg3.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.Body3 = new ModelRenderer(this, 100, 65);
        this.Body3.setRotationPoint(2.5F, -2.0F, 8.5F);
        this.Body3.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.Head1 = new ModelRenderer(this, 36, 0);
        this.Head1.setRotationPoint(2.5F, -2.1F, -3.7F);
        this.Head1.addBox(-3.0F, 0.0F, -7.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(Head1, 1.3962634015954636F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 41, 19);
        this.Mouth.setRotationPoint(1.0F, 4.0F, -9.5F);
        this.Mouth.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 5, 0.0F);
        this.setRotateAngle(Mouth, 0.06981317007977318F, -0.0F, 0.0F);
        this.LeftEar = new ModelRenderer(this, 0, 22);
        this.LeftEar.setRotationPoint(-1.0F, -0.1F, -3.8F);
        this.LeftEar.addBox(-3.0F, 0.0F, 0.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(LeftEar, 0.0F, 0.0F, -2.6179938779914944F);
        this.Body2 = new ModelRenderer(this, 100, 65);
        this.Body2.setRotationPoint(2.5F, -2.0F, 1.0F);
        this.Body2.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.Neck2 = new ModelRenderer(this, 30, 41);
        this.Neck2.setRotationPoint(-2.5F, -5.3F, -7.6F);
        this.Neck2.addBox(0.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(Neck2, -0.6373942428283291F, -0.01308996938995747F, 0.0F);
        this.Head3 = new ModelRenderer(this, 19, 22);
        this.Head3.setRotationPoint(1.0F, 1.5F, -8.9F);
        this.Head3.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(Head3, 0.3490658503988659F, 0.0F, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 51);
        this.leg1.setRotationPoint(1.75F, 7.5F, 12.0F);
        this.leg1.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.Head1.addChild(this.Head2);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.leg4);
        this.Head1.addChild(this.Head4);
        this.Head1.addChild(this.RightEar);
        this.Body.addChild(this.leg2);
        this.Body.addChild(this.Tail1);
        this.Body.addChild(this.leg3);
        this.Body.addChild(this.Body3);
        this.Neck2.addChild(this.Head1);
        this.Head1.addChild(this.Mouth);
        this.Head1.addChild(this.LeftEar);
        this.Body.addChild(this.Body2);
        this.Neck.addChild(this.Neck2);
        this.Head1.addChild(this.Head3);
        this.Body.addChild(this.leg1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Body.render(f5);
        this.Neck.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {

        this.Neck.rotateAngleX = headPitch * 0.017453292F -0.6F;
        this.Neck.rotateAngleY = netHeadYaw * 0.017453292F;

        //this.body.rotateAngleX = ((float)Math.PI / 2F)-90;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
