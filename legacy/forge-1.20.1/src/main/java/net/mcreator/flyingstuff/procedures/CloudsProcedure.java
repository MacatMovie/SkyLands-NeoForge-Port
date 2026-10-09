package net.mcreator.flyingstuff.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.flyingstuff.network.FlyingStuffModVariables;
import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;


import javax.annotation.Nullable;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.data.worldgen.DimensionTypes;


@Mod.EventBusSubscriber()
public class CloudsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {

			SimplexNoise noise = new SimplexNoise(event.player.level().getRandom());
			
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), noise);
		}
	}
	
	public static void execute(LevelAccessor world, double x, double y, double z, SimplexNoise noise) {
		execute(null, world, x, y, z, noise);
	}
	
	private static boolean is_in_biome(double x_new, double z_new,double y, LevelAccessor world) {
		return (world.getBiome(BlockPos.containing(x_new, y, z_new)).is(new ResourceLocation("flying_stuff:flying_islands")) ||
		world.getBiome(BlockPos.containing(x_new, y, z_new)).is(new ResourceLocation("flying_stuff:glaciated_floating_islands"))|| 
		world.getBiome(BlockPos.containing(x_new, y, z_new)).is(new ResourceLocation("flying_stuff:lavic_floating_islands")) || 
		world.getBiome(BlockPos.containing(x_new, y, z_new)).is(new ResourceLocation("flying_stuff:arid_floating_islands")));
	}
	
	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, SimplexNoise noise) {
		double x_new = 0;
		double z_new = 0;

		RandomSource rand = world.getRandom();
		
		if (world.isClientSide()) {

		if (FlyingStuffModVariables.CloudActive) {
			x_new = x + Mth.nextDouble(rand, -FlyingStuffModVariables.CloudDist.getValue() * 0.75f, FlyingStuffModVariables.CloudDist.getValue() * 0.75f);
			z_new = z + Mth.nextDouble(rand, -FlyingStuffModVariables.CloudDist.getValue() * 0.75f, FlyingStuffModVariables.CloudDist.getValue() * 0.75f);
			
			if (is_in_biome(x_new, z_new,y, world)) {

				for (int i = 0; i < 19; i++) {
						double x_newest = x_new + Mth.nextDouble(rand, -35.0, 35.0);
						double z_newest = z_new + Mth.nextDouble(rand, -22.0, 22.0);
						world.addParticle((SimpleParticleType) (FlyingStuffModParticleTypes.CLOUD_BARRIER_3.get()), x_newest, (320 + noise.getValue(x_newest / 12000, z_newest/ 16000)* 340), z_newest, 0.1, 0, 0.06);
					}
			}
			if (FlyingStuffModVariables.CloudActiveOutside.getValue()) {
				if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("minecraft:overworld"))) {

					if (Mth.nextFloat(rand, 0.0f, 1.0f) < 0.65) {
						return;
					}
					
					x_new = x + Mth.nextDouble(rand, -FlyingStuffModVariables.CloudDist.getValue(), FlyingStuffModVariables.CloudDist.getValue());
					z_new = z + Mth.nextDouble(rand, -FlyingStuffModVariables.CloudDist.getValue(), FlyingStuffModVariables.CloudDist.getValue());
					for (int i = 0; i < 20; i++) {
							double x_newest = x_new + Mth.nextDouble(rand, -32.0, 32.0);
							double z_newest = z_new + Mth.nextDouble(rand, -20.0, 20.0);
							world.addParticle((SimpleParticleType) (FlyingStuffModParticleTypes.CLOUD_BARRIER_3.get()), x_newest, (310 + noise.getValue(x_newest / 11000.0, z_newest/ 16000.0)* 120), z_newest, 0.1, 0, 0.06);
						}
				}
		}
		}
		}
	}
}

