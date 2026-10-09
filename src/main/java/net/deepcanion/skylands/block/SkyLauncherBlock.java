package net.deepcanion.skylands.block;
import net.deepcanion.skylands.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.shapes.*;
public final class SkyLauncherBlock extends FacingBlock {
    private final boolean powered;
    public SkyLauncherBlock(boolean powered, Properties properties) { super(properties); this.powered = powered; }
    @Override protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) { return Block.box(0, 0, 0, 16, 6, 16); }
    @Override protected VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) { return Shapes.empty(); }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (context.getLevel().hasNeighborSignal(context.getClickedPos()) ? ModBlocks.ACTIVE_SKY_LAUNCHER.get() : ModBlocks.SKY_LAUNCHER.get()).defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    @Override protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos from, boolean moved) {
        if (!level.isClientSide() && level.hasNeighborSignal(pos) != powered) level.setBlock(pos, (powered ? ModBlocks.SKY_LAUNCHER.get() : ModBlocks.ACTIVE_SKY_LAUNCHER.get()).defaultBlockState().setValue(FACING, state.getValue(FACING)), 3);
    }
    @Override protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState old, boolean moved) { neighborChanged(state, level, pos, this, pos, moved); }
}
