package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.entity.Entity;

public class MoltenMetalMobplayerCollidesBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setSecondsOnFire(15);
	}
}
