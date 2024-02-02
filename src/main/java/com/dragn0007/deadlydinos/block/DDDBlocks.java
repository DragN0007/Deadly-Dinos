package com.dragn0007.deadlydinos.block;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.item.util.DDDItemGroup;
import com.dragn0007.deadlydinos.item.DDDItems;
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

public class DDDBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, DeadlyDinos.MODID);


    //BLOCKS
    public static final RegistryObject<Block> RGLASS = registerBlock("rglass",
            () -> new Block(Block.Properties.of(Material.GLASS).noOcclusion()
                    .strength(2).instabreak()));
    public static final RegistryObject<Block> RSTONEBRICKS = registerBlock("rstonebricks",
            () -> new Block(Block.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops().strength(3.0F, 4.0F)));
    public static final RegistryObject<Block> RCOBBLESTONE = registerBlock("rcobblestone",
            () -> new Block(Block.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops().strength(3.0F, 3.0F)));


    //WOOD
    public static final RegistryObject<RotatedPillarBlock> CONIFERLOG = registerBlock("conifer_log",
            () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CONIFERPLANKS = registerBlock("conifer_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CONIFERLEAVES = registerBlock("conifer_leaves",
            () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> CONIFERSAPLING = registerBlock("conifer_sapling",
            () -> new SaplingBlock(new ConiferTreeGrower(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> RCONIFERPLANKS = registerBlock("rconifer_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2.0F, 2.0F)));
    public static final RegistryObject<Block> CONIFERSTAIRS = registerBlock("conifer_stairs",
            () -> new StairBlock(CONIFERPLANKS.get().defaultBlockState(), Block.Properties.copy(CONIFERPLANKS.get())));
    public static final RegistryObject<Block> CONIFERSLAB = registerBlock("conifer_slab",
            () -> new SlabBlock(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 3.0F)));


    public static final RegistryObject<RotatedPillarBlock> YEWLOG = registerBlock("yew_log",
            () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> YEWPLANKS = registerBlock("yew_planks",
            () -> new Block(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> YEWLEAVES = registerBlock("yew_leaves",
            () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> YEWSAPLING = registerBlock("yew_sapling",
            () -> new SaplingBlock(new YewTreeGrower(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> RYEWPLANKS = registerBlock("ryew_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2.0F, 2.0F)));
    public static final RegistryObject<Block> YEWSTAIRS = registerBlock("yew_stairs",
            () -> new StairBlock(YEWPLANKS.get().defaultBlockState(), Block.Properties.copy(CONIFERPLANKS.get())));
    public static final RegistryObject<Block> YEWSLAB = registerBlock("yew_slab",
            () -> new SlabBlock(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 3.0F)));


    public static final RegistryObject<RotatedPillarBlock> SEQUOIALOG = registerBlock("sequoia_log",
            () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> SEQUOIAPLANKS = registerBlock("sequoia_planks",
            () -> new Block(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> SEQUOIALEAVES = registerBlock("sequoia_leaves",
            () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> SEQUOIASAPLING = registerBlock("sequoia_sapling",
            () -> new SaplingBlock(new SequoiaTreeGrower(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> RSEQUOIAPLANKS = registerBlock("rsequoia_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2.0F, 2.0F)));
    public static final RegistryObject<Block> SEQUOIASTAIRS = registerBlock("sequoia_stairs",
            () -> new StairBlock(SEQUOIAPLANKS.get().defaultBlockState(), Block.Properties.copy(CONIFERPLANKS.get())));
    public static final RegistryObject<Block> SEQUOIASLAB = registerBlock("sequoia_slab",
            () -> new SlabBlock(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 3.0F)));


    public static final RegistryObject<Block> RACACIAPLANKS = registerBlock("racacia_planks",
            () -> new Block(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 4.0F)));
    public static final RegistryObject<Block> RBIRCHPLANKS = registerBlock("rbirch_planks",
            () -> new Block(Block.Properties.of(Material.WOOD)
                   .strength(2.0F, 4.0F)));
    public static final RegistryObject<Block> RCRIMSONPLANKS = registerBlock("rcrimson_planks",
            () -> new Block(Block.Properties.of(Material.NETHER_WOOD)
                    .strength(2.0F, 4.0F)));
    public static final RegistryObject<Block> RDARKOAKPLANKS = registerBlock("rdark_oak_planks",
            () -> new Block(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 4.0F)));
    public static final RegistryObject<Block> RJUNGLEPLANKS = registerBlock("rjungle_planks",
            () -> new Block(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 4.0F)));
    public static final RegistryObject<Block> ROAKPLANKS = registerBlock("roak_planks",
            () -> new Block(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 4.0F)));
    public static final RegistryObject<Block> RSPRUCEPLANKS = registerBlock("rspruce_planks",
            () -> new Block(Block.Properties.of(Material.WOOD)
                    .strength(2.0F, 4.0F)));
    public static final RegistryObject<Block> RWARPEDPLANKS = registerBlock("rwarped_planks",
            () -> new Block(Block.Properties.of(Material.NETHER_WOOD)
                    .strength(2.0F, 4.0F)));


    //PLANTS
    public static final RegistryObject<FlowerBlock> COOKSONIA = registerBlock("cooksonia",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 20, Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission()));
    public static final RegistryObject<FlowerBlock> CYCAS = registerBlock("cycas",
            () -> new FlowerBlock(MobEffects.HEAL, 20, Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission()));
    public static final RegistryObject<FlowerBlock> CYPERUS = registerBlock("cyperus",
            () -> new FlowerBlock(MobEffects.JUMP, 20, Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission()));
    public static final RegistryObject<FlowerBlock> ZOSTER = registerBlock("zoster",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 20, Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission()));
    public static final RegistryObject<TallFlowerBlock> CYCADS = registerBlock("cycads",
            () -> new TallFlowerBlock(Block.Properties.of(Material.REPLACEABLE_PLANT).sound(SoundType.GRASS).noCollission()));




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
