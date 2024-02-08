package com.dragn0007.deadlydinos.datagen;

import com.dragn0007.deadlydinos.block.DDDBlocks;
import com.dragn0007.deadlydinos.item.DDDItems;
import com.dragn0007.deadlydinos.util.DDDTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class DDDRecipeMaker extends RecipeProvider implements IConditionBuilder {
    public DDDRecipeMaker(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        ShapelessRecipeBuilder.shapeless(DDDItems.DINO_ROAST.get())
                .requires(DDDTags.Items.MEATS)
                .requires(DDDTags.Items.VEGETABLES)
                .requires(DDDTags.Items.VEGETABLES)
                .requires(DDDBlocks.CYPERUS.get())
                .requires(DDDItems.BONE_MARROW.get())
                .unlockedBy("has_meat", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.MEATS)
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(DDDItems.CHICKEN_NOODLE_SOUP.get())
                .requires(DDDTags.Items.RAW_CHICKEN)
                .requires(DDDItems.BROTH.get())
                .requires(DDDTags.Items.DOUGH)
                .unlockedBy("has_dough", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.DOUGH.get())
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(DDDItems.DINO_DUMPLING.get())
                .requires(DDDTags.Items.MEATS)
                .requires(DDDTags.Items.VEGETABLES)
                .requires(DDDTags.Items.DOUGH)
                .unlockedBy("has_dough", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.DOUGH.get())
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(DDDItems.SMOOTHIE.get())
                .requires(DDDItems.TIGER_NUTS.get())
                .requires(DDDItems.YEW_PLUM.get())
                .unlockedBy("has_plum", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.YEW_PLUM.get())
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(DDDItems.HEARTY_SALAD.get())
                .requires(DDDTags.Items.VEGETABLES)
                .requires(DDDTags.Items.VEGETABLES)
                .requires(DDDBlocks.COOKSONIA.get())
                .requires(DDDItems.TIGER_NUTS.get())
                .unlockedBy("has_veggies", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.VEGETABLES)
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(DDDItems.DOUGH.get())
                .requires(Items.WHEAT)
                .requires(Items.POTION)
                .unlockedBy("has_wheat", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.WHEAT)
                        .build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(DDDItems.BROTH.get())
                .requires(DDDItems.BONE_MARROW.get())
                .unlockedBy("has_bone_marrow", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.BONE_MARROW.get())
                        .build()))
                .save(pFinishedRecipeConsumer);

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDTags.Items.BONES), DDDItems.BONE_MARROW.get(), 0.35F, 200)
                .unlockedBy("has_bone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.BONES).build()))
                .save(pFinishedRecipeConsumer);

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDItems.DOUGH.get()), Items.BREAD, 0.35F, 200)
                .unlockedBy("has_dough", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.DOUGH).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(DDDBlocks.DINO_NUGGETS_BOX.get())
                .define('A', DDDTags.Items.RAW_CHICKEN)
                .define('B', Items.PAPER)
                .define('C', Items.BREAD)
                .pattern("BBB")
                .pattern("AAA")
                .pattern("CCC")
                .unlockedBy("has_chicken", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.RAW_CHICKEN).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(DDDItems.SODA.get())
                .define('A', Items.SUGAR)
                .define('B', Items.IRON_NUGGET)
                .define('C', Items.POTION)
                .pattern(" B ")
                .pattern(" AC")
                .pattern(" B ")
                .unlockedBy("has_sugar", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.SUGAR).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(DDDItems.MRE.get())
                .define('A', DDDTags.Items.MEATS)
                .define('C', DDDTags.Items.VEGETABLES)
                .define('B', DDDItems.CRACKER.get())
                .pattern(" B ")
                .pattern(" AC")
                .pattern(" B ")
                .unlockedBy("has_veggies", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.VEGETABLES).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(DDDItems.DINOSANDWICH.get())
                .define('A', DDDItems.COOKEDMEDIUMMEAT.get())
                .define('C', DDDTags.Items.VEGETABLES)
                .define('B', Items.BREAD)
                .pattern(" B ")
                .pattern(" AC")
                .pattern(" B ")
                .unlockedBy("has_veggies", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.VEGETABLES).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(DDDItems.CANNEDVEGGIES.get())
                .define('A', DDDTags.Items.VEGETABLES)
                .define('B', Items.IRON_NUGGET)
                .pattern(" B ")
                .pattern(" AA")
                .pattern(" B ")
                .unlockedBy("has_veggies", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.VEGETABLES).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(DDDItems.CANNEDSTEW.get())
                .define('A', DDDTags.Items.MEATS)
                .define('C', DDDTags.Items.VEGETABLES)
                .define('B', Items.IRON_NUGGET)
                .pattern(" B ")
                .pattern(" AC")
                .pattern(" B ")
                .unlockedBy("has_meat", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.MEATS).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(DDDItems.CANNEDMEAT.get())
                .define('A', DDDTags.Items.MEATS)
                .define('B', Items.IRON_NUGGET)
                .pattern(" B ")
                .pattern(" AA")
                .pattern(" B ")
                .unlockedBy("has_meat", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.MEATS).build()))
                .save(pFinishedRecipeConsumer);

    }
}