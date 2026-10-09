package net.deepcanion.skylands.block;

import net.deepcanion.skylands.registry.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public final class SkyFieryLeavesBlock extends LeavesBlock {
    public SkyFieryLeavesBlock(Properties properties) { super(properties); }
    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        if (random.nextFloat() < 0.1F)
            level.addParticle(ModParticles.FIRE_LEAF.get(), pos.getX(), pos.getY() - 0.5, pos.getZ(), 0.2, -0.8, 0.4);
    }
}
