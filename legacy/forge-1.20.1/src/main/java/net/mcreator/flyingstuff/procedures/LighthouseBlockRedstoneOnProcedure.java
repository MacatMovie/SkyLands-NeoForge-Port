package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class LighthouseBlockRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double nex = 0;
		double ney = 0;
		double nez = 0;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.WAX_OFF, x, y, z, 25, 1, 1, 1, 0.25);
		for (int index0 = 0; index0 < 750; index0++) {
			nex = x + Mth.nextInt(RandomSource.create(), -82, 82);
			ney = y + Mth.nextInt(RandomSource.create(), -72, 20);
			nez = z + Mth.nextInt(RandomSource.create(), -82, 82);
			if ((world.getBlockState(BlockPos.containing(nex, ney, nez))).getBlock() == Blocks.AIR) {
				world.setBlock(BlockPos.containing(nex, ney, nez), Blocks.LIGHT.defaultBlockState(), 3);
			}
		}
	}
}
