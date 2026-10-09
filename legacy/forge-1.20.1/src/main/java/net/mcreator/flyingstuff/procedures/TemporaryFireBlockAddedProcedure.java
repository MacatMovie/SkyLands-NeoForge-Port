package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;
import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.mcreator.flyingstuff.FlyingStuffMod;

public class TemporaryFireBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle((SimpleParticleType) (FlyingStuffModParticleTypes.TEMP_FIRE_PARTICLE.get()), x, (y + 1), z, 0, 0, 0);
		if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == FlyingStuffModBlocks.TEMPORARY_FIRE.get()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
		FlyingStuffMod.queueServerWork(60, () -> {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == FlyingStuffModBlocks.TEMPORARY_FIRE.get()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		});
	}
}
