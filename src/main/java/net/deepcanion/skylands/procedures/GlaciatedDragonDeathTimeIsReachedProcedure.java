package net.deepcanion.skylands.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.deepcanion.skylands.registry.ModParticles;

public class GlaciatedDragonDeathTimeIsReachedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ModParticles.CLOUD.get()), x, y, z, 15, 2, 2, 2, 0.1);
	}
}
