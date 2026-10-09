package net.deepcanion.skylands.procedures;
import net.deepcanion.skylands.registry.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.LevelAccessor;
public final class SmokeflowerProjProjectileHitsBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!(world instanceof ServerLevel server)) return;
        server.sendParticles(ModParticles.CLOUD_SMOKE.get(), x, y + 3, z, 25, 2, 1, 2, 0.2);
        server.sendParticles(ModParticles.CLOUD_SMOKE_1.get(), x, y + 3, z, 25, 2, 1, 2, 0.2);
        for (int height = 1; height <= 3; height++) {
            AreaEffectCloud cloud = new AreaEffectCloud(server, x, y + height, z);
            cloud.setRadius(4F);
            cloud.setDuration(300);
            cloud.setWaitTime(0);
            cloud.setParticle(ModParticles.EMPTY.get());
            cloud.addEffect(new MobEffectInstance(ModEffects.HIDDEN, 20, 1));
            server.addFreshEntity(cloud);
        }
    }
}
