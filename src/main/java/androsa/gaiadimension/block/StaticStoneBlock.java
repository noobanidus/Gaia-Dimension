package androsa.gaiadimension.block;

import androsa.gaiadimension.entity.IShockshooterMob;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class StaticStoneBlock extends BasicGaiaBlock {

    public StaticStoneBlock() {
        super(Material.ROCK, MaterialColor.BLUE_TERRACOTTA, 50.0F, 200.0F, ToolType.PICKAXE, 2);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn) || !(entityIn instanceof IShockshooterMob)) {
            entityIn.attackEntityFrom(DamageSource.LIGHTNING_BOLT, 2.0F);
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }

    @Override
    @Deprecated
    public boolean isSolid(BlockState state) {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
