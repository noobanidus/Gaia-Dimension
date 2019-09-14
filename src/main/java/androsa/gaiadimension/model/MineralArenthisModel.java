package androsa.gaiadimension.model;

import androsa.gaiadimension.entity.MineralArenthisEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * ModelMineralArenthis - Androsa
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class MineralArenthisModel extends EntityModel<MineralArenthisEntity> {
    public RendererModel capTop;
    public RendererModel capBottom;
    public RendererModel head;
    public RendererModel[] tentacles = new RendererModel[10];
    public RendererModel body;
    public RendererModel tail;
    public RendererModel finL;
    public RendererModel finR;
    public RendererModel tailfin;

    public MineralArenthisModel() {
        this.textureWidth = 128;
        this.textureHeight = 80;

        this.capTop = new RendererModel(this, 0, 0);
        this.capTop.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.capTop.addBox(-8.0F, 0.0F, -8.0F, 16, 7, 16, 0.0F);
        this.head = new RendererModel(this, 0, 23);
        this.head.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.head.addBox(-3.5F, 0.0F, -3.5F, 7, 4, 7, 0.0F);
        this.body = new RendererModel(this, 104, 0);
        this.body.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.body.addBox(-2.5F, 0.0F, -2.0F, 5, 5, 4, 0.0F);
        this.capBottom = new RendererModel(this, 44, 3);
        this.capBottom.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.capBottom.addBox(-10.0F, 0.0F, -10.0F, 20, 6, 20, 0.0F);
        this.finR = new RendererModel(this, -4, 36);
        this.finR.setRotationPoint(-2.2F, 0.5F, 0.1F);
        this.finR.addBox(-10.0F, 0.0F, -2.0F, 10, 0, 4, 0.0F);
        this.setRotateAngle(finR, 0.0F, 0.0F, -1.2217304763960306F);
        this.finL = new RendererModel(this, -4, 41);
        this.finL.setRotationPoint(2.2F, 0.5F, 0.1F);
        this.finL.addBox(0.0F, 0.0F, -2.0F, 10, 0, 4, 0.0F);
        this.setRotateAngle(finL, 0.0F, 0.0F, 1.2217304763960306F);
        this.tail = new RendererModel(this, 0, 0);
        this.tail.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.tail.addBox(-2.0F, 0.0F, -1.0F, 4, 7, 2, 0.0F);
        this.tailfin = new RendererModel(this, 86, 30);
        this.tailfin.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.tailfin.addBox(-5.5F, 0.0F, 0.0F, 11, 6, 0, 0.0F);
        for (int j = 0; j < this.tentacles.length; ++j) {
            this.tentacles[j] = new RendererModel(this, 28, 23);
            double d0 = (double)j * Math.PI * 2.0D / (double)this.tentacles.length;
            float f = (float)Math.cos(d0) * 8.0F;
            float f1 = (float)Math.sin(d0) * 8.0F;
            this.tentacles[j].addBox(-1.0F, 0.0F, -1.0F, 2, 30, 2);
            this.tentacles[j].rotationPointX = f;
            this.tentacles[j].rotationPointZ = f1;
            this.tentacles[j].rotationPointY = 5.0F;
            d0 = (double)j * Math.PI * -2.0D / (double)this.tentacles.length + (Math.PI / 2D);
            this.tentacles[j].rotateAngleY = (float)d0;
        }

        this.capBottom.addChild(this.head);
        this.head.addChild(this.body);
        this.capTop.addChild(this.capBottom);
        this.body.addChild(this.finR);
        this.body.addChild(this.finL);
        this.body.addChild(this.tail);
        this.tail.addChild(this.tailfin);
    }

    @Override
    public void render(MineralArenthisEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.capTop.render(scale);
        for (RendererModel modelrenderer : this.tentacles) {
            modelrenderer.render(scale);
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(MineralArenthisEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.body.rotateAngleX = MathHelper.sin(ageInTicks * (float)Math.PI * 0.025F) * 3.0F;
        this.tail.rotateAngleX = MathHelper.sin(ageInTicks * (float)Math.PI * 0.025F) * 3.0F;
        this.tailfin.rotateAngleX = MathHelper.sin(ageInTicks * (float)Math.PI * 0.025F) * 3.0F;

        for (RendererModel modelrenderer : this.tentacles) {
            modelrenderer.rotateAngleX = ageInTicks;
        }
    }
}