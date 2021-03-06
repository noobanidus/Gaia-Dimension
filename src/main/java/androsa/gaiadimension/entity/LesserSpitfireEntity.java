package androsa.gaiadimension.entity;

import androsa.gaiadimension.registry.ModBlocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

public class LesserSpitfireEntity extends MonsterEntity implements ISpitfireMob {

    public LesserSpitfireEntity(EntityType<? extends LesserSpitfireEntity> entity, World worldIn) {
        super(entity, worldIn);
        this.experienceValue = 10;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 0.8D, false));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 0.8D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.8D, 0.0F));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 10, false, true, entity -> entity != null && entity instanceof IShockshooterMob));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
    }

    @Override
    public float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }

    @Override
    public boolean canSpawn(IWorld world, SpawnReason reason) {
        return true;
    }

    public static boolean canSpawnHere(EntityType<LesserSpitfireEntity> entity, IWorld world, SpawnReason spawn, BlockPos pos, Random random) {
        return world.getDifficulty() != Difficulty.PEACEFUL && world.getBlockState(pos.down()).getBlock() == ModBlocks.glitter_grass.get() /*&& world.getLightSubtracted(pos.down(), 0) > 8*/;
    }
}
