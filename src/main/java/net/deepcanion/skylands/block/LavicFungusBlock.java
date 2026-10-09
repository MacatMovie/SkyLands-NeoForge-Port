package net.deepcanion.skylands.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/** The original luminous fungus canopy, with native leaf distance and decay. */
public final class LavicFungusBlock extends LeavesBlock {
    public static final MapCodec<LavicFungusBlock> CODEC = simpleCodec(LavicFungusBlock::new);
    public LavicFungusBlock(Properties properties) { super(properties); }
    @Override public MapCodec<? extends LeavesBlock> codec() { return CODEC; }
    @Override protected int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) { return 10; }
    @Override protected VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) { return Shapes.empty(); }
}
