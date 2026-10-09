package net.deepcanion.skylands.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

/** Shared localized tooltips and reusable crafting ingredients. */
public final class MaterialItem extends Item {
    private final String tooltipKey;
    private final boolean reusable;
    public MaterialItem(Properties properties, String tooltipKey, boolean reusable) {
        super(properties);
        this.tooltipKey = tooltipKey;
        this.reusable = reusable;
    }
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lines, TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);
        if (!tooltipKey.isEmpty()) {
            for (String line : Component.translatable(tooltipKey).getString().split("\n")) lines.add(Component.literal(line));
        }
    }
    @Override public boolean hasCraftingRemainingItem(ItemStack stack) { return reusable || super.hasCraftingRemainingItem(stack); }
    @Override public ItemStack getCraftingRemainingItem(ItemStack stack) { return reusable ? new ItemStack(this) : super.getCraftingRemainingItem(stack); }
}
