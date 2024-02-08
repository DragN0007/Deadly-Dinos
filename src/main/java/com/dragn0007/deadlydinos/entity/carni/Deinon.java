package com.dragn0007.deadlydinos.entity.carni;

import com.dragn0007.deadlydinos.client.model.DeinonModel;
import com.dragn0007.deadlydinos.entity.ai.DinoVeryWeakMeleeGoal;
import com.dragn0007.deadlydinos.entity.nonliving.Car;
import com.dragn0007.deadlydinos.entity.nonliving.CarFlipped;
import com.dragn0007.deadlydinos.entity.nonliving.CarSide;
import com.google.common.collect.Maps;
import net.minecraft.Util;
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
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import software.bernie.geckolib3.core.AnimationState;
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



public class Deinon extends Animal implements IAnimatable {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public Deinon(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.JUMP_STRENGTH, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2)
                ;

    }


    private static final Predicate<Mob> NOT_MAHAKALA_PREDICATE = new Predicate<Mob>() {
        public boolean test(@Nullable Mob p_test_1_) {
            return p_test_1_ != null && Mahakala.MOB_SOUND_MAP.containsKey(p_test_1_.getType());
        }
    };
    static final Map<EntityType<?>, SoundEvent> MOB_SOUND_MAP = Util.make(Maps.newHashMap(), (p_200609_0_) -> {
        p_200609_0_.put(EntityType.BLAZE, SoundEvents.BLAZE_AMBIENT);
        p_200609_0_.put(EntityType.CAVE_SPIDER, SoundEvents.AMBIENT_CAVE);
        p_200609_0_.put(EntityType.CREEPER, SoundEvents.PARROT_IMITATE_CREEPER);
        p_200609_0_.put(EntityType.DROWNED, SoundEvents.DROWNED_AMBIENT);
        p_200609_0_.put(EntityType.ELDER_GUARDIAN, SoundEvents.ELDER_GUARDIAN_AMBIENT);
        p_200609_0_.put(EntityType.ENDER_DRAGON, SoundEvents.ENDER_DRAGON_AMBIENT);
        p_200609_0_.put(EntityType.ENDERMITE, SoundEvents.ENDERMITE_AMBIENT);
        p_200609_0_.put(EntityType.EVOKER, SoundEvents.EVOKER_AMBIENT);
        p_200609_0_.put(EntityType.GHAST, SoundEvents.GHAST_AMBIENT);
        p_200609_0_.put(EntityType.GUARDIAN, SoundEvents.GUARDIAN_AMBIENT);
        p_200609_0_.put(EntityType.HOGLIN, SoundEvents.HOGLIN_AMBIENT);
        p_200609_0_.put(EntityType.HUSK, SoundEvents.HUSK_AMBIENT);
        p_200609_0_.put(EntityType.ILLUSIONER, SoundEvents.ILLUSIONER_AMBIENT);
        p_200609_0_.put(EntityType.MAGMA_CUBE, SoundEvents.MAGMA_CUBE_SQUISH);
        p_200609_0_.put(EntityType.PHANTOM, SoundEvents.PHANTOM_AMBIENT);
        p_200609_0_.put(EntityType.PIGLIN, SoundEvents.PIGLIN_AMBIENT);
        p_200609_0_.put(EntityType.PIGLIN_BRUTE, SoundEvents.PIGLIN_AMBIENT);
        p_200609_0_.put(EntityType.PILLAGER, SoundEvents.PILLAGER_AMBIENT);
        p_200609_0_.put(EntityType.RAVAGER, SoundEvents.RAVAGER_AMBIENT);
        p_200609_0_.put(EntityType.SHULKER, SoundEvents.SHULKER_AMBIENT);
        p_200609_0_.put(EntityType.SILVERFISH, SoundEvents.SILVERFISH_AMBIENT);
        p_200609_0_.put(EntityType.SKELETON, SoundEvents.SKELETON_AMBIENT);
        p_200609_0_.put(EntityType.SLIME, SoundEvents.SLIME_ATTACK);
        p_200609_0_.put(EntityType.SPIDER, SoundEvents.SPIDER_AMBIENT);
        p_200609_0_.put(EntityType.STRAY, SoundEvents.STRAY_AMBIENT);
        p_200609_0_.put(EntityType.VEX, SoundEvents.VEX_AMBIENT);
        p_200609_0_.put(EntityType.VINDICATOR, SoundEvents.VINDICATOR_AMBIENT);
        p_200609_0_.put(EntityType.WITCH, SoundEvents.WITCH_AMBIENT);
        p_200609_0_.put(EntityType.WITHER, SoundEvents.WITHER_AMBIENT);
        p_200609_0_.put(EntityType.WITHER_SKELETON, SoundEvents.WITHER_SKELETON_AMBIENT);
        p_200609_0_.put(EntityType.ZOGLIN, SoundEvents.ZOGLIN_AMBIENT);
        p_200609_0_.put(EntityType.ZOMBIE, SoundEvents.ZOMBIE_AMBIENT);
        p_200609_0_.put(EntityType.ZOMBIE_VILLAGER, SoundEvents.ZOMBIE_VILLAGER_AMBIENT);
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
    protected SoundEvent getDeathSound () {
        return SoundEvents.PHANTOM_DEATH;
    }
    public static float getPitch(Random p_192000_0_) {
        return (p_192000_0_.nextFloat() - p_192000_0_.nextFloat()) * 0.7F + 1.0F;
    }
    protected SoundEvent getAmbientSound() {
        return SoundEvents.CHICKEN_AMBIENT;
    }
    @Nullable
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.CAT_HISS;
    }


    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, 30, true, true, LivingEntity::attackable));
        this.goalSelector.addGoal(1, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(3, new DinoVeryWeakMeleeGoal(this, 3.5, true));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.7f));
        this.goalSelector.addGoal(4, new FloatGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, true, new Predicate<LivingEntity>() {
            @Override
            public boolean test(@Nullable LivingEntity livingEntity) {
                if (livingEntity instanceof Austro)
                    return false;
                if (livingEntity instanceof Utah)
                    return false;
                if (livingEntity instanceof Deinon)
                    return false;
                if (livingEntity instanceof Mahakala)
                    return false;
                if (livingEntity instanceof CarSide)
                    return false;
                if (livingEntity instanceof Car)
                    return false;
                if (livingEntity instanceof CarFlipped)
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



    //Animation
    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event) {

        if (event.isMoving()) {
            if (isAggressive() || isSprinting()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("sprint", ILoopType.EDefaultLoopTypes.LOOP));

            } else
                event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", ILoopType.EDefaultLoopTypes.LOOP));
        } else
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("attack", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            this.swinging = false;
        }

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers (AnimationData data){
        data.addAnimationController(new AnimationController(this, "controller", 3, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController", 3, this::attackPredicate));
    }



    @Override
    public AnimationFactory getFactory() {
        return factory;
    }





    //Generates variant textures

    public ResourceLocation getTextureLocation() {
        return DeinonModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
    }


    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Deinon.class, EntityDataSerializers.INT);

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

        setVariant(new Random().nextInt(DeinonModel.Variant.values().length));

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