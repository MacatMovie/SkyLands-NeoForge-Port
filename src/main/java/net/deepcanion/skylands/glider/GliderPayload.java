package net.deepcanion.skylands.glider;
import net.deepcanion.skylands.SkyLands;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
public record GliderPayload(float stamina, boolean exhausted, boolean active) implements CustomPacketPayload {
    public static final Type<GliderPayload> TYPE = new Type<>(SkyLands.id("glider_state"));
    public static final StreamCodec<RegistryFriendlyByteBuf, GliderPayload> CODEC = new StreamCodec<>() {
        public GliderPayload decode(RegistryFriendlyByteBuf buffer) { return new GliderPayload(buffer.readFloat(), buffer.readBoolean(), buffer.readBoolean()); }
        public void encode(RegistryFriendlyByteBuf buffer, GliderPayload value) { buffer.writeFloat(value.stamina()); buffer.writeBoolean(value.exhausted()); buffer.writeBoolean(value.active()); }
    };
    @Override public Type<GliderPayload> type() { return TYPE; }
    public static void register(RegisterPayloadHandlersEvent event) {
        event.registrar("1").playToClient(TYPE, CODEC, (payload, context) -> context.enqueueWork(() -> {
            var data = context.player().getPersistentData();
            data.putFloat(GliderFlight.STAMINA, payload.stamina());
            data.putBoolean(GliderFlight.EXHAUSTED, payload.exhausted());
            data.putBoolean(GliderFlight.ACTIVE, payload.active());
        }));
    }
}
