package net.deepcanion.skylands.client;

import net.deepcanion.skylands.config.CloudConfig;
import net.deepcanion.skylands.registry.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.client.event.ClientTickEvent;

/** Original ~two short wind streaks per second, once per client rather than per player. */
public final class ClientAmbientWind {
    public static void tick(ClientTickEvent.Post event) {
        Minecraft client = Minecraft.getInstance();
        var level = client.level;
        var player = client.player;
        if (level == null || player == null || client.isPaused() || !CloudConfig.SPEC.isLoaded()
                || !CloudConfig.HIGH_ALTITUDE_WIND.get() || !Level.OVERWORLD.equals(level.dimension())
                || player.getY() <= 195 || level.random.nextFloat() >= 0.1F) return;
        level.addParticle(ModParticles.WIND.get(),
                player.getX() + level.random.nextDouble() * 32 - 16,
                player.getY() + level.random.nextDouble() * 32 - 16,
                player.getZ() + level.random.nextDouble() * 32 - 16, 0, 0, 0);
    }
    private ClientAmbientWind() { }
}
