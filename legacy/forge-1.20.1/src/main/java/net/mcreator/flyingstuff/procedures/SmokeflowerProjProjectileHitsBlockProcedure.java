package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;

public class SmokeflowerProjProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (FlyingStuffModParticleTypes.CLOUD_SMOKE.get()), x, (y + 3), z, 25, 2, 1, 2, 0.2);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (FlyingStuffModParticleTypes.CLOUD_SMOKE_1.get()), x, (y + 3), z, 25, 2, 1, 2, 0.2);
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 2), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"summon area_effect_cloud ~ ~ ~ {Particle:\"flying_stuff:empty\",Radius:4f,Duration:300,Color:16777215,Effects:[{Id:\"flying_stuff:hidden\",Amplifier:1b,Duration:20}]}");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"summon area_effect_cloud ~ ~ ~ {Particle:\"flying_stuff:empty\",Radius:4f,Duration:300,Color:16777215,Effects:[{Id:\"flying_stuff:hidden\",Amplifier:1b,Duration:20}]}");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 3), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"summon area_effect_cloud ~ ~ ~ {Particle:\"flying_stuff:empty\",Radius:4f,Duration:300,Color:16777215,Effects:[{Id:\"flying_stuff:hidden\",Amplifier:1b,Duration:20}]}");
	}
}
