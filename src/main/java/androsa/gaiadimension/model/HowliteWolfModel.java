package androsa.gaiadimension.model;

import androsa.gaiadimension.entity.HowliteWolfEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * ModelSlime - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class HowliteWolfModel extends EntityModel<HowliteWolfEntity> {
    RendererModel body;
    RendererModel leg1;
    RendererModel leg2;
    RendererModel leg3;
    RendererModel leg4;
    RendererModel head;
    RendererModel ear1;
    RendererModel ear2;
    RendererModel nose;
    RendererModel tail1;
    RendererModel tail2;

    public HowliteWolfModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        //leg4
        this.leg4 = new RendererModel(this, 20, 0);
        this.leg4.setRotationPoint(0.5F, 16.0F, -4.0F);
        this.leg4.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        //leg1
        this.leg1 = new RendererModel(this, 20, 10);
        this.leg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
        this.leg1.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        //leg3
        this.leg3 = new RendererModel(this, 36, 10);
        this.leg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
        this.leg3.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        //nose
        this.nose = new RendererModel(this, 46, 5);
        this.nose.setRotationPoint(-1.5F, 0.8F, -5.0F);
        this.nose.addBox(0.0F, 0.0F, 0.0F, 3, 2, 4, 0.0F);
        //tail1
        this.tail1 = new RendererModel(this, 44, 11);
        this.tail1.setRotationPoint(-1.0F, 13.0F, 6.5F);
        this.tail1.addBox(0.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotation(tail1, 1.3062044121925562F, 0.0F, 0.0F);
        //leg2
        this.leg2 = new RendererModel(this, 28, 10);
        this.leg2.setRotationPoint(0.5F, 16.0F, 7.0F);
        this.leg2.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        //head
        this.head = new RendererModel(this, 28, 0);
        this.head.setRotationPoint(0.0F, 13.5F, -7.0F);
        this.head.addBox(-2.5F, -3.0F, -2.0F, 5, 6, 4, 0.0F);
        //ear1
        this.ear1 = new RendererModel(this, 46, 0);
        this.ear1.setRotationPoint(-2.0F, -2.5F, 0.0F);
        this.ear1.addBox(-1.0F, -4.0F, 0.0F, 2, 4, 1, 0.0F);
        this.setRotation(ear1, 0.0F, 0.0F, -0.136659280431156F);
        //tail2
        this.tail2 = new RendererModel(this, 52, 11);
        this.tail2.setRotationPoint(0.0F, 7.0F, -1.0F);
        this.tail2.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        this.setRotation(tail2, 0.6818213656395611F, 0.0F, 0.0F);
        //body
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(0.5F, 14.0F, -3.0F);
        this.body.addBox(-3.0F, -2.0F, -3.0F, 5, 12, 5, 0.0F);
        this.setRotation(body, 1.5707963267948966F, 0.0F, 0.0F);
        //ear2
        this.ear2 = new RendererModel(this, 52, 0);
        this.ear2.setRotationPoint(2.0F, -2.5F, 0.0F);
        this.ear2.addBox(-1.0F, -4.0F, 0.0F, 2, 4, 1, 0.0F);
        this.setRotation(ear2, 0.0F, 0.0F, 0.136659280431156F);

        head.addChild(ear1);
        head.addChild(ear2);
        head.addChild(nose);
        tail1.addChild(tail2);
    }

    @Override
    public void render(HowliteWolfEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(entity, f, f1, f2, f3, f4, f5);
        this.leg4.render(f5);
        this.leg1.render(f5);
        this.leg3.render(f5);
        this.tail1.render(f5);
        this.leg2.render(f5);
        this.head.render(f5);
        this.body.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotation(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(HowliteWolfEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.head.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
        this.head.rotateAngleX = headPitch / (180F / (float) Math.PI);

        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;

        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
    }
}