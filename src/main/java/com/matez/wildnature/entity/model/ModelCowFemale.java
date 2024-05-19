package com.matez.wildnature.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCowFemale - Matheus
 * Created using Tabula 7.0.0
 */
public class ModelCowFemale extends ModelBase {
    public ModelRenderer Udders;
    public ModelRenderer Udder1;
    public ModelRenderer Udder2;
    public ModelRenderer Udder3;
    public ModelRenderer Udder4;
    public ModelRenderer Body2;
    public ModelRenderer Neck;
    public ModelRenderer Body1;
    public ModelRenderer Body3;
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer Tail1;
    public ModelRenderer BackRightLeg;
    public ModelRenderer BackLeftLeg;
    public ModelRenderer SmallUdders;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer Head1;
    public ModelRenderer Head2;
    public ModelRenderer Head3;
    public ModelRenderer Head4;
    public ModelRenderer Mouth;
    public ModelRenderer RightEar;
    public ModelRenderer LeftEar;
    public ModelRenderer Horns;
    public ModelRenderer RightHorn;
    public ModelRenderer LeftHorn;

    public ModelCowFemale() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Head1 = new ModelRenderer(this, 36, 0);
        this.Head1.setRotationPoint(-0.5F, -7.5F, -9.5F);
        this.Head1.addBox(-3.0F, 0.0F, -7.0F, 7, 7, 7, 0.0F);
        this.setRotateAngle(Head1, 0.593411945678072F, 0.0F, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 0, 51);
        this.FrontRightLeg.setRotationPoint(2.0F, 12.4F, 4.0F);
        this.FrontRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.Head2 = new ModelRenderer(this, 0, 0);
        this.Head2.setRotationPoint(0.0F, 1.0F, -5.9F);
        this.Head2.addBox(-2.0F, 1.33F, -5.5F, 5, 4, 6, 0.0F);
        this.Udder4 = new ModelRenderer(this, 87, 31);
        this.Udder4.setRotationPoint(1.0F, 15.0F, 11.0F);
        this.Udder4.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.RightEar = new ModelRenderer(this, 0, 31);
        this.RightEar.setRotationPoint(-2.0F, 0.4F, -2.8F);
        this.RightEar.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(RightEar, 0.0F, -0.0F, 0.20943951023931953F);
        this.LeftHorn = new ModelRenderer(this, 26, 0);
        this.LeftHorn.setRotationPoint(6.8F, -1.0F, -4.1F);
        this.LeftHorn.addBox(-3.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(LeftHorn, 0.2617993877991494F, -0.0F, 0.5061454830783556F);
        this.Udder3 = new ModelRenderer(this, 87, 31);
        this.Udder3.setRotationPoint(-2.0F, 15.0F, 11.0F);
        this.Udder3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.BackLeftLeg = new ModelRenderer(this, 0, 51);
        this.BackLeftLeg.setRotationPoint(9.0F, 12.4F, 4.0F);
        this.BackLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.Mouth = new ModelRenderer(this, 41, 19);
        this.Mouth.setRotationPoint(1.5F, 6.1F, -10.8F);
        this.Mouth.addBox(-3.0F, 0.0F, 0.0F, 4, 1, 6, 0.0F);
        this.setRotateAngle(Mouth, 0.06981317007977318F, -0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 14, 44);
        this.Body1.setRotationPoint(-0.5F, -0.3F, -6.5F);
        this.Body1.addBox(0.0F, 0.0F, 0.0F, 11, 13, 7, 0.0F);
        this.Head4 = new ModelRenderer(this, 67, 5);
        this.Head4.setRotationPoint(1.0F, -0.6F, -5.0F);
        this.Head4.addBox(-3.0F, 0.0F, -0.0F, 5, 1, 4, 0.0F);
        this.setRotateAngle(Head4, 0.06981317007977318F, -0.0F, 0.0F);
        this.Horns = new ModelRenderer(this, 68, 0);
        this.Horns.setRotationPoint(0.0F, -1.2F, -3.7F);
        this.Horns.addBox(-3.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
        this.setRotateAngle(Horns, 0.24434609527920614F, 0.0F, 0.0F);
        this.LeftEar = new ModelRenderer(this, 0, 22);
        this.LeftEar.setRotationPoint(6.0F, -0.4F, -2.8F);
        this.LeftEar.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(LeftEar, 0.0F, 0.0F, -0.20943951023931953F);
        this.Body2 = new ModelRenderer(this, 86, 41);
        this.Body2.setRotationPoint(-5.0F, 1.0F, -2.5F);
        this.Body2.addBox(0.0F, 0.0F, 0.0F, 10, 12, 11, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 68);
        this.Tail2.setRotationPoint(0.0F, 6.5F, 0.1F);
        this.Tail2.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(Tail2, -0.2303834612632515F, -0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 30, 26);
        this.Neck.setRotationPoint(0.0F, 9.0F, -5.0F);
        this.Neck.addBox(-3.0F, -7.0F, -10.0F, 6, 7, 10, 0.0F);
        this.setRotateAngle(Neck, -0.3665191429188092F, 0.0F, 0.0F);
        this.Udder1 = new ModelRenderer(this, 87, 31);
        this.Udder1.setRotationPoint(1.0F, 15.0F, 8.0F);
        this.Udder1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.FrontLeftLeg = new ModelRenderer(this, 0, 51);
        this.FrontLeftLeg.setRotationPoint(9.0F, 12.4F, 4.0F);
        this.FrontLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.Udders = new ModelRenderer(this, 86, 30);
        this.Udders.setRotationPoint(-3.0F, 12.5F, 7.0F);
        this.Udders.addBox(0.0F, 0.0F, 0.0F, 6, 4, 6, 0.0F);
        this.Body3 = new ModelRenderer(this, 50, 44);
        this.Body3.setRotationPoint(-0.5F, -0.3F, 10.5F);
        this.Body3.addBox(0.0F, 0.0F, 0.0F, 11, 13, 7, 0.0F);
        this.SmallUdders = new ModelRenderer(this, 106, 26);
        this.SmallUdders.setRotationPoint(3.5F, 12.0F, -1.0F);
        this.SmallUdders.addBox(0.0F, 0.0F, 0.0F, 4, 2, 6, 0.0F);
        this.Udder2 = new ModelRenderer(this, 87, 31);
        this.Udder2.setRotationPoint(-2.0F, 15.0F, 8.0F);
        this.Udder2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.BackRightLeg = new ModelRenderer(this, 0, 51);
        this.BackRightLeg.setRotationPoint(2.0F, 12.4F, 4.0F);
        this.BackRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 68);
        this.Tail1.setRotationPoint(4.5F, 0.9F, 4.8F);
        this.Tail1.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(Tail1, 0.3839724354387525F, -0.0F, 0.0F);
        this.RightHorn = new ModelRenderer(this, 26, 0);
        this.RightHorn.setRotationPoint(-1.3F, -3.6F, -4.1F);
        this.RightHorn.addBox(-3.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(RightHorn, 0.2617993877991494F, 0.0F, -0.5061454830783556F);
        this.Tail3 = new ModelRenderer(this, 0, 38);
        this.Tail3.setRotationPoint(-0.5F, 5.7F, -0.5F);
        this.Tail3.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(Tail3, -0.153588974175501F, 0.0F, 0.0F);
        this.Head3 = new ModelRenderer(this, 19, 22);
        this.Head3.setRotationPoint(1.5F, 2.6F, -10.3F);
        this.Head3.addBox(-3.0F, 0.0F, 0.0F, 4, 1, 5, 0.0F);
        this.setRotateAngle(Head3, 0.2617993877991494F, 0.0F, 0.0F);
        this.Neck.addChild(this.Head1);
        this.Body1.addChild(this.FrontRightLeg);
        this.Head1.addChild(this.Head2);
        this.Head1.addChild(this.RightEar);
        this.Head1.addChild(this.LeftHorn);
        this.Body3.addChild(this.BackLeftLeg);
        this.Head1.addChild(this.Mouth);
        this.Body2.addChild(this.Body1);
        this.Head1.addChild(this.Head4);
        this.Head1.addChild(this.Horns);
        this.Head1.addChild(this.LeftEar);
        this.Tail1.addChild(this.Tail2);
        this.Body1.addChild(this.FrontLeftLeg);
        this.Body2.addChild(this.Body3);
        this.Body3.addChild(this.SmallUdders);
        this.Body3.addChild(this.BackRightLeg);
        this.Body3.addChild(this.Tail1);
        this.Head1.addChild(this.RightHorn);
        this.Tail2.addChild(this.Tail3);
        this.Head1.addChild(this.Head3);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Udder4.render(f5);
        this.Udder3.render(f5);
        this.Body2.render(f5);
        this.Neck.render(f5);
        this.Udder1.render(f5);
        this.Udders.render(f5);
        this.Udder2.render(f5);
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

        this.Neck.rotateAngleX = headPitch * 0.017453292F-0.5F;
        this.Neck.rotateAngleY = netHeadYaw * 0.017453292F;

        //this.body.rotateAngleX = ((float)Math.PI / 2F)-90;
        this.FrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.FrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BackLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
