package net.mcreator.flyingstuff.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.flyingstuff.network.FlyingStuffModVariables;
import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;
import net.mcreator.flyingstuff.FlyingStuffMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Iterator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

@Mod.EventBusSubscriber
public class FreefallTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).is_freefall == true) {
			if (entity.isShiftKeyDown()) {
				if ((entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).was_freefall
						|| !(entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).is_fast_freefalling) {
					if (world.isClientSide()) {
						if (entity instanceof AbstractClientPlayer player) {
							var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("flying_stuff", "player_animation"));
							if (animation != null) {
								animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("flying_stuff", "freefallfast"))));
							}
						}
					}
					if (!world.isClientSide()) {
						if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
							List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
							synchronized (connections) {
								Iterator<Connection> iterator = connections.iterator();
								while (iterator.hasNext()) {
									Connection connection = iterator.next();
									if (!connection.isConnecting() && connection.isConnected())
										FlyingStuffMod.PACKET_HANDLER.sendTo(new SetupPlayerAnimationProcedure.FlyingStuffModAnimationMessage(Component.literal("freefallfast"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
								}
							}
						}
					}
					{
						boolean _setval = true;
						entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.is_fast_freefalling = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (Mth.nextDouble(RandomSource.create(), 0, 1) < 0.1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("flying_stuff:freefall_fast")), SoundSource.PLAYERS, (float) 0.3, (float) 1.5);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("flying_stuff:freefall_fast")), SoundSource.PLAYERS, (float) 0.3, (float) 1.5, false);
							}
						}
					}
				}
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), Math.min(entity.getDeltaMovement().y() + 0.02, -4.5), (entity.getDeltaMovement().z())));
			} else {
				if ((entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).was_freefall
						|| (entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).is_fast_freefalling) {
					if (world.isClientSide()) {
						if (entity instanceof AbstractClientPlayer player) {
							var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("flying_stuff", "player_animation"));
							if (animation != null) {
								animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("flying_stuff", "freefall"))));
							}
						}
					}
					if (!world.isClientSide()) {
						if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
							List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
							synchronized (connections) {
								Iterator<Connection> iterator = connections.iterator();
								while (iterator.hasNext()) {
									Connection connection = iterator.next();
									if (!connection.isConnecting() && connection.isConnected())
										FlyingStuffMod.PACKET_HANDLER.sendTo(new SetupPlayerAnimationProcedure.FlyingStuffModAnimationMessage(Component.literal("freefall"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
								}
							}
						}
					}
					{
						boolean _setval = false;
						entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.is_fast_freefalling = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (Mth.nextDouble(RandomSource.create(), 0, 1) < 0.1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("flying_stuff:freefall")), SoundSource.PLAYERS, (float) 0.2, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("flying_stuff:freefall")), SoundSource.PLAYERS, (float) 0.2, 1, false);
							}
						}
					}
				}
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), Math.max(entity.getDeltaMovement().y() - 0.02, -1.1), (entity.getDeltaMovement().z())));
			}
			{
				boolean _setval = true;
				entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.was_freefall = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.setNoGravity(true);
			world.addParticle((SimpleParticleType) (FlyingStuffModParticleTypes.FAST.get()), (x + Mth.nextDouble(RandomSource.create(), -15, 15)), (y + Mth.nextDouble(RandomSource.create(), -15, 15)),
					(z + Mth.nextDouble(RandomSource.create(), -15, 15)), 0, 1, 0);
			world.addParticle((SimpleParticleType) (FlyingStuffModParticleTypes.FAST.get()), (x + Mth.nextDouble(RandomSource.create(), -15, 15)), (y + Mth.nextDouble(RandomSource.create(), -15, 15)),
					(z + Mth.nextDouble(RandomSource.create(), -15, 15)), 0, 1, 0);
		} else {
			if ((entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).was_freefall == true) {
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("flying_stuff", "player_animation"));
						if (animation != null) {
							animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("flying_stuff", "freefalltransition"))));
						}
					}
				}
				if (!world.isClientSide()) {
					if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
						List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
						synchronized (connections) {
							Iterator<Connection> iterator = connections.iterator();
							while (iterator.hasNext()) {
								Connection connection = iterator.next();
								if (!connection.isConnecting() && connection.isConnected())
									FlyingStuffMod.PACKET_HANDLER.sendTo(new SetupPlayerAnimationProcedure.FlyingStuffModAnimationMessage(Component.literal("freefalltransition"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
							}
						}
					}
				}
			}
			entity.setNoGravity(false);
			{
				boolean _setval = false;
				entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.was_freefall = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity.onGround() || entity.isInWater() || entity instanceof LivingEntity _livEnt28 && _livEnt28.isFallFlying() || entity.isPassenger()) {
			if ((entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).was_freefall == true) {
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("flying_stuff", "player_animation"));
						if (animation != null) {
							animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("flying_stuff", "freefalltransition"))));
						}
					}
				}
				if (!world.isClientSide()) {
					if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
						List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
						synchronized (connections) {
							Iterator<Connection> iterator = connections.iterator();
							while (iterator.hasNext()) {
								Connection connection = iterator.next();
								if (!connection.isConnecting() && connection.isConnected())
									FlyingStuffMod.PACKET_HANDLER.sendTo(new SetupPlayerAnimationProcedure.FlyingStuffModAnimationMessage(Component.literal("freefalltransition"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
							}
						}
					}
				}
			}
			{
				boolean _setval = false;
				entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.is_freefall = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
