package com.dragn0007.deadlydinos.datagen;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.block.DDDBlocksDataGen;
import com.dragn0007.deadlydinos.item.DDDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DDDItemModelProvider extends ItemModelProvider {
    public DDDItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, DeadlyDinos.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(DDDItems.GRYPOTROPHY.get());
        simpleItem(DDDItems.GRYPO_SPAWN_EGG.get());
        simpleItem(DDDItems.ALLOTROPHY.get());
        simpleItem(DDDItems.ALLO_SPAWN_EGG.get());
        simpleItem(DDDItems.DILOTROPHY.get());
        simpleItem(DDDItems.DILO_SPAWN_EGG.get());
        simpleItem(DDDItems.AMPELOTROPHY.get());
        simpleItem(DDDItems.AMPELO_SPAWN_EGG.get());
        simpleItem(DDDItems.YUTYTROPHY.get());
        simpleItem(DDDItems.YUTY_SPAWN_EGG.get());
        simpleItem(DDDItems.CRYOTROPHY.get());
        simpleItem(DDDItems.CRYO_SPAWN_EGG.get());
        simpleItem(DDDItems.PACHYRTROPHY.get());
        simpleItem(DDDItems.PACHYR_SPAWN_EGG.get());
        simpleItem(DDDItems.AUSTRALOTROPHY.get());
        simpleItem(DDDItems.AUSTRALO_SPAWN_EGG.get());
        simpleItem(DDDItems.ATROCITROPHY.get());
        simpleItem(DDDItems.ATROCI_SPAWN_EGG.get());
        simpleItem(DDDItems.EDMONTOTROPHY.get());
        simpleItem(DDDItems.EDMONTO_SPAWN_EGG.get());
        simpleItem(DDDItems.ICHTHYTROPHY.get());
        simpleItem(DDDItems.ICHTHY_SPAWN_EGG.get());
        simpleItem(DDDItems.IGUATROPHY.get());
        simpleItem(DDDItems.IGUA_SPAWN_EGG.get());
        simpleItem(DDDItems.TRIKETROPHY.get());
        simpleItem(DDDItems.TRIKE_SPAWN_EGG.get());
        simpleItem(DDDItems.MEGARAPTROPHY.get());
        simpleItem(DDDItems.MEGARAP_SPAWN_EGG.get());
        simpleItem(DDDItems.EOCARCHARTROPHY.get());
        simpleItem(DDDItems.EOCARCHAR_SPAWN_EGG.get());
        simpleItem(DDDItems.MOSATROPHY.get());
        simpleItem(DDDItems.MOSA_SPAWN_EGG.get());
        simpleItem(DDDItems.HELITROPHY.get());
        simpleItem(DDDItems.HELI_SPAWN_EGG.get());
        simpleItem(DDDItems.DUNKLEOTROPHY.get());
        simpleItem(DDDItems.DUNKLEO_SPAWN_EGG.get());
        simpleItem(DDDItems.ICHTHYOTROPHY.get());
        simpleItem(DDDItems.ICHTHYO_SPAWN_EGG.get());
        simpleItem(DDDItems.LEEDTROPHY.get());
        simpleItem(DDDItems.LEED_SPAWN_EGG.get());
        simpleItem(DDDItems.BARYTROPHY.get());
        simpleItem(DDDItems.BARY_SPAWN_EGG.get());

        simpleItem(DDDItems.GAR_SPAWN_EGG.get());

        simpleItem(DDDItems.IGUA_EGG.get());
        simpleItem(DDDItems.ICHTHY_EGG.get());
        simpleItem(DDDItems.GRYPO_EGG.get());
        simpleItem(DDDItems.AMPELO_EGG.get());
        simpleItem(DDDItems.AMARGA_EGG.get());
        simpleItem(DDDItems.CERATO_EGG.get());
        simpleItem(DDDItems.ALLO_EGG.get());
        simpleItem(DDDItems.YUTY_EGG.get());
        simpleItem(DDDItems.PARA_EGG.get());
        simpleItem(DDDItems.ANDAL_EGG.get());
        simpleItem(DDDItems.TRIKE_EGG.get());
        simpleItem(DDDItems.EOCARCHAR_EGG.get());
        simpleItem(DDDItems.BARY_EGG.get());
        simpleItem(DDDItems.ANKY_EGG.get());

        simpleItem(DDDItems.EOCARCHARIA_ARMOR.get());
        simpleItem(DDDItems.DINO_NUGGET_1.get());
        simpleItem(DDDItems.DINO_NUGGET_2.get());
        simpleItem(DDDItems.DINO_NUGGET_3.get());
        simpleItem(DDDItems.HEARTY_SALAD.get());
        simpleItem(DDDItems.SMOOTHIE.get());
        simpleItem(DDDItems.DINO_DUMPLING.get());
        simpleItem(DDDItems.DOUGH.get());
        simpleItem(DDDItems.BROTH.get());
        simpleItem(DDDItems.BONE_MARROW.get());
        simpleItem(DDDItems.CHICKEN_NOODLE_SOUP.get());
        simpleItem(DDDItems.DINO_ROAST.get());
        simpleItem(DDDItems.GAR.get());
        simpleItem(DDDItems.COOKED_GAR.get());
        simpleItem(DDDItems.SHARK.get());
        simpleItem(DDDItems.COOKED_SHARK.get());
        simpleItem(DDDItems.LARGE_FISH.get());
        simpleItem(DDDItems.COOKED_LARGE_FISH.get());

        simpleItem(DDDItems.BLUBBER.get());

        simpleItem(DDDItems.DUNKLEO_SKELETON.get());
        simpleItem(DDDItems.DUNKLEO_HELMET.get());
        simpleItem(DDDItems.DUNKLEO_CHESTPLATE.get());
        simpleItem(DDDItems.DUNKLEO_LEGGINGS.get());
        simpleItem(DDDItems.DUNKLEO_BOOTS.get());


        simpleSpriteBlockItem(DDDBlocksDataGen.ASTEROXYLON.get());
        simpleSpriteBlockItem(DDDBlocksDataGen.HORSETAIL.get());

        handheldItem(DDDItems.BOWIE_KNIFE.get());
        handheldItem(DDDItems.CROWBAR.get());
    }

    private ItemModelBuilder simpleSpriteBlockItem(Block block) {
        return withExistingParent(block.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DeadlyDinos.MODID,"block/" + block.getRegistryName().getPath()));
    }

    private ItemModelBuilder simpleItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DeadlyDinos.MODID,"item/" + item.getRegistryName().getPath()));
    }

    private ItemModelBuilder handheldItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(DeadlyDinos.MODID,"item/" + item.getRegistryName().getPath()));
    }
}