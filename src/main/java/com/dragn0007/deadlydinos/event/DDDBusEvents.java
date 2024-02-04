package com.dragn0007.deadlydinos.event;


import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.event.loot.AddDinoGiftBoxToDungeonChest;
import com.dragn0007.deadlydinos.event.loot.AddDinoGiftBoxToMineshaft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = DeadlyDinos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DDDBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new AddDinoGiftBoxToDungeonChest.Serializer().setRegistryName
                        (new ResourceLocation(DeadlyDinos.MODID, "dino_gift_box_dungeon")),
                new AddDinoGiftBoxToMineshaft.Serializer().setRegistryName
                        (new ResourceLocation(DeadlyDinos.MODID, "dino_gift_box_mineshaft"))
        );
    }
}
