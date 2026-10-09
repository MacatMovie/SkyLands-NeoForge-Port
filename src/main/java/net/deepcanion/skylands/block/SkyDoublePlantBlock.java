package net.deepcanion.skylands.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SkyDoublePlantBlock extends DoublePlantBlock {
    public SkyDoublePlantBlock(Properties properties) { super(properties); }
    @Override protected boolean mayPlaceOn(BlockState soil, BlockGetter level, BlockPos pos) {
        return soil.is(PlantSupport.SOILS) || super.mayPlaceOn(soil, level, pos);
    }
}
