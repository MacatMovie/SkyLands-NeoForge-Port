package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;

public class GlaciatedDragonDeathTimeIsReachedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (FlyingStuffModParticleTypes.CLOUD.get()), x, y, z, 15, 2, 2, 2, 0.1);
	}
}
