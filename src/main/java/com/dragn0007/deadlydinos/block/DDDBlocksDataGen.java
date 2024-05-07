package com.dragn0007.deadlydinos.block;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.block.plushy.Plushy;
import com.dragn0007.deadlydinos.item.DDDItems;
import com.dragn0007.deadlydinos.item.util.DDDItemGroup;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DDDBlocksDataGen {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, DeadlyDinos.MODID);


    public static final RegistryObject<Block> PARA_PLUSHY_1 = registerBlock("para_plushy_1",
            () -> new Plushy());
    public static final RegistryObject<Block> PARA_PLUSHY_2 = registerBlock("para_plushy_2",
            () -> new Plushy());

    public static final RegistryObject<Block> ACRO_PLUSHY_1 = registerBlock("acro_plushy_1",
            () -> new Plushy());
    public static final RegistryObject<Block> ACRO_PLUSHY_2 = registerBlock("acro_plushy_2",
            () -> new Plushy());




    public static final RegistryObject<FlowerBlock> ASTEROXYLON = registerBlock("asteroxylon",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 20, Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission()));
    public static final RegistryObject<FlowerBlock> HORSETAIL = registerBlock("horsetail",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 20, Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission()));



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
