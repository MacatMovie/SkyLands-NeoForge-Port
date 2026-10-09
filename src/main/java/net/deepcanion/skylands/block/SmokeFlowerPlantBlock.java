package net.deepcanion.skylands.block;

import net.deepcanion.skylands.registry.ModBlocks;
import net.deepcanion.skylands.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;

/** Two authored growth variants, with atomic paired updates and server-only harvests. */
public final class SmokeFlowerPlantBlock extends DoublePlantBlock {
    private final boolean mature;
    public SmokeFlowerPlantBlock(boolean mature, Properties properties) {
        super(properties); this.mature = mature;
    }
    @Override protected boolean mayPlaceOn(BlockState soil, BlockGetter level, BlockPos pos) {
        return soil.is(PlantSupport.SOILS) || super.mayPlaceOn(soil, level, pos);
    }
    private boolean complete(Level level, BlockPos bottom) {
        return level.getBlockState(bottom).is(this)
            && level.getBlockState(bottom).getValue(HALF) == DoubleBlockHalf.LOWER
            && level.getBlockState(bottom.above()).is(this)
            && level.getBlockState(bottom.above()).getValue(HALF) == DoubleBlockHalf.UPPER;
    }
    private void replace(Level level, BlockPos bottom, Block next) {
        // Defer neighbor notifications until both halves exist in their new variant.
        level.setBlock(bottom, next.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER), Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
        level.setBlock(bottom.above(), next.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER), Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
        level.updateNeighborsAt(bottom, next);
        level.updateNeighborsAt(bottom.above(), next);
    }
    @Override protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (!mature) return InteractionResult.PASS;
        BlockPos bottom = state.getValue(HALF) == DoubleBlockHalf.UPPER ? pos.below() : pos;
        if (!complete(level, bottom)) return InteractionResult.PASS;
        if (!level.isClientSide()) {
            replace(level, bottom, ModBlocks.SMOKE_FLOWER_PLANT_GROW_STAGE.get());
            Block.popResource(level, bottom, new ItemStack(ModItems.SMOKE_FLOWER.get()));
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
    @Override protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!mature && state.getValue(HALF) == DoubleBlockHalf.LOWER && complete(level, pos) && random.nextFloat() < 0.4F)
            replace(level, pos, ModBlocks.SMOKE_FLOWER_PLANT.get());
    }
}
