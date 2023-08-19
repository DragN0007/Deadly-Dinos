package com.dragn0007.deadlydinos.entity.ai;

import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Set;


public class DestroyPersonalPropertyGoal extends Goal {

    //Any dino that runs this goal is a total jerk. I'm talking to you, Troodon.

    private static final Set<Block> BREAKABLE = Sets.newHashSet(
            Blocks.CHEST,
            Blocks.TRAPPED_CHEST,
            Blocks.BLACK_BED,
            Blocks.BLUE_BED,
            Blocks.BROWN_BED,
            Blocks.RED_BED,
            Blocks.CYAN_BED,
            Blocks.LIGHT_BLUE_BED,
            Blocks.GREEN_BED,
            Blocks.LIME_BED,
            Blocks.WHITE_BED,
            Blocks.GRAY_BED,
            Blocks.LIGHT_GRAY_BED,
            Blocks.ORANGE_BED,
            Blocks.PINK_BED,
            Blocks.YELLOW_BED,
            Blocks.MAGENTA_BED,
            Blocks.PURPLE_BED,
            Blocks.FLOWER_POT,
            Blocks.CAMPFIRE,
            Blocks.BARREL,

            Blocks.ACACIA_DOOR,
            Blocks.BIRCH_DOOR,
            Blocks.CRIMSON_DOOR,
            Blocks.DARK_OAK_DOOR,
            Blocks.IRON_DOOR,
            Blocks.JUNGLE_DOOR,
            Blocks.OAK_DOOR,
            Blocks.SPRUCE_DOOR,
            Blocks.WARPED_DOOR,

            Blocks.ACACIA_FENCE_GATE,
            Blocks.BIRCH_FENCE_GATE,
            Blocks.CRIMSON_FENCE_GATE,
            Blocks.DARK_OAK_FENCE_GATE,
            Blocks.JUNGLE_FENCE_GATE,
            Blocks.OAK_FENCE_GATE,
            Blocks.SPRUCE_FENCE_GATE,
            Blocks.WARPED_FENCE_GATE
    );


    private final Animal entity;
    private BlockPos currentTarget;

    public DestroyPersonalPropertyGoal(Animal entity) {
        this.entity = entity;
        this.currentTarget = null;
    }




    @Override
    public void tick() {
        if (currentTarget == null) {
            return;
        }

        double distanceSq = entity.distanceToSqr(currentTarget.getX(), currentTarget.getY(), currentTarget.getZ());
        if (distanceSq > 8) { // Blocks away from target
            entity.getNavigation().moveTo(currentTarget.getX(), currentTarget.getY(), currentTarget.getZ(), 1.0);
        } else {
            BlockState state = entity.level.getBlockState(currentTarget);
            if (BREAKABLE.contains(state.getBlock())) {
                List<ItemStack> drops = Block.getDrops(state, (ServerLevel) entity.level, currentTarget, null, entity, ItemStack.EMPTY);
                if (entity.getRandom().nextFloat() < 1) {
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
        if (BREAKABLE.contains(state.getBlock())) {
            currentTarget = pos;
            return true;
        }
        return false;
    }


    public boolean canUse() {
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



