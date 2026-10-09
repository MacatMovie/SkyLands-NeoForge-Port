package net.deepcanion.skylands.item;
import java.util.List;
import net.deepcanion.skylands.entity.IcebombEntity;
import net.deepcanion.skylands.registry.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
public final class IceStaffItem extends Item {
    public IceStaffItem() { super(new Properties().durability(100).rarity(Rarity.RARE)); }
    private ItemStack ammo(Player player) {
        if (player.getOffhandItem().is(ModBlocks.CRISTALIZEDICE.get().asItem())) return player.getOffhandItem();
        for (ItemStack stack : player.getInventory().items)
            if (stack.is(ModBlocks.CRISTALIZEDICE.get().asItem())) return stack;
        return ItemStack.EMPTY;
    }
    @Override public int getUseDuration(ItemStack stack, LivingEntity user) { return 72000; }
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lines, TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);
        lines.add(Component.translatable("item.flying_stuff.ice_staff.tooltip"));
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!player.getAbilities().instabuild && ammo(player).isEmpty()) return InteractionResultHolder.fail(stack);
        player.startUsingItem(hand);
        if (!level.isClientSide()) player.getCooldowns().addCooldown(this, 50);
        return InteractionResultHolder.consume(stack);
    }
    @Override public void releaseUsing(ItemStack stack, Level level, LivingEntity user, int remaining) {
        if (level.isClientSide() || !(user instanceof Player player)) return;
        ItemStack ammo = ammo(player);
        if (!player.getAbilities().instabuild && ammo.isEmpty()) return;
        IcebombEntity.shoot(level, player, level.getRandom());
        if (!player.getAbilities().instabuild) ammo.shrink(1);
        stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
    }
}
