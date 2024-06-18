package com.dragn0007.deadlydinos.client.menu;

import com.dragn0007.deadlydinos.client.gui.DDDMenuTypes;
import com.dragn0007.deadlydinos.entity.carni.Ichthy;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.IContainerFactory;

public class IchthyMenu extends AbstractContainerMenu {

    public Container container;
    public Ichthy para;

    public IchthyMenu(int containerId, Inventory inventory, Container container, Ichthy para) {
        super(DDDMenuTypes.ICHTHY_MENU.get(), containerId);
        this.container = container;
        this.para = para;

        int paraSlots = 0;

        if(this.para.isChested()) {
            for(int y = 0; y < 4; y++) {
                for(int x = 0; x < 9; x++) {
                    this.addSlot(new Slot(this.container, paraSlots++, 8 + x * 18, 18 + y * 18));
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
        return this.para.isAlive() && this.para.distanceTo(player) <= 8f;
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

    public static IContainerFactory<IchthyMenu> create() {
        return (windowId, inv, data) -> {
            int containerSize = data.readInt();
            Ichthy para1 = (Ichthy) inv.player.level.getEntity(data.readInt());
            return new IchthyMenu(windowId, inv, new SimpleContainer(containerSize), para1);
        };
    }
}
