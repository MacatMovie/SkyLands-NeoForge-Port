package net.deepcanion.skylands.glider;

import net.deepcanion.skylands.registry.ModItems;
import net.deepcanion.skylands.registry.ModParticles;
import net.deepcanion.skylands.registry.ModSounds;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.PacketDistributor;

public final class FreefallFlight {
    public static final double NORMAL_SPEED = 0.9;
    public static final double FAST_SPEED = 1.65;
    public static final String ACTIVE = "skylands_freefall_active";
    private static final String NEXT_SOUND = "skylands_freefall_next_sound";
    private static final String LAST_TOGGLE = "skylands_freefall_last_toggle";
    private static boolean eligible(Player player) {
        return player.isAlive() && !player.onGround() && !player.isSpectator() && !player.getAbilities().flying
                && !player.isPassenger() && !player.isInWaterOrBubble() && !player.isInLava() && !player.isFallFlying()
                && !player.getMainHandItem().is(ModItems.GLIDER.get());
    }
    public static void toggle(ServerPlayer player) {
        var data = player.getPersistentData();
        long now = player.level().getGameTime(), previous = data.getLong(LAST_TOGGLE);
        if (data.contains(LAST_TOGGLE) && now >= previous && now - previous < 4) return;
        data.putLong(LAST_TOGGLE, now);
        boolean active = !data.getBoolean(ACTIVE) && eligible(player);
        data.putBoolean(ACTIVE, active);
        PacketDistributor.sendToPlayer(player, new FreefallPayload(active));
        player.hurtMarked = true;
    }
    /** Called before gliding, on both sides; the local client predicts movement only. */
    public static void tick(Player player) {
        var data = player.getPersistentData();
        if (!data.getBoolean(ACTIVE)) return;
        if (!eligible(player)) {
            if (player instanceof ServerPlayer serverPlayer) {
                data.putBoolean(ACTIVE, false);
                PacketDistributor.sendToPlayer(serverPlayer, new FreefallPayload(false));
                player.hurtMarked = true;
            }
            return;
        }
        boolean fast = player.isShiftKeyDown();
        if (!player.level().isClientSide() || player.isLocalPlayer()) {
            Vec3 velocity = player.getDeltaMovement();
            double vertical = fast ? Math.max(velocity.y - 0.08, -FAST_SPEED) : Math.max(velocity.y - 0.02, -NORMAL_SPEED);
            player.setDeltaMovement(velocity.x, vertical, velocity.z);
            // Native gravity and fall damage remain enabled; never leave a no-gravity flag behind.
        }
        if (player.level().isClientSide() && player.isLocalPlayer()) {
            var random = player.getRandom();
            for (int i = 0; i < 2; i++) player.level().addParticle(ModParticles.FAST.get(),
                    player.getX() + random.nextDouble() * 30 - 15, player.getY() + random.nextDouble() * 30 - 15,
                    player.getZ() + random.nextDouble() * 30 - 15, 0, 1, 0);
        } else if (player instanceof ServerPlayer serverPlayer) {
            if (player.tickCount % 20 == 0) PacketDistributor.sendToPlayer(serverPlayer, new FreefallPayload(true));
            long now = player.level().getGameTime();
            if (!data.contains(NEXT_SOUND) || now >= data.getLong(NEXT_SOUND)) {
                data.putLong(NEXT_SOUND, now + 80);
                player.level().playSound(null, player.blockPosition(), fast ? ModSounds.FREEFALL_FAST.get() : ModSounds.FREEFALL.get(),
                        SoundSource.PLAYERS, fast ? 0.3F : 0.2F, fast ? 1.5F : 1F);
            }
        }
    }
    private static void reset(Player player) {
        player.getPersistentData().remove(ACTIVE);
        player.getPersistentData().remove(LAST_TOGGLE);
        player.getPersistentData().remove(NEXT_SOUND);
        if (player instanceof ServerPlayer serverPlayer) PacketDistributor.sendToPlayer(serverPlayer, new FreefallPayload(false));
    }
    public static void login(PlayerEvent.PlayerLoggedInEvent event) { reset(event.getEntity()); }
    public static void respawn(PlayerEvent.PlayerRespawnEvent event) { reset(event.getEntity()); }
    public static void dimensionChange(PlayerEvent.PlayerChangedDimensionEvent event) { reset(event.getEntity()); }
    private FreefallFlight() { }
}
