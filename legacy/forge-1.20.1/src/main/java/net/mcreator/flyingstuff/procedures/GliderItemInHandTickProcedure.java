package net.mcreator.flyingstuff.procedures;

import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.core.BlockPos;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.flyingstuff.network.FlyingStuffModVariables;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.mcreator.flyingstuff.init.FlyingStuffModEnchantments;
import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
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
public class GliderItemInHandTickProcedure {
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
		if (!(entity.onGround() || (entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).is_on_stamina_cooldown)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == FlyingStuffModItems.GLIDER.get()) {
			if ((entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).gliding_stamina > 0.2) {
				{
					boolean _setval = false;
					entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.is_freefall = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("flying_stuff", "player_animation"));
						if (animation != null) {
							animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("flying_stuff", "animation.player.glide"))));
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
									FlyingStuffMod.PACKET_HANDLER.sendTo(new SetupPlayerAnimationProcedure.FlyingStuffModAnimationMessage(Component.literal("animation.player.glide"), entity.getId(), true), connection,
											NetworkDirection.PLAY_TO_CLIENT);
							}
						}
					}
				}
				entity.setNoGravity(true);
				if ((world.getBlockState(BlockPos.containing(x, y - 4, z))).getBlock() == FlyingStuffModBlocks.MECHANICAL_GEYSER.get()
						|| (world.getBlockState(BlockPos.containing(x, y - 3, z))).getBlock() == FlyingStuffModBlocks.MECHANICAL_GEYSER.get()
						|| (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == FlyingStuffModBlocks.MECHANICAL_GEYSER.get()
						|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == FlyingStuffModBlocks.MECHANICAL_GEYSER.get()) {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), Math.min(entity.getDeltaMovement().y() + 0.065, 15), (entity.getDeltaMovement().z())));
				} else {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), Math.max(entity.getDeltaMovement().y() - 0.02, -0.04), (entity.getDeltaMovement().z())));
				}
				entity.fallDistance = 0;
				{
					boolean _setval = true;
					entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.is_gliding = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).gliding_stamina
							- (0.024 - 0.004 * (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(FlyingStuffModEnchantments.LIGHTWEIGHT.get()));
					entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gliding_stamina = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = true;
					entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.is_on_stamina_cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			entity.setNoGravity(false);
			if ((entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).is_gliding) {
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
					capability.is_gliding = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = Math.min((entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).gliding_stamina + 0.05, 6);
				entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.gliding_stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FlyingStuffModVariables.PlayerVariables())).gliding_stamina > 5) {
				{
					boolean _setval = false;
					entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.is_on_stamina_cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
