package net.deepcanion.skylands.item;

import java.util.function.Supplier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.deepcanion.skylands.registry.ModItems;

/** Original equipment stats; native drop tags replace the removed harvest level API. */
public record SkyToolTier(int uses, float speed, float bonus, int enchantment,
        Tier dropTier, Supplier<Ingredient> repair) implements Tier {
    public static final Tier SWORD = new SkyToolTier(3104, 2, 5, 20, Tiers.STONE,
            () -> Ingredient.of(ModItems.INGOT_OF_THE_SKY.get()));
    public static final Tier TOOL = new SkyToolTier(3104, 11, 2, 20, Tiers.NETHERITE, () -> Ingredient.EMPTY);
    public static final Tier INFUSED = new SkyToolTier(169, 2, 6, 21, Tiers.STONE, () -> Ingredient.EMPTY);
    public static final Tier PALE = new SkyToolTier(400, 1.65F, 6, 21, Tiers.STONE, () -> Ingredient.EMPTY);
    public static final Tier WAR_AXE = new SkyToolTier(250, 4, 2.5F, 8, Tiers.STONE,
            () -> Ingredient.of(ModItems.PALE_CELESTIUM.get()));
    public int getUses() { return uses; }
    public float getSpeed() { return speed; }
    public float getAttackDamageBonus() { return bonus; }
    public int getEnchantmentValue() { return enchantment; }
    public TagKey<Block> getIncorrectBlocksForDrops() { return dropTier.getIncorrectBlocksForDrops(); }
    public Ingredient getRepairIngredient() { return repair.get(); }
}
