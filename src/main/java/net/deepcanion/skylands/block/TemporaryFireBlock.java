package net.deepcanion.skylands.block;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
public final class TemporaryFireBlock extends Block {
    public TemporaryFireBlock() { super(BlockBehaviour.Properties.of().noCollission().noOcclusion().instabreak().lightLevel(s -> 15)); }
    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState old, boolean moving) {
        super.onPlace(state, level, pos, old, moving);
        if (!level.isClientSide() && !old.is(this)) level.scheduleTick(pos, this, 60);
    }
    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) { level.removeBlock(pos, false); }
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) { if (!level.isClientSide()) entity.igniteForSeconds(5); }
}
