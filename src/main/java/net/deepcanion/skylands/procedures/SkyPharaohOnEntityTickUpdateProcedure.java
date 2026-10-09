package net.deepcanion.skylands.procedures;
import net.deepcanion.skylands.entity.SkyPharaohEntity;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
public final class SkyPharaohOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (!(world instanceof ServerLevel server) || !(entity instanceof SkyPharaohEntity pharaoh) || !(pharaoh.getTarget() instanceof Player)) return;
        if (pharaoh.getRandom().nextFloat() >= 0.008F) return;
        pharaoh.setAnimation("animation.model.evoke");
        var husk = EntityType.HUSK.create(server);
        if (husk == null) return;
        husk.moveTo(x, y, z, pharaoh.getYRot(), 0);
        husk.finalizeSpawn(server, server.getCurrentDifficultyAt(husk.blockPosition()), MobSpawnType.MOB_SUMMONED, null);
        husk.setTarget(pharaoh.getTarget());
        server.addFreshEntity(husk);
    }
}
