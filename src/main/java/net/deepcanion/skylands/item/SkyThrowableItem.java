package net.deepcanion.skylands.item;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import java.util.function.BiConsumer;
public final class SkyThrowableItem extends Item {
    private final BiConsumer<Level, LivingEntity> shoot;
    private final int cooldown;
    public SkyThrowableItem(Properties properties, int cooldown, BiConsumer<Level, LivingEntity> shoot) { super(properties); this.cooldown = cooldown; this.shoot = shoot; }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            shoot.accept(level, player);
            player.getCooldowns().addCooldown(this, cooldown);
            if (!player.getAbilities().instabuild) stack.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
