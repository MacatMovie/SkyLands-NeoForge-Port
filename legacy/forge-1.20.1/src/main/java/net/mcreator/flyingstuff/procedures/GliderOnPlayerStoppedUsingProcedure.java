package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.entity.Entity;

public class GliderOnPlayerStoppedUsingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(false);
	}
}
