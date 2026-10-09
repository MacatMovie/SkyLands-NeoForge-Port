package net.deepcanion.skylands.procedures;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
public final class FriendlyVexOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null && !entity.level().isClientSide() && entity.level().getRandom().nextFloat() < 0.2F) entity.hurt(entity.damageSources().generic(), 1);
    }
}
