package net.deepcanion.skylands.block.entity;

import net.deepcanion.skylands.registry.ModBlockEntities;
import net.deepcanion.skylands.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/** Starts the native scheduled tick loop after world generation, chunk load, or reload. */
public final class StormBlockEntity extends BlockEntity {
    public StormBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STORM_BLOCK.get(), pos, state);
    }
    @Override public void onLoad() {
        super.onLoad();
        if (level instanceof ServerLevel server && getBlockState().is(ModBlocks.STORM_BLOCK.get()))
            server.scheduleTick(worldPosition, ModBlocks.STORM_BLOCK.get(), 10);
    }
}
