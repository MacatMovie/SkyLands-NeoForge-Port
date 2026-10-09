package net.deepcanion.skylands.registry;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.block.SkyChestBlock;
import net.deepcanion.skylands.block.RewardDispenserBlock;
import net.deepcanion.skylands.block.entity.RewardDispenserBlockEntity;
import net.deepcanion.skylands.block.entity.SkyChestBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.capabilities.*;
import net.neoforged.neoforge.registries.*;
public final class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, SkyLands.MOD_ID);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SkyChestBlockEntity>> SKY_CHEST = TYPES.register("sky_chest", () -> BlockEntityType.Builder.of(SkyChestBlockEntity::new, ModBlocks.BLOCKS.getEntries().stream().map(h -> h.get()).filter(b -> b instanceof SkyChestBlock).toArray(Block[]::new)).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RewardDispenserBlockEntity>> REWARD_DISPENSER = TYPES.register("reward_dispenser", () -> BlockEntityType.Builder.of(RewardDispenserBlockEntity::new, ModBlocks.BLOCKS.getEntries().stream().map(h -> h.get()).filter(b -> b instanceof RewardDispenserBlock).toArray(Block[]::new)).build(null));
    public static void capabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SKY_CHEST.get(), (chest, side) -> chest.unlocked() ? chest.itemHandler : null);
    }
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<net.deepcanion.skylands.block.entity.StormBlockEntity>> STORM_BLOCK = TYPES.register("storm_block", () -> BlockEntityType.Builder.of(net.deepcanion.skylands.block.entity.StormBlockEntity::new, ModBlocks.STORM_BLOCK.get(), ModBlocks.DEACTIVATED_STORM_BLOCK.get()).build(null));
    private ModBlockEntities() { }
}
