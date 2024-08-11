package com.dragn0007.deadlydinos.datagen;

import com.dragn0007.deadlydinos.block.DDDBlocks;
import com.dragn0007.deadlydinos.item.DDDItems;
import com.dragn0007.deadlydinos.util.DDDTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class DDDRecipeMaker extends RecipeProvider implements IConditionBuilder {
    public DDDRecipeMaker(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        ShapedRecipeBuilder.shaped(DDDItems.EOCARCHARIA_ARMOR.get())
                .define('A', Items.LEATHER)
                .define('B', Items.IRON_BLOCK)
                .pattern("BBB")
                .pattern("BA ")
                .unlockedBy("has_iron", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_BLOCK).build()))
                .save(pFinishedRecipeConsumer);


        ShapelessRecipeBuilder.shapeless(DDDItems.DUNKLEO_HELMET.get())
                .requires(DDDItems.DUNKLEO_SKELETON.get())
                .requires(Items.IRON_HELMET)
                .unlockedBy("has_dunkleo_skeleton", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.DUNKLEO_SKELETON.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(DDDItems.DUNKLEO_CHESTPLATE.get())
                .requires(DDDItems.DUNKLEO_SKELETON.get())
                .requires(Items.IRON_CHESTPLATE)
                .unlockedBy("has_dunkleo_skeleton", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.DUNKLEO_SKELETON.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(DDDItems.DUNKLEO_LEGGINGS.get())
                .requires(DDDItems.DUNKLEO_SKELETON.get())
                .requires(Items.IRON_LEGGINGS)
                .unlockedBy("has_dunkleo_skeleton", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.DUNKLEO_SKELETON.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(DDDItems.DUNKLEO_BOOTS.get())
                .requires(DDDItems.DUNKLEO_SKELETON.get())
                .requires(Items.IRON_BOOTS)
                .unlockedBy("has_dunkleo_skeleton", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.DUNKLEO_SKELETON.get()).build()))
                .save(pFinishedRecipeConsumer);


        ShapedRecipeBuilder.shaped(Items.CANDLE)
                .define('A', Items.STRING)
                .define('B', DDDItems.BLUBBER.get())
                .pattern("A")
                .pattern("B")
                .unlockedBy("has_blubber", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDItems.BLUBBER.get()).build()))
                .save(pFinishedRecipeConsumer);



        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDDItems.HYNERIA.get()), DDDItems.COOKED_HYNERIA.get(), 0.35F, 200)
                .unlockedBy("has_furnace", has(Blocks.FURNACE)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "hyneria_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDItems.HYNERIA.get()), DDDItems.COOKED_HYNERIA.get(), 0.35F, 100)
                .unlockedBy("has_smoker", has(Blocks.SMOKER)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "hyneria_smoking"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(DDDItems.HYNERIA.get()), DDDItems.COOKED_HYNERIA.get(), 0.35F, 600)
                .unlockedBy("has_campfire", has(Blocks.CAMPFIRE)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "hyneria_campfire_cooking"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDDItems.ARGANODUS.get()), DDDItems.COOKED_ARGANODUS.get(), 0.35F, 200)
                .unlockedBy("has_furnace", has(Blocks.FURNACE)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "argan_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDItems.ARGANODUS.get()), DDDItems.COOKED_ARGANODUS.get(), 0.35F, 100)
                .unlockedBy("has_smoker", has(Blocks.SMOKER)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "argan_smoking"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(DDDItems.ARGANODUS.get()), DDDItems.COOKED_ARGANODUS.get(), 0.35F, 600)
                .unlockedBy("has_campfire", has(Blocks.CAMPFIRE)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "argan_campfire_cooking"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDDItems.LARGE_FISH.get()), DDDItems.COOKED_LARGE_FISH.get(), 0.35F, 200)
                .unlockedBy("has_furnace", has(Blocks.FURNACE)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "large_fish_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDItems.LARGE_FISH.get()), DDDItems.COOKED_LARGE_FISH.get(), 0.35F, 100)
                .unlockedBy("has_smoker", has(Blocks.SMOKER)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "large_fish_smoking"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(DDDItems.LARGE_FISH.get()), DDDItems.COOKED_LARGE_FISH.get(), 0.35F, 600)
                .unlockedBy("has_campfire", has(Blocks.CAMPFIRE)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "large_fish_campfire_cooking"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDDItems.SHARK.get()), DDDItems.COOKED_SHARK.get(), 0.35F, 200)
                .unlockedBy("has_furnace", has(Blocks.FURNACE)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "shark_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDItems.SHARK.get()), DDDItems.COOKED_SHARK.get(), 0.35F, 100)
                .unlockedBy("has_smoker", has(Blocks.SMOKER)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "shark_smoking"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(DDDItems.SHARK.get()), DDDItems.COOKED_SHARK.get(), 0.35F, 600)
                .unlockedBy("has_campfire", has(Blocks.CAMPFIRE)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "shark_campfire_cooking"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DDDItems.GAR.get()), DDDItems.COOKED_GAR.get(), 0.35F, 200)
                .unlockedBy("has_furnace", has(Blocks.FURNACE)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "gar_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DDDItems.GAR.get()), DDDItems.COOKED_GAR.get(), 0.35F, 100)
                .unlockedBy("has_smoker", has(Blocks.SMOKER)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "gar_smoking"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(DDDItems.GAR.get()), DDDItems.COOKED_GAR.get(), 0.35F, 600)
                .unlockedBy("has_campfire", has(Blocks.CAMPFIRE)).save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "gar_campfire_cooking"));



        ShapelessRecipeBuilder.shapeless(Items.BONE_MEAL, 4)
                .requires(DDDTags.Items.LARGE_BONES)
                .unlockedBy("has_bone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.LARGE_BONES)
                        .build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "large_bonemeal"));

        ShapelessRecipeBuilder.shapeless(Items.BONE_MEAL, 3)
                .requires(DDDTags.Items.MEDIUM_BONES)
                .unlockedBy("has_bone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.MEDIUM_BONES)
                        .build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "medium_bonemeal"));

        ShapelessRecipeBuilder.shapeless(Items.BONE_MEAL, 2)
                .requires(DDDTags.Items.SMALL_BONES)
                .unlockedBy("has_bone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(DDDTags.Items.SMALL_BONES)
                        .build()))
                .save(pFinishedRecipeConsumer, new ResourceLocation("deadlydinos", "small_bonemeal"));


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