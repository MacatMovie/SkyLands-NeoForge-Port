package net.deepcanion.skylands.block;

import net.deepcanion.skylands.registry.ModBlocks;
import net.deepcanion.skylands.registry.ModEffects;
import net.deepcanion.skylands.registry.ModItems;
import net.deepcanion.skylands.registry.ModParticles;
import net.deepcanion.skylands.registry.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;

/** A scheduled server-side freezing field; the inactive variant never schedules work. */
public final class StormBlock extends Block implements net.minecraft.world.level.block.EntityBlock {
    private final boolean active;
    public StormBlock(boolean active, Properties properties) { super(properties); this.active = active; }
    @Override public net.minecraft.world.level.block.entity.BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new net.deepcanion.skylands.block.entity.StormBlockEntity(pos, state);
    }
    @Override protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState old, boolean moved) {
        super.onPlace(state, level, pos, old, moved);
        if (active && !level.isClientSide() && !old.is(this)) level.scheduleTick(pos, this, 10);
    }
    @Override protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!active || !state.is(this)) return;
        AABB area = new AABB(pos.getX() - 6, pos.getY() - 6, pos.getZ() - 6,
                             pos.getX() + 6, pos.getY() + 6, pos.getZ() + 6);
        for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, area, entity -> entity.isAlive() && (!(entity instanceof Player player) || (!player.isCreative() && !player.isSpectator()))))
            entity.addEffect(new MobEffectInstance(ModEffects.FROZEN, 150, 1));
        if (random.nextFloat() < 0.3F) {
            level.sendParticles(ModParticles.CLOUD_BARRIER_2.get(), pos.getX(), pos.getY(), pos.getZ(), 1, 2, 2, 2, 0.03);
            level.playSound(null, pos, ModSounds.MECHANISM_STATIC.get(), SoundSource.BLOCKS, 0.6F, 1F);
            level.playSound(null, pos, ModSounds.POWERFUL_WIND.get(), SoundSource.BLOCKS, 0.8F, 1F);
        }
        level.scheduleTick(pos, this, 10);
    }
    @Override protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!active || !stack.is(ModItems.DIAMOND_LEVEL_1_KEY.get())) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        if (level.isClientSide()) return ItemInteractionResult.SUCCESS;
        if (!level.setBlock(pos, ModBlocks.DEACTIVATED_STORM_BLOCK.get().defaultBlockState(), 3)) return ItemInteractionResult.FAIL;
        if (!player.getAbilities().instabuild) stack.shrink(1);
        level.playSound(null, pos, ModSounds.MECHANISM_DEACTIVATION.get(), SoundSource.BLOCKS, 1F, 1F);
        return ItemInteractionResult.SUCCESS;
    }
    @Override protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (!active) return InteractionResult.PASS;
        ItemStack offhand = player.getOffhandItem();
        if (offhand.is(ModItems.DIAMOND_LEVEL_1_KEY.get())) {
            ItemInteractionResult result = useItemOn(offhand, state, level, pos, player, InteractionHand.OFF_HAND, hit);
            return result == ItemInteractionResult.FAIL ? InteractionResult.FAIL : InteractionResult.sidedSuccess(level.isClientSide());
        }
        if (!level.isClientSide()) player.displayClientMessage(net.minecraft.network.chat.Component.translatable("message.flying_stuff.storm_locked", ModItems.DIAMOND_LEVEL_1_KEY.get().getDescription()), true);
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}
