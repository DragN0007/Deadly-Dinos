package com.dragn0007.deadlydinos.datagen.biglooter;

import com.dragn0007.deadlydinos.block.DDDBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class DDDBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DDDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
