package net.deepcanion.skylands.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.registry.ModItems;
import net.deepcanion.skylands.registry.ModParticles;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.player.PlayerDestroyItemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/** Recover the base sword after native break handling has finished clearing its slot. */
public final class SkySwordRecovery {
    private static final TagKey<Item> RECOVERABLE = TagKey.create(Registries.ITEM, SkyLands.id("breaks_in_sword"));
    private static final Map<ServerPlayer, List<Return>> PENDING = new WeakHashMap<>();
    private record Return(InteractionHand hand, ItemStack sword) { }

    public static void broken(PlayerDestroyItemEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player) || event.getHand() == null
                || !event.getOriginal().is(RECOVERABLE)) return;
        ItemStack sword = new ItemStack(ModItems.SWORD_OF_THE_SKY.get());
        var enchantments = event.getOriginal().get(DataComponents.ENCHANTMENTS);
        if (enchantments != null) sword.set(DataComponents.ENCHANTMENTS, enchantments);
        PENDING.computeIfAbsent(player, ignored -> new ArrayList<>()).add(new Return(event.getHand(), sword));
        player.serverLevel().sendParticles(ModParticles.ITEM_BREAK.get(), player.getX(), player.getY(), player.getZ(), 6, 0.2, 0.2, 0.2, 0.1);
    }

    public static void tick(PlayerTickEvent.Post event) {
        if (event.getEntity() instanceof ServerPlayer player) deliver(player);
    }

    public static void logout(PlayerEvent.PlayerLoggedOutEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) deliver(player);
    }

    private static void deliver(ServerPlayer player) {
        List<Return> returns = PENDING.remove(player);
        if (returns == null) return;
        for (Return pending : returns) {
            if (player.getItemInHand(pending.hand()).isEmpty()) player.setItemInHand(pending.hand(), pending.sword());
            else if (!player.getInventory().add(pending.sword())) player.drop(pending.sword(), false);
        }
    }
    private SkySwordRecovery() { }
}
