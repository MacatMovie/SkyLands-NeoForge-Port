package net.deepcanion.skylands.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.TriState;

/** Preserves the original ground blocks' support for plants. */
public class SkySoilBlock extends Block {
    public SkySoilBlock(Properties properties) { super(properties); }
    @Override public TriState canSustainPlant(BlockState state, BlockGetter level, BlockPos pos, Direction face, BlockState plant) {
        return face == Direction.UP && state.is(PlantSupport.SOILS) ? TriState.TRUE : TriState.DEFAULT;
    }
}
