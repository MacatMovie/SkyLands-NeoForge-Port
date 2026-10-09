package net.deepcanion.skylands.glider;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.PacketDistributor;

/** Broadcast only server-owned flight state to the owner and tracking clients. */
public final class FlightAnimationState {
    public static final String MODE = "skylands_flight_animation_mode";
    public static int mode(ServerPlayer player) {
        if (!player.isAlive() || player.onGround() || player.isSpectator() || player.getAbilities().flying
                || player.isPassenger() || player.isInWaterOrBubble() || player.isInLava() || player.isFallFlying()) return 0;
        var data = player.getPersistentData();
        if (data.getBoolean(GliderFlight.ACTIVE)) return 3;
        if (data.getBoolean(FreefallFlight.ACTIVE)) return player.isShiftKeyDown() ? 2 : 1;
        return 0;
    }
    private static FlightAnimationPayload payload(ServerPlayer player) {
        return new FlightAnimationPayload(player.getId(), player.getUUID(), mode(player));
    }
    public static void tick(ServerPlayer player) {
        var data = player.getPersistentData();
        int mode = mode(player);
        if (!data.contains(MODE) || data.getInt(MODE) != mode || mode != 0 && player.tickCount % 20 == 0) {
            data.putInt(MODE, mode);
            PacketDistributor.sendToPlayersTrackingEntityAndSelf(player, payload(player));
        }
    }
    public static void tracking(PlayerEvent.StartTracking event) {
        if (event.getEntity() instanceof ServerPlayer observer && event.getTarget() instanceof ServerPlayer target)
            PacketDistributor.sendToPlayer(observer, payload(target));
    }
    private FlightAnimationState() { }
}
