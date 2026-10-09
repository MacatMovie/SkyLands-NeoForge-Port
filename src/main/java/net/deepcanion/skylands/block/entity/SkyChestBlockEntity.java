package net.deepcanion.skylands.block.entity;
import net.deepcanion.skylands.block.*;
import net.deepcanion.skylands.inventory.SkyChestMenu;
import net.deepcanion.skylands.registry.ModBlockEntities;
import net.deepcanion.skylands.registry.ModSounds;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import java.util.stream.IntStream;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

/** Shared native loot/inventory persistence; every chest keeps its authored capacity. */
public final class SkyChestBlockEntity extends RandomizableContainerBlockEntity implements GeoBlockEntity, WorldlyContainer {
    private NonNullList<ItemStack> items;
    public final InvWrapper itemHandler = new InvWrapper(this);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final ContainerOpenersCounter openers = new ContainerOpenersCounter() {
        @Override protected void onOpen(Level level, BlockPos pos, BlockState state) { changeOpen(level, pos, state, 1); }
        @Override protected void onClose(Level level, BlockPos pos, BlockState state) { changeOpen(level, pos, state, 2); }
        @Override protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int oldCount, int newCount) { }
        @Override protected boolean isOwnContainer(Player player) { return player.containerMenu instanceof SkyChestMenu menu && menu.container == SkyChestBlockEntity.this; }
    };
    public SkyChestBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SKY_CHEST.get(), pos, state);
        items = NonNullList.withSize(kind().size(), ItemStack.EMPTY);
    }
    public SkyChestKind kind() { return ((SkyChestBlock)getBlockState().getBlock()).kind; }
    public boolean unlocked() { return ((SkyChestBlock)getBlockState().getBlock()).unlocked; }
    @Override public int getContainerSize() { return items.size(); }
    @Override protected NonNullList<ItemStack> getItems() { return items; }
    @Override protected void setItems(NonNullList<ItemStack> items) { this.items = items; }
    @Override protected Component getDefaultName() { return Component.translatable(getBlockState().getBlock().getDescriptionId()); }
    @Override protected AbstractContainerMenu createMenu(int id, Inventory inventory) { return new SkyChestMenu(id, inventory, this); }
    @Override public boolean canOpen(Player player) { return unlocked() && super.canOpen(player); }
    @Override protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        items = NonNullList.withSize(kind().size(), ItemStack.EMPTY);
        if (!tryLoadLootTable(tag)) ContainerHelper.loadAllItems(tag, items, registries);
    }
    @Override protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!trySaveLootTable(tag)) ContainerHelper.saveAllItems(tag, items, registries);
    }
    @Override public int[] getSlotsForFace(Direction side) { return unlocked() ? IntStream.range(0, getContainerSize()).toArray() : new int[0]; }
    @Override public boolean canPlaceItem(int index, ItemStack stack) { return unlocked(); }
    @Override public boolean canPlaceItemThroughFace(int index, ItemStack stack, Direction side) { return unlocked(); }
    @Override public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction side) { return unlocked(); }
    @Override public void startOpen(Player player) {
        if (level != null && !level.isClientSide() && !isRemoved() && !player.isSpectator()) openers.incrementOpeners(player, level, worldPosition, getBlockState());
    }
    @Override public void stopOpen(Player player) {
        if (level != null && !level.isClientSide() && !isRemoved() && !player.isSpectator()) openers.decrementOpeners(player, level, worldPosition, getBlockState());
    }
    private void changeOpen(Level level, BlockPos pos, BlockState state, int animation) {
        level.setBlock(pos, state.setValue(SkyChestBlock.ANIMATION, animation), 3);
        level.playSound(null, pos, animation == 1 ? ModSounds.SKY_CHEST_OPEN.get() : ModSounds.SKY_CHEST_CLOSE.get(), SoundSource.BLOCKS, 0.5f, 1f);
    }
    public void recheckOpen() {
        if (level == null || level.isClientSide() || isRemoved()) return;
        openers.recheckOpeners(level, worldPosition, getBlockState());
        if (openers.getOpenerCount() == 0 && getBlockState().getValue(SkyChestBlock.ANIMATION) == 1) level.setBlock(worldPosition, getBlockState().setValue(SkyChestBlock.ANIMATION, 2), 3);
    }
    @Override public void onLoad() {
        super.onLoad();
        if (level != null && !level.isClientSide()) level.scheduleTick(worldPosition, getBlockState().getBlock(), 5);
    }
    @Override public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<SkyChestBlockEntity>(this, "lid", 0, state -> {
            int animation = getBlockState().getValue(SkyChestBlock.ANIMATION);
            return state.setAndContinue(animation == 0 ? RawAnimation.begin().thenLoop("0") : RawAnimation.begin().thenPlayAndHold("" + animation));
        }));
    }
    @Override public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }
}
