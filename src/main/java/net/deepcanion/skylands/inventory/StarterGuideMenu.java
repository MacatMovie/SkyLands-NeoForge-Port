package net.deepcanion.skylands.inventory;

import net.deepcanion.skylands.registry.ModMenus;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

/** No slots or transferable stacks: page navigation is purely client-side. */
public final class StarterGuideMenu extends AbstractContainerMenu {
    public StarterGuideMenu(int id) { super(ModMenus.STARTER_GUIDE.get(), id); }
    @Override public ItemStack quickMoveStack(Player player, int slot) { return ItemStack.EMPTY; }
    @Override public boolean stillValid(Player player) { return true; }
}
