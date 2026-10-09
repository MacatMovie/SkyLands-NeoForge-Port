package net.deepcanion.skylands.block;

import net.deepcanion.skylands.registry.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;

public final class MoltenMetalBlock extends LiquidBlock {
    public MoltenMetalBlock(Properties properties) { super(ModFluids.MOLTEN_METAL.get(), properties); }
    @Override protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        if (!level.isClientSide()) entity.igniteForSeconds(15);
    }
}
