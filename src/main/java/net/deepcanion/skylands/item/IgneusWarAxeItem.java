package net.deepcanion.skylands.item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
public final class IgneusWarAxeItem extends SwordItem {
    public IgneusWarAxeItem() {
        super(SkyToolTier.WAR_AXE, new Item.Properties()
                .attributes(SwordItem.createAttributes(SkyToolTier.WAR_AXE, 3, -3.2F)));
    }
    @Override public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity user) {
        if (!target.level().isClientSide()) {
            target.igniteForSeconds(5);
            var pos = target.blockPosition();
            var fire = Blocks.FIRE.defaultBlockState();
            if (target.level().isEmptyBlock(pos) && fire.canSurvive(target.level(), pos))
                target.level().setBlock(pos, fire, 3);
        }
        return super.hurtEnemy(stack, target, user);
    }
}
