package com.dragn0007.deadlydinos.entity.sounds;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DinoSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DeadlyDinos.MODID);

    public static RegistryObject<SoundEvent> CHUFF = registerSoundEvent("sounds/chuff");
    public static RegistryObject<SoundEvent> MEDIUM_GROWL1 = registerSoundEvent("medium_growl1");
    public static RegistryObject<SoundEvent> MEDIUM_GROWL2 = registerSoundEvent("medium_growl2");
    public static RegistryObject<SoundEvent> MEDIUM_GROWL3 = registerSoundEvent("medium_growl3");
    public static RegistryObject<SoundEvent> MEDIUM_GROWL4 = registerSoundEvent("medium_growl4");
    public static RegistryObject<SoundEvent> LARGE_HERBI1 = registerSoundEvent("large_herbi1");
    public static RegistryObject<SoundEvent> LARGE_HERBI2 = registerSoundEvent("large_herbi2");
    public static RegistryObject<SoundEvent> SAUROPOD1 = registerSoundEvent("sauropod1");



    public static final ForgeSoundType MEDIUM_CARNI = new ForgeSoundType(1f, 1f,
            DinoSounds.CHUFF, DinoSounds.MEDIUM_GROWL1, DinoSounds.MEDIUM_GROWL2, DinoSounds.MEDIUM_GROWL3, DinoSounds.MEDIUM_GROWL4);

    public static final ForgeSoundType LARGE_HERBI = new ForgeSoundType(1f, 1f,
            DinoSounds.LARGE_HERBI1, DinoSounds.LARGE_HERBI2, DinoSounds.LARGE_HERBI1, DinoSounds.LARGE_HERBI2, DinoSounds.LARGE_HERBI1);

    public static final ForgeSoundType SAUROPOD = new ForgeSoundType(1f, 1f,
            DinoSounds.SAUROPOD1, DinoSounds.SAUROPOD1, DinoSounds.SAUROPOD1, DinoSounds.SAUROPOD1, DinoSounds.SAUROPOD1);


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(DeadlyDinos.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
