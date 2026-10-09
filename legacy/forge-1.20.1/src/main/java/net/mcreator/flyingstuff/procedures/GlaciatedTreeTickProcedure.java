package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GlaciatedTreeTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double treetipe = 0;
		if (Mth.nextInt(RandomSource.create(), 1, 6) <= 1) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("flying_stuff", "ice_tree"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x - 4, y, z - 5), BlockPos.containing(x - 4, y, z - 5), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
	}
}
