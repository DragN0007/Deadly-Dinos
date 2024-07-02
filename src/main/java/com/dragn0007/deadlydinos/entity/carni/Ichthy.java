package com.dragn0007.deadlydinos.entity.carni;

import com.dragn0007.deadlydinos.client.menu.IchthyMenu;
import com.dragn0007.deadlydinos.client.model.IchthyModel;
import com.dragn0007.deadlydinos.entity.Chestable;
import com.dragn0007.deadlydinos.entity.ai.DinoWeakMeleeGoal;
import com.dragn0007.deadlydinos.entity.nonliving.Car;
import com.dragn0007.deadlydinos.entity.nonliving.CarFlipped;
import com.dragn0007.deadlydinos.entity.util.EntityTypes;
import com.dragn0007.deadlydinos.util.DDDTags;
import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.network.NetworkHooks;
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

public class Ichthy extends TamableAnimal implements ContainerListener, IAnimatable, Chestable {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public Ichthy(EntityType<? extends Ichthy> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
        this.updateInventory();
    }

    private static final EntityDataAccessor<Boolean> CHESTED = SynchedEntityData.defineId(Ichthy.class, EntityDataSerializers.BOOLEAN);

    public SimpleContainer inventory;
    private LazyOptional<?> itemHandler = null;

    @Override
    public Vec3 getLeashOffset() {
        return new Vec3(0D, (double)this.getEyeHeight() * 0.9F, (double)(this.getBbWidth() * 1.5F));
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
        private final Ichthy spino;
        public SpinoSwimGoal(Ichthy p_27505_) {
            super(p_27505_, 1.0D, 40);
            this.spino = p_27505_;
        }
        public boolean canUse() {
            return this.spino.canRandomSwim() && super.canUse();
        }
    }

    public static final Predicate<LivingEntity> PREY_SELECTOR = (entity) -> {
        return !(entity instanceof TamableAnimal && ((TamableAnimal) entity).isTame()) && entity.getType() != EntityType.PLAYER;
    };

    @Override
    public float getStepHeight() {
        return 1f;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new BreathAirGoal(this));
        this.goalSelector.addGoal(0, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, 15, true, true, LivingEntity::attackable));
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(4, new FollowBoatGoal(this));
        this.goalSelector.addGoal(0, new DinoWeakMeleeGoal(this, 1, true));
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

        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, true, new Predicate<LivingEntity>() {
            @Override
            public boolean test(@Nullable LivingEntity livingEntity) {
                if (livingEntity instanceof Mahakala)
                    return false;
                if (livingEntity instanceof Ichthy)
                    return false;
                if (livingEntity instanceof Car)
                    return false;
                if (livingEntity instanceof CarFlipped)
                    return false;
                if (livingEntity instanceof ArmorStand)
                    return false;
                if (livingEntity instanceof Squid)
                    return false;
                if (livingEntity instanceof Dolphin)
                    return false;
                if (livingEntity instanceof TamableAnimal) //<- taken care of by the prey selector
                    return false;
                if (livingEntity instanceof Player) //<- taken care of by the prey selector
                    return false;
                return true;
            }
        }));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.TURTLE_AMBIENT_LAND;
    }
    protected SoundEvent getDeathSound () {
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
            if (isAggressive()) {
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
    public void registerControllers (AnimationData data){
        data.addAnimationController(new AnimationController(this, "controller", 3, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController", 1, this::attackPredicate));
    }

    //Tameable Entity
    private static final Set<Item> TAME_FOOD = Sets.newHashSet(Items.TURTLE_EGG);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(DDDTags.Items.SEMI_AQUATIC_FOOD);

    public boolean isFood(ItemStack p_28271_) {
        return FOOD_ITEMS.test(p_28271_);
    }

    public InteractionResult mobInteract(Player p_30412_, InteractionHand p_30413_) {
        ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
        Item item = itemstack.getItem();
        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(p_30412_) || this.isTame() || TAME_FOOD.contains(itemstack.getItem()) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    this.heal((float)itemstack.getFoodProperties(this).getNutrition());
                    if (!p_30412_.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    this.gameEvent(GameEvent.MOB_INTERACT, this.eyeBlockPosition());
                    return InteractionResult.SUCCESS;

                } else if(itemstack.is(Items.CHEST) && this.isChestable()) {
                    // equip chest
                    this.setChested(true);
                    this.equipChest(SoundSource.NEUTRAL);
                    this.updateInventory();
                    return InteractionResult.sidedSuccess(this.level.isClientSide);

                } else if(!this.level.isClientSide) {
                    if (p_30412_.isShiftKeyDown()) {
                        // open chest inventory
                        NetworkHooks.openGui((ServerPlayer) p_30412_, new SimpleMenuProvider((containerId, inventory, serverPlayer) -> {
                            return new IchthyMenu(containerId, inventory, this.inventory, this);
                        }, this.getDisplayName()), (data) -> {
                            data.writeInt(this.getInventorySize());
                            data.writeInt(this.getId());
                        });
                        return InteractionResult.SUCCESS;
                    }
                }

                if (!(item instanceof DyeItem)) {
                    InteractionResult interactionresult = super.mobInteract(p_30412_, p_30413_);
                    if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(p_30412_)) {
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget((LivingEntity)null);
                        return InteractionResult.SUCCESS;
                    }

                    return interactionresult;
                }

            } else if (TAME_FOOD.contains(itemstack.getItem())) {
                if (!p_30412_.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (this.random.nextInt(2) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_30412_)) {
                    this.tame(p_30412_);
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    this.setOrderedToSit(true);
                    this.level.broadcastEntityEvent(this, (byte)7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte)6);
                }

                return InteractionResult.SUCCESS;
            }

            return super.mobInteract(p_30412_, p_30413_);
        }
    }


    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    static class SpinoStrollOnLandGoal extends RandomStrollGoal {
        private final Ichthy spino;

        SpinoStrollOnLandGoal(Ichthy p_30303_, double p_30304_, int p_30305_) {
            super(p_30303_, p_30304_, p_30305_);
            this.spino = p_30303_;
        }

        public boolean canUse() {
            return !this.mob.isInWater() && super.canUse();
        }
    }

    static class SpinoPathNav extends WaterBoundPathNavigation {
        SpinoPathNav(Ichthy p_30294_, Level p_30295_) {
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
            if (this.mob instanceof Ichthy) {
                Ichthy spino = (Ichthy)this.mob;
            }

            return !this.level.getBlockState(p_30300_.below()).isAir();
        }
    }

    public void travel(Vec3 p27490) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.7F, p27490);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0D));
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
        } else {
            super.travel(p27490);
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
        return IchthyModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
    }


    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Ichthy.class, EntityDataSerializers.INT);

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

        if(compoundNBT.contains("Chested")) {
            this.setChested(compoundNBT.getBoolean("Chested"));
        }

        this.updateInventory();
        if(this.isChested()) {
            ListTag listTag = compoundNBT.getList("Items", 10);

            for(int i = 0; i < listTag.size(); i++) {
                CompoundTag compoundTag = listTag.getCompound(i);
                int j = compoundTag.getByte("Slot") & 255;
                if(j < this.inventory.getContainerSize()) {
                    this.inventory.setItem(j, ItemStack.of(compoundTag));
                }
            }
        }

    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundNBT) {
        super.addAdditionalSaveData(compoundNBT);
        compoundNBT.putInt("Variant", getVariant());

        compoundNBT.putBoolean("Chested", this.isChested());

        if(this.isChested()) {
            ListTag listTag = new ListTag();

            for(int i = 0; i < this.inventory.getContainerSize(); i++) {
                ItemStack itemStack = this.inventory.getItem(i);
                if(!itemStack.isEmpty()) {
                    CompoundTag compoundTag = new CompoundTag();
                    compoundTag.putByte("Slot", (byte) i);
                    itemStack.save(compoundTag);
                    listTag.add(compoundTag);
                }
            }
            compoundNBT.put("Items", listTag);
        }
    }


    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {

        setVariant(new Random().nextInt(IchthyModel.Variant.values().length));

        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    public boolean canBeParent() {
        return !this.isBaby() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }

    @Override
    public boolean canMate(Animal animal) {
        if (animal == this || !(animal instanceof Ichthy)) {
            return false;
        } else {
            return this.canBeParent() && ((Ichthy)animal).canBeParent();
        }
    }

    @Override
    public Ichthy getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return EntityTypes.ICHTHY_ENTITY.get().create(level);
    }

    @Override
    protected void defineSynchedData(){
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
        this.entityData.define(CHESTED, false);
    }



    @Override
    public boolean isChestable() {
        return this.isAlive() && !this.isBaby() && this.isTame();
    }

    @Override
    public void equipChest(@Nullable SoundSource soundSource) {
        if(soundSource != null) {
            this.level.playSound(null, this, SoundEvents.MULE_CHEST, soundSource, 0.5f, 1f);
        }
    }

    private int getInventorySize() {
        return this.isChested() ? 51 : 1;
    }

    private void updateInventory() {
        SimpleContainer tempInventory = this.inventory;
        this.inventory = new SimpleContainer(this.getInventorySize());

        if(tempInventory != null) {
            tempInventory.removeListener(this);
            int maxSize = Math.min(tempInventory.getContainerSize(), this.inventory.getContainerSize());

            for(int i = 0; i < maxSize; i++) {
                ItemStack itemStack = tempInventory.getItem(i);
                if(!itemStack.isEmpty()) {
                    this.inventory.setItem(i, itemStack.copy());
                }
            }
        }
        this.inventory.addListener(this);
        this.itemHandler = LazyOptional.of(() -> new InvWrapper(this.inventory));
    }

    @Override
    protected void dropEquipment() {
        if(!this.level.isClientSide) {
            super.dropEquipment();
            if(this.isChested()) {
                this.spawnAtLocation(Items.CHEST);
            }
            Containers.dropContents(this.level, this, this.inventory);
        }
    }

    @Override
    public boolean isChested() {
        return this.entityData.get(CHESTED);
    }

    private void setChested(boolean chested) {
        this.entityData.set(CHESTED, chested);
    }

    @Override
    public void containerChanged(Container container) {
    }
}