package com.dragn0007.deadlydinos.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;


public class TamableDestroyWaterPlantsGoal extends Goal {

    //For Aquatic Herbivores.

    private boolean checkState(BlockState state) {
        return state.is(BlockTags.CROPS)
                || state.is(Blocks.SEAGRASS)
                || state.is(Blocks.TALL_SEAGRASS)
                || state.is(Blocks.LILY_PAD)
                || state.is(Blocks.MELON)
                || state.is(Blocks.PUMPKIN)
                || state.is(Blocks.HAY_BLOCK);
    }

    private final Animal entity;
    private BlockPos currentTarget;
    private final TamableAnimal tamableEntity;

    public TamableDestroyWaterPlantsGoal(Animal entity, TamableAnimal tamableEntity) {
        this.entity = entity;
        this.currentTarget = null;
        this.tamableEntity = tamableEntity;
    }


    @Override
    public void tick() {
        if (currentTarget == null) {
            return;
        }

        double distanceSq = entity.distanceToSqr(currentTarget.getX(), currentTarget.getY(), currentTarget.getZ());
        if (distanceSq > 32) { // Blocks away from target
            entity.getNavigation().moveTo(currentTarget.getX(), currentTarget.getY(), currentTarget.getZ(), 1.0);
        } else {
            BlockState state = entity.level.getBlockState(currentTarget);
            if (checkState(state)) {
                List<ItemStack> drops = Block.getDrops(state, (ServerLevel) entity.level, currentTarget, null, entity, ItemStack.EMPTY);
                if (entity.getRandom().nextFloat() < 0.1) { // check if random number is less than 0.2
                    for (ItemStack drop : drops) {
                        entity.level.addFreshEntity(new ItemEntity(entity.level, currentTarget.getX() + 0.5, currentTarget.getY() + 0.5, currentTarget.getZ() + 0.5, drop));
                    }
                }
                entity.level.destroyBlock(currentTarget, false);
            }
            currentTarget = null;
        }
    }

    private boolean findNewTarget(int x, int y, int z) {
        if (entity.level == null) {
            return false;
        }

        BlockPos pos = new BlockPos(x, y, z);
        BlockState state = entity.level.getBlockState(pos);
        if (checkState(state)) {
            currentTarget = pos;
            return true;
        }
        return false;
    }


    public boolean canUse() {
        if (tamableEntity.isTame()) {
            return false;
        }

        if (currentTarget != null && entity.level.getBlockState(currentTarget).getBlock() == Blocks.AIR) {
            currentTarget = null;
        }
        if (currentTarget != null) {
            try {
                BlockState blockState = entity.level.getBlockState(currentTarget);
                if (blockState.getBlock() == Blocks.AIR) {
                    currentTarget = null;
                }
            } catch (NullPointerException e) {
                currentTarget = null;
            }
        }
        for (int i = 0; i < 30; i++) {
            int x = Mth.floor(entity.getX() + entity.getRandom().nextInt(20) - 10);
            int y = Mth.floor(entity.getY() + entity.getRandom().nextInt(6) - 3);
            int z = Mth.floor(entity.getZ() + entity.getRandom().nextInt(20) - 10);
            if (findNewTarget(x, y, z)) {
                return true;
            }
        }
        return false;
    }


    public void someMethod() {
        for (int i = 0; i < 10; i++) {
            int x = Mth.floor(entity.getX() + entity.getRandom().nextInt(20) - 10);
            int y = Mth.floor(entity.getY() + entity.getRandom().nextInt(6) - 3);
            int z = Mth.floor(entity.getZ() + entity.getRandom().nextInt(20) - 10);

            boolean success = findNewTarget(x, y, z);
            if (success) {
                // Do something with currentTarget
                break;
            }
        }
    }
}



