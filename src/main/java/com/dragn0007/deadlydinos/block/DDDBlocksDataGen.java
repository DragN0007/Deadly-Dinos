package com.dragn0007.deadlydinos.block;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.item.DDDItems;
import com.dragn0007.deadlydinos.item.util.DDDItemGroup;
import com.dragn0007.deadlydinos.world.feature.tree.ConiferTreeGrower;
import com.dragn0007.deadlydinos.world.feature.tree.SequoiaTreeGrower;
import com.dragn0007.deadlydinos.world.feature.tree.YewTreeGrower;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DDDBlocksDataGen {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, DeadlyDinos.MODID);









    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        DDDItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(DDDItemGroup.BLOCK_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
