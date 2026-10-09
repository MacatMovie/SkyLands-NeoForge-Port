package net.deepcanion.skylands.glider;

import net.deepcanion.skylands.SkyLands;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

/** Clients request a toggle; only the server chooses the resulting state. */
public record FreefallPayload(boolean active) implements CustomPacketPayload {
    public static final Type<FreefallPayload> TYPE = new Type<>(SkyLands.id("freefall_state"));
    public static final StreamCodec<RegistryFriendlyByteBuf, FreefallPayload> CODEC = new StreamCodec<>() {
        public FreefallPayload decode(RegistryFriendlyByteBuf buffer) { return new FreefallPayload(buffer.readBoolean()); }
        public void encode(RegistryFriendlyByteBuf buffer, FreefallPayload value) { buffer.writeBoolean(value.active()); }
    };
    @Override public Type<FreefallPayload> type() { return TYPE; }
    public static void register(RegisterPayloadHandlersEvent event) {
        var registrar = event.registrar("1");
        registrar.playToClient(TYPE, CODEC, (payload, context) -> context.enqueueWork(() ->
                context.player().getPersistentData().putBoolean(FreefallFlight.ACTIVE, payload.active())));
        registrar.playToServer(Toggle.TYPE, Toggle.CODEC, (payload, context) -> context.enqueueWork(() -> {
            if (context.player() instanceof net.minecraft.server.level.ServerPlayer player) FreefallFlight.toggle(player);
        }));
    }
    public record Toggle() implements CustomPacketPayload {
        public static final Type<Toggle> TYPE = new Type<>(SkyLands.id("freefall_toggle"));
        public static final StreamCodec<RegistryFriendlyByteBuf, Toggle> CODEC = new StreamCodec<>() {
            public Toggle decode(RegistryFriendlyByteBuf buffer) { return new Toggle(); }
            public void encode(RegistryFriendlyByteBuf buffer, Toggle value) { }
        };
        @Override public Type<Toggle> type() { return TYPE; }
    }
}
