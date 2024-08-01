package com.dragn0007.deadlydinos.entity.marine;

import com.dragn0007.deadlydinos.client.menu.BasiloMenu;
import com.dragn0007.deadlydinos.client.model.BasiloModel;
import com.dragn0007.deadlydinos.entity.Chestable;
import com.dragn0007.deadlydinos.entity.marine.base.AbstractTamableMarineDino;
import com.dragn0007.deadlydinos.entity.util.EntityTypes;
import com.dragn0007.deadlydinos.util.DDDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.items.CapabilityItemHandler;
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


public class Basilo extends AbstractTamableMarineDino implements IAnimatable, Saddleable, Chestable, ContainerListener {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    private static final EntityDataAccessor<Boolean> SADDLED = SynchedEntityData.defineId(Basilo.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CHESTED = SynchedEntityData.defineId(Basilo.class, EntityDataSerializers.BOOLEAN);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(DDDTags.Items.SEMI_AQUATIC_FOOD);

    public SimpleContainer inventory;
    private LazyOptional<?> itemHandler = null;

    public Basilo(EntityType<? extends Basilo> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
        this.updateInventory();
    }

    @Override
    public Vec3 getLeashOffset() {
        return new Vec3(0D, (double)this.getEyeHeight() * 0.8F, (double)(this.getBbWidth() * 1F));
        //                      ^ Side offset                             ^ Height offset                  ^ Length offset
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 250)
                .add(Attributes.ATTACK_DAMAGE, 6)
                .add(Attributes.ATTACK_KNOCKBACK, 3)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ARMOR, 6)
    ;}

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(1, new MeleeAttackGoal(this, 2F, true));
        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));

        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        }



    //Animation
    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            if (isAggressive() || isVehicle()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("swimfast", ILoopType.EDefaultLoopTypes.LOOP));
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", ILoopType.EDefaultLoopTypes.LOOP));
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



    @Override
    public boolean isFood(ItemStack itemStack) {
        return FOOD_ITEMS.test(itemStack);
    }

    public boolean hurt(DamageSource damageSource, float amount) {
        if (damageSource.getEntity() instanceof Player player && player.isCrouching()) {
            if (this.isOrderedToSit()) {
                this.setOrderedToSit(false);
            } else {
                this.setOrderedToSit(true);
            }
            return false;
        }
        return super.hurt(damageSource, amount);
    }


    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if(this.isTame()) {
            if(this.isFood(itemStack)) {
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
            } else if(itemStack.is(Items.SADDLE) && this.isSaddleable()) {
                itemStack.interactLivingEntity(player, this, hand);
                this.setSaddled(true);
                this.updateInventory();
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            } else if(itemStack.is(Items.CHEST) && this.isChestable()) {
                // equip chest
                this.setChested(true);
                this.equipChest(SoundSource.NEUTRAL);
                this.updateInventory();
                return InteractionResult.sidedSuccess(this.level.isClientSide);

            } else if(!this.level.isClientSide) {
                if(player.isShiftKeyDown()) {
                    // open chest inventory
                    NetworkHooks.openGui((ServerPlayer) player, new SimpleMenuProvider((containerId, inventory, serverPlayer) -> {
                        return new BasiloMenu(containerId, inventory, this.inventory, this);
                    }, this.getDisplayName()), (data) -> {
                        data.writeInt(this.getInventorySize());
                        data.writeInt(this.getId());
                    });
                    return InteractionResult.SUCCESS;
                } else if(this.isSaddled() && !this.isOrderedToSit()) {
                    // hop on
                    this.doPlayerRide(player);
                    return InteractionResult.SUCCESS;
                }
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

    //Generates variant textures

    public ResourceLocation getTextureLocation() {
        return BasiloModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
    }


    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Basilo.class, EntityDataSerializers.INT);

    public int getVariant(){
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

        if(tag.contains("Chested")) {
            this.setChested(tag.getBoolean("Chested"));
        }

        this.updateInventory();
        if(this.isChested()) {
            ListTag listTag = tag.getList("Items", 10);

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
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", getVariant());
        tag.putBoolean("Saddled", this.isSaddled());
        tag.putBoolean("Chested", this.isChested());

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
            tag.put("Items", listTag);
        }
    }


    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {

        setVariant(new Random().nextInt(BasiloModel.Variant.values().length));

        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    public boolean canBeParent() {
        return !this.isBaby() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }

    @Override
    public boolean canMate(Animal animal) {
        if (animal == this || !(animal instanceof Basilo)) {
            return false;
        } else {
            return this.canBeParent() && ((Basilo)animal).canBeParent();
        }
    }

    @Override
    public Basilo getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return EntityTypes.BASILO_ENTITY.get().create(level);
    }


    @Override
    protected void defineSynchedData(){
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
        this.entityData.define(SADDLED, false);
        this.entityData.define(CHESTED, false);
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
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if(this.isAlive() && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && this.itemHandler != null) {
            return itemHandler.cast();
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        if(this.itemHandler != null) {
            LazyOptional<?> oldHandler = this.itemHandler;
            this.itemHandler = null;
            oldHandler.invalidate();
        }
    }

    @Override
    public float getStepHeight() {
        return 1f;
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
        this.inventory.setItem(0, new ItemStack(Items.SADDLE));
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

    @Override
    public boolean isChested() {
        return this.entityData.get(CHESTED);
    }

    private void setChested(boolean chested) {
        this.entityData.set(CHESTED, chested);
    }

    protected void doPlayerRide(Player p_30634_) {
        if (!this.level.isClientSide) {
            p_30634_.setYRot(this.getYRot());
            p_30634_.setXRot(this.getXRot());
            p_30634_.startRiding(this);
        }
    }

    @Override
    public void positionRider(Entity entity) {
        if (this.hasPassenger(entity)) {
            double offsetX;
            double offsetY;
            double offsetZ;

            offsetX = 0;
            offsetY = 1.4;
            offsetZ = 2.4;

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

    private Vec3 calcOffset ( double x, double y, double z){
        double rad = this.getYRot() * Math.PI / 180;

        double xOffset = this.position().x + (x * Math.cos(rad) - z * Math.sin(rad));
        double yOffset = this.position().y + y;
        double zOffset = this.position().z + (x * Math.sin(rad) + z * Math.cos(rad));

        return new Vec3(xOffset, yOffset, zOffset);
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

        for(Pose pose : p_30563_.getDismountPoses()) {
            blockpos$mutableblockpos.set(d0, d1, d2);
            double d3 = this.getBoundingBox().maxY + 0.75D;

            while(true) {
                double d4 = this.level.getBlockFloorHeight(blockpos$mutableblockpos);
                if ((double)blockpos$mutableblockpos.getY() + d4 > d3) {
                    break;
                }

                if (DismountHelper.isBlockFloorValid(d4)) {
                    AABB aabb = p_30563_.getLocalBoundsForPose(pose);
                    Vec3 vec3 = new Vec3(d0, (double)blockpos$mutableblockpos.getY() + d4, d2);
                    if (DismountHelper.canDismountTo(this.level, p_30563_, aabb.move(vec3))) {
                        p_30563_.setPose(pose);
                        return vec3;
                    }
                }

                blockpos$mutableblockpos.move(Direction.UP);
                if (!((double)blockpos$mutableblockpos.getY() < d3)) {
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