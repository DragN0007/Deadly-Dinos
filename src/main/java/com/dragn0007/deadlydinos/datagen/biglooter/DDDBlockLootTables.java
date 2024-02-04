package com.dragn0007.deadlydinos.datagen.biglooter;

import com.dragn0007.deadlydinos.block.DDDBlocks;
import com.dragn0007.deadlydinos.block.DDDBlocksDataGen;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class DDDBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(DDDBlocksDataGen.PARA_PLUSHY_1.get());
        this.dropSelf(DDDBlocksDataGen.PARA_PLUSHY_2.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DDDBlocksDataGen.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
