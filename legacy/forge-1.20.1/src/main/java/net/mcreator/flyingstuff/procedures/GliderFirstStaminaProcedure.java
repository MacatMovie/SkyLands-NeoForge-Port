package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.flyingstuff.network.FlyingStuffModVariables;

public class GliderFirstStaminaProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).gliding_stamina >= 1;
	}
}
