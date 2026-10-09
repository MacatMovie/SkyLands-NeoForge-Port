package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;

public class FieryLeavesClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.1) {
			world.addParticle((SimpleParticleType) (FlyingStuffModParticleTypes.FIRE_LEAF.get()), x, (y - 0.5), z, 0.2, (-0.8), 0.4);
		}
	}
}
