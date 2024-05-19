package com.matez.wildnature.entity.model;

import com.matez.wildnature.Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * CamelMale - Matheus
 * Created using Tabula 7.0.0
 */
public class ModelCamelMale extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer Neck;
    public ModelRenderer Tail1;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer Body2;
    public ModelRenderer Body3;
    public ModelRenderer Tail2;
    public ModelRenderer Body4;
    public ModelRenderer Body5;
    public ModelRenderer Neck2;
    public ModelRenderer Head1;
    public ModelRenderer Head2;
    public ModelRenderer Head3;
    public ModelRenderer Head4;
    public ModelRenderer Mouth;
    public ModelRenderer RightEar;
    public ModelRenderer LeftEar;

    public ModelCamelMale() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.RightEar = new ModelRenderer(this, 0, 31);
        this.RightEar.setRotationPoint(-2.9F, 1.9F, -2.8F);
        this.RightEar.addBox(-3.0F, 0.0F, 0.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(RightEar, 0.0F, -0.0F, 2.6179938779914944F);
        this.leg3 = new ModelRenderer(this, 0, 51);
        this.leg3.setRotationPoint(9.5F, 12.4F, 4.0F);
        this.leg3.addBox(-1.5F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 51);
        this.leg1.setRotationPoint(2.0F, 12.4F, 22.5F);
        this.leg1.addBox(-1.5F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
        this.Head2 = new ModelRenderer(this, 0, 0);
        this.Head2.setRotationPoint(0.0F, 1.0F, -5.9F);
        this.Head2.addBox(-2.0F, 1.33F, -5.5F, 5, 4, 6, 0.0F);
        this.Body4 = new ModelRenderer(this, 0, 98);
        this.Body4.setRotationPoint(0.5F, 1.0F, 4.0F);
        this.Body4.addBox(0.0F, 0.0F, 0.0F, 5, 7, 2, 0.0F);
        this.setRotateAngle(Body4, 0.4363323129985824F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 41, 19);
        this.Mouth.setRotationPoint(1.5F, 6.1F, -10.8F);
        this.Mouth.addBox(-3.0F, 0.0F, 0.0F, 4, 1, 6, 0.0F);
        this.setRotateAngle(Mouth, 0.06981317007977318F, -0.0F, 0.0F);
        this.leg2 = new ModelRenderer(this, 0, 51);
        this.leg2.setRotationPoint(9.0F, 12.4F, 22.5F);
        this.leg2.addBox(-1.5F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
        this.Tail2 = new ModelRenderer(this, 16, 68);
        this.Tail2.setRotationPoint(0.5F, 8.5F, 0.6F);
        this.Tail2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Tail2, -0.2303834612632515F, -0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 36, 0);
        this.Head1.setRotationPoint(-0.5F, -7.7F, -9.8F);
        this.Head1.addBox(-3.0F, 0.0F, -7.0F, 7, 7, 7, 0.0F);
        this.setRotateAngle(Head1, 0.9948376736367678F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 30, 68);
        this.Tail1.setRotationPoint(4.5F, 0.9F, 23.0F);
        this.Tail1.addBox(0.0F, 0.0F, 0.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(Tail1, 0.3839724354387525F, -0.0F, 0.0F);
        this.Body2 = new ModelRenderer(this, 0, 82);
        this.Body2.setRotationPoint(2.5F, -7.0F, 3.0F);
        this.Body2.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6, 0.0F);
        this.setRotateAngle(Body2, -0.2617993877991494F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 20, 45);
        this.Neck.setRotationPoint(0.0F, 2.0999999999999996F, -7.5F);
        this.Neck.addBox(-3.5F, -4.0F, -8.0F, 7, 8, 8, 0.0F);
        this.setRotateAngle(Neck, -0.2792526803190927F, 0.0F, 0.0F);
        this.Head4 = new ModelRenderer(this, 67, 5);
        this.Head4.setRotationPoint(0.5F, -1.1F, -6.0F);
        this.Head4.addBox(-3.0F, 0.0F, -0.0F, 6, 2, 5, 0.0F);
        this.setRotateAngle(Head4, 0.06981317007977318F, 0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 54, 90);
        this.Body1.setRotationPoint(-5.5F, -2.3000000000000003F, -10.5F);
        this.Body1.addBox(0.0F, 0.0F, 0.0F, 11, 13, 25, 0.0F);
        this.Body3 = new ModelRenderer(this, 0, 82);
        this.Body3.setRotationPoint(2.5F, -6.5F, 16.5F);
        this.Body3.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6, 0.0F);
        this.setRotateAngle(Body3, -0.2617993877991494F, 0.0F, 0.0F);
        this.Body5 = new ModelRenderer(this, 0, 98);
        this.Body5.setRotationPoint(0.5F, 1.0F, 4.0F);
        this.Body5.addBox(0.0F, 0.0F, 0.0F, 5, 7, 2, 0.0F);
        this.setRotateAngle(Body5, 0.4363323129985824F, 0.0F, 0.0F);
        this.leg4 = new ModelRenderer(this, 0, 51);
        this.leg4.setRotationPoint(2.0F, 12.4F, 4.0F);
        this.leg4.addBox(-1.5F, 0.0F, -2.0F, 3, 14, 4, 0.0F);
        this.Neck2 = new ModelRenderer(this, 30, 26);
        this.Neck2.setRotationPoint(0.0F, 3.8F, -7.5F);
        this.Neck2.addBox(-3.0F, -7.0F, -10.0F, 6, 7, 10, 0.0F);
        this.setRotateAngle(Neck2, -0.5585053606381855F, -0.0F, 0.0F);
        this.LeftEar = new ModelRenderer(this, 0, 22);
        this.LeftEar.setRotationPoint(0.5F, -0.1F, -2.8F);
        this.LeftEar.addBox(-3.0F, 0.0F, 0.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(LeftEar, 0.0F, 0.0F, -2.6179938779914944F);
        this.Head3 = new ModelRenderer(this, 19, 22);
        this.Head3.setRotationPoint(1.5F, 2.5F, -10.4F);
        this.Head3.addBox(-3.0F, 0.0F, 0.0F, 4, 1, 5, 0.0F);
        this.setRotateAngle(Head3, 0.3490658503988659F, 0.0F, 0.0F);
        this.Head1.addChild(this.RightEar);
        this.Body1.addChild(this.leg3);
        this.Body1.addChild(this.leg1);
        this.Head1.addChild(this.Head2);
        this.Body2.addChild(this.Body4);
        this.Head1.addChild(this.Mouth);
        this.Body1.addChild(this.leg2);
        this.Tail1.addChild(this.Tail2);
        this.Neck2.addChild(this.Head1);
        this.Body1.addChild(this.Tail1);
        this.Body1.addChild(this.Body2);
        this.Head1.addChild(this.Head4);
        this.Body1.addChild(this.Body3);
        this.Body3.addChild(this.Body5);
        this.Body1.addChild(this.leg4);
        this.Neck.addChild(this.Neck2);
        this.Head1.addChild(this.LeftEar);
        this.Head1.addChild(this.Head3);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Neck.render(f5);
        this.Body1.render(f5);
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

        this.Neck.rotateAngleX = headPitch * 0.017453292F - 0.3F;
        this.Neck.rotateAngleY = netHeadYaw * 0.017453292F;

        //this.body.rotateAngleX = ((float)Math.PI / 2F)-90;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
