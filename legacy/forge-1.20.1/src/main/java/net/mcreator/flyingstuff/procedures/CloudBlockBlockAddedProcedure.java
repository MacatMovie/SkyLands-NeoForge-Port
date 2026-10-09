package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.flyingstuff.network.FlyingStuffModVariables;
import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;

public class CloudBlockBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isClientSide()) {
			if (FlyingStuffModVariables.CloudBlockActive.getValue()) {
				if (Math.random() < 0.3) {
					world.addParticle((SimpleParticleType) (FlyingStuffModParticleTypes.CLOUD.get()), (x + Mth.nextDouble(RandomSource.create(), -2, 2)), (y + Mth.nextDouble(RandomSource.create(), 0, 1.5)),
							(z + Mth.nextDouble(RandomSource.create(), -2, 2)), (Mth.nextDouble(RandomSource.create(), 0.1, 1)), 0, (Mth.nextDouble(RandomSource.create(), 0.1, 1)));
				}
			}
		}
	}
}
