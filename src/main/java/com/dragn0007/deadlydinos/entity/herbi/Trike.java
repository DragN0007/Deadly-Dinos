package com.dragn0007.deadlydinos.entity.herbi;


import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.client.menu.TrikeMenu;
import com.dragn0007.deadlydinos.client.model.TrikeModel;
import com.dragn0007.deadlydinos.entity.Chestable;
import com.dragn0007.deadlydinos.entity.ai.DinoMeleeGoal;
import com.dragn0007.deadlydinos.entity.ai.TamableDestroyCropsGoal;
import com.dragn0007.deadlydinos.entity.util.EntityTypes;
import com.dragn0007.deadlydinos.entity.util.Serializers;
import com.dragn0007.deadlydinos.event.network.Network;
import com.dragn0007.deadlydinos.util.DDDTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.jetbrains.annotations.NotNull;
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
import java.util.Random;

public class Trike extends TamableAnimal implements ContainerListener, Saddleable, IAnimatable, Chestable {

    enum Mode {
        TILL(new ResourceLocation(DeadlyDinos.MODID, "textures/gui/tillmode.png")),
        HARVEST(new ResourceLocation(DeadlyDinos.MODID, "textures/gui/harvestmode.png")),
        NO(new ResourceLocation(DeadlyDinos.MODID, "textures/gui/nomode.png"));

        public final ResourceLocation texture;

        Mode(ResourceLocation texture) {
            this.texture = texture;
        }

        public Mode next() {
            return Mode.values()[(this.ordinal() + 1) % Mode.values().length];
        }
    }

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public Trike(EntityType<? extends Trike> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
        this.updateInventory();
    }

    @Override
    public Vec3 getLeashOffset() {
        return new Vec3(0D, (double)this.getEyeHeight() * 0.6F, (double)(this.getBbWidth() * 1.3F));
        //                      ^ Side offset                             ^ Height offset                  ^ Length offset
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.ATTACK_DAMAGE, 9)
                .add(Attributes.MOVEMENT_SPEED, 0.21)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ARMOR_TOUGHNESS, 5)
                ;

    }

    private static final EntityDataAccessor<Boolean> SADDLED = SynchedEntityData.defineId(Trike.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CHESTED = SynchedEntityData.defineId(Trike.class, EntityDataSerializers.BOOLEAN);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(DDDTags.Items.HERBI_FOOD);

    public SimpleContainer inventory;
    private LazyOptional<?> itemHandler = null;


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
        this.goalSelector.addGoal(2, new TamableDestroyCropsGoal(this, this));
        this.goalSelector.addGoal(0, new DinoMeleeGoal(this, 1.6, true));
        this.goalSelector.addGoal(4, new FloatGoal(this));

        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
    }


    //Animation
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
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
                        return new TrikeMenu(containerId, inventory, this.inventory, this);
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

    //Till
     public static IIngameOverlay trikeHUD() {
            return (gui, poseStack, partialTick, width, height) -> {
            Minecraft minecraft = Minecraft.getInstance();
            Player player = (Player) minecraft.getCameraEntity();

            if(!minecraft.options.hideGui && player instanceof LocalPlayer && player.getVehicle() instanceof Trike trike) {
                Trike.Mode mode = trike.mode();
                ResourceLocation texture = mode.texture;

                int x = (width / 2) + 92;
                int y = height - 32;

                gui.setupOverlayRenderState(true, false, texture);
                gui.blit(poseStack, x, y, 0, 0, 32, 32);
            }
        };
     }

    public static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(DeadlyDinos.MODID, "network"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static final EntityDataAccessor<Integer> MODE = (EntityDataAccessor<Integer>) SynchedEntityData.defineId(Trike.class, Serializers.MODE_SERIALIZER.get().getSerializer());

    public Mode mode() {
        return Mode.values() [this.entityData.get(MODE)];
    }

    public void cycleMode() {
        this.entityData.set(MODE, this.mode().next().ordinal());
    }

    private void harvestCrop(BlockPos pos) {
        if(this.level.getBlockState(pos).getBlock() instanceof CropBlock cropBlock) {
            BlockState blockState = this.level.getBlockState(pos);
            if(cropBlock.isMaxAge(blockState)) {
                List<ItemStack> drops = Block.getDrops(blockState, (ServerLevel) this.level, pos, null);
                drops.remove(new ItemStack(cropBlock.asItem()));
                drops.forEach(itemStack -> {
                    if(this.inventory.canAddItem(itemStack)) {
                        this.inventory.addItem(itemStack);
                    } else {
                        this.spawnAtLocation(itemStack);
                    }
                });

                this.level.setBlockAndUpdate(pos, blockState.setValue(cropBlock.getAgeProperty(), 0));
            }
        }
    }

    private void tillNewFarmland(BlockPos pos) {
        pos = pos.below();
        BlockState blockState = this.level.getBlockState(pos);
        if (blockState.is(Blocks.DIRT) || blockState.is(Blocks.MYCELIUM) || blockState.is(Blocks.GRASS_BLOCK) || blockState.is(Blocks.PODZOL)) {
            this.level.setBlockAndUpdate(pos, Blocks.FARMLAND.defaultBlockState());
        }
    }

    private Vec3 calcOffset(double x, double y, double z) {
        double rad = this.getYRot() * Math.PI / 180;

        double xOffset = this.position().x + (x * Math.cos(rad) - z * Math.sin(rad));
        double yOffset = this.position().y + y;
        double zOffset = this.position().z + (x * Math.sin(rad) + z * Math.cos(rad));

        return new Vec3(xOffset, yOffset, zOffset);
    }

    public void harvest() {
        Vec3 left = this.calcOffset(-1, 0.2, -1.65);
        Vec3 mid = this.calcOffset(0, 0.2, -1.65);
        Vec3 right = this.calcOffset(1, 0.2, -1.65);

        BlockPos leftPos = new BlockPos(Math.floor(left.x), Math.floor(left.y), Math.floor(left.z));
        BlockPos midPos = new BlockPos(Math.floor(mid.x), Math.floor(mid.y), Math.floor(mid.z));
        BlockPos rightPos = new BlockPos(Math.floor(right.x), Math.floor(right.y), Math.floor(right.z));

        this.harvestCrop(leftPos);
        this.harvestCrop(midPos);
        this.harvestCrop(rightPos);
    }

    public void till() {
        Vec3 left = this.calcOffset(-1, 0.2, -1.65);
        Vec3 mid = this.calcOffset(0, 0.2, -1.65);
        Vec3 right = this.calcOffset(1, 0.2, -1.65);

        BlockPos leftPos = new BlockPos(Math.floor(left.x), Math.floor(left.y), Math.floor(left.z));
        BlockPos midPos = new BlockPos(Math.floor(mid.x), Math.floor(mid.y), Math.floor(mid.z));
        BlockPos rightPos = new BlockPos(Math.floor(right.x), Math.floor(right.y), Math.floor(right.z));

        this.tillNewFarmland(leftPos);
        this.tillNewFarmland(midPos);
        this.tillNewFarmland(rightPos);
    }


    public Vec3 lastClientPos = Vec3.ZERO;
    public Vec3 lastServerPos = Vec3.ZERO;
    private int lerpSteps;
    private double targetX;
    private double targetY;
    private double targetZ;
    private float targetYRot;

    public void calcAnimStep() {
        double xStep = this.position().x - this.lastClientPos.x;
        double zStep = this.position().z - this.lastClientPos.z;
        float deg = (float) (Math.atan2(xStep, zStep) * 180 / Math.PI);
    }

    @Override
    public void tick() {
        super.tick();
        this.lastClientPos = this.position();

        if(this.getControllingPassenger() instanceof LocalPlayer player) {
            this.handleInput((KeyboardInput) player.input);
        }

        if(!this.level.isClientSide) {
            Vec3 diff = this.lastServerPos.subtract(this.position());
            this.lastServerPos = this.position();
            if(this.isVehicle() && diff.length() != 0) {
                if(this.mode() == Mode.TILL) {
                    this.till();
                } else if(this.mode() == Mode.HARVEST) {
                    this.harvest();
                }

            }

        } else if(this.mode() != Mode.NO) {
            Vec3 pos = this.calcOffset(0.9, 3.7, 0.1);
            double yVel = this.random.nextDouble();
            if(yVel > 0.75) {
                this.level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.x, pos.y, pos.z, 0, yVel / 10, 0);
            }
        }

        if (this.lerpSteps > 0) {
            double x = this.getX() + (this.targetX - this.getX()) / this.lerpSteps;
            double y = this.getY() + (this.targetY - this.getY()) / this.lerpSteps;
            double z = this.getZ() + (this.targetZ - this.getZ()) / this.lerpSteps;

            float yRot = this.getYRot() + (this.targetYRot - this.getYRot()) / this.lerpSteps;

            this.setPos(x, y, z);
            this.setYRot(yRot);
            this.lerpSteps--;
        }

        this.calcAnimStep();
    }

    private int tillerCooldown = 0;

    private void handleInput(KeyboardInput input) {

        this.tillerCooldown = Math.max(this.tillerCooldown - 1, 0);
        if(input.jumping && this.tillerCooldown == 0) {
            Network.INSTANCE.sendToServer(new Network.ToggleTillerPowerRequest(this.getId()));
            this.tillerCooldown = 10;
        }

    }


    //Generates variant textures

    public ResourceLocation getTextureLocation() {
        return TrikeModel.Variant.variantFromOrdinal(getVariant()).resourceLocation;
    }


    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Trike.class, EntityDataSerializers.INT);

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
        tag.putString("TillerOn", this.mode().toString());

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

    @Override
    @NotNull
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {

        setVariant(new Random().nextInt(TrikeModel.Variant.values().length));

        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    public boolean canBeParent() {
        return !this.isBaby() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }

    @Override
    public boolean canMate(Animal animal) {
        if (animal == this || !(animal instanceof Trike)) {
            return false;
        } else {
            return this.canBeParent() && ((Trike)animal).canBeParent();
        }
    }

    @Override
    public Trike getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return EntityTypes.TRIKE_ENTITY.get().create(level);
    }


    @Override
    protected void defineSynchedData(){
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
        this.entityData.define(SADDLED, false);
        this.entityData.define(CHESTED, false);
        this.entityData.define(MODE, Mode.NO.ordinal());
    }


    @Override
    public void positionRider(Entity entity) {
        if (this.hasPassenger(entity)) {

            double offsetX = 0;
            double offsetY = 2.8;
            double offsetZ = -0.5;

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

    @Nullable
    public Entity getControllingPassenger() {
        return this.getOwner() == this.getFirstPassenger() ? this.getFirstPassenger() : null;
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
    public void travel(Vec3 vec) {
        if (this.isAlive()) {
            if (this.isVehicle() && this.canBeControlledByRider()) {
                LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
                this.setYRot(livingentity.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(livingentity.getXRot() * 0.5F);
                this.setRot(this.getYRot(), this.getXRot());
                this.yBodyRot = this.getYRot();
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.4F; //Strafe moving speed
                float f1 = livingentity.zza * 0.7F; //Foward moving speed
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                }

                this.flyingSpeed = this.getSpeed() * 0.1F;
                if (this.isControlledByLocalInstance()) {
                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    super.travel(new Vec3(f, vec.y, f1));
                } else if (livingentity instanceof Player) {
                    this.setDeltaMovement(Vec3.ZERO);
                }

                this.calculateEntityAnimation(this, false);
                this.tryCheckInsideBlocks();
            } else {
                this.flyingSpeed = 0.02F;
                super.travel(vec);
            }
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