package net.deepcanion.skylands.item;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.registry.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
public final class PharaohStaffItem extends Item {
    public PharaohStaffItem() {
        super(new Properties().durability(350).rarity(Rarity.RARE).attributes(ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(SkyLands.id("pharaoh_staff_damage"), 1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(SkyLands.id("pharaoh_staff_speed"), -2.4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build()));
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level instanceof ServerLevel server) {
            for (int i = 0; i < 3; i++) {
                Entity vex = ModEntities.FRIENDLY_VEX.get().spawn(server, player.blockPosition(), MobSpawnType.MOB_SUMMONED);
                if (vex != null) vex.setYRot(level.getRandom().nextFloat() * 360F);
            }
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            player.getCooldowns().addCooldown(this, 260);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
    @Override public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity user) {
        if (!user.level().isClientSide()) stack.hurtAndBreak(1, user, EquipmentSlot.MAINHAND);
        return true;
    }
}
