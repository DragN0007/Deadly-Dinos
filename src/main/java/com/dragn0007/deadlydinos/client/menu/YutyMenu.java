package com.dragn0007.deadlydinos.client.menu;

import com.dragn0007.deadlydinos.client.gui.DDDMenuTypes;
import com.dragn0007.deadlydinos.entity.carni.Yuty;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.IContainerFactory;

public class YutyMenu extends AbstractContainerMenu {

    public Container container;
    public Yuty yuty;

    public YutyMenu(int containerId, Inventory inventory, Container container, Yuty yuty) {
        super(DDDMenuTypes.YUTY_MENU.get(), containerId);
        this.container = container;
        this.yuty = yuty;

        int yutySlots = 0;
        this.addSlot(new Slot(this.container, yutySlots++, 8, 106) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.is(Items.SADDLE) && !this.hasItem() && yuty.isSaddleable();
            }

            @Override
            public boolean isActive() {
                return yuty.isSaddleable();
            }
        });

        this.addSlot(new Slot(this.container, yutySlots++, 26, 106) {
        });

        if(this.yuty.isChested()) {
            for(int y = 0; y < 4; y++) {
                for(int x = 0; x < 9; x++) {
                    this.addSlot(new Slot(this.container, yutySlots++, 8 + x * 18, 18 + y * 18));
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
        return this.yuty.isAlive() && this.yuty.distanceTo(player) <= 8f;
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

    public static IContainerFactory<YutyMenu> create() {
        return (windowId, inv, data) -> {
            int containerSize = data.readInt();
            Yuty yuty1 = (Yuty) inv.player.level.getEntity(data.readInt());
            return new YutyMenu(windowId, inv, new SimpleContainer(containerSize), yuty1);
        };
    }
}
