package net.deepcanion.skylands.item;

import net.deepcanion.skylands.inventory.StarterGuideMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/** Opens a read-only guide through the ordinary server-owned menu path. */
public final class StarterGuideItem extends Item {
    public StarterGuideItem() { super(new Properties().stacksTo(1)); }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.openMenu(new SimpleMenuProvider((id, inventory, reader) -> new StarterGuideMenu(id),
                    Component.translatable("item.flying_stuff.sky_lands_starter_guide")));
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }
}
