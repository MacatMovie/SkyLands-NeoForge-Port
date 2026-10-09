package net.deepcanion.skylands.client;

import java.util.HashSet;
import java.util.Set;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.glider.FlightAnimationState;
import net.deepcanion.skylands.glider.FreefallFlight;
import net.deepcanion.skylands.glider.GliderFlight;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;

/** Original poses, played through Player Animator's 2.x playable API. */
public final class FlightAnimations {
    private static final ResourceLocation LAYER = SkyLands.id("player_animation");
    private static final String[] NAMES = {"freefalltransition", "freefall", "freefallfast", "animation.player.glide"};
    private static final Set<String> WARNED = new HashSet<>();
    public static void register() {
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(LAYER, 1000, player -> new FlightLayer());
    }
    public static void tick(Minecraft client) {
        if (client.level == null) return;
        for (AbstractClientPlayer player : client.level.players()) {
            var data = player.getPersistentData();
            int mode;
            if (player.isLocalPlayer()) {
                if (data.getBoolean(GliderFlight.ACTIVE)) mode = 3;
                else if (data.getBoolean(FreefallFlight.ACTIVE)) mode = player.isShiftKeyDown() ? 2 : 1;
                else mode = 0;
            } else mode = data.getInt(FlightAnimationState.MODE);
            boolean blocked = !player.isAlive() || player.isSpectator() || player.getAbilities().flying || player.isPassenger()
                    || player.isInWaterOrBubble() || player.isInLava() || player.isFallFlying();
            if (blocked || player.onGround()) mode = 0;
            var animation = PlayerAnimationAccess.getPlayerAssociatedData(player).get(LAYER);
            if (animation instanceof FlightLayer layer) layer.update(Math.clamp(mode, 0, 3), blocked);
        }
    }
    private static final class FlightLayer extends ModifierLayer<IAnimation> {
        private int mode;
        void update(int next, boolean blocked) {
            if (blocked) { mode = 0; setAnimation(null); return; }
            if (next == mode) return;
            var playable = PlayerAnimationRegistry.getAnimation(SkyLands.id(NAMES[next]));
            if (playable == null) {
                setAnimation(null);
                if (WARNED.add(NAMES[next])) SkyLands.LOGGER.warn("[Sky Lands] Missing player animation: {}", NAMES[next]);
                return;
            }
            setAnimation(playable.playAnimation());
            mode = next;
        }
    }
    private FlightAnimations() { }
}
