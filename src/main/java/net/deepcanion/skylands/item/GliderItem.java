package net.deepcanion.skylands.item;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
public final class GliderItem extends Item {
    public GliderItem() { super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)); }
    public static int canvas(ItemStack stack) { return Math.clamp(stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getInt("canvas"), 0, 27); }
}
