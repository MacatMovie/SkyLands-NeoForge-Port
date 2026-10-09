package net.deepcanion.skylands.block;
import com.mojang.serialization.MapCodec;
import net.deepcanion.skylands.block.entity.RewardDispenserBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.*;
public final class RewardDispenserBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, 3);
    public final RewardDispenserKind kind;
    private final MapCodec<RewardDispenserBlock> codec;
    public RewardDispenserBlock(RewardDispenserKind kind, Properties properties) {
        super(properties); this.kind = kind; codec = simpleCodec(p -> new RewardDispenserBlock(kind, p));
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(ANIMATION, 0));
    }
    @Override protected MapCodec<RewardDispenserBlock> codec() { return codec; }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) { builder.add(FACING, ANIMATION); }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) { return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()); }
    @Override protected BlockState rotate(BlockState state, Rotation rotation) { return state.setValue(FACING, rotation.rotate(state.getValue(FACING))); }
    @Override protected BlockState mirror(BlockState state, Mirror mirror) { return state.rotate(mirror.getRotation(state.getValue(FACING))); }
    @Override protected RenderShape getRenderShape(BlockState state) { return RenderShape.ENTITYBLOCK_ANIMATED; }
    @Override protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) { return Block.box(0, 0, 0, 16, 32, 16); }
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) { return new RewardDispenserBlockEntity(pos, state); }
    @Override protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!stack.is(kind.currency.get())) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        if (level.isClientSide()) return ItemInteractionResult.SUCCESS;
        if (level.getBlockEntity(pos) instanceof RewardDispenserBlockEntity dispenser) dispenser.deposit(player, stack);
        return ItemInteractionResult.SUCCESS;
    }
    @Override protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (!level.isClientSide() && level.getBlockEntity(pos) instanceof RewardDispenserBlockEntity dispenser) {
            ItemStack offhand = player.getOffhandItem();
            if (offhand.is(kind.currency.get())) dispenser.deposit(player, offhand);
            else dispenser.showStatus(player);
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
    @Override protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getBlockEntity(pos) instanceof RewardDispenserBlockEntity dispenser) dispenser.finish();
    }
    @Override protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState next, boolean moved) {
        if (state.getBlock() != next.getBlock()) {
            if (!level.isClientSide() && level.getBlockEntity(pos) instanceof RewardDispenserBlockEntity dispenser) dispenser.dropStored();
            super.onRemove(state, level, pos, next, moved);
        }
    }
}
