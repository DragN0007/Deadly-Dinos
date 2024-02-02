package com.dragn0007.deadlydinos.item.util;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum DDDArmorMaterial implements ArmorMaterial {

    BONENETHERITE("bonenetherite", 50, new int[]{7, 10, 12, 7}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 5.0F, 0.3F, () -> {
        return Ingredient.of(Items.DIAMOND);
    }),
    BONEDIAMOND("bonediamond", 45, new int[]{5, 8, 10, 5}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 4.0F, 0.2F, () -> {
        return Ingredient.of(Items.DIAMOND);
    }),
    BONEGOLD("bonegold", 20, new int[]{3, 5, 7, 3}, 25, SoundEvents.ARMOR_EQUIP_GOLD, 2.0F, 0.1F, () -> {
        return Ingredient.of(Items.GOLD_INGOT);
    }),

    BONEIRON("boneiron", 25, new int[]{4, 7, 8, 4}, 9, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.1F, () -> {
        return Ingredient.of(Items.IRON_INGOT);
    });




    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;


    private DDDArmorMaterial(String p_i231593_3_, int p_i231593_4_, int[] p_i231593_5_, int p_i231593_6_, SoundEvent p_i231593_7_, float p_i231593_8_, float p_i231593_9_, Supplier<Ingredient> p_i231593_10_) {
        this.name = p_i231593_3_;
        this.durabilityMultiplier = p_i231593_4_;
        this.slotProtections = p_i231593_5_;
        this.enchantmentValue = p_i231593_6_;
        this.sound = p_i231593_7_;
        this.toughness = p_i231593_8_;
        this.knockbackResistance = p_i231593_9_;
        this.repairIngredient = new LazyLoadedValue<>(p_i231593_10_);
    }

    public int getDurabilityForSlot(EquipmentSlot p_200896_1_) {
        return HEALTH_PER_SLOT[p_200896_1_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot p_200902_1_) {
        return this.slotProtections[p_200902_1_.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return DeadlyDinos.MODID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}