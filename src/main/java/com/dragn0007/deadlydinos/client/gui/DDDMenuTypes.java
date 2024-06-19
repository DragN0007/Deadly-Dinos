package com.dragn0007.deadlydinos.client.gui;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.client.menu.*;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDDMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, DeadlyDinos.MODID);

    public static final RegistryObject<MenuType<GrypoMenu>> GRYPO_MENU = MENU_TYPES.register("grypo_menu", () -> new MenuType<>(GrypoMenu.create()));
    public static final RegistryObject<MenuType<AmargaMenu>> AMARGA_MENU = MENU_TYPES.register("amarga_menu", () -> new MenuType<>(AmargaMenu.create()));
    public static final RegistryObject<MenuType<ParaMenu>> PARA_MENU = MENU_TYPES.register("para_menu", () -> new MenuType<>(ParaMenu.create()));
    public static final RegistryObject<MenuType<IchthyMenu>> ICHTHY_MENU = MENU_TYPES.register("ichthy_menu", () -> new MenuType<>(IchthyMenu.create()));
    public static final RegistryObject<MenuType<YutyMenu>> YUTY_MENU = MENU_TYPES.register("yuty_menu", () -> new MenuType<>(YutyMenu.create()));

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}
