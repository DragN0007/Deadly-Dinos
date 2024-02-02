package com.dragn0007.deadlydinos.item.util;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum DDDItemTier implements Tier {
    SMALLBONE(1, 100, 5F, 3.0F, 5, () -> {
        return Ingredient.of(Items.BONE_MEAL);
    }),
    MEDIUMBONE(2, 350, 6.5F, 5.0F, 14, () -> {
        return Ingredient.of(Items.BONE_MEAL);
    }),
    LARGEBONE(3, 1700, 8.5F, 6.0F, 10, () -> {
        return Ingredient.of(Items.BONE_MEAL);
    });



    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    DDDItemTier(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}
