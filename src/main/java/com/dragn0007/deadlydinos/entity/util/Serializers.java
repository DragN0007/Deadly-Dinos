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

    public static final DeferredRegister<DataSerializerEntry> SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.DATA_SERIALIZERS, DeadlyDinos.MODID);
    public static final RegistryObject<DataSerializerEntry> MODE_SERIALIZER = SERIALIZERS.register("mode_serializer", () -> new DataSerializerEntry(new EntityDataSerializer<Integer>() {
        @Override
        public void write(FriendlyByteBuf byteBuf, Integer integer) {
            byteBuf.writeInt(integer);
        }
        @Override
        public Integer read(FriendlyByteBuf byteBuf) {
            return byteBuf.readInt();
        }
        @Override
        public Integer copy(Integer integer) {
            return integer;
        }
    }));

    public static final RegistryObject<DataSerializerEntry> RESOURCE_SERIALIZER = SERIALIZERS.register("resource_serializer", () -> new DataSerializerEntry(new EntityDataSerializer<ResourceLocation>() {
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
