package com.dragn0007.deadlydinos.entity.carni;

import com.dragn0007.deadlydinos.Network;
import com.dragn0007.deadlydinos.client.model.BaryModel;
import com.dragn0007.deadlydinos.entity.ai.DinoWeakMeleeGoal;
import com.dragn0007.deadlydinos.entity.nonliving.Car;
import com.dragn0007.deadlydinos.entity.nonliving.CarFlipped;
import com.dragn0007.deadlydinos.entity.nonliving.CarSide;
import com.dragn0007.deadlydinos.entity.util.EntityTypes;
import com.dragn0007.deadlydinos.item.DDDItems;
import com.dragn0007.deadlydinos.util.DDDTags;
import com.google.common.collect.Sets;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.items.CapabilityItemHandler;
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

public class Bary extends TamableAnimal implements ContainerListener, IAnimatable, Saddleable {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public Bary(EntityType<? extends Bary> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
    }

    private static final EntityDataAccessor<Boolean> SADDLED = SynchedEntityData.defineId(Bary.class, EntityDataSerializers.BOOLEAN);

    public SimpleContainer inventory;
    private LazyOptional<?> itemHandler = null;

    @Override
    public Vec3 getLeashOffset() {
        return new Vec3(0D, (double) this.getEyeHeight() * 0.9F, (double) (this.getBbWidth() * 1.5F));
        //                      ^ Side offset                             ^ Height offset                  ^ Length offset
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.MOVEMENT_SPEED, 0.21)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                ;
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    protected boolean canRandomSwim() {
        return true;
    }

    static class SpinoSwimGoal extends RandomSwimmingGoal {
        private final Bary spino;

        public SpinoSwimGoal(Bary p_27505_) {
            super(p_27505_, 1.0D, 40);
            this.spino = p_27505_;
        }

        public boolean canUse() {
            return this.spino.canRandomSwim() && super.canUse();
        }
    }

    public static final Predicate<LivingEntity> PREY_SELECTOR = (entity) -> {
        if (entity instanceof TamableAnimal && ((TamableAnimal) entity).isTame()) {
            return false;
        }
        if (entity.getType() == EntityType.PLAYER) {
            return false;
        }
        if (entity.getType() == EntityTypes.BARY_ENTITY.get()) {
            return false;
        }
        return true;
    };

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new BreathAirGoal(this));
        this.goalSelector.addGoal(0, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(4, new FollowBoatGoal(this));
        this.goalSelector.addGoal(0, new DinoWeakMeleeGoal(this, 1.7, true));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(4, new SpinoSwimGoal(this));
        this.goalSelector.addGoal(3, new SpinoStrollOnLandGoal(this, 1.0D, 100));

        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1));
        this.targetSelector.addGoal(0, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(0, new OwnerHurtTargetGoal(this));

        this.targetSelector.addGoal(1, new NonTameRandomTargetGoal<>(this, LivingEntity.class, false, PREY_SELECTOR));

        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, true, new Predicate<LivingEntity>() {
            @Override
            public boolean test(@Nullable LivingEntity livingEntity) {
                if (livingEntity
                        instanceof Bary
                        || livingEntity instanceof Mahakala
                        || livingEntity instanceof CarSide
                        || livingEntity instanceof Car
                        || livingEntity instanceof CarFlipped
                        || livingEntity instanceof ArmorStand
                        || livingEntity instanceof AbstractFish
                        || livingEntity instanceof Squid
                        || livingEntity instanceof Dolphin
                        || livingEntity instanceof TamableAnimal
                        || livingEntity instanceof Player
                ){
                    return false;
                }
                return true;
            }
        }));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.TURTLE_AMBIENT_LAND;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.PHANTOM_DEATH;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.POLAR_BEAR_WARNING;
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(SoundEvents.POLAR_BEAR_STEP, 0.15F, 0.5F);
    }


    //Animation
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (isInWater()) {
            if (!event.isMoving()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("swimidle", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            }
        }

        if (event.isMoving()) {
            if (isAggressive() || isVehicle()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("run", ILoopType.EDefaultLoopTypes.LOOP));
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
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 3, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController", 1, this::attackPredicate));
    }

    //Tameable Entity
    private static final Set<Item> TAME_FOOD = Sets.newHashSet(DDDItems.LARGE_FISH.get());
    private static final Ingredient FOOD_ITEMS = Ingredient.of(DDDTags.Items.SEMI_AQUATIC_FOOD);

    public boolean isFood(ItemStack p_28271_) {
        return FOOD_ITEMS.test(p_28271_);
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (this.isTame()) {
            if (this.isFood(itemStack)) {
                if (this.getHealth() < this.getMaxHealth()) {
                    // heal
                    this.usePlayerItem(player, hand, itemStack);
                    this.heal(itemStack.getFoodProperties(this).getNutrition());
                    this.gameEvent(GameEvent.MOB_INTERACT, this.eyeBlockPosition());
                    return InteractionResult.sidedSuccess(this.level.isClientSide);
                } else if (this.canFallInLove() && !this.level.isClientSide) {
                    // set to baby maker mode
                    this.usePlayerItem(player, hand, itemStack);
                    this.setInLove(player);
                    this.gameEvent(GameEvent.MOB_INTERACT, this.eyeBlockPosition());
                    return InteractionResult.SUCCESS;
                }
            } else if (itemStack.is(Items.SADDLE) && this.isSaddleable()) {
                itemStack.interactLivingEntity(player, this, hand);
                this.setSaddled(true);
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            } else if (player.isCrouching()) {
                // sit if crouch clicking
                if (this.isOrderedToSit()) {
                    this.setOrderedToSit(false);
                } else {
                    this.setOrderedToSit(true);
                }
                return InteractionResult.SUCCESS;
            } else if (itemStack.is(Items.SADDLE) && this.isSaddleable()) {
                // saddle up
                itemStack.interactLivingEntity(player, this, hand);
                this.setSaddled(true);
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            } else if (this.isSaddled() && !this.isOrderedToSit()) {
                // hop on
                this.doPlayerRide(player);
                return InteractionResult.SUCCESS;
            }
        } else if (this.isFood(itemStack) && !this.level.isClientSide && this.isBaby()) {
            this.usePlayerItem(player, hand, itemStack);
            // try to tame (33% chance to succeed)
            if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
                this.tame(player);
                return InteractionResult.SUCCESS;
            }

            if(this.isBaby()) {
                // grow baby
                this.ageUp(itemStack.getFoodProperties(this).getNutrition());
                this.gameEvent(GameEvent.MOB_INTERACT, this.eyeBlockPosition());
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.sidedSuccess(this.level.isClientSide);
    }



    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    static class SpinoStrollOnLandGoal extends RandomStrollGoal {
        private final Bary spino;

        SpinoStrollOnLandGoal(Bary p_30303_, double p_30304_, int p_30305_) {
            super(p_30303_, p_30304_, p_30305_);
            this.spino = p_30303_;
        }

        public boolean canUse() {
            return !this.mob.isInWater() && super.canUse();
        }
    }

    static class SpinoPathNav extends WaterBoundPathNavigation {
        SpinoPathNav(Bary p_30294_, Level p_30295_) {
            super(p_30294_, p_30295_);
        }

        protected boolean canUpdatePath() {
            return true;
        }

        protected PathFinder createPathFinder(int p_30298_) {
            this.nodeEvaluator = new AmphibiousNodeEvaluator(true);
            return new PathFinder(this.nodeEvaluator, p_30298_);
        }

        public boolean isStableDestination(BlockPos p_30300_) {
            if (this.mob instanceof Bary) {
                Bary spino = (Bary) this.mob;
            }

            return !this.level.getBlockState(p_30300_.below()).isAir();
        }
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }

    @Override
    public float getStepHeight() {
        return 1f;
    }

    @Override
    public void travel(Vec3 vec) {
        if (this.isAlive()) {
            if (this.isInWater()) {
                if (this.isVehicle() && this.canBeControlledByRider()) {
                    LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
                    this.setYRot(livingentity.getYRot());
                    this.yRotO = this.getYRot();
                    this.setXRot(livingentity.getXRot() * 0.5F);
                    this.setRot(this.getYRot(), this.getXRot());
                    this.yBodyRot = this.getYRot();
                    this.yHeadRot = this.yBodyRot;
                    float f = livingentity.xxa * 0.5F; // Strafe moving speed
                    float f1 = livingentity.zza * 0.8F; // Forward moving speed
                    double verticalMovement = vec.y;

                    if (f1 <= 0.0F) {
                        f1 = 0.25F;
                    }

                    if(this.isControlledByLocalInstance() && this.getControllingPassenger() instanceof LocalPlayer localPlayer1) {
                        this.handleInput((KeyboardInput) localPlayer1.input);
                        if (livingentity instanceof Player && this.isInWater()) {
                            Player player = (Player) livingentity;
                            Minecraft game = Minecraft.getInstance();
                            LocalPlayer localPlayer = game.player;
                            if (localPlayer != null && localPlayer.input.jumping) {
                                verticalMovement = 0.4D; // Swim up if holding Space
                            } else if (player.isSprinting()) {
                                verticalMovement = -0.4D; // Swim down if holding CTRL
                            }
                        }
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
            } else {
                if (this.isVehicle() && this.canBeControlledByRider()) {
                    LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
                    this.setYRot(livingentity.getYRot());
                    this.yRotO = this.getYRot();
                    this.setXRot(livingentity.getXRot() * 0.5F);
                    this.setRot(this.getYRot(), this.getXRot());
                    this.yBodyRot = this.getYRot();
                    this.yHeadRot = this.yBodyRot;
                    float f = livingentity.xxa * 0.3F; // Strafe moving speed
                    float f1 = livingentity.zza * 0.5F; // Forward moving speed
                    if (f1 <= 0.0F) {
                        f1 *= 0.25F;
                    }

                    this.flyingSpeed = (float) this.getAttributeValue(Attributes.MOVEMENT_SPEED);
                    if (this.isControlledByLocalInstance()) {
                        this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                        super.travel(new Vec3(f, vec.y, f1));
                    } else if (livingentity instanceof Player) {
                        this.setDeltaMovement(Vec3.ZERO);
                    }

                    this.calculateEntityAnimation(this, false);
                    this.tryCheckInsideBlocks();
                } else {
                    this.flyingSpeed = (float) this.getAttributeValue(Attributes.MOVEMENT_SPEED);
                    super.travel(vec);
                }
            }
        }
    }

    private void handleInput(KeyboardInput input) {
        if(input.jumping) {
            Network.INSTANCE.sendToServer(new Network.ToggleTillerPowerRequest(this.getId()));
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


    //Generates variant textures

    public ResourceLocation getTextureLocation() {
        return BaryModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
    }


    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Bary.class, EntityDataSerializers.INT);

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        if(tag.contains("Variant")) {
            setVariant(tag.getInt("Variant"));
        }

        if(tag.contains("Saddled")) {
            this.setSaddled(tag.getBoolean("Saddled"));
        }

    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", getVariant());
        tag.putBoolean("Saddled", this.isSaddled());
    }


    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {

        setVariant(new Random().nextInt(BaryModel.Variant.values().length));

        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    public boolean canBeParent() {
        return !this.isBaby() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }

    @Override
    public boolean canMate(Animal animal) {
        if (animal == this || !(animal instanceof Bary)) {
            return false;
        } else {
            return this.canBeParent() && ((Bary) animal).canBeParent();
        }
    }

    @Override
    public Bary getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return EntityTypes.BARY_ENTITY.get().create(level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
        this.entityData.define(SADDLED, false);
    }


    @Override
    public void positionRider(Entity entity) {
        if (this.hasPassenger(entity)) {
            double offsetX;
            double offsetY;
            double offsetZ;

            if (this.isInWater()) {
                offsetX = 0;
                offsetY = -0.6;
                offsetZ = 0.4;
            } else {
                offsetX = 0;
                offsetY = 1.2;
                offsetZ = 0.4;
            }

            double radYaw = Math.toRadians(this.getYRot());

            double offsetXRotated = offsetX * Math.cos(radYaw) - offsetZ * Math.sin(radYaw);
            double offsetYRotated = offsetY;
            double offsetZRotated = offsetX * Math.sin(radYaw) + offsetZ * Math.cos(radYaw);

            double x = this.getX() + offsetXRotated;
            double y = this.getY() + offsetYRotated;
            double z = this.getZ() + offsetZRotated;

            entity.setPos(x, y, z);
        }
    }

    @Override
    protected void dropEquipment() {
        if (!this.level.isClientSide) {
            super.dropEquipment();
        }
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (this.isAlive() && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && this.itemHandler != null) {
            return itemHandler.cast();
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        if (this.itemHandler != null) {
            LazyOptional<?> oldHandler = this.itemHandler;
            this.itemHandler = null;
            oldHandler.invalidate();
        }
    }

    @Override
    public boolean canBeControlledByRider() {
        return this.getControllingPassenger() instanceof LivingEntity;
    }

    @Override
    public boolean isPushable() {
        return !this.isVehicle();
    }

    @Override
    public boolean isSaddleable() {
        return this.isAlive() && !this.isBaby() && this.isTame();
    }

    @Override
    public void equipSaddle(@Nullable SoundSource soundSource) {
        this.setSaddled(true);
        if (soundSource != null) {
            this.level.playSound(null, this, SoundEvents.HORSE_SADDLE, soundSource, 0.5f, 1.0f);
        }
    }

    @Override
    public boolean isSaddled() {
        return this.entityData.get(SADDLED);
    }

    private void setSaddled(boolean saddled) {
        this.entityData.set(SADDLED, saddled);
    }

    protected void doPlayerRide(Player p_30634_) {
        if (!this.level.isClientSide) {
            p_30634_.setYRot(this.getYRot());
            p_30634_.setXRot(this.getXRot());
            p_30634_.startRiding(this);
        }
    }

    @Nullable
    public Entity getControllingPassenger() {
        return this.getOwner() == this.getFirstPassenger() ? this.getFirstPassenger() : null;
    }

    @Nullable
    private Vec3 getDismountLocationInDirection(Vec3 p_30562_, LivingEntity p_30563_) {
        double d0 = this.getX() + p_30562_.x;
        double d1 = this.getBoundingBox().minY;
        double d2 = this.getZ() + p_30562_.z;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (Pose pose : p_30563_.getDismountPoses()) {
            blockpos$mutableblockpos.set(d0, d1, d2);
            double d3 = this.getBoundingBox().maxY + 0.75D;

            while (true) {
                double d4 = this.level.getBlockFloorHeight(blockpos$mutableblockpos);
                if ((double) blockpos$mutableblockpos.getY() + d4 > d3) {
                    break;
                }

                if (DismountHelper.isBlockFloorValid(d4)) {
                    AABB aabb = p_30563_.getLocalBoundsForPose(pose);
                    Vec3 vec3 = new Vec3(d0, (double) blockpos$mutableblockpos.getY() + d4, d2);
                    if (DismountHelper.canDismountTo(this.level, p_30563_, aabb.move(vec3))) {
                        p_30563_.setPose(pose);
                        return vec3;
                    }
                }

                blockpos$mutableblockpos.move(Direction.UP);
                if (!((double) blockpos$mutableblockpos.getY() < d3)) {
                    break;
                }
            }
        }
        return null;
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity p_30576_) {
        Vec3 vec3 = getCollisionHorizontalEscapeVector(this.getBbWidth(), p_30576_.getBbWidth(), this.getYRot() + (p_30576_.getMainArm() == HumanoidArm.RIGHT ? 90.0F : -90.0F));
        Vec3 vec31 = this.getDismountLocationInDirection(vec3, p_30576_);
        if (vec31 != null) {
            return vec31;
        } else {
            Vec3 vec32 = getCollisionHorizontalEscapeVector(this.getBbWidth(), p_30576_.getBbWidth(), this.getYRot() + (p_30576_.getMainArm() == HumanoidArm.LEFT ? 90.0F : -90.0F));
            Vec3 vec33 = this.getDismountLocationInDirection(vec32, p_30576_);
            return vec33 != null ? vec33 : this.position();
        }
    }

    @Override
    public void containerChanged(Container container) {
        boolean flag = this.isSaddled();
        if(!this.level.isClientSide) {
            this.setSaddled(!this.inventory.getItem(0).isEmpty());
        }
        if(this.tickCount > 20 && !flag && this.isSaddleable()) {
            this.playSound(SoundEvents.HORSE_SADDLE, 0.5f, 1f);
        }
    }
}