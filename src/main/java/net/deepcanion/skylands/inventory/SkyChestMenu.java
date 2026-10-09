package net.deepcanion.skylands.inventory;
import net.deepcanion.skylands.registry.ModMenus;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;

public final class SkyChestMenu extends AbstractContainerMenu {
    public final Container container;
    public final int size;
    public SkyChestMenu(int id, Inventory inventory, int size) { this(id, inventory, new SimpleContainer(size)); }
    public SkyChestMenu(int id, Inventory inventory, Container container) {
        super(container.getContainerSize() == 44 ? ModMenus.PROTO_CHEST.get() : ModMenus.SKY_CHEST.get(), id);
        this.container = container; size = container.getContainerSize();
        checkContainerSize(container, size); container.startOpen(inventory.player);
        if (size == 44) {
            for (int i = 0; i < 36; i++) addSlot(new Slot(container, i, 30 + (i % 9) * 18, 14 + (i / 9) * 18));
            for (int i = 36; i < 44; i++) addSlot(new Slot(container, i, i < 40 ? 12 : 192, 14 + ((i - 36) % 4) * 18));
        } else for (int i = 0; i < 27; i++) addSlot(new Slot(container, i, 15 + (i % 9) * 18, 17 + (i / 9) * 18));
        int x = size == 44 ? 30 : 15, y = size == 44 ? 103 : 88;
        for (int row = 0; row < 3; row++) for (int col = 0; col < 9; col++) addSlot(new Slot(inventory, col + (row + 1) * 9, x + col * 18, y + row * 18));
        for (int i = 0; i < 9; i++) addSlot(new Slot(inventory, i, x + i * 18, size == 44 ? 161 : 146));
    }
    @Override public boolean stillValid(Player player) { return container.stillValid(player); }
    @Override public void removed(Player player) { super.removed(player); container.stopOpen(player); }
    @Override public ItemStack quickMoveStack(Player player, int index) {
        if (index < 0 || index >= slots.size()) return ItemStack.EMPTY;
        Slot slot = slots.get(index);
        if (!slot.hasItem()) return ItemStack.EMPTY;
        ItemStack stack = slot.getItem(), copy = stack.copy();
        if (index < size) { if (!moveItemStackTo(stack, size, slots.size(), true)) return ItemStack.EMPTY; }
        else if (!moveItemStackTo(stack, 0, size, false)) return ItemStack.EMPTY;
        if (stack.isEmpty()) slot.setByPlayer(ItemStack.EMPTY); else slot.setChanged();
        slot.onTake(player, stack); return copy;
    }
}
