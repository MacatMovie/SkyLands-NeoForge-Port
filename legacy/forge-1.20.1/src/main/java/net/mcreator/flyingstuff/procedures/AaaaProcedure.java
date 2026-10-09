package net.mcreator.flyingstuff.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.flyingstuff.network.FlyingStuffModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AaaaProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world.isClientSide()) {
			FlyingStuffModVariables.CloudActive = FlyingStuffModVariables.CloudActiveBolean.getValue();
		}
	}
}
