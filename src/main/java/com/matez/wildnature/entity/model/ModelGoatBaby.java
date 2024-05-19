package com.matez.wildnature.entity.model;

import com.matez.wildnature.Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelGoatBaby - Matheus
 * Created using Tabula 7.0.0
 */
public class ModelGoatBaby extends ModelBase {
    public ModelRenderer neck;
    public ModelRenderer Tail;
    public ModelRenderer body;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer head;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer head5;
    public ModelRenderer ear1;
    public ModelRenderer ear2;

    public ModelGoatBaby() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.leg2 = new ModelRenderer(this, 65, 11);
        this.leg2.setRotationPoint(1.5F, 18.0F, 4.0F);
        this.leg2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.leg4 = new ModelRenderer(this, 65, 11);
        this.leg4.setRotationPoint(1.5F, 18.0F, -2.5F);
        this.leg4.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.ear1 = new ModelRenderer(this, 18, 0);
        this.ear1.setRotationPoint(1.3F, 0.8F, -2.0F);
        this.ear1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(ear1, 0.08726646259971647F, 0.0F, -0.8726646259971648F);
        this.Tail = new ModelRenderer(this, 14, 17);
        this.Tail.setRotationPoint(-0.5F, 14.5F, 4.0F);
        this.Tail.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Tail, 0.4597754776477814F, 0.0F, 0.0F);
        this.leg1 = new ModelRenderer(this, 65, 11);
        this.leg1.setRotationPoint(-1.5F, 18.0F, 4.0F);
        this.leg1.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.setRotationPoint(-2.5F, 13.5F, -3.799999952316284F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 5, 5, 9, 0.0F);
        this.ear2 = new ModelRenderer(this, 18, 0);
        this.ear2.setRotationPoint(-1.9F, 0.1F, -2.0F);
        this.ear2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(ear2, 0.08726646259971647F, 0.0F, 0.8726646259971648F);
        this.head3 = new ModelRenderer(this, 50, 1);
        this.head3.setRotationPoint(0.0F, 4.5F, -5.2F);
        this.head3.addBox(-1.0F, -1.0F, 1.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(head3, 0.17453292519943295F, 0.0F, 0.0F);
        this.head4 = new ModelRenderer(this, 0, 8);
        this.head4.setRotationPoint(-1.5F, -0.5F, -2.5F);
        this.head4.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
        this.head5 = new ModelRenderer(this, 35, 0);
        this.head5.setRotationPoint(-0.5F, 2.0F, -5.9F);
        this.head5.addBox(-1.0F, 0.0F, 1.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(head5, 0.08726646259971647F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 25);
        this.neck.setRotationPoint(0.0F, 16.4F, -2.4F);
        this.neck.addBox(-1.5F, -1.5F, -6.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(neck, -1.0471975511965976F, 0.0F, 0.0F);
        this.head2 = new ModelRenderer(this, 61, 1);
        this.head2.setRotationPoint(0.0F, 3.6F, -4.8F);
        this.head2.addBox(-1.0F, -1.0F, 1.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(head2, 0.8028514559173915F, 0.0F, 0.0F);
        this.leg3 = new ModelRenderer(this, 65, 11);
        this.leg3.setRotationPoint(-1.5F, 18.0F, -2.5F);
        this.leg3.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -1.8F, -5.5F);
        this.head.addBox(-2.0F, 0.0F, -3.0F, 4, 4, 3, 0.0F);
        this.setRotateAngle(head, 0.9599310885968813F, 0.0F, 0.0F);
        this.head.addChild(this.ear1);
        this.head.addChild(this.ear2);
        this.head.addChild(this.head3);
        this.head.addChild(this.head4);
        this.head.addChild(this.head5);
        this.head.addChild(this.head2);
        this.neck.addChild(this.head);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.leg2.render(f5);
        this.leg4.render(f5);
        this.Tail.render(f5);
        this.leg1.render(f5);
        this.body.render(f5);
        this.neck.render(f5);
        this.leg3.render(f5);
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

        this.neck.rotateAngleX = headPitch * 0.017453292F-1;
        this.neck.rotateAngleY = netHeadYaw * 0.017453292F;

        //this.body.rotateAngleX = ((float)Math.PI / 2F)-90;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

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



        this.Tail.rotateAngleY = btail;

    }
}
