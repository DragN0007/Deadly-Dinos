package com.dragn0007.deadlydinos.entity.util;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DataSerializerEntry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Serializers {

    public static final DeferredRegister<DataSerializerEntry> RESOURCE_SERIALIZER_REGISTER = DeferredRegister.create(ForgeRegistries.Keys.DATA_SERIALIZERS, DeadlyDinos.MODID);

    public static final RegistryObject<DataSerializerEntry> RESOURCE_SERIALIZER = RESOURCE_SERIALIZER_REGISTER.register("resource_serializer", () -> new DataSerializerEntry(new EntityDataSerializer<ResourceLocation>() {
        @Override
        public void write(FriendlyByteBuf buffer, ResourceLocation resourceLocation) {
            buffer.writeResourceLocation(resourceLocation);
        }

        @Override
        public ResourceLocation read(FriendlyByteBuf buffer) {
            return buffer.readResourceLocation();
        }

        @Override
        public ResourceLocation copy(ResourceLocation resourceLocation) {
            return resourceLocation;
        }
    }));
}
