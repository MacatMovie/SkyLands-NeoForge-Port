package net.deepcanion.skylands.block;
import java.util.function.Supplier;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.registry.ModItems;
import net.minecraft.tags.TagKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
public enum RewardDispenserKind {
    GOLDEN("golden_reward_dispencer", ModItems.CELESTIUM, "textures/block/gambling_machine.png"),
    GLACIATED("glaciated_reward_dispenser", ModItems.AMBER_CELESTIUM, "textures/block/gambling_machine_ice.png"),
    LAVIC("lavic_reward_dispenser", ModItems.PALE_CELESTIUM, "textures/block/gambling_machine_lavic.png"),
    ARID("arid_reward_dispenser", ModItems.INKY_CELESTIUM, "textures/block/gambling_machine_arid.png");
    public final String id, texture;
    public final Supplier<? extends Item> currency;
    public final TagKey<Item> rewards;
    RewardDispenserKind(String id, Supplier<? extends Item> currency, String texture) {
        this.id = id; this.currency = currency; this.texture = texture;
        rewards = TagKey.create(Registries.ITEM, SkyLands.id(id + "_loots"));
    }
}
