package com.dragn0007.deadlydinos;

import com.dragn0007.deadlydinos.block.DDDBlocks;
import com.dragn0007.deadlydinos.block.DDDBlocksDataGen;
import com.dragn0007.deadlydinos.client.gui.DDDMenuTypes;
import com.dragn0007.deadlydinos.entity.util.EntityTypes;
import com.dragn0007.deadlydinos.event.network.Network;
import com.dragn0007.deadlydinos.item.DDDItems;
import com.dragn0007.deadlydinos.util.config.DeadlyDinosCommonConfig;
import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

import static com.dragn0007.deadlydinos.DeadlyDinos.MODID;
import static com.dragn0007.deadlydinos.entity.util.Serializers.SERIALIZERS;

@Mod(MODID)
public class DeadlyDinos
{

    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "deadlydinos";

    public DeadlyDinos()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SERIALIZERS.register(eventBus);

        DDDItems.register(eventBus);
        DDDBlocks.register(eventBus);
        DDDBlocksDataGen.register(eventBus);
        EntityTypes.ENTITY_TYPES.register(eventBus);
        DDDMenuTypes.register(eventBus);

        GeckoLib.initialize();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DeadlyDinosCommonConfig.SPEC, "deadlydinos-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
        }
        static {
            GeckoLibMod.DISABLE_IN_DEV = true;
        }
    }
}

