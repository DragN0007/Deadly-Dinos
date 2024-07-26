package com.dragn0007.deadlydinos.client.menu;

import com.dragn0007.deadlydinos.client.gui.DDDMenuTypes;
import com.dragn0007.deadlydinos.entity.Armorable;
import com.dragn0007.deadlydinos.entity.carni.Eocarchar;
import com.dragn0007.deadlydinos.entity.carni.Yuty;
import com.dragn0007.deadlydinos.item.DDDItems;
import com.dragn0007.deadlydinos.util.DDDTags;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.network.IContainerFactory;

public class EocarcharMenu extends AbstractContainerMenu {

    public Container container;
    public Eocarchar eochar;

    public EocarcharMenu(int containerId, Inventory inventory, Container container, Eocarchar eochar) {
        super(DDDMenuTypes.EOCARCHAR_MENU.get(), containerId);
        this.container = container;
        this.eochar = eochar;

        int eocharSlots = 0;

        this.addSlot(new SaddleSlot(this.container, eocharSlots++, 8, 108) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.is(Items.SADDLE) && !this.hasItem() && eochar.isSaddleable();
            }
            @Override
            public boolean isActive() {
                return eochar.isSaddleable();
            }
        });

        this.addSlot(new ArmorSlot(this.container, eocharSlots++, 26, 108) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.is(DDDItems.EOCARCHARIA_ARMOR.get()) && !this.hasItem() && eochar.isArmorable();
            }
            @Override
            public boolean isActive() {
                return eochar.isArmorable();
            }
        });

        if(this.eochar.isChested()) {
            for(int y = 0; y < 4; y++) {
                for(int x = 0; x < 9; x++) {
                    this.addSlot(new Slot(this.container, eocharSlots++, 8 + x * 18, 18 + y * 18));
                }
            }
        }

        this.addSlot(new BedrollSlot(this.container, eocharSlots++, 44, 108) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.is(DDDTags.Items.BEDROLL_BEDS);
            }
        });

        int playerSlots = 0;
        for(int x = 0; x < 9; x++) {
            this.addSlot(new Slot(inventory, playerSlots++, 8 + x * 18, 198));
        }

        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 9; x++) {
                this.addSlot(new Slot(inventory, playerSlots++, 8 + x * 18, 140 + y * 18));
            }
        }
    }

    static class ArmorSlot extends Slot {
        public ArmorSlot(Container container, int i, int j, int k) {
            super(container, i, j, k);
        }
        public boolean mayPlace(ItemStack placeItem) {
            return mayPlaceItem(placeItem);
        }
        public static boolean mayPlaceItem(ItemStack p_39113_) {
            return p_39113_.is(DDDItems.EOCARCHARIA_ARMOR.get());
        }
        public int getMaxStackSize() {
            return 1;
        }
    }

    static class SaddleSlot extends Slot {
        public SaddleSlot(Container p_39105_, int p_39106_, int p_39107_, int p_39108_) {
            super(p_39105_, p_39106_, p_39107_, p_39108_);
        }
        public boolean mayPlace(ItemStack p_39111_) {
            return mayPlaceItem(p_39111_);
        }
        public static boolean mayPlaceItem(ItemStack p_39113_) {
            return p_39113_.is(Items.SADDLE);
        }
        public int getMaxStackSize() {
            return 1;
        }
    }

    static class BedrollSlot extends Slot {
        public BedrollSlot(Container p_39105_, int p_39106_, int p_39107_, int p_39108_) {
            super(p_39105_, p_39106_, p_39107_, p_39108_);
        }
        public boolean mayPlace(ItemStack p_39111_) {
            return mayPlaceItem(p_39111_);
        }
        public static boolean mayPlaceItem(ItemStack p_39113_) {
            return p_39113_.is(DDDTags.Items.BEDROLL_BEDS);
        }
        public int getMaxStackSize() {
            return 1;
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return this.eochar.isAlive() && this.eochar.distanceTo(player) <= 8f;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotId) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotId);
        if(slot.hasItem()) {
            itemStack = slot.getItem().copy();
            int containerSize = this.container.getContainerSize();

            if(slotId < containerSize) {
                if(!this.moveItemStackTo(itemStack, containerSize, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if(!this.moveItemStackTo(itemStack, 0, containerSize, false)) {
                return ItemStack.EMPTY;
            }

            if(itemStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemStack;
    }

    public static IContainerFactory<EocarcharMenu> create() {
        return (windowId, inv, data) -> {
            int containerSize = data.readInt();
            Eocarchar eochar1 = (Eocarchar) inv.player.level.getEntity(data.readInt());
            return new EocarcharMenu(windowId, inv, new SimpleContainer(containerSize), eochar1);
        };
    }
}
