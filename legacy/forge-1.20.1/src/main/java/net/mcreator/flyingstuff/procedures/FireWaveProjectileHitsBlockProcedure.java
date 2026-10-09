package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;

public class FireWaveProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), FlyingStuffModBlocks.TEMPORARY_FIRE.get().defaultBlockState(), 3);
	}
}
