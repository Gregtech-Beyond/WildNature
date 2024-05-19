package com.matez.wildnature.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCowBaby - Matheus
 * Created using Tabula 7.0.0
 */
public class ModelCowBaby extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer BackRightLeg;
    public ModelRenderer BackLeftLeg;
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer Tail1;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer Head1;
    public ModelRenderer Head2;
    public ModelRenderer Head3;
    public ModelRenderer Head4;
    public ModelRenderer Mouth;
    public ModelRenderer RightEar;
    public ModelRenderer LeftEar;

    public ModelCowBaby() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.LeftEar = new ModelRenderer(this, 0, 22);
        this.LeftEar.setRotationPoint(5.0F, -0.6F, -3.8F);
        this.LeftEar.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(LeftEar, 0.0F, 0.0F, -0.20943951023931953F);
        this.BackRightLeg = new ModelRenderer(this, 0, 51);
        this.BackRightLeg.setRotationPoint(1.75F, 7.5F, 12.0F);
        this.BackRightLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.FrontLeftLeg = new ModelRenderer(this, 0, 51);
        this.FrontLeftLeg.setRotationPoint(6.25F, 7.5F, 2.5F);
        this.FrontLeftLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.BackLeftLeg = new ModelRenderer(this, 0, 51);
        this.BackLeftLeg.setRotationPoint(6.25F, 7.5F, 12.0F);
        this.BackLeftLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 68);
        this.Tail1.setRotationPoint(3.5F, 0.6F, 12.9F);
        this.Tail1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(Tail1, 0.3839724354387525F, -0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 68);
        this.Tail2.setRotationPoint(0.0F, 4.5F, 0.1F);
        this.Tail2.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(Tail2, -0.2303834612632515F, -0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 77, 41);
        this.Body.setRotationPoint(-4.0F, 7.5F, -7.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 8, 8, 14, 0.0F);
        this.Head4 = new ModelRenderer(this, 67, 5);
        this.Head4.setRotationPoint(1.0F, -0.6F, -6.0F);
        this.Head4.addBox(-3.0F, 0.0F, -0.0F, 4, 1, 4, 0.0F);
        this.setRotateAngle(Head4, 0.06981317007977318F, -0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 30, 26);
        this.Neck.setRotationPoint(0.5F, 11.3F, -5.3F);
        this.Neck.addBox(-3.0F, -4.0F, -6.0F, 5, 6, 6, 0.0F);
        this.setRotateAngle(Neck, -0.5410520681182421F, 0.0F, 0.0F);
        this.Head2 = new ModelRenderer(this, 0, 0);
        this.Head2.setRotationPoint(-0.0F, 1.0F, -4.5F);
        this.Head2.addBox(-2.0F, 1.33F, -5.5F, 4, 3, 5, 0.0F);
        this.Head3 = new ModelRenderer(this, 19, 22);
        this.Head3.setRotationPoint(1.5F, 2.4F, -8.9F);
        this.Head3.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(Head3, 0.3490658503988659F, 0.0F, 0.0F);
        this.RightEar = new ModelRenderer(this, 0, 31);
        this.RightEar.setRotationPoint(-2.0F, 0.1F, -3.8F);
        this.RightEar.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(RightEar, 0.0F, -0.0F, 0.20943951023931953F);
        this.Tail3 = new ModelRenderer(this, 0, 38);
        this.Tail3.setRotationPoint(-0.5F, 3.7F, -0.5F);
        this.Tail3.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(Tail3, -0.153588974175501F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 36, 0);
        this.Head1.setRotationPoint(-0.5F, -5.2F, -4.9F);
        this.Head1.addBox(-3.0F, 0.0F, -7.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(Head1, 0.767944870877505F, 0.0F, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 0, 51);
        this.FrontRightLeg.setRotationPoint(1.75F, 7.5F, 2.5F);
        this.FrontRightLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.Mouth = new ModelRenderer(this, 41, 19);
        this.Mouth.setRotationPoint(1.5F, 5.1F, -9.5F);
        this.Mouth.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 5, 0.0F);
        this.setRotateAngle(Mouth, 0.06981317007977318F, -0.0F, 0.0F);
        this.Head1.addChild(this.LeftEar);
        this.Body.addChild(this.BackRightLeg);
        this.Body.addChild(this.FrontLeftLeg);
        this.Body.addChild(this.BackLeftLeg);
        this.Body.addChild(this.Tail1);
        this.Tail1.addChild(this.Tail2);
        this.Head1.addChild(this.Head4);
        this.Head1.addChild(this.Head2);
        this.Head1.addChild(this.Head3);
        this.Head1.addChild(this.RightEar);
        this.Tail2.addChild(this.Tail3);
        this.Neck.addChild(this.Head1);
        this.Body.addChild(this.FrontRightLeg);
        this.Head1.addChild(this.Mouth);
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

        this.Neck.rotateAngleX = headPitch * 0.017453292F-0.5F;
        this.Neck.rotateAngleY = netHeadYaw * 0.017453292F;

        //this.body.rotateAngleX = ((float)Math.PI / 2F)-90;
        this.FrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.FrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BackLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
