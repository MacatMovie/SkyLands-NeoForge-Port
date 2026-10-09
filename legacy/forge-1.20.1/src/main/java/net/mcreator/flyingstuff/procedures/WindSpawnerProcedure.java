package net.mcreator.flyingstuff.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WindSpawnerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (Level.OVERWORLD == (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) && y > 195) {
			if (Math.random() < 0.1) {
				world.addParticle((SimpleParticleType) (FlyingStuffModParticleTypes.WIND.get()), (x + Mth.nextDouble(RandomSource.create(), -16, 16)), (y + Mth.nextDouble(RandomSource.create(), -16, 16)),
						(z + Mth.nextDouble(RandomSource.create(), -16, 16)), 0, 0, 0);
			}
		}
	}
}
