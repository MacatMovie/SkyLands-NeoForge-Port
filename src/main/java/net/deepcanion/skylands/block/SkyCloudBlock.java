package net.deepcanion.skylands.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/** Noncolliding cloud shell. Cull internal faces between matching clouds. */
public final class SkyCloudBlock extends Block {
    public SkyCloudBlock(Properties properties) { super(properties); }
    @Override public void animateTick(BlockState state, net.minecraft.world.level.Level level,
                                      net.minecraft.core.BlockPos pos, net.minecraft.util.RandomSource random) {
        if (!net.deepcanion.skylands.config.CloudConfig.SPEC.isLoaded()
                || !net.deepcanion.skylands.config.CloudConfig.CLOUD_BLOCK_PARTICLES.get()
                || random.nextFloat() >= 0.3F) return;
        level.addParticle(net.deepcanion.skylands.registry.ModParticles.CLOUD.get(),
                pos.getX() + 0.5 + (random.nextDouble() * 4 - 2),
                pos.getY() + random.nextDouble() * 1.5,
                pos.getZ() + 0.5 + (random.nextDouble() * 4 - 2),
                0.1 + random.nextDouble() * 0.9, 0, 0.1 + random.nextDouble() * 0.9);
    }

    @Override protected boolean skipRendering(BlockState state, BlockState adjacent, Direction side) {
        return adjacent.is(this) || super.skipRendering(state, adjacent, side);
    }
}
