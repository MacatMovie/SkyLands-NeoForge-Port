package net.deepcanion.skylands.block.entity;
import java.util.ArrayList;
import java.util.List;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.block.*;
import net.deepcanion.skylands.registry.ModBlockEntities;
import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

/** The server holds deposits and committed rolls, including while chunks are unloaded. */
public final class RewardDispenserBlockEntity extends BlockEntity implements GeoBlockEntity {
    private int deposited;
    private long readyAt;
    private final List<ItemStack> pending = new ArrayList<>();
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public RewardDispenserBlockEntity(BlockPos pos, BlockState state) { super(ModBlockEntities.REWARD_DISPENSER.get(), pos, state); }
    public RewardDispenserKind kind() { return ((RewardDispenserBlock)getBlockState().getBlock()).kind; }
    public void showStatus(Player player) {
        player.displayClientMessage(pending.isEmpty()
            ? Component.translatable("message.flying_stuff.dispenser_needs", 32 - deposited, kind().currency.get().getDescription())
            : Component.translatable("message.flying_stuff.dispenser_busy"), true);
    }
    public void deposit(Player player, ItemStack stack) {
        if (level == null || level.isClientSide() || isRemoved() || !stack.is(kind().currency.get()) || stack.isEmpty()) return;
        if (!pending.isEmpty()) { showStatus(player); return; }
        List<Item> rewards = BuiltInRegistries.ITEM.getTag(kind().rewards)
            .map(tag -> tag.stream().map(holder -> holder.value()).filter(item -> item != Items.AIR).toList()).orElse(List.of());
        // A broken/overridden empty reward pool never consumes payment.
        if (rewards.isEmpty()) { player.displayClientMessage(Component.translatable("message.flying_stuff.dispenser_empty"), true); return; }
        int amount = Math.min(32 - deposited, stack.getCount());
        deposited += amount; stack.shrink(amount);
        if (deposited == 32) {
            int count = 2 + level.random.nextInt(5);
            for (int i = 0; i < count; i++) pending.add(new ItemStack(rewards.get(level.random.nextInt(rewards.size()))));
            deposited = 0; readyAt = level.getGameTime() + 43;
            level.scheduleTick(worldPosition, getBlockState().getBlock(), 43);
            stopTriggeredAnim("action", null);
            triggerAnim("action", "dispense");
            // Award when the payout is committed, so disconnecting during the delay does not lose credit.
            if (player instanceof ServerPlayer serverPlayer) {
                var advancement = serverPlayer.server.getAdvancements().get(SkyLands.id("gambling"));
                if (advancement != null) {
                    var progress = serverPlayer.getAdvancements().getOrStartProgress(advancement);
                    for (String criterion : progress.getRemainingCriteria()) serverPlayer.getAdvancements().award(advancement, criterion);
                }
            }
        } else { stopTriggeredAnim("action", null); triggerAnim("action", "insert"); showStatus(player); }
        setChanged();
    }
    public void finish() {
        if (level == null || level.isClientSide() || isRemoved() || pending.isEmpty()) return;
        if (level.getGameTime() < readyAt) { schedulePending(); return; }
        Direction facing = getBlockState().getValue(RewardDispenserBlock.FACING);
        while (!pending.isEmpty()) {
            ItemEntity reward = new ItemEntity(level, worldPosition.getX() + 0.5 + facing.getStepX() * 0.8,
                worldPosition.getY() + 0.6, worldPosition.getZ() + 0.5 + facing.getStepZ() * 0.8, pending.get(0).copy());
            reward.setPickUpDelay(5);
            if (!level.addFreshEntity(reward)) { schedulePending(); return; }
            pending.remove(0); setChanged();
        }
        readyAt = 0; setChanged();
    }
    private void schedulePending() {
        if (level != null && !level.isClientSide() && !pending.isEmpty()) level.scheduleTick(worldPosition, getBlockState().getBlock(), (int)Math.max(1, Math.min(43, readyAt - level.getGameTime())));
    }
    @Override public void onLoad() { super.onLoad(); schedulePending(); }
    public void dropStored() {
        if (level == null || level.isClientSide()) return;
        if (deposited > 0) Block.popResource(level, worldPosition, new ItemStack(kind().currency.get(), deposited));
        for (ItemStack stack : pending) Block.popResource(level, worldPosition, stack.copy());
        deposited = 0; pending.clear(); readyAt = 0; setChanged();
    }
    @Override protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        deposited = Math.max(0, Math.min(31, tag.getInt("Deposited"))); readyAt = tag.getLong("ReadyAt"); pending.clear();
        ListTag rewards = tag.getList("PendingRewards", Tag.TAG_COMPOUND);
        for (int i = 0; i < rewards.size(); i++) {
            ItemStack stack = ItemStack.parseOptional(registries, rewards.getCompound(i));
            if (!stack.isEmpty()) pending.add(stack);
        }
    }
    @Override protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("Deposited", deposited); tag.putLong("ReadyAt", readyAt);
        ListTag rewards = new ListTag();
        for (ItemStack stack : pending) rewards.add(stack.save(registries));
        tag.put("PendingRewards", rewards);
    }
    @Override public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<RewardDispenserBlockEntity>(this, "idle", 0, state -> state.setAndContinue(RawAnimation.begin().thenLoop("0"))));
        controllers.add(new AnimationController<RewardDispenserBlockEntity>(this, "action", 0, state -> PlayState.STOP)
            .triggerableAnim("insert", RawAnimation.begin().thenPlay("1"))
            .triggerableAnim("dispense", RawAnimation.begin().thenPlay("2")));
    }
    @Override public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }
}
