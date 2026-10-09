package net.deepcanion.skylands.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public final class SkyCactusBranchBlock extends FacingBlock {
    public SkyCactusBranchBlock(Properties properties) { super(properties); }
    @Override protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        SkyCactusGrowth.grow(level, pos, random);
    }
}
