package com.matez.wildnature.entity.model;

import com.matez.wildnature.Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelGoatFemale - Matheus
 * Created using Tabula 7.0.0
 */
public class ModelGoatFemale extends ModelBase {
    public ModelRenderer tail;
    public ModelRenderer Neck;
    public ModelRenderer body;
    public ModelRenderer BackRightLeg;
    public ModelRenderer BackLeftLeg;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer Udders;
    public ModelRenderer head;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer head5;
    public ModelRenderer beard;
    public ModelRenderer ear1;
    public ModelRenderer ear2;
    public ModelRenderer RightHorn1;
    public ModelRenderer LeftHorn1;
    public ModelRenderer RightHorn2;
    public ModelRenderer LeftHorn2;

    public ModelGoatFemale() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.head2 = new ModelRenderer(this, 0, 15);
        this.head2.setRotationPoint(-3.5F, -1.6F, -11.2F);
        this.head2.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(head2, 0.03106686068549907F, -0.0F, 0.0F);
        this.body = new ModelRenderer(this, 30, 28);
        this.body.setRotationPoint(1.0F, 8.5F, 3.0F);
        this.body.addBox(-5.0F, -10.0F, -7.0F, 8, 15, 8, 0.0F);
        this.setRotateAngle(body, 1.5707963705062866F, -0.0F, 0.0F);
        this.beard = new ModelRenderer(this, 9, 7);
        this.beard.setRotationPoint(-2.0F, 1.8F, -9.8F);
        this.beard.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.RightHorn1 = new ModelRenderer(this, 0, 0);
        this.RightHorn1.setRotationPoint(-4.0F, -6.6F, -4.6F);
        this.RightHorn1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(RightHorn1, -0.4363323129985824F, -0.0F, -0.3141592653589793F);
        this.Neck = new ModelRenderer(this, 30, 14);
        this.Neck.setRotationPoint(0.0F, 11.0F, -5.0F);
        this.Neck.addBox(-2.0F, -3.0F, -8.5F, 4, 5, 8, 0.0F);
        this.setRotateAngle(Neck, -0.9599310885968813F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 70, 0);
        this.head.setRotationPoint(1.5F, -3.0F, -3.4F);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 5, 6, 6, 0.0F);
        this.setRotateAngle(head, 1.0471975511965976F, 0.0F, 0.0F);
        this.BackLeftLeg = new ModelRenderer(this, 0, 40);
        this.BackLeftLeg.setRotationPoint(2.4F, 14.0F, 6.0F);
        this.BackLeftLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.LeftHorn2 = new ModelRenderer(this, 3, 5);
        this.LeftHorn2.setRotationPoint(0.2F, -2.8F, 0.9F);
        this.LeftHorn2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LeftHorn2, -0.12217304763960307F, -0.0F, 0.05235987755982988F);
        this.tail = new ModelRenderer(this, 20, 40);
        this.tail.setRotationPoint(-0.5F, 10.2F, 7.5F);
        this.tail.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(tail, 1.9266689612765404F, -0.0F, 0.0F);
        this.head5 = new ModelRenderer(this, 100, 0);
        this.head5.setRotationPoint(-3.5F, -4.7F, -7.0F);
        this.head5.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
        this.FrontLeftLeg = new ModelRenderer(this, 0, 40);
        this.FrontLeftLeg.setRotationPoint(2.4F, 14.0F, -4.5F);
        this.FrontLeftLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.head4 = new ModelRenderer(this, 0, 23);
        this.head4.setRotationPoint(-3.0F, 1.0F, -10.7F);
        this.head4.addBox(0.0F, 0.0F, 0.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(head4, 0.04293509959906051F, -0.0F, 0.0F);
        this.head3 = new ModelRenderer(this, 81, 31);
        this.head3.setRotationPoint(-3.0F, -1.5F, -10.8F);
        this.head3.addBox(0.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
        this.setRotateAngle(head3, 0.6609561877302526F, -0.0F, 0.0F);
        this.RightHorn2 = new ModelRenderer(this, 3, 5);
        this.RightHorn2.setRotationPoint(-0.2F, -2.8F, 0.9F);
        this.RightHorn2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(RightHorn2, -0.12217304763960307F, 0.0F, -0.05235987755982988F);
        this.ear1 = new ModelRenderer(this, 40, 0);
        this.ear1.setRotationPoint(-6.7F, -2.8F, -5.0F);
        this.ear1.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(ear1, 0.0F, -0.0F, -0.3490658503988659F);
        this.BackRightLeg = new ModelRenderer(this, 0, 40);
        this.BackRightLeg.setRotationPoint(-2.4F, 14.0F, 6.0F);
        this.BackRightLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.Udders = new ModelRenderer(this, 12, 0);
        this.Udders.setRotationPoint(-1.5F, 14.5F, 2.0F);
        this.Udders.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 0, 40);
        this.FrontRightLeg.setRotationPoint(-2.4F, 14.0F, -4.5F);
        this.FrontRightLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.ear2 = new ModelRenderer(this, 40, 0);
        this.ear2.setRotationPoint(0.8F, -3.8F, -5.0F);
        this.ear2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(ear2, 0.0F, -0.0F, 0.3490658503988659F);
        this.LeftHorn1 = new ModelRenderer(this, 0, 0);
        this.LeftHorn1.setRotationPoint(0.0F, -6.9F, -4.8F);
        this.LeftHorn1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(LeftHorn1, -0.3490658503988659F, -0.0F, 0.3141592653589793F);
        this.head.addChild(this.head2);
        this.head.addChild(this.beard);
        this.head.addChild(this.RightHorn1);
        this.Neck.addChild(this.head);
        this.LeftHorn1.addChild(this.LeftHorn2);
        this.head.addChild(this.head5);
        this.head.addChild(this.head4);
        this.head.addChild(this.head3);
        this.RightHorn1.addChild(this.RightHorn2);
        this.head.addChild(this.ear1);
        this.head.addChild(this.ear2);
        this.head.addChild(this.LeftHorn1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
        this.Neck.render(f5);
        this.BackLeftLeg.render(f5);
        this.tail.render(f5);
        this.FrontLeftLeg.render(f5);
        this.BackRightLeg.render(f5);
        this.Udders.render(f5);
        this.FrontRightLeg.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    private float atail = -0.1F,btail = 0;
    private int randomizeTail = 0;
    private double maxRotation=1.1;
    boolean canMoveTail=true;

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {

        this.Neck.rotateAngleX = headPitch * 0.017453292F-1;
        this.Neck.rotateAngleY = netHeadYaw * 0.017453292F;

        //this.body.rotateAngleX = ((float)Math.PI / 2F)-90;
        this.FrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.FrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BackLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        if(Main.generateRandomInt(0,45)==0){
            atail=-0.1F;
            randomizeTail=Main.generateRandomInt(1,4);
            canMoveTail=true;
        }

        if(canMoveTail){
            btail = btail + atail;
            if (btail > maxRotation) {
                atail = -0.1F;
            } else if (btail < -maxRotation) {
                atail = 0.1F;
                randomizeTail--;
            }
        }

        if (btail == 0) {
            if (randomizeTail <= 0) {
                atail = 0;
                canMoveTail=false;
            }
        }



        this.tail.rotateAngleY = btail;

    }
}
