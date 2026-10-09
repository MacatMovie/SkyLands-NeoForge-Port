package net.deepcanion.skylands.block;

import net.deepcanion.skylands.registry.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public final class SkySwampyBushBlock extends SkyDoublePlantBlock {
    public SkySwampyBushBlock(Properties properties) { super(properties); }
    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        level.addParticle(ModParticles.FIREFLY.get(), pos.getX() + random.nextDouble() * 8 - 4,
                pos.getY() + random.nextDouble() * 8 - 3, pos.getZ() + random.nextDouble() * 8 - 4, 0, 0, 0);
    }
}
