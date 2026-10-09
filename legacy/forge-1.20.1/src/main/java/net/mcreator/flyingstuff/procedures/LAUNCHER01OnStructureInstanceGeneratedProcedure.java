package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;

public class LAUNCHER01OnStructureInstanceGeneratedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y + 180, z), FlyingStuffModBlocks.GEN_LAUNCH_0.get().defaultBlockState(), 3);
		world.scheduleTick(BlockPos.containing(x, y + 180, z), world.getBlockState(BlockPos.containing(x, y + 180, z)).getBlock(), 20);
	}
}
