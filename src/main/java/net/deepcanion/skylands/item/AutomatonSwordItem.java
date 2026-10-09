package net.deepcanion.skylands.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

/** Original durability, repair material, damage, attack speed and Poison II on player hits. */
public final class AutomatonSwordItem extends SwordItem {
    private static final Tier TIER = new Tier() {
        public int getUses() { return 200; }
        public float getSpeed() { return 1F; }
        public float getAttackDamageBonus() { return 2F; }
        public TagKey<Block> getIncorrectBlocksForDrops() { return BlockTags.INCORRECT_FOR_STONE_TOOL; }
        public int getEnchantmentValue() { return 10; }
        public Ingredient getRepairIngredient() { return Ingredient.of(Items.GOLD_INGOT); }
    };

    public AutomatonSwordItem() {
        super(TIER, new Item.Properties().attributes(SwordItem.createAttributes(TIER, 3, -2.5F)));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);
        if (!target.level().isClientSide()) target.addEffect(new MobEffectInstance(MobEffects.POISON, 120, 1));
        return result;
    }
}
