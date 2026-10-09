package net.deepcanion.skylands.item;

import java.util.List;
import net.deepcanion.skylands.entity.FireWaveEntity;
import net.deepcanion.skylands.registry.ModEffects;
import net.deepcanion.skylands.registry.ModEntities;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;

public final class SkyInfusedSwordItem extends SwordItem {
    public enum Infusion { VERDANT, PEARLECENT, INKY, PALE }
    private final Infusion infusion;
    public SkyInfusedSwordItem(Infusion infusion) {
        super(tier(infusion), properties(infusion));
        this.infusion = infusion;
    }
    private static Tier tier(Infusion infusion) { return infusion == Infusion.PALE ? SkyToolTier.PALE : SkyToolTier.INFUSED; }
    private static Item.Properties properties(Infusion infusion) {
        Item.Properties properties = new Item.Properties().fireResistant()
                .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                .attributes(SwordItem.createAttributes(tier(infusion), 3, infusion == Infusion.PALE ? -2.4F : -2.35F));
        return infusion == Infusion.PALE ? properties.rarity(Rarity.RARE) : properties;
    }
    @Override public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity user) {
        if (!target.level().isClientSide()) {
            switch (infusion) {
                case VERDANT -> target.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 2));
                case PEARLECENT -> target.addEffect(new MobEffectInstance(ModEffects.FROZEN, 200, 3));
                case PALE -> target.igniteForSeconds(5);
                default -> { }
            }
        }
        return super.hurtEnemy(stack, target, user);
    }
    @Override public float getDestroySpeed(ItemStack stack, BlockState state) {
        return infusion == Infusion.PALE ? 1.65F : super.getDestroySpeed(stack, state);
    }
    @Override public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (infusion != Infusion.PEARLECENT || player == null) return super.useOn(context);
        if (player.getCooldowns().isOnCooldown(this)) return InteractionResult.FAIL;
        Level level = context.getLevel();
        if (!level.isClientSide()) {
            var lightning = EntityType.LIGHTNING_BOLT.create(level);
            if (lightning == null) return InteractionResult.FAIL;
            BlockPos pos = context.getClickedPos();
            lightning.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
            if (!level.addFreshEntity(lightning)) return InteractionResult.FAIL;
            player.getCooldowns().addCooldown(this, 100);
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (infusion != Infusion.INKY && infusion != Infusion.PALE) return super.use(level, player, hand);
        ItemStack stack = player.getItemInHand(hand);
        if (player.getCooldowns().isOnCooldown(this)) return InteractionResultHolder.fail(stack);
        if (!level.isClientSide()) {
            if (infusion == Infusion.INKY) {
                for (int i = 0; i < 3; i++) {
                    var vex = ModEntities.FRIENDLY_VEX.get().create(level);
                    if (vex != null) {
                        vex.moveTo(player.getX(), player.getY(), player.getZ(), level.getRandom().nextFloat() * 360F, 0);
                        level.addFreshEntity(vex);
                    }
                }
                player.getCooldowns().addCooldown(this, 260);
            } else {
                FireWaveEntity.shoot(level, player, level.getRandom());
                player.getCooldowns().addCooldown(this, 20);
            }
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lines, TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);
        lines.add(Component.translatable("item.flying_stuff.infusion." + infusion.name().toLowerCase(java.util.Locale.ROOT)));
    }
}
