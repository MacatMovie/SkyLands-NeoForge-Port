package net.deepcanion.skylands.block;
import com.mojang.serialization.MapCodec;
import net.deepcanion.skylands.block.entity.SkyChestBlockEntity;
import net.deepcanion.skylands.registry.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;

/** Key exchange and inventory transfer execute exclusively on the server. */
public final class SkyChestBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, 2);
    public final SkyChestKind kind;
    public final boolean unlocked;
    private final MapCodec<SkyChestBlock> codec;
    public SkyChestBlock(SkyChestKind kind, boolean unlocked, Properties properties) {
        super(properties); this.kind = kind; this.unlocked = unlocked;
        codec = simpleCodec(p -> new SkyChestBlock(kind, unlocked, p));
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(ANIMATION, 0));
    }
    @Override protected MapCodec<SkyChestBlock> codec() { return codec; }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) { builder.add(FACING, ANIMATION); }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) { return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()); }
    @Override protected BlockState rotate(BlockState state, Rotation rotation) { return state.setValue(FACING, rotation.rotate(state.getValue(FACING))); }
    @Override protected BlockState mirror(BlockState state, Mirror mirror) { return state.rotate(mirror.getRotation(state.getValue(FACING))); }
    @Override protected RenderShape getRenderShape(BlockState state) { return RenderShape.ENTITYBLOCK_ANIMATED; }
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) { return new SkyChestBlockEntity(pos, state); }
    @Override protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (unlocked) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        if (kind.key == null || !stack.is(kind.key.get())) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        if (level.isClientSide()) return ItemInteractionResult.SUCCESS;
        if (!(level.getBlockEntity(pos) instanceof SkyChestBlockEntity old)) return ItemInteractionResult.FAIL;
        Block target = BuiltInRegistries.BLOCK.get(net.deepcanion.skylands.SkyLands.id("open_" + kind.id));
        CompoundTag saved = old.saveWithoutMetadata(level.registryAccess());
        BlockState next = target.defaultBlockState().setValue(FACING, state.getValue(FACING));
        if (!level.setBlock(pos, next, 3)) return ItemInteractionResult.FAIL;
        if (!(level.getBlockEntity(pos) instanceof SkyChestBlockEntity current)) {
            level.setBlock(pos, state, 3);
            if (level.getBlockEntity(pos) instanceof SkyChestBlockEntity restored) restored.loadWithComponents(saved, level.registryAccess());
            return ItemInteractionResult.FAIL;
        }
        current.loadWithComponents(saved, level.registryAccess()); current.setChanged();
        level.invalidateCapabilities(pos);
        level.updateNeighbourForOutputSignal(pos, target);
        level.playSound(null, pos, ModSounds.CHEST_UNLOCK.get(), SoundSource.BLOCKS, 0.8f, 1f);
        if (!player.getAbilities().instabuild) stack.shrink(1);
        player.openMenu(current);
        return ItemInteractionResult.SUCCESS;
    }
    @Override protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (!unlocked) {
            ItemStack offhand = player.getOffhandItem();
            if (offhand.is(kind.key.get())) {
                ItemInteractionResult result = useItemOn(offhand, state, level, pos, player, InteractionHand.OFF_HAND, hit);
                return result == ItemInteractionResult.FAIL ? InteractionResult.FAIL : InteractionResult.sidedSuccess(level.isClientSide());
            }
            if (!level.isClientSide()) player.displayClientMessage(net.minecraft.network.chat.Component.translatable("message.flying_stuff.chest_locked", kind.key.get().getDescription()), true);
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        if (!level.isClientSide() && level.getBlockEntity(pos) instanceof SkyChestBlockEntity chest) player.openMenu(chest);
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
    @Override protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState next, boolean moved) {
        if (state.getBlock() != next.getBlock()) {
            boolean transferring = next.getBlock() instanceof SkyChestBlock chest && chest.kind == kind;
            if (!transferring && level.getBlockEntity(pos) instanceof SkyChestBlockEntity chest) {
                Containers.dropContents(level, pos, chest);
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, next, moved);
        }
    }
    @Override protected boolean hasAnalogOutputSignal(BlockState state) { return unlocked; }
    @Override protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return unlocked ? AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos)) : 0;
    }
    @Override protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getBlockEntity(pos) instanceof SkyChestBlockEntity chest) chest.recheckOpen();
    }
}
