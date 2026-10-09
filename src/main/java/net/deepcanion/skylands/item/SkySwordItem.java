package net.deepcanion.skylands.item;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
public final class SkySwordItem extends SwordItem {
    public SkySwordItem() {
        super(SkyToolTier.SWORD, new Item.Properties().fireResistant()
                .attributes(SwordItem.createAttributes(SkyToolTier.SWORD, 3, -2.35F)));
    }
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lines, TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);
        lines.add(Component.translatable("item.flying_stuff.sword_of_the_sky.tooltip"));
    }
}
