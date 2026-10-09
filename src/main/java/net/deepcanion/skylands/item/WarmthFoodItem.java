package net.deepcanion.skylands.item;

import net.deepcanion.skylands.registry.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public final class WarmthFoodItem extends Item {
    private final boolean drink;
    public WarmthFoodItem(boolean drink) {
        super(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(drink ? 0 : 1).saturationModifier(drink ? 0F : 0.1F).alwaysEdible().build()));
        this.drink = drink;
    }
    @Override public UseAnim getUseAnimation(ItemStack stack) { return drink ? UseAnim.DRINK : UseAnim.EAT; }
    @Override public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);
        if (!level.isClientSide()) entity.addEffect(new MobEffectInstance(ModEffects.WARMTH, drink ? 1000 : 40, 1));
        if (!drink || (entity instanceof Player player && player.getAbilities().instabuild)) return result;
        ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);
        if (result.isEmpty()) return bottle;
        if (!level.isClientSide() && entity instanceof Player player && !player.getInventory().add(bottle)) player.drop(bottle, false);
        return result;
    }
}
