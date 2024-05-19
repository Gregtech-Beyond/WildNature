package com.matez.wildnature.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCowMale - Matheus
 * Created using Tabula 7.0.0
 */
public class ModelCowMale extends ModelBase {
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
    public ModelRenderer Tail3;
    public ModelRenderer Head1;
    public ModelRenderer Neck2;
    public ModelRenderer Head2;
    public ModelRenderer Head3;
    public ModelRenderer Head4;
    public ModelRenderer Mouth;
    public ModelRenderer RightEar;
    public ModelRenderer LeftEar;
    public ModelRenderer Horns;
    public ModelRenderer RightHorn;
    public ModelRenderer LeftHorn;

    public ModelCowMale() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.FrontLeftLeg = new ModelRenderer(this, 0, 51);
        this.FrontLeftLeg.setRotationPoint(9.0F, 12.4F, 4.0F);
        this.FrontLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.Body5 = new ModelRenderer(this, 10, 65);
        this.Body5.setRotationPoint(0.5F, 0.0F, 7.5F);
        this.Body5.addBox(0.0F, 0.0F, 0.0F, 8, 3, 14, 0.0F);
        this.setRotateAngle(Body5, -0.15707963267948966F, 0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 14, 44);
        this.Body1.setRotationPoint(-0.5F, -0.3F, -6.5F);
        this.Body1.addBox(0.0F, 0.0F, 0.0F, 11, 13, 7, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 68);
        this.Tail1.setRotationPoint(4.5F, 0.9F, 4.8F);
        this.Tail1.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(Tail1, 0.3839724354387525F, -0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 36, 0);
        this.Head1.setRotationPoint(-0.5F, -7.4F, -5.5F);
        this.Head1.addBox(-3.0F, 0.0F, -7.0F, 7, 7, 7, 0.0F);
        this.setRotateAngle(Head1, 0.22689280275926282F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 86, 65);
        this.Neck2.setRotationPoint(-2.5F, -4.0F, -7.0F);
        this.Neck2.addBox(0.0F, 0.0F, 0.0F, 5, 4, 9, 0.0F);
        this.setRotateAngle(Neck2, -0.6457718232379019F, 0.0F, 0.0F);
        this.RightHorn = new ModelRenderer(this, 26, 0);
        this.RightHorn.setRotationPoint(-1.8F, -4.3F, -4.3F);
        this.RightHorn.addBox(-3.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(RightHorn, 0.2617993877991494F, 0.0F, -0.5061454830783556F);
        this.Tail3 = new ModelRenderer(this, 0, 38);
        this.Tail3.setRotationPoint(-0.5F, 5.7F, -0.5F);
        this.Tail3.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(Tail3, -0.153588974175501F, 0.0F, 0.0F);
        this.BackRightLeg = new ModelRenderer(this, 0, 51);
        this.BackRightLeg.setRotationPoint(2.0F, 12.4F, 4.0F);
        this.BackRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.Head2 = new ModelRenderer(this, 0, 0);
        this.Head2.setRotationPoint(0.0F, 1.0F, -5.9F);
        this.Head2.addBox(-2.0F, 1.33F, -5.5F, 5, 4, 6, 0.0F);
        this.LeftHorn = new ModelRenderer(this, 26, 0);
        this.LeftHorn.setRotationPoint(7.3F, -1.7F, -4.3F);
        this.LeftHorn.addBox(-3.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LeftHorn, 0.2617993877991494F, -0.0F, 0.5061454830783556F);
        this.Body3 = new ModelRenderer(this, 50, 44);
        this.Body3.setRotationPoint(-0.5F, -0.3F, 10.5F);
        this.Body3.addBox(0.0F, 0.0F, 0.0F, 11, 13, 7, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 68);
        this.Tail2.setRotationPoint(0.0F, 6.5F, 0.1F);
        this.Tail2.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(Tail2, -0.2303834612632515F, -0.0F, 0.0F);
        this.Horns = new ModelRenderer(this, 68, 0);
        this.Horns.setRotationPoint(0.0F, -1.2F, -3.7F);
        this.Horns.addBox(-3.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
        this.setRotateAngle(Horns, 0.24434609527920614F, 0.0F, 0.0F);
        this.Head3 = new ModelRenderer(this, 19, 22);
        this.Head3.setRotationPoint(1.5F, 2.6F, -10.3F);
        this.Head3.addBox(-3.0F, 0.0F, 0.0F, 4, 1, 5, 0.0F);
        this.setRotateAngle(Head3, 0.2617993877991494F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 41, 19);
        this.Mouth.setRotationPoint(1.5F, 6.1F, -10.8F);
        this.Mouth.addBox(-3.0F, 0.0F, 0.0F, 4, 1, 6, 0.0F);
        this.setRotateAngle(Mouth, 0.06981317007977318F, -0.0F, 0.0F);
        this.RightEar = new ModelRenderer(this, 0, 31);
        this.RightEar.setRotationPoint(-2.0F, 0.4F, -2.8F);
        this.RightEar.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(RightEar, 0.0F, -0.0F, 0.20943951023931953F);
        this.FrontRightLeg = new ModelRenderer(this, 0, 51);
        this.FrontRightLeg.setRotationPoint(2.0F, 12.4F, 4.0F);
        this.FrontRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.LeftEar = new ModelRenderer(this, 0, 22);
        this.LeftEar.setRotationPoint(6.0F, -0.4F, -2.8F);
        this.LeftEar.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(LeftEar, 0.0F, 0.0F, -0.20943951023931953F);
        this.Head4 = new ModelRenderer(this, 67, 5);
        this.Head4.setRotationPoint(1.0F, -0.6F, -5.0F);
        this.Head4.addBox(-3.0F, 0.0F, -0.0F, 5, 1, 4, 0.0F);
        this.setRotateAngle(Head4, 0.06981317007977318F, -0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 25, 30);
        this.Neck.setRotationPoint(0.0F, 6.1F, -6.5F);
        this.Neck.addBox(-3.0F, -7.0F, -6.0F, 6, 7, 6, 0.0F);
        this.setRotateAngle(Neck, -0.017453292519943295F, -0.0F, 0.0F);
        this.Body4 = new ModelRenderer(this, 51, 77);
        this.Body4.setRotationPoint(1.0F, -1.6F, 0.0F);
        this.Body4.addBox(0.0F, 0.0F, 0.0F, 9, 3, 8, 0.0F);
        this.Body2 = new ModelRenderer(this, 86, 41);
        this.Body2.setRotationPoint(-5.0F, 1.0F, -2.5F);
        this.Body2.addBox(0.0F, 0.0F, 0.0F, 10, 12, 11, 0.0F);
        this.BackLeftLeg = new ModelRenderer(this, 0, 51);
        this.BackLeftLeg.setRotationPoint(9.0F, 12.4F, 4.0F);
        this.BackLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.Body1.addChild(this.FrontLeftLeg);
        this.Body4.addChild(this.Body5);
        this.Body2.addChild(this.Body1);
        this.Body3.addChild(this.Tail1);
        this.Neck.addChild(this.Head1);
        this.Neck.addChild(this.Neck2);
        this.Head1.addChild(this.RightHorn);
        this.Tail2.addChild(this.Tail3);
        this.Body3.addChild(this.BackRightLeg);
        this.Head1.addChild(this.Head2);
        this.Head1.addChild(this.LeftHorn);
        this.Body2.addChild(this.Body3);
        this.Tail1.addChild(this.Tail2);
        this.Head1.addChild(this.Horns);
        this.Head1.addChild(this.Head3);
        this.Head1.addChild(this.Mouth);
        this.Head1.addChild(this.RightEar);
        this.Body1.addChild(this.FrontRightLeg);
        this.Head1.addChild(this.LeftEar);
        this.Head1.addChild(this.Head4);
        this.Body1.addChild(this.Body4);
        this.Body3.addChild(this.BackLeftLeg);
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
