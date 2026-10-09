package net.deepcanion.skylands.procedures;
import net.deepcanion.skylands.registry.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
public final class FireWaveWhileProjectileFlyingTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!(world instanceof ServerLevel server)) return;
        server.sendParticles(ModParticles.TEMP_FIRE_PARTICLE.get(), x, y + 1, z, 1, 0, 0, 0, 0);
        // Fill only empty supported cells; the legacy offsets could overwrite the floor.
        for (int down = 0; down <= 2; down++) {
            BlockPos pos = BlockPos.containing(x, y - down, z);
            if (server.isEmptyBlock(pos) && server.getBlockState(pos.below()).isFaceSturdy(server, pos.below(), net.minecraft.core.Direction.UP)) {
                server.setBlock(pos, ModBlocks.TEMPORARY_FIRE.get().defaultBlockState(), 3);
                break;
            }
        }
    }
}
