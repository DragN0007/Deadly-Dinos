package com.dragn0007.deadlydinos.entity.marine.base;

import net.minecraft.client.player.KeyboardInput;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidAttributes;

import java.util.Random;

public abstract class AbstractTamableMarineDino extends TamableAnimal  {
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 50);
    private int remainingPersistentAngerTime;

    protected AbstractTamableMarineDino(EntityType<? extends AbstractTamableMarineDino> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new AbstractTamableMarineDino.FishMoveControl(this);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    public MobType getMobType() {
        return MobType.WATER;
    }

    public boolean checkSpawnObstruction(LevelReader p_30348_) {
        return p_30348_.isUnobstructed(this);
    }

    public int getAmbientSoundInterval() {
        return 120;
    }

    protected int getExperienceReward(Player p_30353_) {
        return 1 + this.level.random.nextInt(3);
    }

    protected void handleAirSupply(int p_30344_) {
        if (this.isAlive() && !this.isInWaterOrBubble()) {
            this.setAirSupply(p_30344_ - 1);
            if (this.getAirSupply() == -20) {
                this.setAirSupply(0);
                this.hurt(DamageSource.DROWN, 2.0F);
            }
        } else {
            this.setAirSupply(300);
        }

    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }

    public void baseTick() {
        int i = this.getAirSupply();
        super.baseTick();
        this.handleAirSupply(i);
    }


    public boolean canBeLeashed(Player p_30346_) {
        return false;
    }

    public static boolean checkSurfaceWaterAnimalSpawnRules(EntityType<? extends AbstractTamableMarineDino> p_186238_, LevelAccessor p_186239_, MobSpawnType p_186240_, BlockPos p_186241_, Random p_186242_) {
        int i = p_186239_.getSeaLevel();
        int j = i - 13;
        return p_186241_.getY() >= j && p_186241_.getY() <= i && p_186239_.getFluidState(p_186241_.below()).is(FluidTags.WATER) && p_186239_.getBlockState(p_186241_.above()).is(Blocks.WATER);
    }

    public int getMaxSpawnClusterSize() {
        return 4;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new AbstractTamableMarineDino.SharkMeleeAttackGoal());
        this.goalSelector.addGoal(4, new AbstractTamableMarineDino.SharkSwimGoal(this));
        this.targetSelector.addGoal(1, new AbstractTamableMarineDino.SharkHurtByTargetGoal());
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1.0D, 10));
    }

    protected PathNavigation createNavigation(Level p_27480_) {
        return new WaterBoundPathNavigation(this, p_27480_);
    }

    public void tick() {
        super.tick();
            if (this.level.isClientSide && this.isInWater() && this.getDeltaMovement().lengthSqr() > 0.03D) {
                Vec3 vec3 = this.getViewVector(0.0F);
                float f = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * 0.3F;
                float f1 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) * 0.3F;
                float f2 = 1.2F - this.random.nextFloat() * 0.7F;

                for(int i = 0; i < 2; ++i) {
                    this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3.x * (double)f2 + (double)f, this.getY() - vec3.y, this.getZ() - vec3.z * (double)f2 + (double)f1, 0.0D, 0.0D, 0.0D);
                    this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3.x * (double)f2 - (double)f, this.getY() - vec3.y, this.getZ() - vec3.z * (double)f2 - (double)f1, 0.0D, 0.0D, 0.0D);
                }
            }
    }

    @Override
    public void travel(Vec3 vec) {
        if (this.isAlive() || this.isInWater()) {
            if (this.isVehicle() && this.canBeControlledByRider()) {
                LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
                this.setYRot(livingentity.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(livingentity.getXRot() * 0.5F);
                this.setRot(this.getYRot(), this.getXRot());
                this.yBodyRot = this.getYRot();
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F; // Strafe moving speed
                float f1 = livingentity.zza * 0.9F; // Forward moving speed
                double verticalMovement = vec.y;

                if (livingentity instanceof Player) {
                    Player player = (Player) livingentity;
                    if (player.isVehicle()) {    //IM GOING TO LOSE MY MIND RAHH HRAHHH WHY DOESNT PLAYER HAVE A JUMPINH CONTROL IM GOJNA CHEW MY OWN SKIN OFF RAHHHH
                        verticalMovement = 0.2D; // Swim up if holding Space
                    } else if (player.isSprinting()) {
                        verticalMovement = -0.4D; // Swim down if holding CTRL
                    }
                }

                if (f1 <= 0.0F) {
                    f1 = 0.25F;
                }

                this.flyingSpeed = (float) this.getAttributeValue(Attributes.MOVEMENT_SPEED);
                if (this.isControlledByLocalInstance()) {
                    this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    this.moveRelative(0.1F, new Vec3(f, verticalMovement, f1));
                    this.move(MoverType.SELF, this.getDeltaMovement());
                    this.setDeltaMovement(this.getDeltaMovement().scale(0.8D));
                } else if (livingentity instanceof Player) {
                    this.setDeltaMovement(Vec3.ZERO);
                }

                this.calculateEntityAnimation(this, false);
                this.tryCheckInsideBlocks();
            } else {
                this.moveRelative(0.02F, vec);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().scale(0.8D));
                if (this.getTarget() == null) {
                    this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
                } else {
                    if (this.getTarget().isAlive() && this.canAttack(this.getTarget())) {
                        Vec3 targetPos = new Vec3(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ());
                        this.moveTowardsTarget(targetPos);
                    } else {
                        this.setTarget(null);
                    }
                }
            }
        }
    }

    private void moveTowardsTarget(Vec3 targetPos) {
        double dx = targetPos.x - this.getX();
        double dy = targetPos.y - this.getY();
        double dz = targetPos.z - this.getZ();

        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
        double speed = 0.1;
        dx /= distance;
        dy /= distance;
        dz /= distance;

        this.setDeltaMovement(dx * speed, dy * speed, dz * speed);
    }

    public void aiStep() {
        if (!this.isInWater() && this.onGround && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), (double)0.4F, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
            this.onGround = false;
            this.hasImpulse = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }

        super.aiStep();
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public boolean isSwimming() {
        return true;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    protected SoundEvent getAmbientSound() {
        return null;
    }

    protected SoundEvent getDeathSound() {
        return null;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.RAVAGER_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.ELDER_GUARDIAN_FLOP;
    }

    protected boolean canRandomSwim() {
        return true;
    }


    protected SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }

    protected void playStepSound(BlockPos p_27482_, BlockState p_27483_) {
    }

    static class FishMoveControl extends MoveControl {
        private final AbstractTamableMarineDino shark;

        FishMoveControl(AbstractTamableMarineDino p_27501_) {
            super(p_27501_);
            this.shark = p_27501_;
        }

        public void tick() {
            if (this.shark.isEyeInFluid(FluidTags.WATER)) {
                this.shark.setDeltaMovement(this.shark.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
            }

            if (this.operation == Operation.MOVE_TO && !this.shark.getNavigation().isDone()) {
                float f = (float)(this.speedModifier * this.shark.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.shark.setSpeed(Mth.lerp(0.125F, this.shark.getSpeed(), f));
                double d0 = this.wantedX - this.shark.getX();
                double d1 = this.wantedY - this.shark.getY();
                double d2 = this.wantedZ - this.shark.getZ();
                if (d1 != 0.0D) {
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    this.shark.setDeltaMovement(this.shark.getDeltaMovement().add(0.0D, (double)this.shark.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
                }

                if (d0 != 0.0D || d2 != 0.0D) {
                    float f1 = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                    this.shark.setYRot(this.rotlerp(this.shark.getYRot(), f1, 90.0F));
                    this.shark.yBodyRot = this.shark.getYRot();
                }

            } else {
                this.shark.setSpeed(0.0F);
            }
        }
    }

    public boolean doHurtTarget(Entity p_29522_) {
        boolean flag = p_29522_.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.doEnchantDamageEffects(this, p_29522_);
        }

        return flag;
    }
    class SharkHurtByTargetGoal extends HurtByTargetGoal {
        public SharkHurtByTargetGoal() {
            super(AbstractTamableMarineDino.this);
        }

        protected void alertOther(Mob p_29580_, LivingEntity p_29581_) {
            if (p_29580_ instanceof AbstractTamableMarineDino && !p_29580_.isBaby()) {
                super.alertOther(p_29580_, p_29581_);
            }

        }
    }
    class SharkMeleeAttackGoal extends MeleeAttackGoal {
        public SharkMeleeAttackGoal() {
            super(AbstractTamableMarineDino.this, 5D, true);
        }
        protected void checkAndPerformAttack(LivingEntity p_29589_, double p_29590_) {
            double d0 = this.getAttackReachSqr(p_29589_);
            if (p_29590_ <= d0 && this.isTimeToAttack()) {
                this.resetAttackCooldown();
                this.mob.doHurtTarget(p_29589_);
            } else if (p_29590_ <= d0 * 2.0D) {
                if (this.isTimeToAttack()) {

                    this.resetAttackCooldown();
                }
                if (this.getTicksUntilNextAttack() <= 10) {
                }
            } else {
                this.resetAttackCooldown();
            }

        }
    }


    static class SharkSwimGoal extends RandomSwimmingGoal {
        public final AbstractTamableMarineDino fish;

        public SharkSwimGoal(AbstractTamableMarineDino p_27505_) {
            super(p_27505_, 1.0D, 40);
            this.fish = p_27505_;
        }

        public boolean canUse() {
            return this.fish.canRandomSwim() && super.canUse();
        }
    }
}

