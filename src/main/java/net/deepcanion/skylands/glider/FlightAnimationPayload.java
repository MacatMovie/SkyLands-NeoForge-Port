package net.deepcanion.skylands.glider;

import java.util.UUID;
import net.deepcanion.skylands.SkyLands;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

public record FlightAnimationPayload(int entityId, UUID uuid, int mode) implements CustomPacketPayload {
    public static final Type<FlightAnimationPayload> TYPE = new Type<>(SkyLands.id("flight_animation"));
    public static final StreamCodec<RegistryFriendlyByteBuf, FlightAnimationPayload> CODEC = new StreamCodec<>() {
        public FlightAnimationPayload decode(RegistryFriendlyByteBuf buffer) {
            return new FlightAnimationPayload(buffer.readVarInt(), buffer.readUUID(), buffer.readUnsignedByte());
        }
        public void encode(RegistryFriendlyByteBuf buffer, FlightAnimationPayload value) {
            buffer.writeVarInt(value.entityId()); buffer.writeUUID(value.uuid()); buffer.writeByte(value.mode());
        }
    };
    @Override public Type<FlightAnimationPayload> type() { return TYPE; }
    public static void register(RegisterPayloadHandlersEvent event) {
        event.registrar("1").playToClient(TYPE, CODEC, (payload, context) -> context.enqueueWork(() -> {
            var entity = context.player().level().getEntity(payload.entityId());
            if (entity instanceof net.minecraft.world.entity.player.Player player && player.getUUID().equals(payload.uuid())
                    && payload.mode() >= 0 && payload.mode() <= 3)
                player.getPersistentData().putInt(FlightAnimationState.MODE, payload.mode());
        }));
    }
}
