package com.dragn0007.deadlydinos.block.plushy;

import com.dragn0007.deadlydinos.block.rot.DecorRotator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class ParaPlushy extends DecorRotator {
    public ParaPlushy() {
        super(NORTH, EAST, SOUTH, WEST);
    }

    public static final VoxelShape NORTH = Stream.of(
            Block.box(10, 0, 0, 14, 12, 10),
            Block.box(1, 0, 10, 14, 6, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape EAST = Stream.of(
            Block.box(6, 0, 10, 16, 12, 14),
            Block.box(0, 0, 1, 6, 6, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape SOUTH = Stream.of(
            Block.box(2, 0, 6, 6, 12, 16),
            Block.box(2, 0, 0, 15, 6, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape WEST = Stream.of(
            Block.box(0, 0, 2, 10, 12, 6),
            Block.box(10, 0, 2, 16, 6, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();


}
