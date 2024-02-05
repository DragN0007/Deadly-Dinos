package com.dragn0007.deadlydinos.entity.herbi;

import com.dragn0007.deadlydinos.client.model.SauroModel;
import com.dragn0007.deadlydinos.entity.ai.DestroyCropsGoal;
import com.dragn0007.deadlydinos.entity.ai.DinoExtremeMeleeGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Random;

public class Sauro extends Animal implements IAnimatable {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public Sauro(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 400)
                .add(Attributes.ATTACK_DAMAGE, 50)
                .add(Attributes.MOVEMENT_SPEED, 0.22)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                ;

    }


    protected SoundEvent getAmbientSound() {
        return SoundEvents.HORSE_BREATHE;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.POLAR_BEAR_WARNING;
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(SoundEvents.POLAR_BEAR_STEP, 0.15F, 0.5F);
    }


    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(2, new DestroyCropsGoal(this));
        this.goalSelector.addGoal(0, new DinoExtremeMeleeGoal(this, 1, true));
        this.goalSelector.addGoal(4, new FloatGoal(this));
    }


    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event) {

        if (event.isMoving()) {
            if (isAggressive()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("sauroattack", ILoopType.EDefaultLoopTypes.LOOP));

            } else
                event.getController().setAnimation(new AnimationBuilder().addAnimation("saurowalk", ILoopType.EDefaultLoopTypes.LOOP));

        } else
            event.getController().setAnimation(new AnimationBuilder().addAnimation("sauroidle", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }



    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this,"controller",5,this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }




    //Generates variant textures

    public ResourceLocation getTextureLocation() {
        return SauroModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
    }


    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Sauro.class, EntityDataSerializers.INT);

    public int getVariant(){
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundNBT) {
        super.readAdditionalSaveData(compoundNBT);
        if(compoundNBT.contains("Variant")) {
            setVariant(compoundNBT.getInt("Variant"));
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundNBT) {
        super.addAdditionalSaveData(compoundNBT);
        compoundNBT.putInt("Variant", getVariant());
    }


    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {

        setVariant(new Random().nextInt(SauroModel.Variant.values().length));

        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
        return null;
    }


    @Override
    protected void defineSynchedData(){
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
    }

}

