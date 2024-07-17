package com.dragn0007.deadlydinos.entity.carni;

import com.dragn0007.deadlydinos.client.model.AndalModel;
import com.dragn0007.deadlydinos.entity.herbi.Ava;
import com.dragn0007.deadlydinos.entity.nonliving.Car;
import com.dragn0007.deadlydinos.entity.nonliving.CarFlipped;
import com.dragn0007.deadlydinos.entity.nonliving.CarSide;
import com.dragn0007.deadlydinos.entity.util.EntityTypes;
import com.dragn0007.deadlydinos.util.DDDTags;
import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
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
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;


public class Andal extends TamableAnimal implements IAnimatable {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public static final Predicate<LivingEntity> PREY_SELECTOR = (entity) -> {
        if (entity instanceof TamableAnimal && ((TamableAnimal) entity).isTame()) {
            return false;
        }
        if (entity.getType() == EntityType.PLAYER) {
            return false;
        }
        if (entity.getType() == EntityTypes.ANDAL_ENTITY.get()) {
            return false;
        }
        return true;
    };

    public Andal(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
    }

    public static boolean checkDesertDinoSpawnRules(EntityType<Andal> p_29550_, LevelAccessor p_29551_, MobSpawnType p_29552_, BlockPos p_29553_, Random p_29554_) {
        Holder<Biome> holder = p_29551_.getBiome(p_29553_);
        if (!holder.is(Biomes.DESERT) && !holder.is(Biomes.BADLANDS)) {
            return checkAnimalSpawnRules(p_29550_, p_29551_, p_29552_, p_29553_, p_29554_);
        } else {
            return isBrightEnoughToSpawn(p_29551_, p_29553_) && p_29551_.getBlockState(p_29553_.below()).is(DDDTags.Blocks.DESERT_DINO_SPAWNABLE_ON);
        }
    }

    @Override
    public Vec3 getLeashOffset() {
        return new Vec3(0D, (double)this.getEyeHeight() * 1F, (double)(this.getBbWidth() * 0.5F));
        //                      ^ Side offset                             ^ Height offset                  ^ Length offset
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ATTACK_DAMAGE, 8)
                .add(Attributes.MOVEMENT_SPEED, 0.17)
                .add(Attributes.JUMP_STRENGTH, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.4)
                ;

    }
    @Override
    public float getStepHeight() {
        return 1f;
    }
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 2, true));
        this.goalSelector.addGoal(3, new FloatGoal(this));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1.0D, 5.0F, 1.0F, true));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1));
        this.targetSelector.addGoal(0, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(0, new OwnerHurtTargetGoal(this));

        this.targetSelector.addGoal(1, new NonTameRandomTargetGoal<>(this, LivingEntity.class, false, PREY_SELECTOR));

        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));

        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LivingEntity.class, 15.0F, 2.0D, 2.0D, livingEntity
                -> livingEntity instanceof Acro
                || livingEntity instanceof Alberto
                || livingEntity instanceof Giga
                || livingEntity instanceof Rex
                || livingEntity instanceof Spino
        ));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, true, new Predicate<LivingEntity>() {
            @Override
            public boolean test(@Nullable LivingEntity livingEntity) {
                if (livingEntity
                        instanceof Andal
                        || livingEntity instanceof Mahakala
                        || livingEntity instanceof CarSide
                        || livingEntity instanceof Car
                        || livingEntity instanceof CarFlipped
                        || livingEntity instanceof ArmorStand
                        || livingEntity instanceof AbstractFish
                        || livingEntity instanceof Squid
                        || livingEntity instanceof Dolphin
                        || livingEntity instanceof Giga
                        || livingEntity instanceof Rex
                        || livingEntity instanceof Alberto
                        || livingEntity instanceof Tarbo
                        || livingEntity instanceof Carchar
                        || livingEntity instanceof Acro
                        || livingEntity instanceof Spino
                        || livingEntity instanceof TamableAnimal
                        || livingEntity instanceof Player
                ){
                    return false;
                }
                return true;
            }
        }));
    }



    //Tameable Entity
    private static final Set<Item> TAME_FOOD = Sets.newHashSet(Items.EGG);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.EGG);
    public boolean isFood(ItemStack p_28271_) {
        return FOOD_ITEMS.test(p_28271_);
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(player) || this.isTame() || TAME_FOOD.contains(itemstack.getItem()) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    this.heal((float) itemstack.getFoodProperties(this).getNutrition());
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    this.gameEvent(GameEvent.MOB_INTERACT, this.eyeBlockPosition());
                    return InteractionResult.SUCCESS;
                }

                if (!(item instanceof DyeItem)) {
                    InteractionResult interactionresult = super.mobInteract(player, hand);
                    if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(player)) {
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget((LivingEntity) null);
                        return InteractionResult.SUCCESS;
                    }

                    return interactionresult;
                }

            } else if (this.isFood(itemstack) && !this.level.isClientSide && this.isBaby()) {
                this.usePlayerItem(player, hand, itemstack);
                // try to tame (33% chance to succeed)
                if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    return InteractionResult.SUCCESS;
                }

                if (this.isBaby()) {
                    // grow baby
                    this.ageUp(itemstack.getFoodProperties(this).getNutrition());
                    this.gameEvent(GameEvent.MOB_INTERACT, this.eyeBlockPosition());
                    return InteractionResult.SUCCESS;
                }
            }
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        }
    }

    protected SoundEvent getDeathSound () {
        return SoundEvents.PHANTOM_DEATH;
    }
    protected SoundEvent getAmbientSound() {
        return SoundEvents.CHICKEN_AMBIENT;
    }
    @Nullable
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.PHANTOM_HURT;
    }
    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(SoundEvents.WOLF_STEP, 0.15F, 1.0F);
    }


    //Animation
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {

        if (event.isMoving()) {
            if (isAggressive() || isSprinting()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("sprint", ILoopType.EDefaultLoopTypes.LOOP));
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", ILoopType.EDefaultLoopTypes.LOOP));
            }

        } else {
            if (isInSittingPose()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("sit", ILoopType.EDefaultLoopTypes.LOOP));
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", ILoopType.EDefaultLoopTypes.LOOP));
            }
        }

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
        data.addAnimationController(new AnimationController(this, "attackController", 1, this::attackPredicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }




    //Generates variant textures

    public ResourceLocation getTextureLocation() {
        return AndalModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
    }


    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Andal.class, EntityDataSerializers.INT);

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

        setVariant(new Random().nextInt(AndalModel.Variant.values().length));

        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    public boolean canBeParent() {
        return !this.isBaby() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }

    @Override
    public boolean canMate(Animal animal) {
        if (animal == this || !(animal instanceof Andal)) {
            return false;
        } else {
            return this.canBeParent() && ((Andal)animal).canBeParent();
        }
    }

    @Override
    public Andal getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return EntityTypes.ANDAL_ENTITY.get().create(level);
    }

    @Override
    protected void defineSynchedData(){
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
    }
}
