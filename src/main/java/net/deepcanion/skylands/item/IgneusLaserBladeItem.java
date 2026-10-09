package net.deepcanion.skylands.item;
import net.deepcanion.skylands.entity.FireWaveEntity;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
public final class IgneusLaserBladeItem extends SwordItem {
    private static final Tier TIER = new Tier() {
        public int getUses() { return 400; }
        public float getSpeed() { return 1.5F; }
        public float getAttackDamageBonus() { return 2F; }
        public net.minecraft.tags.TagKey<net.minecraft.world.level.block.Block> getIncorrectBlocksForDrops() { return Tiers.IRON.getIncorrectBlocksForDrops(); }
        public int getEnchantmentValue() { return 0; }
        public net.minecraft.world.item.crafting.Ingredient getRepairIngredient() { return net.minecraft.world.item.crafting.Ingredient.EMPTY; }
    };
    public IgneusLaserBladeItem() {
        super(TIER, new Item.Properties().durability(400).fireResistant().rarity(Rarity.RARE).attributes(SwordItem.createAttributes(TIER, 4, -2.4F)));
    }
    @Override public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity user) {
        if (!target.level().isClientSide()) target.igniteForSeconds(5);
        return super.hurtEnemy(stack, target, user);
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            FireWaveEntity.shoot(level, player, level.getRandom());
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            player.getCooldowns().addCooldown(this, 20);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
