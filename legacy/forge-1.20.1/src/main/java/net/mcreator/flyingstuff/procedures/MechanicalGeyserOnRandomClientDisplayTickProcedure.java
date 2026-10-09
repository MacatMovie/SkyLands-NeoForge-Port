package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;

public class MechanicalGeyserOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle((SimpleParticleType) (FlyingStuffModParticleTypes.FAST.get()), (x + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 0.5), (z + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0, 1, 0);
	}
}
