package com.matez.wildnature.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * BisonMale - Matheus
 * Created using Tabula 7.0.0
 */
public class ModelBisonMale extends ModelBase {
    public ModelRenderer Body2;
    public ModelRenderer Neck;
    public ModelRenderer Body1;
    public ModelRenderer Body3;
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer Body4;
    public ModelRenderer Body5;
    public ModelRenderer Tail1;
    public ModelRenderer BackRightLeg;
    public ModelRenderer BackLeftLeg;
    public ModelRenderer Tail2;
    public ModelRenderer Head1;
    public ModelRenderer Neck2;
    public ModelRenderer Head2;
    public ModelRenderer Head3;
    public ModelRenderer Mouth;
    public ModelRenderer RightEar;
    public ModelRenderer LeftEar;
    public ModelRenderer RightHorn;
    public ModelRenderer LeftHorn;
    public ModelRenderer beard;

    public ModelBisonMale() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.BackLeftLeg = new ModelRenderer(this, 0, 51);
        this.BackLeftLeg.setRotationPoint(9.0F, 12.4F, 4.0F);
        this.BackLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.FrontLeftLeg = new ModelRenderer(this, 0, 51);
        this.FrontLeftLeg.setRotationPoint(9.0F, 12.4F, 4.0F);
        this.FrontLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.Head1 = new ModelRenderer(this, 36, 0);
        this.Head1.setRotationPoint(-0.5F, -4.1F, -2.4F);
        this.Head1.addBox(-3.0F, 0.0F, -7.0F, 7, 10, 7, 0.0F);
        this.setRotateAngle(Head1, -0.9599310885968813F, 0.0F, 0.0F);
        this.Head2 = new ModelRenderer(this, 0, 0);
        this.Head2.setRotationPoint(-0.5F, 8.5F, -1.2F);
        this.Head2.addBox(-2.0F, 1.33F, -5.5F, 6, 2, 4, 0.0F);
        this.Body3 = new ModelRenderer(this, 50, 44);
        this.Body3.setRotationPoint(-0.5F, -0.3F, 10.5F);
        this.Body3.addBox(0.0F, 0.0F, 0.0F, 11, 13, 7, 0.0F);
        this.Body4 = new ModelRenderer(this, 51, 77);
        this.Body4.setRotationPoint(1.0F, -3.5F, 0.0F);
        this.Body4.addBox(0.0F, 0.0F, 0.0F, 9, 5, 8, 0.0F);
        this.LeftEar = new ModelRenderer(this, 0, 22);
        this.LeftEar.setRotationPoint(6.0F, 1.0F, -2.8F);
        this.LeftEar.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.Body5 = new ModelRenderer(this, 9, 64);
        this.Body5.setRotationPoint(0.5F, 0.0F, 7.5F);
        this.Body5.addBox(0.0F, 0.0F, 0.0F, 8, 5, 16, 0.0F);
        this.setRotateAngle(Body5, -0.22689280275926282F, 0.0F, 0.0F);
        this.LeftHorn = new ModelRenderer(this, 26, 0);
        this.LeftHorn.setRotationPoint(6.9F, 1.0F, -7.5F);
        this.LeftHorn.addBox(-3.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LeftHorn, 0.7853981633974483F, -0.0F, 0.5061454830783556F);
        this.Neck = new ModelRenderer(this, 25, 30);
        this.Neck.setRotationPoint(0.0F, 3.6F, -5.4F);
        this.Neck.addBox(-3.0F, -7.0F, -8.0F, 6, 7, 8, 0.0F);
        this.setRotateAngle(Neck, 0.4886921905584123F, -0.0F, 0.0F);
        this.Head3 = new ModelRenderer(this, 15, 7);
        this.Head3.setRotationPoint(1.5F, -0.8F, -6.3F);
        this.Head3.addBox(-3.0F, 0.0F, -0.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(Head3, 0.06981317007977318F, -0.0F, 0.0F);
        this.RightEar = new ModelRenderer(this, 0, 31);
        this.RightEar.setRotationPoint(-2.0F, 1.0F, -2.8F);
        this.RightEar.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.beard = new ModelRenderer(this, 0, 7);
        this.beard.setRotationPoint(-0.5F, 8.4F, -2.0F);
        this.beard.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(beard, 0.4363323129985824F, 0.0F, 0.0F);
        this.Body2 = new ModelRenderer(this, 86, 41);
        this.Body2.setRotationPoint(-5.0F, 1.0F, -2.5F);
        this.Body2.addBox(0.0F, 0.0F, 0.0F, 10, 12, 11, 0.0F);
        this.BackRightLeg = new ModelRenderer(this, 0, 51);
        this.BackRightLeg.setRotationPoint(2.0F, 12.4F, 4.0F);
        this.BackRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 68);
        this.Tail2.setRotationPoint(0.0F, 6.5F, 0.1F);
        this.Tail2.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(Tail2, -0.2303834612632515F, -0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 0, 14);
        this.Mouth.setRotationPoint(0.5F, 9.5F, -2.7F);
        this.Mouth.addBox(-3.0F, 0.0F, 0.0F, 6, 2, 1, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 68);
        this.Tail1.setRotationPoint(4.5F, 0.9F, 4.8F);
        this.Tail1.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(Tail1, 0.3839724354387525F, -0.0F, 0.0F);
        this.RightHorn = new ModelRenderer(this, 26, 0);
        this.RightHorn.setRotationPoint(-1.5F, -1.5F, -7.5F);
        this.RightHorn.addBox(-3.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(RightHorn, 0.7853981633974483F, 0.0F, -0.5061454830783556F);
        this.Neck2 = new ModelRenderer(this, 86, 65);
        this.Neck2.setRotationPoint(-2.5F, -2.9F, -4.7F);
        this.Neck2.addBox(0.0F, 0.0F, 0.0F, 5, 4, 9, 0.0F);
        this.setRotateAngle(Neck2, -1.3658946726107624F, 0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 14, 44);
        this.Body1.setRotationPoint(-0.5F, -0.3F, -6.5F);
        this.Body1.addBox(0.0F, 0.0F, 0.0F, 11, 13, 7, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 0, 51);
        this.FrontRightLeg.setRotationPoint(2.0F, 12.4F, 4.0F);
        this.FrontRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.Body3.addChild(this.BackLeftLeg);
        this.Body1.addChild(this.FrontLeftLeg);
        this.Neck.addChild(this.Head1);
        this.Head1.addChild(this.Head2);
        this.Body2.addChild(this.Body3);
        this.Body1.addChild(this.Body4);
        this.Head1.addChild(this.LeftEar);
        this.Body4.addChild(this.Body5);
        this.Head1.addChild(this.LeftHorn);
        this.Head1.addChild(this.Head3);
        this.Head1.addChild(this.RightEar);
        this.Head1.addChild(this.beard);
        this.Body3.addChild(this.BackRightLeg);
        this.Tail1.addChild(this.Tail2);
        this.Head1.addChild(this.Mouth);
        this.Body3.addChild(this.Tail1);
        this.Head1.addChild(this.RightHorn);
        this.Neck.addChild(this.Neck2);
        this.Body2.addChild(this.Body1);
        this.Body1.addChild(this.FrontRightLeg);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Neck.render(f5);
        this.Body2.render(f5);
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

        this.Neck.rotateAngleX = headPitch * 0.017453292F;
        this.Neck.rotateAngleY = netHeadYaw * 0.017453292F;

        //this.body.rotateAngleX = ((float)Math.PI / 2F)-90;
        this.FrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.FrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BackLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
