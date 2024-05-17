package com.dragn0007.deadlydinos.client.menu;

import com.dragn0007.deadlydinos.entity.herbi.Amarga;
import com.dragn0007.deadlydinos.client.gui.DDDMenuTypes;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.IContainerFactory;

public class AmargaMenu extends AbstractContainerMenu {

    public Container container;
    public Amarga amarga;

    public AmargaMenu(int containerId, Inventory inventory, Container container, Amarga amarga) {
        super(DDDMenuTypes.AMARGA_MENU.get(), containerId);
        this.container = container;
        this.amarga = amarga;

        int amargaSlots = 0;
        this.addSlot(new Slot(this.container, amargaSlots++, 15, 26) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.is(Items.SADDLE) && !this.hasItem() && amarga.isSaddleable();
            }

            @Override
            public boolean isActive() {
                return amarga.isSaddleable();
            }
        });

        if(this.amarga.isChested()) {
            for(int y = 0; y < 2; y++) {
                for(int x = 0; x < 7; x++) {
                    this.addSlot(new Slot(this.container, amargaSlots++, 44 + x * 18, 18 + y * 18));
                }
            }

            for(int y = 0; y < 4; y++) {
                for(int x = 0; x < 9; x++) {
                    this.addSlot(new Slot(this.container, amargaSlots++, 8 + x * 18, 54 + y * 18));
                }
            }
        }

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

    @Override
    public boolean stillValid(Player player) {
        return this.amarga.isAlive() && this.amarga.distanceTo(player) <= 8f;
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

    public static IContainerFactory<AmargaMenu> create() {
        return (windowId, inv, data) -> {
            int containerSize = data.readInt();
            Amarga amarga1 = (Amarga) inv.player.level.getEntity(data.readInt());
            return new AmargaMenu(windowId, inv, new SimpleContainer(containerSize), amarga1);
        };
    }
}
