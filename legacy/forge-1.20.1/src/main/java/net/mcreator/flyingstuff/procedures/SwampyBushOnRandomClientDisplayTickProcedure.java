package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;

public class SwampyBushOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle((SimpleParticleType) (FlyingStuffModParticleTypes.FIREFLY.get()), (x + Mth.nextDouble(RandomSource.create(), -4, 4)), (y + Mth.nextDouble(RandomSource.create(), -3, 5)), (z + Mth.nextDouble(RandomSource.create(), -4, 4)), 0,
				0, 0);
	}
}
