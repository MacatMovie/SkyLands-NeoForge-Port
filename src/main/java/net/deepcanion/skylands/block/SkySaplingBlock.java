package net.deepcanion.skylands.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

/** Vanilla growth and bonemeal, with support for the island ground blocks. */
public final class SkySaplingBlock extends SaplingBlock {
    public SkySaplingBlock(TreeGrower grower, Properties properties) { super(grower, properties); }
    @Override protected boolean mayPlaceOn(BlockState soil, BlockGetter level, BlockPos pos) {
        return soil.is(PlantSupport.SOILS) || super.mayPlaceOn(soil, level, pos);
    }
}
