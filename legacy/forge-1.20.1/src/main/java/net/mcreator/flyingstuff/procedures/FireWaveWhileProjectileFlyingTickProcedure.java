package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;
import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;

public class FireWaveWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle((SimpleParticleType) (FlyingStuffModParticleTypes.TEMP_FIRE_PARTICLE.get()), x, (y + 1), z, 0, 0, 0);
		if ((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing(x, y - 3, z)).canOcclude()) {
			world.setBlock(BlockPos.containing(x, y, z), FlyingStuffModBlocks.TEMPORARY_FIRE.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing(x, y - 2, z)).canOcclude()) {
			world.setBlock(BlockPos.containing(x, y - 1, z), FlyingStuffModBlocks.TEMPORARY_FIRE.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
			world.setBlock(BlockPos.containing(x, y - 2, z), FlyingStuffModBlocks.TEMPORARY_FIRE.get().defaultBlockState(), 3);
		}
	}
}
