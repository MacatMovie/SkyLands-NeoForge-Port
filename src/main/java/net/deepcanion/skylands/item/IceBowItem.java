package net.deepcanion.skylands.item;
import net.deepcanion.skylands.entity.IceArrowEntity;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
public final class IceBowItem extends Item {
    public IceBowItem() { super(new Item.Properties().durability(128).rarity(Rarity.UNCOMMON)); }
    private ItemStack ammo(Player player) {
        for (ItemStack stack : player.getInventory().items) if (stack.is(Items.ARROW)) return stack;
        if (player.getOffhandItem().is(Items.ARROW)) return player.getOffhandItem();
        return ItemStack.EMPTY;
    }
    @Override public UseAnim getUseAnimation(ItemStack stack) { return UseAnim.BOW; }
    @Override public int getUseDuration(ItemStack stack, LivingEntity user) { return 72; }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!player.getAbilities().instabuild && ammo(player).isEmpty()) return InteractionResultHolder.fail(stack);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }
    @Override public void releaseUsing(ItemStack stack, Level level, LivingEntity user, int remaining) {
        if (level.isClientSide() || !(user instanceof Player player)) return;
        ItemStack ammo = ammo(player);
        if (!player.getAbilities().instabuild && ammo.isEmpty()) return;
        IceArrowEntity.shoot(level, user, level.getRandom());
        if (!player.getAbilities().instabuild) ammo.shrink(1);
        stack.hurtAndBreak(1, user, LivingEntity.getSlotForHand(user.getUsedItemHand()));
    }
}
