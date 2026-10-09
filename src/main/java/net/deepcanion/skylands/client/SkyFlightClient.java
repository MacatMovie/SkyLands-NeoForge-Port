package net.deepcanion.skylands.client;

import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.glider.FreefallFlight;
import net.deepcanion.skylands.glider.FreefallPayload;
import net.deepcanion.skylands.glider.GliderFlight;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.lwjgl.glfw.GLFW;

/** Input and the HUD are isolated from common/server class loading. */
public final class SkyFlightClient {
    public static final KeyMapping FREEFALL = new KeyMapping("key.flying_stuff.freefall", GLFW.GLFW_KEY_R, "key.categories.movement");
    private static final ResourceLocation UNDER = SkyLands.id("textures/screens/stamina_under.png");
    private static final ResourceLocation OVER = SkyLands.id("textures/screens/stamina_over.png");
    private static boolean wasDown;
    public static void tick(ClientTickEvent.Post event) {
        Minecraft client = Minecraft.getInstance();
        FlightAnimations.tick(client);
        boolean down = FREEFALL.isDown();
        boolean pressed = down && !wasDown;
        wasDown = down;
        while (FREEFALL.consumeClick()) { /* Discard repeats and menu clicks. */ }
        if (pressed && client.screen == null && client.player != null && client.getConnection() != null)
            PacketDistributor.sendToServer(new FreefallPayload.Toggle());
    }
    public static void render(GuiGraphics graphics, net.minecraft.client.DeltaTracker delta) {
        Minecraft client = Minecraft.getInstance();
        var player = client.player;
        if (player == null || player.isSpectator() || client.options.hideGui || client.screen != null) return;
        var data = player.getPersistentData();
        float stamina = Math.clamp(data.contains(GliderFlight.STAMINA) ? data.getFloat(GliderFlight.STAMINA) : 6, 0, 6);
        boolean showStamina = stamina < 6 || data.getBoolean(GliderFlight.ACTIVE);
        int center = graphics.guiWidth() / 2, y = graphics.guiHeight() - 70;
        if (showStamina) {
            graphics.blit(UNDER, center - 47, y, 0, 0, 96, 16, 96, 16);
            int[] offsets = {-49, -28, -7, 14, 36};
            for (int i = 0; i < offsets.length; i++) if (stamina >= i + 1)
                graphics.blit(OVER, center + offsets[i], y, 0, 0, 16, 16, 16, 16);

        }
        if (data.getBoolean(FreefallFlight.ACTIVE))
            graphics.drawCenteredString(client.font, Component.translatable(player.isShiftKeyDown() ? "freefall.flying_stuff.fast" : "freefall.flying_stuff.active"),
                    center, showStamina ? y - 23 : y - 11, 0xffffff);
    }
    private SkyFlightClient() { }
}
