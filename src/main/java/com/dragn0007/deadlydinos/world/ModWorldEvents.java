package com.dragn0007.deadlydinos.world;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.world.gen.ModFlowerGeneration;
import com.dragn0007.deadlydinos.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber (modid = DeadlyDinos.MODID)
public class ModWorldEvents {



    @SubscribeEvent
            public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

    ModFlowerGeneration.generateFlowers(event);
    ModTreeGeneration.generateTrees(event);


    }
}
