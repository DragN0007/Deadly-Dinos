package com.dragn0007.deadlydinos.entity;

import com.dragn0007.deadlydinos.entity.ai.DestroyPersonalPropertyGoal;
import com.dragn0007.deadlydinos.entity.ai.DinoVeryWeakMeleeGoal;
import com.dragn0007.deadlydinos.model.TroodonModel;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
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
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;


public class TroodonEntity extends Animal implements IAnimatable {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    protected TroodonEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.JUMP_STRENGTH, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2)
                ;
    }


    //Sound
    private static final Predicate<Mob> NOT_MAHAKALA_PREDICATE = new Predicate<Mob>() {
        public boolean test(@Nullable Mob p_test_1_) {
            return p_test_1_ != null && MahakalaEntity.MOB_SOUND_MAP.containsKey(p_test_1_.getType());
        }
    };
    static final Map<EntityType<?>, SoundEvent> MOB_SOUND_MAP = Util.make(Maps.newHashMap(), (p_200609_0_) -> {
        p_200609_0_.put(EntityType.COW, SoundEvents.COW_AMBIENT);
        p_200609_0_.put(EntityType.SHEEP, SoundEvents.SHEEP_AMBIENT);
        p_200609_0_.put(EntityType.PIG, SoundEvents.PIG_AMBIENT);
        p_200609_0_.put(EntityType.HORSE, SoundEvents.HORSE_AMBIENT);
        p_200609_0_.put(EntityType.VILLAGER, SoundEvents.VILLAGER_AMBIENT);
    });
    public void aiStep() {
        if (this.level.random.nextInt(150) == 0) {
            imitateNearbyMobs(this.level, this);
        }
        super.aiStep();
    }
    public static boolean imitateNearbyMobs(Level p_192006_0_, Entity p_192006_1_) {
        if (p_192006_1_.isAlive() && !p_192006_1_.isSilent() && p_192006_0_.random.nextInt(2) == 0) {
            List<Mob> list = p_192006_0_.getEntitiesOfClass(Mob.class, p_192006_1_.getBoundingBox().inflate(20.0D), NOT_MAHAKALA_PREDICATE);
            if (!list.isEmpty()) {
                Mob mobentity = list.get(p_192006_0_.random.nextInt(list.size()));
                if (!mobentity.isSilent()) {
                    SoundEvent soundevent = getImitatedSound(mobentity.getType());
                    p_192006_0_.playSound((Player) null, p_192006_1_.getX(), p_192006_1_.getY(), p_192006_1_.getZ(), soundevent, p_192006_1_.getSoundSource(), 0.7F, getPitch(p_192006_0_.random));
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    private static SoundEvent getImitatedSound(EntityType<?> p_200610_0_) {
        return MOB_SOUND_MAP.getOrDefault(p_200610_0_, SoundEvents.CHICKEN_AMBIENT);
    }

    public float getVoicePitch() {
        return getPitch(this.random);
    }


    public static float getPitch(Random p_192000_0_) {
        return (p_192000_0_.nextFloat() - p_192000_0_.nextFloat()) * 0.2F + 1.0F;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.PARROT_AMBIENT;
    }
    @Nullable
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.PARROT_HURT;
    }
    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
    }




    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, 30, true, true, LivingEntity::attackable));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(2, new DinoVeryWeakMeleeGoal(this, 3.5, true));
        this.goalSelector.addGoal(3, new BreakDoorGoal(this, (x) -> x == Difficulty.EASY || x == Difficulty.NORMAL || x == Difficulty.HARD));
        this.goalSelector.addGoal(3, new FloatGoal(this));
        this.goalSelector.addGoal(6, new DestroyPersonalPropertyGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1));
        this.goalSelector.addGoal(5, new AvoidEntityGoal<>(this, LivingEntity.class, 15.0F, 2.0D, 2.0D, new Predicate<LivingEntity>() {
            @Override
            public boolean test(LivingEntity livingEntity) {
                if (livingEntity instanceof AcroEntity)
                    return false;
                if (livingEntity instanceof RexEntity)
                    return false;
                if (livingEntity instanceof AlbertoEntity)
                    return false;
                if (livingEntity instanceof SpinoEntity)
                    return false;
                if (livingEntity instanceof GigaEntity)
                    return false;
                return true;
            }
        }));

        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, true, new Predicate<LivingEntity>() {
            @Override
            public boolean test(@Nullable LivingEntity livingEntity) {
                if (livingEntity instanceof TroodonEntity)
                    return false;
                if (livingEntity instanceof AcroEntity)
                    return false;
                if (livingEntity instanceof AlbertoEntity)
                    return false;
                if (livingEntity instanceof GigaEntity)
                    return false;
                if (livingEntity instanceof RexEntity)
                    return false;
                if (livingEntity instanceof SpinoEntity)
                    return false;
                if (livingEntity instanceof CarSideEntity)
                    return false;
                if (livingEntity instanceof CarEntity)
                    return false;
                if (livingEntity instanceof CarFlippedEntity)
                    return false;
                if (livingEntity instanceof ArmorStand)
                    return false;
                if (livingEntity instanceof AbstractFish)
                    return false;
                if (livingEntity instanceof Squid)
                    return false;
                if (livingEntity instanceof Dolphin)
                    return false;
                return true;
            }
        }));
    }



    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event) {

        if (event.isMoving()) {
            if (isAggressive()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("troodonsprint", ILoopType.EDefaultLoopTypes.LOOP));

            } else
                event.getController().setAnimation(new AnimationBuilder().addAnimation("troodonwalk", ILoopType.EDefaultLoopTypes.LOOP));

        } else
            event.getController().setAnimation(new AnimationBuilder().addAnimation("troodonidle", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 5, this::predicate));
    }


    @Override
    public AnimationFactory getFactory() {
        return factory;
    }





    //Generates variant textures

    public ResourceLocation getTextureLocation() {
        return TroodonModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
    }


    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(TroodonEntity.class, EntityDataSerializers.INT);

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

        setVariant(new Random().nextInt(TroodonModel.Variant.values().length));

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
